package level2;

import java.util.HashSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/12981
public class 영어끝말잇기 {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> wordCount = new HashSet<>();

        wordCount.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1) || !wordCount.add(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }

        return answer;
    }
}
