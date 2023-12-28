import java.util.Scanner;
class PAQ8
{
        public static void main(String[] args)
        {
              Scanner sc=new Scanner(System.in);
              System.out.println("Please enter the any ASIA cricket team");
              String country=sc.next();
              sc.close();
              switch(country)
              {
                    case "India":
                        System.out.println("Delhi is capital of "+country);
                    case "SriLanka":
                         System.out.println("Colombo is capital of "+country);
                    default:
                         System.out.println("Please enter valid country name:");
                         break;
              }
      }
}