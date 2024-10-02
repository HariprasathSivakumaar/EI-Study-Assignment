public class AdsFreeDecorator extends SubscriptionDecorator {
    public AdsFreeDecorator(Subscription subscription) {
        super(subscription);
    }

    @Override
    public String getDescription() {
        return subscription.getDescription() + ", Ads-Free";
    }

    @Override
    public double cost() {
        return subscription.cost() + 5.0;
    }
}
