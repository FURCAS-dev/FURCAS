package com.sap.ide.moftool.editor.core.ui.wizards.plugin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.UUID;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.osgi.framework.Bundle;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;

public class PluginProjectGenerator implements IRunnableWithProgress {

	private static final String METAMODEL_MAIN_PROJECT_NAME = "$METAMODEL_MAIN_PROJECT_NAME$"; //$NON-NLS-1$
	private static final String MAIL_RESPONSIBLE = "$MAIL_RESPONSIBLE$"; //$NON-NLS-1$
	private static final String CSN_COMPONENT = "$CSN_COMPONENT$"; //$NON-NLS-1$
	private static final String CSN_COMPONENT_BC = "BC"; //$NON-NLS-1$
	private static final String WRAPPER_PLUGIN_ID = "$WRAPPER_PLUGIN_ID$"; //$NON-NLS-1$
	private static final String VENDOR = "$VENDOR$"; //$NON-NLS-1$
	private static final String METAMODEL_DC_NAME = "$METAMODEL_DC_NAME$"; //$NON-NLS-1$
	private static final String METAMODEL_NAME = "$METAMODEL_NAME$"; //$NON-NLS-1$
	// <sw28012009> removed to fix CSN 0120061532 0000566975 2009
	//	private static final String EXPORT_PACKAGES = "$EXPORT_PACKAGES$"; //$NON-NLS-1$
	// </sw28012009>
	private static final String VENDOR_NAME = "$VENDOR_NAME$"; //$NON-NLS-1$
	private static final String METAMODEL_GUID_PACKAGE = "$METAMODEL_GUID_PACKAGE$"; //$NON-NLS-1$
	private static final String INFO_FILE_UUID = "$INFO_FILE_UUID$"; //$NON-NLS-1$

	private final ArrayList<File> mPerforceFiles = new ArrayList<File>(8);

	private JaProPluginData mData = null;

	public PluginProjectGenerator(JaProPluginData data) {
		super();
		mData = data;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		try {
			monitor.beginTask(LocalizationMessages.PluginProjectGenerator_0_XMSG, 30);

			// Folder to retrieve templates
			monitor.subTask(LocalizationMessages.PluginProjectGenerator_1_XMSG);
			Bundle bundle = Platform.getBundle(MOFToolEditorPlugin.ID);
			URL url = FileLocator.toFileURL(FileLocator.find(bundle, new Path("resources/templates"), null)); //$NON-NLS-1$
			File templateFolder = new Path(url.toString()).setDevice(null).makeRelative().toFile();

			// Location for new plugin main project
			String pluginMainProjectLocation = mData.getPluginMainProjectLocation();

			// Name for new plugin main project
			String pluginMainProjectName = new Path(mData.getMetamodelMainProjectLocation()).lastSegment();
			monitor.worked(3);
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}

			// Create new main project
			monitor.subTask(LocalizationMessages.PluginProjectGenerator_2_XMSG);

			// Parts of main project that are also needed for subproject creation
			File mainProjectFolder = new File(pluginMainProjectLocation);
			mainProjectFolder.mkdirs();
			// Codeline folder
			File codelineFolder = new File(mainProjectFolder, mData.getPluginCodeline());
			codelineFolder.mkdir();
			// src folder
			File srcFolder = new File(codelineFolder, "src"); //$NON-NLS-1$
			srcFolder.mkdir();
			monitor.worked(6);
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}

			// Parts of main project that are only needed when creating a new main project
			if (mData.isCreateNewPluginMainProject()) {
				monitor.subTask(LocalizationMessages.PluginProjectGenerator_3_XMSG);
				// cfg folder
				File cfgFolder = new File(codelineFolder, "cfg"); //$NON-NLS-1$
				cfgFolder.mkdir();
				monitor.worked(7);
				// build.japro
				File file = new File(cfgFolder, "build.japro"); //$NON-NLS-1$
				file.createNewFile();
				mPerforceFiles.add(file);
				copyFile(new File(templateFolder, "main/build.japro"), file); //$NON-NLS-1$
				monitor.worked(8);
				// compile.cfg
				file = new File(cfgFolder, "compile.cfg"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "main/compile.cfg"), file); //$NON-NLS-1$
				monitor.worked(9);
				// import.lst
				file = new File(cfgFolder, "import.lst"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "main/import.lst"), file); //$NON-NLS-1$
				replaceInFile(file, METAMODEL_MAIN_PROJECT_NAME, pluginMainProjectName);
				monitor.worked(10);
				// macros.lst
				file = new File(cfgFolder, "macros.lst"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "main/macros.lst"), file); //$NON-NLS-1$
				monitor.worked(11);
				// <project name>.prop
				file = new File(cfgFolder, pluginMainProjectName + ".prop"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "main/projectname.prop"), file); //$NON-NLS-1$
				replaceInFile(file, MAIL_RESPONSIBLE, mData.getMailResponsible());
				replaceInFile(file, CSN_COMPONENT, mData.getCsnComponent());
				monitor.worked(12);
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
			}

			// Create subproject
			{
				monitor.subTask(LocalizationMessages.PluginProjectGenerator_4_XMSG);
				File subprojectFolder = new File(srcFolder, "_" + mData.getPluginId()); //$NON-NLS-1$
				subprojectFolder.mkdir();
				monitor.worked(13);
				// cfg folder
				File cfgFolder = new File(subprojectFolder, "cfg"); //$NON-NLS-1$
				cfgFolder.mkdir();
				monitor.worked(14);
				// build.japro
				File file = new File(cfgFolder, "build.japro"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "sub/build.japro"), file); //$NON-NLS-1$
				replaceInFile(file, WRAPPER_PLUGIN_ID, mData.getPluginId());
				monitor.worked(15);
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				// import.lst
				file = new File(cfgFolder, "import.lst"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "sub/import.lst"), file); //$NON-NLS-1$
				replaceInFile(file, METAMODEL_MAIN_PROJECT_NAME, pluginMainProjectName);
				replaceInFile(file, VENDOR, mData.getVendor());
				replaceInFile(file, METAMODEL_DC_NAME, mData.getMetamodelDcName());
				monitor.worked(16);
				// project.info
				file = new File(cfgFolder, "project.info"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "sub/project.infoTemplate"), file); //$NON-NLS-1$
				replaceInFile(file, METAMODEL_NAME, mData.getMetamodelName());
				monitor.worked(17);
				// subproject.prop
				file = new File(cfgFolder, "subproject.prop"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "sub/subproject.prop"), file); //$NON-NLS-1$
				replaceInFile(file, MAIL_RESPONSIBLE, mData.getMailResponsible());
				monitor.worked(18);
				// ecp folder
				File ecpFolder = new File(subprojectFolder, "ecp"); //$NON-NLS-1$
				ecpFolder.mkdir();
				monitor.worked(19);
				// ecp/api folder
				file = new File(ecpFolder, "api"); //$NON-NLS-1$
				file.mkdir();
				monitor.worked(20);
				// ecp/bin folder
				file = new File(ecpFolder, "bin"); //$NON-NLS-1$
				file.mkdir();
				monitor.worked(21);
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				// ecp/core folder
				file = new File(ecpFolder, "core"); //$NON-NLS-1$
				file.mkdir();
				monitor.worked(22);
				// build.properties
				file = new File(ecpFolder, "build.properties"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "sub/build.properties"), file); //$NON-NLS-1$
				monitor.worked(23);
				// plugin.properties
				file = new File(ecpFolder, "plugin.properties"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "sub/plugin.properties"), file); //$NON-NLS-1$
				replaceInFile(file, METAMODEL_NAME, mData.getMetamodelName());
				replaceInFile(file, VENDOR_NAME, mData.getVendorName());
				monitor.worked(24);

				// plugin.info
				file = new File(ecpFolder, "plugin.info"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "sub/plugin.infoTemplate"), file); //$NON-NLS-1$
				replaceInFile(file, METAMODEL_NAME, mData.getMetamodelName());
				replaceInFile(file, VENDOR_NAME, mData.getVendorName());
				replaceInFile(file, INFO_FILE_UUID, generateUUID());
				String csnComponent = CSN_COMPONENT_BC;
				if (mData.getCsnComponent() != null && mData.getCsnComponent().length() >= 2) {
					csnComponent = mData.getCsnComponent().substring(0, 2);
				}
				replaceInFile(file, CSN_COMPONENT, csnComponent);
				replaceInFile(file, VENDOR_NAME, mData.getVendorName());
				replaceInFile(file, MAIL_RESPONSIBLE, mData.getMailResponsible());
				monitor.worked(25);

				// plugin.xml
				file = new File(ecpFolder, "plugin.xml"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				file.createNewFile();
				copyFile(new File(templateFolder, "sub/plugin.xml"), file); //$NON-NLS-1$
				replaceInFile(file, METAMODEL_GUID_PACKAGE, mData.getMetamodelGuidPackage());
				monitor.worked(26);
				// ecp/META-INF folder
				File metaInfFolder = new File(ecpFolder, "META-INF"); //$NON-NLS-1$
				mPerforceFiles.add(file);
				metaInfFolder.mkdir();
				monitor.worked(27);
				// MANIFEST.MF
				file = new File(metaInfFolder, "MANIFEST.MF"); //$NON-NLS-1$
				file.createNewFile();
				copyFile(new File(templateFolder, "sub/MANIFEST.MF"), file); //$NON-NLS-1$
				replaceInFile(file, METAMODEL_NAME, mData.getMetamodelName());
				replaceInFile(file, WRAPPER_PLUGIN_ID, mData.getPluginId());

				// metamodel builder takes care of writing export entry
				// replaceInFile(file, EXPORT_PACKAGES, mData.getExportPackages());
				// <sw28012009> removed to fix CSN 0120061532 0000566975 2009
				//				replaceInFile(file, EXPORT_PACKAGES, ""); //$NON-NLS-1$
				// </sw28012009>

				monitor.worked(28);
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
			}
		} catch (IOException e) {
			MOFToolEditorPlugin.logError(e);
			return;
		}
	}

	public ArrayList<File> getNewFiles() {
		return mPerforceFiles;
	}

	private void copyFile(File in, File out) throws IOException {
		FileChannel sourceChannel = new FileInputStream(in).getChannel();
		FileChannel destinationChannel = new FileOutputStream(out).getChannel();
		sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
		sourceChannel.close();
		destinationChannel.close();
	}

	private void replaceInFile(File file, String oldString, String newString) throws IOException {
		// Read source file
		FileInputStream fileInputStream = new FileInputStream(file);
		String content = null;
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[bufferedInputStream.available()];
		int length = 0;
		while ((length = bufferedInputStream.read(buffer)) != -1) {
			byteArrayOutputStream.write(buffer, 0, length);
		}
		content = byteArrayOutputStream.toString("UTF-8"); //$NON-NLS-1$
		byteArrayOutputStream.close();
		bufferedInputStream.close();
		fileInputStream.close();

		// Replace
		int index = content.indexOf(oldString);
		while (index != -1) {
			content = content.substring(0, index) + newString + content.substring(index + oldString.length());
			index = content.indexOf(oldString);
		}

		// Write target file
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		bufferedOutputStream.write(content.getBytes("UTF-8")); //$NON-NLS-1$
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
		fileOutputStream.close();
	}

	public static String generateUUID() {
		final StringBuffer result = new StringBuffer();
		result.append("time:"); //$NON-NLS-1$
		result.append(System.currentTimeMillis());
		result.append("_uuid:"); //$NON-NLS-1$
		result.append(UUID.randomUUID());
		return result.toString();
	}
}
