class PAQ7 {
     public static void main(String[] args) {
            String str = "we are here to learn java";
            String str1 = "";
            char[] ch = {'a', 'e', 'i','o', 'u'}; 
            for(char c : ch){
                  for (int i = 0; i < str.length(); i++){
                        if (str.charAt(i) == c){
                             str1 += c;
                        }
                  }
            }
            System.out.println(str1);
      }
}