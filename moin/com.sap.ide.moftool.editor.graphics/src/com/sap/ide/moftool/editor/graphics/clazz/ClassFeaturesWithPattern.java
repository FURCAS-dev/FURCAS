package com.sap.ide.moftool.editor.graphics.clazz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.commands.CreateClassCommand;
import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.ide.moftool.editor.graphics.IImageConstants;
import com.sap.ide.moftool.editor.graphics.clazz.mapping.ClassBehavioralFeatureStructureMapping;
import com.sap.ide.moftool.editor.graphics.clazz.mapping.ClassDataMapping;
import com.sap.ide.moftool.editor.graphics.clazz.mapping.ClassStructuralFeaturesStructureMapping;
import com.sap.ide.moftool.editor.graphics.clazz.mapping.ClassStructureMapping;
import com.sap.ide.moftool.editor.graphics.diagram.ForcedUpdateContext;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.ide.moftool.editor.graphics.pattern.IMofCompartmentPatternConfiguration;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.AnchorUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.ClassUtil;
import com.sap.ide.moftool.editor.graphics.serviceLayer.clazz.DiagramUtil;
import com.sap.mi.gfw.features.IReason;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.ICreateContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.context.impl.AddConnectionContext;
import com.sap.mi.gfw.features.impl.Reason;
import com.sap.mi.gfw.mapping.IStructureMapping;
import com.sap.mi.gfw.mapping.IStructureMappingMulti;
import com.sap.mi.gfw.mapping.IStructureMappingSingle;
import com.sap.mi.gfw.mapping.data.IDataMapping;
import com.sap.mi.gfw.mapping.data.ITextDataMapping;
import com.sap.mi.gfw.mm.links.PictogramLink;
import com.sap.mi.gfw.mm.pictograms.Anchor;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.ChopboxAnchor;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.mm.pictograms.Style;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.tc.moin.repository.Connection;

public class ClassFeaturesWithPattern extends AbstractMofCompartmentPattern {

    public static final String FEATURE_NAME = Messages.ClassFeaturesWithPattern_0_xbut;

	public ClassFeaturesWithPattern() {
        super();
        initConfiguration();
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	if (!super.canAdd(context)) {
    		return false;
    	}
        HashMap<MofClass, ContainerShape> allClassesFromDiagram = getAllMofClassesFromDiagram();
        MofClass newAddedClass = (MofClass)context.getNewObject();
        // returns true, if user wants to add a MOF class to a diagram
        if (!allClassesFromDiagram.containsKey(newAddedClass)
            && (context.getTargetContainer() instanceof Diagram)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean canCreate(ICreateContext context) {
        boolean ret = false;
        ContainerShape targetContainer = context.getTargetContainer();
        if (targetContainer instanceof Diagram) {
            if (getBusinessObjectForPictogramElement(targetContainer) != null){
                ret=true;
            }
        } 
        return ret;
    }

    @Override
    public Object[] create(ICreateContext context) {

        MofPackage mPackage = null;
        Object businessObject = getBusinessObjectForPictogramElement(context.getTargetContainer());
        // retrieve Mof Package
        if(businessObject instanceof MofPackage){
             mPackage  = (MofPackage) businessObject;
        }
       Connection connection =  getFeatureProvider().getConnection();
       // Create the new class
        CreateClassCommand command = new CreateClassCommand(NamespaceService.getValidNameForNewSubobject(mPackage,Messages.ClassFeaturesWithPattern_1_xbut), mPackage, connection);
        command.execute();
       
        // add the graphical representation
        addGraphicalRepresentation(context, command.getMofClass());

        PeUtil.createChopboxAnchor(context.getTargetContainer());

        activateHeaderTextAutoDirectEditing();

        // return newly created business object(s)
        return new Object[] { command.getMofClass()};
    }

    @Override
    public String getCreateDescription() {
        return Messages.ClassFeaturesWithPattern_2_xmsg;
    }

    @Override
    public String getCreateName() {
        return FEATURE_NAME;
    }

    @Override
    protected IStructureMappingMulti[] createCompartmentMappings() {
        return new IStructureMappingMulti[] {
        		new ClassStructuralFeaturesStructureMapping(getMappingProvider()),
        		new ClassBehavioralFeatureStructureMapping(getMappingProvider()) };
    }

    @Override
    protected IStructureMappingSingle createHeaderMapping() {
        return new ClassStructureMapping(getMappingProvider());
    }

    @Override
    public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
        return mainBusinessObject instanceof MofClass;
    }

    @Override
    public String getCreateImageId() {
        return IImageConstants.IMG_CLASS;
    }

	@Override
	public PictogramElement add(IAddContext context) {
		
		PictogramElement pe = super.add(context);
		ContainerShape cs = (ContainerShape) pe;

		Object ref = getBusinessObjectForPictogramElement(pe);
		if (ref instanceof MofClass) {      
			MofClass newAddedMofClass = (MofClass) ref;
			int newWidth = ClassUtil.calculateASuitableWidth(newAddedMofClass);
			if(newWidth != 0){
				// find a suitable Width for Class Shape
				cs.getGraphicsAlgorithm().setWidth(newWidth);
			}
			// Update the class pictogram elements
			updatePictogramElement(cs);
			// Update association relations to other classes also on the diagram
			updateAssociations(cs);
		}
		return cs;
	}

    private void updateAssociations(ContainerShape containerShape) {
        Object object = getBusinessObjectForPictogramElement(containerShape);
        if (object instanceof MofClass) {
            MofClass newAddedMofClass = (MofClass) object;
            HashMap<MofClass, ContainerShape> allClassesFromDiagram = getAllMofClassesFromDiagram();
            ChopboxAnchor sourceAnchor = AnchorUtil.getChopboxAnchor(containerShape.getAnchors());

            for (Iterator<MofClass> iter = allClassesFromDiagram.keySet().iterator(); iter.hasNext();) {
                MofClass existMofClass = iter.next();
                List<Association> associations = ClassUtil.getAssociationsBetween(newAddedMofClass, existMofClass);
                if (associations.size() != 0 ) {
                    ContainerShape existClassContainer = (ContainerShape) allClassesFromDiagram.get(existMofClass);
                    Collection<Anchor> existAnchors = existClassContainer.getAnchors();
                    ChopboxAnchor targetAnchor = AnchorUtil.getChopboxAnchor(existAnchors);
                    for (ListIterator<Association> assocIter = associations.listIterator(); assocIter.hasNext();) {
                        Association association = assocIter.next();
                        if (!DiagramUtil.existAssocitionInDiagram(getDiagram(), association)) {
                            // add the graphical representation
                            AddConnectionContext addContext = new AddConnectionContext(sourceAnchor, targetAnchor);
                            addContext.setNewObject(association);
                            getFeatureProvider().addIfPossible(addContext);
                        }
                    }
                }
            }
        }
    }

    private HashMap<MofClass, ContainerShape> getAllMofClassesFromDiagram() {
        List<Shape> ch = getDiagram().getChildren();
        HashMap<MofClass, ContainerShape> result = new HashMap<MofClass, ContainerShape>();
        for (ListIterator<Shape> iter = ch.listIterator(); iter.hasNext();) {
            PictogramElement pe = iter.next();
            Object object = getBusinessObjectForPictogramElement(pe);
            if (object instanceof MofClass) {
                MofClass mofClass = (MofClass) object;
                result.put(mofClass, (ContainerShape)pe);
            }
        }
        return result;
    }

    private void initConfiguration() {
        IMofCompartmentPatternConfiguration configuration = getConfiguration();
        configuration.setCornerWidth(15);
        configuration.setCornerHeight(15);
        configuration.setMinimumHeight(0);
        configuration.setMinimumWidth(0);
        configuration.setLineWidth(2);
        configuration.setOuterIndentTop(8);
    }

	public boolean update(IUpdateContext context) {

		if (super.update(context)) {
			PictogramElement pe = context.getPictogramElement();
			if (pe instanceof ContainerShape) {
				ContainerShape cs = (ContainerShape)pe;
				// Update the generalization relations of the class along with the class
				// itself, since those relations are considered to be part of the class
				// in contrast to associations which are considered to be separate
				updateGeneralizations(cs);
			}
		}
		return true;
	}
    
	public IReason updateNeeded(IUpdateContext context) {
		if (context instanceof ForcedUpdateContext) {
			return Reason.createTrueReason();
		}
		
		IReason reason = super.updateNeeded(context);
		if (reason.toBoolean()) {
			return reason;
		}

		PictogramElement pe = context.getPictogramElement();
		if (isPatternRoot(pe)) {
			// Check if a generalization has to be added
			ContainerShape currentContainerShape = (ContainerShape)pe;
			MofClass currentClass = (MofClass)getBusinessObjectForPictogramElement(currentContainerShape);

			Generalizes generalizes = MofService.getModelPackage(getConnection()).getGeneralizes();
			Iterator<Shape> children = getDiagram().getChildren().iterator();

			while (children.hasNext()) {
				Shape otherShape = children.next();
				if (!currentContainerShape.equals(otherShape) && otherShape instanceof ContainerShape) {
					Object bo = getBusinessObjectForPictogramElement(otherShape);
					if (bo instanceof MofClass) {
						MofClass otherClass = (MofClass)bo;
						if (generalizes.exists(otherClass, currentClass)) {
							if(canAddConnection(currentContainerShape, otherShape, generalizes)) {
								return Reason.createTrueReason();
							}
						}
					}
				}
			}

			// Check if a generalization has to be removed	        
			Collection<com.sap.mi.gfw.mm.pictograms.Connection> allConnections = getDiagram().getConnections();
			Iterator<com.sap.mi.gfw.mm.pictograms.Connection> connIt = allConnections.iterator();
			while (connIt.hasNext()) {
				com.sap.mi.gfw.mm.pictograms.Connection connection = connIt.next();
				if (PeUtil.getProperty(connection, MOFToolConstants.CON_PROPERTY_GENERALIZATION) != null) {
					Anchor startAnchor = connection.getStart();
					Anchor endAnchor = connection.getEnd();
					if (startAnchor != null && endAnchor != null) {
						AnchorContainer startParent = startAnchor.getParent();
						AnchorContainer endParent = endAnchor.getParent();
						if (startParent != null && endParent != null) {
							if (currentContainerShape.equals(startParent)) {
								RefObject startObject = (RefObject)getBusinessObjectForPictogramElement(startParent);
								RefObject endObject = (RefObject)getBusinessObjectForPictogramElement(endParent);
								if (startObject != null && endObject != null) {
									if (startObject instanceof MofClass && endObject instanceof MofClass) {
										MofClass startClass = (MofClass)startObject;
										MofClass endClass = (MofClass)endObject;
										if (!generalizes.exists(endClass, startClass)) {
											return Reason.createTrueReason();	                                                                                                         
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return Reason.createFalseReason();
	}

    /**
     * Updates the generalization connections for the given MOF class container shape using a loop
     * over all direct children of the diagram
     * @param currentContainerShape
     */
	private void updateGeneralizations(ContainerShape currentContainerShape) {
		MofClass currentClass = (MofClass) getBusinessObjectForPictogramElement(currentContainerShape);
		Generalizes generalizes = MofService.getModelPackage(getConnection()).getGeneralizes();

		// Delete no longer existing generalizations from the diagram
		Collection<com.sap.mi.gfw.mm.pictograms.Connection> allToBeDeletedConnections = new ArrayList<com.sap.mi.gfw.mm.pictograms.Connection>();        
		Collection<com.sap.mi.gfw.mm.pictograms.Connection> allConnections = getDiagram().getConnections();
		Iterator<com.sap.mi.gfw.mm.pictograms.Connection> connIt = allConnections.iterator();
		while (connIt.hasNext()) {
			com.sap.mi.gfw.mm.pictograms.Connection connection = connIt.next();
			if (PeUtil.getProperty(connection, MOFToolConstants.CON_PROPERTY_GENERALIZATION) != null) {
				Anchor startAnchor = connection.getStart();
				Anchor endAnchor = connection.getEnd();
				if (startAnchor != null && endAnchor != null) {
					AnchorContainer startParent = startAnchor.getParent();
					AnchorContainer endParent = endAnchor.getParent();
					if (startParent != null && endParent != null) {
						if (currentContainerShape.equals(startParent)) {
							RefObject startObject = (RefObject)getBusinessObjectForPictogramElement(startParent);
							RefObject endObject = (RefObject)getBusinessObjectForPictogramElement(endParent);
							if (startObject != null && endObject != null) {
								if (startObject instanceof MofClass && endObject instanceof MofClass) {
									MofClass startClass = (MofClass)startObject;
									MofClass endClass = (MofClass)endObject;
									if (!generalizes.exists(endClass, startClass)) {
										allToBeDeletedConnections.add(connection);                                                                      
									}
								}
							}
							else {
								// One of the classes is NULL -> seems to be invalid
								allToBeDeletedConnections.add(connection);
							}
						}
					}
				}
			}
		}
		// remove connection from editor
		removeGeneralizationConnections(allToBeDeletedConnections);

		// Update existing generalizations and add new ones
		Iterator<Shape> children = getDiagram().getChildren().iterator();
		while (children.hasNext()) {
			Shape otherShape = children.next();
			if (!currentContainerShape.equals(otherShape) && otherShape instanceof ContainerShape) {
				Object bo = getBusinessObjectForPictogramElement(otherShape);
				if (bo instanceof MofClass) {
					MofClass otherClass = (MofClass)bo;
					if (generalizes.exists(otherClass, currentClass)) {
						updateConnection(currentContainerShape, otherShape, generalizes);
					}
					if (generalizes.exists(currentClass, otherClass)) {
						updateConnection(otherShape, currentContainerShape, generalizes);
					}
				}
			}
		}
	}

    private void updateConnection(AnchorContainer from, AnchorContainer to, Object businessObject) {
        Anchor fromAnchor = AnchorUtil.getChopboxAnchor(from.getAnchors());
        Anchor toAnchor = AnchorUtil.getChopboxAnchor(to.getAnchors());

        AddConnectionContext addConnectionContext = new AddConnectionContext(fromAnchor, toAnchor);
        addConnectionContext.setNewObject(businessObject);
        getFeatureProvider().addIfPossible(addConnectionContext);
    }
    
    private boolean canAddConnection(AnchorContainer from, AnchorContainer to, Object businessObject) {
        Anchor fromAnchor = AnchorUtil.getChopboxAnchor(from.getAnchors());
        Anchor toAnchor = AnchorUtil.getChopboxAnchor(to.getAnchors());

        AddConnectionContext addConnectionContext = new AddConnectionContext(fromAnchor, toAnchor);
        addConnectionContext.setNewObject(businessObject);
        return getFeatureProvider().canAdd(addConnectionContext).toBoolean();    	
    }

    @Override
    protected String getPackageName(IStructureMapping structureMapping, PictogramLink linkForPictogramElement) {
        {
            String ret = null;
            IDataMapping dm = structureMapping.getDataMapping();
            List<RefObject> refobjs = linkForPictogramElement.getBusinessObjects();            
            if (dm instanceof ITextDataMapping && refobjs.get(0) instanceof MofClass) {
                ret = ((ClassDataMapping)dm).getContainerName(linkForPictogramElement);
            }
            return ret;
        }
    }
    
    /**
     * Removes the given collection of generalization connections
     * @param connections
     */
	private void removeGeneralizationConnections(Collection<com.sap.mi.gfw.mm.pictograms.Connection> connections) {
		for (Iterator<com.sap.mi.gfw.mm.pictograms.Connection> iter = connections.iterator(); iter.hasNext();) {
			com.sap.mi.gfw.mm.pictograms.Connection connection = iter.next();
			// We cannot use the remove feature here because there is no such feature
			// for generalization connections. This is disabled in feature provider to hide the
			// remove entry in the context menu of generalizations. Reason: generalizations are
			// updated together with the class.
			PeUtil.deletePictogramElement(connection);
		}
	}

	protected Style getTextStyle(ModelElement element) {
		if (element instanceof Attribute) {
			return StyleService.getAttributeStyle(getDiagram());
		}
		else if (element instanceof Reference) {
			return StyleService.getReferenceStyle(getDiagram());
		}
		else if (element instanceof Operation) {
			return StyleService.getOperationStyle(getDiagram());
		}
		else if (element instanceof MofException) {
			return StyleService.getExceptionStyle(getDiagram());
		}
		return null;
	}

	@Override
	protected Style getCompartmentStyle() {
		return StyleService.getClassStyle(getDiagram());
	}

	@Override
	protected Style getCompartmentSeparatorStyle() {
		return StyleService.getClassSeparatorStyle(getDiagram());
	}
}
