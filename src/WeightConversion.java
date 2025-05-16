import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeightConversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            weightConverter(scan);
        }
    }
    public static void weightConverter(Scanner scan) {
        System.out.println("How many weights do you want to enter?");
        int count = scan.nextInt();
        // Make it so a person can type in a list of weights all at once instead of typing in each weight one by one
        List<Integer> weights = new ArrayList<>();
        {
            int i = 0;
            while (i < count) {
                System.out.println("Enter weight" + (i + 1) + ": ");
                int weight = scan.nextInt();
                weights.add(weight);
                System.out.println("Is this the last weight?(y/n)");
                String contuine = scan.nextLine();
                if (contuine.equalsIgnoreCase("n")) {
                    System.out.println("Enter weight" + (i + 1) + ": ");
                    weight = scan.nextInt();
                } else {
                    conversionMath(weight, scan);
                    return;

                }
            }
        }
    }

    private static void conversionMath(int weight, Scanner scan){
        final String[] weightUnits = {"KG,LBS,Viss"};
        System.out.println("Select a choice from the list" + weightUnits);
        // This is converts the weight
        System.out.println(weightUnits);
        if (weightUnits.equals("KG")) {
            System.out.println("What would you like to convert to? (LBS or Viss)");
            String conversionChoice = scan.nextLine();
            if (conversionChoice == "LBS") {
                int newWeight = (int) (weight * 2.2046);
                System.out.println("Weight in LBS is" + newWeight);
            }
        } else {
            int newWeight = (int) (weight * 0.613);
            System.out.println("Weight in Viss is" + newWeight);
        }
        if (weightUnits.toString().equalsIgnoreCase("LBS")) {
            System.out.println("What would you like to convert to? (KG or Viss)");
            String conversionChoice = scan.nextLine();
            if (conversionChoice.toLowerCase().startsWith("k")) {
                int newWeight = (int) (weight / 2.2046);
                System.out.println("Weight in LBS is:" + newWeight);
            } else {
                int newWeight = (int) (weight * 0.2835);
                System.out.println("Weight in Viss is:" + newWeight);
            }

        }
        if (weightUnits.equals("Viss")) {
            System.out.println("What would you like to convert to? (KG or LBS)");
            String conversionChoice = scan.nextLine();
            if (conversionChoice.toLowerCase().startsWith("k")) {
                int newWeight = (int) (weight * 1.6);
                System.out.println("Weight in KG is:" + newWeight);
            } else {
                int newWeight = (int) (weight * 3.527);
                System.out.println("Weight in LBS is:" + newWeight);
            }
        }
        System.out.println("Would you like to convert to Tons?(y/n)");
        String getBigger = scan.nextLine();
        if (getBigger.equalsIgnoreCase("yes")) {
            getTons(scan);
        } else {
        }
    }
    //This allows someone to make the weight into tons which could be used for shipping on a freighter or another method business may use
    public static void getTons(Scanner scan) {
        System.out.println("What is the weight?");
        int weight = scan.nextInt();
        System.out.println("What is the unit of weight?");
        String unit = scan.nextLine();
        if (unit.equalsIgnoreCase("kg")) {
            int tonsWeight;
            tonsWeight = (int) (weight / 1000);
        }
        if (unit.equalsIgnoreCase("lbs")) {
            int tonsWeight;
            tonsWeight = (int) (weight / 2000);
        }
    }



}