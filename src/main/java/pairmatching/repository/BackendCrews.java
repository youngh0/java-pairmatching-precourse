package pairmatching.repository;

import java.util.List;

public class BackendCrews implements Crews{
    private final List<Crew> crewInfo;

    public BackendCrews(List<Crew> crewInfo) {
        this.crewInfo = crewInfo;
    }
}
