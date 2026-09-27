import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        Broker broker = new Broker();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1. Add message");
            System.out.println("2. Process batch");
            System.out.println("3. View and clear DLQ");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            try {
                if (choice.equals("1")) {
                    System.out.print("Message ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Payload: ");
                    String payload = scanner.nextLine();
                    System.out.print("Success (0-100): ");
                    int chance = Integer.parseInt(scanner.nextLine());

                    broker.addMessage(new Message(id, payload, chance));
                    System.out.println("Message added");
                } else if (choice.equals("2")) {
                    broker.processBatch();
                } else if (choice.equals("3")) {
                    broker.viewAndClearDLQ();
                } else if (choice.equals("4")) {
                    running = false;
                } else {
                    System.out.println("Invalid choice");
                }

            } catch (QueueOverflowException | QueueUnderflowException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
