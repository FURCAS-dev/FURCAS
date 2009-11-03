package com.sap.ide.cts.editor.contentassist;

import java.util.Arrays;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Reference;

public class ModelElementMoinFactory implements ModelElementFactory {

	private Connection connection;
	private ModelPackage rootPkg;

	public ModelElementMoinFactory(Connection connection) {
		this.connection = connection;
		rootPkg = connection.getPackage(ModelPackage.PACKAGE_DESCRIPTOR);
	}

	protected Connection getConnection() {
		return connection;
	}

	@Override
	public MofClass createMofClass() {
		return (MofClass) rootPkg.getMofClass().refCreateInstance();
	}

	@Override
	public Attribute createAttribute() {
		return (Attribute) rootPkg.getAttribute().refCreateInstance();
	}

	@Override
	public Reference createReference() {
		return (Reference) rootPkg.getReference().refCreateInstance();
	}

	@Override
	public MultiplicityType createMultiplicityType(int lower, int upper,
			boolean isOrdered, boolean isUnique) {
		return (MultiplicityType) rootPkg.refCreateStruct("MultiplicityType",
				Arrays
						.asList(new Object[] { lower, upper, isOrdered,
								isUnique }));
	}

}
