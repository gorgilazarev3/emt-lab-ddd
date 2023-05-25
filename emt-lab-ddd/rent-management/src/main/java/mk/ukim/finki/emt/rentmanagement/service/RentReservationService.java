package mk.ukim.finki.emt.rentmanagement.service;

import mk.ukim.finki.emt.rentmanagement.domain.exceptions.ExtraFeatureIdNotExistException;
import mk.ukim.finki.emt.rentmanagement.domain.exceptions.ReservationDayIdNotExistException;
import mk.ukim.finki.emt.rentmanagement.domain.exceptions.ReservationIdNotExistException;
import mk.ukim.finki.emt.rentmanagement.domain.models.ExtraFeatureId;
import mk.ukim.finki.emt.rentmanagement.domain.models.RentReservation;
import mk.ukim.finki.emt.rentmanagement.domain.models.RentReservationDayId;
import mk.ukim.finki.emt.rentmanagement.domain.models.RentReservationId;
import mk.ukim.finki.emt.rentmanagement.service.forms.ExtraFeatureForm;
import mk.ukim.finki.emt.rentmanagement.service.forms.RentReservationDayForm;
import mk.ukim.finki.emt.rentmanagement.service.forms.RentReservationForm;

import java.util.List;
import java.util.Optional;

public interface RentReservationService {

    RentReservationId scheduleRentReservation(RentReservationForm rentReservationForm);
    List<RentReservation> findAll();
    Optional<RentReservation> findById(RentReservationId id);
    void addReservationDay(RentReservationId rentReservationId, RentReservationDayForm rentReservationDayForm) throws ReservationIdNotExistException, ReservationDayIdNotExistException;
    void cancelReservationDay(RentReservationId rentReservationId, RentReservationDayId rentReservationDayId) throws ReservationIdNotExistException, ReservationDayIdNotExistException;
    void addExtraFeatureToReservationDay(RentReservationId rentReservationId, RentReservationDayId rentReservationDayId, ExtraFeatureForm extraFeatureForm) throws ReservationIdNotExistException, ReservationDayIdNotExistException;
    void removeExtraFeatureFromReservationDay(RentReservationId rentReservationId, RentReservationDayId rentReservationDayId, ExtraFeatureId extraFeatureId) throws ReservationIdNotExistException, ReservationDayIdNotExistException, ExtraFeatureIdNotExistException;
}
