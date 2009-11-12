package com.sap.ide.moftool.editor.graphics;

import com.sap.ide.moftool.editor.graphics.clazz.ClassFeaturesWithPattern;
import com.sap.ide.moftool.editor.graphics.datatype.enumtype.EnumTypeFeatureWithPattern;
import com.sap.ide.moftool.editor.graphics.datatype.structuretype.StructureTypeFeatureWithPattern;
import com.sap.mi.gfw.dt.JAMDiagramTypeProvider;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;

public class ClassDiagramTypeProvider extends JAMDiagramTypeProvider {

    private IToolBehaviorProvider[] availableToolBehaviorProviders;

    public ClassDiagramTypeProvider() {
        super();
        ClassDiagramFeatureProvider fp = new ClassDiagramFeatureProvider(this);
        fp.addPattern(new ClassFeaturesWithPattern());
        fp.addPattern(new EnumTypeFeatureWithPattern());
        fp.addPattern(new StructureTypeFeatureWithPattern());
        setFeatureProvider(fp);
    }

    @Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (availableToolBehaviorProviders == null) {
            availableToolBehaviorProviders = new IToolBehaviorProvider[] { new ClassDiagramToolBehaviourProvider(this) };
        }
        return availableToolBehaviorProviders;
    }

	@Override
	public String getDiagramTitleImage() {
		return IImageConstants.IMG_CLASS_DIAGRAM;
	}
}
