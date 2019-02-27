package br.com.atech.flightsapi.flight;

import lombok.Getter;

@Getter
public enum Status {
	
	SCHEDULED,
    DELAYED,
    DEPARTED,
    ARRIVED,
    CANCELLED
}
