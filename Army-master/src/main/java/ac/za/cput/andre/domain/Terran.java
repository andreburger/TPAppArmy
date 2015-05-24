package ac.za.cput.andre.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * Created by student on 2015/04/26.
 */
@Entity
public class Terran implements Race,Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String armyName;
    int armyPop;

    public Terran()
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
        if(name.equals("Marine"))
        {
            return new Marine();
        }
        else
        {
            if(name.equals("Thor"))
            {
                return new Thor();
            }
            else
                return null;
        }
    }

}
