public class SmartLight implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Smart light is turned on.");
    }

    public void turnOff() {
        System.out.println("Smart light is turned off.");
    }
}
