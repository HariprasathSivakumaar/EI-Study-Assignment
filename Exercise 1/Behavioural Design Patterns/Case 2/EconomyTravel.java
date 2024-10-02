public class EconomyTravel implements TravelStrategy {
    @Override
    public void bookTrip(String destination) {
        System.out.println("Booking an economy trip to " + destination);
    }
}
