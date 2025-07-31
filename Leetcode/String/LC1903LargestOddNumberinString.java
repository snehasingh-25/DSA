public class LC1903LargestOddNumberinString {
    public String largestOddNumber(String num) {
        int n=num.length();
        for(int i=n-1;i>=0;i--){
            int number=num.charAt(i)-'0';
            // System.out.println(number);
            if(number%2!=0){
                return num.substring(0,i+1);
            }
        }
        return "";
    }
    public static void main(String[] args) {
        LC1903LargestOddNumberinString solution = new LC1903LargestOddNumberinString();
        String num = "52";
        String result = solution.largestOddNumber(num);
        System.out.println("Largest odd number in string: '" + result + "'");
    }
}
