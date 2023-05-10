public class Node {
    private int digit;
    private Node next;

    public Node(int digit) {
        this.digit = digit;
        this.next = null;
    }
    public Node getNext(){
        return this.next;
    }
    public void setNext(Node node){
        this.next = node;
    }
    public Integer getDigit(){
        return this.digit;
    }

//    public void setDigit(char newDigit)
//    {
//        this.digit = newDigit;
//    }
}