/** Represents a battery-powered device system.
 * The class calculates the runtime of one battery,
 * the number of batteries required, and the total cost.
 * @author Asma Ahmadzai
 */

public class BatterySystem {
    //attributes
    public int numBatteries;
    public float runtimeHours;
    public float totalCost;

    private String deviceName;
    private float batteryCapacity;
    private float currentConsumption;
    private float budget;
    private float batteryPrice;
    //constant
    private final float SAFETY_FACTOR = 0.85f;

    //default constructor
    /**
     * Constructs a BatterySystem object with numeric values,
     * initialized to zero and the device name initialized to null.
     */
    public BatterySystem() {
        numBatteries = 0;
        runtimeHours = 0;
        totalCost = 0;

        deviceName = null;
        batteryCapacity = 0;
        currentConsumption = 0;
        budget = 0;
        batteryPrice = 0;
    }
    //overloaded constructor
    /** Constructs a BatterySystem object using the device information
     * and calculates the runtime of one battery.
     * @param deviceName : name of the device
     * @param batteryCapacity : battery capacity in mAh
     * @param currentConsumption : device current consumption in mA
     */
    public BatterySystem(String deviceName, float batteryCapacity, float currentConsumption) {
        this(); //calls the default constructor first
        this.deviceName = deviceName;
        this.batteryCapacity = batteryCapacity;
        this.currentConsumption = currentConsumption;
        runtimeHours = (batteryCapacity * SAFETY_FACTOR) / currentConsumption;
    }
    //getters/setters for private
    /**
     * Returns the name of the device.
     * @return the device name
     */
    public String getDeviceName() {
        return deviceName;
    }
    /**
     * Sets the name of the device.
     * @param deviceName : new device name
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    /**
     * Returns the battery capacity.
     * @return the battery capacity in mAh
     */
    public float getBatteryCapacity() {
        return batteryCapacity;
    }
    /**
     * Sets the battery capacity.
     * @param batteryCapacity : battery capacity in mAh
     */
    public void setBatteryCapacity(float batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
    /**
     * Returns the current consumption of the device.
     * @return the current consumption in mA
     */
    public float getCurrentConsumption() {
        return currentConsumption;
    }
    /**
     * Sets the current consumption of the device.
     * @param currentConsumption : the current consumption in mA
     */
    public void setCurrentConsumption(float currentConsumption) {
        this.currentConsumption = currentConsumption;
    }
    /**
     * Returns the user's budget.
     * @return the budget
     */
    public float getBudget() {
        return budget;
    }
    /**
     * Sets the user's budget.
     * @param budget the user's budget
     */
    public void setBudget(float budget) {
        this.budget = budget;
    }
    /**
     * Returns the price of one battery.
     * @return the battery price
     */
    public float getBatteryPrice() {
        return batteryPrice;
    }
    /**
     * Sets the price of one battery.
     * @param batteryPrice the price of one battery
     */
    public void setBatteryPrice(float batteryPrice) {
        this.batteryPrice = batteryPrice;
    }
    /**
     * Calculates the number of batteries required and their total cost
     * for a specified operating time.
     * @param hours the required operating time in hours
     */
    public void calculateCost(int hours) {
        numBatteries = (int) Math.ceil(hours / runtimeHours);
        totalCost = numBatteries * batteryPrice;
    }
}