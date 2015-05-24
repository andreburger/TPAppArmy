package ac.za.cput.andre.domain;


/**
 * Created by student on 2015/04/26.
 */
public interface Race{

    public Unit addUnit(String name);


    public void setID(long id);
    public void setArmyName(String nm);
    public void setArmyPop(int pop);

    public String getArmyName();
    public long getID();
}
