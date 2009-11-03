package com.sap.ide.cts.editor.test.util;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.junit.BeforeClass;

import tcs.ConcreteSyntax;
import tcs.TcsPackage;

import com.sap.ide.cts.editor.contentassist.TcsModelElementFactory;
import com.sap.ide.cts.editor.contentassist.TcsModelElementMoinFactory;
import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;

public abstract class ConcreteSyntaxBasedTest extends MetamodelBasedTest {

	protected ConcreteSyntax syntax;

	protected static TcsPackage tcsPackage;

	protected static TcsModelElementFactory modelFactory;

	@BeforeClass
	public static void initPackageAndModelFactory() {
		tcsPackage = connection.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
		assertNotNull(tcsPackage);

		modelFactory = new TcsModelElementMoinFactory(connection);
		assertNotNull(modelFactory);
	}

	protected void initSyntax(InputStream languageTcsFile) {
		assertNotNull(connection);

		syntax = TcsTestHelper.getSyntaxFromStream(languageTcsFile, connection,
				MOINTCSMetaConnectionProvider
						.getPartitionsOfMetamodel(metamodelId), null);

		assertNotNull(syntax);
	}
}
