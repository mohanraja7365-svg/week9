import java.util.*;

abstract class TravelBooking {
    double distanceKm;
    static final double BOOKING_FEE = 50.0;

    TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }

    abstract String getMode();
}

class Bus extends TravelBooking {

    Bus(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateFare() {
        return distanceKm * 2.0;
    }

    @Override
    String getMode() {
        return "BUS";
    }
}

class Train extends TravelBooking {

    Train(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateFare() {
        return distanceKm * 1.5;
    }

    @Override
    String getMode() {
        return "TRAIN";
    }
}

class Flight extends TravelBooking {

    Flight(double distanceKm) {
        super(distanceKm);
    }

    @Override
    double calculateFare() {
        return 2500 + (distanceKm * 4.0);
    }

    @Override
    String getMode() {
        return "FLIGHT";
    }
}

public class fee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            switch (mode) {
                case "BUS":
                    bookings[i] = new Bus(distance);
                    break;

                case "TRAIN":
                    bookings[i] = new Train(distance);
                    break;

                case "FLIGHT":
                    bookings[i] = new Flight(distance);
                    break;
            }
        }

        for (TravelBooking booking : bookings) {
            System.out.printf(
                "%s: %.2f%n",
                booking.getMode(),
                booking.calculateTotal()
            );
        }

        sc.close();
    }
}