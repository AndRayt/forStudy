class Expon {
  public static void main(String[] args) {
    if (args.length == 2) {
      try {int result = Integer.parseInt(args[0]);
      for (int i = 1; i < Integer.parseInt(args[1]); i++) {
        result = result * Integer.parseInt(args[0]);
      }
      System.out.println(result); }
      catch(Throwable t) {
        System.err.println("Error. Perhaps incorrect arguments");
      }
    } else {
      System.err.println("Invalid number of arguments. Enter 2 arguments");
    }
    }
}
