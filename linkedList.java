public class linkedList {
    private Node head;
    private int size;

    public linkedList() {
        this.head = null;
        this.size = 0;
    }
    public Integer getSize(){
        return this.size;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public linkedList Reverse() {
        linkedList reversed = new linkedList();
        Node curr = this.head;
        while (curr != null) {
            reversed.addStart(curr.getDigit());
            curr = curr.getNext();
        }
        return reversed;
    }
    public void add(Integer value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }
    public void addStart(Integer value) {
        Node newNode = new Node(value);
        newNode.setNext(head);
        head = newNode;
        size++;
    }
//    public void updateDigit(int index, char newDigit) {
//        if (index < 0 || index >= this.size) {
//            throw new IndexOutOfBoundsException();
//        }
//        Node current = this.head;
//        for (int i = 0; i < index; i++) {
//            current = current.getNext();
//        }
//        current.setDigit(newDigit);
//    }
    public Node getHead(){
        return this.head;
    }

    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getDigit();
    }
    public String Read() {
        String result = "";
        Node current = head;
        for (int i = 0; i < size; i++) {
            result = result + Integer.toString(current.getDigit());
            current = current.getNext();
        }
        return result;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}