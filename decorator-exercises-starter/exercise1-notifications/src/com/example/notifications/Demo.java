package com.example.notifications;

/**
 * Demo class showing different combinations of notification decorators.
 */
public class Demo {
    public static void main(String[] args) {
        // Base notifier
        Notifier base = new EmailNotifier("user@example.com");

        // 1. Baseline behavior - Email only
        System.out.println("\n1. Sending email only:");
        base.notify("This is an email notification.");

        // 2. Email + SMS
        System.out.println("\n2. Sending email + SMS:");
        Notifier smsAndEmail = new SmsDecorator(base, "+1-555-123-4567");
        smsAndEmail.notify("Your order has been shipped!");

        // 3. Email + WhatsApp
        System.out.println("\n3. Sending email + WhatsApp:");
        Notifier whatsappAndEmail = new WhatsAppDecorator(base, "user_whatsapp_id");
        whatsappAndEmail.notify("Your appointment is tomorrow at 2 PM.");

        // 4. Email + Slack
        System.out.println("\n4. Sending email + Slack:");
        Notifier slackAndEmail = new SlackDecorator(base, "general");
        slackAndEmail.notify("New message in the general channel");

        // 5. Email + WhatsApp + Slack
        System.out.println("\n5. Sending email + WhatsApp + Slack:");
        Notifier allChannels = new SlackDecorator(
            new WhatsAppDecorator(base, "user_whatsapp_id"),
            "alerts"
        );
        allChannels.notify("URGENT: System maintenance in 30 minutes!");
    }
}
