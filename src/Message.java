public class Message {
    private String messageId;
    private String payload;
    private int retryCount;

    public Message(String messageId, String payload) {
        this.messageId = messageId;
        this.payload = payload;
        this.retryCount = 0;
    }

    public String toString() {
        return "ID: " + messageId + ", Payload: " + payload + ", Retries: " + retryCount;
    }
}
