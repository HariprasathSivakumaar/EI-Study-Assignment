public class BusinessTravel implements TravelStrategy {
    @Override
    public void bookTrip(String destination) {
        System.out.println("Booking a business trip to " + destination);
    }
}
