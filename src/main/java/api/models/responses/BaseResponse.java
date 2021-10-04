package api.models.responses;

import lombok.Data;

@Data
public class BaseResponse <R> {
    boolean status;
    R result;
}
