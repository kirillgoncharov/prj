import com.netcracker.devcourses.sd4.persistence.api.dao.AirportRepository;
import com.netcracker.devcourses.sd4.persistence.configuration.PersistenceConfiguration;
import com.netcracker.devcourses.sd4.persistence.domain.Airport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Konstantin on 25.10.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfiguration.class)
public class AirportRepositoryTest {

    @Autowired
    private AirportRepository airportRepository;

    @Test
    public void testGetOne() {
        Assert.assertNotNull(airportRepository.findOne(3));
    }

    @Test
    public void testGetAll() {
        List<Airport> airports = (List<Airport>) airportRepository.findAll();
        Assert.assertTrue(airports.size() > 0);
    }

    @Test
    public void testAdd() {
        airportRepository.save(new Airport("Test"));
        List<Airport> airports = (List<Airport>) airportRepository.findAll();
        Assert.assertTrue(airports.stream().anyMatch((airport) -> airport.getName().equals("Test")));
    }

    @Test
    public void testDelete() {
        airportRepository.delete(new Airport("Test"));
        List<Airport> airports = (List<Airport>) airportRepository.findAll();
        Assert.assertTrue(airports.stream().anyMatch((airport) -> airport.getName().equals("Test")));
    }
}
