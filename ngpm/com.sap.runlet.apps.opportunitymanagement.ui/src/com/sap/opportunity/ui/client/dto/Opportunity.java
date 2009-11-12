package com.sap.opportunity.ui.client.dto;

import java.util.Date;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.sap.opportunity.ui.client.OpportunityDTO;

public class Opportunity extends BaseModelData {

    private static final long serialVersionUID = 8879375948762294792L;
    
    public Opportunity() {
    }
    
    public Opportunity(OpportunityDTO dto) {
	setId(dto.id);
	setDescription(dto.description);
	setProspect(dto.prospect);
	setPhase(dto.phase);
	setCompetitors(dto.competitors);
	setCloseDate(dto.closeDate);
	setExpectedSalesVolume(dto.expectedSalesVolume);
	setProbability(dto.probability);
	setResponsibleEmployee(dto.responsibleEmployee);
    }
    
    public Opportunity(String id, String description, String prospect, String phase, String competitors, Date closeDate, String responsibleEmployee, double expectedSalesVolumne, double probability) {
	setId(id);
	setDescription(description);
	setProspect(prospect);
	setPhase(phase);
	setCompetitors(competitors);
	setCloseDate(closeDate);
	setExpectedSalesVolume(expectedSalesVolumne);
	setProbability(probability);
	setResponsibleEmployee(responsibleEmployee);
    }
    
    public OpportunityDTO toDTO() {
	OpportunityDTO dto = new OpportunityDTO();
	dto.id = getId();
	dto.description = getDescription();
	dto.prospect = getProspect();
	dto.phase = getPhase();
	dto.competitors = getCompetitors();
	dto.closeDate = getCloseDate();
	dto.expectedSalesVolume = getExpectedSalesVolume();
	dto.probability = getProbability();
	dto.responsibleEmployee = getResponsibleEmployee();
	return dto;
    }
    
    public void setId(String id) {
	set("id", id);
    }
    
    public String getId() {
	return get("id");
    }
    
    public String getDescription() {
	return get("description");
    }

    public void setDescription(String description) {
	set("description", description);
    }

    public String getPhase() {
	return get("phase");
    }

    public void setPhase(String phase) {
	set("phase", phase);
    }

    public Date getCloseDate() {
	return get("closeDate");
    }

    public void setCloseDate(Date closeDate) {
	set("closeDate", closeDate);
    }

    public Double getExpectedSalesVolume() {
	return get("expectedSalesVolume");
    }

    public void setExpectedSalesVolume(Double expectedSalesVolume) {
	set("expectedSalesVolume", expectedSalesVolume);
    }

    public Double getProbability() {
	return get("probability");
    }

    public void setProbability(Double probability) {
	set("probability", probability);
    }

    public String getProspect() {
	return get("prospect");
    }
    
    public void setProspect(String prospect) {
	set("prospect", prospect);
    }

    public String getCompetitors() {
	return get("competitors");
    }
    
    public void setCompetitors(String competitors) {
	set("competitors", competitors);
    }

    public String getResponsibleEmployee() {
	return get("responsibleEmployee");
    }
    
    public void setResponsibleEmployee(String responsibleEmployee) {
	set("responsibleEmployee", responsibleEmployee);
    }

}
