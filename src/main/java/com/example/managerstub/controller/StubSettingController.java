package com.example.managerstub.controller;

import com.example.managerstub.dto.StubDto;
import com.example.managerstub.service.StubService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stubs")
@RequiredArgsConstructor
@Tag(name = "Stub Management", description = "Endpoints for managing stubs")
public class StubSettingController {

  private final StubService stubService;

  @GetMapping("/{project_name}/list")
  public List<StubDto> getStubList(@PathVariable("project_name") String projectName) {
    return stubService.getStubList(projectName);
  }

  @GetMapping("/{stub_id}")
  public StubDto getStubById(@PathVariable("stub_id") Long stubId) {
    return stubService.getStubById(stubId);
  }

  @PostMapping
  public StubDto createStub(@RequestBody StubDto stubDto) {
    return stubService.createStub(stubDto);
  }

  @PatchMapping
  public StubDto updateStub(@RequestBody StubDto stubDto) {
    return stubService.updateStub(stubDto);
  }

  @DeleteMapping("/{stub_id}")
  public void deleteStubById(@PathVariable("stub_id") Long stubId) {
    stubService.deleteStub(stubId);
  }

}
