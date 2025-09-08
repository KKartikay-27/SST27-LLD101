package com.example.notifications;

/**
 * Base decorator class that implements the Notifier interface
 * and maintains a reference to a wrapped Notifier.
 */
public abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void notify(String text) {
        wrappedNotifier.notify(text);
    }
}
