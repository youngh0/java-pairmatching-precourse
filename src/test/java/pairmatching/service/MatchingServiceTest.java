package pairmatching.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.MatchingInfo;
import pairmatching.repository.Course;
import pairmatching.repository.Crew;
import pairmatching.repository.CrewInfo;
import pairmatching.repository.Mission;
import pairmatching.util.CrewInfoReader;

import java.io.IOException;
import java.util.List;

class MatchingServiceTest {

    MatchingService matchingService = new MatchingService(new CrewInfo(new CrewInfoReader()), new MatchingInfo());
    CrewInfoReader crewInfoReader = new CrewInfoReader();
    List<Crew> backendCrew;
    MatchingServiceTest() throws IOException {
        backendCrew = crewInfoReader.readBackEndCrew();
    }

    @Test
    void 크루원정보_섞기_테스트() {
        List<Crew> crews = matchingService.shuffleCrews(Course.BACKEND);
        Assertions.assertThat(crews.equals(backendCrew)).isFalse();
    }

    @Test
    void 매칭_정보_존재_여부_테스트() {
        List<Crew> crews = matchingService.shuffleCrews(Course.BACKEND);
        matchingService.saveMatchingInfo(Mission.BASEBALL, matchingService.makePair(crews));
        Assertions.assertThat(matchingService.isExistMatching(Mission.BASEBALL)).isTrue();
    }

    @Test
    void 매칭_정보_존재_여부_FALSE_테스트() {
        List<Crew> crews = matchingService.shuffleCrews(Course.BACKEND);
        matchingService.saveMatchingInfo(Mission.BASEBALL, matchingService.makePair(crews));
        Assertions.assertThat(matchingService.isExistMatching(Mission.DEPLOY)).isFalse();
    }
}