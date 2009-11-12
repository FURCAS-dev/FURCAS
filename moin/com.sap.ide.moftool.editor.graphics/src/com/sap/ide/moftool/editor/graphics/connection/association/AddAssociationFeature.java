package com.sap.ide.moftool.editor.graphics.connection.association;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.graphics.clazz.autolayout.MofGraphTransformation;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationEndMultiplicityFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationEndNameFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationNameFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IAddConnectionContext;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.jam.AbstractAddShapeFeature;
import com.sap.mi.gfw.mm.datatypes.Point;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.FreeFormConnection;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Text;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PeUtil;

public class AddAssociationFeature extends AbstractAddShapeFeature {

    public AddAssociationFeature(IFeatureProvider fp) {
        super(fp);
    }

	public PictogramElement add(IAddContext context) {

		IAddConnectionContext addConnectionContext = (IAddConnectionContext)context;
		Association association = (Association)addConnectionContext.getNewObject();

		Anchor sourceAnchor = addConnectionContext.getSourceAnchor();
		Anchor targetAnchor = addConnectionContext.getTargetAnchor();
		
		// <pg161007> get existing direct connection and get list of existing (single) bend points	
		FreeFormConnection directFreeformConnection = null;
		List<Point> bendpoints = new ArrayList<Point>();		
		
		Collection<Connection> outcons = sourceAnchor.getOutgoingConnections();	
		Iterator<Connection> it = outcons.iterator();
		Connection outcon = null;
		while (it.hasNext()) {
			outcon = it.next();
			if (targetAnchor != null && targetAnchor.equals(outcon.getEnd())) {
				if (outcon instanceof FreeFormConnection) {
					int numberOfBendpoints = ((FreeFormConnection)outcon).getBendpoints().size();
					if (numberOfBendpoints == 0 ) {						
						directFreeformConnection = (FreeFormConnection)outcon;
					} else if (numberOfBendpoints == 1) {
						bendpoints.add(((FreeFormConnection)outcon).getBendpoints().get(0));
					}
				}		
				
			}
		}
		Collection<Connection> incons = sourceAnchor.getIncomingConnections();	
		Iterator<Connection> it1 = incons.iterator();
		Connection incon = null;
		while (it1.hasNext()) {
			incon = it1.next();
			if (targetAnchor != null && targetAnchor.equals(incon.getStart())) {
				if (incon instanceof FreeFormConnection) {
					int numberOfBendpoints = ((FreeFormConnection)incon).getBendpoints().size();
					if (numberOfBendpoints == 0 ) {						
						directFreeformConnection = (FreeFormConnection)incon;
					} else if (numberOfBendpoints == 1) {
						bendpoints.add(((FreeFormConnection)incon).getBendpoints().get(0));
					}
				}		
				
			}
		}
		// </pg161007>

		MofClass sourceClass = (MofClass)getBusinessObjectForPictogramElement(sourceAnchor.getParent());
		MofClass targetClass = (MofClass)getBusinessObjectForPictogramElement(targetAnchor.getParent());

		// get association Ends
		AssociationEnd[] assocEnds = AssociationService.getAssociationEnds(association);

		FreeFormConnection newConnection = null;
		if (assocEnds != null && assocEnds.length == 2) {
			AssociationEnd end1 = assocEnds[0];
			AssociationEnd end2 = assocEnds[1];
			newConnection = PeUtil.createFreeFormConnection(getDiagram());
			if (sourceClass.equals(end1.getType()) && targetClass.equals(end2.getType())) {
				newConnection.setStart(sourceAnchor);
				newConnection.setEnd(targetAnchor);
			}
			else if (targetClass.equals(end1.getType()) && sourceClass.equals(end2.getType())) {
				newConnection.setStart(targetAnchor);
				newConnection.setEnd(sourceAnchor);
			} 
			
			// <pg161007> add bend point to avoid overlay if a direct connection already exists
			if (directFreeformConnection != null) {
				addBendpoint(newConnection, sourceAnchor, targetAnchor, bendpoints);
			}


			if (newConnection != null) {
				// Initially the decorators shall be shown; therefore set the visibility property
				// to "yes" to indicate that the decorators should be displayed
				String property = MOFToolConstants.VALUE_YES;
				PeUtil.setPropertyValue(newConnection, MOFToolConstants.PROPERTY_DECORATORS_VISIBLE, property);

				// Link new connection with association
				link(newConnection, association);

				// Use the update feature to actually draw the connection and its decorators
				updatePictogramElement(newConnection); 
				
				// <pg211108> perform decorator layout independently of update
				MofGraphTransformation.performLayoutConnectionDecorators(newConnection); 				

			}
		}
		return newConnection;
	}

    public boolean canAdd(IAddContext context) {
        if (context instanceof IAddConnectionContext && context.getNewObject() instanceof Association) {
            return true;
        }
        return false;
    }
    
    private void addBendpoint(FreeFormConnection connection, Anchor sourceAnchor, Anchor targetAnchor, List<Point> bendpoints) {
		int xs = sourceAnchor.getParent().getGraphicsAlgorithm().getX();
		int ws = sourceAnchor.getParent().getGraphicsAlgorithm().getWidth();
		xs = xs + ws/2;
		int ys = sourceAnchor.getParent().getGraphicsAlgorithm().getY();
		int hs = sourceAnchor.getParent().getGraphicsAlgorithm().getHeight();
		ys = ys + hs/2;
		int xt = targetAnchor.getParent().getGraphicsAlgorithm().getX();
		int wt = targetAnchor.getParent().getGraphicsAlgorithm().getWidth();
		xt = xt + wt/2;
		int yt = targetAnchor.getParent().getGraphicsAlgorithm().getY();
		int ht = targetAnchor.getParent().getGraphicsAlgorithm().getHeight();
		yt = yt + ht/2;
		int xd = (xt-xs)/20; 
		int yd = (yt-ys)/20;
		int xb = (xt+xs)/2;
		int yb = (yt+ys)/2;
		Point newBendpoint = null;
		delta:
		for (int i = 0; i < 30; i++) {
			xb = xb + yd;
			yb = yb - xd;
			Iterator<Point> iter = bendpoints.iterator();
			while (iter.hasNext()) {
				Point point = (Point)iter.next();
				int dx = point.getX()- xb;
				int dy = point.getY()- yb;
				if ((dx*dx + dy*dy) < 400) {							
					continue delta;
				}
			}					
			break delta;
		} 
		newBendpoint = GaUtil.createPoint(connection, xb, yb);
		connection.getBendpoints().add(newBendpoint);
    }
}
