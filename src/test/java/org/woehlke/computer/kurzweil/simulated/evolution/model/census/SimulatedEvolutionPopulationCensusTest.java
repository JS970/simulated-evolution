package org.woehlke.computer.kurzweil.simulated.evolution.model.census;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus;

public class SimulatedEvolutionPopulationCensusTest {
    private SimulatedEvolutionPopulationCensus population;

    @Before
    public void setUp() throws Exception {
        population = new SimulatedEvolutionPopulationCensus(0);
    }

    @After
    public void tearDown() throws Exception {
        population = null;
    }


    @Test
    public void testCountStatusOfYoungCell() {
        int previousPopulation = population.getPopulation();
        int previousYoungCellPopulation = population.getYoungCells();
        population.countStatusOfOneCell(LifeCycleStatus.YOUNG, 0);

        assertEquals(previousPopulation + 1, population.getPopulation());
        assertEquals(previousYoungCellPopulation + 1, population.getYoungCells());
    }

    @Test
    public void testCountStatusOfYoungAndFatCell() {
        int previousPopulation = population.getPopulation();
        int previousYoungAndFatPopulation = population.getYoungAndFatCells();
        population.countStatusOfOneCell(LifeCycleStatus.YOUNG_AND_FAT, 0);
        
        assertEquals(previousPopulation + 1, population.getPopulation());
        assertEquals(previousYoungAndFatPopulation + 1, population.getPopulation());
    }

    @Test
    public void testCountStatusOfAdultCell() {
        int previousPopulation = population.getPopulation();
        int previousAdultCellPopulation = population.getAdultCells();
        population.countStatusOfOneCell(LifeCycleStatus.ADULT_AGE, 0);

        assertEquals(previousPopulation + 1, population.getPopulation());
        assertEquals(previousAdultCellPopulation + 1, population.getAdultCells());
    }

    @Test
    public void testCountStatusOfDeadCell() {
        int previousPopulation = population.getPopulation();
        int previousDeadCellPopulation = population.getDeadCells();
        population.countStatusOfOneCell(LifeCycleStatus.DEAD, 0);

        assertEquals(previousPopulation + 1, population.getPopulation());
        assertEquals(previousDeadCellPopulation + 1, population.getDeadCells());
    }

    @Test
    public void testCountStatusOfOldCell() {
        int previousPopulation = population.getPopulation();
        int previousOldCellPopulation = population.getOldCells();
        population.countStatusOfOneCell(LifeCycleStatus.OLD, 0);

        assertEquals(previousPopulation + 1, population.getPopulation());
        assertEquals(previousOldCellPopulation + 1, population.getOldCells());
    }

    @Test
    public void testCountStatusOfHungryCell() {
        int previousPopulation = population.getPopulation();
        int previousHungryCellPopulation = population.getHungryCells();
        population.countStatusOfOneCell(LifeCycleStatus.HUNGRY, 0);

        assertEquals(previousPopulation + 1, population.getPopulation());
        assertEquals(previousHungryCellPopulation + 1, population.getHungryCells());
    }
    @Test
    public void testIncrementYoungCells(){
        int previousYoungCells = population.getYoungCells();
        population.incrementYoungCells();

        assertEquals(previousYoungCells + 1, population.getYoungCells());
    }

    @Test
    public void testIncrementYoungAndFatCells(){
        int previousYoungAndFatCells = population.getYoungAndFatCells();
        population.incrementYoungAndFatCells();

        assertEquals(previousYoungAndFatCells + 1, population.getYoungAndFatCells());
    }

    @Test
    public void testIncrementFullAgeCells(){
        int previousFullAgeCells = population.getAdultCells();
        population.incrementFullAgeCells();

        assertEquals(previousFullAgeCells + 1, population.getAdultCells());
    }

    @Test
    public void testIncrementHungryCells(){
        int previousHungryCells = population.getHungryCells();
        population.incrementHungryCells();

        assertEquals(previousHungryCells + 1, population.getHungryCells());
    }

    @Test
    public void testIncrementOldCells(){
        int previousOldCells = population.getOldCells();
        population.incrementOldCells();

        assertEquals(previousOldCells + 1, population.getOldCells());
    }

    @Test
    public void testIncrementDeadCells(){
        int previousDeadCells = population.getDeadCells();
        population.incrementDeadCells();

        assertEquals(previousDeadCells + 1, population.getDeadCells());
    }

    @Test
    public void testIncrementPopulation(){
        int previousPopulation = population.getPopulation();
        population.incrementPopulation();

        assertEquals(previousPopulation + 1, population.getPopulation());
    }
}
