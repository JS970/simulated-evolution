package org.woehlke.computer.kurzweil.simulated.evolution.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimulatedEvolutionParameterTest {
    public SimulatedEvolutionParameter param;
    @Before
    public void setup(){
        param = new SimulatedEvolutionParameter(1,2,true);
    }

    /**
     * Purpose : Test getter and setter
     * Expected : getter returns the value changed by the setter.
     */
    @Test
    public void getterSetterTest(){
        param.setFoodPerDay(5);
        param.setFoodPerDayGardenOfEden(4);
        param.setGardenOfEdenEnabled(false);
        Assert.assertEquals(5, param.getFoodPerDay());
        Assert.assertEquals(4, param.getFoodPerDayGardenOfEden());
        Assert.assertFalse(param.isGardenOfEdenEnabled());
    }

    /**
     * Purpose : To check increaseFoodPerDay increase foodperday value by 1
     * Expected : return (initialized value(1) + 1) = 2
     */
    @Test
    public void increaseFoodPerDay() {
        param.increaseFoodPerDay();
        Assert.assertEquals(2,param.getFoodPerDay());
    }

    /**
     * Purpose : To check increaseFoodPerDay decrease foodperday value by 1
     * Expected : return (initialized value(1) - 1) = 0
     */
    @Test
    public void decreaseFoodPerDay() {
        param.decreaseFoodPerDay();
        Assert.assertEquals(0, param.getFoodPerDay());
    }

    /**
     * Purpose : To check GardenOfEden is toggled by toggleGardenOfEden
     * Expected : return  !(initialized value) = false
     */
    @Test
    public void toggleGardenOfEden() {
        param.toggleGardenOfEden();
        Assert.assertFalse(param.isGardenOfEdenEnabled());
    }
}
