package pairmatching.repository;

import java.util.List;

public class FrontCrews implements Crews{
    private final List<Crew> crewInfo;

    public FrontCrews(List<Crew> crewInfo) {
        this.crewInfo = crewInfo;
    }
}
