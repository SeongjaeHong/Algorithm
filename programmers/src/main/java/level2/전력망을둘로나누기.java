package level2;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/86971
public class 전력망을둘로나누기 {
    ArrayList<ArrayList<Integer>> nodes;

    public int solution(int n, int[][] wires) {
        nodes = new ArrayList<>(n + 1);

        for (int i = 1; i <= n + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            nodes.get(wire[0]).add(wire[1]);
            nodes.get(wire[1]).add(wire[0]);
        }

        int minDiff = n;
        int cnt;
        int diff;
        boolean[] visits;
        for (int[] wire : wires) {
            nodes.get(wire[0]).remove(Integer.valueOf(wire[1]));
            nodes.get(wire[1]).remove(Integer.valueOf(wire[0]));

            visits = new boolean[n + 1];
            visits[1] = true;
            cnt = size(visits, 1);
            diff = n - 2 * cnt;
            if (diff < 0) {
                diff *= -1;
            }
            if (diff < minDiff) {
                minDiff = diff;
            }

            nodes.get(wire[0]).add(wire[1]);
            nodes.get(wire[1]).add(wire[0]);
        }

        return minDiff;
    }

    int size(boolean[] visits, int curNode) {
        int cnt = 1;

        for (Integer node : nodes.get(curNode)) {
            if (!visits[node]) {
                visits[node] = true;
                cnt += size(visits, node);
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int[][] arr2 = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        int[][] arr3 = new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        int[][] arr4 = new int[][]{{1, 2}, {2, 3}};
        int[][] arr5 = new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}, {9, 10}, {10, 11}};
        전력망을둘로나누기 cls = new 전력망을둘로나누기();

        int[][] arr = arr5;
        int diff = cls.solution(arr.length + 1, arr);
        System.out.println("diff = " + diff);
    }
}
