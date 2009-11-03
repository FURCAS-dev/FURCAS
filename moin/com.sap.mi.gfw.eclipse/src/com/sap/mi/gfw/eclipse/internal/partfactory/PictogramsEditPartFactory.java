package com.sap.mi.gfw.eclipse.internal.partfactory;

import java.util.Map;

import org.eclipse.gef.EditPart;

import com.sap.mi.gfw.eclipse.internal.config.AbstractConfigurationProviderHolder;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.config.IEditPartFactory;
import com.sap.mi.gfw.eclipse.internal.parts.BoxRelativeAnchorEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.ConnectionDecoratorEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.ContainerShapeEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.DiagramEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.FixPointAnchorEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.FreeFormConnectionEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.ManhattanConnectionEditPart;
import com.sap.mi.gfw.eclipse.internal.parts.ShapeEditPart;
import com.sap.mi.gfw.mm.pictograms.BoxRelativeAnchor;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.FixPointAnchor;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.ManhattanConnection;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.T;

/**
 * A concrete implementation of the interface IEditPartFactory, which works on a pictogram model.
 */
public class PictogramsEditPartFactory extends AbstractConfigurationProviderHolder implements IEditPartFactory {

	/**
	 * Creates a new PictogramsEditPartFactory.
	 */
	public PictogramsEditPartFactory(IConfigurationProvider configurationProvider) {
		super(configurationProvider);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart ret = null;
		IConfigurationProvider configurationProvider = getConfigurationProvider();

		Map epRegistry = getConfigurationProvider().getDiagramEditor().getGraphicalViewer().getEditPartRegistry();
		if (epRegistry != null && epRegistry.containsKey(model)) {
			T.racer().warning("PictogramsEditPartFactory.createEditPart()", "edit part for this model already exists"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		if (model instanceof Shape) {
			Shape shape = (Shape) model;
			if (!(shape instanceof Diagram) && !shape.isActive()) {
				// return ret;
				// the following is a temorary fix just to make it fly
				ret = new ShapeEditPart(configurationProvider, shape);
			}
		}
		if (ret == null) {
			if (model instanceof Diagram) {
				ret = new DiagramEditPart(configurationProvider, (Diagram) model);
			} else if (model instanceof ConnectionDecorator) {
				ret = new ConnectionDecoratorEditPart(configurationProvider, (Shape) model);
			} else if (model instanceof ContainerShape) {
				ret = new ContainerShapeEditPart(configurationProvider, (ContainerShape) model);
			} else if (model instanceof Shape) {
				ret = new ShapeEditPart(configurationProvider, (Shape) model);
			} else if (model instanceof ManhattanConnection) {
				ret = new ManhattanConnectionEditPart(configurationProvider, (ManhattanConnection) model);
			} else if (model instanceof FreeFormConnection) {
				ret = new FreeFormConnectionEditPart(configurationProvider, (FreeFormConnection) model);
			} else if (model instanceof FixPointAnchor) {
				ret = new FixPointAnchorEditPart(configurationProvider, (FixPointAnchor) model);
			} else if (model instanceof BoxRelativeAnchor) {
				ret = new BoxRelativeAnchorEditPart(configurationProvider, (BoxRelativeAnchor) model);
			}
		}

		// check whether autoswitch to direct editing has been set
		// if yes: store the affected edit part in the editor for later use in
		// the refresh method
		// if (ret instanceof ShapeEditPart) {
		// IDirectEditingInfo dei =
		// getConfigurationProvider().getDiagramTypeProvider().getFeatureProvider()
		// .getDirectEditingInfo();
		// if (dei.isActive() && model.equals(dei.getMainPictogramElement())) {
		// getConfigurationProvider().getDiagramEditor().setDirectEditingEditPart((ShapeEditPart)
		// ret);
		// }
		// }

		return ret;
	}
}