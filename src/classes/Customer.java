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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "classes.Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double total = 0;
            Rental rental = (Rental) enum_rentals.nextElement();
            //determine amounts for rental line
            total = amountFor(rental);
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(total) + "\n";
            totalAmount += total;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rental) {
        double total = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                total += 2;
                if (rental.getDaysRented() > 2)
                    total += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                total += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                total += 1.5;
                if (rental.getDaysRented() > 3)
                    total += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return total;
    }

}
    