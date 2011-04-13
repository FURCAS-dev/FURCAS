package org.eclipse.emf.query.index;

import org.eclipse.osgi.util.NLS;

/**
 * Containers externalized strings used by index code
 *
 */
public class Messages extends NLS {
	
	public static final String BUNDLE_NAME = "org.eclipse.emf.query.index.messages"; //$NON-NLS-1$
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	public static String QueryIndexUI_IndexFactory_ErrorIndexingURI;
	public static String Query2Index_AbstractMapBase_NoElementFound;
	public static String Query2Index_AbstractMapBase_SizeCounterDiffers;
	public static String Query2Index_EObjectDescriptorProperties_Fragment;
	public static String Query2Index_EObjectDescriptorProperties_Name;
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
	public static String Query2Index_ReferenceDescriptorProperties_Basic;
	public static String Query2Index_ReferenceDescriptorProperties_ReferenceURI;
	public static String Query2Index_ReferenceDescriptorProperties_SourceFragment;
	public static String Query2Index_ReferenceDescriptorProperties_SourceResource;
	public static String Query2Index_ReferenceDescriptorProperties_TargetFragment;
	public static String Query2Index_ReferenceDescriptorProperties_TargetResource;
	public static String Query2Index_ResourceIndexProperties_Basic;
	public static String Query2Index_ResourceIndexProperties_ResourceURI;
	public static String Query2Index_SerializationStrategyFactory_UnknownLinkKind;
	public static String Query2Index_SerializationStrategyFactory_UnknownLinkType;
	public static String Query2Index_SerializationStrategyFactory_UnsupportedValue;
	public static String Query2Index_SingleMap_NullParameter;
	public static String QueryIndexUI_IndexFactory_TimeTakenToDump;
	public static String QueryIndexUI_IndexFactory_TimeTakenToLoad;

	private Messages() {
	}
	
	public static String getString(String parameterizedString, String params[]) {
		return NLS.bind(parameterizedString, params);
	}

}
