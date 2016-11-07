import com.netcracker.devcourses.sd4.persistence.api.dao.CountryDao;
import com.netcracker.devcourses.sd4.persistence.configuration.PersistenceConfiguration;
import com.netcracker.devcourses.sd4.persistence.domain.Airport;
import com.netcracker.devcourses.sd4.persistence.domain.City;
import com.netcracker.devcourses.sd4.persistence.domain.Country;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Set;

/**
 * Created by Konstantin on 21.10.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfiguration.class)
@Transactional
public class CountryDaoTest {

    @Autowired
    private CountryDao countryDao;

    @Before
    public void setUp() {
        countryDao.addCountry(new Country("Belarus"));
    }

    @Test
    public void testGetBy() {
        Country canada = countryDao.getCountry("Canada");
        Assert.assertNotNull(canada);
    }

    @Test
    public void testGetAll() {
        List<Country> allEntities = countryDao.getAllEntities(Country.class);
        Assert.assertTrue(allEntities.size() > 0);
    }

    @Test
    public void testGetSingle() {
        Country entity = countryDao.getEntity(Country.class, 3);
        Assert.assertNotNull(entity);
    }

    @Test
    public void testAddCountry() {
        countryDao.addCountry(new Country("TestCountry"));
        Assert.assertNotNull(countryDao.getCountry("TestCountry"));
    }

    @Test(expected = NoResultException.class)
    public void testDeleteCountry() {
        Country belarus = countryDao.getCountry("Belarus");
        countryDao.deleteCountry(belarus);
        countryDao.getCountry("Belarus");
    }

    @Test
    public void testUpdateCountry() {
        Country belarus = countryDao.getCountry("Belarus");
        belarus.setName("Belarus!");
        countryDao.updateCountry(belarus);
        Assert.assertNotNull(countryDao.getCountry("Belarus!"));
    }

    @Test
    public void testGetDeepData() {
        Country usa = countryDao.getCountry("United States");
        Set<City> cities = usa.getCities();
        Assert.assertTrue(cities.size() > 0);
        City city = cities.iterator().next();
        Assert.assertNotNull(city);
        Set<Airport> airports = city.getAirports();
        Assert.assertTrue(airports.size() > 0);
        Airport airport = airports.iterator().next();
        String airportName = airport.getName();
        Assert.assertNotNull(airportName);
        System.out.println(airportName);
    }
}
