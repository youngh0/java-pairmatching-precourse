package pairmatching.service;

import pairmatching.repository.Course;
import pairmatching.repository.Crew;
import pairmatching.repository.CrewInfo;

import java.util.ArrayList;
import java.util.List;

public class MatchingService {
    private final CrewInfo crewInfo;

    public MatchingService(CrewInfo crewInfo) {
        this.crewInfo = crewInfo;
    }

    public List<Crew> shuffleCrews(Course course) {
        return crewInfo.shuffleCourseCrews(course);
    }

    public void makePair(List<Crew> crews) {
        List<List<Crew>> pairResult = new ArrayList<>();
        int startIdx = 0;
        for (int count = 0; count < crews.size() / 2 - 1; count++) {
            pairResult.add(crews.subList(startIdx, startIdx + 2));
            startIdx += 2;
        }
        pairResult.add(crews.subList(startIdx, crews.size()));
    }
}
