package com.sap.ide.moftool.editor.graphics.clazz.autoadd;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.graphics.clazz.ClassFeaturesWithPattern;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ConnectionUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.impl.CreateContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.BoxRelativeAnchor;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.PeUtil;

public abstract class AbstractCreateRelatedClassesFeature extends AbstractCustomFeature {

	public AbstractCreateRelatedClassesFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public boolean isAvailable(IContext context) {
		boolean ret = false;
		if (context instanceof ICustomContext) {
			ICustomContext customContext = (ICustomContext)context;
			PictogramElement[] pes = customContext.getPictogramElements();
			if (pes.length > 0) {
				PictogramElement pe = pes[0];
				Diagram diagram = PeUtil.getDiagramForPictogramElement(pe);
				if (diagram != null && diagram.getLink() == null) {
					// Root diagrams (without package) should not enable creation of objects
					return false;
				}
				Object bo = getBusinessObjectForPictogramElement(pe);
				if (bo instanceof MofClass && pe instanceof Shape) {
					ret = true;
				}
			}
		}
		return ret;
	}


	protected MofClass createClass(PictogramElement pe, int posX, int posY, boolean upper) {

		if (pe instanceof BoxRelativeAnchor){
			pe = ((BoxRelativeAnchor) pe).getParent();
		}
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof MofClass && pe instanceof Shape) {
			MofClass mofClass = (MofClass) bo;
			Shape shape = (Shape) pe;

			CreateContext createClassContext = new CreateContext();
			// initiate a create context
			{
				createClassContext.setTargetContainer(shape.getContainer());
				int newX = posX;
				int newY = posY;
				createClassContext.setLocation(newX, newY);
			}


			ClassFeaturesWithPattern createFeature = new ClassFeaturesWithPattern();
			createFeature.setFeatureProvider(getFeatureProvider());
			boolean canCreate = createFeature.canCreate(createClassContext);

			if (canCreate) {
				// create the new class
				Object[] newObjects = createFeature.create(createClassContext);
				if (newObjects != null && newObjects.length > 0) {
					MofClass newMofClass = (MofClass) newObjects[0];
					// create generalization between the new created class and the existing class
					if (upper) {
						ConnectionUtil.createGeneralization(getConnection(), mofClass, newMofClass);
					} else {
						ConnectionUtil.createGeneralization(getConnection(), newMofClass, mofClass);
					}
					updatePictogramElement(pe);
					return newMofClass;
				}
			}
		}
		return null;
	}
}
