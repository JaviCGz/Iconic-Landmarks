package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.BasicIconDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("icons")
public class IconController {

    @Autowired
    private IconService iconService;

    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
        IconDTO savedIcon = iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIcon);
    }

    @GetMapping
    public ResponseEntity<List<BasicIconDTO>> getAll() {
        List<BasicIconDTO> icons = iconService.getAllBasicIcons();
        return ResponseEntity.ok().body(icons);
    }
}
