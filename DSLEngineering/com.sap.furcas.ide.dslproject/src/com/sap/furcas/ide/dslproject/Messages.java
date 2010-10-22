package com.sap.furcas.ide.dslproject;

import org.eclipse.osgi.util.NLS;


/**
 * The Class Messages.
 */
public class Messages extends NLS {
	
	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "com.sap.mi.textual.epi.conf.messages"; //$NON-NLS-1$

    public static String WorkbenchPropertyPage_NoEcoreFileSetMessage;

    public static String EcoreRadioButton;
	
	/** The Change label. */
	public static String ChangeLabel;
	
	/** The Meta model label. */
	public static String MetaModelLabel;
	
	/** The Toggle nature action_ remove nature confirm text. */
	public static String ToggleNatureAction_RemoveNatureConfirmText;
	
	/** The Toggle nature action_ remove nature confirm title. */
	public static String ToggleNatureAction_RemoveNatureConfirmTitle;
	
	/** The Workbench property page_ error_ nature_ conflict. */
	public static String WorkbenchPropertyPage_Error_Nature_Conflict;
	
	/** The Workbench property page_ error nature not set. */
	public static String WorkbenchPropertyPage_ErrorNatureNotSet;
	
	/** The Workbench property page_ incomplete selection. */
	public static String WorkbenchPropertyPage_IncompleteSelection;
	
	/** The Workbench property page_ no dsl nature. */
	public static String WorkbenchPropertyPage_NoDSLNature;
	
	/** The Workbench property page_ no meta model set message. */
	public static String WorkbenchPropertyPage_NoMetaModelSetMessage;
	
	/** The Workbench property page_ no ref project set message. */
	public static String WorkbenchPropertyPage_NoRefProjectSetMessage;
	
	/** The message beneath Ref project label. */
	public static String MessageRefProjectLabel;
	
	/** The Ref project label. */
	public static String RefProjectLabel;
	
	/** The Ref project radio button. */
	public static String RefProjectRadioButton;
	
	/** The Deployed meta radio button. */
	public static String DeployedMetaRadioButton;
	
	/** The Select ref project dialog title. */
	public static String SelectRefProjectDialogTitle;
	
	/** The Select deployed metamodel dialog title. */
	public static String SelectDeployedMetamodelDialogTitle;
	
	/** The Add nature wizard title. */
	public static String AddNatureWizardTitle;
	
	/** The Add nature wizard mm page description. */
	public static String AddNatureWizardMMPageDescription;
	
	/** The Success. */
	public static String Success;
	
	/** The Remove nature success message. */
	public static String RemoveNatureSuccessMessage;

    public static String EcoreLabel;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	/**
	 * Instantiates a new messages.
	 */
	private Messages() {
	}
}
