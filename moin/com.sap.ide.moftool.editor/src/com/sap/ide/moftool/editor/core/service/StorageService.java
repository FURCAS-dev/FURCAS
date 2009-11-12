package com.sap.ide.moftool.editor.core.service;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Tag;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.commands.CreateTagCommand;
import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.tc.moin.friends.Constants;
import com.sap.tc.moin.repository.Connection;

/**
 * MOIN storage related services
 * @author d027044
 */
public final class StorageService {

	private static final String STORAGE_TAG_NAME_PREFIX = "storage_"; //$NON-NLS-1$
	
	/**
	 * Returns the relevant tag for the storage definition for the given association end and
	 * the given value if the tag exists. In case the tag does not exist <code>null</code> is
	 * returned.
	 * This method follows the MOIN suggestion on how to cope with defining storage. The 
	 * relevant tag is defined within the top level package containing the association end 
	 * (the top level package is the root package within the containment hierarchy of the 
	 * association end). There can be a tag for each of the possible values (<code>true</code> and
	 * <code>false</code>); the tags only exist in case at least one association end exists
	 * within the scope of the root package that defines the according storage value.
	 * @param ae The association end to search the tag for
	 * @param tagValue The desired value of the tag (<code>true</code> or <code>false</code>
	 * @return The relevant tag if it exist, otherwise <code>null</code>
	 */
	public static Tag getRelevantStorageTag(AssociationEnd ae, boolean tagValue) {
		// Get the root package (should contain the tags for storage)
		MofPackage rootPackage = PackageService.getRootPackage(ae);
		if (rootPackage == null) {
			return null;
		}
		
		// Loop over all directly contained elements and find the tags
		List<ModelElement> contents = rootPackage.getContents();
		for (Iterator<ModelElement> it = contents.iterator(); it.hasNext();) {
			ModelElement modelElement = it.next();
			if (modelElement instanceof Tag) {
				Tag tag = (Tag)modelElement;
				if (Constants.MARK_LINK_END.equals(tag.getTagId())) {
					// Storage tag found
					List<String> values = tag.getValues();
					if (values != null && values.size() > 0) {
						if (tagValue) {
							// Search for "Yes" tag
							if (Constants.MARK_LINK_END_STORE.equals(values.get(0))) {
								return tag;
							}
						}
						else {
							// Search for "No" tag
							if (Constants.MARK_LINK_END_DONTSTORE.equals(values.get(0))) {
								return tag;
							}
						}
					}
				}
			}
		}
		
		// No appropriate tag found
		return null;
	}
	
	/**
	 * Returns the relevant tag for the storage definition for the given association end and
	 * the given value if the tag exists. In case the tag does not exist it will be created.
	 * This method follows the MOIN suggestion on how to cope with defining storage. The concept
	 * is described {@linkplain StorageService#getRelevantStorageTag(AssociationEnd, boolean)}here. 
	 * @param ae The association end to search the tag for
	 * @param tagValue The desired value of the tag (<code>true</code> or <code>false</code>
	 * @return The relevant tag
	 */
	public static Tag getOrCreateRelevantStorageTag(AssociationEnd ae, boolean tagValue, Connection connection) {
		// Search for existing tag
		Tag tag = getRelevantStorageTag(ae, tagValue);
		if (tag == null) {
			// Tag does not yet exist --> create it
			tag = createStorageTag(PackageService.getRootPackage(ae), tagValue, connection);
		}
		
		return tag;
	}
	
	/**
	 * Creates the storage {@link Tag} with the given value in the given {@link Namespace} object.
	 * To follow the MOIN conventions the {@link Namespace} object has to be a root package (in 
	 * fact this is not checked here).
	 * @param parent The {@link Namespace} to create the tag in
	 * @param tagValue The value of the tag, either <code>true</code> or <code>false</code>
	 * @param connection The connection to use
	 * @return The newly created {@link Tag}
	 */
	private static Tag createStorageTag(Namespace parent, boolean tagValue, Connection connection) {
		String name = null;
		String value = null;
		if (tagValue) {
			name = STORAGE_TAG_NAME_PREFIX + "yes";  //$NON-NLS-1$
			value = Constants.MARK_LINK_END_STORE;
		}
		else {
			name = STORAGE_TAG_NAME_PREFIX + "no";  //$NON-NLS-1$
			value = Constants.MARK_LINK_END_DONTSTORE;
		}

		// Create the tag
		CreateTagCommand command = new CreateTagCommand(parent, name, connection);
		if (!command.canExecute()) {
			throw new InternalErrorException("Cannot create tag");  //$NON-NLS-1$
		}
		command.execute();
		Tag tag = command.getTag();
		if (tag == null) {
			throw new InternalErrorException("Tag was not created");  //$NON-NLS-1$
		}
		
		// Set attributes
		tag.setAnnotation(LocalizationMessages.StorageService_0_YMSG);
		tag.setTagId(Constants.MARK_LINK_END);
		tag.getValues().add(value);
		
		// No tagged elements so far (not even the package)
		tag.getElements().clear();
		
		return tag;
	}
}
