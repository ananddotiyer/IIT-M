class Mock_Quiz1_2_Engine {
    private class Fuel {
        String i_fuelType;

        public boolean isFossilFuel(String fuelType) {
            if (fuelType == "Petrol" || fuelType == "Diesel")
                return true;
            else
                return false;
        }
    }

    public String Mock_Quiz1_2_maxMileage(String fuelType) {
        Fuel f = new Fuel();
        if (!f.isFossilFuel(fuelType)) // Line 1
            return "Low";
        else
            return "High";
    }
}

public class Mock_Quiz1_2 {
    public static void main(String[] args) {
        Mock_Quiz1_2_Engine e = new Mock_Quiz1_2_Engine();
        int i = 0;
        String fType[] = { "Biodiesel", "Diesel", "Petrol", "Steam" };
        for (i = 0; i < 4; i++) {
            System.out.println(e.Mock_Quiz1_2_maxMileage(fType[i])); // Line 2
        }
    }
}