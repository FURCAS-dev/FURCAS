package com.sap.mi.textual.moin.standalone.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import ngpm.NgpmPackage;

import org.junit.Test;

import tcs.TcsPackage;
import test.TestPackage;

import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;

import finex.FinexPackage;

public class TestOtherMetamodelStandaloneConnection {

	@Test
	public void TcsMetamodelLoaded() {
		Connection con = MOINTCSMetaConnectionProvider.getTestConnection();

		TcsPackage tcsPackage = con.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
		assertNotNull(tcsPackage);

		Set<PRI> partitions = MOINTCSMetaConnectionProvider
				.getPartitionsOfMetamodel("demo.sap.com/tcsmeta");

		boolean found = false;
		for (PRI pri : partitions) {
			if (pri.getPartitionName().endsWith("textblocks.moinmm")) {
				found = true;
			}
		}

		assertTrue(found);
	}

	@Test
	public void NgpmMetamodelLoaded() {
		Connection con = MOINTCSMetaConnectionProvider.getTestConnection();

		NgpmPackage ngpmPackage = con
				.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		assertNotNull(ngpmPackage);
	}

	@Test
	public void EditorTestMetamodelLoaded() {
		Connection con = MOINTCSMetaConnectionProvider.getTestConnection();

		TestPackage testPackage = con
				.getPackage(TestPackage.PACKAGE_DESCRIPTOR);
		assertNotNull(testPackage);
	}

	@Test
	public void FinexMetamodelLoaded() {
		Connection con = MOINTCSMetaConnectionProvider.getTestConnection();

		FinexPackage finexPackage = con
				.getPackage(FinexPackage.PACKAGE_DESCRIPTOR);
		assertNotNull(finexPackage);
	}
}
