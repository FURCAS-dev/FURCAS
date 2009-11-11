package com.sap.opportunity.ui.client;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>OpportunityService</code>.
 */
public interface OpportunityServiceAsync {

    void getOpportunities(AsyncCallback<List<OpportunityDTO>> callback);

    void getOpportunities(int minRevenue, AsyncCallback<List<OpportunityDTO>> callback);

    void getOpportunities(String phase, AsyncCallback<List<OpportunityDTO>> callback);

    void getOpportunities(int minRevenue, String phase, AsyncCallback<List<OpportunityDTO>> callback);

    void updateOpportunities(List<OpportunityDTO> dtos, AsyncCallback<Void> callback);

    void getHistoricOpportunities(Date transactionTime, AsyncCallback<List<OpportunityDTO>> callback);

    void getHistoricOpportunities(Date transactionTime, int minRevenue, AsyncCallback<List<OpportunityDTO>> callback);

    void getHistoricOpportunities(Date transactionTime, String phase, AsyncCallback<List<OpportunityDTO>> callback);

    void getHistoricOpportunities(Date transactionTime, int minRevenue, String phase, AsyncCallback<List<OpportunityDTO>> callback);

    void getChartData(AsyncCallback<List<SalesByMonthDTO>> callback);

    void getChartData(Date transactionTime, AsyncCallback<List<SalesByMonthDTO>> callback);
}
