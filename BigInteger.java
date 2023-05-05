import java.util.*;

public class BigInteger {
    private LinkedList num1;
    private LinkedList num2;
    private LinkedList answer;
    private int size;



    public BigInteger() {
        this.num1 = null;
        this.num2 = null;
        this.size = 0;
    }
    public void setNum1(LinkedList L){
        this.num1 = L;
    }
    public void setNum2(LinkedList W){
        this.num2 = W;
    }
    public void setAnswer(LinkedList N){
        this.answer = N;
    }
    public void add() {
        int carry = 0;
        Node curr1 = this.num1.getHead();
        Node curr2 = this.num2.getHead();
        int sum = 0;
        while (curr1 != null || curr2 != null) {
            sum = 0;
            if (carry > 0) {
                sum = carry;
            }
            carry = 0;
            if (curr1 != null) {
                sum += curr1.getDigit();
                curr1 = curr1.getNext();
            }
            if (curr2 != null) {
                sum += curr2.getDigit();
                curr2 = curr2.getNext();
            }
            carry = sum / 10;
            answer.addStart(sum % 10);
        }
        if (carry > 0) {
            answer.addStart(carry);
        }
    }

    public Integer multiply() {
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

    public Integer exponentiate(int n) {
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

}

