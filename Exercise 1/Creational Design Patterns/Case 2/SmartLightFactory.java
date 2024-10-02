public class SmartLightFactory extends SmartDeviceFactory {
    @Override
    public SmartDevice createDevice() {
        return new SmartLight();
    }
}
