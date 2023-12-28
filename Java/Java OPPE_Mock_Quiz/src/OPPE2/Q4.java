package OPPE2;

import java.util.Scanner;

class InvalidInputException extends Exception{
    public InvalidInputException(String msg){
        super(msg);
    }
}
public class Q4 {
    public static int convertCelsToKelv(int cel) throws InvalidInputException{
        if (cel < -273)
            throw new InvalidInputException("Invalid Celsius value");
        return cel + 273;
    }

    public static int convertKelvToCels(int kel) throws InvalidInputException{
        if (kel < 0)
            throw new InvalidInputException("Invalid Kelvin value");
        return kel - 273;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
        convertCelsToKelv(sc.nextInt()); // Celsius
        convertKelvToCels(sc.nextInt()); //Kelvin
        } catch (InvalidInputException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
