package mk.ukim.finki.emt.rentmanagement.service.impl;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import mk.finki.ukim.emt.sharedkernel.domain.events.rentreservations.RentReservationDayCancelled;
import mk.finki.ukim.emt.sharedkernel.domain.events.rentreservations.RentReservationDayScheduled;
import mk.finki.ukim.emt.sharedkernel.infra.DomainEventPublisher;
import mk.ukim.finki.emt.rentmanagement.domain.exceptions.ExtraFeatureIdNotExistException;
import mk.ukim.finki.emt.rentmanagement.domain.exceptions.ReservationDayIdNotExistException;
import mk.ukim.finki.emt.rentmanagement.domain.exceptions.ReservationIdNotExistException;
import mk.ukim.finki.emt.rentmanagement.domain.models.*;
import mk.ukim.finki.emt.rentmanagement.domain.repository.RentReservationRepository;
import mk.ukim.finki.emt.rentmanagement.service.RentReservationService;
import mk.ukim.finki.emt.rentmanagement.service.forms.ExtraFeatureForm;
import mk.ukim.finki.emt.rentmanagement.service.forms.RentReservationDayForm;
import mk.ukim.finki.emt.rentmanagement.service.forms.RentReservationForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RentReservationServiceImpl implements RentReservationService {

    private final RentReservationRepository rentReservationRepository;
    private final Validator validator;
    private final DomainEventPublisher domainEventPublisher;

    @Override
    public RentReservationId scheduleRentReservation(RentReservationForm rentReservationForm) {
        Objects.requireNonNull(rentReservationForm, "rent reservation must not be null");
        var constraintViolations = validator.validate(rentReservationForm);
        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The rent reservation form is not valid",constraintViolations);
        }
        var newRentReservation = rentReservationRepository.saveAndFlush(toRentReservationDomainObject(rentReservationForm));
        newRentReservation.getReservationDays().forEach(rd -> domainEventPublisher.publish(new RentReservationDayScheduled(newRentReservation.getId().getId(), rd.getVehicleId().getId(), rd.getPricePerDay(), rd.getReservationDayDate())));
        return newRentReservation.getId();
    }

    @Override
    public List<RentReservation> findAll() {
        return rentReservationRepository.findAll();
    }

    @Override
    public Optional<RentReservation> findById(RentReservationId id) {
        return rentReservationRepository.findById(id);
    }

    @Override
    public void addReservationDay(RentReservationId rentReservationId, RentReservationDayForm rentReservationDayForm) throws ReservationIdNotExistException, ReservationDayIdNotExistException {
        RentReservation rentReservation = rentReservationRepository.findById(rentReservationId).orElseThrow(ReservationIdNotExistException::new);
        rentReservation.addReservationDayForRent(rentReservationDayForm.getVehicle(), rentReservationDayForm.getPricePerDay(), rentReservationDayForm.getRentReservationDayDate());
        rentReservationRepository.saveAndFlush(rentReservation);
        domainEventPublisher.publish(new RentReservationDayScheduled(rentReservationId.getId(), rentReservationDayForm.getVehicle().getId().getId(), rentReservationDayForm.getPricePerDay(), rentReservationDayForm.getRentReservationDayDate()));
    }

    @Override
    public void cancelReservationDay(RentReservationId rentReservationId, RentReservationDayId rentReservationDayId) throws ReservationIdNotExistException, ReservationDayIdNotExistException {
        RentReservation rentReservation = rentReservationRepository.findById(rentReservationId).orElseThrow(ReservationIdNotExistException::new);
        rentReservation.cancelReservationDayForRent(rentReservationDayId);
        rentReservationRepository.saveAndFlush(rentReservation);
        domainEventPublisher.publish(new RentReservationDayCancelled(rentReservationId.getId(),rentReservationDayId.getId()));
    }

    @Override
    public void addExtraFeatureToReservationDay(RentReservationId rentReservationId, RentReservationDayId rentReservationDayId, ExtraFeatureForm extraFeatureForm) throws ReservationDayIdNotExistException {
        RentReservation rentReservation = rentReservationRepository.findById(rentReservationId).orElseThrow(ReservationIdNotExistException::new);
        RentReservationDay rentReservationDay = rentReservation.getRentReservationDayById(rentReservationDayId);
        rentReservationDay.addExtraFeatureOnDay(extraFeatureForm.getExtraFeatureDescription(), extraFeatureForm.getPriceForFeaturePerDay());
        rentReservationRepository.saveAndFlush(rentReservation);
    }

    @Override
    public void removeExtraFeatureFromReservationDay(RentReservationId rentReservationId, RentReservationDayId rentReservationDayId, ExtraFeatureId extraFeatureId) throws ReservationDayIdNotExistException, ExtraFeatureIdNotExistException {
        RentReservation rentReservation = rentReservationRepository.findById(rentReservationId).orElseThrow(ReservationIdNotExistException::new);
        RentReservationDay rentReservationDay = rentReservation.getRentReservationDayById(rentReservationDayId);
        rentReservationDay.removeExtraFeatureOnDay(extraFeatureId);
        rentReservationRepository.saveAndFlush(rentReservation);
    }

    private RentReservation toRentReservationDomainObject(RentReservationForm rentReservationForm) {
        var rentReservation = new RentReservation(rentReservationForm.getUserId(),rentReservationForm.getReservationStartDate(),rentReservationForm.getReservationEndDate(),rentReservationForm.getPickupLocation(),rentReservationForm.getDropOffLocation(),rentReservationForm.getCurrency());
        rentReservationForm.getRentReservationDaysList().forEach(rrd -> rentReservation.addReservationDayForRent(rrd.getVehicle(),rrd.getPricePerDay(),rrd.getRentReservationDayDate()));
        return rentReservation;
    }

    private ExtraFeature toExtraFeatureDomainObject(ExtraFeatureForm extraFeatureForm) {
        return new ExtraFeature(extraFeatureForm.getExtraFeatureDescription(), extraFeatureForm.getPriceForFeaturePerDay());
    }
}
