package com.example.payments;

import java.util.Objects;

public class SafeCashAdapter implements PaymentGateway {
    private final SafeCashClient safeCashClient;

    public SafeCashAdapter(SafeCashClient safeCashClient) {
        this.safeCashClient = Objects.requireNonNull(safeCashClient, "SafeCashClient cannot be null");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "Customer ID cannot be null");
        if (amountCents <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        
        SafeCashPayment payment = safeCashClient.createPayment(amountCents, customerId);
        return payment.confirm();
    }
}
