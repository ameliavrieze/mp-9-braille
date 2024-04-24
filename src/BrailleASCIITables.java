package src;

import java.io.FileInputStream;

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
      output = "\\u" + unicode.get(bits);
    } catch (Exception e) {
      System.err.print(e);
    }
    return output;
  }
  
}
