package src;

import java.io.PrintWriter;

/**
 * A main utility class to translate between the various character sets.
 * @author Amelia Vrieze
 */

public class BrailleASCII {
  public static void main(String[] args) {

    if (args.length < 2) {
      System.err.println("Missing args.");
    }
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args[0].equals("braille")) {
      char[] text = args[1].toUpperCase().toCharArray();
      String result = "";
      for (char c : text) {
        result += BrailleASCIITables.toBraille(c);
      }
      pen.println(result);

    } else if (args[0].equals("ascii")) {
      String[] letters = new String[args[1].length() / 6];
      int index = 0;
      String result = "";
      for (int i = 0; i < args[1].length(); i += 6) {
        letters[index] = args[1].substring(i, i + 6);
        index++;
      }
      for (String letter : letters) {
        result += BrailleASCIITables.toASCII(letter);
      }
      pen.println(result);

    } else if (args[0].equals("unicode")) {
      char[] text = args[1].toUpperCase().toCharArray();
      String result = "";
      for (char letter : text) {
        result += BrailleASCIITables.toUnicode(BrailleASCIITables.toBraille(letter));
      }
      pen.println(result);


    } else {
      System.err.println("Invalid target character set.");
    }

    BrailleASCIITables.dumpAll(pen);

  } 
}
