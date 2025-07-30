public class LC1021RemoveOutermostParentheses{
    public String remove(String s){
        StringBuilder ans=new StringBuilder();
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                cnt--;
            }
            if(cnt!=0){
                ans.append(s.charAt(i));
            }
            if(s.charAt(i)=='('){
                cnt++;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args){
        LC1021RemoveOutermostParentheses solution = new LC1021RemoveOutermostParentheses();
        String s = "(()())(())";
        String result = solution.remove(s);
        System.out.println("Result after removing outermost parentheses: " + result);
    }
}