package ac.za.cput.andre.repository;

import ac.za.cput.andre.App;
import ac.za.cput.andre.domain.Protoss;
import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Unit;
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
public class ProtossCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    @Autowired
    private ProtossRepository repository;

    @Test
    public void create() throws Exception {
        ArrayList<Unit> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race protoss = race.getRace("Protoss");
        Unit unit1 = protoss.addUnit("Zealot");
        Unit unit2 = protoss.addUnit("Colossus");

        army.add(unit1);
        army.add(unit2);


        int popcap = 0;
        for(int i = 0;i<army.size();i++)
        {
            popcap = popcap + army.get(i).popcap();
        }
        protoss.setArmyName("Protoss");
        protoss.setArmyPop(popcap);
        repository.save((Protoss)protoss);
        id=protoss.getID();
        Assert.assertNotNull(protoss);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Race terran = repository.findOne(id);
        Assert.assertNotNull(terran);

    }

    @Test(dependsOnMethods = "read")
    public void delete() throws Exception {
        Race protoss = repository.findOne(id);
        repository.delete((Protoss)protoss);
        Race deletedProtoss = repository.findOne(id);
        Assert.assertNull(deletedProtoss);
    }

}
