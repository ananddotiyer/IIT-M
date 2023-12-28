import java.util.logging.*;

public class PA1 {
    public PA1() {
        Logger.getGlobal().config("cont called");
    }

    public void fun() {
        Logger.getGlobal().fine("fun() called");
    }

    public static void main(String[] args) {
        PA1 obj = new PA1();
        Logger.getGlobal().setLevel(Level.FINE);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);
        Logger.getGlobal().addHandler(handler);
        obj.fun();
        Logger.getGlobal().config("fun() return");
        Logger.getGlobal().log(Level.FINER, "end of main()");
    }
}