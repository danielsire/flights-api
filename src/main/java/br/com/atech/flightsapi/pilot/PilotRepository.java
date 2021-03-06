package br.com.atech.flightsapi.pilot;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface PilotRepository extends PagingAndSortingRepository<Pilot, Long> {

	Pilot findByName(@Param("name") String name);
	
}