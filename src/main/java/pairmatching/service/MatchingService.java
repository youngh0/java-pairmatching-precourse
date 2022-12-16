package pairmatching.service;

import pairmatching.domain.MatchingInfo;
import pairmatching.repository.Course;
import pairmatching.repository.Crew;
import pairmatching.repository.CrewInfo;
import pairmatching.repository.Mission;

import java.util.ArrayList;
import java.util.List;

public class MatchingService {
    private final CrewInfo crewInfo;
    private final MatchingInfo matchingInfo;

    public MatchingService(CrewInfo crewInfo, MatchingInfo matchingInfo) {
        this.crewInfo = crewInfo;
        this.matchingInfo = matchingInfo;
    }

    public boolean isExistMatching(Mission mission) {
        return matchingInfo.isExistMatching(mission);
    }

    public List<Crew> shuffleCrews(Course course) {
        return crewInfo.shuffleCourseCrews(course);
    }

    public List<List<Crew>> makePair(List<Crew> crews) {
        List<List<Crew>> pairResult = new ArrayList<>();
        int startIdx = 0;
        for (int count = 0; count < crews.size() / 2 - 1; count++) {
            pairResult.add(crews.subList(startIdx, startIdx + 2));
            startIdx += 2;
        }
        pairResult.add(crews.subList(startIdx, crews.size()));
        return pairResult;
    }

    public void saveMatchingInfo(Mission mission, List<List<Crew>> matchingData) {
        matchingInfo.saveMatchingInfo(mission, matchingData);
    }
}
