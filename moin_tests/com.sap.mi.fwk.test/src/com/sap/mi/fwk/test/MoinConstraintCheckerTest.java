package com.sap.mi.fwk.test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IContributor;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.spi.RegistryContributor;

import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.MarkerManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.MoinConstraintChecker;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;

/**
 * Tests {@link MoinConstraintChecker}
 * 
 * @author d024127
 */
public class MoinConstraintCheckerTest extends ProjectBasedTest implements IContributor {

	private static final String DC_NAME = "test/constraintchecker";

	private static final String MODEL_PACKAGE_NAME = "Model";

	private MofClass mClass;

	public MoinConstraintCheckerTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	public void testSetMarkerType() {
		MoinConstraintChecker checker = new MoinConstraintChecker();
		checker.setMarkerType("new type");
	}

	public void testClean() throws Exception {
		MoinConstraintChecker checker = new MoinConstraintChecker();

		runNonPublicMethod(checker, "setProject", new Class[] { IProject.class }, new Object[] { getProject() });
		runNonPublicMethod(checker, "build", new Class[] { Integer.TYPE, Map.class, IProgressMonitor.class }, new Object[] {
				IncrementalProjectBuilder.FULL_BUILD, null, new NullProgressMonitor() });

		// expected violations: not part of package and abstract class must not
		// be singleton
		IMarker[] result = MarkerManager.getInstance().findMarkers(mClass, IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		long start = System.currentTimeMillis();
		while (result.length == 0 && System.currentTimeMillis() - start < 4000) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException ie) {
			}
			result = MarkerManager.getInstance().findMarkers(mClass, IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		}

		assertTrue("Markers expected", result.length >= 1);

		boolean lastValue = false;

		// for testing purposes final method setProject must be called
		runNonPublicMethod(checker, "clean", new Class[] { IProgressMonitor.class }, new Object[] { new NullProgressMonitor() });

		start = System.currentTimeMillis();
		result = MarkerManager.getInstance().findMarkers(mClass, IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		while (result.length > 0 && System.currentTimeMillis() - start < 4000) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException ie) {
			}
			result = MarkerManager.getInstance().findMarkers(mClass, IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		}

		assertTrue("No markers expected", result.length == 0);

		PDEUtil.setAutoBuilding(lastValue);
	}

	public void testBuild() throws CoreException {

		IFile file = getProject().getFile(".dcdef");
		assertTrue(".dcdef file not found", file.exists());

		MoinConstraintChecker checker = new MoinConstraintChecker();

		runNonPublicMethod(checker, "setProject", new Class[] { IProject.class }, new Object[] { getProject() });
		runNonPublicMethod(checker, "build", new Class[] { Integer.TYPE, Map.class, IProgressMonitor.class }, new Object[] {
				IncrementalProjectBuilder.FULL_BUILD, null, new NullProgressMonitor() });

		// expected violations: not part of package and abstract class must not
		// be singleton
		IMarker[] result = MarkerManager.getInstance().findMarkers(mClass, IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		assertTrue("Markers expected", result.length >= 1);
	}

	public void testCategoryCheck() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<?eclipse version=\"3.2\"?><plugin>"
				+ "<extension point=\"com.sap.mi.fwk.categoryprovider\">" + "<provider class=\"" + String.class.getName()
				+ "\"></provider></extension></plugin>";
		ByteArrayInputStream is = new ByteArrayInputStream(xml.getBytes());
		IExtensionRegistry extRegistry = Platform.getExtensionRegistry();

		// using temporary API since no other api is provided
		Object token = runNonPublicMethod(extRegistry, "getTemporaryUserToken", null, null);
		IContributor contributor = new RegistryContributor("com.sap.mi.fwk", "mi.fwk", "com.sap.mi.fwk", "mi.fwk");
		extRegistry.addContribution(is, contributor, false, null, null, token);

		MoinConstraintChecker checker = new MoinConstraintChecker();

		runNonPublicMethod(checker, "setProject", new Class[] { IProject.class }, new Object[] { getProject() });
		runNonPublicMethod(checker, "build", new Class[] { Integer.TYPE, Map.class, IProgressMonitor.class }, new Object[] {
				IncrementalProjectBuilder.FULL_BUILD, null, new NullProgressMonitor() });

		// expected violations: not part of package and abstract class must not
		// be singleton
		IMarker[] result = MarkerManager.getInstance().findMarkers(mClass, IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		assertTrue("Markers expected", result.length >= 1);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		IProjectDescription description = getProject().getDescription();
		String[] natureIds = description.getNatureIds();
		Set<String> ids = new HashSet<String>(Arrays.asList(natureIds));
		String id = (String) accessNonPublicField(MoinConstraintChecker.class, "MOIN_META_MODEL_NATURE_ID");
		ids.add(id);
		description.setNatureIds(ids.toArray(new String[ids.size()]));
		getProject().setDescription(description, null);

		boolean lastValue = PDEUtil.setAutoBuilding(false);

		Connection connection = createConnection();
		connection.getCommandStack().openGroup("create class");

		PRI pri = ModelManager.getPartitionService().getPRI(getProject(), SOURCE_FOLDER.append("partition.xmi"));
		ModelPartition partition = connection.getPartition(pri);
		if (partition != null) {
			partition.delete();
		}
		partition = connection.createPartition(pri);

		ModelPackage p = (ModelPackage) connection.getPackage(null, MODEL_PACKAGE_NAME);
		mClass = connection.createElement(MofClass.class);
		mClass.setName("test");
		mClass.setVisibility(VisibilityKindEnum.PUBLIC_VIS);
		mClass.setAbstract(true);
		mClass.setSingleton(true);

		partition.assignElement(mClass);
		connection.getCommandStack().closeGroup();
		connection.save();

		PDEUtil.setAutoBuilding(lastValue);
	}
}
