package test.airplane.tracking.api;

import airplane.tracking.api.db.domain.Airport;
import airplane.tracking.api.db.domain.airplane.AirplaneInAirport;
import airplane.tracking.api.db.repository.AirportRepository;
import airplane.tracking.api.db.repository.StoredProcedureRepository;
import airplane.tracking.api.server.service.airport.RealAirportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RealAirportServiceTest {

    @InjectMocks
    RealAirportService airportService;

    @Mock
    AirportRepository airportRepository;
    @Mock
    StoredProcedureRepository storedProcedureRepository;

    @Test
    public void getAllAirportsTest(){
        List<Airport> airports = new ArrayList<>();
        airports.add(Airport.builder().id(1L).iataCode("JND55DS").airportName("Minsk").build());
        airports.add(Airport.builder().id(2L).iataCode("JND475DS").airportName("Moscow").build());

        when(airportRepository.findAll()).thenReturn(airports);
        List<Airport> airportList = airportService.getAll();

        assertEquals(2, airportList.size());
        verify(airportRepository, times(1)).findAll();
    }

    @Test
    public void getAirportByIdTest(){
        when(airportRepository.findById(1L)).thenReturn(
                Optional.ofNullable(Airport.builder().id(1L).iataCode("JND55DS").airportName("Minsk").build()));

        Airport airport = airportService.getById(1L).isPresent() ? airportService.getById(1L).get() : new Airport();

        assertEquals(Long.valueOf(1L), airport.getId());
        assertEquals("JND55DS", airport.getIataCode());
        assertEquals("Minsk", airport.getAirportName());
    }

    @Test
    public void getAirplanesInformationByIdTest(){
        List<AirplaneInAirport> airplanesWithPlace = new ArrayList<>();
        airplanesWithPlace.add(new AirplaneInAirport(220L, "Airbus A380-800", "A6-EOT", "arrives"));

        when(storedProcedureRepository.getAirplanesInformationById(1L)).thenReturn(airplanesWithPlace);

        List<AirplaneInAirport> airplaneInAirport = airportService.getAirplanesInformationById(1L);
        assertEquals(1, airplaneInAirport.size());
        verify(storedProcedureRepository, times(1)).getAirplanesInformationById(1L);
    }

}
