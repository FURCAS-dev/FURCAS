package com.sap.ide.moftool.editor.graphics.datatype.structuretype;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.StructureMappingSingle;

public class StructureTypeStructureMapping extends StructureMappingSingle {

    public StructureTypeStructureMapping(IMappingProvider mp) {
        super(new StructureTypeDataMapping(mp), mp);
    }

    
}
