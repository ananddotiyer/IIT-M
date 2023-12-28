package in.ac.iitm.onlinedegree;

import java.util.logging.*;

public class GA2 {
    private final static Logger logbook = Logger.getLogger("in.ac.iitm.onlinedegree");

    public void doIt() {
        // logbook.setLevel(Level.INFO);
        logbook.warning("start of doIt() in in.ac.iitm.onlinedegree");
        logbook.setLevel(Level.OFF);
        logbook.warning("end of doIt() in in.ac.iitm.onlinedegree");
    }
}