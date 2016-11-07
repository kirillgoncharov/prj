import com.netcracker.devcourses.sd4.persistence.api.dao.AirportRepository;
import com.netcracker.devcourses.sd4.persistence.api.dao.FlightRepository;
import com.netcracker.devcourses.sd4.persistence.configuration.PersistenceConfiguration;
import com.netcracker.devcourses.sd4.persistence.domain.Flight;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by Konstantin on 25.10.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfiguration.class)
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Test
    public void testFindAll() {
        Assert.assertTrue(flightRepository.findAll().size() > 0);
    }

    @Test
    public void testFindByAirportName() {
        Assert.assertTrue(flightRepository.findByArrivalAirportName("LaGuardia Airport").size() > 0);
    }

    @Test
    public void testFindBetweenDates() {
        LocalDate from = LocalDate.of(2016, 5, 22);
        LocalDate to = LocalDate.of(2016, 10, 20);
        List<Flight> flights = flightRepository.findByArrivalTimeBetween(
                Date.from(from.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                        Date.from(to.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));

        Assert.assertTrue(flights.size() > 0);
    }
}
