package com.example.payments;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        // Create and configure the payment gateways with their respective adapters
        Map<String, PaymentGateway> gateways = new HashMap<>();
        gateways.put("fastpay", new FastPayAdapter(new FastPayClient()));
        gateways.put("safecash", new SafeCashAdapter(new SafeCashClient()));
        
        // Create the order service with the configured gateways
        OrderService svc = new OrderService(gateways);

        // Process payments through different providers
        try {
            String fastpayId = svc.charge("fastpay", "cust-1", 1299);
            System.out.println("FastPay Transaction ID: " + fastpayId);
            
            String safecashId = svc.charge("safecash", "cust-2", 2499);
            System.out.println("SafeCash Transaction ID: " + safecashId);
            
            // Test with invalid provider
            try {
                svc.charge("invalid", "cust-3", 999);
            } catch (IllegalArgumentException e) {
                System.out.println("Expected error for invalid provider: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Payment processing failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
