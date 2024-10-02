public class BasicSubscription implements Subscription {
    @Override
    public String getDescription() {
        return "Basic Subscription";
    }

    @Override
    public double cost() {
        return 10.0;
    }
}
