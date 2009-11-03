package com.sap.mi.gfw.eclipse.internal.policy;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;

import com.sap.mi.gfw.command.MoveShapeFeatureCommandWithContext;
import com.sap.mi.gfw.eclipse.internal.command.GefCommandWrapper;
import com.sap.mi.gfw.eclipse.internal.config.ConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Shape;

public class ShapeContainerAndXYLayoutEditPolicy extends ShapeXYLayoutEditPolicy {

	protected ShapeContainerAndXYLayoutEditPolicy(IConfigurationProvider configurationProvider) {
		super(configurationProvider);
	}

	@Override
	protected Command createAddCommand(EditPart child, Object constraint) {

		if (child.getModel() instanceof ConnectionDecorator) {
			return super.createAddCommand(child, constraint);
		}

		Command result = null;

		Object hostModel = getHost().getModel();
		if (hostModel instanceof ContainerShape) {
			ContainerShape containerShape = (ContainerShape) hostModel;

			Object model = child.getModel();
			if (model instanceof Shape) {
				Shape shape = (Shape) model;
				IConfigurationProvider configurationProvider = getConfigurationProvider();
				if (configurationProvider instanceof ConfigurationProvider) {
					ConfigurationProvider jmiConfigProv = (ConfigurationProvider) configurationProvider;
					ContainerShape oldContainer = shape.getContainer();
					IMoveShapeContext context = createMoveShapeContext(shape, oldContainer, containerShape, constraint);
					IFeatureProvider featureProvider = jmiConfigProv.getDiagramTypeProvider().getFeatureProvider();
					IMoveShapeFeature layoutShapeFeature = featureProvider.getMoveShapeFeature(context);
					if (layoutShapeFeature != null) {
						result = new GefCommandWrapper(new MoveShapeFeatureCommandWithContext(layoutShapeFeature, context), featureProvider
								.getConnection());
					}
				}
			}
		}
		return result;
	}
}