package test.airplane.tracking.api;

import airplane.tracking.api.db.domain.airplane.Airplane;
import airplane.tracking.api.db.repository.AirplaneRepository;
import airplane.tracking.api.server.service.airplane.RealAirplaneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RealAirplaneServiceTest {

    @InjectMocks
    RealAirplaneService airplaneService;

    @Mock
    AirplaneRepository airplaneRepository;

    @Test
    public void getAllAirplanesTest(){
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(Airplane.builder().id(1L).productionLine("Boeing 737 Classic").registrationNumber("YR-BAC").build());
        airplanes.add(Airplane.builder().id(2L).productionLine("Airbus A380-800").registrationNumber("A6-EOT").build());

        when(airplaneRepository.findAll()).thenReturn(airplanes);
        List<Airplane> airplaneList = airplaneService.getAll();

        assertEquals(2, airplaneList.size());
        verify(airplaneRepository, times(1)).findAll();
    }

    @Test
    public void getAllAirplanesWithPlaceTest(){
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(Airplane.builder().id(1L).productionLine("Boeing 737 Classic").registrationNumber("YR-BAC").place("Minsk").build());
        airplanes.add(Airplane.builder().id(2L).productionLine("Airbus A380-800").registrationNumber("A6-EOT").place("Minsk").build());

        when(airplaneRepository.findAll()).thenReturn(airplanes);
        List<Airplane> airplaneList = airplaneService.getAll();

        assertEquals(2, airplaneList.size());
        verify(airplaneRepository, times(1)).findAll();
    }

    @Test
    public void getAirplaneByIdWithPlace(){
        when(airplaneRepository.findById(1L)).thenReturn(
                Optional.ofNullable(Airplane.builder().id(1L).productionLine("Boeing 737 Classic").registrationNumber("YR-BAC").place("Minsk").build()));

        Airplane airplane = airplaneService.getById(1L).isPresent() ? airplaneService.getById(1L).get() : new Airplane();

        assertEquals(Long.valueOf(1L), airplane.getId());
        assertEquals("Boeing 737 Classic", airplane.getProductionLine());
        assertEquals("YR-BAC", airplane.getRegistrationNumber());
        assertEquals("Minsk", airplane.getPlace());
    }

    @Test
    public void getAirplaneById(){
        when(airplaneRepository.findById(1L)).thenReturn(
                Optional.ofNullable(Airplane.builder().id(1L).productionLine("Boeing 737 Classic").registrationNumber("YR-BAC").build()));

        Airplane airplane = airplaneService.getById(1L).isPresent() ? airplaneService.getById(1L).get() : new Airplane();

        assertEquals(Long.valueOf(1L), airplane.getId());
        assertEquals("Boeing 737 Classic", airplane.getProductionLine());
        assertEquals("YR-BAC", airplane.getRegistrationNumber());
        assertNull(airplane.getPlace());
    }
}
