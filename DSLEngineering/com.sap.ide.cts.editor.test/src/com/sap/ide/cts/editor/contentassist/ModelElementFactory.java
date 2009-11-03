package com.sap.ide.cts.editor.contentassist;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Reference;

public interface ModelElementFactory {

	public MofClass createMofClass();

	public Reference createReference();

	public Attribute createAttribute();

	public MultiplicityType createMultiplicityType(int lower, int upper,
			boolean isOrdered, boolean isUnique);

}
