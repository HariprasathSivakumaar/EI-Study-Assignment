public class LuxuryTravel implements TravelStrategy {
    @Override
    public void bookTrip(String destination) {
        System.out.println("Booking a luxury trip to " + destination);
    }
}
