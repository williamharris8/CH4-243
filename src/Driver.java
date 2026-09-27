
public class Driver {
    public static void main(String[] args) {
        QueueInterface<Message> queue = new LinkedQueue<>();

        try {
            queue.enqueue(new Message("1", "First"));
            queue.enqueue(new Message("2", "Second"));
            queue.enqueue(new Message("3", "Third"));

            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
        } catch (QueueOverflowException | QueueUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}
