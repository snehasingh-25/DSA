public class LC796RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        LC796RotateString solution = new LC796RotateString();
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(solution.rotateString(s, goal));  // Output: true
    }
}
