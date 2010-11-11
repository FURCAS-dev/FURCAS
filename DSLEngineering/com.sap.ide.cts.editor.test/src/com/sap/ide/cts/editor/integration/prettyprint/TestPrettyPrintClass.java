package com.sap.ide.cts.editor.integration.prettyprint;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.ide.cts.editor.prettyprint.TcsPrettyPrinterTestHelper;
import com.sap.ide.cts.editor.prettyprint.imported.SyntaxAndModelMismatchException;

public class TestPrettyPrintClass extends CtsPrettyPrinterIntegrationTestBase {

	NgpmPackage ngpmPackage;

	@Before
	public void init() {
		ngpmPackage = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);

		initSyntax("Class");
	}

	@Test
	public void testAssociation() throws SyntaxAndModelMismatchException {
		final SapClass clazz = (SapClass) ngpmPackage.getData().getClasses()
				.getSapClass().refCreateInstance();
		clazz.setName("Humba");
		clazz.setValueType(false);
		Association assoc = (Association) ngpmPackage.getData().getClasses()
				.getAssociation().refCreateInstance();
		assoc.setName("unnamed");

		AssociationEnd a1 = (AssociationEnd) ngpmPackage.getData().getClasses()
				.getAssociationEnd().refCreateInstance();
		a1.setName("a1");
		a1.setNavigable(true);

		AssociationEnd a2 = (AssociationEnd) ngpmPackage.getData().getClasses()
				.getAssociationEnd().refCreateInstance();
		a2.setContributesToEquality(true);
		a2.setName("unnamed");
		a2.setNavigable(false);

		ClassTypeDefinition a1ctd = (ClassTypeDefinition) ngpmPackage.getData()
				.getClasses().getClassTypeDefinition().refCreateInstance();
		a1ctd.setLowerMultiplicity(0);
		a1ctd.setUpperMultiplicity(1);
		// a1ctd.setOrdered(true);
		// a1ctd.setUnique(true);
		a1ctd.setClazz(findClass("Class1"));

		ClassTypeDefinition a2ctd = (ClassTypeDefinition) ngpmPackage.getData()
				.getClasses().getClassTypeDefinition().refCreateInstance();
		a2ctd.setLowerMultiplicity(0);
		a2ctd.setUpperMultiplicity(-1);
		// a2ctd.setOrdered(true);
		// a2ctd.setUnique(true);
		a2ctd.setClazz(clazz);
		a1.setType(a1ctd);
		a2.setType(a2ctd);
		assoc.getEnds().add(a1);
		assoc.getEnds().add(a2);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(
				clazz, syntax, new ClassParserFactory());
		assertOutput(output, "Association");
	}

	@Test
	public void testBoolean() throws SyntaxAndModelMismatchException {

		SapClass clazz = findClass("Boolean");
		assertNotNull(clazz);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(
				clazz, syntax, new ClassParserFactory());
		assertOutput(output, "Boolean");
	}

	@Test
	public void testNumber() throws SyntaxAndModelMismatchException {

		SapClass clazz = findClass("Number");
		assertNotNull(clazz);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(
				clazz, syntax, new ClassParserFactory());
		assertOutput(output, "Number");
	}

	@Test
	public void testMonthAndYear() throws SyntaxAndModelMismatchException {

		SapClass clazz = findClass("MonthAndYear");
		assertNotNull(clazz);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(
				clazz, syntax, new ClassParserFactory());
		assertOutput(output, "MonthAndYear");
	}

	@Test
	public void testOrganization() throws SyntaxAndModelMismatchException {

		SapClass clazz = findClass("Organization");
		assertNotNull(clazz);

		TextBlock output = TcsPrettyPrinterTestHelper.prettyPrintTextBlock(
				clazz, syntax, new ClassParserFactory());
		assertOutput(output, "Organization");
	}

	private SapClass findClass(String classname) {
		MQLProcessor mql = connection.getMQLProcessor();
		MQLResultSet queryResult = mql.execute(
				"select c from data::classes::SapClass as c where for c(name='"
						+ classname + "')", mql.getQueryScopeProvider(
				/* scopeInclusive */false, /* partitionScope */
				null, (String[]) null));
		SapClass clazz = (SapClass) queryResult.getRefObjects("c")[0];
		return clazz;
	}

}
