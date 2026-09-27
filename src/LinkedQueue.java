public class LinkedQueue<T> implements QueueInterface<T> {
    protected LLNode<T> front;
    protected LLNode<T> rear;
    protected int numElements = 0;

    public void enqueue(T element) {
        LLNode<T> newNode = new LLNode<>(element);
        if (rear == null)
            front = newNode;
        else
            rear.setLink(newNode);
        rear = newNode;
        numElements++;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean isFull() {
        return false;
    }

    public int size() {
        return numElements;
    }

    public T dequeue() throws QueueUnderflowException {
        if (isEmpty())
            throw new QueueUnderflowException("Dequeue attempted on empty queue.");
        T element = front.getInfo();
        front = front.getLink();
        if (front == null)
            rear = null;
        numElements--;
        return element;
    }
}
