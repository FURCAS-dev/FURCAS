package com.sap.ide.moftool.editor.graphics.datatype;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.AnchorUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.context.impl.AddConnectionContext;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;

public abstract class DataTypeFeaturesWithPattern extends AbstractMofCompartmentPattern{

	private Namespace container = null;
	@Override
	public boolean canCreate(ICreateContext context) {
		boolean ret = false;
		ContainerShape targetContainer = context.getTargetContainer();
		if (targetContainer instanceof Diagram) {
			if (getBusinessObjectForPictogramElement(targetContainer) != null){
				ret=true;
			}
		} 
		return ret;
	}

	@Override
	public boolean canAdd(IAddContext context) {
    	if (!super.canAdd(context)) {
    		return false;
    	}
		// Returns true, if the user wants to add a Data Type to a diagram that is not
		// yet visible on the diagram
		Object obj = context.getNewObject();
		if (obj instanceof DataType) {
			DataType dataType = (DataType) obj;
			List<DataType> allDataTypesOnDiagram = getAllDataTypesFromDiagram();
			if (context.getTargetContainer() instanceof Diagram && !allDataTypesOnDiagram.contains(dataType)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		PictogramElement pe = super.add(context);
		ContainerShape cs = (ContainerShape) pe;

		Object ref = getBusinessObjectForPictogramElement(pe);
		if (ref instanceof DataType) {
			DataType dataType = (DataType) ref;
			int newWidth = getAddWidth(dataType);
			if (newWidth != 0) {
				cs.getGraphicsAlgorithm().setWidth(newWidth);
			}
			if(dataType.getContainer() instanceof MofClass){
				MofClass mofClass = (MofClass) dataType.getContainer();              
				ContainerShape mofClassShape =  DiagramUtil.getExistingMofClassShapeFromDiagram(getDiagram(), mofClass);
				if (mofClassShape != null) {
					// Only add the connection in case the class is also available on the diagram
					updateConnenction(cs, mofClassShape);
				}
			}
			updatePictogramElement(cs);
		}
		return cs;
	}

	private void updateConnenction(ContainerShape source, ContainerShape target) {
		Anchor fromAnchor = AnchorUtil.getChopboxAnchor(source.getAnchors());
		Anchor toAnchor = AnchorUtil.getChopboxAnchor(target.getAnchors());
		AddConnectionContext addConnectionContext = new AddConnectionContext(fromAnchor, toAnchor);
		addConnectionContext.setNewObject(null);
		getFeatureProvider().addIfPossible(addConnectionContext);
	}

	public void setContainer(Namespace container) {
		this.container = container;
	}
	public Namespace getContainer(){
		return container;
	}

	private List<DataType> getAllDataTypesFromDiagram() {
		List<Shape> ch = getDiagram().getChildren();
		ArrayList<DataType> result = new ArrayList<DataType>();
		for (ListIterator<Shape> iter = ch.listIterator(); iter.hasNext();) {
			PictogramElement pe = (PictogramElement)iter.next();
			Object object = getBusinessObjectForPictogramElement(pe);
			if (object instanceof DataType) {
				result.add((DataType)object);
			}
		}
		return result;
	}
	
	protected abstract int getAddWidth(DataType type);
}
