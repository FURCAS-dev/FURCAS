package com.sap.mi.gfw.platform;

import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.tc.moin.repository.Connection;

/**
 * The Interface IDiagramEditor.
 */
public interface IDiagramEditor {

	/**
	 * Select all the given pictogram elements in the editor.
	 * 
	 * @param pictogramElements
	 *            the pictogram elements
	 */
	void selectPictogramElements(PictogramElement[] pictogramElements);

	/**
	 * Get all pictogram elements currently selected.
	 * 
	 * @return all selected pictogram elements
	 */
	PictogramElement[] getSelectedPictogramElements();

	/**
	 * Sets the pictogram element which should be selected after the editor refresh.
	 * 
	 * @param pictogramElement
	 *            the pictogram element
	 */
	void setPictogramElementForSelection(PictogramElement pictogramElement);

	/**
	 * Sets the pictogram elements which should be selected after the editor refresh.
	 * 
	 * @param pictogramElements
	 *            the pictogram element
	 */
	void setPictogramElementsForSelection(PictogramElement[] pictogramElements);

	/**
	 * Gets the connection.
	 * 
	 * @return the connection
	 */
	Connection getConnection();

	/**
	 * Gets the diagram type provider.
	 * 
	 * @return the diagram type provider
	 */
	IDiagramTypeProvider getDiagramTypeProvider();

	/**
	 * Refresh.
	 */
	void refresh();

	/**
	 * Gets the current size.
	 * 
	 * @return the current size of the diagram in the editor
	 */
	IDimension getCurrentSize();

	/**
	 * Checks if is dirty.
	 * 
	 * @return true, if editor is dirty
	 */
	boolean isDirty();

	/**
	 * Refreshes the title tool tip text of this part.
	 */
	void refreshTitleToolTip();

	/**
	 * Refreshes all rendering decorators for the given pictogram element. That means: 1. delete current decorators 2. ask the toolbehaviour
	 * provider for decorator data 3. create new decorators with this data and render this new decorators
	 * 
	 * @param pe
	 *            pictogram element
	 */
	void refreshRenderingDecorators(PictogramElement pe);

	/**
	 * Refreshes the editor's palette.
	 */
	void refreshPalette();
}
