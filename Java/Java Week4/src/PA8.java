
   interface PA8_City{
         public abstract void travel(String name);
   }
   class PA8_Mumbai implements PA8_City{
         public void travel(String name) {
               System.out.println(name+" Travelling to Mumbai");
         }
   }
   class PA8_Hyderabad implements PA8_City{
         public void travel(String name) {
               System.out.println(name+" Travelling to Hyderabad");
         }
   }
   class PA8_Traveller{
         private PA8_City city;
         private String name;
         public PA8_Traveller(PA8_City city,String name) {
              this.city = city;
              this.name = name;
         }
         public void journey(){
               city.travel(name);
         }
   }
   public class PA8{
         public static void main(String[] args) {
              PA8_Traveller traveller1=new PA8_Traveller(new PA8_Hyderabad(),"Johny");
              traveller1.journey();
              PA8_Traveller traveller2=new PA8_Traveller(new PA8_Mumbai(),"Virat");
              traveller2.journey();
        }
   }