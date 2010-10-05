package com.sap.ide.cts.editor.contentassist;

import java.util.Arrays;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;


public class ModelElementMoinFactory implements ModelElementFactory {

	private ResourceSet connection;
	private EPackage rootPkg;

	public ModelElementMoinFactory(ResourceSet connection) {
		this.connection = connection;
		rootPkg = connection.getPackage(EPackage.PACKAGE_DESCRIPTOR);
	}

	protected ResourceSet getConnection() {
		return connection;
	}

	@Override
	public EClass createMofClass() {
		return (EClass) rootPkg.eClass().refCreateInstance();
	}

	@Override
	public EReference createAttribute() {
		return (EReference) rootPkg.getAttribute().refCreateInstance();
	}

	@Override
	public EReference createReference() {
		return (EReference) rootPkg.getReference().refCreateInstance();
	}

	@Override
	public EReference createMultiplicityType(int lower, int upper,
			boolean isOrdered, boolean isUnique) {
		return (EReference) rootPkg.refCreateStruct("MultiplicityType",
				Arrays
						.asList(new Object[] { lower, upper, isOrdered,
								isUnique }));
	}

}
