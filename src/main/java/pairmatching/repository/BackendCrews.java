package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BackendCrews implements Crews{
    private final List<Crew> crewInfo;

    public BackendCrews(List<Crew> crewInfo) {
        this.crewInfo = crewInfo;
    }

    @Override
    public List<Crew> shuffle() {
        return Randoms.shuffle(crewInfo);
    }
}
