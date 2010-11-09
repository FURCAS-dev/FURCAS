package com.sap.ide.cts.editor.test.util;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.junit.BeforeClass;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.TCSPackage;
import com.sap.furcas.test.util.TcsTestHelper;
import com.sap.ide.cts.editor.contentassist.TcsModelElementFactory;
import com.sap.ide.cts.editor.contentassist.TcsModelElementMoinFactory;

public abstract class ConcreteSyntaxBasedTest extends MetamodelBasedTest {

	protected ConcreteSyntax syntax;

	protected static TCSPackage tcsPackage;

	protected static TcsModelElementFactory modelFactory;

	@BeforeClass
	public static void initPackageAndModelFactory() {
		tcsPackage = connection.getPackage(TCSPackage.PACKAGE_DESCRIPTOR);
		assertNotNull(tcsPackage);

		modelFactory = new TcsModelElementMoinFactory(connection);
		assertNotNull(modelFactory);
	}

	protected void initSyntax(InputStream languageTcsFile) {
		assertNotNull(connection);

		syntax = TcsTestHelper.getSyntaxFromStream(languageTcsFile, connection,
				MOINTCSMeytaConnectionProvider
						.getPartitionsOfMetamodel(metamodelId), null);

		assertNotNull(syntax);
	}
}
