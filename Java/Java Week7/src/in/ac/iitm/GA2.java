package in.ac.iitm;

import java.util.logging.*;

public class GA2 {
    private final static Logger logbook = Logger.getLogger("in.ac.iitm");

    public void doIt() {
        logbook.warning("start of doIt() in in.ac.iitm");
        logbook.setLevel(Level.OFF);
        logbook.warning("end of doIt() in in.ac.iitm");
    }
}