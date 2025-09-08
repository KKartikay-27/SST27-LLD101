package com.example.notifications;

/**
 * Decorator that adds Slack notification capability.
 */
public class SlackDecorator extends NotifierDecorator {
    private final String channel;

    public SlackDecorator(Notifier notifier, String channel) {
        super(notifier);
        this.channel = channel;
    }

    @Override
    public void notify(String text) {
        // First post to Slack
        System.out.println("[SLACK -> #" + channel + "]: " + text);
        // Then delegate to the wrapped notifier
        super.notify(text);
    }
}
