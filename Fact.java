class Fact {
  public static void main(String[] args) {
  if (args.length == 1) {
    try {
        System.out.println(fact(Integer.parseInt(args[0])));
    }  catch(Throwable t) {
        System.err.println("Error. Perhaps incorrect arguments");
    }
  } else {
    System.err.println("Invalid number of arguments. Enter 1 argument");
  }
  }
  static int fact(int num) {
    return ((num == 0) ? 1 : num * fact(num - 1));
  }
}
