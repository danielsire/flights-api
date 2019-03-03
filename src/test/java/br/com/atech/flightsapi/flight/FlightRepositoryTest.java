package br.com.atech.flightsapi.flight;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.atech.flightsapi.aircraft.Aircraft;
import br.com.atech.flightsapi.aircraft.AircraftRepository;
import br.com.atech.flightsapi.pilot.Pilot;
import br.com.atech.flightsapi.pilot.PilotRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("tests")
public class FlightRepositoryTest {

	@Autowired
	private PilotRepository pilotRepo;
	
	@Autowired
	private AircraftRepository acftRepo;
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Before
	public void init() {
		flightRepo.deleteAll();
		acftRepo.deleteAll();
		pilotRepo.deleteAll();
		
		pilotRepo.save(new Pilot("Jose"));
		
		Pilot pilot = pilotRepo.findByName("Jose");
		
		acftRepo.save(new Aircraft("222222", "PW-ERT", "Teco-TecoII"));
		
		Aircraft aircraft = acftRepo.findOne("222222");
		
		
		flightRepo.save(new Flight("weeqrf", Status.ARRIVED, new Date(1537758000000l), new Date(1537844400000l), "GRU", "BHZ", aircraft, pilot));
		flightRepo.save(new Flight("sszhhs", Status.SCHEDULED, new Date(1537758000000l), new Date(1537844400000l), "GRU", "BHZ", aircraft, pilot));
		flightRepo.save(new Flight("qstdre", Status.DELAYED, new Date(1537758000000l), new Date(1537844400000l), "GRU", "BHZ", aircraft, pilot));
	}
	
	@Test
    public void findOne() {
		Flight flight = flightRepo.findOne(1L);
        Assert.assertEquals("weeqrf", flight.getFlightCode());
    }
	
	@Test
    public void list() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Flight> flights = flightRepo.findAll(pageable);
        Assert.assertEquals(3, flights.getTotalElements());
    }
	
	@Test
    public void findByFlightCodeContaining() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Flight> flights = flightRepo.findByFlightCodeContaining("qs", pageable);
        Assert.assertEquals(1, flights.getTotalElements());
        Assert.assertEquals("qstdre", flights.iterator().next().getFlightCode());
    }
	
}
