import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueConversion = true;

        // These are exchange rates as of 2025
        final double USD_TO_EUR = 0.92;
        final double USD_TO_YEN = 155.0;
        final double USD_TO_PESOS = 17.0;

        while (continueConversion) {
            System.out.print("Enter value and currency to convert (Options: USD, EUR, YEN, PESOS): ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");
            // Separates string by spaces so that user can type 100*space*USD

            if (parts.length != 2) {
                System.out.println("Invalid input format. Please use the format: <value> <currency>");
                continue;
            }

            double value;
            try {
                value = Double.parseDouble(parts[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
                continue;
            }

            String currency = parts[1].toUpperCase();

            //Simple switch for each currency available for conversion
            switch (currency) {
                case "USD":
                    System.out.printf("%.2f USD is %.2f EUR%n", value, value * USD_TO_EUR);
                    System.out.printf("%.2f USD is %.2f YEN%n", value, value * USD_TO_YEN);
                    System.out.printf("%.2f USD is %.2f PESOS%n", value, value * USD_TO_PESOS);
                    break;
                case "EUR":
                    double eurToUsd = value / USD_TO_EUR;
                    System.out.printf("%.2f EUR is %.2f USD%n", value, eurToUsd);
                    System.out.printf("%.2f EUR is %.2f YEN%n", value, eurToUsd * USD_TO_YEN);
                    System.out.printf("%.2f EUR is %.2f PESOS%n", value, eurToUsd * USD_TO_PESOS);
                    break;
                case "YEN":
                    double yenToUsd = value / USD_TO_YEN;
                    System.out.printf("%.2f YEN is %.2f USD%n", value, yenToUsd);
                    System.out.printf("%.2f YEN is %.2f EUR%n", value, yenToUsd * USD_TO_EUR);
                    System.out.printf("%.2f YEN is %.2f PESOS%n", value, yenToUsd * USD_TO_PESOS);
                    break;
                case "PESOS":
                    double pesosToUsd = value / USD_TO_PESOS;
                    System.out.printf("%.2f PESOS is %.2f USD%n", value, pesosToUsd);
                    System.out.printf("%.2f PESOS is %.2f EUR%n", value, pesosToUsd * USD_TO_EUR);
                    System.out.printf("%.2f PESOS is %.2f YEN%n", value, pesosToUsd * USD_TO_YEN);
                    break;
                default:
                    System.out.println("Unsupported currency. Try USD, EUR, YEN, or PESOS.");
                    continue;
            }

            System.out.print("Do you want to do another conversion? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            continueConversion = response.equals("yes");
        }

        System.out.println("Thank you for using the currency converter!");
        scanner.close();
    }
}
