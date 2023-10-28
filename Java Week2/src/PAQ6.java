class PAQ6{
          int i = 10;
          public PAQ6(int _i) { i = 20; }
          public void print() { System.out.println(i); }
}
class PQ{
       public static void main(String[] args) {
             int i = 30;
             PAQ6 obj = new PAQ6(i);
             obj.print();
     }
}