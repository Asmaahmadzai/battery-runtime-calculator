import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //lets user type
        System.out.print("Enter the device name: ");
        String deviceName = input.nextLine(); //reads text

        System.out.print("Enter your budget: ");
        float budget = input.nextFloat(); //reads decimal numbers.

        System.out.print("Enter battery capacity (mAh): ");
        float batteryCapacity = input.nextFloat();

        System.out.print("Enter device current consumption (mA): ");
        float currentConsumption = input.nextFloat();

        System.out.print("Enter the price of one battery: ");
        float batteryPrice = input.nextFloat();

        //calls overloaded constructor to create object
        BatterySystem battery = new BatterySystem(deviceName, batteryCapacity, currentConsumption);

        // Set remaining values
        battery.setBudget(budget);
        battery.setBatteryPrice(batteryPrice);

        System.out.println("******************************");
        System.out.println("Device name: " + battery.getDeviceName());
        System.out.printf("Estimated runtime of one battery: %.2f hours%n", battery.runtimeHours);

        // Loop for 8, 16, 24 hours
        for (int hours = 8; hours <= 24; hours += 8) {
            battery.calculateCost(hours);
            System.out.println("******************************");
            System.out.println("Required operating time: " + hours + " hours");
            System.out.println("Number of batteries needed: " + battery.numBatteries);
            System.out.printf("Battery cost: %.2f$%n", battery.totalCost);
            System.out.printf("Money left from the budget: %.2f$%n",
                    battery.getBudget() - battery.totalCost);
        }
        input.close();
    }
}