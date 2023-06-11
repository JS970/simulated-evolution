package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

public class HungryStatusTest {
    private static CensusCellStatus status;
    private static SimulatedEvolutionPopulationCensus census;
    @BeforeClass
    public static void setup(){
        status = new HungryStatus();
        census = new SimulatedEvolutionPopulationCensus(0);
    }
    /**
     * Purpose : increase HungryStatus cell number from given SimulatedEvolutionPopulationCensus
     * Input : None
     * Expected :
     *      return void
     *      increase HungryStatus cell number 1;
     */
    @Test
    public void countStatus() {
        int beforeAdultCells = status.getCellsNumber(census);
        status.countStatus(census);
        Assert.assertEquals(beforeAdultCells + 1,  status.getCellsNumber(census));
    }

    /**
     * Purpose : get AdultAgeStatus cell's color
     * Input : void
     * Expected : return Color.LIGHT_GRAY
     */
    @Test
    public void getColor() {
        Assert.assertSame(status.getColor(),Color.LIGHT_GRAY);
    }


    /**
     * get AdultAgeStatus cell's foreground color
     * Input : void
     * Expected : return Color.BLACK
     */
    @Test
    public void getColorForeground() {
        Assert.assertSame(status.getColorForeground(),Color.BLACK);
    }


    /**
     * get HungryStatus cell's background color
     * Input : void
     * Expected : return Color.LIGHT_GRAY
     */
    @Test
    public void getColorBackground() {
        Assert.assertSame(status.getColorBackground(),Color.LIGHT_GRAY);
    }
}
