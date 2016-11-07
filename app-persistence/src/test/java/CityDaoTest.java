import com.netcracker.devcourses.sd4.persistence.api.dao.CityDao;
import com.netcracker.devcourses.sd4.persistence.configuration.PersistenceConfiguration;
import com.netcracker.devcourses.sd4.persistence.domain.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Konstantin on 24.10.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfiguration.class)
public class CityDaoTest {

    @Autowired
    private CityDao cityDao;

    @Test
    public void testGetBy() {
        City chicago = cityDao.getCity("Chicago");
        Assert.assertNotNull(chicago);
    }

    @Test
    public void testGetAllEntitiesByNamedQuery() {
        List<City> cities = cityDao.getAllEntities(City.class);
        Assert.assertTrue(cities.size() > 0);
    }

    @Transactional
    @Test
    public void testGetCityByAirportName() {
        City city = cityDao.getCityByAirportName("Los Angeles International Airport");
        Assert.assertNotNull(city);
        Assert.assertEquals(city.getName(), "Los Angeles");
    }
}
