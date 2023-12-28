import java.util.logging.*;

class SomeClass {
    private final static Logger logbook = Logger.getLogger(SomeClass.class.getName());

    public void logIt() {
        logbook.info("logIt() called");
        logbook.setLevel(Level.INFO);
    }
}

public class PA2 {
    private final static Logger logbook = Logger.getLogger(PA2.class.getName());

    public static void main(String[] args) {
        logbook.info("main() started");
        logbook.setLevel(Level.WARNING);
        SomeClass obj = new SomeClass();
        obj.logIt();
        logbook.info("main() ends");
    }
}