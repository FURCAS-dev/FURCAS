package com.sap.ide.moftool.editor.graphics.connection.association;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.ide.moftool.editor.core.commands.CreateAssociationCommand;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.core.service.ReferenceService;
import com.sap.ide.moftool.editor.graphics.ClassDiagramFeatureProvider;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.ICreateConnectionContext;
import com.sap.mi.gfw.features.context.impl.AddConnectionContext;
import com.sap.mi.gfw.features.jam.AbstractCreateConnectionFeature;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.pattern.IPattern;
import com.sap.mi.gfw.util.PeUtil;

public abstract class CreateAbstractAssociationFeature extends AbstractCreateConnectionFeature{

    public CreateAbstractAssociationFeature(IFeatureProvider fp, String name, String description) {
        super(fp, name, description);
    }

    public boolean canCreate(ICreateConnectionContext context) {
    	
        Anchor sourceAnchor = getAnchor(context.getSourceAnchor(), context.getSourcePictogramElement());
        Anchor targetAnchor = getAnchor(context.getTargetAnchor(), context.getTargetPictogramElement());

        if (sourceAnchor == null || targetAnchor == null) {
            return false;
        }
    	
        MofClass source = getMofClass(sourceAnchor);
        MofClass target = getMofClass(targetAnchor);
        if (source != null && target != null) {
        	// In case both classes are foreign it must not be possible to 
        	// create the association because the storage tag cannot be set 
        	// for any end (one is mandatory) because the following JMI 
        	// generation would need to add a member to the MOF class at the 
        	// storage end which would be a modification to the build result
        	// of the used metamodel
        	if (ModelElementService.isForeignObject(getDiagram(), source) &&
        			ModelElementService.isForeignObject(getDiagram(), target)) {
        		return false;
        	}
        	// Otherwise it's ok 
            return true;
        }
        return false;
    }

    public boolean canStartConnection(ICreateConnectionContext context) {
        Anchor sourceAnchor = getAnchor(context.getSourceAnchor(), context.getSourcePictogramElement());
        if (getMofClass(sourceAnchor) != null) {
            return true;
        }
        return false;
    }

	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;
		MofPackage mPackage = null;

		ContainerShape targetContainer = getDiagram();
		if (targetContainer instanceof Diagram) {
			
	        Anchor sourceAnchor = getAnchor(context.getSourceAnchor(), context.getSourcePictogramElement());
	        Anchor targetAnchor = getAnchor(context.getTargetAnchor(), context.getTargetPictogramElement());

	        if (sourceAnchor == null || targetAnchor == null) {
	            return null;
	        }
			
			// Get mof classes which should be connected
			MofClass source = getMofClass(sourceAnchor);
			MofClass target = getMofClass(targetAnchor);
			if (source != null && target != null) {
				// Get containing package (stored as business object on diagram level)
				Object object = getBusinessObjectForPictogramElement(targetContainer);
				if (object instanceof MofPackage) {
					mPackage = (MofPackage) object;
					
					String mName = AssociationService.createNewAssociationName(source, target);
					mName = NamespaceService.getValidNameForNewSubobject(mPackage, mName);

					// Create business object for the new connection
					MofClass containingClass = ReferenceService.getContainingClassForAssociationEndReference(source);
					CreateAssociationCommand command = new CreateAssociationCommand(mName, mPackage,
							source, target, containingClass, getAssociationType(),
							getFeatureProvider().getConnection());
					command.execute();

					// Use existing add feature for the creation of the graphical representation
					newConnection = addAssociationRepresentation(context, command.getAssociation(), sourceAnchor, targetAnchor);					

				}
			}
		}
		return newConnection;
	}

	private Connection addAssociationRepresentation(ICreateConnectionContext context, Association association, Anchor sourceAnchor, Anchor targetAnchor) {
		Connection newConnection = null;		

        if (sourceAnchor == null || targetAnchor == null) {
            return null;
        }
		
		AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
		addContext.setNewObject(association);
		PictogramElement pe = getFeatureProvider().addIfPossible(addContext);
		if (pe instanceof Connection) {
			newConnection = (Connection)pe;
		}
		
		// Update source class in diagram 
		updatePictogramElement(newConnection.getStart().getParent());
		
		// Update target class in diagram
		updatePictogramElement(newConnection.getEnd().getParent());

		return newConnection;
	}

	abstract protected AggregationKindEnum getAssociationType();

    protected MofClass getMofClass(Anchor anchor) {
        if (anchor != null) {
            Object object = getBusinessObjectForPictogramElement(anchor.getParent());
            if (object instanceof MofClass) {
                return (MofClass)object;
            }
        }
        return null;
    }
    
    private Anchor getAnchor(Anchor anchor, PictogramElement pe) {
        Anchor ret = anchor;
        if (ret == null) {
            // get mof compartment pattern
        	IFeatureProvider featureProvider = getFeatureProvider();
            AbstractMofCompartmentPattern mofPattern = null;
            if ((featureProvider != null) && (featureProvider instanceof ClassDiagramFeatureProvider)) {
                IPattern pattern = ((ClassDiagramFeatureProvider) featureProvider)
                    .getPatternForPictogramElement(pe);
                if ((pattern != null) && (pattern instanceof AbstractMofCompartmentPattern)) {
                    mofPattern = (AbstractMofCompartmentPattern) pattern;
                } else {
                    return null;
                }
            } else {
                return null;
            }
            // get outer shape
            Shape outerShape = mofPattern.getPatternRoot(pe);
            if (outerShape == null) {
                return null;
            } 
            // get anchor
            ret = PeUtil.getChopboxAnchor(outerShape);
            
        }
        return ret;
    }

}
