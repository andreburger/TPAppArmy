package ac.za.cput.andre.service;

import ac.za.cput.andre.App;
import ac.za.cput.andre.domain.Protoss;
import ac.za.cput.andre.domain.Race;
import ac.za.cput.andre.domain.Unit;
import ac.za.cput.andre.factory.RaceSelector;
import ac.za.cput.andre.repository.ProtossRepository;
import ac.za.cput.andre.repository.TerranRepository;
import ac.za.cput.andre.services.ProtossService;
import ac.za.cput.andre.services.TerranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/23.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ProtossServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ProtossService service;

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

    @Test
    public void testGetProtoss() throws Exception {
        List<Protoss> army = service.getProtoss();
        int size = army.size()-1;
        Assert.assertEquals(army.get(size).getArmyName(),"Protoss");

    }
}
