package com.example.pizasson.Model.Extras;

/**
 * This is a enum class where we implement the ingredients for after user.
 *
 */
public enum ExtraIngredients {
    EGG("Egg", 0.50),
    CREAM_OF_TARTAR("Cream Of Tartar", 5.00),
    BUTTER_SOFTENED("Butter Softened", 6.00),
    SIFTED_CAKE_FLOUR("Sifted Cake Flour", 3.50),
    EGGPLANT("Eggplant",4.50),
    TAHINI("Tahini", 3.50),
    LEMON_JUICE("Lemon Juice", 5.30),
    POTATO("Potato", 3.50),
    TOMATO("Tomato", 2.50),
    ONIONS("Onions", 2.00),
    LETTUCE("Lettuce", 1.50),
    CARROT("Carrot", 2.00),
    BLACK_PEPPER("Black Peper", 1.00),
    GARLIC("Garlic", 2.00),
    VEGETABLE_OIL("Vegetable Oil", 5.00),
    GROUND_PAPRIKA("Ground Paprika", 2.50),
    PEPPER("Pepper", 2.50),
    CHICKEN_WINGS("Chicken Wings", 17.50),
    BUTTER("Butter",  6.50),
    HOT_SAUCE("Hot Sauce", 12.00),
    GROUND_CUMIN("Ground Cumin", 0.50),
    MILK("Milk", 6.00),
    VANILLA("Vanilla", 5.30),
    FLOUR("Flour",4.20),
    GROUND_GINGER("Ground Ginger", 7.00),
    PUMPKIN_PUREE("Pumpkin Puree", 6.00),
    BREAD("Bread", 1.00),
    MOZZARELLA_CHEESE("Mozzarella Cheese", 13.00);

    private final String name;
    private final double cost;


    ExtraIngredients(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
