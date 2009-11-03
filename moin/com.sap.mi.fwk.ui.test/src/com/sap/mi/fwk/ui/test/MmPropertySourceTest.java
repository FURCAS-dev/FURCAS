package com.sap.mi.fwk.ui.test;

import java.util.Collection;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;

import com.sap.mi.fwk.test.service.MetamodelBasedTest;
import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Test for {@link MmPropertySource}
 * 
 * @author d031150
 */
public class MmPropertySourceTest extends MetamodelBasedTest {

	public MmPropertySourceTest(String name) {
		super(name);
	}

	@Override
	protected String[] getMetamodels() {
		return new String[] { WebDynproProjectTest.CONTAINER_NAME_WEBDYNPRO };
	}

	protected void setUp() throws Exception {
		// This is just to ensure that "com.sap.mi.fwk.ui" plugin is activated.
		// Needed as otherwise no adapters are returned.
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				MetamodelManagerUI.getInstance().showDeploymentView();
			}
		});
	}

	public void testPropertySourceViaAdapter() {
		Collection<MmDeploymentInfo> metamodels = MoinFactory.getMmDeploymentManager().getMetaModelPluginList();

		for (MmDeploymentInfo metamodel : metamodels) {
			IPropertySource source = (IPropertySource) Platform.getAdapterManager().getAdapter(metamodel,
					IPropertySource.class);
			assertNotNull("No property source for metamodel: " + metamodel.getLabel(), //$NON-NLS-1$
					source);

			IPropertyDescriptor[] descs = source.getPropertyDescriptors();
			if (descs.length == 0)
				fail("No property descriptors returned for metamodel: " + metamodel.getLabel()); //$NON-NLS-1$

			// Test all properties if they return a value (do it only for one of
			// our own metamodels
			if ("demo.sap.com/mi/test/metamodel".equals(metamodel.getContainerName())) {
				for (int i = 0; i < descs.length; i++) {
					Object object = source.getPropertyValue(descs[i].getId());
					assertNotNull("No property value for " + descs[i].getId(), object);
				}
			}
		}
	}

}
