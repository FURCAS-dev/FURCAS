package com.sap.ide.moftool.editor.graphics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.Generalizes;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.ide.moftool.editor.core.MOFToolConstants;
import com.sap.ide.moftool.editor.core.service.AssociationService;
import com.sap.ide.moftool.editor.core.service.ClassService;
import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.graphics.clazz.ClassNameDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.clazz.CollapseAllClassCustomFeature;
import com.sap.ide.moftool.editor.graphics.clazz.DeleteClassFeature;
import com.sap.ide.moftool.editor.graphics.clazz.ExpandAllClassCustomFeature;
import com.sap.ide.moftool.editor.graphics.clazz.ShowInCommonNavigatorFeature;
import com.sap.ide.moftool.editor.graphics.clazz.attribute.ClassAttributeDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.clazz.attribute.CreateAttributeCustomFeature;
import com.sap.ide.moftool.editor.graphics.clazz.attribute.DeleteAttributeFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AddEnumTypeOfClassFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AddStructureTypeOfClass;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AddSubClassesFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AddSuperClassesFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.CreateInnerEnumTypeFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.CreateInnerStructureTypeFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.CreateSubClassFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.CreateSuperClassFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autolayout.DefaultClassAutoLayoutCustomFeature;
import com.sap.ide.moftool.editor.graphics.clazz.operation.ClassOperationDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.clazz.operation.CreateOperationCustomFeature;
import com.sap.ide.moftool.editor.graphics.clazz.operation.DeleteOperationFeature;
import com.sap.ide.moftool.editor.graphics.clazz.reference.CreateReferenceFeature;
import com.sap.ide.moftool.editor.graphics.clazz.reference.DeleteReferenceFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.AddAllAssociationCustomFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.AddAssociationFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.ChangeDecoratorsVisibility;
import com.sap.ide.moftool.editor.graphics.connection.association.CreateAssociationFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.CreateCompositionFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.DeleteAssociationFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.GenericAddAssociationCustomFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.HideAllDecoratorsFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.ShowAllDecoratorsFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.ToggleStorageFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.UpdateAssociationFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.AssociationEndMultiplicityDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.AssociationEndNameDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.AssociationNameDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationEndMultiplicityFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationEndNameFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationNameFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.decorations.UpdateAssociationEndCombinedDecoratorFeature;
import com.sap.ide.moftool.editor.graphics.connection.datatype.AddDataTypeConnectionFeature;
import com.sap.ide.moftool.editor.graphics.connection.generalization.AddGeneralizationFeature;
import com.sap.ide.moftool.editor.graphics.connection.generalization.CreateGeneralizationFeature;
import com.sap.ide.moftool.editor.graphics.connection.generalization.DeleteGeneralizationFeature;
import com.sap.ide.moftool.editor.graphics.connection.generalization.ReconnectGeneralizationFeature;
import com.sap.ide.moftool.editor.graphics.datatype.DeleteDataTypeFeature;
import com.sap.ide.moftool.editor.graphics.datatype.enumtype.CreateLabelForEnumTypeCustomFeature;
import com.sap.ide.moftool.editor.graphics.datatype.enumtype.DeleteLabelFromEnumTypeFeature;
import com.sap.ide.moftool.editor.graphics.datatype.enumtype.EnumTypeLabelDirecEditingFeature;
import com.sap.ide.moftool.editor.graphics.datatype.enumtype.EnumTypeNameDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.datatype.structuretype.CreateStructureFieldForStructureTypeFeature;
import com.sap.ide.moftool.editor.graphics.datatype.structuretype.DeleteStructureFieldFromStructureTypeFeature;
import com.sap.ide.moftool.editor.graphics.datatype.structuretype.StructureTypeFieldDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.datatype.structuretype.StructureTypeNameDirectEditingFeature;
import com.sap.ide.moftool.editor.graphics.diagram.ShowPropertiesFeature;
import com.sap.ide.moftool.editor.graphics.diagram.UpdateClassDiagramFeature;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.ide.moftool.editor.graphics.pattern.compartment.CollapseCompartmentsCustomFeature;
import com.sap.ide.moftool.editor.graphics.pattern.compartment.ExpandCompartmentsCustomFeature;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.IAddFeature;
import com.sap.mi.gfw.features.ICreateConnectionFeature;
import com.sap.mi.gfw.features.IDeleteFeature;
import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.features.ILayoutFeature;
import com.sap.mi.gfw.features.IMoveShapeFeature;
import com.sap.mi.gfw.features.IReconnectionFeature;
import com.sap.mi.gfw.features.IRemoveFeature;
import com.sap.mi.gfw.features.IResizeShapeFeature;
import com.sap.mi.gfw.features.IUpdateFeature;
import com.sap.mi.gfw.features.context.IAddContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IDeleteContext;
import com.sap.mi.gfw.features.context.IDirectEditingContext;
import com.sap.mi.gfw.features.context.ILayoutContext;
import com.sap.mi.gfw.features.context.IMoveShapeContext;
import com.sap.mi.gfw.features.context.IReconnectionContext;
import com.sap.mi.gfw.features.context.IRemoveContext;
import com.sap.mi.gfw.features.context.IResizeShapeContext;
import com.sap.mi.gfw.features.context.IUpdateContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.mm.pictograms.AnchorContainer;
import com.sap.mi.gfw.mm.pictograms.Connection;
import com.sap.mi.gfw.mm.pictograms.ConnectionDecorator;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.GraphicsAlgorithm;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Property;
import com.sap.mi.gfw.mm.pictograms.Text;
import com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns;
import com.sap.mi.gfw.pattern.IPattern;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class ClassDiagramFeatureProvider extends DefaultJamFeatureProviderWithPatterns {

	public ClassDiagramFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	// <innerSelection> override: works for all pe, not only for the outer ones 
	@Override
	public IPattern getPatternForPictogramElement(PictogramElement pe) {
		for (IPattern pattern : getPatterns()) {
			if (pattern instanceof AbstractMofCompartmentPattern) {
				AbstractMofCompartmentPattern ap = (AbstractMofCompartmentPattern) pattern;
				if (ap.isPatternControlled(pe))
					return pattern;
			}
		}
		return super.getPatternForPictogramElement(pe);
	}


	@Override
	protected IAddFeature getAddFeatureAdditional(IAddContext context) {
		if (context.getNewObject() instanceof Association) {
			return new AddAssociationFeature(this);
		} else if(context.getNewObject() instanceof Generalizes){
			return new AddGeneralizationFeature(this);
		} else if(context.getNewObject() == null){
			// TODO: why is the object in the context empty for DataTypes ?
			return new AddDataTypeConnectionFeature(this);
		}

		return super.getAddFeatureAdditional(context);
	}

	@Override
	protected IUpdateFeature getUpdateFeatureAdditional(IUpdateContext context) {

		IUpdateFeature ret = null;
		PictogramElement pe = context.getPictogramElement();
		Object businessObject = getBusinessObjectForPictogramElement(pe);

		// special solution for diagrams
		if (ret == null && pe instanceof Diagram) {
			return super.getUpdateFeatureAdditional(context);
		}
		if (businessObject instanceof Association) {
			if (pe instanceof Connection) {
				return new UpdateAssociationFeature(this);
			} else if (pe instanceof ConnectionDecorator
					&& LinkUtil.hasLinkProperty(pe, MOFToolConstants.ASSOCIATION_NAME)) {
				return new UpdateAssociationNameFeature(this);
			}
		}
		else if (businessObject instanceof AssociationEnd) {
			if (pe instanceof ConnectionDecorator
					&& LinkUtil.hasLinkProperty(pe, MOFToolConstants.ASSOCIATION_END_NAME)) {
				return new UpdateAssociationEndNameFeature(this);
			}
			else if (pe instanceof ConnectionDecorator
					&& LinkUtil.hasLinkProperty(pe, MOFToolConstants.MULTIPLICITY)) {
				return new UpdateAssociationEndMultiplicityFeature(this);
			}
			else if(pe instanceof ConnectionDecorator
					&& LinkUtil.hasLinkProperty(pe, MOFToolConstants.NAVIGABLE)) {
				return new UpdateAssociationEndCombinedDecoratorFeature(this);
			}
		}
		return super.getUpdateFeatureAdditional(context);
	}

	@Override
	protected ILayoutFeature getLayoutFeatureAdditional(ILayoutContext context) {

		PictogramElement pe = context.getPictogramElement();
		// check, whether autolayout is called. If yes, return null.
		if (pe instanceof Diagram) {
			return null;
		}
		return super.getLayoutFeatureAdditional(context);
	}

	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {


		ICustomFeature[] ret = super.getCustomFeatures(context);
		List<ICustomFeature> featureList = new ArrayList<ICustomFeature>();
		for (int i = 0; i < ret.length; i++) {
			featureList.add(ret[i]);
		}

		// Class related Custom Features
		featureList.add(new CollapseAllClassCustomFeature(this));
		featureList.add(new ExpandAllClassCustomFeature(this));
		
		featureList.add(new ShowInCommonNavigatorFeature(this));

		featureList.add(new ChangeDecoratorsVisibility(this));
		featureList.add(new ShowAllDecoratorsFeature(this));
		featureList.add(new HideAllDecoratorsFeature(this));
		featureList.add(new ToggleStorageFeature(this));

		featureList.add(new CreateAttributeCustomFeature(this));
		featureList.add(new CreateOperationCustomFeature(this));

		featureList.add(new AddSuperClassesFeature(this));
		featureList.add(new AddSubClassesFeature(this));
		featureList.add(new CreateSuperClassFeature(this));
		featureList.add(new CreateSubClassFeature(this));

		featureList.add(new DefaultClassAutoLayoutCustomFeature(this));
		featureList.add(new AddAllAssociationCustomFeature(this));

		featureList.add(new CreateInnerEnumTypeFeature(this));
		featureList.add(new CreateInnerStructureTypeFeature(this));
		featureList.add(new AddEnumTypeOfClassFeature(this));
		featureList.add(new AddStructureTypeOfClass(this));

		// <add new expand feature> 
		featureList.add(new ExpandCompartmentsCustomFeature(this));
		featureList.add(new CollapseCompartmentsCustomFeature(this));
		// </add new expand feature> 

		PictogramElement[] pes = context.getPictogramElements();
		PictogramElement firstPE = pes[0];
		if (pes != null && pes.length == 1 && firstPE instanceof ContainerShape) {               
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof MofClass) {
				MofClass mofClass = (MofClass) bo;
				List<Association> assocs = ClassService.getAllAssociations(mofClass);
				if (!assocs.isEmpty()) {
					for (Iterator<Association> iter = assocs.iterator(); iter.hasNext();) {
						Association association = iter.next();
						AssociationEnd[] aes = AssociationService.getAssociationEnds(association);
						if (aes[0].getType() != null && aes[1].getType() != null) {
							if (aes[0].getType().equals(mofClass) || aes[1].getType().equals(mofClass)) {
								featureList.add(new GenericAddAssociationCustomFeature(this,association));
							}
						}
					}                                                             
				}
			}
		}
		
		// Create new reference in class shape
		if (pes != null && pes.length == 1 && firstPE instanceof ContainerShape) {               
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof MofClass) {
				MofClass containingClass = (MofClass)bo;
				addCreateReferencesFeatureForClass(featureList, containingClass,
						containingClass);
			}
		}
		
		// Create new reference for association
		if (pes != null && pes.length == 1 && firstPE instanceof Connection) {               
			Object bo = getBusinessObjectForPictogramElement(firstPE);
			if (bo instanceof Association) {
				Association association = (Association)bo;
				AssociationEnd[] aes = AssociationService.getAssociationEnds(association);
				if (aes != null) {
					for (int i = 0; i < aes.length; i++) {
						AssociationEnd referencedEnd = aes[i];
						if (referencedEnd != null) {
							AssociationEnd exposedEnd = referencedEnd.otherEnd();
							if (exposedEnd != null) {
								MofClass containingClass = (MofClass)exposedEnd.getType();
								addCreateReferencesFeatureForAssociationEndSubclass(
										featureList, association, exposedEnd,
										referencedEnd, containingClass);
							}
						}
					}
				}
			}
		}

		// Enumeration type related Custom features
		featureList.add(new CreateLabelForEnumTypeCustomFeature(this));

		//StructureType related Custom features
		featureList.add(new CreateStructureFieldForStructureTypeFeature(this));

		// Diagram functions
		featureList.add(new UpdateClassDiagramFeature(this));
		featureList.add(new ShowPropertiesFeature(this));

		return featureList.toArray(ret);
	}

	private void addCreateReferencesFeatureForClass(
			List<ICustomFeature> featureList, MofClass containingClass,
			MofClass evaluationClass) {
		List<MofClass> allClasses = new ArrayList<MofClass>();
		addCreateReferencesFeatureForClassInternal(featureList, containingClass, evaluationClass, allClasses);
	}
	
	private void addCreateReferencesFeatureForClassInternal(
			List<ICustomFeature> featureList, MofClass containingClass,
			MofClass evaluationClass, List<MofClass> allClasses) {
		// Associations to the evaluation class
		List<Association> assocs = ClassService.getAllAssociations(evaluationClass);
		for (Iterator<Association> iter = assocs.iterator(); iter.hasNext();) {
			Association association = iter.next();
			AssociationEnd[] aes = AssociationService.getAssociationEnds(association);
			if (aes != null) {
				for (int i = 0; i < aes.length; i++) {
					if (evaluationClass.equals(aes[i].getType())) {
						AssociationEnd exposedEnd = aes[i];
						if (exposedEnd != null) {
							AssociationEnd referencedEnd = exposedEnd.otherEnd();
							if (referencedEnd != null) {
								// Create reference feature for creating a reference to the association
								// to the evaluation class within the containing class
								featureList.add(new CreateReferenceFeature(this, exposedEnd,
										referencedEnd, containingClass, association,
										CreateReferenceFeature.START_FROM_CLASS));
							}
						}
					}
				}
			}
		}
		
		// Associations to super classes of evaluation class
		Collection<MofClass> superClasses = ClassService.getSuperClasses(evaluationClass);
		for (Iterator<MofClass> it = superClasses.iterator(); it.hasNext();) {
			MofClass mofClass = it.next();
			if (!allClasses.contains(mofClass)) {
				allClasses.add(mofClass);
				addCreateReferencesFeatureForClassInternal(featureList, containingClass, mofClass, allClasses);
			}
		}
	}


	private void addCreateReferencesFeatureForAssociationEndSubclass(
			List<ICustomFeature> featureList, Association association,
			AssociationEnd exposedEnd, AssociationEnd referencedEnd,
			MofClass mofClass) {
		List<MofClass> allClasses = new ArrayList<MofClass>();
		addCreateReferencesFeatureForAssociationEndSubclassInternal(
				featureList, association,
				 exposedEnd, referencedEnd,
				 mofClass, allClasses);		
	}
	
	private void addCreateReferencesFeatureForAssociationEndSubclassInternal(
			List<ICustomFeature> featureList, Association association,
			AssociationEnd exposedEnd, AssociationEnd referencedEnd,
			MofClass mofClass, List<MofClass> allClasses) {

		if (!allClasses.contains(mofClass)) {
			allClasses.add(mofClass);
			featureList.add(new CreateReferenceFeature(this, exposedEnd,
					referencedEnd, mofClass, association,
					CreateReferenceFeature.START_FROM_ASSOCIATION));
		}
		Collection<MofClass> subclasses = ClassService.getSubClasses(mofClass);
		for (Iterator<MofClass> it = subclasses.iterator(); it.hasNext();) {
			MofClass subClass = it.next();
			addCreateReferencesFeatureForAssociationEndSubclassInternal(
				featureList, association, exposedEnd,
				referencedEnd, subClass, allClasses);

		}		
	}
			

	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		if (getDiagramTypeProvider().getDiagram().getLink() == null) {
			// Root diagram -> no creation possibility
			return new ICreateConnectionFeature[0];
		}
		return new ICreateConnectionFeature[] { new CreateAssociationFeature(this), new CreateCompositionFeature(this), new CreateGeneralizationFeature(this) };
	}

	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		PictogramElement pictogramElement = context.getPictogramElement();

		if (pictogramElement instanceof ConnectionDecorator) {
			// No delete allowed for connection decorators
			return null;
		}

		Object obj = getBusinessObjectForPictogramElement(pictogramElement);
		if (obj instanceof RefObject) {
			RefObject bo = (RefObject)obj;
			if (pictogramElement instanceof Connection) {
				Connection connection = (Connection)pictogramElement;

				if (PeUtil.getProperty(connection,
						MOFToolConstants.CON_PROPERTY_GENERALIZATION) != null) {
					return new DeleteGeneralizationFeature(this);
				} else if (bo instanceof Association) {
					return new DeleteAssociationFeature(this);
				}

			} 
			else if (bo instanceof MofClass) {
				return new DeleteClassFeature(this);
			} 
			else if (bo instanceof DataType) {
				if (bo instanceof EnumerationType) {
					Property property = LinkUtil.getLinkProperty(pictogramElement);
					if (property != null && property.getValue() != null) {
						return new DeleteLabelFromEnumTypeFeature(this);
					}
				}
				return new DeleteDataTypeFeature(this);
			}
			else if (bo instanceof Attribute) {
				return new DeleteAttributeFeature(this);
			}
			else if (bo instanceof Reference) {
				return new DeleteReferenceFeature(this);
			}
			else if (bo instanceof Operation) {
				return new DeleteOperationFeature(this);
			}
			else if (bo instanceof StructureField) {
				return new DeleteStructureFieldFromStructureTypeFeature(this);
			}
		} 
		else {
			// Generalization connections do not have a business object
			if (pictogramElement instanceof Connection) {
				Connection connection = (Connection)pictogramElement;
				if (PeUtil.getProperty(connection,
						MOFToolConstants.CON_PROPERTY_GENERALIZATION) != null) {
					return new DeleteGeneralizationFeature(this);
				}
				AnchorContainer startContainer = connection.getStart().getParent();
				AnchorContainer endContainer = connection.getEnd().getParent();
				if (startContainer != null && endContainer != null) {
					Object startBo = getBusinessObjectForPictogramElement(startContainer);
					Object endBo = getBusinessObjectForPictogramElement(endContainer);
					if (startBo instanceof DataType && endBo instanceof MofClass) {
						// Do not offer the option to delete the inner data type connection
						// since the deletion should happen via the deletion of the inner
						// data type itself
						return null;
					}
				}
			}
		}
		return super.getDeleteFeature(context);
	}

	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
		IDirectEditingFeature ret = super.getDirectEditingFeature(context);
		PictogramElement pe = context.getPictogramElement();
		Object obj = getBusinessObjectForPictogramElement(pe);
		RefObject bo = null;
		if (obj instanceof RefObject) {
			bo = (RefObject)obj;
		} else {
			return ret;
		}
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		if (bo instanceof MofClass && ga instanceof Text) {
			ret = new ClassNameDirectEditingFeature(this);
		} else if(bo instanceof Attribute && ga instanceof Text){
			ret = new ClassAttributeDirectEditingFeature(this);
		} else if(bo instanceof Operation && ga instanceof Text){
			ret = new ClassOperationDirectEditingFeature(this);
//			} else if(bo instanceof Feature && ga instanceof Image){
//			ret = new VisibilityDirectEditingFeature(this);
		} else if(bo instanceof Association && ga instanceof Text){
			ret = new AssociationNameDirectEditingFeature(this);
		} else if(bo instanceof AssociationEnd && ga instanceof Text && LinkUtil.hasLinkProperty(pe, MOFToolConstants.ASSOCIATION_END_NAME)){
			ret = new AssociationEndNameDirectEditingFeature(this);
		} else if(bo instanceof AssociationEnd && ga instanceof Text && LinkUtil.hasLinkProperty(pe, MOFToolConstants.MULTIPLICITY)){
			ret = new AssociationEndMultiplicityDirectEditingFeature(this);
		} else if(bo instanceof EnumerationType && ga instanceof Text && LinkUtil.getLinkProperty(pe) == null){
			ret = new EnumTypeNameDirectEditingFeature(this);
		} else if(bo instanceof EnumerationType && ga instanceof Text && LinkUtil.getLinkProperty(pe) != null){
			ret = new EnumTypeLabelDirecEditingFeature(this);
		} else if(bo instanceof StructureType && ga instanceof Text){
			ret = new StructureTypeNameDirectEditingFeature(this);
		} else if(bo instanceof StructureField && ga instanceof Text){
			ret = new StructureTypeFieldDirectEditingFeature(this);
		}

		return ret;
	}

	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) {
		return new ReconnectGeneralizationFeature(this);
		// return super.getReconnectionFeature(context);
	}

	/*
	 * @see com.sap.mi.gfw.pattern.DefaultJamFeatureProviderWithPatterns#getResizeShapeFeature(com.sap.mi.gfw.features.context.IResizeShapeContext)
	 */
	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		PictogramElement pe = context.getPictogramElement();
		// No resize handles for inner elements
		if (isInnerElement(pe)) {
			return null;
		}
		// No resize handles for association and association end decorators
		Object obj = getBusinessObjectForPictogramElement(pe);
		if (obj instanceof RefObject) {
			RefObject bo = (RefObject)obj;
			if (bo instanceof AssociationEnd || bo instanceof Association) {
				return null;
			}
		}
		return super.getResizeShapeFeature(context);
	}


	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		PictogramElement pe = context.getPictogramElement();
		// <innerSelection> no move feature for inner elements
		if (isInnerElement(pe)) {
			return null;
		}
		return super.getMoveShapeFeature(context);
	}

	// <innerSelection> check if element is inner element
	private boolean isInnerElement(PictogramElement pictogramElement) {
		if (getPatternForPictogramElement(pictogramElement) instanceof AbstractMofCompartmentPattern) {
			AbstractMofCompartmentPattern pattern = (AbstractMofCompartmentPattern) getPatternForPictogramElement(pictogramElement);
			if (pattern.isCompartment(pictogramElement) || pattern.isCompartmentEntry(pictogramElement) || pattern.isHeader(pictogramElement) ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		// TODO disable context menu entry "remove" for generalization connections
		// without disabling the automatic removal of those connections after
		// e.g. removing a class from a diagram
//		if (context.getPictogramElement() instanceof Connection) {
//		Connection connection = (Connection)context.getPictogramElement();
//		if (PeUtil.getProperty(connection, MOFToolConstants.CON_PROPERTY_GENERALIZATION) != null) {
//		// Generalization connections should not be removable since they are
//		// considered to belong to the class itself
//		return null;
//		}
//		}
		// <innerSelection> no remove context button for inner elements
		if (isInnerElement(context.getPictogramElement())) {
			return null;
		}		
		// For all other shapes delegate to super
		return super.getRemoveFeature(context);
	}

	/* (non-Javadoc)
	 * @see com.sap.mi.gfw.features.impl.AbstractFeatureProvider#getAffectedPartitionsForModification()
	 */
	@Override
	public Collection<PartitionOperation> getAffectedPartitionsForModification() {
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		ArrayList<PartitionOperation> list = new ArrayList<PartitionOperation>(2);
		if (diagram != null) {
			// Diagram partition
			ModelPartition partition = ((Partitionable)diagram).get___Partition();
			PRI mri = partition.getPri();
			PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
			list.add(editOperation);

			// Standard partition for root package
			MofPackage diagramPackage = DiagramService.getDiagramPackage(diagram);
			if (diagramPackage != null) {
				partition = ((Partitionable)diagramPackage).get___Partition();
				if (partition != null) {
					mri = partition.getPri();
					editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
					list.add(editOperation);
				}
			}
		}
		return list;
	}
}
