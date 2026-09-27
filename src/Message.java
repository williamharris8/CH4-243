public class Message {
    private String messageId;
    private String payload;
    private int retryCount;
    private int successChance;

    public Message(String messageId, String payload, int successChance) {
        this.messageId = messageId;
        this.payload = payload;
        this.retryCount = 0;
        this.successChance = successChance;
    }

    public int getSuccessChance() {
        return successChance;
    }

    public void incrementRetryCount() {
        retryCount++;
    }

    public String toString() {
        return "ID: " + messageId + ", Payload: " + payload + ", Retries: " + retryCount;
    }
}
