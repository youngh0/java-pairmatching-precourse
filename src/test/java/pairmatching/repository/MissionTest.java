package pairmatching.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MissionTest {

    @ParameterizedTest
    @ValueSource(strings = {"자동차경주", "야구게임"})
    void 유효한_미션_예외_테스트(String missionName) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Mission.of(missionName, Level.LEVEL2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"자동차경주", "숫자야구게임"})
    void 유효한_미션_테스트(String missionName) {
        org.assertj.core.api.Assertions.assertThat(Mission.of(missionName, Level.LEVEL1)).isEqualTo(true);
    }
}