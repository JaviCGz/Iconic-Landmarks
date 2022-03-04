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

    private final ContinentMapper continentMapper;
    private final ContinentRepository continentRepository;

    @Autowired // CONSTRUCTOR
    public ContinentServiceImpl(ContinentMapper continentMapper, ContinentRepository continentRepository) {
        this.continentMapper = continentMapper;
        this.continentRepository = continentRepository;
    }

    public ContinentDTO save(ContinentDTO dto) {
        ContinentEntity entity = continentMapper.convertToEntity(dto);
        ContinentEntity entitySaved = continentRepository.save(entity);
        return continentMapper.convertToDto(entitySaved);
    }

    public List<ContinentDTO> getAllContinents() {
        List<ContinentEntity> entities = continentRepository.findAll();
        return continentMapper.convertToDtoList(entities);
    }
}
