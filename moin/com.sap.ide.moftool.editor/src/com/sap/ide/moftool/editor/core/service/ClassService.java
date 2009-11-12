package com.sap.ide.moftool.editor.core.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;

public abstract class ClassService {

	/**
	 * Returns the sub classes of the given MOF class.
	 * @param mofClass
	 * The class for which the sub classes should be returned
	 * @param connection
	 * The MOIN connection to use
	 * @return
	 * A collection of the all direct subclasses of the given MOF class.
	 */
	public static Collection<MofClass> getSubClasses(MofClass mofClass) {
		Connection connection = ModelAdapter.getInstance().getConnection(mofClass);
		Generalizes generalizes = MofService.getModelPackage(connection).getGeneralizes();
		Collection<GeneralizableElement> subTypes = generalizes.getSubtype(mofClass);
		List<MofClass> list = new ArrayList<MofClass>();
		for (GeneralizableElement element : subTypes) {
			if (element instanceof MofClass) {
				list.add((MofClass)element);
			}
		}
		return list;
	}
	
	public static void addRecursivelyAllSubClasses(MofClass mofClass, List<MofClass> allClasses) {
		if (!allClasses.contains(mofClass)) {
			allClasses.add(mofClass);
		}
		Collection<MofClass> subclasses = ClassService.getSubClasses(mofClass);
		for (Iterator<MofClass> it = subclasses.iterator(); it.hasNext();) {
			MofClass subClass = it.next();
			addRecursivelyAllSubClasses(subClass, allClasses);
		}
	}

	/**
	 * Returns the super classes of the given MOF class.
	 * @param mofClass
	 * The class for which the super classes should be returned
	 * @param connection
	 * The MOIN connection to use
	 * @return
	 * A collection of the all direct superclasses of the given MOF class.
	 */
	public static Collection<MofClass> getSuperClasses(MofClass mofClass) {
		Connection connection = ModelAdapter.getInstance().getConnection(mofClass);
		Generalizes generalizes = MofService.getModelPackage(connection).getGeneralizes();
		Collection<GeneralizableElement> superTypes = generalizes.getSupertype(mofClass);
		List<MofClass> list = new ArrayList<MofClass>();
		for (GeneralizableElement element : superTypes) {
			if (element instanceof MofClass) {
				list.add((MofClass)element);
			}
		}
		return list;
	}

	public static List<Association> getAllAssociations(MofClass mofClass) {
		Collection<AssociationEnd> c = ((Partitionable)mofClass).get___Connection().getJmiHelper().getAssociationEnds(mofClass, false);

		Iterator<AssociationEnd> it = c.iterator();
		List<Association> associations = new ArrayList<Association>(c.size());
		// flag to avoid appearing of self associations twice
		int selfAssociation = 0;
		while (it.hasNext()) {
			AssociationEnd assocEnd = it.next();
			Classifier type = assocEnd.getType();
			if (type != null && type.equals(assocEnd.otherEnd().getType())) {
				selfAssociation += 1;
			} else if (type != null && type.equals(mofClass)) {
				Association assoc = (Association)assocEnd.refImmediateComposite();
				associations.add(assoc);
			}
			if (selfAssociation == 2) {
				Association assoc = (Association)assocEnd.refImmediateComposite();
				associations.add(assoc);
			}
		}
		return associations;
	}

	public static List<Reference> getReferences(MofClass mofClass) {
		List<ModelElement> contents = mofClass.getContents();
		List<Reference> references = new ArrayList<Reference>();
		for (ModelElement obj : contents) {
			if (obj instanceof Reference) {
				Reference ref = (Reference)obj;
				references.add(ref);
			}
		}
		return references;
	}
}
