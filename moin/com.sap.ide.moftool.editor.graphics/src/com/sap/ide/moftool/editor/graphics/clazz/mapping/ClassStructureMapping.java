package com.sap.ide.moftool.editor.graphics.clazz.mapping;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.StructureMappingSingle;

public class ClassStructureMapping extends StructureMappingSingle {

	public ClassStructureMapping(IMappingProvider mp) {
		super(new ClassDataMapping(mp), mp);
	}

}
