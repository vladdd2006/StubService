package com.example.managerstub.mapper;//package com.example.managerstub.mapper;

import com.example.managerstub.dto.RouteDto;
import com.example.managerstub.entity.RouteEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface RouteMapper {

  @Mapping(target = "stubId", source = "stub.id")
  RouteDto entityToDto(RouteEntity entity);

  List<RouteDto> entityToDtoList(List<RouteEntity> entityList);

  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  @Mapping(target = "stub", ignore = true)
  RouteEntity dtoToEntity(RouteDto dto);
}
