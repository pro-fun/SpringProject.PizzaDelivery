package by.academypvt.dto.error;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private int status;
}
