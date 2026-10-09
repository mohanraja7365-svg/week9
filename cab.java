import java.util.*;

interface NightService {
double NIGHT_CHARGE = 0.20;

```
default double applyNightCharge(double fare) {
    return fare + (fare * NIGHT_CHARGE);
}
```

}

abstract class Cab {
double km;

```
Cab(double km) {
    this.km = km;
}

abstract double getRate();

double calculateFare() {
    double fare = km * getRate();

    if (fare < 100) {
        fare = 100;
    }

    return fare;
}
```

}

class Mini extends Cab {
Mini(double km) {
super(km);
}

```
@Override
double getRate() {
    return 10;
}
```

}

class Sedan extends Cab implements NightService {
Sedan(double km) {
super(km);
}

```
@Override
double getRate() {
    return 14;
}
```

}

class SUV extends Cab implements NightService {
SUV(double km) {
super(km);
}

```
@Override
double getRate() {
    return 18;
}
```

}

public class cab {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

```
    int n = sc.nextInt();
    double total = 0.0;

    for (int i = 0; i < n; i++) {
        String type = sc.next();
        double km = sc.nextDouble();
        String time = sc.next();

        Cab cab;

        switch (type) {
            case "MINI":
                cab = new Mini(km);
                break;

            case "SEDAN":
                cab = new Sedan(km);
                break;

            case "SUV":
                cab = new SUV(km);
                break;

            default:
                continue;
        }

        if (time.equals("NIGHT") && !(cab instanceof NightService)) {
            System.out.println(type + ": night service not available");
            continue;
        }

        double fare = cab.calculateFare();

        if (time.equals("NIGHT")) {
            NightService nightCab = (NightService) cab;
            fare = nightCab.applyNightCharge(fare);
        }

        System.out.printf("%s: %.2f%n", type, fare);

        total += fare;
    }

    System.out.printf("Total: %.2f%n", total);

    sc.close();
}
```

}
