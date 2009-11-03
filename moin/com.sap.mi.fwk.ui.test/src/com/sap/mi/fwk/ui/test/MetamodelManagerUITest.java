package com.sap.mi.fwk.ui.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkingSet;

import com.sap.ide.junit.ui.lift.FactoryBuilder;
import com.sap.ide.junit.ui.lift.LFactory;
import com.sap.ide.junit.ui.lift.LRunnable;
import com.sap.ide.junit.ui.lift.LShell;
import com.sap.ide.junit.utils.PDEUtil;
import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.test.service.MetamodelBasedTest;
import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests {@link MetamodelManagerUI} class
 * 
 * @author d031150
 */
public class MetamodelManagerUITest extends MetamodelBasedTest {

	private static final String MM_CONTAINER_GFW = "sap.com/com/sap/mi/gfw/mm";

	private LFactory mAbbotFactory;
	private LShell mShell;

	private MetamodelManagerUI mManager;

	public MetamodelManagerUITest() {
		super(MetamodelManagerUITest.class.getName());
	}

	@Override
	protected String[] getMetamodels() {
		return new String[] { WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO, MM_CONTAINER_GFW };
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		PDEUtil.prepareWorkbench();

		mAbbotFactory = FactoryBuilder.newAbbotFactory();
		mAbbotFactory.setWaitTimeout(3000);
		mShell = mAbbotFactory.getShell(Display.getDefault());

		mManager = MetamodelManagerUI.getInstance();
	}

	@Override
	protected void tearDown() throws Exception {
		PDEUtil.hideView(MetamodelManagerUI.ID_DEPLOY_VIEW);

		super.tearDown();
	}

	public void testGetInstance() {
		assertNotNull(mManager);

		MetamodelManager mmManager = MetamodelManagerUI.getMetamodelManager();
		assertNotNull(mmManager);
	}

	public void testShowDeploymentView() throws Exception {
		IViewPart part = mShell.syncExec(new LRunnable<IViewPart>() {
			public IViewPart run() throws Exception {
				return MetamodelManagerUI.getInstance().showDeploymentView();
			}
		});

		assertNotNull("Deployment view must be returned", part);
	}

	public void testShowDeploymentViewNegative() {
		IViewPart nullPart = MetamodelManagerUI.getInstance().showDeploymentView();
		assertNull("Should return null if called from non-UI thread: " + Thread.currentThread().getName(), nullPart);
	}

	public void testCreateWorkingSet() {
		{
			List<MmDeploymentInfo> noMms = Collections.emptyList();
			IWorkingSet workingSet = mManager.createMetamodelWorkingSet(noMms);
			assertNotNull(workingSet);
		}
		{
			Collection<MmDeploymentInfo> mmInfo = getMetamodelInfo();
			IWorkingSet workingSet = mManager.createMetamodelWorkingSet(mmInfo);
			assertNotNull(workingSet);
			IAdaptable[] elements = workingSet.getElements();
			assertEquals("Working set must contain same number of metamodels: " + Arrays.toString(elements), mmInfo
					.size(), elements.length);
		}
	}

	public void testGetWorkingSets() {
		Collection<MmDeploymentInfo> mmInfo = getMetamodelInfo();
		IWorkingSet workingSet = mManager.createMetamodelWorkingSet(mmInfo);
		Collection<IWorkingSet> workingSets = mManager.getMetamodelWorkingSets();

		assertTrue("Created working set must be available: " + workingSets, workingSets.contains(workingSet));
	}

	public void testAddToWorkingSet() {
		List<MmDeploymentInfo> noMms = Collections.emptyList();
		Collection<MmDeploymentInfo> mmInfo = getMetamodelInfo();
		IWorkingSet workingSet = mManager.createMetamodelWorkingSet(noMms);
		// add no elements (better coverage)
		mManager.addToMetamodelWorkingSet(noMms, workingSet);
		mManager.addToMetamodelWorkingSet(mmInfo, workingSet);

		IAdaptable[] elements = workingSet.getElements();
		assertEquals("Working set must contain same number of metamodels: " + Arrays.toString(elements), mmInfo.size(),
				elements.length);
	}

	public void testRemoveFromWorkingSet() {
		List<MmDeploymentInfo> noMms = Collections.emptyList();
		Collection<MmDeploymentInfo> mmInfo = getMetamodelInfo();
		IWorkingSet workingSet = mManager.createMetamodelWorkingSet(noMms);
		// remove elements not contained (better coverage)
		mManager.removeFromMetamodelWorkingSet(mmInfo, workingSet);
		// fill
		mManager.addToMetamodelWorkingSet(mmInfo, workingSet);
		// and remove
		mManager.removeFromMetamodelWorkingSet(mmInfo, workingSet);

		IAdaptable[] elements = workingSet.getElements();
		assertEquals("Working set must be empty: " + Arrays.toString(elements), 0, elements.length);
	}

	public void testStatusInfo() {
		MmDeploymentInfo mmInfo = getMetamodelInfo().iterator().next();
		String status = mManager.getStatusInfo(mmInfo);
		assertNotNull("Status info must not be null for metamodel: " + mmInfo, status);
		assertTrue("Must be a 'Deployed' status: " + status, status.toLowerCase().contains("deployed"));
	}

	private Collection<MmDeploymentInfo> getMetamodelInfo() {
		MetamodelManager mmManager = MetamodelManager.getInstance();
		String[] metamodelNames = getMetamodels();
		Collection<MmDeploymentInfo> metamodels = new ArrayList<MmDeploymentInfo>(metamodelNames.length);
		for (String name : metamodelNames) {
			MmDeploymentInfo metamodel = mmManager.getDeployedMetamodel(name);
			metamodels.add(metamodel);
		}
		return metamodels;
	}

}