import java.util.Scanner;

public class Main {
    private Scanner scanner;

    public Main() {
        scanner = new Scanner(System.in);
    }

    public int readNumber() {
        int number = 0;

        System.out.println("Insert a number:");

        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {
                System.out.println("Error: invalid input\n\nTry again:");

                continue;
            }

            if (number <= 0) {
                System.out.println("Error: invalid value\n\nTry again:");
            } else {
                break;
            }
        }

        return number;
    }

    public Queue fillQueue(int lengthOfQueue) {
        Queue queue = new Queue(lengthOfQueue);

        for (int currentNumber = 1; currentNumber <= lengthOfQueue; currentNumber++) {
            queue.addElement(convertDecimalToBinary(currentNumber));
        }

        return queue;
    }

    private int convertDecimalToBinary(int number) {
        int[] characters = new int[64];
        int binary = 0;

        for (int currentIndex = 0; number > 0; currentIndex++) {
            characters[currentIndex] = number % 2;
            number /= 2;
        }

        for (int currentIndex = 0; currentIndex < 64; currentIndex++) {
            binary += characters[currentIndex] * Math.pow(10, currentIndex);
        }

        return binary;
    }

    private void printQueueElements(Queue queue) {
        String output = "Successful.\n\nYour queue:\n";

        for (int currentIndex = 0; !queue.isEmpty(); currentIndex++) {
            if (currentIndex == 0) {
                output += "[ ";
            }

            output += queue.removeElement();

            if (!queue.isEmpty()) {
                output += ", ";
            } else {
                output += " ]";
            }
        }

        System.out.println(output);
    }

    public static void main(String[] args) {
        Main main = new Main();
        int numberOfBinaryRepresentations = main.readNumber();
        Queue queue = null;

        System.out.println("\nCreating a queue with " + numberOfBinaryRepresentations + " cells...");
        queue = main.fillQueue(numberOfBinaryRepresentations);

        System.out.println("Successful.\nGenerating the binary representantions...");
        main.printQueueElements(queue);

        System.out.println("\nSee you soon.");
    }
}
