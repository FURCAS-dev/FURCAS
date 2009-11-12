package com.sap.opportunity.ui.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("opportunity")
public interface OpportunityService extends RemoteService {

    /**
     * Returns a list of *all* Opportunities.
     * 
     * @return
     */
    List<OpportunityDTO> getOpportunities();

    List<OpportunityDTO> getOpportunities(int minRevenue);

    List<OpportunityDTO> getOpportunities(String phase);

    List<OpportunityDTO> getOpportunities(int minRevenue, String phase);
    
    /**
     * Updates the opportunities
     * @param dtos
     */
    void updateOpportunities(List<OpportunityDTO> dtos);

    /**
     * Returns a list of *all* Opportunities at a given point in time (aka time
     * travel). The result should not be edited or updated.
     * 
     * @param transactionTime
     * @return
     */
    List<OpportunityDTO> getHistoricOpportunities(Date transactionTime);
    
    List<OpportunityDTO> getHistoricOpportunities(Date transactionTime, int minRevenue);

    List<OpportunityDTO> getHistoricOpportunities(Date transactionTime, String phase);

    List<OpportunityDTO> getHistoricOpportunities(Date transactionTime, int minRevenue, String phase);
    
    /**
     * Returns the chart data (expected sales per Month by phase).
     * 
     * From current month (determined by user time) and the following three months.
     */
    List<SalesByMonthDTO> getChartData();
    
    /**
     * Returns the chart data (expected sales per Month by phase).
     * 
     * From current month (determined by user time) and the following three months.
     * 
     * @param transactionTime time point for retrieving historic data
     * 
     */
    List<SalesByMonthDTO> getChartData(Date transactionTime);

}
