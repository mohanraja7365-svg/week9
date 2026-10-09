import java.util.Scanner;

abstract class MovieTicket {
static final double CONVENIENCE_FEE = 20.0;

```
abstract double getPrice();

double calculateAmount(int count) {
    return count * (getPrice() + CONVENIENCE_FEE);
}
```

}

class Regular extends MovieTicket {
@Override
double getPrice() {
return 150.0;
}
}

class Premium extends MovieTicket {
@Override
double getPrice() {
return 250.0;
}
}

class Recliner extends MovieTicket {
@Override
double getPrice() {
return 400.0;
}
}

public class ticket {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

```
    int n = sc.nextInt();
    double total = 0.0;

    for (int i = 0; i < n; i++) {
        String seat = sc.next().toUpperCase();
        int count = sc.nextInt();

        MovieTicket ticket;

        switch (seat) {
            case "REGULAR":
                ticket = new Regular();
                break;

            case "PREMIUM":
                ticket = new Premium();
                break;

            case "RECLINER":
                ticket = new Recliner();
                break;

            default:
                System.out.println("Invalid seat type: " + seat);
                continue;
        }

        double amount = ticket.calculateAmount(count);

        System.out.printf("%s: %.2f%n", seat, amount);
        total += amount;
    }

    System.out.printf("Total: %.2f%n", total);

    sc.close();
}
```

}
