class GA7 {
    public static void main(String[] args) {
        int i = 0;
        System.out.println("From the while loop");
        while (i > 0) {
            System.out.println(i);
        }
        System.out.println("From the do-while loop.  Will execute at least once");
        do {
            System.out.println(i);
        } while (i > 0);
    }
}