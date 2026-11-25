import java.util.Scanner;
import Task1.*;
import Task2.*;
import Task3.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== MAIN MENU (LAB 3) ===");
            System.out.println("1. Task 1 (Variant 7: Trial -> Test, Exam -> FinalExam)");
            System.out.println("2. Task 2 (Variant 11: Abstract class Container)");
            System.out.println("3. Task 3 (Variant 11: Interface IContainer)");
            System.out.println("0. Exit");

            int choice = readInt("Select an option: ", 0, 3);
            switch (choice) {
                case 1:
                    runTask1();
                    break;
                case 2:
                    runTask2();
                    break;
                case 3:
                    runTask3();
                    break;
                case 0:
                    System.out.println("Program finished.");
                    scanner.close();
                    return;
            }
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(input);
                if (val >= min && val <= max) {
                    return val;
                }
                System.out.printf("Error: enter an integer between %d and %d.%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("Error: invalid integer format. Try again.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: invalid number format. Try again.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Error: string cannot be empty.");
        }
    }

    private static double[] inputArrayFromKeyboard() {
        int size = readInt("Enter array size (1..20): ", 1, 20);
        double[] arr = new double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = readDouble("  Element [" + i + "]: ");
        }
        return arr;
    }

    private static void runTask1() {
        System.out.println("\n--- Task 1: Inheritance Hierarchy ---");
        int count = readInt("How many trial objects do you want to create (1..10)? ", 1, 10);
        Trial[] trials = new Trial[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nObject #" + (i + 1) + " type:");
            System.out.println("1 - Trial (Випробування)");
            System.out.println("2 - Test (Тест)");
            System.out.println("3 - Exam (Іспит)");
            System.out.println("4 - FinalExam (Випускний іспит)");
            int type = readInt("Choose type: ", 1, 4);

            String subject = readNonEmptyString("Enter subject name: ");
            int maxScore = readInt("Enter max score (1..1000): ", 1, 1000);

            switch (type) {
                case 1:
                    trials[i] = new Trial(subject, maxScore);
                    break;
                case 2:
                    int qCount = readInt("Enter number of questions (1..200): ", 1, 200);
                    trials[i] = new Test(subject, maxScore, qCount);
                    break;
                case 3:
                    String examiner = readNonEmptyString("Enter examiner's full name: ");
                    trials[i] = new Exam(subject, maxScore, examiner);
                    break;
                case 4:
                    String examinerFinal = readNonEmptyString("Enter examiner's full name: ");
                    String commission = readNonEmptyString("Enter commission head name: ");
                    trials[i] = new FinalExam(subject, maxScore, examinerFinal, commission);
                    break;
            }
        }

        System.out.println("\n=== Outputting all trials using Show() ===");
        for (Trial t : trials) {
            t.Show();
        }
    }

    private static void runTask2() {
        System.out.println("\n--- Task 2: Abstract Class Container ---");
        Container[] containers = new Container[2];

        System.out.println("\n[1] Enter data for Bubble container:");
        containers[0] = new Bubble(inputArrayFromKeyboard());

        System.out.println("\n[2] Enter data for Choice container:");
        containers[1] = new Choice(inputArrayFromKeyboard());

        System.out.println("\n=== Results (Abstract Class) ===");
        for (Container c : containers) {
            System.out.println("Before sort: " + c.toString());
            c.sort();
            System.out.println("After sort:  " + c.toString());
            System.out.printf("Norma value: %.4f%n%n", c.norma());
        }

        Bubble copyBubble = new Bubble(containers[0].getData());
        System.out.println("Equals check (containers[0] vs copy): " + containers[0].equals(copyBubble));
        System.out.println("Equals check (containers[0] vs containers[1]): " + containers[0].equals(containers[1]));
    }

    private static void runTask3() {
        System.out.println("\n--- Task 3: Interface IContainer ---");
        IContainer[] containers = new IContainer[2];

        System.out.println("\n[1] Enter data for BubbleImpl (Interface):");
        containers[0] = new BubbleImpl(inputArrayFromKeyboard());

        System.out.println("\n[2] Enter data for ChoiceImpl (Interface):");
        containers[1] = new ChoiceImpl(inputArrayFromKeyboard());

        System.out.println("\n=== Results (Interface) ===");
        for (IContainer c : containers) {
            System.out.println("Before sort: " + c.toString());
            c.sort();
            System.out.println("After sort:  " + c.toString());
            System.out.printf("Norma value: %.4f%n%n", c.norma());
        }

        ChoiceImpl copyChoice = new ChoiceImpl(((ChoiceImpl) containers[1]).getData());
        System.out.println("Equals check (containers[1] vs copy): " + containers[1].equals(copyChoice));
    }
}