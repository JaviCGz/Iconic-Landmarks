package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinentDTO;
import com.alkemy.icons.icons.entity.ContinentEntity;
import com.alkemy.icons.icons.mapper.ContinentMapper;
import com.alkemy.icons.icons.repository.ContinentRepository;
import com.alkemy.icons.icons.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentMapper continentMapper;
    @Autowired
    private ContinentRepository continentRepository;

    public ContinentDTO save(ContinentDTO dto) {
        ContinentEntity entity = continentMapper.convertToEntity(dto);
        ContinentEntity entitySaved = continentRepository.save(entity);
        ContinentDTO result = continentMapper.convertToDto(entitySaved);
        return result;
    }

    public List<ContinentDTO> getAllContinents() {
        List<ContinentEntity> entities = continentRepository.findAll();
        List<ContinentDTO> result = continentMapper.convertAllToDto(entities);
        return result;
    }
}
