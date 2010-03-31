package com.sap.mi.fwk.test;

import java.util.Collection;

import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.fwk.test.service.TestUtil;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for methods of {@link MetamodelManager}, except <code>import</code> (see
 * {@link ImportMetamodelTest}).
 * 
 * @author d031150
 */
public class MetamodelManagerTest extends ProjectBasedTest {

	private static final String DC_NAME = "test/metamodelmanager";
	private final MetamodelManager mmManager = MetamodelManager.getInstance();

	public MetamodelManagerTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Override
	protected String[] getMetamodels() {
		return new String[] { WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO };
	}

	public void testGetDeployedMetamodels() {
		Collection<MmDeploymentInfo> imported = mmManager.getDeployedMetamodels();

		assertTrue("Metamodel '" + WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO + "' not deployed",
				imported.size() > 0);
	}

	public void testGetImportedMetamodels() {
		Collection<MmDeploymentInfo> imported = mmManager.getImportedMetamodels();

		assertTrue("Metamodel '" + WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO + "' not imported",
				imported.size() > 0);
	}

	public void testIsMetamodelImported() {
		boolean imported = mmManager.isMetamodelImported(WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO);
		assertTrue("Metamodel '" + WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO + "' not imported", imported);
	}

	public void testIsMetamodelImportedSpecials() {
		boolean imported = mmManager.isMetamodelImported(TestUtil.CONTAINER_NAME_MOF, "");
		assertTrue("Special names for MOF and dummy entry must be ignored", imported);

		String mmNameWrong = "someMetamodelNameThatReallyShouldNotExist";
		imported = mmManager.isMetamodelImported(TestUtil.CONTAINER_NAME_MOF, "", mmNameWrong);
		assertFalse(mmNameWrong + " should not be imported", imported);
	}

}
