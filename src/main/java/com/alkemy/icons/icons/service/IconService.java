package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.BasicIconDTO;
import com.alkemy.icons.icons.dto.IconDTO;

import java.util.List;

public interface IconService {

    IconDTO save (IconDTO dto);
    List<BasicIconDTO> getAllBasicIcons();
}
