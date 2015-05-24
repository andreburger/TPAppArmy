package ac.za.cput.andre.model;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by student on 2015/05/24.
 */
public class TerranResource extends ResourceSupport {
    private Long resID;
    private String armyName;

    private TerranResource()
    {

    }

    public Long getResID()
    {
        return resID;
    }

    public String getArmyName()
    {
        return armyName;
    }

    public TerranResource(Builder builder)
    {
        this.resID = builder.resID;
        this.armyName = builder.armyName;
    }


    public static class Builder{
        private Long resID;
        private String armyName;

        public Builder(String name) {
            this.armyName = name;
        }

        public Builder resid(Long value){
            this.resID=value;
            return this;
        }


        public Builder armyName(String value){
            this.armyName=value;
            return this;
        }

        public TerranResource build(){
            return new TerranResource(this);
        }

    }


}
