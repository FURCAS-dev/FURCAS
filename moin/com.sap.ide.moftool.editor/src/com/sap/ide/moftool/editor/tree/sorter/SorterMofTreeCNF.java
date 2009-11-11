package com.sap.ide.moftool.editor.tree.sorter;

import java.text.Collator;

import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.StructureType;

import org.eclipse.jface.viewers.ViewerSorter;

import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfClasses;
import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfDataTypes;
import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfDiagramsInPackages;
import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfDiagramsInRootPackages;
import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfPackages;
import com.sap.ide.moftool.editor.tree.tcnf.men.NodeCnfRootDiagrams;

public class SorterMofTreeCNF extends ViewerSorter {

	private static final int CATEGORY_DIAGRAM = 0;
	private static final int CATEGORY_PACKAGE = 1;
	private static final int CATEGORY_CLASS = 2;
	private static final int CATEGORY_STRUCTURE_TYPE = 3;
	private static final int CATEGORY_ENUMERATION_TYPE = 4;
	
	public SorterMofTreeCNF() {
		super();
	}

	public SorterMofTreeCNF(Collator collator) {
		super(collator);
	}

	@Override
	public int category(Object element) {
		int category = 0;
		
		if (element instanceof NodeCnfRootDiagrams ||
				element instanceof NodeCnfDiagramsInRootPackages ||
				element instanceof NodeCnfDiagramsInPackages) {
			category = CATEGORY_DIAGRAM;
		}
		else if (element instanceof NodeCnfPackages) {
			category = CATEGORY_PACKAGE;
		}
		else if (element instanceof NodeCnfClasses) {
			category = CATEGORY_CLASS;
		}
		else if (element instanceof NodeCnfDataTypes) {
			NodeCnfDataTypes node = (NodeCnfDataTypes)element;
			if (node.getValue() instanceof StructureType) {
				category = CATEGORY_STRUCTURE_TYPE;
			}
			else if (node.getValue() instanceof EnumerationType) {
				category = CATEGORY_ENUMERATION_TYPE;
			}
		}
		
		return category;
	}
}
