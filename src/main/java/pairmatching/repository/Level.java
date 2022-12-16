package pairmatching.repository;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    Level(String name) {
        this.name = name;
    }

    public static boolean of(String levelName) {
        Arrays.stream(Level.values())
                .filter(level -> level.getName().equals(levelName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 레벨입니다."));
        return true;
    }

    private String getName() {
        return name;
    }
}
