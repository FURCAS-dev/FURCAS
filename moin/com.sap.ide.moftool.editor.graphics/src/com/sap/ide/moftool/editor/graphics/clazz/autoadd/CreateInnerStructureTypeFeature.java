package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.datatype.DataTypeFeaturesWithPattern;
import com.sap.ide.moftool.editor.graphics.datatype.structuretype.StructureTypeFeatureWithPattern;
import com.sap.mi.gfw.features.IFeatureProvider;

public class CreateInnerStructureTypeFeature extends AbstractCreateInnerDataTypeFeature {

    private static String DATATYPE_NAME = Messages.CreateInnerStructureTypeFeature_0_xbut;
    private static final String NAME = NAME_PREFIX + DATATYPE_NAME;
    private static final String DESCRIPTION = NAME_PREFIX + DATATYPE_NAME +DESCRIPTION_SUFFIX;

    public CreateInnerStructureTypeFeature(IFeatureProvider fp) {
        super(fp);
    }

    @Override
    protected boolean isDataTypeRight(Object object) {
        return (object instanceof StructureType);
    }

    @Override
    protected DataTypeFeaturesWithPattern getPattern() {      
        return new StructureTypeFeatureWithPattern();
    }

    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

}
