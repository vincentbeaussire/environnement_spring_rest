package org.example.environnement_spring_rest.enums;

public enum TravelMode {
    WALKING(0.0),
    BIKE(0.0),
    CAR(0.22),
    BUS(0.11),
    TRAIN(0.03),
    PLANE(0.259);


    private final double estimatedCo2kg;

    TravelMode(double estimatedCo2kg) {
        this.estimatedCo2kg = estimatedCo2kg;
    }

    public double getEstimatedCo2kg() {
        return estimatedCo2kg;
    }

    public double calculateCo2ForDistance(double distanceKm) {
        return this.estimatedCo2kg * distanceKm;
    }

//    TravelMode mode = TravelMode.CAR;
//
//        switch (mode) {
//        case WALKING:
//            System.out.println("You are walking.");
//            break;
//        case BIKE:
//            System.out.println("You are biking.");
//            break;
//        case CAR:
//            System.out.println("You are driving.");
//            break;
//        case BUS:
//            System.out.println("You are on a bus.");
//            break;
//        case TRAIN:
//            System.out.println("You are on a train.");
//            break;
//        case PLANE:
//            System.out.println("You are flying.");
//            break;
//    }
}
