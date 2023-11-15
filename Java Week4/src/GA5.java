interface GA5_Inter {
      public abstract void greet();
}

class GA5_Greetings {
      private String country;

      public void setCountry(String s) {
            this.country = s;
      }

      public String getCountry() {
            return country;
      }

      public GA5_Inter checkCountry() {
            if (getCountry() == "India") {
                  return new IndiaGreetings();
            }
            return new WorldGreetings();
      }

      private class IndiaGreetings implements GA5_Inter {
            public void greet() {
                  System.out.println("Hello" + " " + "India");
            }
      }

      private class WorldGreetings implements GA5_Inter {
            public void greet() {
                  System.out.println("Hello" + " " + "World");
            }
      }
}

public class GA5 {
      public static void main(String[] args) {
            GA5_Greetings g = new GA5_Greetings();
            g.setCountry("India");
            g.checkCountry().greet();
      }
}