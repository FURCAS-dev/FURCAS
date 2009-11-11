package com.sap.opportunity.ui.client;

import java.util.Date;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SliderEvent;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Status;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Main implements EntryPoint, Listener<SliderEvent>, IStatusDisplay {
    
    private Status statusBar;
    private TimeTravelPanel timeTravelPanel;
    private OpportunitiesPanel opporunitiesPanel;
    private ChartPanel chartPanel;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {	
	ContentPanel panel = new ContentPanel();
	panel.setHeaderVisible(false);
	panel.setLayout(new RowLayout(Orientation.VERTICAL));
	
	ContentPanel statusPanel = new ContentPanel(new CenterLayout());
	statusPanel.setHeaderVisible(false);
	statusPanel.setBorders(false);
	statusBar = new Status();
	statusPanel.add(statusBar);
	
	timeTravelPanel = new TimeTravelPanel();
	timeTravelPanel.addSliderListener(this);
	timeTravelPanel.setHeight(100);

	chartPanel = new ChartPanel(this);
	chartPanel.setHeight(300);
	
	opporunitiesPanel = new OpportunitiesPanel(this, chartPanel);
	opporunitiesPanel.setHeight(430);

	panel.add(statusPanel, new RowData(1, -1, new Margins(4)));
	panel.add(timeTravelPanel, new RowData(1, -1, new Margins(4)));
	panel.add(chartPanel, new RowData(1, -1, new Margins(4)));
	panel.add(opporunitiesPanel, new RowData(1, -1, new Margins(4)));

	RootPanel.get().add(panel);
    }

    @Override
    public void handleEvent(SliderEvent sliderEvent) {
	// in case we switch to "history" mode
	if (sliderEvent.getOldValue() == 0 && sliderEvent.getNewValue() < 0) {
	    opporunitiesPanel.switchToHistoryMode();
	}
	// in case we switch from "history" mode to live data
	else if (sliderEvent.getOldValue() < 0 && sliderEvent.getNewValue() == 0) {
	    opporunitiesPanel.switchToLiveMode();
	}
	
	// update the historic data in case we are time travelling
	if (sliderEvent.getNewValue() < 0) {
	    long ts = System.currentTimeMillis();
	    ts = ts + (sliderEvent.getNewValue() * 10000);  // slider Range is [-180, 0]
	    Date txTime = new Date(ts);
	    //TODO: back to: CalendarUtil.addDaysToDate(txTime, sliderEvent.getNewValue());

	    opporunitiesPanel.updateHistoryData(txTime);
	    chartPanel.updateChart(txTime);
	}
	else {
	    chartPanel.updateChart();
	}
    }

    int rpcCount = 0;
    @Override
    public void error(String message) {
	rpcCount = 0;
	statusBar.clearStatus(message);
    }

    @Override
    public void finishRPC() {
	if (--rpcCount == 0) {
	    rpcCount = 0;
	    statusBar.clearStatus("");
	}
	else if (rpcCount > 0) {
	    statusBar.setBusy("Talking with server (" + rpcCount +" pending requests)");
	}
	else {
	    rpcCount = 0;
	}
	
    }

    @Override
    public void startRPC() {
	++rpcCount;
	statusBar.setBusy("Talking with server (" + rpcCount +" pending requests)");
    }
    
}
