package com.quesra.quesra.service;

import com.quesra.quesra.domain.Space;
import com.quesra.quesra.dto.SpaceDto;


import java.util.List;

public interface SpaceService {
    Space createSpace(SpaceDto spaceDto);

    List<Space> getAllSpaces();

}
