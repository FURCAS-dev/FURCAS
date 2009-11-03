package com.sap.mi.gfw.platform;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.ILabelProvider;
import com.sap.mi.gfw.datatypes.IDimension;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.mm.datatypes.Color;
import com.sap.mi.gfw.mm.pictograms.AbstractText;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.Font;

/**
 * The Interface IPlatformService.
 */
public interface IPlatformService {

	/**
	 * Opens an simple input dialog with OK and Cancel buttons.
	 * <p>
	 * 
	 * @param dialogTitle
	 *            the dialog title, or <code>null</code> if none
	 * @param dialogMessage
	 *            the dialog message, or <code>null</code> if none
	 * @param initialValue
	 *            the initial input value, or <code>null</code> if none (equivalent to the empty string)
	 * @return the string
	 */
	String askString(String dialogTitle, String dialogMessage, String initialValue);

	/**
	 * Convenience method to open a simple Yes/No question dialog.
	 * 
	 * @param message
	 *            the message
	 * @param dialogTitle
	 *            the dialog title
	 * @return <code>true</code> if the user presses the OK button, <code>false</code> otherwise
	 */
	boolean askUser(String dialogTitle, String message);

	/**
	 * Opens a dialog to change the color.
	 * 
	 * @param color
	 *            the color to change
	 * @return the changed color
	 */
	Color editColor(Color color);

	/**
	 * Opens a dialog to change the font styles and colors.
	 * 
	 * @param coloredFont
	 *            the current colored font
	 * @param diagram
	 *            the diagram
	 * @param text
	 *            the text
	 * @return the changed colored font
	 */
	ColoredFont editFont(AbstractText text, ColoredFont coloredFont, Diagram diagram);

	/**
	 * Let the user choose from a list of elements.
	 * 
	 * @param title
	 *            dialog title
	 * @param message
	 *            dialog message
	 * @param selectableElements
	 *            array of elements a user can choose from
	 * @param selectedElements
	 *            pre selected elements
	 * @param singleSelection
	 *            true, if only one element can be selected
	 * @param labelProvider
	 *            the label provider
	 * @return the choosen elements; null if user cancels dialog
	 */
	Object[] objectSelection(String title, String message, Object selectableElements[], Object selectedElements[], boolean singleSelection,
			ILabelProvider labelProvider);

	/**
	 * Opens the given diagram with the diagram type provider identified by the providerId. A new MOIN connection will be created.
	 * 
	 * @param diagram
	 *            diagram to open in the graphical editor
	 * @param providerId
	 *            provider id of the current diagram type provider
	 */
	void openDiagram(Diagram diagram, String providerId);

	/**
	 * Opens a platform specific kind of a quick fix UI. The resolution has to be done on the PEs and the linked objects.
	 * 
	 * @param objects
	 *            the pictogram elements
	 * @return true if the resolution was successfull
	 */
	boolean doFixes(RefObject[] objects);

	/**
	 * Determines whether quick fixes exist for a given set of RefObjects.
	 * 
	 * @param objects
	 *            the pictogram elements
	 * @return true if quick fixes exist
	 */
	boolean canDoFixes(RefObject[] objects);

	// /**
	// * Returns the Dimensions of the given text, converting newlines and tabs
	// appropriately.
	// *
	// * @param text the text
	// * @param f the font
	// * @return the dimensions of the given text
	// * @since 2.0
	// */
	// IDimension getTextExtents(String text, Font f);

	/**
	 * Async exec.
	 * 
	 * @param runnable
	 *            the runnable
	 */
	void asyncExec(Runnable runnable);

	/**
	 * Sync exec.
	 * 
	 * @param runnable
	 *            the runnable
	 */
	void syncExec(Runnable runnable);

	/**
	 * @param diagramTypeProvider
	 *            a valid diagram type provider
	 * 
	 * @return creates a dummy implementation which can be used e.g. for dark feature processing
	 */
	IDiagramEditor createDiagramEditorDummy(IDiagramTypeProvider diagramTypeProvider);

	/**
	 * Calculates and returns the size of the text.
	 * 
	 * @param text
	 * @param font
	 * 
	 * @return the size of the text
	 */
	public IDimension calculateTextSize(String text, Font font);
}
