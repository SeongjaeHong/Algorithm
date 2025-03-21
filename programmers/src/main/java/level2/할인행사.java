import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127?language=java
public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        LinkedList<String> queue = new LinkedList<>();
        HashMap<String, Integer> buy = new HashMap<>();

        for (int i=0; i < want.length; i++) {
            buy.put(want[i], number[i]);
        }

        for (int i=0; i < 10; i++) {
            queue.add(discount[i]);
            if (buy.containsKey(discount[i])) {
                buy.replace(discount[i], buy.get(discount[i]) - 1);
            }
            if (buy.values().stream().allMatch(v -> v<=0)) {
                answer += 1;
            }
        }

        String k;
        for (String product: Arrays.copyOfRange(discount, 10, discount.length)) {
            k = queue.poll();
            if (buy.containsKey(k)) {
                buy.replace(k, buy.get(k) + 1);
            }

            queue.add(product);
            if (buy.containsKey(product)) {
                buy.replace(product, buy.get(product) - 1);
            }

            if (buy.values().stream().allMatch(v -> v<=0)) {
                answer += 1;
            }
        }

        return answer;
    }
}
