package classes;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        Enumeration enum_rentals = rentals.elements();	    
        String result = "classes.Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double total = 0;
            Rental rental = (Rental) enum_rentals.nextElement();
            //determine amounts for rental line
            total = rental.getCharge();
            // add frequent renter points
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(total) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double charge = 0;
        Enumeration enumeration = rentals.elements();
        while (enumeration.hasMoreElements()) {
            Rental rental = (Rental) enumeration.nextElement();
            charge += rental.getCharge();
        }
        return charge;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        Enumeration enumeration = rentals.elements();
        while (enumeration.hasMoreElements()) {
            Rental rental = (Rental) enumeration.nextElement();
            points += rental.getFrequentRenterPoints();
        }
        return points;
    }

}
    