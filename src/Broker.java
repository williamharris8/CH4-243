import java.util.Random;

public class Broker {
    private QueueInterface<Message> queue = new LinkedQueue<>();
    private Random random = new Random();

    public void addMessage(Message message) throws QueueOverflowException {
        queue.enqueue(message);
    }

    public void processBatch() throws QueueOverflowException, QueueUnderflowException {
        int batchSize = queue.size();

        for (int i = 0; i < batchSize; i++) {
            Message message = queue.dequeue();

            if (random.nextInt(100) < message.getSuccessChance()) {
                System.out.println("Success: " + message);
            } else {
                message.incrementRetryCount();
                queue.enqueue(message);
                System.out.println("Failed: " + message);
            }
        }
    }
}
