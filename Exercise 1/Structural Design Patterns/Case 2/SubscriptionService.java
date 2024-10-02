public class SubscriptionService {
    public static void main(String[] args) {
        Subscription subscription = new BasicSubscription();
        System.out.println(subscription.getDescription() + " $" + subscription.cost());

        subscription = new AdsFreeDecorator(subscription);
        System.out.println(subscription.getDescription() + " $" + subscription.cost());

        subscription = new PremiumSupportDecorator(subscription);
        System.out.println(subscription.getDescription() + " $" + subscription.cost());
    }
}
