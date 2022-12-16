package pairmatching.repository;

import java.util.Arrays;

public enum Mission {
    RACING("자동차경주","레벨1"),
    LOTTO("로또", "레벨1"),
    BASEBALL("숫자야구게임", "레벨1"),
    SHOPPING_CART("장바구니", "레벨2"),
    PAYMENT("결제", "레벨2"),
    SUBWAY("지하철노선도", "레벨2"),
    REFACTORING("성능개선", "레벨4"),
    DEPLOY("배포", "레벨4");

    private final String missionName;
    private final String level;

    Mission(String missionName, String level) {
        this.missionName = missionName;
        this.level = level;
    }

    public static boolean of(String missionName, String level) {
        Arrays.stream(Mission.values())
                .filter(mission -> missionName.equals(mission.missionName) && level.equals(mission.level))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));
        return true;
    }
}
