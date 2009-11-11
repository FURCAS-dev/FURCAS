package com.sap.opportunity.ui.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.Legend;
import com.extjs.gxt.charts.client.model.Legend.Position;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.axis.YAxis;
import com.extjs.gxt.charts.client.model.charts.StackedBarChart;
import com.extjs.gxt.charts.client.model.charts.StackedBarChart.StackValue;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class ChartPanel extends LayoutContainer implements ISaveListener {

    private ChartModel chartModel;

    private final OpportunityServiceAsync oppService = GWT.create(OpportunityService.class);

    private AsyncCallback<List<SalesByMonthDTO>> chartCB = new AsyncCallback<List<SalesByMonthDTO>>() {
	public void onSuccess(List<SalesByMonthDTO> result) {
	    statusDisplay.finishRPC();
	    updateChart(result);
	}

	public void onFailure(Throwable caught) {
	    statusDisplay.finishRPC();
	    statusDisplay.error("Could not get chart data from server.");
	    GWT.log("Could not get chart data from server.", caught);
	}
    };

    private StackedBarChart chart;

    private Chart chartWidget;
    
    private IStatusDisplay statusDisplay;
    
    public ChartPanel(IStatusDisplay status) {
	super();
	statusDisplay = status;
	((ServiceDefTarget) oppService).setServiceEntryPoint("http://localhost:8282/runlet/main/opportunity");
    }

    @Override
    protected void onRender(Element parent, int index) {
	super.onRender(parent, index);
	ContentPanel cp = new ContentPanel();
	cp.setHeading("Open Opportunity Pipeline [$] by Month of Closing Date"
		+ " (for all Opps with a closing date in the last 30 or next 150 days)");
	cp.setHeight(300);
	cp.setFrame(true);
	cp.setLayout(new FitLayout());

	String url = "main/chart/open-flash-chart.swf";

	chartWidget = new Chart(url);
	chartModel = createBarChartData();
	chartWidget.setChartModel(chartModel);
	cp.add(chartWidget);
	
	updateChart();

	add(cp);
    }

    private ChartModel createBarChartData() {
	ChartModel cm = new ChartModel();
	Legend legend = new Legend(Position.RIGHT);
	cm.setLegend(legend);
	cm.setBackgroundColour("#eeffee");
	cm.setDecimalSeparatorComma(true);
	XAxis xa = new XAxis();
	xa.setLabels("June 2009", "July 2009", "August 2009", "September 2009");
	xa.setGridColour("#AAAAAA");
	xa.setColour("#AAAAAA");
	cm.setXAxis(xa);
	YAxis ya = new YAxis();
	ya.setRange(0, 20000);
	ya.setSteps(2000);
	ya.setGridColour("#AAAAAA");
	ya.setColour("#AAAAAA");
	cm.setYAxis(ya);

	chart = new StackedBarChart();
	chart.setTooltip("$#val#");

	cm.addChartConfig(chart);
	return cm;
    }
    
    private void updateChart(List<SalesByMonthDTO> result) {
	List<String> labels = new ArrayList<String>(4);
	List<StackValue> stack = new ArrayList<StackValue>(3);
	chart.set("values", null);
	
	int maxSales = 10;

	for (SalesByMonthDTO sbm : result) {
	    labels.add(sbm.month);
	    
	    stack.clear();
	    int thisSales = 0;
	    for (ExpectedSalesDTO es : sbm.sales) {
		String color = "";
		if (es.phase.equals("Decision Making")) {
		    color = "FD7400";
		} else if (es.phase.equals("Final Phase")) {
		    color = "FFE11A";
		} else {
		    color = "BEDB39";
		}
		thisSales += es.expectedVolume;
		stack.add(new StackedBarChart.StackValue(es.expectedVolume, color));
	    }
	    maxSales = (thisSales > maxSales) ? thisSales : maxSales;
	    chart.addStack(stack);
	    
	}
	// calculate y-Axis max and steps
	chartModel.getXAxis().setLabels(labels);
	chartModel.getYAxis().setMax(maxSales * 1.1);
	float steps = maxSales / 10;
	int exp = 1;
	while (steps >= 100) {
	    exp *= 10;
	    steps = Math.round(steps / 10);
	}
	steps = steps * exp;
	chartModel.getYAxis().setSteps(steps);
	chartWidget.setChartModel(chartModel);
    }
    
    public void updateChart(Date transactionTime) {
	statusDisplay.startRPC();
	oppService.getChartData(transactionTime, chartCB);
    }
    
    public void updateChart() {
	statusDisplay.startRPC();
	oppService.getChartData(chartCB);
    }

    @Override
    public void opportunitiesSaved() {
	//TODO: one important assumptions here: if we get a save event
	// we are sure to show the chart for the current data. changes
	// on past data are not possible.
	updateChart();
    }
    
}
