package cpsc2150.labs.lab4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * Lab 4
 * 2/12/2018
 * Kevin Plis
 */

public class DirectionalSpeedsterTest {

    @Test
    //tests the constructor: all values should be 0
    public void testConstructor()
    {
        DirectionalSpeedster s = new DirectionalSpeedster ();

        assertTrue(s.getTotalDistance() == 0);
        assertTrue(s.getNetDistance() == 0);
        assertTrue(s.getTotalTime() == 0);

        //testing current position by assuming correct output from known values
        s.addTravel(3,4, 1);
        assertTrue(s.getNetDistance() == 5);

    }
    @Test
    //testing negative x and y values (equivalence testing)
    public void testaddTravel_xNeg_yNeg_timePos(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(-3,-4,1);
        assertTrue(s.getTotalDistance() == 5);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test for positive x and y values (equivalence testing)
    public void testaddTravel_xPos_yPos_timePos(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(6,8,1);
        assertTrue(s.getTotalDistance() == 10);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test when x and y are 0 (boundary testing)
    public void testaddTravel_x0_y0_time1(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(0,0,1);
        assertTrue(s.getTotalDistance() == 0);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test for positive x and negative y values (equivalence testing)
    public void testaddTravel_xPos_yNeg_time1(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(6,-8,1);
        assertTrue(s.getTotalDistance() == 10);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test for negative x values and positive y values (equivalence testing)
    public void testaddTravel_xNeg_yPos_timePos(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(-6,8,1);
        assertTrue(s.getTotalDistance() == 10);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test for complex x and y values (challenge testing)
    public void testaddTravel_x13dot5_y63dot2_timePos(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(13.5,63.2,1);
        assertEquals(s.getTotalDistance(), 64.62576885, 0.00000001);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this test when x and y are positive (equivalence testing)
    public void testgetNetDistance_xPos_yPos(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,2,1);
        assertEquals(s.getNetDistance(),2.828427,0.000001);
    }
    @Test
    //chose this test when x and y are negative values (equivalence testing)
    public void testgetNetDistance_xNeg_yNeg(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(-2,-2,1);
        assertEquals(s.getNetDistance(),2.828427,0.000001);
    }
    @Test
    //chose this test when x is a positive value and y is negative (equivalence testing)
    public void testgetNetDistance_xPos_yNeg(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,-2,1);
        assertEquals(s.getNetDistance(),2.828427,0.000001);
    }
    @Test
    //chose this test when x is a negative value and y is positive (equivalence testing)
    public void testgetNetDistance_xNeg_yPos(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(-2,2,1);
        assertEquals(s.getNetDistance(),2.828427,0.000001);
    }
    @Test
    //chose this test to test when x is positive and y is positive, and then add travel is called on negative and
    //positive values
    //also tests boundary (0)
    public void testgetNetDistance_xPosNeg0_yNegPos0(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,-2,1);
        s.addTravel(-2,2,1);
        s.addTravel(0,0,1);

        assertEquals(s.getNetDistance(),0,0.000001);
    }
    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when time is a small integer and x and y are positive values (boundary testing)
    public void getAverageVelocity_xPos_yPos_timeSmall(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,2,2);
        assertEquals(s.getAverageVelocity(),1.414213, 0.000001);
    }
    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when time is a large integer and x and y are positive values (boundary testing)
    public void getAverageVelocity_xPos_yPos_timeLarge(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,2,20000);
        assertEquals(s.getAverageVelocity(),0.000141, 0.000001);
    }
    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when time is a double and x and y are positive values (complex testing)
    public void getAverageVelocity_xPos_yPos_timeDouble(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,2,6.9);
        assertEquals(s.getAverageVelocity(),0.409916, 0.000001);
    }
    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when addTravel is called multiple times with multiple x, y, and multiple time values to test for average
    public void getAverageVelocity_totalDistanceMultiple_timeMultiple(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,-2,2);
        s.addTravel(-8,6,4);
        s.addTravel(4,2,1);
        assertEquals(s.getAverageVelocity(), 2.471509, 0.000001);
    }
    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when addTravel is called multiple times with x and y as 0 and multiple values for time (boundary)
    public void getAverageVelocity_totalDistance0_timeMultiple(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(0,0,2);
        s.addTravel(0,0,4);
        s.addTravel(0,0,1);
        assertEquals(s.getAverageVelocity(), 0, 0.000001);
    }

    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when time is a small integer
    public void getNetVelocity_xPos_yPos_timeSmall(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,2,2);
        assertEquals(s.getNetVelocity(),1.414213, 0.000001);
    }
    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when time is a large integer
    public void getNetVelocity_xPos_yPos_timeLarge(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,2,20000);
        assertEquals(s.getNetVelocity(),0.000141, 0.000001);
    }
    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when time is a double and when adding a positive x and negative y value then adding a negative and
    //positive y value to account for "net" velocity
    public void getNetVelocity_xPosNeg_yNegPos_timeDouble(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,-2,6.9);
        s.addTravel(-2,2,6.9);
        assertEquals(s.getNetVelocity(),0, 0.000001);
    }
    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when addTravel is called multiple times with different x, y, and time values to test for average
    public void getNetVelocity_totalDistanceMultiple_timeMultiple(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(2,-2,2);
        s.addTravel(-8,6,4);
        s.addTravel(4,2,1);
        assertEquals(s.getNetVelocity(), 0.903507, 0.000001);
    }
    @Test
    //don't have to test negative time as invariant dictates time >= 0
    //requires clause for addTravel dictates time > 0
    //testing when addTravel is called multiple times with x and y being 0 and multiple time values to test for average
    public void getNetVelocity_totalDistance0_timeMultiple(){

        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(0,0,2);
        s.addTravel(0,0,4);
        s.addTravel(0,0,1);
        assertEquals(s.getNetVelocity(), 0, 0.000001);
    }
}