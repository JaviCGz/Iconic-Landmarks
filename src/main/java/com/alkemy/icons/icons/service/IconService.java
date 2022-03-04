package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.BasicIconDTO;
import com.alkemy.icons.icons.dto.IconDTO;

import java.util.List;
import java.util.Set;

public interface IconService {

    IconDTO save (IconDTO dto);
    IconDTO update (Long id, IconDTO dto);
    void delete(Long id);
    void addCountry(Long id, Long idCountry);
    void removeCountry(Long id, Long idCountry);
    List<BasicIconDTO> getAllBasicIcons();
    IconDTO getDetailsById(Long id);
    List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order);

}
