package com.quesra.quesra.repository;

import com.quesra.quesra.domain.Space;
import com.quesra.quesra.domain.User;
import com.quesra.quesra.dto.SpaceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpaceRepository extends JpaRepository<Space,Long> {
    Space findSpaceByName(String name);

    @Query (nativeQuery = true, value = "DELETE FROM users_joinded_spaces where user_id = ?1 and joinded_spaces_id=?2")
    User deleteSpaceForUser(Long userId, Long spaceId);
}
