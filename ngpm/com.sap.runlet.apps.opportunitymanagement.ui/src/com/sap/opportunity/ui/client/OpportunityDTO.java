package com.sap.opportunity.ui.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class OpportunityDTO implements IsSerializable {
    public String id;
    public String description;
    public String prospect;
    public String phase;
    public String competitors;
    public String responsibleEmployee;
    public Date closeDate;
    public double expectedSalesVolume;
    public double probability;

    public OpportunityDTO() {
    }

    public OpportunityDTO(String id, String description, String prospect, String phase, String competitors, Date closeDate,
	    String responsibleEmployee, int expectedSalesVolume, float probability) {
	this.id = id;
	this.description = description;
	this.prospect = prospect;
	this.phase = phase;
	this.competitors = competitors;
	this.closeDate = closeDate;
	this.expectedSalesVolume = expectedSalesVolume;
	this.probability = probability;
	this.responsibleEmployee = responsibleEmployee;
    }

}
