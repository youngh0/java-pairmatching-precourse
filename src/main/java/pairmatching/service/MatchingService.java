package pairmatching.service;

import pairmatching.repository.Course;
import pairmatching.repository.Crew;
import pairmatching.repository.CrewInfo;

import java.util.List;

public class MatchingService {
    private final CrewInfo crewInfo;

    public MatchingService(CrewInfo crewInfo) {
        this.crewInfo = crewInfo;
    }

    public List<Crew> shuffleCrews(Course course) {
        return crewInfo.shuffleCourseCrews(course);
    }
}
