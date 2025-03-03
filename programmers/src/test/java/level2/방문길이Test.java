package level2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 방문길이Test {

    @Test
    void solution() {
        assertAll(
                () -> assertEquals(7, 방문길이.solution("ULURRDLLU")),
                () -> assertEquals(7, 방문길이.solution("LULLLLLLU")),
                () -> assertEquals(0, 방문길이.solution("")),
                () -> assertEquals(1, 방문길이.solution("UDUDU")),
                () -> assertEquals(4, 방문길이.solution("URDLURD")),
                () -> assertEquals(5, 방문길이.solution("URDLURDR")),
                () -> assertEquals(4, 방문길이.solution("LLLRRRR")));
    }
}