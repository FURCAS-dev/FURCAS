package org.eclipse.emf.query.index.ui.internal;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	public static final String BUNDLE_NAME = "org.eclipse.emf.query.index.ui.internal.messages"; //$NON-NLS-1$
	public static String Query2IndexUI_IndexView_FileNotFound;
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
	public static String Query2IndexUI_IndexViewLegendManager_EObjectDescriptor;
	public static String Query2IndexUI_IndexViewLegendManager_EObjectsGroup;
	public static String Query2IndexUI_IndexViewLegendManager_IncomingLinksGroup;
	public static String Query2IndexUI_IndexViewLegendManager_IndexDescriptors;
	public static String Query2IndexUI_IndexViewLegendManager_Links;
	public static String Query2IndexUI_IndexViewLegendManager_OutgoingLinksGroup;
	public static String Query2IndexUI_IndexViewLegendManager_ResourceDescriptor;
	public static String Query2IndexUI_IndexViewLegendManager_ResourceIndexGroup;
	public static String Query2IndexUI_IndexViewLegendManager_ResourceType;
	public static String Query2IndexUI_IndexViewLegendManager_ResourceTypeGroup;
	public static String Query2IndexUI_CopyQualifiedName_NullSelection;
	public static String QueryIndexView_IndexViewTableLabelProvider_PropertyCategory;
	

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
