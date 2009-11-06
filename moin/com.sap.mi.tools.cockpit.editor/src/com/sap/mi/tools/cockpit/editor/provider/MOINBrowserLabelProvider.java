package com.sap.mi.tools.cockpit.editor.provider;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.provider.TreeNodeLabelProvider;
import com.sap.mi.tools.cockpit.editor.MOINBrowser;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.model.AssociationEndNode;
import com.sap.mi.tools.cockpit.editor.model.AttributeValuePair;
import com.sap.mi.tools.cockpit.editor.model.CollectionNode;
import com.sap.mi.tools.cockpit.editor.model.LiteralNode;
import com.sap.mi.tools.cockpit.editor.model.MetaModelNode;
import com.sap.mi.tools.cockpit.editor.model.MetaObjectNode;
import com.sap.mi.tools.cockpit.editor.model.ModelPartitionNode;
import com.sap.mi.tools.cockpit.editor.model.ModelPartitionSubPathNode;
import com.sap.mi.tools.cockpit.editor.model.NameValuePair;
import com.sap.mi.tools.cockpit.editor.model.ProjectRootNode;
import com.sap.mi.tools.cockpit.editor.model.PropertyNode;
import com.sap.mi.tools.cockpit.editor.model.RefObjectNode;
import com.sap.mi.tools.cockpit.editor.model.RefPackageNode;
import com.sap.mi.tools.cockpit.editor.model.StructureTypeNode;
import com.sap.mi.tools.cockpit.editor.model.TypeNode;
import com.sap.mi.tools.cockpit.editor.ui.MOINBrowserView;
import com.sap.tc.moin.repository.mmi.model.AliasType;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.reflect.RefStruct;

/**
 * Label provider for the {@link MOINBrowserView}. Assumes elements are instances of {@link ITreeNode}.
 * 
 * @author d003456
 * 
 */
public class MOINBrowserLabelProvider extends TreeNodeLabelProvider implements IStyledLabelProvider {

	public static final String ERROR_LABEL = Messages.MOINBrowserLabelProvider_0_xfld;

	public static final String EMPTY_LABEL = Messages.MOINBrowserLabelProvider_1_xfld;

	public static final String UNKNOWN_LABEL = Messages.MOINBrowserLabelProvider_2_xfld;

	public static final String NULL_VALUE = Messages.MOINBrowserLabelProvider_3_xfld;

	public final static String TYPE_STRING_LABEL_PART = "String"; //$NON-NLS-1$

	public final static String TYPE_INTEGER_LABEL_PART = "Integer"; //$NON-NLS-1$

	public final static String TYPE_LONG_LABEL_PART = "Long"; //$NON-NLS-1$

	public final static String TYPE_FLOAT_LABEL_PART = "Float"; //$NON-NLS-1$

	public final static String TYPE_DOUBLE_LABEL_PART = "Double"; //$NON-NLS-1$

	public final static String TYPE_BOOLEAN_LABEL_PART = "Boolean"; //$NON-NLS-1$

	public final static String REF_META_OBJECT = "refMetaObject"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {

		if (element instanceof RefPackageNode) {
			return ((RefPackageNode) element).getLabel();
		}

		if (element instanceof ProjectRootNode) {
			return ((ProjectRootNode) element).getLabel();
		}

		if (element instanceof ModelPartitionSubPathNode) {
			return ((ModelPartitionSubPathNode) element).getLabel();
		}

		if (element instanceof PropertyNode) {
			return ((PropertyNode<?>) element).getLabel();
		}

		if (element instanceof LiteralNode) {
			return ((LiteralNode) element).getLabel();
		}

		if (element instanceof CollectionNode) {
			return ((CollectionNode) element).getLabel();
		}

		if (element instanceof TypeNode) {
			return (((TypeNode) element).getValue()).getName();
		}

		if (element instanceof MetaModelNode) {
			return ((MetaModelNode) element).getLabel();
		}

		if (element instanceof MetaObjectNode) {
			return ((MetaObjectNode) element).getLabel();
		}

		if (element instanceof ModelPartitionNode) {
			return ((ModelPartitionNode) element).getLabel();
		}

		if (element instanceof AssociationEndNode) {
			return ((AssociationEndNode) element).getLabel();
		}

		if (element instanceof RefObjectNode) {
			return ((RefObjectNode) element).getLabel();
		}

		if (element instanceof StructureTypeNode) {
			return ((StructureTypeNode<?>) element).getLabel();
		}

		// this should never happen
		// return "Error: " + String.valueOf(element);
		return super.getText(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {

		if (element instanceof AssociationEndNode) {
			final AssociationEndNode node = (AssociationEndNode) element;
			final int cardinality = node.getCardinality();
			if (node.isComposite()) {
				if (cardinality == 1) {
					return MOINBrowser.getDefault().getImage(MOINBrowser.ZERO_TO_ONE_COMPOSITION_IMAGE);
				} else {
					return MOINBrowser.getDefault().getImage(MOINBrowser.ZERO_TO_UNBOUND_COMPOSITION_IMAGE);
				}
			} else {
				if (cardinality == 1) {
					return MOINBrowser.getDefault().getImage(MOINBrowser.ZERO_TO_ONE_ASSOCIATION_IMAGE);
				} else {
					return MOINBrowser.getDefault().getImage(MOINBrowser.ZERO_TO_UNBOUND_ASSOCIATION_IMAGE);
				}
			}
		}

		if (element instanceof CollectionNode) {
			return MOINBrowser.getDefault().getImage(MOINBrowser.ZERO_TO_UNBOUND_ATTRIBUTE_IMAGE);
		}

		if (element instanceof RefObjectNode) {
			return MOINBrowser.getDefault().getImage(MOINBrowser.OBJECT_IMAGE);
		}

		if (element instanceof MetaObjectNode) {
			return MOINBrowser.getDefault().getImage(MOINBrowser.MOVE_UP_IMAGE);
		}

		if (element instanceof ProjectRootNode) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT);
		}

		if (element instanceof ModelPartitionSubPathNode) {
			if (!((ModelPartitionSubPathNode) element).isContainer()) {
				return MOINBrowser.getDefault().getImage(MOINBrowser.CONTAINER_PATH_IMAGE);
			} else {
				return MOINBrowser.getDefault().getImage(MOINBrowser.CONTAINER_IMAGE);
			}
		}

		if (element instanceof ModelPartitionNode) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		}

		if (element instanceof TypeNode) {
			return MOINBrowser.getDefault().getImage(MOINBrowser.TYPE_IMAGE);
		}

		if (element instanceof MetaModelNode) {
			return MOINBrowser.getDefault().getImage(MOINBrowser.METAMODEL_IMAGE);
		}

		if (element instanceof LiteralNode) {
			return MOINBrowser.getDefault().getImage(MOINBrowser.LITERAL_IMAGE);
		}

		if (element instanceof RefPackageNode) {
			return MOINBrowser.getDefault().getImage(MOINBrowser.PACKAGE_IMAGE);
		}

		if (element instanceof PropertyNode) {

			if (((PropertyNode<?>) element).getValue() instanceof AttributeValuePair) {
				final AttributeValuePair attrValuePair = (AttributeValuePair) ((PropertyNode<?>) element).getValue();
				if (attrValuePair.getAttribute().getType() instanceof EnumerationType) {
					return MOINBrowser.getDefault().getImage(MOINBrowser.ENUMERATION_TYPE_IMAGE);
				} else if (attrValuePair.getAttribute().getType() instanceof StructureType) {
					return MOINBrowser.getDefault().getImage(MOINBrowser.STRUCTURE_TYPE_IMAGE);
				} else if (attrValuePair.getAttribute().getType() instanceof AliasType) {
					return MOINBrowser.getDefault().getImage(MOINBrowser.ALIAS_TYPE_IMAGE);
				} else {
					return MOINBrowser.getDefault().getImage(MOINBrowser.ATTRIBUTE_IMAGE);
				}
			} else if (((PropertyNode<?>) element).getValue() instanceof NameValuePair) {
				final NameValuePair nameValuePair = (NameValuePair) ((PropertyNode<?>) element).getValue();
				final Object value = nameValuePair.getValue();
				if (value instanceof String || value instanceof Integer || value instanceof Long || value instanceof Double
						|| value instanceof Float || value instanceof Boolean) {

					return MOINBrowser.getDefault().getImage(MOINBrowser.ATTRIBUTE_IMAGE);

				} else if (value instanceof RefStruct) {
					return MOINBrowser.getDefault().getImage(MOINBrowser.ATTRIBUTE_IMAGE);
				}
			}
		}

		if (element instanceof StructureTypeNode) {
			return MOINBrowser.getDefault().getImage(MOINBrowser.STRUCTURE_TYPE_IMAGE);
		}

		// return MOINBrowser.getDefault().getImage(MOINBrowser.ATTRIBUTE_IMAGE);
		return super.getImage(element);
		// return MOINBrowser.getDefault().getImage(MOINBrowser.LOADING_IMAGE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getStyledText(java.lang.Object)
	 */
	public StyledString getStyledText(Object element) {

		String text = getText(element);
		StyledString styledString = new StyledString(text);
		if (element instanceof RefObjectNode) {
			int index = text.indexOf(": "); //$NON-NLS-1$
			if (index != -1) {
				styledString.setStyle(index, text.length() - index, StyledString.DECORATIONS_STYLER);
			}
		} else if (element instanceof PropertyNode || element instanceof CollectionNode || element instanceof StructureTypeNode) {
			int index = text.indexOf(", "); //$NON-NLS-1$
			if (index != -1) {
				styledString.setStyle(index + 2, text.length() - (index + 2), StyledString.QUALIFIER_STYLER);
			}
		} else if (element instanceof AssociationEndNode) {
			int index = text.indexOf("-> "); //$NON-NLS-1$
			if (index != -1) {
				styledString.setStyle(index + 3, text.length() - (index + 3), StyledString.QUALIFIER_STYLER);
			}
		} else if (element instanceof LiteralNode) {
			styledString.setStyle(0, text.length(), StyledString.QUALIFIER_STYLER);
		}
		return styledString;
	}
}
