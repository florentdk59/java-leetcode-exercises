package com.florent.leetcode.temperatures;


import com.florent.leetcode.temperatures.utils.TemperatureMaker;
import com.florent.leetcode.utils.ParameterizedIntList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class TemperaturesSolutionTest {

    @Nested
    class ComputeClosestToZero {

        @ParameterizedTest
        @CsvSource(delimiter = ';', value = {
                "7,-10,13,8,4,-7,-12,-3,3,-9,6,-1,-6,7; -1",
                "-5,-4,-3,-2,2,3,4,5; 2",
                "-5,-4,-3,-2,3,4,5; -2",
                "-5,-4,-3,-2,0,2,3,4,5; 0",
                "0; 0"
        })
        void shouldFindTemperatureClosestToZero(ParameterizedIntList temperatures, int expectedTemperature) {
            int[] temperatureArray = temperatures.getValues().stream().mapToInt(Integer::intValue).toArray();

            var result = new TemperaturesSolution().computeClosestToZero(temperatureArray);

            log.info("shouldFindTemperatureClosestToZero [{}] -> {}", temperatures, result);
            assertThat(result).isEqualTo(expectedTemperature);
        }


    }

    @Nested
    class ComputeClosestToZeroPerformance {

        private static int[] largeArray = null;
        private static int closestExpected = 0;
        @BeforeAll
        static void setup() {
            closestExpected = TemperatureMaker.makeRandomTemperature(3);
            largeArray = TemperatureMaker.fillWithRandomTemperatures(new int[1000000], closestExpected);
        }

        @Test
        @Timeout(value = 1, unit = TimeUnit.SECONDS)
        void shouldFindTemperatureClosestToZero() {
            log.info("shouldFindTemperatureClosestToZero int[{}] expected {}", largeArray.length, closestExpected);

            var result = new TemperaturesSolution().computeClosestToZero(largeArray);

            log.info("shouldFindTemperatureClosestToZero found -> {}", result);
            assertThat(result).isEqualTo(closestExpected);
        }
    }
}
