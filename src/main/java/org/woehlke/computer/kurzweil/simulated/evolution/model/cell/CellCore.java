package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

abstract public class CellCore {
    public static CellCoreOriginal createCellCore(Random random) {
        return new CellCoreOriginal(random);
    }

    protected Random random;

    @Setter
    @Getter
    protected List<Integer> dna;

    protected int MIN_VALUE = 0;
    @Getter
    protected int MAX_VALUE = 16;
    protected int MAX_INITIAL_VALUE = 8;

    public abstract CellCore performMitosis();

    public abstract Orientation getRandomOrientation();

}
