package com.sachet.organisationservice.service;

import com.sachet.organisationservice.dto.OrganisationDto;

public interface OrganisationService {

    OrganisationDto createOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisationByCode(String code);
}
