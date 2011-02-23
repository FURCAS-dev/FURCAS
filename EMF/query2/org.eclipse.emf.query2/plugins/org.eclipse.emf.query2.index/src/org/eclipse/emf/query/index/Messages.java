package org.eclipse.emf.query.index;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	public static final String BUNDLE_NAME = "org.eclipse.emf.query.index.messages"; //$NON-NLS-1$
	public static String QueryIndexUI_IndexFactory_ErrorIndexingURI;
	public static String Query2Index_AbstractMapBase_NoElementFound;
	public static String Query2Index_AbstractMapBase_SizeCounterDiffers;
	public static String Query2Index_IndexUpdaterImpl_ResourceAlreadyInUse;
	public static String Query2Index_IndexUpdaterImpl_ToImplement;
	public static String Query2Index_LeanMap_ToImplement;
	public static String Query2Index_ListMap_ElementNotFound;
	public static String Query2Index_ListMap_NullArgument;
	public static String Query2Index_PageableIndexImpl_ToImplement;
	public static String Query2Index_PageableIndexImpl_UnsetTolerance;
	public static String Query2Index_PageableIndexImpl_UnspecifiedBaseDirectory;
	public static String Query2Index_PageFileProviderImpl_BasePathNotSet;
	public static String Query2Index_PagingStrategyImpl_AlreadyInQueue;
	public static String Query2Index_PagingStrategyImpl_ElementNotLocked;
	public static String Query2Index_PagingStrategyImpl_LockedPages;
	public static String Query2Index_QueryResultImpl_InvalidResult;
	public static String Query2Index_SerializationStrategyFactory_UnknownLinkKind;
	public static String Query2Index_SerializationStrategyFactory_UnknownLinkType;
	public static String Query2Index_SerializationStrategyFactory_UnsupportedValue;
	public static String Query2Index_SingleMap_NullParameter;
	public static String QueryIndexUI_IndexFactory_TimeTakenToDump;
	public static String QueryIndexUI_IndexFactory_TimeTakenToLoad;
	
	
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
