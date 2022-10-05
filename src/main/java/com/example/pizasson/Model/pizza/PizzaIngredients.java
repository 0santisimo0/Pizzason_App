package com.example.pizasson.Model.pizza;

public enum PizzaIngredients {
    HAM("Ham", 4.00,"src/main/resources/images/IngredientsImages/ham.png"),
    NORMAL_CHEESE("White Cheese", 3.00,"src/main/resources/images/IngredientsImages/normal_cheese.png"),
    MOZZARELLA_CHEESE("Mozzarella Cheese", 4.00,"src/main/resources/images/IngredientsImages/mozzarella.png"),
    PARMESAN_CHEESE("Parmesan Cheese", 3.50,"src/main/resources/images/IngredientsImages/parmesan_cheese.png"),
    ROQUEFORT_CHEESE("Roquefort Cheese", 3.50,"src/main/resources/images/IngredientsImages/roquefort_cheese.png"),
    TOFU_CHEESE("Tofu Cheese", 3.50,"src/main/resources/images/IngredientsImages/tofu_cheese.png"),
    MUSHROOM("Mushroom", 5.00,"src/main/resources/images/IngredientsImages/mushroom.png"),
    PEPPER("Pepper", 4.00,"src/main/resources/images/IngredientsImages/pepper.png"),
    PINEAPPLE("Pineapple", 4.00,"src/main/resources/images/IngredientsImages/pineapple.png"),
    ONION("Onion", 2.00,"src/main/resources/images/IngredientsImages/onion.png"),
    BACON("Bacon", 4.00,"src/main/resources/images/IngredientsImages/bacon.png"),
    GARLIC("Garlic", 1.50,"src/main/resources/images/IngredientsImages/garlic.png"),
    TOMATO("Tomato", 3.00,"src/main/resources/images/IngredientsImages/tomato.png"),
    TOMATO_SAUCE("Tomato Sauce", 4.00,"src/main/resources/images/IngredientsImages/tomato_sauce.png"),
    JALAPENO("Jalapeno", 2.50,"src/main/resources/images/IngredientsImages/jalapeno.png"),

    PARSLEY("Parsley", 2.50,"src/main/resources/images/IngredientsImages/parsley.png"),
    SAUSAGE("Sausage", 4.50,"src/main/resources/images/IngredientsImages/sausage.png"),
    CORN("Corn", 3.00,"src/main/resources/images/IngredientsImages/corn.png"),
    OLIVES("Olive",2.00,"src/main/resources/images/IngredientsImages/olive.png"),

    SPINACH("Spinach", 1.00,"src/main/resources/images/IngredientsImages/spinach.png"),
    BROCCOLI("Broccoli", 5.00,"src/main/resources/images/IngredientsImages/broccoli.png"),
    PEPPERONI("Peperoni", 2.00,"src/main/resources/images/IngredientsImages/pepperoni.png");


    private final String name;
    private final double cost;
    private final String imagePath;

    PizzaIngredients(String name, double cost, String imagePath) {
        this.name = name;
        this.cost = cost;
        this.imagePath = imagePath;
    }


    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getImagePath() {
        return imagePath;
    }
}
