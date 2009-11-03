package com.sap.mi.fwk.test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.Properties;

import com.sap.ide.dii05.model.api.IDcMetadataState;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.junit.extensions.ExtendedTestCase;
import com.sap.mi.fwk.dcfwk.DCHelper;

public class DCHelperTest extends ExtendedTestCase {

	public void testDCHelper() {
		DCHelper helper = DCHelper.getInstance();

		IDcMetadataState mockState = createMock(IDcMetadataState.class);
		IDevelopmentComponent mockDc = createMock(IDevelopmentComponent.class);

		expect(mockDc.getName()).andReturn("name");
		expect(mockDc.getVendor()).andReturn("vendor");
		expect(mockDc.getDisplayName()).andReturn("desc");
		expect(mockDc.getLocalState()).andReturn(mockState);
		expect(mockState.getDescription()).andReturn(null);

		replay(mockDc, mockState);

		Properties result = (Properties) runNonPublicMethod(helper, "getDCInfoInternal", new Class[] { IDevelopmentComponent.class },
				new Object[] { mockDc });

		assertEquals("name", result.get(DCHelper.NAME));
		assertEquals("vendor", result.get(DCHelper.VENDOR));
		assertEquals("desc", result.getProperty(DCHelper.DESCRIPTION));
	}
}
