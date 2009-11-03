package com.sap.mi.gfw.eclipse.internal.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.features.IAddFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.impl.AddContext;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;

public class AddModelObjectCommand extends AbstractCommand {

	private List<AddContext> contextList; // contains IAddContext

	public AddModelObjectCommand(IConfigurationProvider configurationProvider, ContainerShape parent, ISelection sel, Rectangle rectangle) {
		this(configurationProvider, parent, sel, rectangle, null);
	}

	public AddModelObjectCommand(IConfigurationProvider configurationProvider, ContainerShape parent, ISelection sel, Rectangle rectangle,
			Connection connection) {
		super(configurationProvider);

		IStructuredSelection s = (IStructuredSelection) sel;
		if (s == null) {
			s = StructuredSelection.EMPTY;
		}

		contextList = new ArrayList<AddContext>();

		int x = rectangle.x;
		int y = rectangle.y;

		for (Iterator iter = s.iterator(); iter.hasNext();) {
			Object next = iter.next();

			if (next instanceof IAdaptable) {
				IAdaptable adaptable = (IAdaptable) next;
				Object adapter = adaptable.getAdapter(RefObject.class);
				if (adapter instanceof RefObject) {
					next = adapter;
				}
			}
			AddContext ctx = new AddContext();
			ctx.setNewObject(next);
			ctx.setTargetContainer(parent);
			ctx.setLocation(x, y);
			ctx.setTargetConnection(connection);
			contextList.add(ctx);

			x += 10;
			y += 10;
		}
	}

	@Override
	public boolean canExecute() {
		IFeatureProvider featureProvider = getFeatureProvider();

		if (featureProvider != null && contextList.size() > 0) {
			// try to find an add-feature for each object in the selection
			for (Iterator<AddContext> iter = contextList.iterator(); iter.hasNext();) {
				IAddContext ctx = iter.next();
				IAddFeature f = featureProvider.getAddFeature(ctx);
				if (f == null) {
					return false;
				} else {
					boolean canAdd = f.canAdd(ctx);
					if (canAdd == true) {
						return true;
					}
				}
			}
			// return false;
		}

		return false;
	}

	@Override
	public void execute() {
		for (Iterator<AddContext> iter = contextList.iterator(); iter.hasNext();) {
			IAddContext ctx = iter.next();
			getFeatureProvider().addIfPossible(ctx);
		}
	}

	@Override
	public boolean canUndo() {
		return false;
	}
}