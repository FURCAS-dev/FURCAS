package com.sap.ide.moftool.editor.graphics.connection.association.decorations;

import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ConnectionDecoratorUtil;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.internal.GaUtilInternal;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.Text;

public class UpdateAssociationEndMultiplicityFeature extends UpdateTextDecoratorFeature {

	public UpdateAssociationEndMultiplicityFeature(IFeatureProvider fp) {
		super(fp);
	}
	
	@Override
	protected String getLinkPropertyValue() {
		return MOFToolConstants.MULTIPLICITY;
	}

	@Override
	protected String getText(ModelElement element) {
		AssociationEnd associationEnd = (AssociationEnd)element;
		MultiplicityType mult = associationEnd.getMultiplicity();
		String multAsString = ConnectionDecoratorUtil.getMultiplicityAsText(mult);
		return multAsString;
	}

	public static int calculateOffsetX(ConnectionDecorator decorator, Text text) {
		int offsetX = 5;
		int textLength = text.getValue().length();
		// <pg121107> consider line segment from start point to first bend point
		// or from last bend point to end point
		int startX = 0;
		int endX = 0;
		Connection conn = decorator.getConnection();
		Point startPoint = null;
		Point endPoint = null;
		if (conn instanceof FreeFormConnection) {
			Iterator<Point> it = ((FreeFormConnection)conn).getBendpoints().iterator();
			while (it.hasNext()) {
				Point point = it.next();
				if (startPoint == null) {
					startPoint = point;
				}
				endPoint = point;
			}
		}
		if (decorator.getConnection().getStart() == null || decorator.getConnection().getEnd() == null) {
			return offsetX;
		}
		if (decorator.getLocation() > 0.5) {
			// end decorator
			if (endPoint != null) {
				startX = endPoint.getX();
			} else {
				startX = decorator.getConnection().getStart().getParent().getGraphicsAlgorithm().getX();
			}
			endX = decorator.getConnection().getEnd().getParent().getGraphicsAlgorithm().getX();
		} else {
			// start decorator
			if (startPoint != null) {
				endX = startPoint.getX();
			} else {
				endX = decorator.getConnection().getEnd().getParent().getGraphicsAlgorithm().getX();
			}
			startX = decorator.getConnection().getStart().getParent().getGraphicsAlgorithm().getX();
		}
		// calculate offsets for label
		if (startX < endX) {
			// Normal orientation (left to right)
			if (decorator.getLocation() > 0.5) {
				// This is the right end
				// TODO use real length of text field
				offsetX = 0 - (GaUtilInternal.getFont(text, true).getSize() * textLength);
			}
		}
		else {
			// Inverse orientation (right to left)
			if (decorator.getLocation() < 0.5) {
				// This is the right end
				// TODO use real length of text field
				offsetX = 0 - (GaUtilInternal.getFont(text, true).getSize() * textLength);
			}
			
		}
		return offsetX;
	}

	public static int calculateOffsetY(ConnectionDecorator decorator, Text text) {
		int offsetY = 20;		
		// <pg121107> consider line segment from start point to first bend point
		// or from last bend point to end point
		int startY = 0;
		int endY = 0;
		Connection conn = decorator.getConnection();
		Point startPoint = null;
		Point endPoint = null;
		if (conn instanceof FreeFormConnection) {
			Iterator<Point> it = ((FreeFormConnection)conn).getBendpoints().iterator();
			while (it.hasNext()) {
				Point point = it.next();
				if (startPoint == null) {
					startPoint = point;
				}
				endPoint = point;
			}
		}
		if (decorator.getConnection().getStart() == null || decorator.getConnection().getEnd() == null) {
			return offsetY;
		}
		if (decorator.getLocation() > 0.5) {
			// end decorator
			if (endPoint != null) {
				startY = endPoint.getY();
			} else {
				startY = decorator.getConnection().getStart().getParent().getGraphicsAlgorithm().getY();
			}
			endY = decorator.getConnection().getEnd().getParent().getGraphicsAlgorithm().getY();
		} else {
			// start decorator
			if (startPoint != null) {
				endY = startPoint.getY();
			} else {
				endY = decorator.getConnection().getEnd().getParent().getGraphicsAlgorithm().getY();
			}
			startY = decorator.getConnection().getStart().getParent().getGraphicsAlgorithm().getY();
		}
		// calculate offsets for label
		if (startY < endY) {
			// Normal orientation (top to bottom)
			if (decorator.getLocation() > 0.5) {
				// This is the bottom end
				// TODO use real height of text field
				offsetY = 0 - (GaUtilInternal.getFont(text, true).getSize() * 4);
			}
		}
		else {
			// Inverse orientation (bottom to top)
			if (decorator.getLocation() < 0.5) {
				// This is the bottom end
				// TODO use real height of text field
				offsetY = 0 - (GaUtilInternal.getFont(text, true).getSize() * 4);
			}
			
		}
		return offsetY;
	}
}
