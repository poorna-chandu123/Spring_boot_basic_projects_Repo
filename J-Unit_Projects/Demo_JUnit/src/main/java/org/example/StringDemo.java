package org.example;

public class StringDemo {

    public int stringToInt(String str) {

        if (str == null || str.isEmpty() || str.isBlank() || str.length() == 0) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        return Integer.parseInt(str);
    }
  /*  public static void main(String[] args) {
        StringDemo stringDemo = new StringDemo();
      int i   = stringDemo.stringToInt("123");
        System.out.println("valaue is = "+i);
    }*/
}
