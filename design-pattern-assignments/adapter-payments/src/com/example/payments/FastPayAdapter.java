package com.example.payments;

import java.util.Objects;

public class FastPayAdapter implements PaymentGateway {
    private final FastPayClient fastPayClient;

    public FastPayAdapter(FastPayClient fastPayClient) {
        this.fastPayClient = Objects.requireNonNull(fastPayClient, "FastPayClient cannot be null");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "Customer ID cannot be null");
        if (amountCents <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        
        return fastPayClient.payNow(customerId, amountCents);
    }
}
