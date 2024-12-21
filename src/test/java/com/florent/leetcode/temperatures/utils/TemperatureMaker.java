package com.florent.leetcode.temperatures.utils;


import lombok.experimental.UtilityClass;

@UtilityClass
public class TemperatureMaker {

    public static int[] fillWithRandomTemperatures(final int[] intArray, final int forbiddenLowest) {
        for (var index = 0; index < intArray.length; index++) {
            int temperature = 0;
            while(temperature == 0 || Math.abs(temperature) <= Math.abs(forbiddenLowest)) {
                temperature = makeRandomTemperature(25);
            }
            intArray[index] = temperature;
        }
        // inserting lowest value
        intArray[(int) (Math.random() * intArray.length)] = forbiddenLowest;
        return intArray;
    }

    public static int makeRandomTemperature(int maxTemp) {
        var temp = (int) (Math.random() * maxTemp);
        var positive = Math.random() > 0.5;
        return positive ? temp : -temp;
    }
}
