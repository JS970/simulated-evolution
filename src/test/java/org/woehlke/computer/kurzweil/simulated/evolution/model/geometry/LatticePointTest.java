package org.woehlke.computer.kurzweil.simulated.evolution.model.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LatticePointTest {

    @Test
    public void LatticePointConstructor(){
        //given
        LatticePoint param  = new LatticePoint(10, -10);
        //when
        LatticePoint target = new LatticePoint(param);
        //then
        assertEquals(target.getX(), 10);
        assertEquals(target.getY(), -10);
     }

     @Test
     public void makePositive(){
         //given
         LatticePoint point = new LatticePoint(-10, -20);
         LatticePoint point2 = new LatticePoint(100, 200);
         point2.setX(-30);
         point2.setY(-50);

         //when
         point.makePositive();
         point2.makePositive();
         //then
         assertEquals(point.getX(), 10);
         assertEquals(point.getY(), 20);
         assertEquals(point2.getX(),30);
         assertEquals(point2.getY(), 50);
      }

      @Test
      public void addAndAbsolute() {
          //given
          LatticePoint lhs = new LatticePoint(-20, -30);
          LatticePoint rhs = new LatticePoint(-40, -70);
          //when
          lhs.addAndAbsolute(rhs);
          //then
          assertEquals(lhs.getX(), 60);
          assertEquals(lhs.getY(), 100);
       }

       @Test
       public void add() {
           //given
           LatticePoint lhs1 = new LatticePoint(10, 20);
           LatticePoint rhs1= new LatticePoint(30, 50);
           LatticePoint lhs2 = new LatticePoint(-20, -50);
           LatticePoint rhs2 = new LatticePoint(-30, -50);
           //when
           lhs1.add(rhs1);
           lhs2.add(rhs2);
           //then
           assertEquals(lhs1.getX(), 40);
           assertEquals(lhs1.getY(), 70);
           assertEquals(lhs2.getX(), -50);
           assertEquals(lhs2.getY(), -100);
        }

        @Test
        public void normalize(){
            //given
            LatticePoint lhs = new LatticePoint(100 , 100);
            LatticePoint rhs = new LatticePoint(10 , 10);
            LatticePoint lhs2 = new LatticePoint(0,100);
            LatticePoint rhs2 = new LatticePoint(100, 100);
            //when
            rhs.normalize(lhs);
            //then
            assertEquals(rhs.getX(), 10);
            assertEquals(rhs.getY(),10 );
            Assertions.assertThrows(ArithmeticException.class, ()->{
                rhs2.normalize(lhs2);
            });
    }

    @Test
    public void copy(){
        //given
        LatticePoint point = new LatticePoint(123, 456);
        LatticePoint clone;
        //when
        clone = point.copy();
        //then
        assertEquals(clone.getX(),123);
        assertEquals(clone.getY(),456);
     }

     @Test
     public void toLatticePoint() throws Exception{
         //given
         LatticePoint point = new LatticePoint(77,66);
         LatticeDimension dimension;
         //when
         dimension = point.toLatticePoint();
         //then
         assertEquals(dimension.getWidth(), 77);
         assertEquals(dimension.getHeight(), 66);
      }

      @Test
      public void of(){
          //given
          LatticePoint point = new LatticePoint();
          LatticeDimension dimension = new LatticeDimension(72,35);
          //when
          point = LatticePoint.of(dimension);
          //then
          assertEquals(point.getX(), 72);
          assertEquals(point.getY(), 35);
       }

       @Test
       public void getNeighbourhood() {
           //given
           LatticePoint target = new LatticePoint(15, 65);
           LatticePoint param = new LatticePoint(15, 32);
           //when
           LatticePoint[] result = target.getNeighbourhood(param);
           //then
           assertEquals(result[0].getX(), 14);
           assertEquals(result[0].getY(), 0);
           assertEquals(result[1].getX(), 14);
           assertEquals(result[1].getY(), 1);
           assertEquals(result[2].getX(), 14);
           assertEquals(result[2].getY(), 2);
           assertEquals(result[3].getX(), 0);
           assertEquals(result[3].getY(), 0);
           assertEquals(result[4].getX(), 0);
           assertEquals(result[4].getY(), 1);
           assertEquals(result[5].getX(), 0);
           assertEquals(result[5].getY(),2);
           assertEquals(result[6].getX(), 1);
           assertEquals(result[6].getY(), 0);
           assertEquals(result[7].getX(), 1);
           assertEquals(result[7].getY(), 1);
           assertEquals(result[8].getX(), 1);
           assertEquals(result[8].getY(), 2);
           Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () ->{
               assertEquals(result[9].getY(), 0);
           });

       }
}
