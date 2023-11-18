import java.util.Scanner;

class Rational {
    private int p;
    private int q;
    public Rational(int p, int q){
        this.p = p;
        this.q = q;
    }

    public String toString(){
        return p + "/" + q;
    }

    public Rational product (Rational r){
        return new Rational(p * r.p, q * r.q);
    }
}

public class OPPE7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rational r1 = new Rational(scanner.nextInt(), scanner.nextInt());
        Rational r2 = new Rational(scanner.nextInt(), scanner.nextInt());
        Rational r3 = r1.product(r2);
        System.out.println(r3);
    }
}