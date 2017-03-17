class Summ {
  public static void main(String[] args) {
    if (args.length == 2) {
      try {
        System.err.println(Double.parseDouble(args[0]) + Double.parseDouble(args[1]));
      } catch (Throwable t) {
        System.err.println("Error. Perhaps incorrect arguments");
      }
    } else {
      System.err.println("Invalid number of arguments. Enter 2 arguments");
    }
  }
}
