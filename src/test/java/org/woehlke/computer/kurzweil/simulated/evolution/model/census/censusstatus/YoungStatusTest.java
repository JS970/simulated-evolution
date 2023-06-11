package org.woehlke.computer.kurzweil.simulated.evolution.model.census.censusstatus;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.census.SimulatedEvolutionPopulationCensus;

import java.awt.*;

public class YoungStatusTest {
    private static CensusCellStatus status;
    private static SimulatedEvolutionPopulationCensus census;
    @BeforeClass
    public static void setup(){
        status = new YoungStatus();
        census = new SimulatedEvolutionPopulationCensus(0);
    }
    /**
     * Purpose : increase YoungStatus cell number from given SimulatedEvolutionPopulationCensus
     * Input : None
     * Expected :
     *      return void
     *      increase YoungStatus cell number 1;
     */
    @Test
    public void countStatus() {
        int beforeAdultCells = status.getCellsNumber(census);
        status.countStatus(census);
        Assert.assertEquals(beforeAdultCells + 1,  status.getCellsNumber(census));
    }

    /**
     * Purpose : get YoungStatus cell's color
     * Input : void
     * Expected : return Color.BLUE
     */
    @Test
    public void getColor() {
        Assert.assertSame(status.getColor(),Color.BLUE);
    }


    /**
     * get YoungStatus cell's foreground color
     * Input : void
     * Expected : return Color.WHITE
     */
    @Test
    public void getColorForeground() {
        Assert.assertSame(status.getColorForeground(),Color.WHITE);
    }


    /**
     * get YoungStatus cell's background color
     * Input : void
     * Expected : return Color.BLUE
     */
    @Test
    public void getColorBackground() {
        Assert.assertSame(status.getColorBackground(),Color.BLUE);
    }
}
