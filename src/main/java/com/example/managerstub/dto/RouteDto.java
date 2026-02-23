package com.example.managerstub.dto;//package com.example.managerstub.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

  @Schema(example = "0")
  private Long id;
  @Schema(defaultValue = "null")
  private Long stubId;
  private String name;
  @Schema(example = "REST")
  private String protocol;
  @Schema(example = "JSON")
  private String messageFormat;
  @Schema(example = "true")
  private boolean enabled;
  private Integer delayMs;

  // REST
  private String restMethod;
  private String restPath;

  // Kafka
  private String kafkaTopic;
  private String kafkaGroupId;
  private String kafkaOutputTopic;

  // Параметры извлечения
//  private List<Map<String, Object>> extractParams;

  private Map<String, Object> responseBody;

  // Правила
//  private List<RuleDto> rules;
//  private int rulesCount;

}
