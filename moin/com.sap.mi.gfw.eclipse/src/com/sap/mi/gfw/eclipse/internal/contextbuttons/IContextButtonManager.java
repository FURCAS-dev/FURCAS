package com.sap.mi.gfw.eclipse.internal.contextbuttons;

import org.eclipse.gef.GraphicalEditPart;

/**
 * An interface of a context button manager, which is responsible to show/hide a context buttons for an edit-part.
 */
public interface IContextButtonManager {

	/**
	 * Registers the given graphical edit-part for the context button manager. As a result the context button manager will show the context
	 * buttons when the mouse is over the given graphical edit-part. Typically in this method the context button manager will register as
	 * mouse-listener on the edit-part.
	 * 
	 * @param graphicalEditPart
	 *            The graphical edit-part to register for the context button manager.
	 */
	void register(GraphicalEditPart graphicalEditPart);

	/**
	 * Deregisters the given graphical edit-part from the context button manager. Also see {@link #register(GraphicalEditPart)}.
	 * 
	 * @param graphicalEditPart
	 *            The graphical edit-part to deregister from the context button manager.
	 */
	void deRegister(GraphicalEditPart graphicalEditPart);

	/**
	 * Hides the context buttons (if they are currently showing). This method can be called from outside the context button manager to hide
	 * the context buttons, e.g. when the mouse leaves the editor, when the shape is moved/resized, ...
	 */
	void hideContextButtonsInstantly();
}
