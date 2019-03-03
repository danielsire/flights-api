package br.com.atech.flightsapi.flight;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(excerptProjection = FlightProjection.class)
public interface FlightRepository extends PagingAndSortingRepository<Flight, Long> {

	@RestResource(path = "by-flight-code", 
				  rel = "by-flight-code")
	Page<Flight> findByFlightCodeContaining(@Param("flightCode") 
									        String flightCode, 
									        Pageable p);
	
}
