package com.sachet.organisationservice.service.impl;

import com.sachet.organisationservice.dto.OrganisationDto;
import com.sachet.organisationservice.entity.Organisation;
import com.sachet.organisationservice.exception.OrganisationAlreadyExist;
import com.sachet.organisationservice.exception.ResourceNotFound;
import com.sachet.organisationservice.repository.OrganisationRepository;
import com.sachet.organisationservice.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private OrganisationRepository organisationRepository;
    private ModelMapper modelMapper;

    @Override
    public OrganisationDto createOrganisation(OrganisationDto organisationDto) {
        Optional<Organisation> organisation = organisationRepository
                .findByOrganisationCode(organisationDto.getOrganisationCode());
        if (organisation.isPresent()) {
            throw new OrganisationAlreadyExist(
                    "Organisation with code "+organisationDto.getOrganisationCode()
                    +" already exists! Please try again with different code."
            );
        }
        Organisation organisationToSave = modelMapper.map(organisationDto, Organisation.class);
        return modelMapper.map(organisationRepository.save(organisationToSave), OrganisationDto.class);
    }

    @Override
    public OrganisationDto getOrganisationByCode(String code) {
        Organisation organisation = organisationRepository.findByOrganisationCode(code)
                .orElseThrow(() -> new ResourceNotFound("Organisation", "CODE", code));
        return modelMapper.map(organisation, OrganisationDto.class);
    }
}
