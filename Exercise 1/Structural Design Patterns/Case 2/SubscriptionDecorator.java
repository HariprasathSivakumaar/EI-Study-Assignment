public abstract class SubscriptionDecorator implements Subscription {
    protected Subscription subscription;

    public SubscriptionDecorator(Subscription subscription) {
        this.subscription = subscription;
    }
}
