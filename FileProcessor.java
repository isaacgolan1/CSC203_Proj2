import java.io.File;
import java.io.FileNotFoundException;
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
                LinkedList num1 = new LinkedList();
                LinkedList num2 = new LinkedList();
                LinkedList answer = new LinkedList();
                String[] strings = line.split(" ");
                BigInteger compute = new BigInteger();
                compute.setAnswer(answer);
                for (int i = strings[0].length()-1; i >= 0 ; i--) {
                    char ch = strings[0].charAt(i);
                    num1.add((int) (ch));
                }
                if (strings[1].equals("^")){
                    for (int i = strings[0].length()-1; i >= 0 ; i--) {
                        char ch = strings[0].charAt(i);
                        num2.add((int) (ch));
                    }
                    int exponent = Integer.parseInt(strings[2]);
                    compute.exponentiate(exponent);
                }
                else {
                    for (int i = strings[2].length()-1; i >= 0 ; i--) {
                        char ch = strings[2].charAt(i);
                        num2.add((int) (ch));
                    }
                    compute.setNum1(num1);
                    compute.setNum2(num2);
                    if (strings[1].equals("+")) {
                        compute.add();
                    } else if (strings[1].equals("*")) {
                        compute.multiply();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
