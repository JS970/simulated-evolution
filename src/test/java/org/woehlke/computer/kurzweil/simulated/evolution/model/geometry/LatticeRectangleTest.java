package org.woehlke.computer.kurzweil.simulated.evolution.model.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class LatticeRectangleTest {

    @Test
    public void of() throws Exception{
        //given
        LatticeRectangle rectangle;
        LatticePoint point = new LatticePoint(10,20);
        LatticeDimension dimension = new LatticeDimension(30,40);
        //when
        rectangle = LatticeRectangle.of(point, dimension);
        //then
        assertEquals(rectangle.getDimension().getWidth(), 30);
        assertEquals(rectangle.getDimension().getHeight(), 40);
        assertEquals(rectangle.getStart().getX(), 10);
        assertEquals(rectangle.getStart().getY(),20);
     }
    @Test
    public void testOf() {
        //given
        LatticeRectangle rectangle;
        int X = 10, Y=20, width= 50, height=60;
        //when
        rectangle = LatticeRectangle.of(X,Y,width,height);
        //then
        assertEquals(rectangle.getStart().getX(), X);
        assertEquals(rectangle.getStart().getY(), Y);
        assertEquals(rectangle.getDimension().getWidth(),width);
        assertEquals(rectangle.getDimension().getHeight(),height);
    }
}
