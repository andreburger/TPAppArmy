package ac.za.cput.andre.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/05/24.
 */
public class ZergResource  extends ResourceSupport {
    private Long resID;
    private String armyName;

    private ZergResource()
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

    public ZergResource(Builder builder)
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

        public ZergResource build(){
            return new ZergResource(this);
        }

    }

}