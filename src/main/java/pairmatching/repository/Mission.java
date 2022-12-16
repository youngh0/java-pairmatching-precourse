package pairmatching.repository;

import java.util.Arrays;

public enum Mission {
    RACING("자동차경주",Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),
    SHOPPING_CART("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),
    REFACTORING("성능개선", Level.LEVEL4),
    DEPLOY("배포", Level.LEVEL4);

    private final String missionName;
    private final Level level;

    Mission(String missionName, Level level) {
        this.missionName = missionName;
        this.level = level;
    }

    public static boolean of(String missionName, Level level) {
        Arrays.stream(Mission.values())
                .filter(mission -> mission.missionName.equals(missionName) && mission.level.equals(level))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));
        return true;
    }

    public Level getLevel() {
        return level;
    }
}
