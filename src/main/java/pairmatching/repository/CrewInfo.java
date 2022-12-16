package pairmatching.repository;

import pairmatching.util.CrewInfoReader;

import java.io.IOException;
import java.util.EnumMap;
import java.util.List;

public class CrewInfo {
    private final EnumMap<Course, Crews> courseCrewInfo = new EnumMap<>(Course.class);

    public CrewInfo(CrewInfoReader crewInfoReader) throws IOException {
        courseCrewInfo.put(Course.BACKEND,new BackendCrews(crewInfoReader.readBackEndCrew()));
        courseCrewInfo.put(Course.FRONTEND, new FrontCrews(crewInfoReader.readFrontEndCrew()));
    }

    public List<Crew> shuffleCourseCrews(Course course) {
        return courseCrewInfo.get(course).shuffle();
    }
}
