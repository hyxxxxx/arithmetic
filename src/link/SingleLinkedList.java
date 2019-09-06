package link;

public class SingleLinkedList {

    private Node head = null;

    private class Node<T> {
        private T data;
        private Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public <T> void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
    }

}
