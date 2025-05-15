import java.util.*;

public class DistanceConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            handleDistanceConversion(scanner);

            System.out.print("Do you want to perform another conversion? (yes/no): ");
            String again = scanner.nextLine().trim().toLowerCase();
            if (!again.equals("yes")) {
                keepRunning = false;
            }
        }

        System.out.println("Thank you for using the Distance Converter!");
        scanner.close();
    }

    public static void handleDistanceConversion(Scanner scanner) {
        Map<String, Double> conversionFactors = new HashMap<>();
        conversionFactors.put("miles_to_km", 1.60934);
        conversionFactors.put("km_to_miles", 1 / 1.60934);

        System.out.print("Enter the distance with unit (e.g., 100 miles or 160 km): ");
        String input = scanner.nextLine().trim();
        String[] parts = input.split(" ");

        if (parts.length != 2) {
            System.out.println("Invalid format. Please enter a value and unit separated by a space.");
            return;
        }

        double value;
        try {
            value = Double.parseDouble(parts[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
            return;
        }

        String unit = parts[1].toLowerCase();

        switch (unit) {
            case "miles":
                double toKm = value * conversionFactors.get("miles_to_km");
                System.out.printf("%.2f miles is %.2f kilometers.%n", value, toKm);
                break;
            case "km":
            case "kilometers":
                double toMiles = value * conversionFactors.get("km_to_miles");
                System.out.printf("%.2f kilometers is %.2f miles.%n", value, toMiles);
                break;
            default:
                System.out.println("Unsupported unit. Please use 'miles' or 'km'.");
        }
    }
}
