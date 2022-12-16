package pairmatching.repository;

import pairmatching.util.CrewInfoReader;

import java.io.IOException;

public class CrewInfo {
    private final BackendCrews backendCrews;
    private final FrontCrews frontCrews;

    public CrewInfo(CrewInfoReader crewInfoReader) throws IOException {
        this.backendCrews = new BackendCrews(crewInfoReader.readBackEndCrew());
        this.frontCrews = new FrontCrews(crewInfoReader.readFrontEndCrew());
    }
}
