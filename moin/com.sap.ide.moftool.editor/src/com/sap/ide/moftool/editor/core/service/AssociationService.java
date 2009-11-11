package com.sap.ide.moftool.editor.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;

import com.sap.ide.moftool.editor.core.commands.InternalErrorException;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

public final class AssociationService {
	
	/**
	 * This methods returns the association ends for the given association.
	 * The assumption is that there are exactly two ends for every association
	 * otherwise an internal error will be thrown. 
	 * @param association
	 * The association for which the association ends should be returned 
	 * @return
	 * An array of two association ends, the first one is the source end,
	 * the second one the target end.
	 */
	public static AssociationEnd[] getAssociationEnds(Association association) {
		List<ModelElement> content = association.getContents();
		AssociationEnd[] assocEnds = new AssociationEnd[2];
		int i = 0;
		for (Object obj : content) {
			if (obj instanceof AssociationEnd) {
				AssociationEnd ae = (AssociationEnd)obj;
				if (i < 2) {
					assocEnds[i] = ae;
				}
				i += 1;
			}
		}
		if (i != 2 || assocEnds[0] == null || assocEnds[1] == null) {
			MOFToolEditorPlugin.logError(new InternalErrorException("There must be exactly two association ends for association '" + //$NON-NLS-1$
					association.getName() + "'; found: " + i)); //$NON-NLS-1$
		}
		return assocEnds;
	}

	public static String createNewAssociationName(MofClass source, MofClass target) {
		int count = 0;
		Collection<Association> allAssoc = new ArrayList<Association>();
		Collection<String> allAssocNames = new ArrayList<String>();
		StringBuffer ret = new StringBuffer();
		ret.append(source.getName() + "_" + target.getName()); //$NON-NLS-1$
		
		// Get all associations of involved classes
		allAssoc.addAll(ClassService.getAllAssociations(source));
		allAssoc.addAll(ClassService.getAllAssociations(target));
		
		// Create a collection from the names of associations
		for (Iterator<Association> iter = allAssoc.iterator(); iter.hasNext();) {
			Association ass = iter.next();
			allAssocNames.add(ass.getName());
		}

		// Create a unique name for new association
		while (true) {
			StringBuffer newName = new StringBuffer();
			newName.append(ret.toString());
			if (count != 0) {
				newName.append(Integer.toString(count));
			}
			if (!allAssocNames.contains(newName.toString())) {
				return newName.toString();
			}
			count++;
		}
	}
	
	/**
	 * Checks if navigation is enabled for the given {@link AssociationEnd}. Returns <code>true</code>
	 * in case a reference exists within the type class of the association end.
	 * @param ae The association end to check the navigation for. Must not be <code>null</code>,
	 * otherwise a NullPointerException is thrown.
	 * @return <code>true</code> in case navigation is defined for the given association end, <code>
	 * false</code> otherwise.
	 */
	public static boolean isNavigationEnabled(AssociationEnd ae) {
		
		// Check if a reference exists
		Classifier classifier = ae.otherEnd().getType();
		if (classifier instanceof MofClass) {
			List<Reference> referenceList = ReferenceService.findReferenceInMofClass(ae,
					// use the other end to find references pointing there
					(MofClass)classifier, false);
			if (referenceList.size() > 0) {
				// There is at least one reference locally in the class
				return true;
			}
		}
		
		return false;
	}
}
