   interface DBIF{
        public void executeStatement(String qry);
   }

    class Database{
            private ConnectionObj cobj = null;
            // public ConnectionObj connectDB(String u, String p) {
            public DBIF connectDB(String u, String p) {
                 if(isValidate(u, p))
                       cobj = new ConnectionObj();
                 return cobj;
            }
            public boolean isValidate(String u, String p) {
                  //assume the vaidation is always true
                  return true;
            }
            private class ConnectionObj implements DBIF{
                  public void executeStatement(String qry) {
                       System.out.println("Execute: " + qry);
                  }
           }
   }
   public class GA4{
           public static void main(String[] args) {
                  DBIF con = new Database().connectDB("test", "test");
                  con.executeStatement("fetch students");
           }
   }