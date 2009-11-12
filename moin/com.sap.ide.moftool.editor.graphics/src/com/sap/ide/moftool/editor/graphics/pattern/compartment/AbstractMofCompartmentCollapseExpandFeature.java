package com.sap.ide.moftool.editor.graphics.pattern.compartment;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;

public abstract class AbstractMofCompartmentCollapseExpandFeature extends AbstractCustomFeature{
    private String name ;
    private String description;
   
    public AbstractMofCompartmentCollapseExpandFeature(IFeatureProvider fp, String name, String description) {
        super(fp); 
        this.name = name;
        this.description = description;
    }  
    public String getName() {
        return name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
}
