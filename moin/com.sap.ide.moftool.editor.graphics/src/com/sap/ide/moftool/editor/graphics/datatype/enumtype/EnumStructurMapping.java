package com.sap.ide.moftool.editor.graphics.datatype.enumtype;

import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.StructureMappingSingle;

public class EnumStructurMapping extends StructureMappingSingle {

    public EnumStructurMapping(IMappingProvider mp) {
        super(new EnumDataMapping(mp), mp);
    }

}
