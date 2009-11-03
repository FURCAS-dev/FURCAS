package com.sap.mi.gfw.platform.ga;

/**
 * This interface allows to access and modify the transient visual state of an element. The transient visual state includes all feedback
 * relevant attributes, which are not persisted, like selection-feedback or action-target-feedback.
 */
public interface IVisualState {

	/**
	 * Constant indicating, that there is currently no action target feedback.
	 */
	final static int ACTION_TARGET_FEEDBACK_OFF = 0;

	/**
	 * Constant indicating, that an action is allowed for this target.
	 */
	final static int ACTION_TARGET_ALLOWED = 1;

	/**
	 * Constant indicating, that an action is forbidden for this target
	 */
	final static int ACTION_TARGET_FORBIDDEN = 2;

	/**
	 * Constant indicating, that there is currently no selection feedback.
	 */
	final static int SELECTION_FEEDBACK_OFF = 0;

	/**
	 * Constant indicating, that the visual element is the primary selection.
	 */
	final static int SELECTION_PRIMARY = 1;

	/**
	 * Constant indicating, that the visual element is the secondary selection.
	 */
	final static int SELECTION_SECONDARY = 2;

	/**
	 * Adds a change listener.
	 * 
	 * @param listener
	 *            The change listener to add.
	 */
	void addChangeListener(IVisualStateChangeListener listener);

	/**
	 * Removes a change listener.
	 * 
	 * @param listener
	 *            The change listener to remove.
	 */
	void removeChangeListener(IVisualStateChangeListener listener);

	/**
	 * Returns the action target feedback. It indicates, if a certain action (e.g. drag & drop) can be performed with this visual element as
	 * a target.
	 * 
	 * @return The action target feedback.
	 */
	int getActionTargetFeedback();

	/**
	 * Sets the action target feedback. It indicates, if a certain action (e.g. drag & drop) can be performed with this visual element as a
	 * target.
	 * 
	 * @param feedback
	 *            The action target feedback to set.
	 */
	void setActionTargetFeedback(int feedback);

	/**
	 * Returns the selection feedback. It indicates if the visual element is selected.
	 * 
	 * @return The selection feedback.
	 */
	int getSelectionFeedback();

	/**
	 * Sets the selection feedback. It indicates if the visual element is selected.
	 * 
	 * @param feedback
	 *            The selection feedback to set.
	 */
	void setSelectionFeedback(int feedback);
}
