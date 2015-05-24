package ac.za.cput.andre.domain;

import ac.za.cput.andre.factory.RaceSelector;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by student on 2015/04/26.
 */
public class domainTest {
    @Before
    public void setUp() throws Exception {}

    @Test
    public void testCreateAmyTerran() throws Exception
    {
        ArrayList<Unit> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race terran = race.getRace("Terran");
        Unit unit1 = terran.addUnit("Marine");
        Unit unit2 = terran.addUnit("Thor");

        army.add(unit1);
        army.add(unit2);


        Assert.assertEquals(army.get(0).name(),"Marine");
        Assert.assertEquals(army.get(1).name(),"Thor");
    }

    @Test
    public void testCreateAmyProtoss() throws Exception
    {
        ArrayList<Unit> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race protoss = race.getRace("Protoss");
        Unit unit1 = protoss.addUnit("Zealot");
        Unit unit2 = protoss.addUnit("Colossus");

        army.add(unit1);
        army.add(unit2);

        Assert.assertEquals(army.get(0).name(),"Zealot");
        Assert.assertEquals(army.get(1).name(),"Colossus");
    }

    @Test
    public void testCreateAmyZerg() throws Exception
    {
        ArrayList<Unit> army = new ArrayList<>();
        RaceSelector race = new RaceSelector();

        Race zerg = race.getRace("Zerg");
        Unit unit1 = zerg.addUnit("Zergling");
        Unit unit2 = zerg.addUnit("Hydralisk");

        army.add(unit1);
        army.add(unit2);

        Assert.assertEquals(army.get(0).name(),"Zergling");
        Assert.assertEquals(army.get(1).name(),"Hydralisk");
    }

}
