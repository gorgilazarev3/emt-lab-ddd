package mk.ukim.finki.emt.rentmanagement.xport.events;

import lombok.AllArgsConstructor;
import mk.finki.ukim.emt.sharedkernel.domain.config.TopicHolder;
import mk.finki.ukim.emt.sharedkernel.domain.events.DomainEvent;
import mk.finki.ukim.emt.sharedkernel.domain.events.rentreservations.RentReservationDayCancelled;
import mk.finki.ukim.emt.sharedkernel.domain.events.rentreservations.RentReservationDayScheduled;
import mk.ukim.finki.emt.rentmanagement.domain.models.RentReservationDayId;
import mk.ukim.finki.emt.rentmanagement.domain.models.RentReservationId;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.Vehicle;
import mk.ukim.finki.emt.rentmanagement.service.RentReservationService;
import mk.ukim.finki.emt.rentmanagement.service.forms.RentReservationDayForm;
import mk.ukim.finki.emt.rentmanagement.xport.client.VehicleClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentReservationDayEventListener {

    private final RentReservationService rentReservationService;
    private final VehicleClient vehicleClient;

    @KafkaListener(topics= TopicHolder.TOPIC_RENT_RESERVATION_DAY_SCHEDULED, groupId = "rentManagement")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            RentReservationDayScheduled event = DomainEvent.fromJson(jsonMessage,RentReservationDayScheduled.class);
            RentReservationDayForm form = new RentReservationDayForm();
            Vehicle vehicle = vehicleClient.findById(event.getVehicleId());
            form.setVehicle(vehicle);
            form.setPricePerDay(event.getPricePerDay());
            form.setRentReservationDayDate(event.getRentReservationDayDate());
            rentReservationService.addReservationDay(RentReservationId.of(event.getRentReservationId()),form);
        } catch (Exception e){

        }

    }

    @KafkaListener(topics= TopicHolder.TOPIC_RENT_RESERVATION_DAY_CANCELLED, groupId = "rentManagement")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            RentReservationDayCancelled event = DomainEvent.fromJson(jsonMessage,RentReservationDayCancelled.class);
            rentReservationService.cancelReservationDay(RentReservationId.of(event.getRentReservationId()),RentReservationDayId.of(event.getRentReservationDayId()));
        } catch (Exception e){

        }

    }
}

