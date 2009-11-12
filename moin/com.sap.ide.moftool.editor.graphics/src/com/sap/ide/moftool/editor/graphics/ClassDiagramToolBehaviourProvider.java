package com.sap.ide.moftool.editor.graphics;

import java.util.ArrayList;
import java.util.List;

import com.sap.ide.moftool.editor.graphics.clazz.attribute.CreateAttributeCustomFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AbstractAddClassesFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AbstractAddDataTypesFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AbstractCreateInnerDataTypeFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AbstractCreateRelatedClassesFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AddSubClassesFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.AddSuperClassesFeature;
import com.sap.ide.moftool.editor.graphics.clazz.autoadd.CreateSuperClassFeature;
import com.sap.ide.moftool.editor.graphics.clazz.operation.CreateOperationCustomFeature;
import com.sap.ide.moftool.editor.graphics.clazz.reference.CreateReferenceFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.AddAllAssociationCustomFeature;
import com.sap.ide.moftool.editor.graphics.connection.association.GenericAddAssociationCustomFeature;
import com.sap.ide.moftool.editor.graphics.datatype.enumtype.CreateLabelForEnumTypeCustomFeature;
import com.sap.ide.moftool.editor.graphics.datatype.structuretype.CreateStructureFieldForStructureTypeFeature;
import com.sap.ide.moftool.editor.graphics.diagram.ShowPropertiesFeature;
import com.sap.ide.moftool.editor.graphics.pattern.AbstractMofCompartmentPattern;
import com.sap.ide.moftool.editor.graphics.pattern.compartment.CollapseCompartmentsCustomFeature;
import com.sap.ide.moftool.editor.graphics.pattern.compartment.ExpandCompartmentsCustomFeature;
import com.sap.mi.gfw.DiagramScrollingBehavior;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.ei.IExecutionInfo;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.features.context.ICustomContext;
import com.sap.mi.gfw.features.context.IPictogramElementContext;
import com.sap.mi.gfw.features.context.impl.CustomContext;
import com.sap.mi.gfw.features.context.impl.base.PictogramElementContext;
import com.sap.mi.gfw.features.custom.ICustomFeature;
import com.sap.mi.gfw.mm.pictograms.ContainerShape;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.mm.pictograms.PictogramElement;
import com.sap.mi.gfw.mm.pictograms.Shape;
import com.sap.mi.gfw.pattern.CreateFeatureForPattern;
import com.sap.mi.gfw.pattern.IPattern;
import com.sap.mi.gfw.tb.AdvancedDecoratingToolBehaviorProvider;
import com.sap.mi.gfw.tb.ContextButtonEntry;
import com.sap.mi.gfw.tb.ContextEntryHelper;
import com.sap.mi.gfw.tb.ContextMenuEntry;
import com.sap.mi.gfw.tb.IContextButtonEntry;
import com.sap.mi.gfw.tb.IContextButtonPadData;
import com.sap.mi.gfw.tb.IContextMenuEntry;
import com.sap.mi.gfw.util.PeUtil;

public class ClassDiagramToolBehaviourProvider extends AdvancedDecoratingToolBehaviorProvider {

	@Override
	public DiagramScrollingBehavior getDiagramScrollingBehavior() {
		return DiagramScrollingBehavior.SCROLLBARS_ALWAYS_VISIBLE;
	}

	/*
	 * @Override public ISelectionInfo getShapeSelectionInfo(Shape shape) { ISelectionInfo si = super.getShapeSelectionInfo(shape); final
	 * IFeatureProvider featureProvider = getFeatureProvider(); // get mof compartment pattern AbstractMofCompartmentPattern mofPattern =
	 * null; if ((featureProvider != null) && (featureProvider instanceof ClassDiagramFeatureProvider)) { IPattern pattern =
	 * ((ClassDiagramFeatureProvider) featureProvider).getPatternForPictogramElement(shape); if ((pattern != null) && (pattern instanceof
	 * AbstractMofCompartmentPattern)) { mofPattern = (AbstractMofCompartmentPattern) pattern; } else { return si; } } else { return si; }
	 * 
	 * if (mofPattern.isCompartmentEntry(shape)) { Color selColor =
	 * PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().getDisplay() .getSystemColor(SWT.COLOR_LIST_SELECTION);
	 * IColorConstant selection = new ColorConstant(selColor.getRed(), selColor.getGreen(), selColor.getBlue()); si.setColor(selection);
	 * si.setLineStyle(LineStyleEnum.SOLID); } return si;
	 * 
	 * }
	 */

	public ClassDiagramToolBehaviourProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	@Override
	public PictogramElement getAlternativeSelection(PictogramElement originalPe, PictogramElement[] oldSelection) {

		// TODO
		PictogramElement oldSel = oldSelection[0];
		// no shape selected: keep selection
		if ((originalPe == null) || !(originalPe instanceof Shape)) {
			return super.getAlternativeSelection(originalPe, oldSelection);
		}
		Shape originalShape = (Shape) originalPe;

		// get mof compartment pattern
		AbstractMofCompartmentPattern mofPattern = null;
		IFeatureProvider featureProvider = getFeatureProvider();
		if ((featureProvider != null) && (featureProvider instanceof ClassDiagramFeatureProvider)) {
			IPattern pattern = ((ClassDiagramFeatureProvider) featureProvider).getPatternForPictogramElement(originalShape);
			if ((pattern != null) && (pattern instanceof AbstractMofCompartmentPattern)) {
				mofPattern = (AbstractMofCompartmentPattern) pattern;
			} else {
				return super.getAlternativeSelection(originalPe, oldSelection);
			}
		} else {
			return super.getAlternativeSelection(originalPe, oldSelection);
		}

		if (originalPe instanceof Diagram) {
			// is diagram: always keep selection
			return super.getAlternativeSelection(originalPe, oldSelection);
		}
		if (mofPattern.isPatternRoot(originalPe)) {
			// is root node: always keep selection
			return super.getAlternativeSelection(originalPe, oldSelection);
		}
		// get outer shape
		Shape originalOuterShape = mofPattern.getPatternRoot(originalPe);
		if (mofPattern.isCompartment(originalPe)) {
			// is compartment: always select root node of compartment
			return originalOuterShape;
		}

		if (mofPattern.isCompartmentEntry(originalPe) || mofPattern.isHeader(originalPe)) {
			// is compartment entry or is header
			if ((oldSel == null) || (oldSel instanceof Diagram) || !(oldSel instanceof Shape)
					|| !(originalOuterShape.equals(mofPattern.getPatternRoot(oldSel)))) {
				return originalOuterShape;
			} else {
				// otherwise keep selection
				return super.getAlternativeSelection(originalPe, oldSelection);
			}
		} else {
			return super.getAlternativeSelection(originalPe, oldSelection);
		}

	}

	@Override
	protected boolean isContextMenuApplicable(IFeature feature) {
		return feature instanceof ICustomFeature;
	}

	@Override
	public IContextButtonPadData getContextButtonPadData(IPictogramElementContext context) {

		final PictogramElement pictogramElement = ((PictogramElementContext) context).getPictogramElement();
		if (!(pictogramElement instanceof Shape)) { // exclude Connections immediately
			return null;
		}

		final IFeatureProvider featureProvider = getFeatureProvider();
		if (!(featureProvider instanceof ClassDiagramFeatureProvider)) {
			return null;
		}

		IPattern pattern = ((ClassDiagramFeatureProvider) featureProvider).getPatternForPictogramElement(pictogramElement);
		if (!(pattern instanceof AbstractMofCompartmentPattern)) {
			return null;
		}

		// get the container shape since it determines the location of the context button pad
		AbstractMofCompartmentPattern mofPattern = (AbstractMofCompartmentPattern) pattern;
		ContainerShape containerShape = mofPattern.getPatternRoot(pictogramElement);
		if (containerShape == null) {
			return null;
		}

		// create the default pad
		PictogramElementContext pictogramElementContext = new PictogramElementContext(containerShape);
		IContextButtonPadData contextButtonPadData = super.getContextButtonPadData(pictogramElementContext);

		/*
		 * 
		 * now decide on context button type
		 */

		String prefix_new = Messages.ClassDiagramToolBehaviourProvider_0_xbut;
		String prefix_add = Messages.ClassDiagramToolBehaviourProvider_1_xbut;

		CustomContext customContext = new CustomContext(new PictogramElement[] { containerShape });
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);
		int featureCount = customFeatures.length;
		for (int i = 0; i < featureCount; i++) {
			ICustomFeature customFeature = customFeatures[i];
			if (customFeature.isAvailable(customContext)) {
				if (customFeature instanceof CreateOperationCustomFeature) {
					ContextButtonEntry contextButtonEntry = new ContextButtonEntry(customFeature, customContext);

					contextButtonEntry.setText(prefix_new + customFeature.getName());
					contextButtonEntry.setDescription(customFeature.getDescription());
					contextButtonEntry.setIconId(IImageConstants.IMG_CREATE_OPERATION);
					contextButtonPadData.getDomainSpecificContextButtons().add(contextButtonEntry);
				} else if (customFeature instanceof CreateAttributeCustomFeature) {
					ContextButtonEntry contextButtonEntry = new ContextButtonEntry(customFeature, customContext);

					contextButtonEntry.setText(prefix_new + customFeature.getName());
					contextButtonEntry.setDescription(customFeature.getDescription());
					contextButtonEntry.setIconId(IImageConstants.IMG_CREATE_ATTRIBUTE);
					contextButtonPadData.getDomainSpecificContextButtons().add(contextButtonEntry);
				} else if (customFeature instanceof AddSuperClassesFeature) {
					ContextButtonEntry contextButtonEntry = new ContextButtonEntry(customFeature, customContext);

					contextButtonEntry.setText(prefix_add + customFeature.getName());
					contextButtonEntry.setDescription(customFeature.getDescription());
					contextButtonEntry.setIconId(IImageConstants.IMG_MODIFIER_SUPCLASS_OBJ);
					contextButtonPadData.getDomainSpecificContextButtons().add(contextButtonEntry);
				} else if (customFeature instanceof AddSubClassesFeature) {
					ContextButtonEntry contextButtonEntry = new ContextButtonEntry(customFeature, customContext);

					contextButtonEntry.setText(prefix_add + customFeature.getName());
					contextButtonEntry.setDescription(customFeature.getDescription());
					contextButtonEntry.setIconId(IImageConstants.IMG_MODIFIER_SUBCLASS_OBJ);
					contextButtonPadData.getDomainSpecificContextButtons().add(contextButtonEntry);
				} else if (customFeature instanceof CreateSuperClassFeature) {
					ContextButtonEntry contextButtonEntry = new ContextButtonEntry(customFeature, customContext);

					contextButtonEntry.setText(prefix_new + customFeature.getName());
					contextButtonEntry.setDescription(customFeature.getDescription());
					contextButtonEntry.setIconId(IImageConstants.IMG_NEW_SUPERCLASS);
					contextButtonPadData.getDomainSpecificContextButtons().add(contextButtonEntry);
				} else if (customFeature instanceof AddAllAssociationCustomFeature) {
					ContextButtonEntry contextButtonEntry = new ContextButtonEntry(customFeature, customContext);

					contextButtonEntry.setText(prefix_add + customFeature.getName());
					contextButtonEntry.setDescription(customFeature.getDescription());
					contextButtonEntry.setIconId(IImageConstants.IMG_ADD_ASSOCIATION_OBJ);
					contextButtonPadData.getDomainSpecificContextButtons().add(contextButtonEntry);
				} else if (customFeature instanceof CreateLabelForEnumTypeCustomFeature) {
					ContextButtonEntry contextButtonEntry = new ContextButtonEntry(customFeature, customContext);

					contextButtonEntry.setText(customFeature.getName());
					contextButtonEntry.setDescription(customFeature.getDescription());
					contextButtonEntry.setIconId(IImageConstants.IMG_NEWLABEL_OBJ);
					contextButtonPadData.getDomainSpecificContextButtons().add(contextButtonEntry);
				} else if (customFeature instanceof CreateStructureFieldForStructureTypeFeature) {
					ContextButtonEntry contextButtonEntry = new ContextButtonEntry(customFeature, customContext);

					contextButtonEntry.setText(customFeature.getName());
					contextButtonEntry.setDescription(customFeature.getDescription());
					contextButtonEntry.setIconId(IImageConstants.IMG_NEWSTRUCTUREFIELD_OBJ);
					contextButtonPadData.getDomainSpecificContextButtons().add(contextButtonEntry);
				} else if (customFeature instanceof ExpandCompartmentsCustomFeature) {
					IContextButtonEntry collapseButton = ContextEntryHelper
							.createCollapseContextButton(false, customFeature, customContext);
					contextButtonPadData.setCollapseContextButton(collapseButton);

				} else if (customFeature instanceof CollapseCompartmentsCustomFeature) {
					IContextButtonEntry collapseButton = ContextEntryHelper.createCollapseContextButton(true, customFeature, customContext);
					contextButtonPadData.setCollapseContextButton(collapseButton);

				}
			}

		}
		return contextButtonPadData;
	}

	@Override
	public IContextMenuEntry[] getContextMenu(IContext context) {
		IContextMenuEntry[] ret = new IContextMenuEntry[0];
		List<IContextMenuEntry> retList = new ArrayList<IContextMenuEntry>();

		// custom features
		if (context instanceof ICustomContext) {
			ICustomContext customContext = (ICustomContext) context;
			ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(customContext);

			// menu groups
			ContextMenuEntry submenuEntryNew = null;
			ContextMenuEntry autoAddClassesEntry = null;
			ContextMenuEntry singleAssociationEntry = null;
			ContextMenuEntry propertiesEntry = null;
			ContextMenuEntry submenuReferenceFor = null;
			ContextMenuEntry submenuReferenceIn = null;

			// expand-collapse as first customer entry
			for (int i = 0; i < customFeatures.length; i++) {
				ICustomFeature customFeature = customFeatures[i];
				if (isContextMenuApplicable(customFeature)) {
					ContextMenuEntry contextMenuEntry = new ContextMenuEntry(customFeature, context);
					if (customFeature instanceof CollapseCompartmentsCustomFeature
							|| customFeature instanceof ExpandCompartmentsCustomFeature) {
						retList.add(contextMenuEntry);
					}
				}
			}

			// domain-specific customer entries
			for (int i = 0; i < customFeatures.length; i++) {
				ICustomFeature customFeature = customFeatures[i];
				if (isContextMenuApplicable(customFeature)) {
					ContextMenuEntry contextMenuEntry = new ContextMenuEntry(customFeature, context);

					if (customFeature instanceof CreateOperationCustomFeature || customFeature instanceof CreateAttributeCustomFeature
							|| customFeature instanceof AbstractCreateRelatedClassesFeature
							|| customFeature instanceof AbstractCreateInnerDataTypeFeature
							|| customFeature instanceof CreateReferenceFeature) {
						if (submenuEntryNew == null) {
							submenuEntryNew = new ContextMenuEntry(null, null);
							submenuEntryNew.setSubmenu(true);
							submenuEntryNew.setText(Messages.ClassDiagramToolBehaviourProvider_2_xbut);
							submenuEntryNew.setDescription(Messages.ClassDiagramToolBehaviourProvider_3_xmsg);
							retList.add(submenuEntryNew);
						}
						if (customFeature instanceof CreateReferenceFeature) {
							CreateReferenceFeature createReferenceFeature = (CreateReferenceFeature) customFeature;
							if (createReferenceFeature.getStartFrom() == CreateReferenceFeature.START_FROM_CLASS) {
								if (submenuReferenceFor == null) {
									submenuReferenceFor = new ContextMenuEntry(null, null);
									submenuReferenceFor.setSubmenu(true);
									submenuReferenceFor.setText(Messages.ClassDiagramToolBehaviourProvider_4_xmsg);
									submenuReferenceFor.setDescription(Messages.ClassDiagramToolBehaviourProvider_5_xmsg);
									submenuEntryNew.add(submenuReferenceFor);
								}
								submenuReferenceFor.add(contextMenuEntry);
							} else if (createReferenceFeature.getStartFrom() == CreateReferenceFeature.START_FROM_ASSOCIATION) {
								if (submenuReferenceIn == null) {
									submenuReferenceIn = new ContextMenuEntry(null, null);
									submenuReferenceIn.setSubmenu(true);
									submenuReferenceIn.setText(Messages.ClassDiagramToolBehaviourProvider_6_xmsg);
									submenuReferenceIn.setDescription(Messages.ClassDiagramToolBehaviourProvider_7_xmsg);
									submenuEntryNew.add(submenuReferenceIn);
								}
								submenuReferenceIn.add(contextMenuEntry);
							}
						} else {
							submenuEntryNew.add(contextMenuEntry);
						}
					} else if (customFeature instanceof AbstractAddClassesFeature || customFeature instanceof AbstractAddDataTypesFeature
							|| customFeature instanceof AddAllAssociationCustomFeature
							|| customFeature instanceof GenericAddAssociationCustomFeature) {
						if (autoAddClassesEntry == null) {
							autoAddClassesEntry = new ContextMenuEntry(null, null);
							autoAddClassesEntry.setSubmenu(true);
							autoAddClassesEntry.setText(Messages.ClassDiagramToolBehaviourProvider_8_xbut);
							autoAddClassesEntry.setDescription(Messages.ClassDiagramToolBehaviourProvider_9_xmsg);
							retList.add(autoAddClassesEntry);
						}
						if (customFeature instanceof GenericAddAssociationCustomFeature) {
							if (singleAssociationEntry == null) {
								singleAssociationEntry = new ContextMenuEntry(null, null);
								singleAssociationEntry.setSubmenu(true);
								singleAssociationEntry.setText(Messages.ClassDiagramToolBehaviourProvider_10_xbut);
								singleAssociationEntry.setDescription(Messages.ClassDiagramToolBehaviourProvider_11_xmsg);
								autoAddClassesEntry.add(singleAssociationEntry);
							}
							singleAssociationEntry.add(contextMenuEntry);

						} else {
							autoAddClassesEntry.add(contextMenuEntry);
						}
					} else {
						if (!(customFeature instanceof CollapseCompartmentsCustomFeature
								|| customFeature instanceof ExpandCompartmentsCustomFeature || customFeature instanceof ShowPropertiesFeature)) {
							retList.add(contextMenuEntry);
						}
					}
				}
			}
			// properties
			for (int i = 0; i < customFeatures.length; i++) {
				ICustomFeature customFeature = customFeatures[i];
				if (isContextMenuApplicable(customFeature)) {
					ContextMenuEntry contextMenuEntry = new ContextMenuEntry(customFeature, context);
					if (customFeature instanceof ShowPropertiesFeature) {
						if (propertiesEntry == null) {
							propertiesEntry = new ContextMenuEntry(null, null);
							propertiesEntry.setSubmenu(false);
							// propertiesEntry.setText("Show");
							// propertiesEntry.setDescription("Auto Add functionality");
							propertiesEntry.add(contextMenuEntry);
							retList.add(propertiesEntry);
						}
					}

				}
			}
		}

		ret = retList.toArray(ret);
		return ret;
	}

	@Override
	public boolean isPaletteApplicable(IFeature feature) {
		if (feature instanceof CreateFeatureForPattern) {
			IPattern pattern = ((CreateFeatureForPattern) feature).getPattern();
			if (pattern instanceof AbstractMofCompartmentPattern) {
				if (feature.getFeatureProvider().getDiagramTypeProvider().getDiagram().getLink() == null) {
					// Root diagram -> no creation of objects allowed
					return false;
				}
			}
		}
		return super.isPaletteApplicable(feature);
	}

	@Override
	public void postExecute(IExecutionInfo executionInfo) {
		super.postExecute(executionInfo);
		PeUtil.moveBendpoints(executionInfo);
	}

}
