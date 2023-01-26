package com.quesra.quesra.service.Impl;

import com.quesra.quesra.domain.Space;
import com.quesra.quesra.domain.User;
import com.quesra.quesra.dto.SpaceDto;
import com.quesra.quesra.repository.SpaceRepository;
import com.quesra.quesra.service.SpaceService;
import com.quesra.quesra.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;

    private final UserService userService;

    public SpaceServiceImpl(SpaceRepository spaceRepository, UserService userService) {
        this.spaceRepository = spaceRepository;
        this.userService = userService;
    }

    @Override
    public Space createSpace(SpaceDto spaceDto) {
        Space space = new Space();
        space.setName(spaceDto.getName());
        space.setAdmin(userService.findByEmail(spaceDto.getEmail()));

        return spaceRepository.save(space);
    }

    @Override
    public List<Space> getAllSpaces() {
        return spaceRepository.findAll();
    }





}
