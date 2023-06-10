package org.woehlke.computer.kurzweil.simulated.evolution.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.cell.LifeCycleStatus;
import org.woehlke.computer.kurzweil.simulated.evolution.view.SimulatedEvolutionTab;
import org.woehlke.computer.kurzweil.simulated.evolution.view.census.CensusElement;

import java.util.Properties;


public class ComputerKurzweilPropertiesTest {

    private static ComputerKurzweilProperties properties;
    @BeforeClass
    public static void setup(){
        String configFileName = "application.yml";
        String jarFilePath = "target/simulatedevolution.jar";

        properties = ComputerKurzweilProperties.propertiesFactory(
            configFileName, jarFilePath
        );
    }
    @Test
    public void allinonTest(){
        ComputerKurzweilProperties.Allinone allinon = properties.getAllinone();
        Assert.assertEquals(640, allinon.getLattice().getWidth().intValue());
        Assert.assertEquals(400, allinon.getLattice().getHeight().intValue());

        Assert.assertEquals("Computer Kurzweil", allinon.getView().getTitle());
        Assert.assertEquals("Scientific Imfotainment", allinon.getView().getSubtitle());
        Assert.assertEquals("(c) 2020 Thomas Woehlke", allinon.getView().getCopyright());
        Assert.assertEquals(5, allinon.getView().getBorderPaddingX().intValue());
        Assert.assertEquals(5, allinon.getView().getBorderPaddingY().intValue());
        Assert.assertEquals(60, allinon.getView().getTitleHeight().intValue());
        Assert.assertEquals("Start / Stop", allinon.getView().getStartStopp());
        Assert.assertEquals("Start", allinon.getView().getStart());
        Assert.assertEquals("Stop", allinon.getView().getStop());
        Assert.assertEquals("Info", allinon.getView().getInfo());
    }
    @Test
    public void madelbrotTest(){
        ComputerKurzweilProperties.Mandelbrot mandelbrot = properties.getMandelbrot();
        Assert.assertEquals("Mandelbrot Set", mandelbrot.getView().getTitle());
        Assert.assertEquals("Fractal Mandelbrot Set drawn by a Turing Machine", mandelbrot.getView().getSubtitle());
        Assert.assertEquals("Zoom In", mandelbrot.getView().getButtonsZoom());
        Assert.assertEquals("Zoom Out", mandelbrot.getView().getButtonsZoomOut());
        Assert.assertEquals("Mandelbrot Set <-> Julia Set", mandelbrot.getView().getButtonsSwitch());
        Assert.assertEquals("Zoom", mandelbrot.getView().getButtonsZoomLabel());
        Assert.assertEquals("Choose Mouse Click Mode", mandelbrot.getView().getButtonsLabel());

        Assert.assertEquals(50, mandelbrot.getControl().getThreadSleepTime().intValue());

    }
    @Test
    public void simulatedEvolutionTest() {
        ComputerKurzweilProperties.SimulatedEvolution simulatedEvolution = properties.getSimulatedevolution();
        Assert.assertEquals("Simulated Evolution", simulatedEvolution.getView().getTitle());
        Assert.assertEquals("Artificial Life Simulation of Bacteria Motion depending on DNA", simulatedEvolution.getView().getSubtitle());
        Assert.assertEquals("(C) 2022 Thomas Woehlke", simulatedEvolution.getView().getCopyright());
        Assert.assertEquals(320, simulatedEvolution.getView().getWidth().intValue());
        Assert.assertEquals(234, simulatedEvolution.getView().getHeight().intValue());
        Assert.assertEquals(3, simulatedEvolution.getView().getScale().intValue());
        Assert.assertEquals(40, simulatedEvolution.getView().getHeightOfTitle().intValue());
        Assert.assertEquals(80, simulatedEvolution.getView().getHeightOfStatistics().intValue());
        Assert.assertEquals(120, simulatedEvolution.getView().getHeightOfStatisticsCanvas().intValue());

        Assert.assertEquals(100, simulatedEvolution.getControl().getThreadSleepTime().intValue());
        Assert.assertEquals(0, simulatedEvolution.getControl().getExitStatus().intValue());
        Assert.assertEquals(960, simulatedEvolution.getControl().getQueueMaxLength().intValue());

        Assert.assertEquals(2000, simulatedEvolution.getCellConf().getFatMax().intValue());
        Assert.assertEquals(1000, simulatedEvolution.getCellConf().getFatHungerMax().intValue());
        Assert.assertEquals(800, simulatedEvolution.getCellConf().getFatMinimumForSex().intValue());
        Assert.assertEquals(500, simulatedEvolution.getCellConf().getFatAtBirth().intValue());
        Assert.assertEquals(25, simulatedEvolution.getCellConf().getFatPerFood().intValue());
        Assert.assertEquals(200, simulatedEvolution.getCellConf().getAgeOfAdulthood().intValue());
        Assert.assertEquals(800, simulatedEvolution.getCellConf().getAgeOld().intValue());
        Assert.assertEquals(1000, simulatedEvolution.getCellConf().getAgeMax().intValue());

        Assert.assertEquals(20, simulatedEvolution.getPopulation().getInitialPopulation().intValue());
        Assert.assertEquals("Statistics", simulatedEvolution.getPopulation().getPanelPopulationStatistics());
        Assert.assertEquals("young", simulatedEvolution.getPopulation().getYoungCellsLabel());
        Assert.assertEquals("fat", simulatedEvolution.getPopulation().getYoungAndFatCellsLabel());
        Assert.assertEquals("adult", simulatedEvolution.getPopulation().getFullAgeCellsLabel());
        Assert.assertEquals("hungry", simulatedEvolution.getPopulation().getHungryCellsLabel());
        Assert.assertEquals("old", simulatedEvolution.getPopulation().getOldCellsLabel());
        Assert.assertEquals("all", simulatedEvolution.getPopulation().getPopulationLabel());
        Assert.assertEquals("world age", simulatedEvolution.getPopulation().getWorldIterationLabel());
        Assert.assertEquals("oldest Generation", simulatedEvolution.getPopulation().getGenerationOldestLabel());
        Assert.assertEquals("youngest Generation", simulatedEvolution.getPopulation().getGenerationYoungestLabel());

        Assert.assertEquals(20, simulatedEvolution.getFood().getFoodPerDay().intValue());
        Assert.assertEquals(3, simulatedEvolution.getFood().getFoodPerDayFieldColumns().intValue());
        Assert.assertEquals("Food per Day:", simulatedEvolution.getFood().getFoodPerDayLabel());
        Assert.assertEquals("Food per Day:", simulatedEvolution.getFood().getFoodPerDayBorderLabel());
        Assert.assertEquals("+", simulatedEvolution.getFood().getButtonFoodPerDayIncrease());
        Assert.assertEquals("-", simulatedEvolution.getFood().getButtonFoodPerDayDecrease());
        Assert.assertEquals("Food", simulatedEvolution.getFood().getPanelFood());

        Assert.assertTrue(simulatedEvolution.getGardenOfEden().getGardenOfEdenEnabled());
        Assert.assertEquals("enabled", simulatedEvolution.getGardenOfEden().getGardenOfEdenEnabledString());
        Assert.assertEquals("Change", simulatedEvolution.getGardenOfEden().getGardenOfEdenEnabledToggleButton());
        Assert.assertEquals(80, simulatedEvolution.getGardenOfEden().getFoodPerDay().intValue());
        Assert.assertEquals(5, simulatedEvolution.getGardenOfEden().getGardenOfEdenLatticeDivisor().intValue());
        Assert.assertEquals(2, simulatedEvolution.getGardenOfEden().getGardenOfEdenLatticeDivisorPadding().intValue());
        Assert.assertEquals("Garden of Eden", simulatedEvolution.getGardenOfEden().getPanelGardenOfEden());

    }

    @Test
    public void CcaTest() {
        ComputerKurzweilProperties.Cca Cca = properties.getCca();
        Assert.assertEquals("Cyclic Cellular Automaton", Cca.getView().getTitle());
        Assert.assertEquals("Cyclic Cellular Automaton", Cca.getView().getSubtitle());

        Assert.assertEquals("Neighborhood", Cca.getView().getNeighborhood().getTitle());
        Assert.assertEquals("Von Neumann", Cca.getView().getNeighborhood().getTypeVonNeumann());
        Assert.assertEquals("Moore", Cca.getView().getNeighborhood().getTypeMoore());
        Assert.assertEquals("Woehlke", Cca.getView().getNeighborhood().getTypeWoehlke());

        Assert.assertEquals(100, Cca.getControl().getThreadSleepTime().intValue());
    }

    @Test
    public void randomWalkTest() {
        ComputerKurzweilProperties.WienerProcess randomWalk = properties.getRandomwalk();
        Assert.assertEquals("Random Walk", randomWalk.getView().getTitle());
        Assert.assertEquals("Brownian Motion by Fractal Random Walk", randomWalk.getView().getSubtitle());

        Assert.assertEquals(100, randomWalk.getControl().getThreadSleepTime().intValue());
    }

    @Test
    public void dlaTest() {
        ComputerKurzweilProperties.Dla dla = properties.getDla();
        Assert.assertEquals("Diffusion Limited Aggregation", dla.getView().getTitle());
        Assert.assertEquals("Fractal Random Walk due to Brownian Motion Cluster", dla.getView().getSubtitle());

        Assert.assertEquals(50, dla.getControl().getThreadSleepTime().intValue());
        Assert.assertEquals(30000, dla.getControl().getNumberOfParticles().intValue());
    }

    @Test
    public void kochSnowflakeTest() {
        ComputerKurzweilProperties.Kochsnowflake kochSnowflake = properties.getKochsnowflake();
        Assert.assertEquals("Koch Snowflake", kochSnowflake.getView().getTitle());
        Assert.assertEquals("Fractal Koch Snowflake", kochSnowflake.getView().getSubtitle());

        Assert.assertEquals("Neighborhood", kochSnowflake.getView().getNeighborhood().getTitle());
        Assert.assertEquals("Von Neumann", kochSnowflake.getView().getNeighborhood().getTypeVonNeumann());
        Assert.assertEquals("Moore", kochSnowflake.getView().getNeighborhood().getTypeMoore());
        Assert.assertEquals("Woehlke", kochSnowflake.getView().getNeighborhood().getTypeWoehlke());

        Assert.assertEquals(50, kochSnowflake.getControl().getThreadSleepTime().intValue());
        Assert.assertEquals(30000, kochSnowflake.getControl().getNumberOfParticles().intValue());
    }

    @Test
    public void sameGameTest() {
        ComputerKurzweilProperties.Samegame sameGame = properties.getSamegame();
        Assert.assertEquals("Same Game", sameGame.getView().getTitle());
        Assert.assertEquals("Play the Same Game", sameGame.getView().getSubtitle());

        Assert.assertEquals("Neighborhood", sameGame.getView().getNeighborhood().getTitle());
        Assert.assertEquals("Von Neumann", sameGame.getView().getNeighborhood().getTypeVonNeumann());
        Assert.assertEquals("Moore", sameGame.getView().getNeighborhood().getTypeMoore());
        Assert.assertEquals("Woehlke", sameGame.getView().getNeighborhood().getTypeWoehlke());

        Assert.assertEquals(50, sameGame.getControl().getThreadSleepTime().intValue());
        Assert.assertEquals(30000, sameGame.getControl().getNumberOfParticles().intValue());
    }

    @Test
    public void sierpinskiTriangleTest() {
        ComputerKurzweilProperties.Sierpinskitriangle sierpinskiTriangle = properties.getSierpinskitriangle();
        Assert.assertEquals("Sierpinski Triangle", sierpinskiTriangle.getView().getTitle());
        Assert.assertEquals("Fractal Sierpinski Triangle", sierpinskiTriangle.getView().getSubtitle());

        Assert.assertEquals("Neighborhood", sierpinskiTriangle.getView().getNeighborhood().getTitle());
        Assert.assertEquals("Von Neumann", sierpinskiTriangle.getView().getNeighborhood().getTypeVonNeumann());
        Assert.assertEquals("Moore", sierpinskiTriangle.getView().getNeighborhood().getTypeMoore());
        Assert.assertEquals("Woehlke", sierpinskiTriangle.getView().getNeighborhood().getTypeWoehlke());

        Assert.assertEquals(50, sierpinskiTriangle.getControl().getThreadSleepTime().intValue());
        Assert.assertEquals(30000, sierpinskiTriangle.getControl().getNumberOfParticles().intValue());

    }

    @Test
    public void tetrisTest() {
        ComputerKurzweilProperties.Tetris tetris = properties.getTetris();
        Assert.assertEquals("Tetris", tetris.getView().getTitle());
        Assert.assertEquals("Play Tetris", tetris.getView().getSubtitle());

        Assert.assertEquals("Neighborhood", tetris.getView().getNeighborhood().getTitle());
        Assert.assertEquals("Von Neumann", tetris.getView().getNeighborhood().getTypeVonNeumann());
        Assert.assertEquals("Moore", tetris.getView().getNeighborhood().getTypeMoore());
        Assert.assertEquals("Woehlke", tetris.getView().getNeighborhood().getTypeWoehlke());

        Assert.assertEquals(50, tetris.getControl().getThreadSleepTime().intValue());
        Assert.assertEquals(30000, tetris.getControl().getNumberOfParticles().intValue());
    }

    @Test
    public void turmiteTest() {
        ComputerKurzweilProperties.Turmite turmite = properties.getTurmite();
        Assert.assertEquals("Turmite", turmite.getView().getTitle());
        Assert.assertEquals("Termites as Turing Machines with 2D Tape", turmite.getView().getSubtitle());

        Assert.assertEquals("Neighborhood", turmite.getView().getNeighborhood().getTitle());
        Assert.assertEquals("Von Neumann", turmite.getView().getNeighborhood().getTypeVonNeumann());
        Assert.assertEquals("Moore", turmite.getView().getNeighborhood().getTypeMoore());
        Assert.assertEquals("Woehlke", turmite.getView().getNeighborhood().getTypeWoehlke());

        Assert.assertEquals(50, turmite.getControl().getThreadSleepTime().intValue());
        Assert.assertEquals(30000, turmite.getControl().getNumberOfParticles().intValue());
    }
    @Test
    public void watorTest() {
        ComputerKurzweilProperties.Wator wator = properties.getWator();
        Assert.assertEquals("WaTor", wator.getView().getTitle());
        Assert.assertEquals("Population Dynamics on Planet Water Torus", wator.getView().getSubtitle());

        Assert.assertEquals("Neighborhood", wator.getView().getNeighborhood().getTitle());
        Assert.assertEquals("Von Neumann", wator.getView().getNeighborhood().getTypeVonNeumann());
        Assert.assertEquals("Moore", wator.getView().getNeighborhood().getTypeMoore());
        Assert.assertEquals("Woehlke", wator.getView().getNeighborhood().getTypeWoehlke());

        Assert.assertEquals(50, wator.getControl().getThreadSleepTime().intValue());
        Assert.assertEquals(30000, wator.getControl().getNumberOfParticles().intValue());
    }
    @Test
    public void gameofliveTest() {
        ComputerKurzweilProperties.Gameoflive gameoflive = properties.getGameoflive();
        Assert.assertEquals("Conways Game of Life", gameoflive.getView().getTitle());
        Assert.assertEquals("Conways Game of Life Cellular Automaton", gameoflive.getView().getSubtitle());

        Assert.assertEquals("Neighborhood", gameoflive.getView().getNeighborhood().getTitle());
        Assert.assertEquals("Von Neumann", gameoflive.getView().getNeighborhood().getTypeVonNeumann());
        Assert.assertEquals("Moore", gameoflive.getView().getNeighborhood().getTypeMoore());
        Assert.assertEquals("Woehlke", gameoflive.getView().getNeighborhood().getTypeWoehlke());

        Assert.assertEquals(50, gameoflive.getControl().getThreadSleepTime().intValue());
        Assert.assertEquals(30000, gameoflive.getControl().getNumberOfParticles().intValue());
    }




}

