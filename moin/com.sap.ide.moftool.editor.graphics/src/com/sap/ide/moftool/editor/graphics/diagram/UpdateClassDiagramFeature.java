package com.sap.ide.moftool.editor.graphics.diagram;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.CustomContext;
import com.sap.mi.gfw.features.custom.AbstractCustomFeature;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.util.PeUtil;

/**
 * Updates the complete class diagram
 * @author d027044
 */
public class UpdateClassDiagramFeature extends AbstractCustomFeature {

	public UpdateClassDiagramFeature(IFeatureProvider fp) {
		super(fp);
	}

	public String getName() {
		return Messages.UpdateClassDiagramFeature_0_xbut;
	}
	
	@Override
	public boolean isAvailable(IContext context) {
		if (context instanceof CustomContext) {
			CustomContext cc = (CustomContext)context;
			PictogramElement[] elements = cc.getPictogramElements();
			if (elements.length > 0 && elements[0] instanceof Diagram) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	public void execute(ICustomContext context) {
		PictogramElement[] elements = context.getPictogramElements();
		if (elements.length > 0 && elements[0] instanceof Diagram) {
			Diagram diagram = (Diagram)elements[0];
			
			// Update the styles for the diagram
			StyleService.updateExistingStyles(diagram);
			
			// Loop over connections
			Object[] objects = new Object[diagram.getConnections().size()];
			objects = diagram.getConnections().toArray(objects);
			for (int i = 0; i < objects.length; i++) {
				Connection connection = (Connection)objects[i];
				// Generalizations are updated via the classes on the diagram
				if (PeUtil.getProperty(connection, MOFToolConstants.CON_PROPERTY_GENERALIZATION) == null) {
					// Update everything else
					IUpdateContext updateContext = new ForcedUpdateContext(connection);
					getFeatureProvider().updateIfPossible(updateContext);
				}
			}
			
			// Loop over classes and data types
			objects = new Object[diagram.getChildren().size()];
			objects = diagram.getChildren().toArray(objects);
			for (int i = 0; i < objects.length; i++) {
				Object object = objects[i];
				// Update only the container shapes of the compartment pattern
				if (object instanceof ContainerShape) {
					ContainerShape shape = (ContainerShape)object;
					IUpdateContext updateContext = new ForcedUpdateContext(shape);
					getFeatureProvider().updateIfPossible(updateContext);
				}
			}
		}
	}
}
