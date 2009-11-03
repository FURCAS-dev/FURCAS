package com.sap.mi.fwk.services.local;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileServices {

	/**
	 * Returns the path to the user temp directory.
	 * @return The path to the user temp directory.
	 */
	public static String getTempDir() {
		return System.getProperty("java.io.tmpdir");//$NON-NLS-1$
	}
	
	/**
	 * @param fileName
	 * @param inputStream
	 */
	public static void streamToFile(String fileName, InputStream inputStream) {
		File f = new File(fileName);
		try {
			if (f.exists()) {
				f.delete();
			}
			if (!f.exists()) {
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			BufferedOutputStream bf = new BufferedOutputStream(fos);
			inputStreamToOutputStream(inputStream, bf);
			bf.close();
		} catch (IOException eio) {
			throw new RuntimeException("streamToFile" + fileName, eio);//$NON-NLS-1$
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
