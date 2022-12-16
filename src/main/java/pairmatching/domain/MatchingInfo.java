package pairmatching.domain;

import pairmatching.repository.Crew;
import pairmatching.repository.Mission;

import java.util.EnumMap;
import java.util.List;

public class MatchingInfo {
    private final EnumMap<Mission, List<List<Crew>>> matchingInfo = new EnumMap<>(Mission.class);

    public void saveMatchingInfo(Mission mission, List<List<Crew>> matchingData) {
        matchingInfo.put(mission, matchingData);
    }

    public boolean isExistMatching(Mission mission) {
        return matchingInfo.containsKey(mission);
    }
}
