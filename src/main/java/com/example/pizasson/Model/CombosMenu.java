package com.example.pizasson.Model;

import java.util.ArrayList;

/**
 * This class contains the menu combos.
 *
 */
public class CombosMenu {
    /**
     * Is the number of combos ordered
     */
    private int combosOrderedNumber;
    /**
     * Is the combos list
     */
    private ArrayList<Combo> combos;

    /**
     * This is the constructor method.
     * Initialize the combos list.
     *
     * @param combos Is of type ArrayList.
     */
    public CombosMenu(ArrayList<Combo> combos) {
        this.combos = combos;
    }

    /**
     * This is a getter method of the combos list.
     *
     * @return Returns a combos list.
     */
    public ArrayList<Combo> getCombos() {
        return combos;
    }

    /**
     * This is a setter method of the combos list.
     *
     * @param combos Is of type ArrayList.
     */
    public void setCombos(ArrayList<Combo> combos) {
        this.combos = combos;
    }

    /**
     * This is a getter method of the number of combo orders.
     *
     * @return Returns an int type.
     */
    public int getCombosOrderedNumber() {
        return combosOrderedNumber;
    }
}
