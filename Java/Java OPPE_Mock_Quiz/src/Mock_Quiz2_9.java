class Mock_Quiz2_9_Bowler {
      String name;
      String type;

      public Mock_Quiz2_9_Bowler(String name, String type) {
            this.name = name;
            this.type = type;
      }

      public String toString() {
            return " [name=" + name + ", type=" + type + "]";
      }
}

class Mock_Quiz2_9_AllRounder extends Mock_Quiz2_9_Bowler {
      public Mock_Quiz2_9_AllRounder(String name, String type) {
            super(name, type);
      }

      public String toString() {
            return " [name=" + name + ", dept=" + type + "]";
      }
}

public class Mock_Quiz2_9 {
      public static <S extends T, T> void copy(S[] src, T[] tgt) {
            int i, limit;
            limit = Math.min(src.length, tgt.length);
            for (i = 0; i < limit; i++) {
                  tgt[i] = src[i];
            }
      }

      public static void main(String[] args) {
            Mock_Quiz2_9_AllRounder obj1 = new Mock_Quiz2_9_AllRounder("V.Iyer", "AllRounder");
            Mock_Quiz2_9_AllRounder obj2 = new Mock_Quiz2_9_AllRounder("D.Hooda", "AllRounder");
            Mock_Quiz2_9_AllRounder obj3 = new Mock_Quiz2_9_AllRounder("R.Jadeja", "AllRounder");
            Mock_Quiz2_9_AllRounder allRounders[] = { obj1, obj2, obj3 };
            Mock_Quiz2_9_Bowler[] bowlers = new Mock_Quiz2_9_Bowler[2];
            Mock_Quiz2_9.copy(allRounders, bowlers);
            for (int i = 0; i < bowlers.length; i++) {
                  System.out.println(bowlers[i]);
            }
      }
}