import java.util.*;

public class BigInteger {
    private LinkedList num1;
    private LinkedList num2;
    private String answer;
    private int size;



    public BigInteger() {
        this.num1 = null;
        this.num2 = null;
        this.size = 0;
        this.answer = "";
    }
    public void setNum1(LinkedList L){
        this.num1 = L;
    }
    public void setNum2(LinkedList W){
        this.num2 = W;
    }
    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String N){
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
                sum += curr1.getDigit() - '0';
                curr1 = curr1.getNext();
            }
            if (curr2 != null) {
                sum += curr2.getDigit() - '0';
                curr2 = curr2.getNext();
            }
            carry = sum / 10;
            String answer1 = Integer.toString(sum % 10);
            this.answer = answer1 + this.answer;
        }
        if (carry > 0) {
            String answer2 = Integer.toString(carry);
            this.answer = answer2 + this.answer;
        }
    }
    public int multiply() {
        int result = 0;
        Node leftDigit = this.num1.getHead();
        int leftDigitPos = 0;
        while (leftDigit != null) {
            int carry = 0;
            int digitResult = 0;
            Node rightDigit = this.num2.getHead();
            while (rightDigit != null) {
                int product = (leftDigit.getDigit() - '0') * (rightDigit.getDigit() - '0') + carry;
                carry = product / 10;
                digitResult = digitResult * 10 + (product % 10);
                rightDigit = rightDigit.getNext();
            }
            if (carry > 0) {
                digitResult = digitResult * 10 + carry;
            }
            for (int i = 0; i < leftDigitPos; i++) {
                digitResult *= 10;
            }
            result += digitResult;
            leftDigit = leftDigit.getNext();
            leftDigitPos++;
        }
        this.answer = Integer.toString(result);
        return result;
    }
    /*
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
    */
}

