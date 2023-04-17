package com.sachet.organisationservice.controller;

import com.sachet.organisationservice.dto.OrganisationDto;
import com.sachet.organisationservice.service.OrganisationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organisation")
@AllArgsConstructor
public class OrganisationController {

    private OrganisationService organisationService;

    @PostMapping("/create")
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto){
        return ResponseEntity.ok(organisationService.createOrganisation(organisationDto));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<OrganisationDto> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(organisationService.getOrganisationByCode(code));
    }

}
