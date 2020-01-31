package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Chipotle {

    private HashMap<Integer, String> chipotleIngrediants = new HashMap<Integer, String>() {{
        put(1, "White Rice");
        put(2, "Brown Rice");
        put(3, "No Rice");
        put(4, "All Rice");//rice

        put(5, "Chicken");
        put(6, "Steak");
        put(7, "Carnitas");
        put(8, "Chorizo");
        put(9, "Vegetarian/No Meat");
        put(10, "No Meat");
        put(11, "All Meat"); //meat

        put(12, "Pinto Beans");
        put(13, "Black Beans");
        put(14, "No Beans");
        put(15, "All Beans");//beans

        put(16, "Lettuce");
        put(17, "Fajitas");
        put(18, "No Veggies");
        put(19, "All Veggies");//veg
    }};
    private Boolean cheese = false;
    private Boolean guac = false;
    private Boolean queso = false;
    private Boolean sourCream = false;
    private final double ADDANOTHER = .50, ALLMEAT = 2.00, ALLVEGGIES = 1.00,
            ALLBEANS = 1.00, ALLRICE = 1.00;
    int i = 1;


    private ArrayList cart = new ArrayList();
    ArrayList totalCart = new ArrayList();

    //Constructor
    public Chipotle() {
        for (int x = 0; x < 10; x++) {
            System.out.println("Burrito #" + i++);
            randomMethod(chipotleIngrediants);//calling the (random method) with the hashmap as parameter.
            System.out.println("Total Price : $" + totalPrice(cart));//totalPrice method with the cart as parameter
            }
        for(Object key : totalCart){
            String s = ("|"+key + ": " + Collections.frequency(totalCart, key)+"|");
            System.out.println(s);


        }
//        String s = ("|"+key + ": " + Collections.frequency(totalCart, key)+"|");





    }

    /*method first grabs a random int from 5-9 for the number of ingredients
       *Then gets another random int 1-19 (size of hashmap) and gets a random item from the hashmap
       * and places into array list called cart.
     */
    public ArrayList randomMethod(HashMap chipotleIngrediants) {
        ArrayList cart = new ArrayList();
        int loop = 5 + (int) (Math.random() * ((9 - 5) + 1));

        for (int i = 0; i <= loop; i++) {
            int choice = 1 + (int) (Math.random() * ((20 - 1) - 1));
            cart.add(chipotleIngrediants.get(choice)); //Cart for each order
            totalCart.add(chipotleIngrediants.get(choice)); //Adding to the totalCart (LOTS OF WORDS)
        }
        System.out.println(cart);
        this.cart = cart;
        return totalCart;//return totalCart to add them up
    }


     //Price will always start at 3.00 and increment depending on the Strings the array list contains.
    public double totalPrice(ArrayList cart) {
        double totalPrice = 3.00;
        for (int i = 0; i <= cart.size(); i++) {
            if (cart.contains("All Meat")) {
                totalPrice += ALLMEAT;
            } else if (cart.contains("All Veggies")) {
                totalPrice += ALLVEGGIES;
            } else if (cart.contains("All Rice")) {
                totalPrice += ALLRICE;
            } else if (cart.contains("All Beans")) {
                totalPrice += ALLBEANS;
            } else if (cart.contains("No")) {
                totalPrice += 0;
            } else {
                totalPrice += ADDANOTHER;
            }
        }
        return totalPrice;
    }
}

