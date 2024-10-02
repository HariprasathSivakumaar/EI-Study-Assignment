public class PremiumSupportDecorator extends SubscriptionDecorator {
    public PremiumSupportDecorator(Subscription subscription) {
        super(subscription);
    }

    @Override
    public String getDescription() {
        return subscription.getDescription() + ", Premium Support";
    }

    @Override
    public double cost() {
        return subscription.cost() + 7.0;
    }
}
