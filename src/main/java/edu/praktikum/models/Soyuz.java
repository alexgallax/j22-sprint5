package edu.praktikum.models;

import java.util.Comparator;
import java.util.Objects;

public class Soyuz implements SpaceShip {

    private final int crewCount;

    public Soyuz(int crewCount) {
        this.crewCount = crewCount;
    }

    @Override
    public int getCrewCount() {
        return crewCount;
    }

    @Override
    public boolean isCargo() {
        return false;
    }

    @Override
    public String toString() {
        return "Soyuz{" +
                "crewCount=" + crewCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soyuz soyuz = (Soyuz) o;
        return crewCount == soyuz.crewCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(crewCount);
    }

    @Override
    public int compareTo(SpaceShip o) {
        return Comparator.comparingInt((SpaceShip obj) -> obj.getCrewCount())
                .thenComparing((SpaceShip obj) -> obj.isCargo())
                .compare(this, o);
    }
}
