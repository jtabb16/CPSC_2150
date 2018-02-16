package cpsc2150.labs.lab4;

/**
 * Sangram Kadam (sangrak)
 * Jack Tabb (jbtabb)
 * Lab 4
 * 2/12/2018
 * Kevin Plis
 */

/**
 * @invariant time >= 0 and totalDistance >= 0 and avgVelocity >= 0 and netDistance >= 0 and netVelocity >= 0 and
 *            Double.MIN_VALUE <= xInit <= Double.MAX_VALUE and  Double.MIN_VALUE <= yInit <= Double.MAX_VALUE and
 *            Double.MIN_VALUE <= xFinal <= Double.MAX_VALUE and  Double.MIN_VALUE <= yFinal <= Double.MAX_VALUE
 */
public class DirectionalSpeedster {

    private double time;
    private double totalDistance;
    private double avgVelocity;
    private double netDistance;
    private double netVelocity;
    private double xInit;
    private double yInit;
    private double xFinal;
    private double yFinal;

    /**
     *
     * @ensures     time = 0; and
                    totalDistance = 0 and
                    avgVelocity = 0 and
                    netDistance = 0 and
                    netVelocity = 0 and
                    xInit = 0 and
                    yInit = 0 and
                    xFinal = 0 and
                    yFinal = 0
     */
    public DirectionalSpeedster(){
        time = 0;
        totalDistance = 0;
        avgVelocity = 0;
        netDistance = 0;
        netVelocity = 0;
        xInit = 0;
        yInit = 0;
        xFinal = 0;
        yFinal = 0;
    }

    /**
     *
     * @param xChange is final - inital x value
     * @param yChange is final - inital y value
     * @param time amount of time taken for travel
     * @requires Double.MIN_VALUE <= xChange <= Double.MAX_VALUE and Double.MIN_VALUE <= yChange <= Double.MAX_VALUE
     *           and time > 0;
     * @ensures addTravel = sqrt(xChange^2 + yChange^2)
     */
    public void addTravel(double xChange, double yChange, double time){

        //formula to get total distance given distance travelled in x and y
        totalDistance += Math.sqrt(Math.pow(xChange, 2) + Math.pow(yChange, 2));
        xFinal += xChange;
        yFinal += yChange;
        this.time += time;
    }

    /**
     * @requires [the object that calls getTotalDistance is an instance of DirectionalSpeedster]
     * @ensures getTotalDistance = totalDistance
     * @return totalDistance
     */
    public double getTotalDistance(){

        return totalDistance;
    }
    /**
     * @requires [the object that calls getTotalTime is an instance of DirectionalSpeedster]
     * @ensures getTotalTime = time
     * @return time
     */
    public double getTotalTime(){

        return time;
    }
    /**
     * @requires [the object that calls getNetDistance is an instance of DirectionalSpeedster]
     * @ensures netDistance = sqrt((x final - x initial)^2 + (y final - y initial)^2)
     * @return netDistance
     */
    public double getNetDistance(){

        //formula to calculate distance with regards to final and initial positions
        netDistance = Math.sqrt(Math.pow(xFinal - 0, 2) + Math.pow(yFinal - 0, 2));

        return netDistance;
    }
    /**
     * @requires [the object that calls getAverageVelocity is an instance of DirectionalSpeedster]
     * @ensures average velocity = total distance / time
     * @return avgVelocity
     */
    public double getAverageVelocity(){

        //formula to calculate average velocity
        avgVelocity = totalDistance / time;

        return avgVelocity;
    }
    /**
     * @requires [the object that calls getNetVelocity is an instance of DirectionalSpeedster]
     * @ensures net velocity = net distance / time
     * @return netVelocity
     */
    public double getNetVelocity(){

        //formula for net distance to use in calculating netVelocity
        netDistance = Math.sqrt(Math.pow(xFinal - 0, 2) + Math.pow(yFinal - 0, 2));
        //formula to calculate net velocity
        netVelocity = netDistance / time;

        return netVelocity;
    }
}