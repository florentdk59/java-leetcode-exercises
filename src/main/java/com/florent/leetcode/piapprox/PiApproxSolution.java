package com.florent.leetcode.piapprox;

import java.util.Arrays;

/**
 * PointXY represents a pair of random X-Y coordinates, such as 0 < x <= 1 and 0 < y <= 1.
 * You have a 2D grid, with an x-axis, and a y-axis.
 * On the grid, there is circle centered on x=0 y=0, with a radius of 1.
 * This results in quarter of circle, located on the portion of the grid with positive coordinates.
 * We know that the probability of any random PointXY being located in that quarter of a circle is actually PI / 4.
 * You get a list of several coordinates (PointXY).
 * Using the list of PointXY, calculate an approximation of PI.
 */
public class PiApproxSolution {

    public double piApprox(PointXY[] points) {
        // the equation for PROBABILITY (of being in the quarter of a circle) is x² + y² <= 1 (based on the Monte Carlo estimation)
        long quantityOfPointsInsideQuarterCircle = Arrays.stream(points)
                .map(point -> Math.pow(point.x(), 2) + Math.pow(point.y(), 2))
                .filter(area -> area <= 1)
                .count();

        // actual statistics for our list of points
        double statisticalProbability = (double) quantityOfPointsInsideQuarterCircle / points.length;

        // PROBABILITY = PI / 4
        // -> the solution is PROBABILITY times 4
        return statisticalProbability * 4;
    }


}
