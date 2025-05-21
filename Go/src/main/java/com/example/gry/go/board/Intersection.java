package com.example.gry.go.board;

/**
 * Reprezentuje przecięcie na planszy gry Go.
 */
public class Intersection {
    /**
     * Współrzędne przecięcia na planszy.
     */
    private final Coordinate coordinate;

    /**
     * Stan przecięcia. Może być puste, zajęte przez czarny kamień lub biały kamień.
     */
    private StateOfIntersection stoneState;

    /**
     * Konstruktor klasy Intersection.
     * @param coordinate Współrzędne przecięcia na planszy.
     * @param stoneState Stan przecięcia. Może być puste, zajęte przez czarny kamień lub biały kamień.
     */
    public Intersection(Coordinate coordinate, StateOfIntersection stoneState) {
        this.coordinate = coordinate;
        this.stoneState = stoneState;
    }

    /**
     * @return Współrzędne przecięcia na planszy.
     */
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    /**
     * @return Stan przecięcia. Może być puste, zajęte przez czarny kamień lub biały kamień.
     */
    public StateOfIntersection getStoneState() {
        return this.stoneState;
    }

    /**
     * Ustawia stan przecięcia na podaną wartość.
     * @param newStoneState Stan przecięcia, na który należy ustawić przecięcie.
     */
    public void setStoneState(StateOfIntersection newStoneState) {
        this.stoneState = newStoneState;
    }
}
