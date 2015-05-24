package ac.za.cput.andre.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by student on 2015/04/26.
 */
@Entity
public class Protoss implements Race,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String armyName;
    int armyPop;

    public Protoss()
    {

    }

    public long getID()
    {
        return id;
    }
    public void setID(long id)
    {
        this.id = id;
    }
    public void setArmyName(String nm)
    {
        armyName = nm;
    }

    public void setArmyPop(int pop)
    {
        armyPop = pop;
    }
    public String getArmyName(){return armyName;}

    public Unit addUnit(String name)
    {
        if(name.equals("Zealot"))
        {

            return new Zealot();
        }
        else
        {
            if(name.equals("Colossus"))
            {

                return new Colossus();
            }
            else
                return null;
        }
    }


}
