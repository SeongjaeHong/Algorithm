import java.util.HashSet;

public class Solution {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> wordCount = new HashSet<>();

        wordCount.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || !wordCount.add(words[i])) {
                if ((i + 1) % n == 0) {
                    answer[0] = n;
                    answer[1] = (i + 1) / n;
                } else {
                    answer[0] = (i + 1) % n;
                    answer[1] = (i + 1) / n + 1;
                }
                break;
            }
        }

        return answer;
    }
}