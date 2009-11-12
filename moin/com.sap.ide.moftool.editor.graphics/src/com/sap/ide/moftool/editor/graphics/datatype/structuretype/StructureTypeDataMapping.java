package com.sap.ide.moftool.editor.graphics.datatype.structuretype;

import java.text.MessageFormat;

import com.sap.tc.moin.repository.mmi.model.StructureType;

import com.sap.ide.moftool.editor.graphics.datatype.Messages;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofDataMapping;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mm.links.PictogramLink;

public class StructureTypeDataMapping  extends AbstractMofDataMapping {
	
    public StructureTypeDataMapping(IMappingProvider mp) {
        super(mp);
    }

    @Override
    public String getText(PictogramLink link) {
        // TODO: Replace with icon and remove
        StringBuffer result = new StringBuffer();      
        Object refObject = getBusinessObject(link);       
        if (refObject instanceof StructureType) {
            StructureType structureType = (StructureType) refObject;
           result.append(getHeaderInformation(structureType));
        }
        return result.toString();
    }

    private String getHeaderInformation(StructureType structureType) {
        return MessageFormat.format(Messages.StructureTypeDataMapping_0_xmsg, new Object[]{structureType.getName()});
    }
}
