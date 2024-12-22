package com.florent.leetcode.temperatures;


import com.florent.leetcode.temperatures.utils.TemperatureMaker;
import com.florent.leetcode.utils.ParameterizedIntList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class TemperaturesSolutionTest {

    private TemperaturesSolution solution;

    @BeforeEach
    void setup() {
        solution = new TemperaturesSolution();
    }

    @Nested
    class ComputeClosestToZero {

        @ParameterizedTest
        @CsvSource({
                "7_-10_13_8_4_-7_-12_-3_3_-9_6_-1_-6_7, -1",
                "-5_-4_-3_-2_2_3_4_5, 2",
                "-5_-4_-3_-2_3_4_5, -2",
                "-5_-4_-3_-2_0_2_3_4_5, 0",
                "0, 0"
        })
        void shouldFindTemperatureClosestToZero(ParameterizedIntList temperatures, int expectedTemperature) {
            int[] temperatureArray = temperatures.getValues().stream().mapToInt(Integer::intValue).toArray();

            var result = solution.computeClosestToZero(temperatureArray);

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
