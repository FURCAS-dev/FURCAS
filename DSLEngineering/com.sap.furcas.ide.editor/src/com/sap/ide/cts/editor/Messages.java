package com.sap.ide.cts.editor;

import org.eclipse.osgi.util.NLS;

/**
 * Common class for all message bundle classes.
 * 
 * @author Roman Andrej
 */
public class Messages extends NLS {
	
	/**
	 *  Initialize the class with the values from the specified message bundle.
	 */
	static {
		NLS.initializeMessages("messages", Messages.class); //$NON-NLS-1$
	}

	/**
	 * Define the Title,Message and ErrorMassage of DataTypeDialog
	 */
	public static String DataTypeDialog_NewTitle;
	public static String DataTypeDialog_EditTitle;
	public static String DataTypeDialog_ShellNewTitle;
	public static String DataTypeDialog_ShellEditTitle;
	public static String DataTypeDialog_ErrorMsgName;
	public static String DataTypeDialog_ErrorMsgInner;
	public static String DataTypeDialog_ErrorMsgInnerName;
	public static String DataTypeDialog_ErrorMsgInnerType;

	/**
	 * Define the Title,Message and ErrorMassage of ParametersDialog
	 */
	public static String ParametersDialog_Title;
	public static String ParametersDialog_ErrorMsgInner;
}
