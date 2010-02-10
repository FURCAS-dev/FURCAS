package com.sap.ide.moftool.editor.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;

import org.eclipse.swt.widgets.Display;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.ui.preferences.PreferenceConstants;
import com.sap.ide.moftool.editor.sections.ContainingClassSelectionDialog;

public abstract class ReferenceService {

	/**
	 * Service method that can be used to find the reference for a given association end, can e.g. be used to keep the
	 * multiplicities in sync.
	 * 
	 * @param associationEnd
	 *            The association end for which the reference will be searched
	 * @return The reference that needs to be kept in sync
	 */
	public static List<Reference> findReferences(AssociationEnd associationEnd) {
		if (associationEnd == null) {
			return null;
		}

		MofClass mofClass = (MofClass) associationEnd.otherEnd().getType();
		return findReferenceInMofClass(associationEnd, mofClass, true);
	}

	public static List<Reference> findReferenceInMofClass(AssociationEnd associationEnd, MofClass mofClass,
			boolean alsoSearchSubclasses) {
		ArrayList<Reference> references = new ArrayList<Reference>();

		if (mofClass == null) {
			return references;
		}

		// First search locally within the class for a suitable reference
		Collection<ModelElement> contents = mofClass.getContents();
		for (Iterator<ModelElement> iter = contents.iterator(); iter.hasNext();) {
			ModelElement element = iter.next();
			if (element instanceof Reference) {
				Reference reference = (Reference) element;
				if (associationEnd.equals(reference.getReferencedEnd())) {
					references.add(reference);
				}
			}
		}

		if (alsoSearchSubclasses) {
			// Then in all subclasses (recursively)
			Collection<MofClass> subClasses = ClassService.getSubClasses(mofClass);
			for (Iterator<MofClass> iter = subClasses.iterator(); iter.hasNext();) {
				MofClass subClass = iter.next();
				List<Reference> subReferences = findReferenceInMofClass(associationEnd, subClass, true);
				if (subReferences.size() > 0) {
					references.addAll(subReferences);
				}
			}
		}

		return references;
	}

	public static MofClass getContainingClassForAssociationEndReference(MofClass referencingClass) {
		return getContainingClassForAssociationEndReference(referencingClass, false);
	}

	public static MofClass getContainingClassForAssociationEndReference(MofClass referencingClass, boolean alwaysAsk) {
		MofClass containingClass = null;

		String setting = PreferenceConstants.getReferenceCreationSetting();
		if (alwaysAsk || PreferenceConstants.VALUE_REFERENCE_CREATION_ASK.equals(setting)) {

			ModelElement modelElement = new ContainingClassSelectionDialog().openAddDialog(Display.getCurrent()
					.getActiveShell(), MofService.getConnection(referencingClass), referencingClass);
			if (modelElement instanceof MofClass) {
				containingClass = (MofClass) modelElement;
			}
		} else if (PreferenceConstants.VALUE_REFERENCE_CREATION_AUTO.equals(setting)) {
			// Use type of association end as containing class for reference
			containingClass = referencingClass;
		}

		return containingClass;
	}

}
