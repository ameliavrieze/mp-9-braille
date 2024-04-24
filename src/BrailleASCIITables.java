package src;

import java.io.FileInputStream;
import java.io.PrintWriter;

/**
 * A utility class to translate between character sets and dump translation tables.
 * @author Amelia Vrieze
 */

public class BrailleASCIITables {
  static BitTree braille = new BitTree(8);
  static BitTree ascii = new BitTree(6);
  static BitTree unicode = new BitTree(6);

  public static String toBraille(char letter) {
    String output = "";
    try {
      braille.load(new FileInputStream("ASCIIToBraille.txt"));
      output = braille.get("0" + Integer.toBinaryString((int) letter));
    } catch (Exception e) {
      System.err.println(e);
    }
    return output;
  }

  public static String toASCII(String bits) {
    String output = "";
    try {
      ascii.load(new FileInputStream("BrailleToASCII.txt"));
      output = ascii.get(bits);
    } catch (Exception e) {
      System.err.print(e);
    }
    return output;
  }

  public static String toUnicode(String bits) {
    String output = "";
    try {
      unicode.load(new FileInputStream("BrailleToUnicode.txt"));
      output += Character.toChars(Integer.parseInt(unicode.get(bits), 16));
    } catch (Exception e) {
      System.err.print(e);
    }
    return output;
  }

  public static void dumpAll(PrintWriter pen) {
    try {
      braille.load(new FileInputStream("ASCIIToBraille.txt"));
      ascii.load(new FileInputStream("BrailleToASCII.txt"));
      unicode.load(new FileInputStream("BrailleToUnicode.txt"));
    } catch (Exception e) {
      System.err.print(e);
    }
    pen.println("ASCII to Braille:");
    braille.dump(pen);
    pen.println("Braille to ASCII:");
    ascii.dump(pen);
    pen.println("Braille to Unicode:");
    unicode.dump(pen);
  }
  
}
