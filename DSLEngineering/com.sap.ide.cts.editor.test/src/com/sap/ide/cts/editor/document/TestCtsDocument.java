/**
 * 
 */
package com.sap.ide.cts.editor.document;


import static org.junit.Assert.assertNotNull;
import ngpm.NgpmPackage;

import org.junit.Test;

import com.sap.ide.cts.editor.test.RunletEditorTest;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * 
 */
// or move it somewhere else, and delete the plugin dependencies that are then
// obsolete.
public class TestCtsDocument extends RunletEditorTest {

	@Test
	public void testTextBlockJMI() {
		final RefPackage rootPkg = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);
		assertNotNull(rootPkg);

		JmiHelper jmihelper = connection.getJmiHelper();
		assertNotNull(jmihelper.findRefPackageByQualifiedName(list("data"), rootPkg));
		assertNotNull(jmihelper.findElementByQualifiedName(list("data",
				"classes", "SapClass"), rootPkg));
		assertNotNull(jmihelper.findElementByQualifiedName(list("behavioral",
				"actions", "Block"), rootPkg));
	}

}
