package br.com.atech.flightsapi.pilot;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import br.com.atech.flightsapi.flight.Flight;

@Projection(name = "pilot", 
			types = { Pilot.class })
public interface PilotProjection {
	
	Long getId();
	
	String getName();
	
	List<Flight> getFlights();
}
