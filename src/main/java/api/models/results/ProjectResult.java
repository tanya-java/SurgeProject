package api.models.results;

import lombok.Data;

@Data
public class ProjectResult {
    String title;
    String code;
    String counts;
    String cases;
    String suites;
    String milestones;
}
