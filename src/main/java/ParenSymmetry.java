import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParenSymmetry {

    public Boolean isBalanced(String s) {
        String g;
        int x=0, idx = 0;

        while(idx < s.length()){
            g = String.valueOf(s.charAt(idx));
            if(g.equals("(")){
                x++;
            }else if(g.equals(")")){
                x--;
            } else if (x <0) {
                return false;
            }
            idx++;
        }

        if(x <0){
            return false;
        } else if(x >0){
            return false;
        } else if(x == 0) {
            return true;
        }
        return null;
    }

    private void checkFile(String filename) {
        // open file named filename
        String data ="";
        try{
            File textFile = new File(filename);
            Scanner s = new Scanner(textFile);
            while (s.hasNextLine()){
                data = s.nextLine();
                System.out.print(isBalanced(data) + ", ");

            }
            s.close();
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();
        ps.checkFile("TestStrings0.txt");

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
