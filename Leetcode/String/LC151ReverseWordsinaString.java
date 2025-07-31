public class LC151ReverseWordsinaString{
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i=0;
        int n=s.length();
        while(i<n){
            while(i<n && s.charAt(i)==' '){
                i++;
            }
            if(i>=n) break;
            int j=i;
            while(j<n && s.charAt(j)!=' '){
                j++;
            }
            String word=s.substring(i,j);
            if(ans.isEmpty())
                ans.append(word);
            else
                ans.insert(0,word+" ");
            i=j;
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        LC151ReverseWordsinaString solution = new LC151ReverseWordsinaString();
        String s = "  the sky is blue  ";
        String result = solution.reverseWords(s);
        System.out.println("Reversed words: '" + result + "'");
    }
}