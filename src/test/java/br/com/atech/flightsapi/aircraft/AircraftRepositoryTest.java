package br.com.atech.flightsapi.aircraft;

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


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("tests")
public class AircraftRepositoryTest {

	@Autowired
	private AircraftRepository repository;
	
	@Before
	public void init() {
		repository.deleteAll();
		
		repository.save(new Aircraft("666666", "PQ-TVT", "Teco-Teco"));
		repository.save(new Aircraft("222222", "PW-ERT", "Teco-TecoII"));
	}
	
	@Test
    public void findOne() {
		Aircraft aircraft = repository.findOne("666666");
        Assert.assertEquals("PQ-TVT", aircraft.getTailNumber());
    }
	
	@Test
    public void list() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Aircraft> aircrafts = repository.findAll(pageable);
        Assert.assertEquals(2, aircrafts.getTotalElements());
    }
	
}
