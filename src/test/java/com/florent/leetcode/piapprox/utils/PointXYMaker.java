package com.florent.leetcode.piapprox.utils;

import com.florent.leetcode.piapprox.PointXY;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class PointXYMaker {

    public static PointXY[] makeRandomPointXYArray(int quantityOfPoints) {
        var points = new PointXY[quantityOfPoints];
        for (int index = 0; index < points.length; index++) {
            points[index] = makeRandomPointXY();
        }
        return points;
    }

    private static PointXY makeRandomPointXY() {
        return new PointXY(Math.random(), Math.random());
    }


}
