package com.sachet.organisationservice.repository;

import com.sachet.organisationservice.dto.OrganisationDto;
import com.sachet.organisationservice.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Optional<Organisation> findByOrganisationCode(String code);
}
