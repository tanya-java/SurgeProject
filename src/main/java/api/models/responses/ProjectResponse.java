package api.models.responses;

import api.models.results.ProjectResult;
import lombok.Data;

@Data
public class ProjectResponse extends BaseResponse<ProjectResult>  {
    ProjectResult result;
}
