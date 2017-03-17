class Expon {
  public static void main(String[] args) {
      int result = Integer.parseInt(args[0]);
      for (int i = 1; i < Integer.parseInt(args[1]); i++) {
        result = result * Integer.parseInt(args[0]);
      }
      System.out.println(result);
    }
}
