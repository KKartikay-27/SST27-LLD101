package com.example.notifications;

/**
 * Decorator that adds WhatsApp notification capability.
 */
public class WhatsAppDecorator extends NotifierDecorator {
    private final String whatsappId;

    public WhatsAppDecorator(Notifier notifier, String whatsappId) {
        super(notifier);
        this.whatsappId = whatsappId;
    }

    @Override
    public void notify(String text) {
        // First send WhatsApp message
        System.out.println("[WHATSAPP -> " + whatsappId + "]: " + text);
        // Then delegate to the wrapped notifier
        super.notify(text);
    }
}
