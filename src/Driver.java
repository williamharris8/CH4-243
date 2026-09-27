
public class Driver {
    public static void main(String[] args) {
        Broker broker = new Broker();

        try {
            broker.addMessage(new Message("1", "Always works", 100));
            broker.addMessage(new Message("2", "Sometimes works", 50));
            broker.addMessage(new Message("3", "Does not work", 0));

            broker.processBatch();
        } catch (QueueOverflowException | QueueUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}
