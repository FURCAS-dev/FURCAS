package com.sap.tc.logging.tools.lv;

/*
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2003
 * Company:      SAP AG.
 *               Walldorf, Germany
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @author			 Robert Boban	
 */

import java.io.*;
import java.text.*;
import java.util.*;

import com.sap.tc.logging.*;
import com.sap.tc.logging.interfaces.*;
import com.sap.tc.logging.reader.*;
import com.sap.tc.logging.exceptions.*;

class LVReader {
	
	//================================================ declaration > ====
		
	private static final Location console = Location.getLocation("std", "tc~logging~java", "BC-JAS-ADM-LOG-API");

	private static final String LISTFORMATTER_VERSION_TAG = "#1.5",
															SPACE 										= " ";
															
	private static final int ALIGN_LEFT 	= 1,
													 ALIGN_CENTER = 2,
													 ALIGN_RIGHT 	= 3;

	private static final SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss.SSS");
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	
	private static final boolean debug = false;
	
	private LVOptions lvOptions = null;
	
	private boolean isStdOut 	 = false,
									isStdError = false;
									
	private File[] 			logDirectory;
	private IReadLog[] 	file;
	
	private static PrintWriter out;
	
	private final ListFormatter formatter = new ListFormatter();

	
	//==== < declaration ============================ constructors > ====
	
	public LVReader (LVOptions lvOptions) throws Exception {
		this.lvOptions = lvOptions;
		out = lvOptions.outSystem;
		init();
	}
	
	//==== < constructors =============================== abstarct > ====
	//==== < abstract ===================================== public > ====
	//==== < public ==================================== protected > ====
	//==== < protected =================================== default > ====
	//==== < default ===================================== private > ====
	//==== < private ================================== deprecated > ====
	
	private void init() throws Exception {
		
		// Set Reading file...
		Vector fileList = new Vector();
		
		for (int i = 0; i < lvOptions.readFileName.length; i++) {
			
			File logDirFile = new File(lvOptions.readFileName[i]);
			
			File[] fileForRead = null;
			// check
			if (logDirFile.exists() && logDirFile.isDirectory()) {
				fileForRead = logDirFile.listFiles(new LVFileFilter());
			}
			else {
				fileForRead = new File[] {logDirFile};
			}
			
			for (int fCnt = 0; fCnt < fileForRead.length; fCnt++) {
				//open file for reading
				fileList.add(ReadableLog.createFileReadLog(fileForRead[fCnt].toString()));
			}	
		}
		
		if (!fileList.isEmpty()) {
			file = (IReadLog[]) fileList.toArray(new IReadLog[0]);
		}
		
		
		// Set out file...
		if (lvOptions.outFileName != null) {
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter(lvOptions.outFileName)));
			}
			catch (Throwable th) {
				throw new LVException(MSGCollection.LOGGING_MSG_ID_LV_INVALID_OPTION, 
															MSGCollection.LOGGING_MSG_STR_LV_INVALID_OPTION, 
															new Object [] {"outfile", lvOptions.outFileName}, th);
			}
		}
		
	}
	
	public void read()throws LVException {
		
		String fileToOpen = null;
		
		try {
			
			for (int i = 0; i < file.length; i++) {
				fileToOpen = file[i].getSource();
				file[i].open();
				// If Tail is On go to the end
				if (lvOptions.isTail) {
					file[i].moveToEOF();	
				}           
				else {
					file[i].moveToBOF();
				}
			}
				
			while (true) {
			
				//	Read all records. 
				readRecords();
	
				// exit in batch mode. 
				if (lvOptions.isBatchMode) {
					return;
				}
				else {
					Thread.sleep(400);
				}
			}
		}
		catch (OpenException ex) {
			throw new LVException(MSGCollection.LOGGING_MSG_ID_FILE_NOT_FOUND, 
														MSGCollection.LOGGING_MSG_STR_FILE_NOT_FOUND, 
														new Object [] {fileToOpen},
														ex);
		}
		catch (Exception ex) { 
			throw new LVException(MSGCollection.LOGGING_MSG_ID_UNEXPECTED, 
														MSGCollection.LOGGING_MSG_STR_UNEXPECTED, 
														new Object [] {"LV Tool"},
														ex);
		}
	}
	
	public LVOptions getLVOptions() {
		return lvOptions;
	}
	
	protected void setLVOptions(LVOptions lvOptions) {
		this.lvOptions = lvOptions;
	}
	
	public void readRecords() throws Exception {
			
		int 		i 				= 0;
		String 	fileIndex	= null;
		ILoggingResultSet rs = null;
		
		for (i = 0; i < file.length; i++) {
			
			if (lvOptions.isIndexed) {
				fileIndex = (file.length > 1) ? "F:" + (i + 1) + "/" + file.length + " -" : null;
			}
			
			file[i].open();
			
			while (!file[i].isEOF()) {
				rs = file[i].readNext();
				if (rs.getSize() > 0) {
					parseMSG(fileIndex, (LogRecord) rs.getResults().get(0), true);				
				}
			}
		}
	}
	
	private void parseMSG (String fileIndex, LogRecord record, boolean isLoggingAPI) throws Exception {
		
		if (record == null) return;
		
		if (isLoggingAPI) {
			isLoggingAPI = false;
		}
		else {
			if (isStdOut) {
				record = console.infoT("[stdout] " 	+ record.getMsgClear());
			}
			else if (isStdError) {
				record = console.errorT("[stderr] " + record.getMsgClear());
			}
			else {
				record = console.infoT("[std] " 		+ record.getMsgClear());
			}
		}
		
		printRecord(fileIndex, record);
	}
		
	void printRecord(String fileIndex, LogRecord record) throws Exception
	{
		Date date = record.getTime();
		int width = 0;
		boolean printRec = true;
		
		// ***************************
		// 	FILTER CHECK
		// ***************************
		
		// SEVERITY		
		if (lvOptions.filSeverity > 0 
		&& (record.getSeverity() < lvOptions.filSeverity)) return;
		// DATE		
		if (lvOptions.filDate != null
		&& (date.compareTo(dateFormatter.parse(lvOptions.filDate)) < 0)) return;
		// LOCATION		
		if (lvOptions.filLocation != null 
		&& (!record.getLocationName().equalsIgnoreCase(lvOptions.filLocation))) return;
		// CATEGORY		
		if (lvOptions.filCategory != null 
		&& (!LVFormatter.getCategory(record).equalsIgnoreCase(lvOptions.filCategory))) return;
		
		// ***************************
		
		StringBuffer buf 				= new StringBuffer(lvOptions.format);		
		int patternLen 					= lvOptions.format.length();

		if (fileIndex != null) out.print(LVFormatter.printString(fileIndex, 9, LVFormatPattern.ALIGN_LEFT));

		out.println(lvOptions.formatter.format(record));
	
		out.flush();
	}
	
	class LVFileFilter implements FileFilter {
		public boolean accept(File pathname) {
			return !pathname.exists() || pathname.isFile();
		}
}

}
