
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    // getToken("sample.txt");
    ParseTree pt = new ParseTree();
    pt.printTree();
  }

  public static void getToken(String fileName) {
    HashMap<String, String> lookup = new HashMap<String, String>();
    lookup.put(";", "toksemicolon");
    lookup.put("=", "tokequals");
    lookup.put("BEGIN", "tokbegin");
    lookup.put("END", "tokend");
    lookup.put(".", "tokperiod");
    lookup.put("PROGRAM", "tokprogram");

    Set<String> identifier = new HashSet<String>(Arrays.asList("PROGRAM", "CONST", "VAR"));

    Stack<String> stack = new Stack<String>();

    try {
      Scanner scanner = new Scanner(new File(fileName));
      String format = "%-20s%s%n";
      String test = "";
      while (scanner.hasNextLine()) {
        String line = scanner.next();
        for (int i = 0; i < line.length(); i++) {
          if (!Character.isDigit(line.charAt(i)) && !Character.isAlphabetic(line.charAt(i))) {
            test = test + " " + line.charAt(i) + " ";
          } else {
            test = test + line.charAt(i);
          }
        }

        test = test + " ";

      }

      String[] splitTest = test.split(" ");

      for (String x : splitTest) {
        if (x == "")
          continue;

        boolean safe = true;
        for (int i = 0; i < x.length(); i++) {
          if (Character.isAlphabetic(x.charAt(i)) && !Character.isAlphabetic(x.charAt(0))) {
            safe = false;
            break;
          } else if (Character.isDigit(x.charAt(i)) && !Character.isDigit(x.charAt(0))) {
            safe = false;
            break;
          }
        }

        // System.out.println(x);

        if (safe) {
          if (Character.isDigit(x.charAt(0)))
            System.out.printf(format, x, "toknum");
          else if (Character.isAlphabetic(x.charAt(0))) {
            if (lookup.containsKey(x)) {
              System.out.printf(format, x, lookup.get(x));
            } else {
              if (identifier.contains(stack.peek()))
                System.out.printf(format, x, "tokidentifier");
              else
                System.out.printf(format, x, "tokword");
            }
          } else {
            if (lookup.containsKey(x)) {
              System.out.printf(format, x, lookup.get(x));
            } else {
              System.out.printf(format, x, "tokop");
            }
          }
          stack.push(x);
        }

      }

      // System.out.println(test);

      scanner.close();
    } catch (

    FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}