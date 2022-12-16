package pairmatching.util;

import pairmatching.repository.Course;
import pairmatching.repository.Crew;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewInfoReader {
    private final String backendCrewDirectory = "src/main/resources/backend-crew.md";
    private final String frontCrewDirectory = "src/main/resources/frontend-crew.md";
    private final List<Crew> backEndCrews = new ArrayList<>();
    private final List<Crew> frontEndCrews = new ArrayList<>();

    public List<Crew> readBackEndCrew() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(backendCrewDirectory));
        while(true) {
            String name = br.readLine();
            if (name==null) {
                break;
            }
            backEndCrews.add(new Crew(Course.BACKEND, name));
        }
        br.close();
        return backEndCrews;
    }

    public List<Crew> readFrontEndCrew() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(frontCrewDirectory));
        while(true) {
            String name = br.readLine();
            if (name==null) {
                break;
            }
            frontEndCrews.add(new Crew(Course.FRONTEND, name));
        }
        br.close();
        return frontEndCrews;
    }
}
