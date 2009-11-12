package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;

import com.sap.ide.moftool.editor.graphics.clazz.Messages;
import com.sap.ide.moftool.editor.graphics.datatype.DataTypeFeaturesWithPattern;
import com.sap.ide.moftool.editor.graphics.datatype.enumtype.EnumTypeFeatureWithPattern;
import com.sap.mi.gfw.features.IFeatureProvider;

public class CreateInnerEnumTypeFeature extends AbstractCreateInnerDataTypeFeature{

    private static String DATATYPE_NAME = Messages.CreateInnerEnumTypeFeature_0_xbut;
    private static final String NAME = NAME_PREFIX + DATATYPE_NAME;
    private static final String DESCRIPTION = NAME_PREFIX + DATATYPE_NAME +DESCRIPTION_SUFFIX;


    public CreateInnerEnumTypeFeature(IFeatureProvider fp) {
        super(fp);        
    }

    @Override
    protected boolean isDataTypeRight(Object object) {
        return (object instanceof EnumerationType);
    }

    @Override
    protected DataTypeFeaturesWithPattern getPattern() {      
        return new EnumTypeFeatureWithPattern();
    }

    public String getName() {
        return NAME;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    
}
