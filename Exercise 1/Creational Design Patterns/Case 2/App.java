public class App {
    public static void main(String[] args) {
        SmartDeviceFactory lightFactory = new SmartLightFactory();
        SmartDevice light = lightFactory.createDevice();
        light.turnOn();
        light.turnOff();


        SmartDeviceFactory fanFactory = new SmartFanFactory();
        SmartDevice fan = fanFactory.createDevice();
        fan.turnOn();
        fan.turnOff();
    }
}
