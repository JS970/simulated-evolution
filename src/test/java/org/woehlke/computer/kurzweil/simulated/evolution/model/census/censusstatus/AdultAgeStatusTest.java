package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.junit.BeforeClass;
import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

import org.junit.*;

public class AdultAgeStatusTest {
    private static CensusCellStatus status;
    private static SimulatedEvolutionPopulationCensus census;
    @BeforeClass
    public static void setup(){
        status = new AdultAgeStatus();
        census = new SimulatedEvolutionPopulationCensus(0);
    }

    /**
     * Purpose : increase AdultAgeStatus cell nummber from given SimulatedEvolutionPopulationCensus
     * Input : None
     * Expected :
     *      return void
     *      increase AdultAgeCellsNumber 1;
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
     * Expected : return Color.RED
     */
    @Test
    public void getColor() {
        Assert.assertSame(status.getColor(),Color.RED);
    }

    /**
     * get AdultAgeStatus cell's foreground color
     * Input : void
     * Expected : return Color.WHITE
     */
    @Test
    public void getColorForeground() {
        Assert.assertSame(status.getColorForeground(),Color.WHITE);
    }

    /**
     * get AdultAgeStatus cell's background color
     * Input : void
     * Expected : return Color.RED
     */
    @Test
    public void getColorBackground() {
        Assert.assertSame(status.getColorBackground(),Color.RED);
    }
}
