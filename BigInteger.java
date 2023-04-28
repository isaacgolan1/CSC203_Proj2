import java.util.*;

public class BigInteger {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private int digit;
        private Node next;

        public Node(int digit) {
            this.digit = digit;
            this.next = null;
        }
    }

    public BigInteger() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public BigInteger(String s) {
        this();
        for (int i = s.length() - 1; i >= 0; i--) {
            addFirst(s.charAt(i) - '0');
        }
    }

    public BigInteger add(BigInteger other) {
        BigInteger result = new BigInteger();
        int carry = 0;
        Node curr1 = this.head;
        Node curr2 = other.head;
        while (curr1 != null || curr2 != null) {
            int sum = carry;
            if (curr1 != null) {
                sum += curr1.digit;
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                sum += curr2.digit;
                curr2 = curr2.next;
            }
            carry = sum / 10;
            result.addLast(sum % 10);
        }
        if (carry > 0) {
            result.addLast(carry);
        }
        return result;
    }

    public BigInteger multiply(BigInteger other) {
        BigInteger result = new BigInteger();
        Node curr1 = this.head;
        int i = 0;
        while (curr1 != null) {
            BigInteger copy = other.copy();
            int carry = 0;
            for (int j = 0; j < i; j++) {
                copy.addFirst(0);
            }
            Node curr2 = copy.head;
            while (curr2 != null) {
                int prod = curr1.digit * curr2.digit + carry;
                carry = prod / 10;
                result.addLast(prod % 10);
                curr2 = curr2.next;
            }
            if (carry > 0) {
                result.addLast(carry);
            }
            curr1 = curr1.next;
            i++;
        }
        return result;
    }

    public BigInteger exponentiate(int n) {
        if (n == 0) {
            return new BigInteger("1");
        }
        BigInteger half = exponentiate(n / 2);
        if (n % 2 == 0) {
            return half.multiply(half);
        } else {
            return this.multiply(half.multiply(half));
        }
    }

    private BigInteger copy() {
        BigInteger copy = new BigInteger();
        Node curr = this.head;
        while (curr != null) {
            copy.addLast(curr.digit);
            curr = curr.next;
        }
        return copy;
    }

    private void addFirst(int digit) {
        Node newNode = new Node(digit);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    private void addLast(int digit) {
        Node newNode = new Node(digit);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

}

//    @Override
//    public String toString() {
//        if (this.size == 0) {
//            return "0";
//        }
//
//        StringBuilder sb = new StringBuilder();
//        Node curr = this.head;
//
//        while (curr != null) {
//            sb.insert(0, curr.data);
//            curr = curr.next;
//        }
//
//        return sb.toString();
//    }

