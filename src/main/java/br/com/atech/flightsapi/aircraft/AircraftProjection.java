package br.com.atech.flightsapi.aircraft;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "aircraft", 
			types = { Aircraft.class })
public interface AircraftProjection {

	String getSerialNumber();
	
	String getTailNumber();

    String getModel();	
}
