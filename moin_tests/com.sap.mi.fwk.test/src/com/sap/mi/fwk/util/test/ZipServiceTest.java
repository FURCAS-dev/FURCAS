package com.sap.mi.fwk.util.test;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.eclipse.core.runtime.Path;

import com.sap.mi.fwk.services.local.FileServices;
import com.sap.mi.fwk.services.local.ZipService;

public class ZipServiceTest extends TestCase {

	private File testDir;
	private File dataDir;
	private File zipFile;
	private File dataFile;

	@Override
	protected void setUp() throws Exception {
		testDir = new File(FileServices.getTempDir() + Path.SEPARATOR + "zipServiceTest");
		dataDir = new File(FileServices.getTempDir() + Path.SEPARATOR + "zipServiceTest" + Path.SEPARATOR + "data");
		
		if (dataDir.exists()) {
			removeDirectory(dataDir);
		}
		dataDir.mkdirs();
		
		zipFile = new File(testDir.getAbsolutePath() + Path.SEPARATOR + "zipFile.zip");
		if (zipFile.exists()) {
			zipFile.delete();
		}
		dataFile = File.createTempFile("data", null, dataDir);
	}

	@Override
	protected void tearDown() throws Exception {
		if (testDir != null) {
			removeDirectory(testDir);
			testDir = null;
		}
		zipFile = null;
		dataFile = null;
	}

	/**
	 * Tests zipping and unzipping of archives using ZipService
	 * 
	 * @throws IOException
	 */
	public void testZipService() throws IOException {
		ZipService.zipDir(zipFile, dataDir);
		assertTrue("Zip file has not been created by zip service", zipFile.exists());
		dataFile.delete();
		assertFalse("Content file " + dataFile.getAbsolutePath() + " must have been deleted", dataFile.exists());
		ZipService.unzipDir(zipFile.getAbsolutePath(), dataDir.getAbsolutePath());
		assertTrue("Content file " + dataFile.getAbsolutePath() + " has not been created by zip service", dataFile.exists());
	}

	private static void removeDirectory(File dirRW) {
		if (dirRW.exists()) {
			File f[] = dirRW.listFiles();
			removeFiles(f);
			dirRW.delete();
		}
		dirRW.delete();
	}

	private static void removeFiles(File[] f) {
		for (int i = 0; i < f.length; ++i) {
			if (f[i].isDirectory()) {
				removeDirectory(f[i]);
			} else {
				removeFile(f[i]);
			}
		}
	}

	private static void removeFile(File f) {
		f.delete();
	}
}
