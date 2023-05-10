
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.AssertEquals.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void additionTest1()
    {
        linkedList num1List = new linkedList();
        Node node1 = new Node(1222349890);
        num1List.setHead(node1);
        linkedList num2List = new linkedList();
        Node node2 = new Node(298349284);
        num1List.setHead(node1);
        num2List.setHead(node2);
        BigInteger num1 = new BigInteger();
        num1.setNum1(num1List);
        num1.setNum2(num2List);
        linkedList result = new linkedList();
        result = num1.addLinkedLists().Reverse();
        String resultStr  = result.Read();
        assertEquals("1520699174", resultStr);

    }
    @Test
    public void additionTest2()
    {
        linkedList num1List = new linkedList();
        Node node1 = new Node(123);
        num1List.setHead(node1);
        linkedList num2List = new linkedList();
        Node node2 = new Node(48);
        num1List.setHead(node1);
        num2List.setHead(node2);
        BigInteger num1 = new BigInteger();
        num1.setNum1(num1List);
        num1.setNum2(num2List);
        linkedList result = new linkedList();
        result = num1.addLinkedLists().Reverse();
        String resultStr  = result.Read();
        assertEquals("171", resultStr);

    }

    @Test
    //DOESN'T PASS SINCE NEED TO FIX LEADING 0's
    public void additionTest3()
    {
        linkedList num1List = new linkedList();
        Node node1 = new Node(00123);
        num1List.setHead(node1);
        linkedList num2List = new linkedList();
        Node node2 = new Node(48);
        num1List.setHead(node1);
        num2List.setHead(node2);
        BigInteger num1 = new BigInteger();
        num1.setNum1(num1List);
        num1.setNum2(num2List);
        linkedList result = new linkedList();
        result = num1.addLinkedLists().Reverse();
        String resultStr  = result.Read();
        assertEquals("171", resultStr);

    }

    @Test
    public void multiplicationTest1()
    {
        linkedList num1List = new linkedList();
        Node node1 = new Node(123);
        num1List.setHead(node1);
        linkedList num2List = new linkedList();
        Node node2 = new Node(48);
        num1List.setHead(node1);
        num2List.setHead(node2);
        BigInteger num1 = new BigInteger();
        num1.setNum1(num1List);
        num1.setNum2(num2List);
        linkedList result = new linkedList();
        result = num1.multiply().Reverse();
        String resultStr  = result.Read();
        assertEquals("5940", resultStr);
    }
    @Test
    public void multiplicationTest2()
    {
        linkedList num1List = new linkedList();
        Node node1 = new Node(3);
        num1List.setHead(node1);
        linkedList num2List = new linkedList();
        Node node2 = new Node(333);
        num1List.setHead(node1);
        num2List.setHead(node2);
        BigInteger num1 = new BigInteger();
        num1.setNum1(num1List);
        num1.setNum2(num2List);
        linkedList result = new linkedList();
        result = num1.multiply().Reverse();
        String resultStr  = result.Read();
        assertEquals("999", resultStr);
    }

    @Test
    //DOESN'T PASS SINCE NEED TO FIX LEADING 0's
    public void multiplicationTest3()
    {
        linkedList num1List = new linkedList();
        Node node1 = new Node(003);
        num1List.setHead(node1);
        linkedList num2List = new linkedList();
        Node node2 = new Node(0333);
        num1List.setHead(node1);
        num2List.setHead(node2);
        BigInteger num1 = new BigInteger();
        num1.setNum1(num1List);
        num1.setNum2(num2List);
        linkedList result = new linkedList();
        result = num1.multiply().Reverse();
        String resultStr  = result.Read();
        assertEquals("999", resultStr);
    }
    @Test
    public void exponentiationTest1()
    {
        BigInteger compute = new BigInteger();
        linkedList number1 = new linkedList();
        Node head = new Node(10);
        number1.setHead(head);
        compute.setNum1(number1);
        compute.setNum2(number1);
        linkedList ans = compute.exponentiate(50);
        System.out.println(ans.Read());
        assertEquals("1000000000000000000000000000000000000000000000000", ans.Read());
    }
    @Test
    public void exponentiationTest2()
    {
        BigInteger compute = new BigInteger();
        linkedList number1 = new linkedList();
        Node head = new Node(5);
        number1.setHead(head);
        compute.setNum1(number1);
        compute.setNum2(number1);
        linkedList ans = compute.exponentiate(5);
        System.out.println(ans.Read());
        assertEquals("3125", ans.Read());
    }
    @Test
    //DOESN'T PASS SINCE NEED TO FIX LEADING 0's
    public void exponentiationTest3()
    {
        BigInteger compute = new BigInteger();
        linkedList number1 = new linkedList();
        Node head = new Node(005);
        number1.setHead(head);
        compute.setNum1(number1);
        compute.setNum2(number1);
        linkedList ans = compute.exponentiate(5);
        System.out.println(ans.Read());
        assertEquals("3125", ans.Read());
    }
}