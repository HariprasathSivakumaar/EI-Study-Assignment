public class App {
    public static void main(String[] args) {
        TravelContext travelContext = new TravelContext();

        travelContext.setStrategy(new EconomyTravel());
        travelContext.executeBooking("Paris");

        travelContext.setStrategy(new LuxuryTravel());
        travelContext.executeBooking("Dubai");
    }
}
