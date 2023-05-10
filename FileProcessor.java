import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                linkedList num1 = new linkedList();
                linkedList num2 = new linkedList();
                String[] strings = line.split("\\s+");
                BigInteger compute = new BigInteger();
                String strnum1 = "";
                String strnum2 = "";
                if (strings.length < 3) {
                    System.out.println("Not Enough Elements");
                    continue;
                }
                for (int i = strings[0].length()-1; i >= 0 ; i--) {
                    char ch = strings[0].charAt(i);
                    num1.add(Character.getNumericValue(ch));
                    strnum1 = ch + strnum1;
                }
                if (strings[1].equals("^")){
                    int exponent = Integer.parseInt(strings[2]);
                    compute.setNum1(num1);
                    compute.setNum2(num1);
                    compute.setAnswer(compute.exponentiate(exponent).Read());
                    System.out.println(strnum1 + " " + strings[1] + " " + exponent + " = " + compute.getAnswer());
                }
                else {
                    for (int i = strings[2].length()-1; i >= 0 ; i--) {
                        char ch = strings[2].charAt(i);
                        num2.add(Character.getNumericValue(ch));
                        strnum2 = ch + strnum2 ;
                    }
                    compute.setNum1(num1);
                    compute.setNum2(num2);
                    if (strings[1].equals("+")) {
                        compute.setAnswer(compute.addLinkedLists().Read());
                    } else if (strings[1].equals("*")) {
                        compute.setAnswer(compute.multiply().Read());
                    }
                    System.out.println(strnum1 + " " + strings[1] + " " + strnum2 + " = " + compute.getAnswer());
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
