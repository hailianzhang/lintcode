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
    
     public static int longestSemiAlternatingSubstring2(String s){
        int result = 0;
        if(s == null || s.isEmpty()){
            return result;
        }
        int size = s.length();
        if(size < 3){
            return size;
        }
        int i = 0;
        char[] charArray = s.toCharArray();
        int count = 1;
        for (int j = 1; j < size ; j++) {
            char currentChar = charArray[j];
            char preChar = charArray[j - 1];
            //每次比较前后的字符，如果一样count++，只要不一样，count恢复初始值1
            count = (currentChar == preChar)? (count + 1) : 1;
            if(count == 3){
                //如果遇到三连，将初始位置标注，把count初始值设置成2
                i = j - 1;
                count = 2;
            }
            //result用来存每次的最长长度，i为初始值的index，j为当前的index
            result = Math.max(result, j-i+1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aabbabb";
        int i = longestSemiAlternatingSubstring2(s);
        System.out.println(i);


    }
}
