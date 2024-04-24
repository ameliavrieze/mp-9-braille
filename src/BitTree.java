package src;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class BitTree {
  int level;
  BitTreeNode root;

  public BitTree(int n) {
    this.level = n;
    this.root = new BitTreeNode(null, null);
  }

  public void set(String bits, String value) throws Exception {
    if (bits.length() != this.level) {
      throw new Exception("Wrong length of bit string");
    }
    BitTreeNode current = this.root;
    for (int i = 0; i < this.level; i++) {
      if (bits.charAt(i) == '0') {
        if (current.left == null) {
          current.setLeft(new BitTreeNode(null, null));
        }
        current = current.left;
      } else if (bits.charAt(i) == '1') {
        if (current.right == null) {
          current.setRight(new BitTreeNode(null, null));
        }
        current = current.right;
      } else {
        throw new Exception("Invalid character in bit string");
      }
    }
    current.setValue(value);
  }

  public String get(String bits) throws Exception {
    if (bits.length() < this.level) {
      throw new Exception("Wrong bit length");
    }
    BitTreeNode current = this.root;
    for (int i = 0; i < this.level; i++) {
      if (bits.charAt(i) == '0') {
        if (current.left == null) {
          throw new Exception("No path.");
        }
        current = current.left;
      } else {
        if (current.right == null) {
          throw new Exception("No path.");
        }
        current = current.right;
      }
    }
    return current.getValue();
  }

  public void dump(PrintWriter pen) {
    dump(pen, this.root, "");

    //stub
  }

  public void dump(PrintWriter pen, BitTreeNode node, String bits) {
    if (node.left == null && node.right == null) {
       pen.println(bits += "," + node.value);
    }
    if (node.left != null) {
      dump(pen, node.left, bits + "0");
    }
    if (node.right != null) {
      dump(pen, node.right, bits + "1");
    } 
  }

  public void load(InputStream source) throws Exception{
    Scanner input = new Scanner(source);
    String[] line;
    String bits;
    String value;
    while (input.hasNextLine()) {
      line = input.nextLine().split(",");
      bits = line[0];
      value = line[1];
      set(bits, value);
    }
    input.close();
  }

}