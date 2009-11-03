package com.sap.mi.gfw.tb;

import java.util.List;

import com.sap.mi.gfw.datatypes.IRectangle;

/**
 * This interface allows to define all information needed to show a context button pad.
 */
public interface IContextButtonPadData {

	/**
	 * Returns the location of the context button pad. It can not be null. These are not the outer bounds of the context button pad, but the
	 * inner rectangle, around which the context button pad is shown. Often these are the outer bounds of the figure, for which the context
	 * button pad is shown. But in some cases it makes sense to use the outer bounds of an inner figure or to shrink/enlarge the rectangle.
	 * <p>
	 * The location can be changed by working directly on the result rectangle (e.g. getPadLocation().setRectangle()).
	 * 
	 * @return The location of the context button pad.
	 */
	IRectangle getPadLocation();

	/**
	 * Returns the generic context buttons (remove, delete, update, ...) to show in the context button pad. It can not be null, but it can
	 * be empty. Note, that the differentiation between the button semantics (generic, domain-specific, collapse, ...) is only made to
	 * display the buttons differently.
	 * <p>
	 * The button list can be changed by working directly on the result list (e.g. getGenericContextButtons().add()).
	 * <p>
	 * To ensure, that the generic context buttons are identical in all tools, you have to create them using
	 * {@link DefaultToolBehaviorProvider#setGenericContextButtons(IContextButtonPadData, com.sap.mi.gfw.mm.pictograms.PictogramElement, int)}.
	 * 
	 * @return The generic context buttons (remove, delete, update, ...) to show in the context button pad.
	 * 
	 * @see DefaultToolBehaviorProvider#setGenericContextButtons(IContextButtonPadData, com.sap.mi.gfw.mm.pictograms.PictogramElement, int)
	 */
	List<IContextButtonEntry> getGenericContextButtons();

	/**
	 * Returns the domain specific context buttons to show in the context button pad. It can not be null, but it can be empty. Note, that
	 * the differentiation between the button semantics (generic, domain-specific, collapse, ...) is only made to display the buttons
	 * differently.
	 * <p>
	 * The button list can be changed by working directly on the result list (e.g. getDomainSpecificContextButtons().add()).
	 * 
	 * @return The domain specific context buttons to show in the context button pad.
	 */
	List<IContextButtonEntry> getDomainSpecificContextButtons();

	/**
	 * Returns the collapse context button to show in the context button pad. It can be null. Note, that the differentiation between the
	 * button semantics (generic, domain-specific, collapse, ...) is only made to display the buttons differently.
	 * 
	 * @return The collapse context button to show in the context button pad.
	 */
	IContextButtonEntry getCollapseContextButton();

	/**
	 * Sets the collapse context button to show in the context button pad. Note, that the differentiation between the button semantics
	 * (generic, domain-specific, collapse, ...) is only made to display the buttons differently.
	 * <p>
	 * To ensure, that the collapse context button is identical in all tools, you have to create it using
	 * {@link ContextEntryHelper#createCollapseContextButton(boolean, com.sap.mi.gfw.features.IFeature, com.sap.mi.gfw.features.context.IContext)}.
	 * 
	 * @param collapseContextButton
	 *            The collapse context button to show in the context button pad. A value of null means, that there is no collapse context
	 *            button.
	 * 
	 * @see ContextEntryHelper#createCollapseContextButton(boolean, com.sap.mi.gfw.features.IFeature,
	 *      com.sap.mi.gfw.features.context.IContext)
	 */
	void setCollapseContextButton(IContextButtonEntry collapseContextButton);
}
