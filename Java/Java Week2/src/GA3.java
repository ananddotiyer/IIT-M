class GA3 {
    public static void main(String[] args) {
        int i1 = 10, i2 = 29;
        double d;
        d = i2 / i1; //2.0
        System.out.print(d + " ");
        d = (double) (i2 / i1); //2.0
        System.out.print(d + " ");
        d = (double) i2 / i1; //2.9
        System.out.print(d);
    }
}