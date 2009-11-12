package com.sap.ide.moftool.editor.graphics.pattern;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.gfw.features.IMappingProvider;
import com.sap.mi.gfw.mapping.data.TextDataMapping;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.Diagram;

public abstract class AbstractMofDataMapping extends TextDataMapping {

	public AbstractMofDataMapping(IMappingProvider mp) {
		super(mp);
	}

	@Override
	public String getText(PictogramLink link) {
		StringBuffer result = new StringBuffer();      
		Object refObject = getBusinessObject(link);       
		if (refObject instanceof ModelElement) {
			ModelElement element = (ModelElement)refObject;
			result.append(element.getName());
		}
		return result.toString();
	}
	
	public String getContainerName (PictogramLink link) {
		StringBuffer result = new StringBuffer();
		Object refObject = getBusinessObject(link);
		Namespace thisObjectPackage = null;
		if (refObject instanceof ModelElement) {
			ModelElement thisObject = (ModelElement)refObject;
			thisObjectPackage = thisObject.getContainer();

			Diagram diagram = link.getDiagramLink().getDiagram();
			MofPackage diagramPackage = DiagramService.getDiagramPackage(diagram);

			if (diagramPackage == null || !diagramPackage.equals(thisObjectPackage)) {
				// For objects from any other container than the one of the diagram
				// show the container as "from ..." below the name of the object.
				// In case of root diagrams this is always the case.
				result.append("-> "); //$NON-NLS-1$
				result.append(thisObjectPackage.getName());
				
				// For objects from any other project (MOIN container) than the one of
				// the diagram also show the project name behind the container name
				// the container should always differ in this case since the container
				// also belongs to another project.
				String diagramContainer = ModelAdapter.getInstance().getContainer(diagram).getContainerName();
				String objectContainer = ModelAdapter.getInstance().getContainer(thisObject).getContainerName();
				if (diagramContainer != null && !diagramContainer.equals(objectContainer)) {
					result.append(" [" + objectContainer + "]"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
		return result.toString();
	}

}
