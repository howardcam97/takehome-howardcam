# Retailer Rewards Program - API Documentation

This document provides information on how to use the Retailer Rewards Program API to calculate reward points earned by customers based on their recorded purchases. The API is implemented using Spring Boot and provides a RESTful endpoint. Example test JSON can be found in `src/main/resources/static/testdata.json`

## Endpoint

The API provides two endpoints to calculate the reward points earned by customers. One of them will return the total points per month per user and the other will return the total rewards points per customer.

```
POST /rewards/month
```

```
POST /rewards/user
```

### Request

The request should be a JSON array of transaction objects, where each transaction represents a customer's purchase. The transaction object should have the following attributes:

- `customerId` (String): The unique identifier of the customer.
- `purchaseAmount` (double): The amount spent by the customer in the transaction.
- `transactionDate` (String): The date of the transaction in the format "yyyy-MM-dd".

Example Request Body:
```json
[
  {
    "customerId": "123",
    "purchaseAmount": 150.0,
    "transactionDate": "2023-05-01"
  },
  {
    "customerId": "456",
    "purchaseAmount": 75.0,
    "transactionDate": "2023-05-02"
  }
]
```

## Solution Implementation

The reward points are calculated based on the given rules: 2 points for every dollar spent over $100, and 1 point for every dollar spent between $50 and $100. The reward points are calculated for each customer per month and then summed up to provide the total reward points.

## Conclusion

The Retailer Rewards Program API allows you to calculate the reward points
