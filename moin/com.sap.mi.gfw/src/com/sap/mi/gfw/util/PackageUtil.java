package com.sap.mi.gfw.util;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.mm.datatypes.DatatypesPackage;
import com.sap.mi.gfw.mm.links.LinksPackage;
import com.sap.mi.gfw.mm.pictograms.PictogramsPackage;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;

/**
 * The Class PackageUtil.
 */
public class PackageUtil {

	public static final String LINKS_PACKAGE_NAME = "links"; //$NON-NLS-1$

	public static final String DATATYPES_PACKAGE_NAME = "datatypes"; //$NON-NLS-1$

	public static final String PICTOGRAMS_PACKAGE_NAME = "pictograms"; //$NON-NLS-1$

	public static final String GRAPHICS_CONTAINER_NAME = "sap.com/com/sap/mi/gfw/mm"; //$NON-NLS-1$

	/**
	 * Gets the pictograms package.
	 * 
	 * @param connection
	 *            the connection
	 * 
	 * @return the pictograms package
	 */
	public static PictogramsPackage getPictogramsPackage(Connection connection) {
		PictogramsPackage p = (PictogramsPackage) connection.getPackage(GRAPHICS_CONTAINER_NAME, PICTOGRAMS_PACKAGE_NAME);
		return p;
	}

	/**
	 * Gets the pictograms package.
	 * 
	 * @param refObject
	 *            the ref object
	 * 
	 * @return the pictograms package
	 */
	public static PictogramsPackage getPictogramsPackage(RefObject refObject) {
		Connection connection = refObject.get___Connection();
		PictogramsPackage p = getPictogramsPackage(connection);
		return p;
	}

	/**
	 * Gets the data types package.
	 * 
	 * @param connection
	 *            the connection
	 * 
	 * @return the data types package
	 */
	public static DatatypesPackage getDataTypesPackage(Connection connection) {
		DatatypesPackage p = (DatatypesPackage) connection.getPackage(GRAPHICS_CONTAINER_NAME, DATATYPES_PACKAGE_NAME);
		return p;
	}

	/**
	 * Gets the data types package.
	 * 
	 * @param refObject
	 *            the ref object
	 * 
	 * @return the data types package
	 */
	public static DatatypesPackage getDataTypesPackage(RefObject refObject) {
		Connection connection = ((Partitionable) refObject).get___Connection();
		return getDataTypesPackage(connection);
	}

	/**
	 * Gets the links package.
	 * 
	 * @param connection
	 *            the connection
	 * 
	 * @return the links package
	 */
	public static LinksPackage getLinksPackage(Connection connection) {
		LinksPackage p = (LinksPackage) connection.getPackage(GRAPHICS_CONTAINER_NAME, LINKS_PACKAGE_NAME);
		return p;
	}

	/**
	 * Gets the links package.
	 * 
	 * @param refObject
	 *            the ref object
	 * 
	 * @return the links package
	 */
	public static LinksPackage getLinksPackage(RefObject refObject) {
		Connection connection = ((Partitionable) refObject).get___Connection();
		return getLinksPackage(connection);
	}
}
