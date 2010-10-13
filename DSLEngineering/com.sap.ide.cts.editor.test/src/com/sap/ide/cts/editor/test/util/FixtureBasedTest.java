package com.sap.ide.cts.editor.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.junit.Before;


/**
 * Base class for fixture based tests which require the cts.test.fixture 
 * 
 * @author C5126871
 *
 */
public class FixtureBasedTest extends ProjectConnectionBasedTest {
	
	protected ResourceSet connection;
	
	@Before
	public void initialize() {
		connection = createConnection();
	}
		
	@Override
	public String getProjectName() {
		return "NgpmTestResults";
	}
	
	@Override
	public InputStream getProjectContentAsStream() {
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream result;

		try {
			result = new PipedInputStream(pos);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		final ZipOutputStream zos = new ZipOutputStream(pos);

		new Thread("Text Fixture ZIP Stream Copier") {
			@Override
			public void run() {
				try {
					List<String> fixtureFilePaths = FixtureFilesLocator
							.getFixtureFilePaths();
					if (fixtureFilePaths != null) {
						for (String fixtureFilePath : fixtureFilePaths) {
							InputStream inputStream = FixtureFilesLocator
									.getFixtureFileStream(fixtureFilePath);

							if (inputStream != null) {

								// fixtures come in as
								// bin/fixtures/<CUSTOM>/FixtureFiles
								// and should go into zip as src/FixtureFiles
								// all merged together
								String zipPath = "src/"
										+ new Path(fixtureFilePath)
												.removeFirstSegments(3)
												.toString();

								ZipEntry ze = new ZipEntry(zipPath);
								zos.putNextEntry(ze);
								byte[] buf = new byte[4096];
								int read = inputStream.read(buf);
								while (read != -1) {
									zos.write(buf, 0, read);
									read = inputStream.read(buf);
								}
							}
						}
					}
					zos.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}.start();

		return result;
	}

}
