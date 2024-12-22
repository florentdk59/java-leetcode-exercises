package com.florent.leetcode.piapprox;

import com.florent.leetcode.piapprox.utils.PointXYMaker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@Slf4j
public class PiApproxSolutionTest {

    private PiApproxSolution solution;

    @BeforeEach
    void setup() {
        solution = new PiApproxSolution();
    }

    @Nested
    class PiApprox {

        @ParameterizedTest
        @CsvSource({
                "1000, 0.2",
                "100000, 0.02",
                "10000000, 0.002"
        })
        void shouldApproximatePiUsingPointsXY(int quantityOfPoints, double acceptableMarginOfError) {
            var points = PointXYMaker.makeRandomPointXYArray(quantityOfPoints);

            var result = solution.piApprox(points);

            log.info("shouldApproximatePiUsingPointsXY : quantityOfPoints({}) -> {}", quantityOfPoints, result);
            assertThat(result).isEqualTo(Math.PI, within(acceptableMarginOfError));
        }


    }


}
