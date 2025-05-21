package com.example.gry.go.board;

public class Board {
    /**
     * Rozmiar planszy (długość boku planszy).
     */
    private final int size;
    /**
     * Plansza do gry w Go. Tablica dwuwymiarowa, gdzie każdy element to przecięcie.
     */
    private final Intersection[][] intersections;

    /**
     * Konstruktor klasy Board.
     *
     * @param size Rozmiar planszy (długość boku planszy).
     * @param intersections Plansza do gry w Go. Tablica dwuwymiarowa, gdzie każdy element to przecięcie.
     */
    public Board(int size, Intersection[][] intersections) {
        if(size <= 0) {
            throw new IllegalArgumentException("Rozmiar planszy musi być większy od 0.");
        }
        this.size = size;
        this.intersections = new Intersection[size][size];
        this.initializeBoard();
    }

    /**
     * Inicjalizuje planszę do gry w Go. Wszystkie przecięcia są puste.
     */
    private void initializeBoard() {
        for(int row = 0; row < size; row++) {
            for(int column = 0; column < size; column++) {
                Coordinate coordinate = new Coordinate(row, column);
                intersections[row][column] = new Intersection(coordinate, StateOfIntersection.EMPTY);
            }
        }
    }

    /**
     * @return Rozmiar planszy (długość boku planszy).
     */
    public int getSize() {
        return size;
    }

    public Intersection getIntersection(Coordinate coordinate) {

        return intersections[coordinate.row()][coordinate.column()];
    }

    /**
     * Metoda sprawdzająca, czy podane współrzędne są w obrębie planszy.
     *
     * @param coordinate Współrzędne do sprawdzenia.
     * @return true, jeśli współrzędne są w obrębie planszy, false w przeciwnym razie.
     */
    public boolean isInBounds(Coordinate coordinate) {
        return coordinate.row() >= 0 && coordinate.row() < size &&
               coordinate.column() >= 0 && coordinate.column() < size;

    }
}
