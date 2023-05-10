import java.util.*;
//import java.util.LinkedList;

import static java.lang.Integer.parseInt;

public class BigInteger {
    private linkedList num1;
    private linkedList num2;
    private String answer;
    private int size;



    public BigInteger() {
        this.num1 = null;
        this.num2 = null;
        this.size = 0;
        this.answer = "";
    }
    public void setNum1(linkedList L){
        this.num1 = L;
    }
    public void setNum2(linkedList W){
        this.num2 = W;
    }

    public linkedList getNum1()
    {
        return this.num1;
    }
    public linkedList getNum2()
    {
        return this.num1;
    }

    public String getNum1str(){
        return this.num1.Read();
    }

    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String N){
        this.answer = N;
    }
    public linkedList multiply() {
        BigInteger temp = new BigInteger();
        int carry = 0;
        Node leftDigit = this.num1.getHead();
        int leftDigitPos = 0;
        temp.num1 = new linkedList();
        while (leftDigit != null) {
            temp.num2 = new linkedList();
            Node rightDigit = this.num2.getHead();
            while (rightDigit != null) {
                int product = (leftDigit.getDigit()) * (rightDigit.getDigit()) + carry;
                carry = product / 10;
                int digit = product % 10;
                temp.num2.addStart(digit);
                rightDigit = rightDigit.getNext();
            }
            if (carry > 0) {
                temp.num2.addStart(carry);
            }
            carry = 0;
            for (int i = 0; i < leftDigitPos; i++) {
                temp.num2.add(0);
            }
            temp.num1 = temp.num1.Reverse();
            temp.num2 = temp.num2.Reverse();
            temp.num1 = temp.addLinkedLists();
            leftDigit = leftDigit.getNext();
            leftDigitPos++;
        }
        return temp.num1;
    }
    public linkedList addLinkedLists() {
        linkedList result = new linkedList();
        int carry = 0;
        Node curr1 = this.num1.getHead();
        Node curr2 = this.num2.getHead();
        while (curr1 != null || curr2 != null) {
            int sum = carry;
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
            int digit = sum % 10;
            result.addStart(digit);
        }

        if (carry > 0) {
            result.add(carry);
        }
        return result;
    }
    /*
    public LinkedList exponentiate(int n) {
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

    public linkedList exponentiate(int base, int expo)
    {
        linkedList result = new linkedList();
//        System.out.println("read num1: "+ this.num1.getHead().getDigit());
//        System.out.println("read num2: "+ this.num2.getHead().getDigit());
        System.out.println("read base, expo: " + base + " , " + expo);

//        intexpo = this.num2.getHead().getDigit();
        if (expo  == 0){
            result.add(1);
            return result;
        }
        else if(expo % 2 ==0)
        {
            return exponentiate(base * base, expo / 2);
        }
        else
        {
            linkedList baseList = new linkedList();
            BigInteger computeExp = new BigInteger();
            linkedList expList = new linkedList();
            BigInteger computeBaseProd = new BigInteger();
            expList.add(expo);
            baseList.add(base);
            computeBaseProd.setNum1(baseList);
            computeBaseProd.setNum2(baseList);
            computeExp.setNum1(baseList);
            computeExp.setNum2(exponentiate(base*base, (expo - 1) / 2));
            return computeExp.multiply();
        }
//        result.addStart(420);
//        return result;
//        return null;
    }

//    public linkedList exponentiate(int exponent)
//    {
//        if (exponent == 0) {
//            // Base case: any number raised to 0 is 1
//            linkedList result = new linkedList();
//            result.add(1);
//            return result;
//    }
}
