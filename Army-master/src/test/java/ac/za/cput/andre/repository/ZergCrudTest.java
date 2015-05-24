package ac.za.cput.andre.repository;

import ac.za.cput.andre.App;
import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Unit;
import ac.za.cput.andre.domain.Zerg;
import ac.za.cput.andre.factory.RaceSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by student on 2015/05/20.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ZergCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private ZergRepository repository;

    @Test
    public void create() throws Exception {
        ArrayList<Unit> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race zerg = race.getRace("Zerg");
        Unit unit1 = zerg.addUnit("Zergling");
        Unit unit2 = zerg.addUnit("Hydralisk");

        army.add(unit1);
        army.add(unit2);


        int popcap = 0;
        for(int i = 0;i<army.size();i++)
        {
            popcap = popcap + army.get(i).popcap();
        }
        zerg.setArmyName("Zerg");
        zerg.setArmyPop(popcap);
        repository.save((Zerg)zerg);
        id=zerg.getID();
        Assert.assertNotNull(zerg);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Race terran = repository.findOne(id);
        Assert.assertNotNull(terran);

    }

    @Test(dependsOnMethods = "read")
    public void delete() throws Exception {
        Race zerg = repository.findOne(id);
        repository.delete((Zerg)zerg);
        Race deletedZerg = repository.findOne(id);
        Assert.assertNull(deletedZerg);
    }

}