package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.repository.Course;
import pairmatching.repository.Crew;
import pairmatching.repository.Mission;

import java.util.Arrays;
import java.util.List;

class MatchingInfoTest {
    MatchingInfo matchingInfo = new MatchingInfo();
    List<List<Crew>> oldPair = Arrays.asList(
            Arrays.asList(new Crew(Course.BACKEND, "a"),new Crew(Course.BACKEND, "b")),
            Arrays.asList(new Crew(Course.BACKEND, "c"),new Crew(Course.BACKEND, "d")),
            Arrays.asList(new Crew(Course.BACKEND, "e"),new Crew(Course.BACKEND, "f"), new Crew(Course.BACKEND, "g"))
    );

    @Test
    void 중복되는_페어가_있는지_확인() {
        List<List<Crew>> newPair = Arrays.asList(
                Arrays.asList(new Crew(Course.BACKEND, "a"),new Crew(Course.BACKEND, "q")),
                Arrays.asList(new Crew(Course.BACKEND, "esdf"),new Crew(Course.BACKEND, "fwer")),
                Arrays.asList(new Crew(Course.BACKEND, "erew"),new Crew(Course.BACKEND, "ewf")));

        matchingInfo.saveMatchingInfo(Mission.BASEBALL, oldPair);
        Assertions.assertThat(matchingInfo.checkDuplicatePair(newPair, Mission.BASEBALL)).isTrue();
    }

    @Test
    void 중복되는_페어가_있으면_에러발생() {
        List<List<Crew>> newPair = Arrays.asList(
                Arrays.asList(new Crew(Course.BACKEND, "a"),new Crew(Course.BACKEND, "q")),
                Arrays.asList(new Crew(Course.BACKEND, "esdf"),new Crew(Course.BACKEND, "fwer")),
                Arrays.asList(new Crew(Course.BACKEND, "g"),new Crew(Course.BACKEND, "e"), new Crew(Course.BACKEND, "p")));

        matchingInfo.saveMatchingInfo(Mission.BASEBALL, oldPair);
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> matchingInfo.checkDuplicatePair(newPair, Mission.BASEBALL));
    }
}