package com.example.managerstub.service.impl;//package com.example.managerstub.service.impl;

import com.example.managerstub.dto.StubDto;
import com.example.managerstub.exception.DatabaseException;
import com.example.managerstub.mapper.StubMapper;
import com.example.managerstub.repository.StubRepository;
import com.example.managerstub.service.StubService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StubServiceImpl implements StubService {

  private static final String ERROR_SAVE_DB = "Ошибка сохранения в БД";
  private static final String ERROR_DELETE_DB = "Ошибка удаления из БД";
  private static final String ERROR_FIND_DB = "Запись не найдена в БД!";

  private final StubRepository stubRepository;
  private final StubMapper stubMapper;

  @Override
  public List<StubDto> getStubList(String projectName) {
    var list = stubRepository.findAllByProjectName(projectName);
    return stubMapper.entityToDtoList(list);
  }

  @Override
  public StubDto getStubById(Long stubId) {
    var entity = stubRepository.findById(stubId);
    if (entity.isPresent()) {
      return stubMapper.entityToDto(entity.orElse(null));
    } else { // если не найдена запись в БД
      throw new DatabaseException(ERROR_FIND_DB);
    }
  }

  @Override
  @Transactional
  public StubDto createStub(StubDto stubDto) {
    try {
      // так как это создание записей, то обнуляем ID
      stubDto.setId(null);
      stubDto.getRoutes().forEach(r -> r.setId(null));

      var entity = stubMapper.dtoToEntity(stubDto);
      entity.getRoutes().forEach(x -> x.setStub(entity));
      return stubMapper.entityToDto(
          stubRepository.save(entity)
      );
    } catch (Exception e) {
      log.error(ERROR_SAVE_DB, e);
      throw new DatabaseException(ERROR_SAVE_DB);
    }
  }

  @Override
  @Transactional
  public StubDto updateStub(StubDto stubDto) {
    try {
      var entity = stubRepository.findById(stubDto.getId());
      if (entity.isPresent()) {
        var target = entity.get();
        var source = stubMapper.dtoToEntity(stubDto);
        stubMapper.copyAttributes(source, target);
        target.setUpdatedAt(LocalDateTime.now());
        return stubMapper.entityToDto(
            stubRepository.save(target)
        );
      } else { // если не найдена запись в БД
        throw new DatabaseException(ERROR_FIND_DB);
      }
    } catch (DatabaseException e) {
      log.error(ERROR_SAVE_DB, e);
      throw e;
    } catch (Exception e) {
      log.error(ERROR_SAVE_DB, e);
      throw new DatabaseException(ERROR_SAVE_DB);
    }
  }

  @Override
  public void deleteStub(Long stubId) {
    try {
      var entity = stubRepository.findById(stubId);
      if (entity.isEmpty()) {  // если не найдена запись в БД
        throw new DatabaseException(ERROR_FIND_DB);
      }
      stubRepository.deleteById(stubId);
    } catch (Exception e) {
      log.error(ERROR_DELETE_DB, e);
      throw new DatabaseException(ERROR_DELETE_DB);
    }
  }
}
