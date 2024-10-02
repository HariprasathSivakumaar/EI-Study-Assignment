public class SmartFanFactory extends SmartDeviceFactory {
    @Override
    public SmartDevice createDevice() {
        return new SmartFan();
    }
}
