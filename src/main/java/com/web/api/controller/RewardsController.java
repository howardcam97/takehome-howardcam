package com.web.api.controller;

import com.web.api.entity.Transaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rewards")
public class RewardsController {

    /*
    Endpoint that takes in a list of Transactions and returns a map of the customer id's mapped to the total rewards
    they have earned for each month.
    */
    @PostMapping("/month")
    public Map<String, Map<String, Integer>> calculateRewardsPerMonth(@RequestBody List<Transaction> transactions) {
        Map<String, Map<String, Integer>> rewardPoints = new HashMap<>();

        for (Transaction transaction : transactions) {
            String customerId = transaction.getCustomerId();
            String month = transaction.getTransactionDate().getMonth().name();
            int points = calculatePoints(transaction.getPurchaseAmount());

            // Get the map for the customer or create a new one if it doesn't exist
            Map<String, Integer> customerPoints = rewardPoints.get(customerId);
            if (customerPoints == null) {
                customerPoints = new HashMap<>();
                rewardPoints.put(customerId, customerPoints);
            }

            // Update the reward points for the customer and month
            Integer existingPoints = customerPoints.get(month);
            if (existingPoints == null) {
                customerPoints.put(month, points);
            } else {
                customerPoints.put(month, existingPoints + points);
            }
        }

        return rewardPoints;
    }

    /*
    Endpoint that takes in a list of Transactions and returns a map of the customer id's mapped to the total rewards
    they have earned.
    */
    @PostMapping("/user")
    public Map<String, Integer> calculateRewardsPerUser(@RequestBody List<Transaction> transactions) {
        Map<String, Integer> rewardPoints = new HashMap<>();

        for (Transaction transaction : transactions) {
            String customerId = transaction.getCustomerId();
            String month = transaction.getTransactionDate().getMonth().name();
            int points = calculatePoints(transaction.getPurchaseAmount());

            // Get the points for the customer or add them if they don't exist
            Integer existingPoints = rewardPoints.get(customerId);
            if (existingPoints == null) {
                rewardPoints.put(customerId, points);
            }
            else {
                rewardPoints.put(customerId, existingPoints + points);
            }
        }

        return rewardPoints;
    }

    private int calculatePoints(double purchaseAmount) {
        int points = 0;

        if (purchaseAmount > 100) {
            points += 2 * (int) (purchaseAmount - 100);
        }

        if (purchaseAmount > 50) {
            points += (int) (purchaseAmount - 50);
        }

        return points;
    }
}

