/*******************************************************************************
 * Copyright (c) 2005-2006 SAP AG 
 * (MITG-Version0.1)
 * (NodeClass_ROOTPROJECT.xsl)
 *******************************************************************************/
package com.sap.ide.moftool.editor.tree.tcnf;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;

import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MoveClassCmd;
import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MovePackageCmd;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfPackages;
import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfRootDiagrams;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransfer;
import com.sap.mi.fwk.ui.tree.dnd.ITreeNodeTransferHandler;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeDomainRoot;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;

/**
 * Navigator Root Node
 * 
 * @author SAP AG
 * @generated modified
 */
public class NodeMofRoot extends TreeNodeDomainRoot implements IThisTreeNode {

	/**
	 * @generated
	 */
	public NodeMofRoot(IProject value) {
		super(value, value);
	}

	/**
	 * @modified
	 */
	public Object[] getChildren() {
		// implement your Moin query here

		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();
		MQLProcessor processor = getConnection().getMQLProcessor();
		CRI containerScope = ModelAdapter.getInstance().getContainer(getValue());
		QueryScopeProvider qsp = processor.getInclusiveCriScopeProvider(containerScope);

		// String queryDiagrams =
		// "select d from \"sap.com/com/sap/mi/gfw/mm\"#pictograms::Diagram as d"
		// ;
		String queryDiagrams = "select d from \"" + MOFToolEditorPlugin.CONTAINERNAME_GFW //$NON-NLS-1$
				+ "\"#pictograms::Diagram as d"; //$NON-NLS-1$
		MQLResultSet resultSetDiagrams = processor.execute(queryDiagrams, qsp);
		RefObject rod = null;
		for (int i = 0; i < resultSetDiagrams.getSize(); i++) {
			rod = resultSetDiagrams.getRefObject(i, "d"); //$NON-NLS-1$
			if (rod instanceof Diagram) {
				Diagram diag = (Diagram) rod;
				if (DiagramService.getDiagramPackage(diag) == null) {
					NodeCnfRootDiagrams ltn = new NodeCnfRootDiagrams(this, diag);
					children.add(ltn);
				}
			}

		}

		// RefBaseObject modelElement = null;
		// {
		//
		// List<RefBaseObject> lMMChildren;
		//
		// if (modelElement == null) {
		//
		// RefPackage refPackage = MOFToolEditorPlugin.getRoot(getConnection());
		// lMMChildren =
		// MMXPathImpl.createQueryExecutor(MOFToolEditorPlugin.getDefault
		// ().getMMNSPMgr(),
		// refPackage).selectList(refPackage,
		// "//pi:Diagram[@diagramTypeId='com.sap.ide.moftool.class' and count(<link>::*)=0]"
		// );
		//
		// } else {
		//
		// lMMChildren =
		// MMXPathImpl.createQueryExecutor(MOFToolEditorPlugin.getDefault
		// ().getMMNSPMgr(),
		// modelElement).selectList(modelElement,
		// "//pi:Diagram[@diagramTypeId='com.sap.ide.moftool.class' and count(<link>::*)=0]"
		// );
		//
		// }
		//
		// for (RefBaseObject devobj : lMMChildren) {
		// NodeCnfRootDiagrams ltn = new NodeCnfRootDiagrams(this, (Diagram)
		// devobj);
		// children.add(ltn);
		// }
		//
		// }

		// String query =
		// "select p from \"sap.com/tc/moin/mof_1.4\"#Model::Package as p";
		String query = "select p from \"" + MOFToolEditorPlugin.CONTAINERNAME_Model + "\"#Model::Package as p"; //$NON-NLS-1$ //$NON-NLS-2$
		MQLResultSet resultSet = processor.execute(query, qsp);
		RefObject ro = null;
		for (int i = 0; i < resultSet.getSize(); i++) {
			ro = resultSet.getRefObject(i, "p"); //$NON-NLS-1$
			if (ro instanceof MofPackage) {
				MofPackage mp = (MofPackage) ro;
				if (mp.getContainer() == null) {
					String name = mp.getName();
					if (!(name != null && name.startsWith("OclGenerated_"))) { //$NON-NLS-1$
						NodeCnfPackages ltn = new NodeCnfPackages(this, mp);
						children.add(ltn);
					}
				}
			}

		}

		/*
		 * {
		 * 
		 * List<RefBaseObject> lMMChildren;
		 * 
		 * if (modelElement == null) {
		 * 
		 * RefPackage refPackage = MOFToolEditorPlugin.getRoot(getConnection());
		 * lMMChildren =
		 * MMXPathImpl.createQueryExecutor(MOFToolEditorPlugin.getDefault
		 * ().getMMNSPMgr(), refPackage).selectList(refPackage,
		 * "//Package[count(./<container>::*)=0]");
		 * 
		 * } else {
		 * 
		 * lMMChildren =
		 * MMXPathImpl.createQueryExecutor(MOFToolEditorPlugin.getDefault
		 * ().getMMNSPMgr(), modelElement).selectList(modelElement,
		 * "//Package[count(./<container>::*)=0]");
		 * 
		 * }
		 * 
		 * for (RefBaseObject devobj : lMMChildren) { NodeCnfRootPackages ltn =
		 * new NodeCnfRootPackages(this, (MofPackage)devobj);
		 * 
		 * // Filter out generated OCL package boolean add = true; RefObject
		 * object = ltn.getValue(); if (object instanceof MofPackage) {
		 * MofPackage mp = (MofPackage)object; String name = mp.getName(); if
		 * (name != null && name.startsWith("OclGenerated_")) { add = false; } }
		 * 
		 * // Only add if not filtered out if (add) { children.add(ltn); } } }
		 */

		return children.toArray();

	}

	/**
	 * @generated
	 */
	public boolean hasChildren() {
		// the assumption is that root nodes always have some children
		return true;
	}
}
