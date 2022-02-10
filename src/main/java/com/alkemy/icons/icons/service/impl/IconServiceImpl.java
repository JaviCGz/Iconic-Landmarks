package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.BasicIconDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IconServiceImpl implements IconService {

    @Autowired
    IconMapper iconMapper;

    @Autowired
    IconRepository iconRepository;

    public IconDTO save(IconDTO dto) {
        IconEntity entity = iconMapper.convertToEntity(dto);
        IconEntity entitySaved = iconRepository.save(entity);
        IconDTO result = iconMapper.convertToDto(entitySaved, true);
        return result;
    }

    public List<BasicIconDTO> getAllBasicIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        List<BasicIconDTO> result = iconMapper.convertAllToBasicDto(entities);
        return result;
    }

}
