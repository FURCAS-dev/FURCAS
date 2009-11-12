package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;

public abstract class AbstractAddDataTypesFeature extends AbstractCustomFeature{

    private  String name;
    private  String description;

    public AbstractAddDataTypesFeature(IFeatureProvider fp,String name, String description) {
        super(fp);  
        this.name = name;
        this.description = description;
    }
    
    @Override
    public boolean canExecute(ICustomContext context) {
        return true;
    }
       
    @Override
    public boolean isAvailable(IContext context) {
        boolean ret = false;
        if (context instanceof ICustomContext) {
            PictogramElement[] pes = ((ICustomContext) context).getPictogramElements();
            if (pes.length == 1) {
                Object bo = getBusinessObjectForPictogramElement(pes[0]);
                if (bo instanceof MofClass) {
                    ret = canExecute(context);
                }
            }
        }
        return ret;
    }
    
    
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
    
    
   protected void addDataTypeToDiagramm(DataType dataType, int x, int y){
       AddContext addContext = new AddContext();
       addContext.setNewObject(dataType);
       addContext.setTargetContainer(getDiagram());
       addContext.setLocation(x+500,y);       
       getFeatureProvider().addIfPossible(addContext);       
   }

}
