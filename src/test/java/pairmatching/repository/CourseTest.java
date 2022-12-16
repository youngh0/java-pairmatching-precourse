package pairmatching.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Course입력 유효성 검사")
class CourseTest {

    @ParameterizedTest
    @ValueSource(strings = {"벡엔드", "프론트앤드"})
    @DisplayName("잘못된 코스 입력에 대한 예외발생 테스트")
    void WrongCourseNameTest(String courseName) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Course.of(courseName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"백엔드", "프론트엔드"})
    @DisplayName("유효한 코스 입력에 대한 테스트")
    void RightCourseNameTest(String courseName) {
        org.assertj.core.api.Assertions.assertThat(Course.of(courseName)).isEqualTo(true);
    }
}