import java.util.*;

interface Insurable {
double calculateInsurance();
}

abstract class Parcel {
double weightKg;
double declaredValue;

```
Parcel(double weightKg, double declaredValue) {
    this.weightKg = weightKg;
    this.declaredValue = declaredValue;
}

abstract double calculateCharge();

double calculateInsurance() {
    return 0.0;
}

String getType() {
    return "STANDARD";
}

double calculateTotal() {
    return calculateCharge() + calculateInsurance();
}
```

}

class StandardParcel extends Parcel {
StandardParcel(double weightKg, double declaredValue) {
super(weightKg, declaredValue);
}

```
@Override
double calculateCharge() {
    return 40 + 10 * weightKg;
}

@Override
String getType() {
    return "STANDARD";
}
```

}

class ExpressParcel extends Parcel implements Insurable {
ExpressParcel(double weightKg, double declaredValue) {
super(weightKg, declaredValue);
}

```
@Override
double calculateCharge() {
    return 80 + 15 * weightKg;
}

@Override
public double calculateInsurance() {
    return declaredValue * 0.02;
}

@Override
String getType() {
    return "EXPRESS";
}
```

}

class FragileParcel extends Parcel implements Insurable {
FragileParcel(double weightKg, double declaredValue) {
super(weightKg, declaredValue);
}

```
@Override
double calculateCharge() {
    return 40 + 10 * weightKg + 50;
}

@Override
public double calculateInsurance() {
    return declaredValue * 0.02;
}

@Override
String getType() {
    return "FRAGILE";
}
```

}

public class charge {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

```
    int n = sc.nextInt();
    double grandTotal = 0.0;

    for (int i = 0; i < n; i++) {
        String type = sc.next();
        double weight = sc.nextDouble();
        double value = sc.nextDouble();

        Parcel parcel;

        switch (type) {
            case "STANDARD":
                parcel = new StandardParcel(weight, value);
                break;

            case "EXPRESS":
                parcel = new ExpressParcel(weight, value);
                break;

            case "FRAGILE":
                parcel = new FragileParcel(weight, value);
                break;

            default:
                continue;
        }

        double charge = parcel.calculateCharge();
        double insurance = parcel.calculateInsurance();
        double total = parcel.calculateTotal();

        System.out.printf(
            "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
            parcel.getType(), charge, insurance, total
        );

        grandTotal += total;
    }

    System.out.printf("Grand Total: %.2f%n", grandTotal);

    sc.close();
}
```

}
