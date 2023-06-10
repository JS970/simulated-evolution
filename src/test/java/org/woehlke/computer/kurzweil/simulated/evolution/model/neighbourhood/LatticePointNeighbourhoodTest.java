package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.runtime.callsite.PogoInterceptableSite;
import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.geometry.LatticePoint;

import static org.junit.Assert.*;
import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodType.*;


@Slf4j
public class LatticePointNeighbourhoodTest {

    @Test
    public void LatticePointNeighbourhood() throws Exception{
        //given
        int x = 100, y= 200, maxX= 200, maxY= 230;
        LatticePoint[] vonNeumannPoints = {new LatticePoint(100,199),
            new LatticePoint(101,200),
            new LatticePoint(100,201),
            new LatticePoint(99,200)};

        LatticePoint[] moorePoints = { new LatticePoint(99,199),
            new LatticePoint(100,199),
            new LatticePoint(101,199),
            new LatticePoint(101, 200),
            new LatticePoint(101,201),
            new LatticePoint(100, 201),
            new LatticePoint(99,201),
            new LatticePoint(99,200)};

        LatticePoint[] userDefinePoints = { new LatticePoint(99, 199),
            new LatticePoint(100, 199),
            new LatticePoint(101, 199),
            new LatticePoint(101, 200),
            new LatticePoint(99, 201),
            new LatticePoint(99, 200)};
        //when
        LatticePointNeighbourhood vonNeumannNeighbourhood = new LatticePointNeighbourhood(maxX, maxY, x, y, VON_NEUMANN_NEIGHBORHOOD);
        LatticePointNeighbourhood mooreNeighbourhood = new LatticePointNeighbourhood(maxX, maxY, x, y, MOORE_NEIGHBORHOOD);
        LatticePointNeighbourhood userDefineNeighbourhood = new LatticePointNeighbourhood(maxX, maxY, x ,y, USER_DEFINE_NEIGHBORHOOD);
        //then
        assertEquals(vonNeumannNeighbourhood.getNeighbourhood().length,  4);
        assertEquals(mooreNeighbourhood.getNeighbourhood().length, 8);
        assertEquals(userDefineNeighbourhood.getNeighbourhood().length , 6);

        assertTrue(checkElementEquals(vonNeumannNeighbourhood.getNeighbourhood(), vonNeumannPoints));
        assertTrue(checkElementEquals(mooreNeighbourhood.getNeighbourhood(), moorePoints));
        assertTrue(checkElementEquals(userDefineNeighbourhood.getNeighbourhood(), userDefinePoints));
     }


    @Test
    public void get() throws Exception{
        //given
        int maxX = 10, maxY =30, worldX = 50, worldY= 70;
        LatticePoint[] expectValues = {new LatticePoint(9, 29),
            new LatticePoint(10, 29),
            new LatticePoint(11, 29),
            new LatticePoint(11,30),
            new LatticePoint(11, 31),
            new LatticePoint(10, 31),
            new LatticePoint(9, 31),
            new LatticePoint(9, 30)};
        //when
        LatticePoint[] points = LatticePointNeighbourhood.get(worldX, worldY, maxX, maxY);
        //then
        assertEquals(points.length, expectValues.length);
        assertTrue(checkElementEquals(points, expectValues));
    }

     private void printTest(LatticePoint[] source){
         for (LatticePoint point : source) {
             log.info("point[x]: {}", point.getX());
             log.info("point[y]: {}", point.getY());
             System.out.println("point[x]: {}"+ point.getX());
             System.out.println("point[y]: {}"+ point.getY());
         }

     }
     private boolean checkElementEquals(LatticePoint[] target, LatticePoint[] expect){
        for(int i =0 ; i < target.length; i++){
            if(target[i].getX() != expect[i].getX()) return false;
            if(target[i].getY() != expect[i].getY()) return false;
        }
        return true;
     }



}
