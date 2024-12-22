package com.florent.leetcode.utils;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class ParameterizedIntList {

    private static final String DELIMITER = "_";

    @ToString.Include
    private final List<Integer> values = new ArrayList<>();

    public ParameterizedIntList(String stringValues) {
        for (String stringValue : stringValues.split(DELIMITER)) {
            values.add(Integer.parseInt(stringValue));
        }
    }



}
