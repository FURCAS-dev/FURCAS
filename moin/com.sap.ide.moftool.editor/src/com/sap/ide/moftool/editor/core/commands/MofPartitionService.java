package com.sap.ide.moftool.editor.core.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.Constraint;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
//import com.tssap.util.projectinfo.ProjectInfo;

public class MofPartitionService {
	
	public static final IPath SOURCE_FOLDER = new Path("moin/meta"); //$NON-NLS-1$
	private static final IPath METAMODEL_OBJECTS_FOLDER = SOURCE_FOLDER;
	// Use root folder "diagrams" in DC for storing diagram partitions. Reason:
	// diagram partitions should not be part of the build folder (moin/meta) 
	// because they cause problems during the metamodel DC build. 
	public static final IPath DIAGRAMS_FOLDER = new Path("diagrams"); //$NON-NLS-1$
	public static final String PARTITION_NAME_FOR_METAMODEL_OBJECTS = "Metamodel"; //$NON-NLS-1$
	private static final String PARTITION_FILE_NAME_FOR_METAMODEL_OBJECTS = PARTITION_NAME_FOR_METAMODEL_OBJECTS +
			MetaModelCatalog.META_MODEL_EXTENSION;
	private static final String PARTITION_FILE_NAME_FOR_OCL_OBJECTS = "Ocl" + MetaModelCatalog.META_MODEL_EXTENSION; //$NON-NLS-1$
	private static final String PARTITION_PREFIX_FOR_CLASS_DIAGRAMS = "CD_"; //$NON-NLS-1$
	private static final String PARTITION_EXTENSION_FOR_CLASS_DIAGRAMS = "diagram"; //$NON-NLS-1$
	
	private static final String METAMODEL_PARTITION_PREFIX_PROPERTY = "MTP_METAMODEL_PARTITION_PREFIX"; //$NON-NLS-1$

	private MofPartitionService() {
		super();
	}
	
	
	public static IPath getDefaultPartitionName(RefObject object) {
		IProject project = ModelAdapter.getInstance().getProjectUsingConnection(object);
		Class<? extends RefBaseObject> type = ((Partitionable)object).get___JmiInterface();
		return getDefaultPartitionName(object, type, project);
	}

	private static String getMetamodelPartitionPrefix(IProject project) {
		//TODO  do we need this?
	        //String metamodelPartitionPrefix = ProjectInfo.getProperty(project, METAMODEL_PARTITION_PREFIX_PROPERTY);
//		if (metamodelPartitionPrefix == null) {
//			metamodelPartitionPrefix = ""; //$NON-NLS-1$
//		}
//		return metamodelPartitionPrefix;
	    return "";
	}

	public static IPath getDefaultPartitionName(RefObject object,
			Class<? extends RefBaseObject> type, IProject project) {
		IPath partitionPath = null;
		
		String metamodelPartitionPrefix = getMetamodelPartitionPrefix(project);

		if (Diagram.class.isAssignableFrom(type)) {
			// All objects in a diagram shall be stored within one partition which has
			// the name of the diagram
			String objectName = ((Diagram)object).getName();
			String name = PARTITION_PREFIX_FOR_CLASS_DIAGRAMS + objectName;
			partitionPath = DIAGRAMS_FOLDER.append(name).addFileExtension(PARTITION_EXTENSION_FOR_CLASS_DIAGRAMS);
		}
		else if (MofClass.class.isAssignableFrom(type) ||
				MofPackage.class.isAssignableFrom(type) ||
				Association.class.isAssignableFrom(type) ||
				EnumerationType.class.isAssignableFrom(type) ||
				StructureType.class.isAssignableFrom(type) ||
				StructureField.class.isAssignableFrom(type) ||
				Attribute.class.isAssignableFrom(type) ||
				Reference.class.isAssignableFrom(type) ||
				Operation.class.isAssignableFrom(type) ||
				MofException.class.isAssignableFrom(type) ||
				Parameter.class.isAssignableFrom(type) ||
				Import.class.isAssignableFrom(type) ||
				Tag.class.isAssignableFrom(type) ||
				Constraint.class.isAssignableFrom(type) ||
				Constant.class.isAssignableFrom(type)) {
			
			// Create the default partition name
			String name = metamodelPartitionPrefix + PARTITION_FILE_NAME_FOR_METAMODEL_OBJECTS;
			partitionPath = METAMODEL_OBJECTS_FOLDER.append(name);
			if (object instanceof ModelElement) {
				ModelElement element = (ModelElement)object;
				ModelElement parent = element.getContainer();
				if (parent != null) {
					// Take the partition of the parent object
					partitionPath = new Path(((Partitionable)parent).get___Partition().getPri().getPartitionName());
				}
			}
		}
		else {
			MOFToolEditorPlugin.logError(new InternalErrorException("Object type '" + //$NON-NLS-1$
					type.getClass().getName() + "' not supported")); //$NON-NLS-1$
		}
		
		return partitionPath;
	}

	public static ModelPartition getPartition(IPath partitionPath, IProject project,
			Connection connection) {
        ModelPartition partition = PartitionService.getInstance().getPartition(connection,
        		project, partitionPath);
        return partition;
	}
	
	public static ModelPartition getDefaultPartition(RefObject object, IProject project,
			Connection connection) {
		IPath partitionPath = getDefaultPartitionName(object);
		return getPartition(partitionPath, project, connection);
	}

	public static ModelPartition getOrCreateDefaultPartition(RefObject object, IProject project,
			Connection connection) {
		IPath partitionPath = getDefaultPartitionName(object);
		ModelPartition partition = getPartition(partitionPath, project, connection);
		if (partition == null) {
			IPath path = project.getProjectRelativePath().append(partitionPath);
			partition = PartitionService.getInstance().createPartition(connection, project, path, null);
		}
		return partition;
	}

	public static ModelPartition getStandardMetamodelPartition(IProject project,
			Connection connection, boolean create) {
		String name = getMetamodelPartitionPrefix(project) + PARTITION_FILE_NAME_FOR_METAMODEL_OBJECTS;
		return getPartition(project, name, connection, create);
	}

	public static ModelPartition getStandardOclPartition(IProject project,
			Connection connection, boolean create) {
		String name = getMetamodelPartitionPrefix(project) + PARTITION_FILE_NAME_FOR_OCL_OBJECTS;
		return getPartition(project, name, connection, create);
	}

	private static ModelPartition getPartition(IProject project, String name,
			Connection connection, boolean create) {
		IPath partitionPath = METAMODEL_OBJECTS_FOLDER.append(name); 
        ModelPartition partition = PartitionService.getInstance().getPartition(connection,
        		project, partitionPath);
        if (partition == null && create) {
        	IPath path = project.getProjectRelativePath().append(partitionPath);
			partition = PartitionService.getInstance().createPartition(connection, project, path, null);
        }
        return partition;
	}

	public static ModelPartition getMetamodelPartition(IProject project, String partitionName,
			Connection connection, boolean create) {
		String name = getMetamodelPartitionPrefix(project) + partitionName + MetaModelCatalog.META_MODEL_EXTENSION;
		IPath partitionPath = METAMODEL_OBJECTS_FOLDER.append(name); 
        ModelPartition partition = PartitionService.getInstance().getPartition(connection,
        		project, partitionPath);
        if (partition == null && create) {
        	IPath path = project.getProjectRelativePath().append(partitionPath);
			partition = PartitionService.getInstance().createPartition(connection, project, path, null);
        }
        return partition;
	}

	public static Collection<PartitionOperation> getAffectedDefaultPartitionsForSubObjectCreation(
			Partitionable parentPartitionable, Class<?> newSubObjectType, String newSubOjectName) {
		// Create list for modified partitions
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();
		
		// Get partition of parent object and add it to list
		ModelPartition parentPartition = parentPartitionable.get___Partition();
		PRI mri = parentPartition.getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
		affectedPartitions.add(editOperation);
		
		// Check if a new partition is needed and add it if necessary
		// TODO The following check does not work
//		String newPartitionName = getDefaultPartitionName(newSubOjectName, newSubObjectType);
//		if (!parentPartition.getPri().getPartitionDescriptor().getContainerName().endsWith(newPartitionName)) {
//			IProject project = ModelManager.getInstance().findProject((RefObject)parentPartitionable);
//			PRI pri = PartitionService.getInstance().getPRI(project, new Path(newPartitionName));
//			PartitionOperation createOperation = new PartitionOperation(PartitionOperation.Operation.CREATE, pri);
//			affectedPartitions.add(createOperation);
//		}

		return affectedPartitions;
	}

	public static Collection<PartitionOperation> getAffectedDefaultPartitionsForChangingReference(
			Partitionable parentPartitionable, Class<?> newTarget) {
		// Create list for modified partitions
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();
		
		// Get partition of parent object and add it to list
		ModelPartition parentPartition = parentPartitionable.get___Partition();
		PRI mri = parentPartition.getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
		affectedPartitions.add(editOperation);
		
		return affectedPartitions;
	}

	public static Collection<PartitionOperation> getAffectedDefaultPartitionsForObjectDeletion(Partitionable object) {
		// Create list for modified partitions
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();
	
		
		// Get partition of object to delete and add it to list
		ModelPartition partition = object.get___Partition();
		PRI pri = partition.getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
		affectedPartitions.add(editOperation);
		
		// Check if the object is contained in a diagram
		if (object instanceof ModelElement) {
			ModelElement modelElement = (ModelElement)object;
			Connection conn = ModelAdapter.getInstance().getConnection(modelElement);
			List<Diagram> diagrams = null;
			if (conn == null) {
				diagrams = DiagramService.getAllClassDiagrams(ModelAdapter.getInstance().getProject(modelElement));
			} else {
				diagrams = DiagramService.getAllClassDiagramsWithConnection(conn);
			}
			
			for (Diagram diagram : diagrams) { 
				if (DiagramService.isContainedInDiagram(diagram, modelElement)) {
					// Object is contained in diagram -> add diagram partition to list of affected partitions
					partition = ((Partitionable)diagram).get___Partition();
					pri = partition.getPri();
					editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, pri);
					affectedPartitions.add(editOperation);
				}
			}
		}

		return affectedPartitions;
	}

	public static Collection<PartitionOperation> getAffectedDefaultPartitionsForObjectModification(Partitionable object) {
		// Create list for modified partitions
		List<PartitionOperation> affectedPartitions = new ArrayList<PartitionOperation>();
		
		// Get partition of object to modify and add it to list
		ModelPartition partition = object.get___Partition();
		PRI mri = partition.getPri();
		PartitionOperation editOperation = new PartitionOperation(PartitionOperation.Operation.EDIT, mri);
		affectedPartitions.add(editOperation);

		return affectedPartitions;
	}
}
