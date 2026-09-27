import java.util.Random;

public class Broker {
    public static final int MAX_RETRIES = 3;

    private QueueInterface<Message> queue = new LinkedQueue<>();
    private QueueInterface<Message> deadLetterQueue = new LinkedQueue<>();
    private Random random = new Random();

    public void addMessage(Message message) throws QueueOverflowException {
        queue.enqueue(message);
    }

    public void processBatch() throws QueueOverflowException, QueueUnderflowException {
        while (!queue.isEmpty()) {
            Message message = queue.dequeue();

            if (random.nextInt(100) < message.getSuccessChance()) {
                System.out.println("Success: " + message);
            } else {
                message.incrementRetryCount();

                if (message.getRetryCount() >= MAX_RETRIES) {
                    deadLetterQueue.enqueue(message);
                    System.out.println("Moved to DLQ: " + message);
                } else {
                    queue.enqueue(message);
                    System.out.println("Failed: " + message);
                }
            }
        }
    }

    public void viewAndClearDLQ() throws QueueUnderflowException {
        if (deadLetterQueue.isEmpty()) {
            System.out.println("DLQ is empty.");
        }

        while (!deadLetterQueue.isEmpty()) {
            System.out.println(deadLetterQueue.dequeue());
        }
    }
}