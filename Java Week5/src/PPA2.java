import java.util.Scanner;

class ConvertArrays {
    public Double doubleArr[] = new Double[3];
    public Integer intArr[] = new Integer[3];
    public int x = 0, y = 0, z = 0;

    public void convert(String[] arr) {
        for (x = 0; x < arr.length; x++) {
            try {
                Integer intValue = Integer.parseInt(arr[x]);
                intArr[y] = intValue;
                y++;
            } catch (NumberFormatException e) {
                try {
                    Double doubleValue = Double.parseDouble(arr[x]);
                    doubleArr[z] = doubleValue;
                    z++;
                } catch (NumberFormatException ex) {
                    // handle the case where 'each' does not contain a valid integer or double
                }
            }
        }

    }

    public <T> void display(T[] arr) {
        for (T elements : arr)
            System.out.print(elements + " ");
        System.out.println();
    }
}

public class PPA2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arr[] = new String[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.next();
        }
        ConvertArrays conArrays = new ConvertArrays();
        conArrays.convert(arr);
        System.out.println("===After conversion Arrays===");
        conArrays.display(conArrays.doubleArr);
        conArrays.display(conArrays.intArr);
    }
}