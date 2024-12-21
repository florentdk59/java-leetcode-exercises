package com.florent.leetcode.idsearch;

import java.util.Arrays;

public class IdSearchSolution {

    public boolean searchId(Customer[] customers, long customerId) {
        var sortedCustomerIds = Arrays.stream(customers).map(Customer::id).sorted().toArray();
        return Arrays.binarySearch(sortedCustomerIds, customerId) >= 0;
    }

}
