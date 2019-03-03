package br.com.atech.flightsapi.flight;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import br.com.atech.flightsapi.aircraft.AircraftProjection;
import br.com.atech.flightsapi.pilot.PilotProjection;

@Projection(name = "flight", 
			types = { Flight.class })
public interface FlightProjection {

	Long getId();

	String getStatus();

	Date getDepartureDate();
	
	Date getArrivalDate();

	String getFlightCode();

	String getDepartureAirport();
	
	String getarrivalAirport();

	AircraftProjection getAircraft();

	PilotProjection getPilot();

}
