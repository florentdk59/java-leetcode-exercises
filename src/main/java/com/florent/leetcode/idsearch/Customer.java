package com.florent.leetcode.idsearch;

import lombok.NonNull;

import java.util.Comparator;

public record Customer(long id, String name) implements Comparable<Customer> {

    public int compareTo(@NonNull Customer other) {
        return Comparator.comparingLong(Customer::id).compare(this, other);
    }

}