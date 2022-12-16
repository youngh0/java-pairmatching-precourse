package pairmatching.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.repository.Course;
import pairmatching.repository.Crew;
import pairmatching.repository.CrewInfo;
import pairmatching.util.CrewInfoReader;

import java.io.IOException;
import java.util.List;

class MatchingServiceTest {

    MatchingService matchingService = new MatchingService(new CrewInfo(new CrewInfoReader()));
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
}