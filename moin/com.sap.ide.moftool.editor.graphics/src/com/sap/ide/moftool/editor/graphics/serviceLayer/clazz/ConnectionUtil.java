package com.sap.ide.moftool.editor.graphics.serviceLayer.clazz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.ide.moftool.editor.core.commands.AddSuperclassCommand;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.ClassService;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.Polygon;
import com.sap.mi.gfw.mm.pictograms.Polyline;
import com.sap.mi.gfw.util.GaUtil;
import com.sap.mi.gfw.util.PeUtil;

public class ConnectionUtil {

	public static Generalizes createGeneralization(com.sap.tc.moin.repository.Connection connection, MofClass source,
			MofClass target) {
		AddSuperclassCommand command = new AddSuperclassCommand(source, target, connection);
		command.execute();
		return command.getGeneralizes();
	}

	public static Connection createGeneralizationConnection(Diagram diagram, Anchor sourceAnchor, Anchor targetAnchor) {
		// Connection line
		Connection connection = PeUtil.createFreeFormConnection(diagram);
		Polyline line = GaUtil.createPolyline(connection);
		GaUtil.ignoreAll(line);
		line.setStyle(StyleService.getGeneralizationStyle(diagram));

		// Arrow at the end
		ConnectionDecorator cd = PeUtil.createConnectionDecorator(connection, false, 1.0, true);
		Polygon arrow = GaUtil.createPolygon(cd, new int[] { 0, 0, -9, -9, -9, 9 });
		GaUtil.ignoreAll(arrow);
		arrow.setStyle(StyleService.getConnectionArrowStyle(diagram));
		cd.setGraphicsAlgorithm(arrow);

		// Set start and end point
		connection.setStart(sourceAnchor);
		connection.setEnd(targetAnchor);

		return connection;
	}

	public static Boolean existDirectGeneralize(com.sap.tc.moin.repository.Connection connection, MofClass source,
			MofClass target) {
		Boolean ret = false;
		ModelPackage modelPackage = MofService.getModelPackage(connection);
		Generalizes generalizes = modelPackage.getGeneralizes();
		ret = generalizes.exists(target, source);
		return ret;
	}

	// TODO: check correctness
	/**
	 * @deprecated
	 */		
	public static Boolean existGeneralize(com.sap.tc.moin.repository.Connection connection, MofClass source,
			MofClass target) {
		
		Collection<GeneralizableElement> targetSuperClasses = target.allSupertypes();

		for (Iterator<GeneralizableElement> iter = targetSuperClasses.iterator(); iter.hasNext();) {
			MofClass mofClass = (MofClass) iter.next();
			if (existGeneralize(connection, source, mofClass)) {
				return true;
			}
		}
		return false;
	}

	public static void deleteGeneralize(com.sap.tc.moin.repository.Connection connection, MofClass source,
			MofClass target) {
		ModelPackage modelPackage = MofService.getModelPackage(connection);
		Generalizes generalizes = modelPackage.getGeneralizes();
		generalizes.remove(target, source);

	}

	public static boolean existAssociationName(String value, Association association) {
		AssociationEnd[] assocEnds = AssociationService.getAssociationEnds(association);
		MofClass mofClass1 = (MofClass) assocEnds[0].getType();
		MofClass mofClass2 = (MofClass) assocEnds[1].getType();

		List<Association> allAssociations = new ArrayList<Association>();

		allAssociations.addAll(ClassService.getAllAssociations(mofClass1));
		allAssociations.addAll(ClassService.getAllAssociations(mofClass2));

		for (Iterator<Association> iter = allAssociations.iterator(); iter.hasNext();) {
			Association assoc = iter.next();
			if (assoc.getName().equals(value) && !association.getName().equals(value)) {
				return true;
			}
		}

		return false;
	}

	public static Connection createInnerTypeConnection(Diagram diagram, Anchor sourceAnchor, Anchor targetAnchor) {
		// Connection
		Connection connection = PeUtil.createFreeFormConnection(diagram);
		Polyline p = GaUtil.createPolyline(connection);
		GaUtil.ignoreAll(p);
		p.setStyle(StyleService.getDataTypeContainmentStyle(diagram));

		// Connection decorator
		ConnectionDecorator cd = PeUtil.createConnectionDecorator(connection, false, 1.0, true);
		// TODO replace with eclipse connection decorator
		// Ellipse p1 = GaUtil.createEllipse(cd);
		Polygon p1 = GaUtil.createPolygon(cd, new int[] { -6, -4, -6, 4, 0, 4, 0, -4 });
		GaUtil.ignoreAll(p1);
		p1.setStyle(StyleService.getConnectionEllipseStyle(diagram));
		cd.setGraphicsAlgorithm(p1);

		// Set start and end point
		connection.setStart(sourceAnchor);
		connection.setEnd(targetAnchor);

		return connection;

	}
}
