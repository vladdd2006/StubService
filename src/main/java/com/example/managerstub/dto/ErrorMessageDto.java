package com.example.managerstub.dto;//package com.example.managerstub.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageDto {

  private int statusCode;
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDateTime timestamp;
  private String message;
}
