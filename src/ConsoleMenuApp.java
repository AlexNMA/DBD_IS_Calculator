import java.util.Scanner;

public class ConsoleMenuApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        DbdMathCalculator dbdMathCalculator = new DbdMathCalculator();
        while (running) {
            // Afisare meniu
            System.out.println("===== MENIU =====");
            System.out.println("1. Total account base by Devour and Level");
            System.out.println("2. Total Time for Iridescent Shards Target");
            System.out.println("3. Close");
            System.out.print("Choose an option: ");

            // Citirea opțiunii selectate de utilizator
            int optiune = scanner.nextInt();
            scanner.nextLine(); // Consumăm newline-ul lăsat de nextInt()

            // Procesarea opțiunii
            switch (optiune) {
                case 1:
                    System.out.println("Total account base by Devour and Level");
                    System.out.print("Enter devotion level: ");
                    int devotion = scanner.nextInt();
                    System.out.print("Enter level: ");
                    int level = scanner.nextInt();
                    int totalIS = dbdMathCalculator.calculateTotalIS(level) + (devotion * 24920);
                    int totalXP = dbdMathCalculator.calculateTotalXP(level) + (devotion * 348270);
                    System.out.println("Total Iridescent Shards: " + totalIS);
                    System.out.println("Total XP: " + totalXP);

                    break;
                case 2:
                    System.out.println("Total Time for Iridescent Shards Target");
                    System.out.print("Enter Iridescent Shards Target: ");
                    int isTarget = scanner.nextInt();
                    System.out.print("Enter level: ");
                    level = scanner.nextInt();
                    System.out.print("Enter how many Iridescent Shards you currently have: ");
                    totalIS = scanner.nextInt();
                    int[] array = dbdMathCalculator.calculateTimeForIsTarget(totalIS, isTarget, level);
                    System.out.println("Target IS will be reached in " + array[0] + " hours and " + array[1]
                            + " minutes, which is approximately " + array[2] + " matches.");

                    break;
                case 3:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }

        scanner.close(); // Închidem scanner-ul la final pentru a evita scurgerile de resurse.
    }
}
