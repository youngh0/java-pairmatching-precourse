package pairmatching.domain;

import pairmatching.repository.Crew;
import pairmatching.repository.Level;
import pairmatching.repository.Mission;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingInfo {
    private final EnumMap<Mission, List<List<Crew>>> matchingInfo = new EnumMap<>(Mission.class);

    public void saveMatchingInfo(Mission mission, List<List<Crew>> matchingData) {
        matchingInfo.put(mission, matchingData);
    }

    public boolean isExistMatching(Mission mission) {
        return matchingInfo.containsKey(mission);
    }

    public boolean checkDuplicatePair(List<List<Crew>> pairInfo, Mission mission) {
        Level level = mission.getLevel();

        List<Mission> sameLevelMission = matchingInfo.keySet().stream()
                .filter(matching -> matching.getLevel().equals(level))
                .collect(Collectors.toList());
        return processThreeTime(sameLevelMission, pairInfo);
    }

    private boolean processThreeTime(List<Mission> missions,List<List<Crew>> pairInfo) {
        int chance = 3;
        boolean isSuccess = true;
        while (chance-- > 0) {
            for (Mission mission : missions) {
                isSuccess = checkPerMissionPair(mission, pairInfo) && isSuccess;
            }
            if (isSuccess) {
                return true;
            }
        }
        throw new IllegalArgumentException("매칭에 3번 이상 실패");
    }

    private boolean checkPerMissionPair(Mission mission, List<List<Crew>> pairInfo) {
        return isUnique(pairInfo, mission);
    }
    private boolean isUnique(List<List<Crew>> newPairInfo, Mission missionName) {
        for (List<Crew> crews : newPairInfo) {
            if(checkDuplicateCount(crews, missionName)){
                return false;
            }
        }
        return true;
    }

    private boolean checkDuplicateCount(List<Crew> crews, Mission missionName) {
        int duplicateCount = 0;
        for (Crew crew : crews) {
            List<List<Crew>> basePair = matchingInfo.get(missionName);
            if (basePair.stream()
                    .anyMatch(baseData -> baseData.contains(crew))) {
                duplicateCount += 1;
            }
            System.out.println(duplicateCount);
            if (duplicateCount >= 2) {
                return true;
            }
        }
        return false;
    }
}
