class sub {
    sub() {
        System.out.println("no arg sub constructor");
    }
    sub(int sub) {
        System.out.println("sub constructor");
    }
}

class sub_sub extends sub {
    sub_sub(int sub_sub) {
        super(sub_sub);
        System.out.println("sub_sub constructor");
    }
}
public class implicit_super {
    public static void main(String[] args) {
        sub_sub s = new sub_sub(4);
    }
}
