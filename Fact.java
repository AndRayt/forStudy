class Fact {
  public static void main(String[] args) {
    System.out.println(fact(Integer.parseInt(args[0])));
  }
  static int fact(int num) {
    return ((num == 0) ? 1 : num * fact(num - 1));
  }
}
