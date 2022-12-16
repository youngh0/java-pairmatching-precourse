package pairmatching.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MissionTest {

    @ParameterizedTest
    @CsvSource(value = {"자동차경주:레벨2", "야구게임:레벨1"}, delimiter = ':')
    void 유효한_미션_예외_테스트(String missionName, String level) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Mission.of(missionName, level));
    }

    @ParameterizedTest
    @CsvSource(value = {"자동차경주:레벨1", "숫자야구게임:레벨1"}, delimiter = ':')
    void 유효한_미션_테스트(String missionName, String level) {
        org.assertj.core.api.Assertions.assertThat(Mission.of(missionName, level)).isEqualTo(true);
    }
}