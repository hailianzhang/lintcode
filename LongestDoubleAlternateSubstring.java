public class LongestDoubleAlternateSubstring {

    /**
     * @param s: the string
     * @return: length of longest semi alternating substring
     *
     * 输入: "baaabbabbb"
     * 输出: 7
     * 说明: "aabbabb"是最长符合条件的子串
     */
    public static int longestSemiAlternatingSubstring(String s) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(checkPreContinue(s.charAt(i), s, i)){
                if(count > maxCount){
                    maxCount = count;
                }
                count = 2;
            }else {
                count++;
                maxCount = count;
            }
        }
        return maxCount;
    }
    public static boolean checkPreContinue(char c, String s, int i){
        boolean flag = false;
        int count = 1;
        for(int j = i-1; j>=0; j--){
            if(s.charAt(j) == c){
                count++;
                if(count == 3){
                    flag = true;
                    break;
                }
            }else {
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "aabbabb";
        int i = longestSemiAlternatingSubstring(s);
        System.out.println(i);


    }
}
