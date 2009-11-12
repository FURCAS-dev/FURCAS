package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.graphics.datatype.DataTypeFeaturesWithPattern;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.CreateContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

public abstract class AbstractCreateInnerDataTypeFeature extends AbstractCustomFeature{

	protected static final String NAME_PREFIX = ""; //$NON-NLS-1$
	protected static final String DESCRIPTION_SUFFIX= ""; //$NON-NLS-1$

	private DataType mNewDataType = null;

	public AbstractCreateInnerDataTypeFeature(IFeatureProvider fp) {
		super(fp);       
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof MofClass) {     
				ret = !ModelElementService.isForeignObject(getDiagram(), (MofClass)bo);
			}
		}
		return ret;
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if (context instanceof ICustomContext) {
			ICustomContext customContext = (ICustomContext) context;
			PictogramElement[] pes = customContext.getPictogramElements();
			if (pes.length > 0) {
				PictogramElement pe = pes[0];
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof MofClass && pe instanceof Shape) {
					ret = true;
				}
			}
		}
		return ret;
	}

	public void execute(ICustomContext context) {
		PictogramElement pe = context.getPictogramElements()[0];
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof MofClass && pe instanceof Shape) {
			MofClass mofClass = (MofClass) bo;
			ContainerShape classShape = (ContainerShape) pe;

			CreateContext createDataTypeContext = new CreateContext();
			// initiate a create context
			createDataTypeContext.setTargetContainer(classShape.getContainer());

			DataTypeFeaturesWithPattern dataTypePattern = getPattern();
			dataTypePattern.setContainer(mofClass);
			dataTypePattern.setFeatureProvider(getFeatureProvider());

			if (dataTypePattern.canCreate(createDataTypeContext)) {
				// create the Data Type
				Object[] obj = dataTypePattern.create(createDataTypeContext);
				if (isDataTypeRight(obj[0])) {
					mNewDataType = (DataType) obj[0];
					mNewDataType.setContainer(mofClass);
				}
			}
		}
	}

	protected abstract boolean isDataTypeRight(Object object);
	protected abstract DataTypeFeaturesWithPattern getPattern();
	
	public DataType getNewDataType() {
		return mNewDataType;
	}
}
