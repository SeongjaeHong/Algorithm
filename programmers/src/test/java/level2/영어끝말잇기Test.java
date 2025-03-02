package level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 영어끝말잇기Test {

    @Test
    void solution() {
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        int[] answers = {3 ,3};
        int[] answers2 = {0, 0};
        int[] answers3 = {1, 3};
        assertAll(
                () -> assertArrayEquals(answers, 영어끝말잇기.solution(3, words1)),
                () -> assertArrayEquals(answers2, 영어끝말잇기.solution(5, words2)),
                () -> assertArrayEquals(answers3, 영어끝말잇기.solution(2, words3))
        );
    }
}