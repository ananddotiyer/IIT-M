interface Mock_Quiz2_13_TV {
    abstract void features(String name);
}

class Mock_Quiz2_13_LedTv implements Mock_Quiz2_13_TV {
    public void features(String name) {
        System.out.println("Picture quality of " + name + " TV is good.");
    }
}

class Mock_Quiz2_13_SmartTv extends Mock_Quiz2_13_LedTv {
    public void features(String name) {
        super.features(name);
        System.out.println(name + " TV similar to LED TV with internet connection");
    }
}

public class Mock_Quiz2_13 {
    public <T extends Mock_Quiz2_13_TV> void getDetails(T obj, String name) { // Line 1
        obj.features(name);
    }

    public static void main(String[] args) {
        Mock_Quiz2_13 obj = new Mock_Quiz2_13();
        obj.getDetails(new Mock_Quiz2_13_LedTv(), "Led");
        obj.getDetails(new Mock_Quiz2_13_SmartTv(), "Smart"); // Line 2
    }
}