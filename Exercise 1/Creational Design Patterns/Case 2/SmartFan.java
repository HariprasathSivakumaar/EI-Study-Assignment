public class SmartFan implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Smart Fan is turned on.");
    }

    public void turnOff() {
        System.out.println("Smart Fan is turned off.");
    }
}
