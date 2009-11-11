package com.sap.opportunity.ui.client;

import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SalesByMonthDTO implements IsSerializable {
    public String month;
    public List<ExpectedSalesDTO> sales;
}
