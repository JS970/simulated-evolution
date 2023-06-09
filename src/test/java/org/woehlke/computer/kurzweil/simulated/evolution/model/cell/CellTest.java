package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.woehlke.computer.kurzweil.simulated.evolution.config.ComputerKurzweilProperties;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticePoint;

import java.util.Random;

import static org.junit.Assert.*;

public class CellTest {

    private LatticePoint max = new LatticePoint(1, 1);
    private LatticePoint position = new LatticePoint(1, 1);
    private Random random = new Random();
    private Cell parentCell;
    private Cell childCell;

    @Before
    public void setup() {
        parentCell = Cell.createCell(max, position, random);
        parentCell.performReproductionByCellDivision();
        childCell = parentCell.performReproductionByCellDivision();
    }

    @Test
    public void createCell() {
        parentCell = Cell.createCell(max, position, random);
        parentCell.performReproductionByCellDivision();
        childCell = parentCell.performReproductionByCellDivision();
        Assertions.assertNotNull(childCell);
    }

    @Test
    public void getPosition() {
        LatticePoint compare = new LatticePoint(0, 0);
        Assertions.assertEquals(compare, parentCell.getPosition());
    }

    @Test
    public void isPregnant() {
        Assertions.assertFalse(childCell.isPregnant());
    }

    @Test
    public void isYoungAndFat() {
        Assertions.assertFalse(parentCell.isYoungAndFat());
    }

    @Test
    public void died() {
        Assertions.assertFalse(childCell.died());
    }

    @Test
    public void getLifeCycleStatus() {
        childCell.eat(1);
        Assertions.assertSame(LifeCycleStatus.YOUNG, childCell.getLifeCycleStatus());
    }

    @Test
    public void eat() {
        childCell.eat(10000);
        Assertions.assertTrue(LifeCycleStatus.HUNGRY != childCell.getLifeCycleStatus());
        Assertions.assertTrue(childCell.isYoungAndFat());
    }

    @Test
    public void getRandomOrientationDemo() {
        Random rand = new Random();
        int dnaLength = Orientation.values().length;
        int dnaBase = rand.nextInt(dnaLength);
        int count = 0;
        boolean negative = dnaBase < 0;
        try {
            while (!negative) {
                dnaBase = rand.nextInt(dnaLength);
                negative = dnaBase < 0;
                count++;
                if (count == 1000000)
                    throw new Exception("dnaBase value didn't reach under 1,000,000 random test cases.");
            }
        } catch (Exception e) {
            System.out.println("====================== getRandomOrientationDemo ======================");
            System.out.println("dnaBase value didn't reach under 1,000,000 random test cases.");
            System.out.println("There exists possibility of getRandomOrientation() mehtod can't coverage all lines");
            System.out.println("    private Orientation getRandomOrientation() {");
            System.out.println("        int dnaLength = Orientation.values().length;");
            System.out.println("        int dnaBase = random.nextInt(dnaLength);");
            System.out.println("        if (dnaBase < 0) {");
            System.out.println(">>          dnaBase *= -1; ==> This line could not be coveraged by this program.");
            System.out.println("        }");
            System.out.println("        return Orientation.values()[dnaBase];");
            System.out.println("    }");
        }
    }

    @Test
    public void move() {
        LifeCycle lc = new LifeCycle();
        lc.setFat(-100);
        CellOriginal testCell = new CellOriginal(max, position, random);
        testCell.setLifeCycle(lc);
        Orientation prevOrientation = testCell.getOrientation();
        testCell.move();
        Assertions.assertTrue(prevOrientation == testCell.getOrientation());

        lc.setFat(1000);
        testCell.setLifeCycle(lc);
        testCell.move();
    }
}
