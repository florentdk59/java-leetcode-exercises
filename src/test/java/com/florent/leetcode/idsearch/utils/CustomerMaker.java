package com.florent.leetcode.idsearch.utils;

import com.florent.leetcode.idsearch.Customer;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class CustomerMaker {

    public static Customer[] makeRandomCustomerArray(int quantityOfCustomers) {
        var customers = new Customer[quantityOfCustomers];
        for (int index = 0; index < quantityOfCustomers; index++) {
            customers[index] = makeRandomCustomer();
        }
        return customers;
    }
    
    public static Customer makeRandomCustomer() {
        var uuid = UUID.randomUUID();
        return new Customer(uuid.getMostSignificantBits(), uuid.toString());
    }


}
