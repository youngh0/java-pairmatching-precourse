package pairmatching.repository;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    Course(String name) {
        this.name = name;
    }

    public static boolean of(String courseName) {
        Arrays.stream(Course.values())
                .filter(course -> course.getName().equals(courseName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 코스입니다."));
        return true;
    }

    public String getName() {
        return name;
    }
}
