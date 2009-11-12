package com.sap.opportunity.ui.client;

import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SliderEvent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Slider;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;

public class TimeTravelPanel extends LayoutContainer implements Listener<SliderEvent> {
    
    private Slider slider;
    private LabelField timeLabel;
    
    private static String defaultTimeLabelContent = "Today";
    
    public TimeTravelPanel() {
	setLayout(new FitLayout());
	
	ContentPanel cp = new ContentPanel();
	cp.setHeading("Time Travel");
	cp.setLayout(new ColumnLayout());
	
	cp.setAutoHeight(true);
	setAutoHeight(true);
	setTitle("Time Travel");
	
	timeLabel = new LabelField(defaultTimeLabelContent);
	cp.add(timeLabel, new ColumnData(100));
	
	slider = new Slider();
	slider.setMinValue(-180);
	slider.setMaxValue(0);
	slider.setIncrement(1);
	slider.setWidth(200);
	slider.setUseTip(false);
	
	cp.add(slider, new ColumnData(1.0));
	addSliderListener(this);
	
	add(cp);
    }
    
    public void addSliderListener(Listener<SliderEvent> l) {
	slider.addListener(Events.Change, l);
    }
    
    private void resetTimeLabel() {
	timeLabel.setText(defaultTimeLabelContent);
    }
    private void setTimeLabel(String text) {
	timeLabel.setText(text);
    }

    @Override
    public void handleEvent(SliderEvent sliderEvent) {
	if (sliderEvent.getNewValue() < 0) {
	    setTimeLabel((sliderEvent.getNewValue() * 10) + " sec");
	}
	else {
	    resetTimeLabel();
	}
    }

}
