public class PA8 {
    int show() {
        try {
            return 10;
        } catch (Exception e) {
            return 20;
        } finally {
            return 100;
        }
    }

    public static void main(String[] args) {
        PA8 object = new PA8();
        System.out.println(object.show());
    }
}