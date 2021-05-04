package classes;

public class Rental {
    private final Movie movie;
    private final int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    public double getCharge() {
        double total = 0;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                total += 2;
                if (getDaysRented() > 2)
                    total += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                total += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                total += 1.5;
                if (getDaysRented() > 3)
                    total += (getDaysRented() - 3) * 1.5;
                break;
        }
        return total;
    }

    public int getFrequentRenterPoints() {
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }
}