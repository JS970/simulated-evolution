package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

public class OldStatusTest {
    private static CensusCellStatus status;
    private static SimulatedEvolutionPopulationCensus census;
    @BeforeClass
    public static void setup(){
        status = new OldStatus();
        census = new SimulatedEvolutionPopulationCensus(0);
    }
    /**
     * Purpose : increase OldStatus cell number from given SimulatedEvolutionPopulationCensus
     * Input : None
     * Expected :
     *      return void
     *      increase OldStatus cell number 1;
     */
    @Test
    public void countStatus() {
        int beforeAdultCells = status.getCellsNumber(census);
        status.countStatus(census);
        Assert.assertEquals(beforeAdultCells + 1,  status.getCellsNumber(census));
    }

    /**
     * Purpose : get OldStatus cell's color
     * Input : void
     * Expected : return Color.DARK_GRAY
     */
    @Test
    public void getColor() {
        Assert.assertSame(status.getColor(),Color.DARK_GRAY);
    }


    /**
     * get OldStatus cell's foreground color
     * Input : void
     * Expected : return Color.WHITE
     */
    @Test
    public void getColorForeground() {
        Assert.assertSame(status.getColorForeground(),Color.WHITE);
    }


    /**
     * get OldStatus cell's background color
     * Input : void
     * Expected : return Color.DARK_GRAY
     */
    @Test
    public void getColorBackground() {
        Assert.assertSame(status.getColorBackground(),Color.DARK_GRAY);
    }
}
