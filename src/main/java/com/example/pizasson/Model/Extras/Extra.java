package com.example.pizasson.Model.Extras;

/**
 * This class is used to inherit attributes to other class because the attributes of this class we can use in other class.
 *
 */
public class Extra {
    protected String name;
    protected double cost;

    /**
     * This method is a constructor where we will be assigned values when we use this constructor.
     *
     * @param name is used to put the name when use the constructor.
     * @param cost is used to put the cost when use the constructor.
     */
    public Extra (String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    /**
     * This method is overload of previous constructor with only one attribute.
     *
     * @param name is used to put the name when use the constructor.
     */
    public Extra (String name) {
        this.name = name;
    }

    /**
     * This method return the name when we call the method.
     *
     * @return name to get when is required.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to get the cost when we call the method.
     *
     * @return cost  for use when is the method is called.
     */
    public double getCost() {
        return cost;
    }

    /**
     * This method set cost od drink when we can change the value of param.
     *
     * @param cost This param will be change when the method is called.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
}
