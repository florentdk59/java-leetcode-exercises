package com.florent.leetcode.temperatures;

/**
 * There is a list of random temperatures.
 * Temperatures can be negative, or positive.
 * Search the list and return the one temperature that is a close to zero as possible.
 * If two values are both equally closest to zero, return the positive one.
 * The list will never have more than 10000 values.
 * If the list is actually empty, return 0.
 */
public class TemperaturesSolution {

    public int computeClosestToZero(int[] ts) {

        if (ts == null || ts.length == 0) {
            return 0;
        }

        int savedTemperature = ts[0];
        for (final int temperature : ts) {

            if (temperature != savedTemperature) {
                final int absoluteTemp = Math.abs(temperature);
                final int absoluteSavedTemp = Math.abs(savedTemperature);

                if (absoluteTemp < absoluteSavedTemp
                    || (absoluteSavedTemp == absoluteTemp && temperature > savedTemperature)) {
                    savedTemperature = temperature;
                }
            }

        }

        return savedTemperature;
    }


}
