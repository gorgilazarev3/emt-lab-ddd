package mk.ukim.finki.emt.rentmanagement.service;

import mk.finki.ukim.emt.sharedkernel.domain.financial.Currency;
import mk.finki.ukim.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rentmanagement.domain.exceptions.ReservationIdNotExistException;
import mk.ukim.finki.emt.rentmanagement.domain.models.RentReservation;
import mk.ukim.finki.emt.rentmanagement.domain.models.RentReservationId;
import mk.ukim.finki.emt.rentmanagement.domain.valueobjects.*;
import mk.ukim.finki.emt.rentmanagement.service.forms.RentReservationDayForm;
import mk.ukim.finki.emt.rentmanagement.service.forms.RentReservationForm;
import mk.ukim.finki.emt.rentmanagement.xport.client.VehicleClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RentReservationServiceTest {

    @Autowired
    private RentReservationService rentReservationService;
    @Autowired
    private VehicleClient vehicleClient;

    @Test
    public void testSchedulingReservation() {
        RentReservationDayForm form1 = new RentReservationDayForm();
        form1.setVehicle(new Vehicle(VehicleId.randomId(VehicleId.class), new VehicleModel(2018,"E63s"),5,BrandId.randomId(BrandId.class), VehicleClass.LUXURY, VehicleType.SEDAN, new Fuel(50,new Consumption(15.2))));
        form1.setPricePerDay(Money.valueOf(Currency.EUR,400));
        form1.setRentReservationDayDate(LocalDate.now());

        RentReservationDayForm form2 = new RentReservationDayForm();
        form2.setVehicle(new Vehicle(VehicleId.randomId(VehicleId.class), new VehicleModel(2018,"E63s"),5,BrandId.randomId(BrandId.class), VehicleClass.LUXURY, VehicleType.SEDAN, new Fuel(50,new Consumption(15.2))));
        form2.setPricePerDay(Money.valueOf(Currency.EUR,400));
        form2.setRentReservationDayDate(LocalDate.now());

        RentReservationForm form = new RentReservationForm();
        form.setCurrency(Currency.EUR);
        form.setUserId(UserId.randomId(UserId.class));
        form.setReservationStartDate(LocalDate.now());
        form.setReservationEndDate(LocalDate.now());
        form.setPickupLocation(new Location("Test",12.1,13.1));
        form.setDropOffLocation(new Location("Test",12.1,13.1));

        form.setRentReservationDaysList(Arrays.asList(form1,form2));

        RentReservationId id = rentReservationService.scheduleRentReservation(form);
        RentReservation rr = rentReservationService.findById(id).orElseThrow(ReservationIdNotExistException::new);

        Assertions.assertEquals(Money.valueOf(Currency.EUR, 800),rr.totalPrice());
    }

    @Test
    public void testVehicleListWithRealData() {
        List<Vehicle> vehicleList = vehicleClient.findAll();
        System.out.println(vehicleList);
    }

    @Test
    public void testRentReservationScheduledWithRealData() {
        RentReservationDayForm form1 = new RentReservationDayForm();
        List<Vehicle> vehicleList = vehicleClient.findAll();
        Vehicle vehicle1 = vehicleList.get(0);
        Vehicle vehicle2 = vehicleList.get(1);
        form1.setVehicle(vehicle1);
        form1.setPricePerDay(Money.valueOf(Currency.EUR,400));
        form1.setRentReservationDayDate(LocalDate.now());

        RentReservationDayForm form2 = new RentReservationDayForm();
        form2.setVehicle(vehicle2);
        form2.setPricePerDay(Money.valueOf(Currency.EUR,400));
        form2.setRentReservationDayDate(LocalDate.now());

        RentReservationForm form = new RentReservationForm();
        form.setCurrency(Currency.EUR);
        form.setUserId(UserId.randomId(UserId.class));
        form.setReservationStartDate(LocalDate.now());
        form.setReservationEndDate(LocalDate.now());
        form.setPickupLocation(new Location("Test",12.1,13.1));
        form.setDropOffLocation(new Location("Test",12.1,13.1));

        form.setRentReservationDaysList(Arrays.asList(form1,form2));

        RentReservationId id = rentReservationService.scheduleRentReservation(form);
        RentReservation rr = rentReservationService.findById(id).orElseThrow(ReservationIdNotExistException::new);

        Assertions.assertEquals(Money.valueOf(Currency.EUR, 800),rr.totalPrice());
    }


}
