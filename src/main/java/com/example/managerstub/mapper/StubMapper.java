package com.example.managerstub.mapper;//package com.example.managerstub.mapper;

import com.example.managerstub.dto.StubDto;
import com.example.managerstub.entity.StubEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    uses = {RouteMapper.class}
)
public interface StubMapper {

  StubDto entityToDto(StubEntity entity);

  List<StubDto> entityToDtoList(List<StubEntity> entityList);

  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  StubEntity dtoToEntity(StubDto dto);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", ignore = true)
  @Mapping(target = "projectName", ignore = true)
  @Mapping(target = "routes", ignore = true)
  @Mapping(target = "createdAt", ignore = true)
  @Mapping(target = "updatedAt", ignore = true)
  StubEntity toEntityFromId(Long id);

  void copyAttributes(StubEntity source, @MappingTarget StubEntity target);
}
