public class LLNode<T> {
    private T info;
    private LLNode<T> link;

    public LLNode(T info) {
        this.info = info;
        this.link = null;
    }
    public T getInfo() {
        return info;
    }
    public LLNode<T> getLink() {
        return link;
    }
    public void setLink(LLNode<T> link) {
        this.link = link;
    }
}
