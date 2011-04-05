package org.eclipse.emf.query.index.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	public static final String BUNDLE_NAME = "org.eclipse.emf.query.index.ui.messages"; //$NON-NLS-1$
	public static String Query2IndexUI_CopyQualifiedNameHandler_2;
	public static String Query2IndexUI_CopyQualifiedNameHandler_ErrorStatus;
	public static String Query2IndexUI_CopyQualifiedNameHandler_SelectionErrorMessage;
	public static String Query2IndexUI_CopyQualifiedNameHandler_UnableToCopyErrorMessage;
	public static String Query2IndexUI_Basic;
	public static String Query2IndexUI_ResourceURI;
	public static String Query2IndexUI_IndexView_EObjectGroup;
	public static String Query2IndexUI_IndexView_ErrorInOpeningEditor;
	public static String Query2IndexUI_IndexView_IncomingLinksGroup;
	public static String Query2IndexUI_IndexView_InvalidFileForEditor;
	public static String Query2IndexUI_IndexView_OutgoingLinksGroup;
	public static String Query2IndexUI_IndexView_PartName;
	public static String Query2IndexUI_IndexView_ToolTip;
	public static String Query2IndexUI_IndexViewTreeLabelProvider_EObjectTable;
	public static String Query2IndexUI_IndexViewTreeLabelProvider_IncomingLinksTable;
	public static String Query2IndexUI_IndexViewTreeLabelProvider_OutgoingLinksTable;
	public static String Query2IndexUI_IndexViewTreeLabelProvider_ResourceIndex;
	public static String Query2IndexUI_IndexViewTreeLabelProvider_TypeIndex;
	public static String Query2IndexUI_QueryIndexBuilder_IndexingResource;
	public static String Query2IndexUI_RecreateIndicesHandler_BuildingIndices;
	public static String Query2IndexUI_IndexView_ActionDisplayLegends_Text;
	public static String Query2IndexUI_IndexView_Legend;
	public static String Query2IndexUI_IndexView_TableFilters_Text;
	

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

	public static String getString(String parameterizedString, String params[]) {
		return NLS.bind(parameterizedString, params);
	}

}
