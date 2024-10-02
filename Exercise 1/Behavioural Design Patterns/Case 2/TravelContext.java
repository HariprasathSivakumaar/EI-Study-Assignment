public class TravelContext {
    private TravelStrategy strategy;

    public void setStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeBooking(String destination) {
        strategy.bookTrip(destination);
    }
}
