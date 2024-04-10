package org.example.expensetracking.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse <T> {
    private String type;
    private String title;
    private Integer status;
    private String instance;
    private Date timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String detail;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T payload;
}

//   Example:
//            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(
//                  "about:blank",
//                  "Venue updated successfully",
//                  HttpStatus.OK.value(),
//                  "/api/v1/venues/" + id,
//                  new Date(),
//                  null,
//                  capitalizedVenue
//            ));
