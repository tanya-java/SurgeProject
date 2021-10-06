package api.models.responses;

import api.models.results.SuiteResult;
import lombok.Data;

@Data
public class SuiteResponse extends BaseResponse<SuiteResult> {
    SuiteResult result;
}
