package com.example.managerstub.entity;

import com.example.managerstub.constants.MessageFormatEnum;
import com.example.managerstub.constants.ProtocolEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "routes", indexes = {
    @Index(name = "idx_routes_stub", columnList = "stub_id")
})
public class RouteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "stub_id", nullable = false)
  private StubEntity stub;

  @Column(nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "protocol", nullable = false)
  private ProtocolEnum protocol; // REST, KAFKA, GRPS

  @Enumerated(EnumType.STRING)
  @Column(name = "message_format", nullable = false)
  private MessageFormatEnum messageFormat; // JSON, PROTOBUF

  @Column(nullable = false)
  private boolean enabled = true;

  @Column(name = "delay_ms")
  private Integer delayMs = 0;

//  // gRPC поля
//  @Column(name = "proto_content", columnDefinition = "TEXT")
//  private String protoContent;

//  @Column(name = "proto_message_type")
//  private String protoMessageType;

  // REST поля
  @Column(name = "rest_method")
  private String restMethod;

  @Column(name = "rest_path")
  private String restPath;

//  @Column(name = "rest_headers", columnDefinition = "TEXT")
//  private String restHeaders;

  // Kafka поля
  @Column(name = "kafka_topic")
  private String kafkaTopic;

  @Column(name = "kafka_group_id")
  private String kafkaGroupId;

  @Column(name = "kafka_output_topic")
  private String kafkaOutputTopic;

//  // Параметры извлечения (JSON)
//  @Column(name = "extract_params", columnDefinition = "TEXT")
//  private String extractParams;

  /**
   * тело ответа
   */
  @JdbcTypeCode(SqlTypes.JSON)
  @Column(name = "response_body", columnDefinition = "jsonb")
  private Map<String, Object> responseBody;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @UpdateTimestamp
  private LocalDateTime updatedAt;

//  @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, orphanRemoval = true)
//  private List<RuleEntity> rules = new ArrayList<>();

}
