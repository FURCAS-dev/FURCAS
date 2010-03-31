package com.sap.mi.gfw.test.smoke;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;

import com.sap.mi.fwk.test.service.ProjectBasedTest;
import com.sap.mi.gfw.GfwUtil;
import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.eclipse.GraphicsPlugin;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.mm.pictograms.PictogramsPackage;
import com.sap.mi.gfw.platform.IGFWExtensionManager;
import com.sap.mi.gfw.samples.dt.IDiagramTypeConstants;
import com.sap.mi.gfw.util.PackageUtil;
import com.sap.tc.moin.repository.Connection;

/**
 * prerequisite for this test plugin:
 * <p> - moin installation is available
 */
public class SmokeTest extends ProjectBasedTest {

	private static final String DC_NAME = "TESTPROJECT-SmokeTest";

	private static final String MODEL_NAME = "Model";

	private Connection connection;

	public SmokeTest() {
		super(DC_NAME);
	}

	@Override
	protected String getDcName() {
		return DC_NAME;
	}

	@Override
	protected String[] getMetamodels() {
		return new String[] { GfwUtil.METAMODEL_ID };
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		connection = createConnection();
		GraphicsPlugin.getDefault();
	}

	@Override
	protected void tearDown() throws Exception {

		if (connection != null) {
			connection.close();
			connection = null;
		}
		super.tearDown();
	}

	@Override
	protected boolean deleteProjectOnSetUp() {
		return false;
	}

	public void testInstallation() {

		assertNotNull("connection not available", connection);

		PictogramsPackage pictogramsPackage = getPictogramsPackage();
		assertNotNull("pictograms package not available", pictogramsPackage);
		ModelPackage modelPackage = getModelPackage();
		assertNotNull("model package not available", modelPackage);

		IGFWExtensionManager extensionManager = GfwUtil.getExtensionManager();
		assertNotNull("extension manager not available", extensionManager);

		String[] diagramTypeProviders = extensionManager.getDiagramTypeProviderExtensionIds(IDiagramTypeConstants.DIAGRAM_TYPE_ID_MOF);
		assertTrue("diagram type provider not available", diagramTypeProviders.length > 0);

		IDiagramTypeProvider dtp = extensionManager.createDiagramTypeProvider(diagramTypeProviders[0]);
		assertNotNull("diagram type provider couldn't be created", dtp);

		dtp.init(null, null);
		IFeatureProvider fp = dtp.getFeatureProvider();
		assertNotNull("feature provider not available", fp);
	}

	private ModelPackage getModelPackage() {
		// return (ModelPackage) PackageUtil.getPackage(getConnection(),
		// "Model");
		return (ModelPackage) connection.getPackage(null, MODEL_NAME);
	}

	private PictogramsPackage getPictogramsPackage() {
		return PackageUtil.getPictogramsPackage(connection);
	}

}
