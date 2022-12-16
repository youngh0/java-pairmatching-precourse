package pairmatching.repository;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class FrontCrews implements Crews{
    private final List<Crew> crewInfo;

    public FrontCrews(List<Crew> crewInfo) {
        this.crewInfo = crewInfo;
    }

    @Override
    public List<Crew> shuffle() {
        return Randoms.shuffle(crewInfo);
    }
}
