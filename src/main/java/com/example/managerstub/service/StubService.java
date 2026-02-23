package com.example.managerstub.service;//package com.example.managerstub.service;

import com.example.managerstub.dto.StubDto;
import java.util.List;

public interface StubService {

  /**
   * Получить список записей из БД проекта (projectName)
   * @param projectName - название проекта
   * @return - список объектов
   */
  List<StubDto> getStubList(String projectName);

  /**
   * Получить объект из БД.
   * @param stubId - Ид записи
   * @return - запись из БД
   */
  StubDto getStubById(Long stubId);

  /**
   * Создание записи в БД
   * @param stubDto - новый объект
   * @return - сохраненный объект
   */
  StubDto createStub(StubDto stubDto);

  /**
   * Обновление атрибутов в БД
   * @param stubDto - новые атрибуты
   * @return - сохраненный объект
   */
  StubDto updateStub(StubDto stubDto);

  /**
   * Удаление записи из БД
   * @param stubId - Ид записи
   */
  void deleteStub(Long stubId);

}
