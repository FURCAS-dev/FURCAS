// TreeMofTreeCNF

// NodeCnfPackages1
/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 *  (MITG-Version0.1
 * (NodeClass_DEFAULT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcnf.men;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MoveAssocCmd;
import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MoveClassCmd;
import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MoveDiagramCmd;
import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MovePackageCmd;
import com.sap.ide.moftool.editor.tree.LocalizationMessages;
import com.sap.ide.moftool.editor.tree.tcnf.IThisTreeNode;
import com.sap.ide.moftool.editor.tree.tcnf.NodeMofRoot;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.mql.MQLProcessor;

/**
 * @generated modified
 */
public class NodeCnfPackages extends TreeNodeRefObject<MofPackage> implements IThisTreeNode, ITreeNodeTransferHandler {

	/**
	 * @modified
	 */
	public NodeCnfPackages(MofPackage modelElement) {
		super(modelElement);
		if (modelElement.getContainer() == null) {
			setParent(new NodeMofRoot(ModelAdapter.getInstance().getProject(getValue())));
		} else {
			setParent(new NodeCnfPackages((MofPackage) modelElement.getContainer()));
		}
	}

	/**
	 * @modified
	 */
	public NodeCnfPackages(Object parent, MofPackage modelElement) {
		super(parent, modelElement);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {

		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();

		MofPackage mofPackage = getValue();

		Connection connection = ModelAdapter.getInstance().getConnection(mofPackage);

		String assocQuery = "select assoc from \"sap.com/tc/moin/mof_1.4\"#Model::Association as assoc, \"" //$NON-NLS-1$
				+ ((Partitionable) mofPackage).get___Mri() + "\" as pack where assoc.container = pack"; //$NON-NLS-1$
		MQLProcessor mqlProcessor = connection.getMQLProcessor();
		if (mqlProcessor.execute(assocQuery, mqlProcessor.getGlobalQueryScopeProvider(), 1).getSize() > 0) {
			children.add(new NodeCnfAssocContainer(this, getConnection()));
		}

		
		for (Diagram d : DiagramService.getAllClassDiagramsForPackage(mofPackage)) {
			NodeCnfDiagramsInPackages ltn = new NodeCnfDiagramsInPackages(this, d);
			children.add(ltn);
		}
		
		for (ModelElement dobj : mofPackage.getContents()) {
			if (dobj instanceof MofPackage) {
				NodeCnfPackages ltn = new NodeCnfPackages(this, (MofPackage) dobj);
				children.add(ltn);
			} else if (dobj instanceof MofClass) {
				NodeCnfClasses ltn = new NodeCnfClasses(this, (MofClass) dobj);
				children.add(ltn);
			} else if (dobj instanceof DataType) {
				NodeCnfDataTypes ltn = new NodeCnfDataTypes(this, (DataType) dobj);
				children.add(ltn);
			}
		}

		return children.toArray();
	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		return getChildren().length != 0;
	}

	public boolean handleTransfer(Object target, ITreeNodeTransfer transfer) {
		RefBaseObject[] refBaseObjects = transfer.getRefBaseObjects(getConnection());
		Command cmd = null;
		//Check out all partitions of the project
		if (!CommandManager.getInstance().prepareExecution(getConnection(), null).isOK()) {
			return false;
		}
		getConnection().getCommandStack().openGroup(LocalizationMessages.NodeCnfPackages_0_XTND);
		try {
			for (RefBaseObject refBaseObject : refBaseObjects) {
				if (refBaseObject instanceof MofClass) {
					cmd = new MoveClassCmd((MofClass) refBaseObject, getValue(), getConnection());
				} else if (refBaseObject instanceof MofPackage) {
					cmd = new MovePackageCmd((MofPackage) refBaseObject, getValue(), getConnection());
				} else if (refBaseObject instanceof Association) {
					cmd = new MoveAssocCmd((Association)refBaseObject, getValue(), getConnection());
				} else if (refBaseObject instanceof Diagram) {
					cmd = new MoveDiagramCmd((Diagram)refBaseObject, getValue(), getConnection());
				}
				cmd.execute();
			}
		} finally {
			getConnection().getCommandStack().closeGroup();
			ConnectionManagerUI.getInstance().saveIfNecessary(getConnection(), null);
		}
		return true;
	}

	public boolean isTransferAllowed(Object target, ITreeNodeTransfer transfer) {
		RefBaseObject[] refBaseObjects = transfer.getRefBaseObjects(getConnection());
		for (RefBaseObject refBaseObject : refBaseObjects) {
			// only classes, associtations and packages can be moved
			if (!(refBaseObject instanceof MofClass) && !(refBaseObject instanceof Association)
					&& !(refBaseObject instanceof MofPackage) && !(refBaseObject instanceof Diagram)) {
				return false;
			}
			
			// if package, it must not be a root package and moving into a lower container is not allowed
			if (refBaseObject instanceof MofPackage) {
				if ( ((MofPackage) refBaseObject).getContainer() == null) {
					return false;
				}
				
				MofPackage parent = (MofPackage) ((NodeCnfPackages) target).getValue();
				while (parent != null) {
					if (parent.equals(refBaseObject)) {
						return false;
					} else
						parent = (MofPackage) parent.getContainer();
				}
			}

		}
		return true;
	}
}
