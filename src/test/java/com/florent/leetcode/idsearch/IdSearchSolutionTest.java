package com.florent.leetcode.idsearch;

import com.florent.leetcode.idsearch.utils.CustomerMaker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class IdSearchSolutionTest {

    @Nested
    class SearchId {

        private static final Customer[] CUSTOMERS = new Customer[] {
                new Customer(1000, "Jacques"),
                new Customer(2000, "Pierre"),
                new Customer(3000, "Paul"),
                new Customer(4000, "John"),
                new Customer(5000, "Said"),
                new Customer(6000, "Charles"),
                new Customer(7000, "Jeffrey"),
                new Customer(8000, "Richard"),
                new Customer(9000, "Joey"),
                new Customer(1654, "Pauline"),
                new Customer(2798, "Natasha"),
                new Customer(3012, "Julie"),
                new Customer(4117, "Jane"),
                new Customer(5987, "Sarah"),
                new Customer(6483, "Claire"),
                new Customer(7298, "Jennifer"),
                new Customer(8678, "Rachel"),
                new Customer(9700, "Gina"),
        };

        @Test
        void shouldFindCustomerId() {
            var result = new IdSearchSolution().searchId(CUSTOMERS, 4117);

            assertThat(result).isTrue();
        }

        @Test
        void shouldNotFindCustomerId() {
            var result = new IdSearchSolution().searchId(CUSTOMERS, 123456789L);

            assertThat(result).isFalse();
        }

    }

    @Nested
    class SearchIdPerformance {

        private static Customer[] largeArray = null;

        @BeforeAll
        static void setup() {
            largeArray = CustomerMaker.makeRandomCustomerArray(1000000);
        }


        @Test
        @Timeout(value = 1, unit = TimeUnit.SECONDS)
        void shouldFindCustomerIdForVeryLargeArray() {
            var existingCustomerId = largeArray[14].id();

            var result = new IdSearchSolution().searchId(largeArray, existingCustomerId);
            assertThat(result).isTrue();
        }

        @Test
        @Timeout(value = 1, unit = TimeUnit.SECONDS)
        void shouldNotFindCustomerIdForVeryLargeArray() {
            // probably does not exist because UUID collision is very unlikely
            var nonExistingCustomerId = UUID.randomUUID().getMostSignificantBits();

            var result = new IdSearchSolution().searchId(largeArray, nonExistingCustomerId);
            assertThat(result).isFalse();
        }

    }
}
