/**
 * 
 */
package com.sap.mi.textual.moin.standalone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipOutputStream;

import tcs.TcsPackage;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;

/**
 * Provides MOIN connections that have the TCS metamodel registered.
 */
public class MOINTCSMetaConnectionProvider {

    private static Connection myConnection;

    /**
     * used to make sure the metamodels are only zipped once during each test-run
     */
    private static boolean metamodelsZipped = false;

    /**
     * contains information from the metamodel.properties files of the zipped metamodels
     */
    private static Set<MetamodelInfo> metamodelInfos = new HashSet<MetamodelInfo>();

    /**
     * contains the loaded PRIs by metamodel id
     */
    private static Map<String, Set<PRI>> partitionsMap = new HashMap<String, Set<PRI>>();

    /**
     * contains the build moin after processing metamodels
     */
    private static Moin buildMoin = null;

    /**
     * caches the jarpaths after the metamodels have been zipped
     */
    private static String[] jarpaths = null;

    public static Connection getTestConnection() {
	return getTestConnection(getJarPaths());
    }

    public static Connection getTestConnection(String[] jarpaths) {
	if (myConnection == null || !myConnection.isAlive()) {
	    Connection co = StandaloneConnectionFactoryFacade.getMetaModelConnection(jarpaths);
	    co.setLabel("standalone");
	    TcsPackage pack = co.getPackage(TcsPackage.PACKAGE_DESCRIPTOR);
	    if (pack == null) {
		throw new IllegalStateException("Connection could not resolve TCS root package, check paths : "
			+ Arrays.toString(jarpaths));
	    }
	    myConnection = co;
	}
	return myConnection;
    }

    public static Moin getBuildMoin() {
	if (buildMoin == null) {
	    buildMoin = StandaloneConnectionFactoryFacade.getMoin(getJarPaths());
	}
	return buildMoin;
    }

    public static String getSourceRoot(Class<?> c) {
	try {
	    return URLDecoder.decode(c.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8");
	} catch (UnsupportedEncodingException e) {
	    throw new RuntimeException(e);
	}
    }

    private static String getStandaloneProjectPath() {
	// source is in /bin folder
	return getSourceRoot(MOINTCSMetaConnectionProvider.class) + "..\\";
    }

    /**
     * @return
     */
    private static String[] getJarPaths() {

	if (!metamodelsZipped) {

	    List<String> metamodelZipFilenames = zipMetamodels();
	    jarpaths = new String[metamodelZipFilenames.size()];

	    for (int i = 0; i < metamodelZipFilenames.size(); i++) {

		File file = new File(getStandaloneProjectPath() + "mmbuild\\" + metamodelZipFilenames.get(i));
		if (!file.exists()) {
		    throw new IllegalStateException("TCS Metamodel archive file does not exist at " + file.getAbsolutePath());

		}
		jarpaths[i] = file.getAbsolutePath();

	    }
	    metamodelsZipped = true;
	}

	return jarpaths;
    }

    private static List<String> zipMetamodels() {

	List<String> resultZips = new ArrayList<String>();

	File directory = new File(getStandaloneProjectPath() + "\\bin\\metamodels\\");

	if (!directory.exists()) {
	    System.out.println("zipMetamodels cannot find directory " + directory.getAbsolutePath());
	    return resultZips;
	}

	File[] files = directory.listFiles();
	for (File file : files) {
	    try {
		if (file.isDirectory()) {

		    String metamodelZipFileName = file.getName() + "_assmbl.zip";

		    resultZips.add(metamodelZipFileName);

		    File metamodelZip = new File("..\\com.sap.mi.textual.moin.standalone\\mmbuild\\" + metamodelZipFileName);

		    metamodelZip.createNewFile();
		    OutputStream os = new FileOutputStream(metamodelZip);
		    ZipOutputStream zos = new ZipOutputStream(os);

		    ZipEntry ze = new ZipEntry("moin/");
		    zos.putNextEntry(ze);
		    ze = new ZipEntry("moin/meta/");
		    zos.putNextEntry(ze);

		    for (File metamodelFile : file.listFiles()) {

			try {

			    InputStream inputStream = new FileInputStream(metamodelFile);

			    // zip should contain the files in moin/meta
			    String zipPath = "moin/meta/" + metamodelFile.getName();

			    // only exception is metamodel.properties, which
			    // goes into the root of the zip file
			    if (metamodelFile.getName().equals("metamodel.properties")) {
				zipPath = "metamodel.properties";
				// also load partition info and create
				// corresponding PRIs

				Properties metamodelProps = new Properties();
				metamodelProps.load(new FileInputStream(metamodelFile));
				String facilityId = metamodelProps.getProperty("facilityName");
				String containerName = metamodelProps.getProperty("metamodelId");
				String partitionsProp = metamodelProps.getProperty("partitionList", "");

				metamodelInfos.add(new MetamodelInfo(facilityId, containerName, partitionsProp));
			    }

			    ze = new ZipEntry(zipPath);
			    zos.putNextEntry(ze);
			    byte[] buf = new byte[4096];
			    int read = inputStream.read(buf);
			    while (read != -1) {
				zos.write(buf, 0, read);
				read = inputStream.read(buf);
			    }
			} catch (IOException fileIoEx) {
			    // do nothing
			}

		    }
		    try {
			zos.close();
		    } catch (ZipException e) {
			// do nothing
		    }
		}
	    } catch (IOException io) {
		// do nothing
	    }
	}
	return resultZips;
    }

    public static Set<PRI> getPartitionsOfMetamodel(String metamodelId) {

	if (metamodelId == null) {
	    return new HashSet<PRI>();
	}

	if (!partitionsMap.containsKey(metamodelId)) {
	    // fill partitionsMap
	    // this also processes metamodels
	    Moin moin = getBuildMoin();

	    Set<PRI> partitions = new HashSet<PRI>();

	    // add standard partitions
	    PRI pri1 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm");
	    PRI pri2 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm");
	    PRI pri3 = moin.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/MOIN.moinmm");

	    partitions.add(pri1);
	    partitions.add(pri2);
	    partitions.add(pri3);

	    for (MetamodelInfo info : metamodelInfos) {
		if (info.getContainerName().equals(metamodelId)) {
		    String[] partitionNames = info.getPartitionsProp().split(";");
		    for (String partitionName : partitionNames) {
			partitions.add(moin.createPri(info.getFacilityId(), "MetaModelDataArea", info.getContainerName(),
				partitionName));
		    }
		}
	    }

	    partitionsMap.put(metamodelId, partitions);
	}

	return partitionsMap.get(metamodelId);
    }

    private static class MetamodelInfo {
	private String facilityId;
	private String containerName;
	private String partitionsProp;

	public MetamodelInfo(String facilityId, String containerName, String partitionsProp) {
	    this.facilityId = facilityId;
	    this.containerName = containerName;
	    this.partitionsProp = partitionsProp;
	}

	public String getFacilityId() {
	    return facilityId;
	}

	public void setFacilityId(String facilityId) {
	    this.facilityId = facilityId;
	}

	public String getContainerName() {
	    return containerName;
	}

	public void setContainerName(String containerName) {
	    this.containerName = containerName;
	}

	public String getPartitionsProp() {
	    return partitionsProp;
	}

	public void setPartitionsProp(String partitionsProp) {
	    this.partitionsProp = partitionsProp;
	}
    }
}
