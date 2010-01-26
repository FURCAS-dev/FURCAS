package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;

import test.enumeration.Student;
import test.expression.ExpressionContainer;
import test.inheritance.Employee;
import test.inheritance.Manager;
import test.reference.Library;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.RootNodeProvider;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;

/**
 * Computes the root nodes of the Editor.Test metamodel which are the deployment
 * units.
 * 
 * @author Axel Uhl D043530
 * 
 */
public class EditorTestRootNodeProvider implements RootNodeProvider {

	private static List<MofClass> topLevelModelElementTypes;

	@Override
	public List<ITreeNode<?>> getChildren(Object parent, IProject project,
			Connection connection) {
		IPartitionScopeProvider partitionScopeProvider = PartitionService
				.getInstance()
				.getPartitionScopeProvider(
						project,
						connection,
						com.sap.mi.fwk.IPartitionScopeProvider.PartitionScope.INNER);
		QueryScopeProvider queryScopeProvider = QueryService.getInstance()
				.getQueryScopeProvider(partitionScopeProvider);
		MQLResultSet librarySet = connection
				.getMQLProcessor()
				.execute(
						"select t from test::reference::Library as t", queryScopeProvider); //$NON-NLS-1$
		MQLResultSet studentSet = connection
				.getMQLProcessor()
				.execute(
						"select t from test::enumeration::Student as t", queryScopeProvider); //$NON-NLS-1$
		MQLResultSet expressionContainerSet = connection
				.getMQLProcessor()
				.execute(
						"select t from test::expression::ExpressionContainer as t", queryScopeProvider); //$NON-NLS-1$
		MQLResultSet addressablePersonSet = connection
				.getMQLProcessor()
				.execute(
						"select t from test::inheritance::AddressablePerson as t", queryScopeProvider); //$NON-NLS-1$

		List<ITreeNode<?>> children = new ArrayList<ITreeNode<?>>();

		for (RefObject ro : librarySet.getRefObjects("t")) {
			//$NON-NLS-1$
			children.add(new GenericRefObjectNode(parent, ro));
		}

		for (RefObject ro : studentSet.getRefObjects("t")) {
			//$NON-NLS-1$
			children.add(new GenericRefObjectNode(parent, ro));
		}

		for (RefObject ro : expressionContainerSet.getRefObjects("t")) {
			//$NON-NLS-1$
			children.add(new GenericRefObjectNode(parent, ro));
		}

		for (RefObject ro : addressablePersonSet.getRefObjects("t")) {
			//$NON-NLS-1$
			children.add(new GenericRefObjectNode(parent, ro));
		}

		return children;
	}

	@Override
	public List<MofClass> getTopLevelModelElementTypes(Connection connection) {
		if (connection == null) {
			return Collections.emptyList();
		} else if (topLevelModelElementTypes == null) {
			List<MofClass> types = new ArrayList<MofClass>(1);
			types.add(connection.getClass(Library.CLASS_DESCRIPTOR)
					.refMetaObject());
			types.add(connection.getClass(Student.CLASS_DESCRIPTOR)
					.refMetaObject());
			types.add(connection.getClass(ExpressionContainer.CLASS_DESCRIPTOR)
					.refMetaObject());
			types.add(connection.getClass(Manager.CLASS_DESCRIPTOR)
					.refMetaObject());
			types.add(connection.getClass(Employee.CLASS_DESCRIPTOR)
					.refMetaObject());
			topLevelModelElementTypes = types;
		}
		return topLevelModelElementTypes;
	}

	@Override
	public String getPartionFolderName() {
		return "src";
	}

	@Override
	public String getPartitionExtension() {
		return "types";
	}

}
