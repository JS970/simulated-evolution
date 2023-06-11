package org.woehlke.computer.kurzweil.simulated.evolution.model.cell;

import org.checkerframework.checker.units.qual.C;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class CellCoreOriginalTest {

    private Random random = new Random();
    private CellCoreOriginal testCellCore = new CellCoreOriginal(random);

    @Test
    public void orientationMAXTest() {
        Orientation testValue = Orientation.HARD_LEFT;
        int value = testValue.ordinal();
        boolean negative = false;

        testValue = Orientation.HARD_LEFT;
        if(testValue.ordinal() == -testCellCore.getMAX_VALUE()) negative = true;

        testValue = Orientation.HARD_RIGHT;
        if(testValue.ordinal() == -testCellCore.getMAX_VALUE()) negative = true;

        testValue = Orientation.FORWARD;
        if(testValue.ordinal() == -testCellCore.getMAX_VALUE()) negative = true;

        testValue = Orientation.FORWARD;
        if(testValue.ordinal() == -testCellCore.getMAX_VALUE()) negative = true;

        testValue = Orientation.BACKWARDS;
        if(testValue.ordinal() == -testCellCore.getMAX_VALUE()) negative = true;

        testValue = Orientation.SOFT_LEFT;
        if(testValue.ordinal() == -testCellCore.getMAX_VALUE()) negative = true;

        testValue = Orientation.SOFT_RIGHT;
        if(testValue.ordinal() == -testCellCore.getMAX_VALUE()) negative = true;

        try {
            if(!negative)  throw new Exception("negative Orientation ordinal is impossible");
        } catch (Exception e) {
            System.out.println("=================CellCoreOriginal.java=================");
            System.out.println("check line 116 - private void decrease(Orientation base)");
            System.out.println("Cannot be true ");
            System.out.println("    private void decrease(Orientation base) {");
            System.out.println("        int value = dna.get(base.ordinal());");
            System.out.println(">>>     if (value == -MAX_VALUE) {");
            System.out.println("            for (int i = 0; i < dna.size(); i++) {");
            System.out.println("                Integer val = dna.get(i);");
            System.out.println("                val++;");
            System.out.println("                dna.set(i, val);");
            System.out.println("            }");
            System.out.println("            dna.set(base.ordinal(), 0);");
            System.out.println("        } else {");
            System.out.println("            dna.set(base.ordinal(), value-1);");
            System.out.println("        }");
            System.out.println("    }");
        }
    }

    @Test
    public void orientationMINTest() {
        Orientation testValue = Orientation.HARD_LEFT;
        int value = testValue.ordinal();
        boolean maxvalue = false;

        testValue = Orientation.HARD_LEFT;
        if(testValue.ordinal() == testCellCore.getMAX_VALUE()) maxvalue = true;

        testValue = Orientation.HARD_RIGHT;
        if(testValue.ordinal() == testCellCore.getMAX_VALUE()) maxvalue = true;

        testValue = Orientation.FORWARD;
        if(testValue.ordinal() == testCellCore.getMAX_VALUE()) maxvalue = true;

        testValue = Orientation.FORWARD;
        if(testValue.ordinal() == testCellCore.getMAX_VALUE()) maxvalue = true;

        testValue = Orientation.BACKWARDS;
        if(testValue.ordinal() == testCellCore.getMAX_VALUE()) maxvalue = true;

        testValue = Orientation.SOFT_LEFT;
        if(testValue.ordinal() == testCellCore.getMAX_VALUE()) maxvalue = true;

        testValue = Orientation.SOFT_RIGHT;
        if(testValue.ordinal() == testCellCore.getMAX_VALUE()) maxvalue = true;

        try {
            if(!maxvalue)  throw new Exception("negative Orientation ordinal is impossible");
        } catch (Exception e) {
            System.out.println("=================CellCoreOriginal.java=================");
            System.out.println("check line 102 - private void increase(Orientation base)");
            System.out.println("Cannot be true ");
            System.out.println("    private void increase(Orientation base) {");
            System.out.println("        int value = dna.get(base.ordinal());");
            System.out.println(">>>     if (value == MAX_VALUE) {");
            System.out.println("            for (int i = 0; i < dna.size(); i++) {");
            System.out.println("                Integer val = dna.get(i);");
            System.out.println("                val--;");
            System.out.println("                dna.set(i, val);");
            System.out.println("            }");
            System.out.println("        }");
            System.out.println("        Integer val = dna.get(base.ordinal());");
            System.out.println("        val++;");
            System.out.println("        dna.set(base.ordinal(), val);");
            System.out.println("    }");
        }
    }
}

