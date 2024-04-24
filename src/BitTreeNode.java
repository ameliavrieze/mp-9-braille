package src;

public class BitTreeNode {

  String value;
  BitTreeNode left = null;
  BitTreeNode right = null;

  public BitTreeNode(BitTreeNode left, BitTreeNode right) {
    this.left = left;
    this.right = right;
    this.value = null;
  }

  public BitTreeNode(String value) {
    this.value = value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setLeft(BitTreeNode left) {
    this.left = left;
  }

  public void setRight(BitTreeNode right) {
    this.right = right;
  }

  public BitTreeNode getLeft() {
    return this.left;
  }

  public BitTreeNode getRight() {
    return this.right;
  }


  
}
