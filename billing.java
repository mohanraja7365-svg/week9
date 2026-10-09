import java.util.*;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {

    Home(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
}

class Shop extends Connection {

    Shop(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return (units * 8.0) + 100.0;
    }
}

class Factory extends Connection {

    Factory(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return Math.max(units * 6.0, 1000.0);
    }
}

public class billing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Connection[] connections = new Connection[n];

        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            switch (type) {
                case "HOME":
                    connections[i] = new Home(units);
                    break;

                case "SHOP":
                    connections[i] = new Shop(units);
                    break;

                case "FACTORY":
                    connections[i] = new Factory(units);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            double bill = connections[i].calculateBill();

            String type = "";

            if (connections[i] instanceof Home) {
                type = "HOME";
            } else if (connections[i] instanceof Shop) {
                type = "SHOP";
            } else if (connections[i] instanceof Factory) {
                type = "FACTORY";
            }

            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}