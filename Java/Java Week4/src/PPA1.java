import java.util.*;
interface Searchable{
    public int search(int start_index, Object key);
}
class PPA1_Char{
    private char c;
    public PPA1_Char(char c_) {
        c = c_;
    }
    public boolean equals(Object d) {
if (d instanceof PPA1_Char) 
            if (((PPA1_Char) d).c == this.c)
                return true;
        return false;
    }
}
class PPA1_CharArray implements Searchable{
    private PPA1_Char[] carr;
    public PPA1_CharArray(PPA1_Char[] carr_){
        carr = carr_;
    }
    public int search(int start_index, Object key) {
        for(int i = start_index; i < carr.length; i++) {
            if (carr[i].equals(key))
                return i;
        }
        return -1;
    }
}

class PPA1_FrequencyCounter{
    public static int getFrequency(Searchable ob, Object key){
        if (ob instanceof PPA1_CharArray) {
            int findIndex = -1;
            int c = -1;
            do {
                c++;
                findIndex = ob.search(findIndex + 1, (PPA1_Char)key);
            }while(findIndex != -1);
            return c;
        }
        else
            return 0;
    }
}
class PPA1{
    public static void main(String[] args) {
        String str;
        char c;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        c = sc.next().charAt(0);
        PPA1_Char key = new PPA1_Char(c);
        PPA1_Char[] cA = new PPA1_Char[str.length()]; 
        for(int i = 0; i < str.length(); i++) {
            cA[i] = new PPA1_Char(str.charAt(i));
        }
        PPA1_CharArray caObj = new PPA1_CharArray(cA);
        System.out.println(PPA1_FrequencyCounter.getFrequency(caObj, key));
    }
}