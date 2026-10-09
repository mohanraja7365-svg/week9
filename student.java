import java.util.*;

interface BusUser {
double getTransportFee();
}

abstract class Student {
String name;

```
Student(String name) {
    this.name = name;
}

abstract double calculateTuition();

double getExtraFee() {
    return 0.0;
}

double calculateTotalFee() {
    return calculateTuition() + getExtraFee();
}
```

}

class DayScholar extends Student implements BusUser {
DayScholar(String name) {
super(name);
}

```
@Override
double calculateTuition() {
    return 40000;
}

@Override
public double getTransportFee() {
    return 12000;
}

@Override
double getExtraFee() {
    return getTransportFee();
}
```

}

class Hosteller extends Student {
Hosteller(String name) {
super(name);
}

```
@Override
double calculateTuition() {
    return 40000;
}

@Override
double getExtraFee() {
    return 60000;
}
```

}

class Scholar extends Student implements BusUser {
Scholar(String name) {
super(name);
}

```
@Override
double calculateTuition() {
    return 20000;
}

@Override
public double getTransportFee() {
    return 12000;
}

@Override
double getExtraFee() {
    return getTransportFee();
}
```

}

public class student {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

```
    int n = sc.nextInt();
    double totalCollected = 0.0;

    for (int i = 0; i < n; i++) {
        String type = sc.next();
        String name = sc.next();

        Student student;

        switch (type) {
            case "DAY_SCHOLAR":
                student = new DayScholar(name);
                break;

            case "HOSTELLER":
                student = new Hosteller(name);
                break;

            case "SCHOLAR":
                student = new Scholar(name);
                break;

            default:
                continue;
        }

        double fee = student.calculateTotalFee();

        System.out.printf("%s: %.2f%n", name, fee);

        totalCollected += fee;
    }

    System.out.printf(
        "Total Collected: %.2f%n", totalCollected
    );

    sc.close();
}
```

}
