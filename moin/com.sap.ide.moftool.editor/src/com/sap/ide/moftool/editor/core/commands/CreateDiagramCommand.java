package com.sap.ide.moftool.editor.core.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.core.resources.IProject;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.core.service.StyleService;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.mi.gfw.util.PeUtil;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class CreateDiagramCommand extends Command {

	private String mName = null;
	private MofPackage mPackage = null;
	private String mDiagramType = null;
	private IProject mProject = null;
	private Diagram mDiagram = null;

	public CreateDiagramCommand(String name, String diagramType,
			IProject project, Connection connection) {
		super(connection, LocalizationMessages.CreateDiagramCommand_0_XMIT);
		mName = name;
		mDiagramType = diagramType;
		mProject = project;
	}

	public CreateDiagramCommand(String name, String diagramType,
			MofPackage diagramPackage, Connection connection) {
		super(connection, LocalizationMessages.CreateDiagramCommand_1_XMIT);
		mName = name;
		mDiagramType = diagramType;
		mPackage = diagramPackage;
		mProject = ModelAdapter.getInstance().getProject(mPackage);
	}

	@Override
	public boolean canExecute() {
		// Name must not be empty or null
		if (mName == null || mName.length() == 0) {
			return false;
		}
		
		List<Diagram> classDiagrams = DiagramService.getAllClassDiagrams(mProject);
		for (Iterator<Diagram> iterator = classDiagrams.iterator(); iterator.hasNext();) {
			Diagram diagram = iterator.next();
			if (mName.equals(diagram.getName())) {
				// Diagram with same name found -> not allowed
				return false;
			}
		}
		return true;
	}

	@Override
	public void doExecute() {
		// Create a new diagram
		int gridUnit = 10;
		boolean snap = true;
		mDiagram = PeUtil.createDiagram(getConnection(), mDiagramType, mName, gridUnit, snap);

		// Add to correct partition
		ModelPartition partition = MofPartitionService.getOrCreateDefaultPartition(mDiagram, mProject,
				getConnection());
		((Partitionable)mDiagram).assign___PartitionIncludingChildren(partition);

		// Initialize styles for diagram
		StyleService.createInitialStyles(mDiagram);

		// Set home package for diagram
		if (mPackage != null) {
			LinkUtil.assignToDiagram(mDiagram, mPackage);
		}
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>(0);
		return affectedPartitions;
	}

	public Diagram getDiagram() {
		return mDiagram;
	}
}
