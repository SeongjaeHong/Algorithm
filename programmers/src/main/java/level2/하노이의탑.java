package level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/12946
public class 하노이의탑 {
    int[][] answer = {};
    int idx = 0;
    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n)-1][2];
        move(n, 1, 2, 3);

        return answer;
    }

    void move(int n, int start, int via, int to) {
        if (n == 1) {
            answer[idx][0] = start;
            answer[idx++][1] = to;
            return;
        }

        move(n-1, start, to, via);
        answer[idx][0] = start;
        answer[idx++][1] = to;
        move(n-1, via, start, to);
    }

    public static void main(String[] args) {
        하노이의탑 c = new 하노이의탑();
        int[][] solution = c.solution(3);
        for (int[] s: solution) {
            System.out.println("{" + s[0] + "," + s[1] + "}");
        }
    }
}
