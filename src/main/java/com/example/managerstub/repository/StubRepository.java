package com.example.managerstub.repository;

import com.example.managerstub.entity.StubEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StubRepository extends JpaRepository<StubEntity, Long> {

  List<StubEntity> findAllByProjectName(String projectName);

}
