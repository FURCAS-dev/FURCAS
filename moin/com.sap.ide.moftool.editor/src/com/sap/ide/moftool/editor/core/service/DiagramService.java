package com.sap.ide.moftool.editor.core.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mql.MQLResultSet;

public abstract class DiagramService {

	/**
	 * Returns the associated package for a given diagram or null if no package
	 * is associated.
	 * @param diagram
	 * @return
	 */
	public static MofPackage getDiagramPackage(Diagram diagram) {
		return (MofPackage)LinkUtil.getBusinessObjectForLinkedPictogramElement(diagram);
	}

	/**
	 * Checks if a given <code>ModelElement</code> is represented on a given diagram
	 * @param diagram The diagram that may contain the class
	 * @param modelElement The ModelElement to check if it is contained in the diagram. Supported
	 * object types are the main objects in the diagram: MOF classes, Structure Types and
	 * Enumeration Types.
	 * @return <code>true</code> if the object is contained in the diagram, <code>
	 * false</code> otherwise. For not supported object types <code>false</code> is returned
	 * in any case.
	 */
    public static boolean isContainedInDiagram(Diagram diagram, ModelElement modelElement) {
    	// No valid object given -> cannot be contained on diagram, log error
    	if (!(modelElement instanceof MofClass || modelElement instanceof StructureType ||
    			modelElement instanceof EnumerationType)) {
    		return false;
    	}
    	
    	// Loop over all direct elements on diagram
        List<Shape> ch = diagram.getChildren();
        for (ListIterator<Shape> iter = ch.listIterator(); iter.hasNext();) {
            Shape shape = iter.next();
            RefObject refObject = LinkUtil.getBusinessObjectForLinkedPictogramElement(shape);
            if (refObject instanceof ModelElement) {
                ModelElement existingObject= (ModelElement)refObject;
                if (modelElement.equals(existingObject)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Returns a list of all diagrams in the given project
     * @param project The containing project
     * @return A list of diagrams
     * TODO Why do we pass the project here? Connection would be sufficient 
     * TODO This method has to be called from the UI Thread but this in not specified!
     */
    public static List<Diagram> getAllClassDiagrams(final IProject project) {
		
		Connection connection = MofService.createConnectionWithBusyCursorWhile(project); 
		if (connection == null) {
			return Collections.emptyList();
		}		
		return getAllClassDiagramsWithConnection(connection);
    }
    
    /**
     * Returns a list of all diagrams within the project of the given connection      
     * @param connection The current connection
     * @return A list of diagrams
     */
    public static List<Diagram> getAllClassDiagramsWithConnection(final Connection connection) {
    	String query = "select d from \"sap.com/com/sap/mi/gfw/mm\"#links::PictogramLink as pl, " //$NON-NLS-1$
			+ "\"sap.com/com/sap/mi/gfw/mm\"#pictograms::Diagram as d " //$NON-NLS-1$
			+ "where pl.pictogramElement = d"; //$NON-NLS-1$
		MQLResultSet resultSet = connection.getMQLProcessor().execute(query);
		
		List<Diagram> children = new ArrayList<Diagram>();

		IProject project = ModelAdapter.getInstance().getProject(connection);
		for (int i = 0; i < resultSet.getSize(); i++) {
			RefObject ro = resultSet.getRefObject(i, "d"); //$NON-NLS-1$
			if (ModelAdapter.getInstance().getProject(ro).equals(project)) {
				children.add((Diagram) ro);
			}
		}
		return children;
    }
    
    /**
     * Returns a list of all diagrams for a given package which must not be null      
     * @param pack the package
     * @return A list of diagrams
     */
    public static List<Diagram> getAllClassDiagramsForPackage(final MofPackage pack) {
    	String query = "select d from \"sap.com/com/sap/mi/gfw/mm\"#links::PictogramLink as pl, " //$NON-NLS-1$
    		+ "\"sap.com/com/sap/mi/gfw/mm\"#pictograms::Diagram as d, " //$NON-NLS-1$
    		+ "\"" +((Partitionable) pack).get___Mri() + "\" as me " + "where pl.businessObjects = me " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    		+ "where pl.pictogramElement = d"; //$NON-NLS-1$
    	MQLResultSet resultSet = pack.get___Connection().getMQLProcessor().execute(query);
    	
    	List<Diagram> children = new ArrayList<Diagram>();
    	
    	for (int i = 0; i < resultSet.getSize(); i++) {
    		RefObject ro = resultSet.getRefObject(i, "d"); //$NON-NLS-1$
    		children.add((Diagram) ro);
    	}
    	return children;
    }
    
    
    
    
}