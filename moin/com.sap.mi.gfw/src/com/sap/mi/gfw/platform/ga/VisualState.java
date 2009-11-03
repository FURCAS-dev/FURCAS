package com.sap.mi.gfw.platform.ga;

import java.util.ArrayList;

/**
 * A simple implementation of {@link IVisualState}.
 */
public class VisualState implements IVisualState {

	private ArrayList<IVisualStateChangeListener> changeListeners = new ArrayList<IVisualStateChangeListener>();

	private int actionTargetFeedback = ACTION_TARGET_FEEDBACK_OFF;

	private int selectionFeedback = SELECTION_FEEDBACK_OFF;

	public void addChangeListener(IVisualStateChangeListener listener) {
		changeListeners.add(listener);
	}

	public void removeChangeListener(IVisualStateChangeListener listener) {
		changeListeners.remove(listener);
	}

	protected void fireVisualStateChanged() {
		for (IVisualStateChangeListener listener : changeListeners) {
			listener.visualStateChanged();
		}
	}

	public int getActionTargetFeedback() {
		return actionTargetFeedback;
	}

	public void setActionTargetFeedback(int feedback) {
		int oldActionTargetFeedback = actionTargetFeedback;
		actionTargetFeedback = feedback;
		if (oldActionTargetFeedback != actionTargetFeedback)
			fireVisualStateChanged();
	}

	public int getSelectionFeedback() {
		return selectionFeedback;
	}

	public void setSelectionFeedback(int feedback) {
		int oldSelectionFeedback = selectionFeedback;
		selectionFeedback = feedback;
		if (oldSelectionFeedback != selectionFeedback)
			fireVisualStateChanged();
	}
}
