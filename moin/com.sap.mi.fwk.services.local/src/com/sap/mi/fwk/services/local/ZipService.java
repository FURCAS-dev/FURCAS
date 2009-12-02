/*
 * Created on 10.10.2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sap.mi.fwk.services.local;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Services to zip Files and Directories
 * 
 * @author d026276
 */
public class ZipService {

	public static void zipDir(String zipFilename, String directoryName) throws IOException {
		File zipFile = new File(zipFilename);
		File zipDir = new File(directoryName);
		zipDir(zipFile, zipDir);
	}

	/**
	 * Zip the given existing Directory into the file zipFile
	 * 
	 * @param zipFile
	 * @param directory
	 * @throws IOException
	 */
	public static void zipDir(File zipFile, File directory) throws IOException {
		zipDir(zipFile, directory, directory);
	}

	/**
	 * Zip the given existing Directory into the file zipFile
	 * 
	 * @param zipFile
	 * @param directory
	 * @throws IOException
	 */
	public static void zipDir(File zipFile, File directory, File rootDirectory) throws IOException {
		if (!directory.isDirectory())
			throw new IllegalArgumentException("File "//$NON-NLS-1$
					+ directory.getAbsolutePath() + " is no directory");//$NON-NLS-1$
		if (!directory.exists())
			throw new IllegalArgumentException("Directory "//$NON-NLS-1$
					+ directory.getAbsolutePath() + " doe not exist");//$NON-NLS-1$
		File fileout = zipFile;
		if (!zipFile.exists()) {
			zipFile.createNewFile();
		}
		if (!zipFile.canWrite())
			throw new IllegalStateException("Unable to Open Output file "//$NON-NLS-1$
					+ zipFile.getAbsolutePath());
		FileOutputStream os = new FileOutputStream(fileout);
		ZipOutputStream zo = new ZipOutputStream(os);
		File dir = directory;
		zipDir(zo, dir, rootDirectory);
		zo.close();
		os.close();
	}

	public static void unzipDir(String zipFilename, String targetDirectoryName) throws IOException {
		File zipFile = new File(zipFilename);
		File zipDir = new File(targetDirectoryName);
		unzipDir(zipFile, zipDir);
	}

	public static void unzipDir(File zipFile, File targetDirectory) throws IOException {
		if (!targetDirectory.exists()) {
			targetDirectory.mkdirs();
		}
		if (!targetDirectory.isDirectory())
			throw new IllegalArgumentException("File "//$NON-NLS-1$
					+ targetDirectory.getAbsolutePath() + " is no directory");//$NON-NLS-1$
		ZipFile f = new ZipFile(zipFile);
		Enumeration<? extends ZipEntry> e = f.entries();
		while (e.hasMoreElements()) {
			ZipEntry en = e.nextElement();
			if (en.isDirectory()) {
				File dir = new File(en.getName());
				if (!dir.isAbsolute()) {
					String odirn = targetDirectory.getAbsolutePath() + File.separator + en.getName();
					dir = new File(odirn);
				}
				dir.mkdirs();
			} else {
				String fn = en.getName();
				InputStream is;
				is = f.getInputStream(en);
				String ofn = targetDirectory.getAbsoluteFile() + File.separator + fn;
				File on = new File(ofn);
				on.getPath();
				File pth = new File(on.getParent());
				if (!pth.exists())
					pth.mkdirs();
				FileOutputStream fos = new FileOutputStream(on);

				writeToStream(is, fos);
				fos.close();
			}
		}
		f.close();
	}

	public static void unzipDir(InputStream zipStream, File targetDirectory) throws IOException {

		// copy to temp file

		File tmpf = File.createTempFile("tmp_zip", ".zip", null);//$NON-NLS-1$ //$NON-NLS-2$
		streamToFile(tmpf, zipStream);

		unzipDir(tmpf, targetDirectory);
	}

	public static void unzipDir(InputStream zipis, String targetDirectoryName) throws IOException {
		File zipDir = new File(targetDirectoryName);
		unzipDir(zipis, zipDir);
	}

	private static void writeToStream(InputStream is, OutputStream os) throws IOException {
		byte[] u = new byte[1000];
		int len = 1000;
		while (len > 0) {
			len = is.read(u);
			if (len > 0)
				os.write(u, 0, len);
		}
	}

	private static void zipFile(ZipOutputStream os, File fls) throws IOException {
		FileInputStream fi = new FileInputStream(fls);
		byte[] u = new byte[1000];
		int len = 1000;
		while (len == 1000) {
			len = fi.read(u);
			if (len > 0)
				os.write(u, 0, len);
		}
		fi.close();
	}

	private static void zipDir(ZipOutputStream zo, File dir, File rootDir) throws IOException {
		File fls[] = dir.listFiles();
		zipFile(zo, fls, rootDir);
	}

	private static void zipFile(ZipOutputStream os, File fls[], File rootDir) throws IOException {
		for (int i = 0; i < fls.length; ++i) {
			if (fls[i].isDirectory()) {
				// ZipEntry ze = new ZipEntry(fls[i].getCanonicalPath());
				// os.putNextEntry(ze);
				zipDir(os, fls[i], rootDir);
				// os.closeEntry();
			} else {
				String fn = getZipName(fls[i], rootDir);
				ZipEntry ze = new ZipEntry(fn);
				os.putNextEntry(ze);
				zipFile(os, fls[i]);
				os.closeEntry();

			}
		}
	}

	private static String getZipName(File fn, File rootDir) {
		String fnfull = fn.getAbsolutePath();
		String fnhalf = rootDir.getAbsolutePath();
		fnfull = fnfull.substring(fnhalf.length() + 1);
		return fnfull;
	}

	/**
	 * @param zipfn
	 * @param resourceAsStream
	 */
	private static void streamToFile(File f, InputStream inputStream) {
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			BufferedOutputStream bf = new BufferedOutputStream(fos);
			inputStreamToOutputStream(inputStream, bf);
			bf.close();
		} catch (IOException eio) {
			throw new RuntimeException("streamToFile" + f.getAbsolutePath(), eio);//$NON-NLS-1$
		}
	}

	/**
	 * Copies and Input Stream to an Output Stream
	 * 
	 * @param is
	 * @param os
	 * @throws IOException
	 */
	public static void inputStreamToOutputStream(InputStream is, OutputStream os) throws IOException {
		byte[] u = new byte[2000];
		int len = 2000;
		// note: Chunks may be returned as 2000 2000 10 2000 2000 10
		while (len >= 0) {
			len = is.read(u);
			if (len > 0)
				os.write(u, 0, len);
		}
	}
}
