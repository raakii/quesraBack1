package com.quesra.quesra.controller;

import com.quesra.quesra.domain.Space;
import com.quesra.quesra.domain.User;
import com.quesra.quesra.dto.SpaceDto;
import com.quesra.quesra.service.SpaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spaces")
public class SpaceController {

    private final SpaceService spaceService;

    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @PostMapping("/create-space")
    public ResponseEntity<Space> createSpace(@RequestBody SpaceDto spaceDto) throws Exception {
        if(spaceDto == null) {
            throw new Exception("Bad Request");
        }
        return ResponseEntity.status(HttpStatus.OK).body(spaceService.createSpace(spaceDto));
    }

    @GetMapping("/get-spaces")
    public ResponseEntity<List<Space>> getAllSpaces(){
        return ResponseEntity.status(HttpStatus.OK).body(spaceService.getAllSpaces());
    }



}
