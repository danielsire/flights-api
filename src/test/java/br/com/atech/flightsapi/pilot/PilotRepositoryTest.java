package br.com.atech.flightsapi.pilot;

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
public class PilotRepositoryTest {

	@Autowired
	private PilotRepository repository;
	
	@Before
	public void init() {
		repository.deleteAll();
		
		repository.save(new Pilot("Joe"));
		repository.save(new Pilot("Pete"));
		repository.save(new Pilot("Jose"));
	}
	
	@Test
    public void findOne() {
		Pilot pilot = repository.findOne(2l);
        Assert.assertEquals("Pete", pilot.getName());
    }
	
	@Test
    public void findByName() {
		Pilot pilot = repository.findByName("Joe");
        Assert.assertNotNull(pilot);
    }
	
	@Test
    public void list() {
		Pageable pageable = new PageRequest(0, 10);
		Page<Pilot> pilots = repository.findAll(pageable);
        Assert.assertEquals(3, pilots.getTotalElements());
    }
	
}
