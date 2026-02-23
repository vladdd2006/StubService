package com.example.managerstub.dto;//package com.example.managerstub.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StubDto {

  @Schema(example = "0")
  private Long id;
  // название стаба
  private String name;
  // название проектной области
  private String projectName;
  // список роутов
  @JsonProperty(value = "routes")
  private List<RouteDto> routes;
  //  private int routesCount;

}
