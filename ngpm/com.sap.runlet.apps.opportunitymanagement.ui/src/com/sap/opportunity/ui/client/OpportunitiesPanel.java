package com.sap.opportunity.ui.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.SliderEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.widget.CardPanel;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Slider;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.SimpleComboValue;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.sap.opportunity.ui.client.dto.Opportunity;

public class OpportunitiesPanel extends LayoutContainer {

    private final OpportunityServiceAsync oppService = GWT.create(OpportunityService.class);

    private EditorGrid<Opportunity> grid;
    private Grid<Opportunity> historyGrid;
    private CardPanel gridPanel;
    private ListStore<Opportunity> liveStore;
    private ListStore<Opportunity> historyStore;
    private Date transactionTime;

    private AsyncCallback<List<OpportunityDTO>> liveCB = new AsyncCallback<List<OpportunityDTO>>() {
	public void onSuccess(List<OpportunityDTO> result) {
	    statusDisplay.finishRPC();
	    liveStore.removeAll();
	    for (OpportunityDTO odto : result) {
		liveStore.add(new Opportunity(odto));
	    }
	}

	public void onFailure(Throwable caught) {
	    statusDisplay.finishRPC();
	    statusDisplay.error("Could not get list of Opportunities from server.");
	    liveStore.removeAll();
	    GWT.log("Could not get list of Opportunities from server.", caught);
	}
    };
    
    private AsyncCallback<Void> updateCB = new AsyncCallback<Void>() {
	public void onSuccess(Void result) {
	    statusDisplay.finishRPC();
	    updateOpportunityList();
	    saveListener.opportunitiesSaved();
	}

	public void onFailure(Throwable caught) {
	    statusDisplay.finishRPC();
	    statusDisplay.error("Failed to update data on server.");
	    GWT.log("Failed to update data on server.", caught);
	}
    };

    private AsyncCallback<List<OpportunityDTO>> historyCB = new AsyncCallback<List<OpportunityDTO>>() {
	public void onSuccess(List<OpportunityDTO> result) {
	    statusDisplay.finishRPC();
	    historyStore.removeAll();
	    for (OpportunityDTO odto : result) {
		historyStore.add(new Opportunity(odto));
	    }
	}

	public void onFailure(Throwable caught) {
	    statusDisplay.finishRPC();
	    statusDisplay.error("Could not get list of Opportunities from server.");
	    historyStore.removeAll();
	    GWT.log("Could not get list of Opportunities from server.", caught);
	}
    };

    private Button resetButton;

    private Button saveButton;

    private Button addButton;

    private SimpleComboBox<String> phaseFilter;

    private Slider revenueSlider;
    
    private IStatusDisplay statusDisplay;
    
    private ISaveListener saveListener;

    public OpportunitiesPanel(IStatusDisplay status, ISaveListener listener) {
	super();
	statusDisplay = status;
	saveListener = listener;
	((ServiceDefTarget) oppService).setServiceEntryPoint("http://localhost:8282/runlet/main/opportunity");
	
	setLayout(new FitLayout());

	// setup column model
	List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

	ColumnConfig column = new ColumnConfig();
	column.setId("description");
	column.setHeader("Description");
	column.setWidth(80);
	TextField<String> text = new TextField<String>();
	text.setAllowBlank(false);
	text.setAutoValidate(true);
	column.setEditor(new CellEditor(text));
	configs.add(column);

	column = new ColumnConfig();
	column.setId("prospect");
	column.setHeader("Prospect");
	column.setWidth(80);
	text = new TextField<String>();
	text.setAllowBlank(false);
	text.setAutoValidate(true);
	column.setEditor(new CellEditor(text));
	configs.add(column);

	final SimpleComboBox<String> combo = new SimpleComboBox<String>();
	combo.setTriggerAction(TriggerAction.ALL);
	combo.add("Initial");
	combo.add("Final Phase");
	combo.add("Decision Making");

	CellEditor editor = new CellEditor(combo) {
	    @Override
	    public Object preProcessValue(Object value) {
		if (value == null) {
		    return value;
		}
		return combo.findModel(value.toString());
	    }

	    @Override
	    public Object postProcessValue(Object value) {
		if (value == null) {
		    return value;
		}
		return ((ModelData) value).get("value");
	    }
	};
	column = new ColumnConfig();
	column.setId("phase");
	column.setHeader("Phase");
	column.setWidth(110);
	column.setEditor(editor);
	configs.add(column);

	column = new ColumnConfig();
	column.setId("competitors");
	column.setHeader("Competitor");
	column.setWidth(80);
	column.setEditor(new CellEditor(new TextField<String>()));
	configs.add(column);

	DateField dateField = new DateField();
	dateField.getPropertyEditor().setFormat(DateTimeFormat.getFormat("MM/dd/y"));
	column = new ColumnConfig();
	column.setId("closeDate");
	column.setHeader("Closing Date");
	column.setWidth(95);
	column.setEditor(new CellEditor(dateField));
	column.setDateTimeFormat(DateTimeFormat.getMediumDateFormat());
	configs.add(column);

	column = new ColumnConfig();
	column.setId("responsibleEmployee");
	column.setHeader("Employee Resp.");
	column.setWidth(80);
	column.setEditor(new CellEditor(new TextField<String>()));
	configs.add(column);

	column = new ColumnConfig();
	column.setId("expectedSalesVolume");
	column.setHeader("Expected Sales Volume");
	column.setAlignment(HorizontalAlignment.RIGHT);
	column.setWidth(135);
	column.setNumberFormat(NumberFormat.getCurrencyFormat());
	column.setEditor(new CellEditor(new NumberField()));
	configs.add(column);

	column = new ColumnConfig();
	column.setId("probability");
	column.setHeader("Probability [%]");
	column.setAlignment(HorizontalAlignment.RIGHT);
	column.setWidth(80);
	column.setNumberFormat(NumberFormat.getPercentFormat());
	column.setEditor(new CellEditor(new NumberField()));
	configs.add(column);

	ColumnModel cm = new ColumnModel(configs);

	// setup component layout
	ContentPanel cp = new ContentPanel();
	cp.setHeading("Opportunities");
	cp.setSize(600, 300);
	cp.setLayout(new FitLayout());

	gridPanel = new CardPanel();

	liveStore = new ListStore<Opportunity>();
	grid = new EditorGrid<Opportunity>(liveStore, cm);
	grid.setBorders(true);
	gridPanel.add(grid);

	historyStore = new ListStore<Opportunity>();
	historyGrid = new Grid<Opportunity>(historyStore, cm);
	historyGrid.setBorders(true);
	gridPanel.add(historyGrid);

	cp.add(gridPanel);

	cp.setTopComponent(getTopPanel());
	cp.setButtonAlign(HorizontalAlignment.CENTER);
	resetButton = new Button("Reset", new SelectionListener<ButtonEvent>() {

	    @Override
	    public void componentSelected(ButtonEvent ce) {
		liveStore.rejectChanges();
	    }
	});
	cp.addButton(resetButton);

	saveButton = new Button("Save", new SelectionListener<ButtonEvent>() {

	    @Override
	    public void componentSelected(ButtonEvent ce) {
		List<Record> changed = liveStore.getModifiedRecords();
		if (changed.size() > 0) {
		    List<OpportunityDTO> dtos = new ArrayList<OpportunityDTO>(changed.size());
		    for (Record r : changed) {
			if (r.getModel() instanceof Opportunity) {
			    dtos.add(((Opportunity) r.getModel()).toDTO());
			}
		    }
		    statusDisplay.startRPC();
		    oppService.updateOpportunities(dtos, updateCB);
		}
		// liveStore.commitChanges();
	    }
	});
	cp.addButton(saveButton);

	add(cp);

	updateOpportunityList();
    }

    private LayoutContainer getTopPanel() {
	ContentPanel panel = new ContentPanel();
	panel.setBorders(false);
	panel.setHeaderVisible(false);
	panel.setLayout(new RowLayout(Orientation.VERTICAL));

	panel.add(getFilterPanel());
	panel.add(getToolBar());

	return panel;
    }

    private LayoutContainer getFilterPanel() {
	ContentPanel panel = new ContentPanel();
	panel.setHeaderVisible(false);
	TableLayout layout = new TableLayout(2);
	layout.setCellPadding(5);
	layout.setCellHorizontalAlign(HorizontalAlignment.LEFT);
	layout.setCellVerticalAlign(VerticalAlignment.MIDDLE);
	panel.setLayout(layout);

	// 1st row
	LabelField filterLabel = new LabelField("Current Phase:");
	panel.add(filterLabel);

	final LabelField revenueLabel = new LabelField("Expected Revenue Greater than or equal to 0 $:");
	panel.add(revenueLabel);

	phaseFilter = new SimpleComboBox<String>();
	phaseFilter.setTriggerAction(TriggerAction.ALL);
	phaseFilter.add("All");
	phaseFilter.add("Initial");
	phaseFilter.add("Final Phase");
	phaseFilter.add("Decision Making");
	phaseFilter.addSelectionChangedListener(new SelectionChangedListener<SimpleComboValue<String>>() {
	    @Override
	    public void selectionChanged(
		    SelectionChangedEvent<SimpleComboValue<String>> se) {
		updateOpportunityList();
	    }
	});
	panel.add(phaseFilter);

	revenueSlider = new Slider();
	revenueSlider.setWidth(250);
	revenueSlider.setMinValue(0);
	revenueSlider.setMaxValue(100000);
	revenueSlider.setIncrement(1000);
	panel.add(revenueSlider);

	revenueSlider.addListener(Events.Change, new Listener<SliderEvent>() {
	    @Override
	    public void handleEvent(SliderEvent se) {
		revenueLabel.setText("Expected Revenue Greater than or equal to " + se.getNewValue() + " $:");
		updateOpportunityList();
	    }

	});

	return panel;
    }

    private void updateOpportunityList() {
	String phase = phaseFilter.getSelectedIndex() < 0 ? "All" : phaseFilter.getSimpleValue();
	int revenue = revenueSlider.getValue();
	statusDisplay.startRPC();
	if (isHistoryMode()) {
	    updateHistoryList(phase, revenue);
	} else {
	    updateLiveList(phase, revenue);
	}
    }

    private void updateLiveList(String phase, int revenue) {
	// if phase is selected
	if (phase.equals("All")) {
	    if (revenue > 0) {
		// query with revenue filter only
		oppService.getOpportunities(revenue, liveCB);
	    } else {
		// query without any filter
		oppService.getOpportunities(liveCB);
	    }
	} else {
	    if (revenue > 0) {
		// query with revenue and phase filter
		oppService.getOpportunities(revenue, phase, liveCB);
	    } else {
		// query with phase filter only
		oppService.getOpportunities(phase, liveCB);
	    }
	}
    }

    private void updateHistoryList(String phase, int revenue) {
	// if phase is selected
	if (phase.equals("All")) {
	    if (revenue > 0) {
		// query with revenue filter only
		oppService.getHistoricOpportunities(transactionTime, revenue, historyCB);
	    } else {
		// query without any filter
		oppService.getHistoricOpportunities(transactionTime, historyCB);
	    }
	} else {
	    if (revenue > 0) {
		// query with revenue and phase filter
		oppService.getHistoricOpportunities(transactionTime, revenue, phase, historyCB);
	    } else {
		// query with phase filter only
		oppService.getHistoricOpportunities(transactionTime, phase, historyCB);
	    }
	}
    }

    private ToolBar getToolBar() {
	ToolBar toolBar = new ToolBar();
	toolBar.setSpacing(6);
	addButton = new Button("Add Opportunity");
	addButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

	    @Override
	    public void componentSelected(ButtonEvent ce) {
		Opportunity opportunity = new Opportunity();
		opportunity.setCloseDate(new Date());
		opportunity.setExpectedSalesVolume(0.);
		opportunity.setPhase("Decision Making");

		grid.stopEditing();
		liveStore.insert(opportunity, 0);
		grid.startEditing(0, 0);
	    }

	});
	toolBar.add(addButton);
	return toolBar;
    }

    public void switchToHistoryMode() {
	if (!isHistoryMode()) {
	    gridPanel.setActiveItem(historyGrid);
	    resetButton.setEnabled(false);
	    saveButton.setEnabled(false);
	    addButton.setEnabled(false);
	}
    }

    public void switchToLiveMode() {
	if (isHistoryMode()) {
	    gridPanel.setActiveItem(grid);
	    resetButton.setEnabled(true);
	    saveButton.setEnabled(true);
	    addButton.setEnabled(true);
	}
    }

    public boolean isHistoryMode() {
	return gridPanel.getActiveItem() == historyGrid;
    }

    public void updateHistoryData(Date transactionTime) {
	this.transactionTime = transactionTime;
	switchToHistoryMode();
	updateOpportunityList();
    }

}
