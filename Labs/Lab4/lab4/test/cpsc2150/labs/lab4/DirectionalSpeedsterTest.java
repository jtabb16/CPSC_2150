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
    public void testaddTravel_xNeg_yNeg_timePos(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(-3,-4,1);
        assertTrue(s.getTotalDistance() == 5);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test for positive x and y values (equivalnce tetsing)
    public void testaddTravel_xPos_yPos_timePos(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(6,8,1);
        assertTrue(s.getTotalDistance() == 10);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test when x and y are 0 (boundary tetsing)
    public void testaddTravel_x0_y0_time1(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(0,0,1);
        assertTrue(s.getTotalDistance() == 0);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test for positive x and negative y values (equivalnce tetsing)
    public void testaddTravel_xPos_yNeg_time1(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(6,-8,1);
        assertTrue(s.getTotalDistance() == 10);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test for negative x values and positive y values (equivalnce tetsing)
    public void testaddTravel_xNeg_yPos_timePos(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(-6,8,1);
        assertTrue(s.getTotalDistance() == 10);
        assertTrue(s.getTotalTime() == 1);
    }
    @Test
    //chose this to test for complex x and y values (challenge tetsing)
    public void testaddTravel_x13dot5_y63dot2_timePos(){
        DirectionalSpeedster s = new DirectionalSpeedster();

        s.addTravel(13.5,63.2,1);
        assertEquals(s.getTotalDistance(), 64.62576885, 0.00000001);
        assertTrue(s.getTotalTime() == 1);
    }

}

