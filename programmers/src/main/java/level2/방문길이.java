package level2;

import java.util.HashSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/49994
public class 방문길이 {
    // 조건 1. 한 번 갔던 길은 셈하지 않는다.
    // 조건 2. 맵 밖을 나가는 명령은 무시한다.
    public static int solution(String dirs) {
        int answer = 0;

        int vertical = 0;
        int horizon = 0;

        HashSet<String> routes = new HashSet<>();
        String route = "";
        for (int i=0; i < dirs.length(); i ++) {
            switch (dirs.charAt(i)) {
                case 'U':
                    if (vertical + 1 > 5) {
                        continue;
                    }
                    vertical += 1;
                    if (vertical > 0){
                        route = "V" + vertical + "H" + horizon;
                    } else {
                        route = "V" + (vertical - 1) + "H" + horizon;
                    }
                    break;
                case 'D':
                    if (vertical - 1 < -5) {
                        continue;
                    }
                    vertical -= 1;
                    if (vertical >= 0){
                        route = "V" + (vertical + 1) + "H" + horizon;
                    } else {
                        route = "V" + vertical + "H" + horizon;
                    }
                    break;
                case 'L':
                    if (horizon - 1 < -5) {
                        continue;
                    }
                    horizon -= 1;
                    if (horizon >= 0){
                        route = "H" + (horizon + 1) + "V" + vertical;
                    } else {
                        route = "H" + horizon + "V" + vertical;
                    }
                    break;
                case 'R':
                    if (horizon + 1 > 5) {
                        continue;
                    }
                    horizon += 1;
                    if (horizon > 0){
                        route = "H" + horizon + "V" + vertical;
                    } else {
                        route = "H" + (horizon - 1) + "V" + vertical;
                    }
                    break;
            }
            if (routes.add(route)) {
                answer += 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("UUUUULLULRD"));
    }
}
