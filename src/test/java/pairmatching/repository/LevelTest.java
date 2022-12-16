package pairmatching.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LevelTest {
    @ParameterizedTest
    @ValueSource(strings = {"레벨6", "레벨0", "래벨3"})
    @DisplayName("레벨 입력에 대한 유효성 검사")
    void 레벨_유효성_예외_테스트(String levelName) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Level.of(levelName));
    }
}