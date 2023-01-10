package com.quesra.quesra.repository;

import com.quesra.quesra.domain.Space;
import com.quesra.quesra.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpaceRepository extends JpaRepository<Space,Long> {

}
