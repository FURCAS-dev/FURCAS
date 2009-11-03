package com.sap.mi.gfw.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.MQLExecutionException;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;

/**
 * The Class MoinHelper.
 */
public class MoinHelper {

	/**
	 * Adds the all elements if not null.
	 * 
	 * @param resultList
	 *            the result list
	 * @param collection
	 *            the collection
	 */
	public static void addAllElementsIfNotNull(List<Object> resultList, Collection collection) {
		for (Iterator iter = collection.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (element != null) {
				resultList.add(element);
			}
		}
	}

	/**
	 * Checks if object is alive.
	 * 
	 * @param obj
	 *            the ref object
	 * @return true, if object is alive
	 */
	public static boolean isObjectAlive(RefObject obj) {
		if (obj != null) {
			return (obj.is___Alive());
		}
		return true;

	}

	/**
	 * Assign same partition.
	 * 
	 * @param partitionable
	 *            the partitionable
	 * @param partitionProvider
	 *            the partition provider
	 */
	public static void assignSamePartition(RefObject partitionable, RefObject partitionProvider) {
		if (partitionable != null && partitionProvider != null) {
			ModelPartition partition = partitionProvider.get___Partition();
			try {
				partitionable.assign___Partition(partition);
			} catch (RuntimeException e) {
				T.racer().error("Error on partition assignment", e); //$NON-NLS-1$
			}
		} else {
			T.racer().error("THIS MUST NOT HAPPEN in " + "MoinHelper.assignSamePartition()"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * Resolve proxy.
	 * 
	 * @param proxy
	 *            the proxy
	 * @param connection
	 *            the connection
	 * @return the ref object
	 */
	public static RefObject resolveProxy(RefObject proxy, Connection connection) {
		MRI mri = proxy.get___Mri();
		return (RefObject) connection.getElement(mri);
	}

	/**
	 * Ref all of class.
	 * 
	 * @param refClass
	 *            the ref class
	 * @return the collection
	 */
	public static Collection refAllOfClass(RefClass refClass) {
		Collection ret;
		ret = performQuery(refClass, false);
		return ret;
	}

	/**
	 * Ref all of type.
	 * 
	 * @param refClass
	 *            the ref class
	 * @return the collection
	 */
	public static Collection refAllOfType(RefClass refClass) {
		Collection ret;
		ret = performQuery(refClass, true);
		return ret;
	}

	private static Collection performQuery(RefClass refClass, boolean withSubtypes) {
		final String SIGNATURE = "performQuery(RefClass, boolean)"; //$NON-NLS-1$
		boolean info = T.racer().info();
		if (info) {
			T.racer().entering(MoinHelper.class, SIGNATURE, new Object[] { refClass, withSubtypes });
		}
		Collection ret = new LinkedList();

		MofClass mofClass = refClass.refMetaObject();
		String className = mofClass.getName();
		String aliasName = "class" + className; //$NON-NLS-1$

		MofPackage mofPackage = refClass.refImmediatePackage().refMetaObject();

		List<String> qnList = new ArrayList<String>();
		qnList.addAll(mofPackage.getQualifiedName());
		qnList.add(className);
		String qName[] = qnList.toArray(new String[0]);

		Connection connection = ((Partitionable) refClass).get___Connection();
		String containerName = ((Partitionable) refClass.refMetaObject()).get___Partition().getPri().getContainerName();

		// define the types in which you are interested
		FromType typeA = new FromType(aliasName, qName, containerName, withSubtypes);
		FromEntry[] fromEntries = new FromEntry[] { typeA };

		// define what you want of it (in this case only its MRI, no attributes)
		SelectAlias selectA = new SelectAlias(aliasName);
		SelectEntry[] selectEntries = new SelectEntry[] { selectA };

		// compose the query and execute it
		MQLQuery query = new MQLQuery(selectEntries, fromEntries);
		MQLProcessor mql = connection.getMQLProcessor();
		MQLResultSet resultSet;
		try {
			resultSet = mql.execute(query);
			// MQL only retrieves MRIs -> you have to resolve them yourself
			for (int i = 0; i < resultSet.getSize(); i++) {
				MRI mri = resultSet.getMri(i, aliasName);
				RefBaseObject element = connection.getElement(mri);
				if (element != null) {
					ret.add(element);
				}
			}
		} catch (MQLExecutionException e) {
			// $JL-EXC$
			T.racer().catching(MoinHelper.class, SIGNATURE, e);
		}

		if (info) {
			T.racer().exiting(MoinHelper.class, SIGNATURE, ret);
		}
		return ret;
	}
}