package com.sap.tc.moin.textual.moinadapter.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.mmi.model.Aliases;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mql.MQLResultSet;

public class MoinHelper {
	private static final String OCL_SELF = "self";
	private static final String QUERY_PARAM_NAME = "\\?";

    /**
     * Finds all {@link RefPackage}s that are imported by the given root.
     * 
     * @param root
     * @return
     */
	public static Collection<? extends RefPackage> getImportedRefPackages(
			RefPackage root) {
		Collection<RefPackage> packages = new ArrayList<RefPackage>();
		List<ModelElement> contents = (root.refMetaObject()).getContents();
		// if (contents != null) { // possible with mock objects
		for (ModelElement element : contents) {
			if (element instanceof Import) {
				if (((Import) element).isClustered()) {
					packages.add(root.refPackage(((Import) element)
							.getImportedNamespace()));
				} else {
					packages.add(root.get___Connection().getJmiHelper()
							.getRefPackageForMofPackage(
									(MofPackage) ((Import) element)
											.getImportedNamespace()));
				}
			}
		}
		// }
		return packages;
	}
	
	public static Collection<MofPackage> getImportedMofPackages(
                MofPackage root) {
            Collection<MofPackage> packages = new ArrayList<MofPackage>();
            List<ModelElement> contents = root.getContents();
            // if (contents != null) { // possible with mock objects
            for (ModelElement element : contents) {
                    if (element instanceof Import) {
                            if (((Import) element).isClustered()) {
                                    packages.add((MofPackage) ((Import) element)
                                                    .getImportedNamespace());
                            } else {
                                    packages.add((MofPackage) ((Import) element).getImportedNamespace());
                            }
                    }
            }
            // }
            return packages;
	}

	public static String prepareOclQuery(String queryToExecute,
			Object contextObject, Object keyValue)
			throws ModelAdapterException {
		String result = queryToExecute;
		if (queryToExecute != null) {
			if (result.startsWith("OCL:")) {
				result = result.replaceFirst("OCL:", "");
			}
			if (ContextAndForeachHelper.usesContext(result)) {
				if (result.indexOf(OCL_SELF) > -1) {
					throw new ModelAdapterException(
							"Ocl Query cannot contain #context and self at the same time.");
				} else {
					// if (contextObject instanceof RefObject ||
					// (contextObject instanceof IModelElementProxy &&
					// ((IModelElementProxy)contextObject).getRealObject() !=
					// null)) {
					result = result.replaceAll(ContextAndForeachHelper.contextPattern
							.pattern(), OCL_SELF);
					// } else if(contextObject instanceof IModelElementProxy) {
					// }else {
					// throw new ModelAdapterException(
					// "#context has to be a model element but was:"
					// + contextObject.getClass());
					// }
				}
			}

			if (keyValue != null) {
				result = result.replaceAll(QUERY_PARAM_NAME, "'"
						+ keyValue.toString() + "'");
			}
		}
		return result;
	}

	/**
	 * Retrieves the {@link MofClass} for Reflect::Element using the given
	 * connection.
	 * 
	 * @param connection
	 * @return {@link MofClass} for Reflect::Element
	 */
	public static MofClass getReflectElement(Connection connection) {
		MQLResultSet resultSet = connection
				.getMQLProcessor()
				.execute(
						"select instance from \""
								+ "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Reflect.moinmm"
								+ "#45ED2E29000DEAF733A545E62844AF3FC5E44767\" as instance");
		return (MofClass) resultSet.getRefObjects("instance")[0];
	}

	    public static RefPackage getOutermostPackageThroughClusteredImports(
		    Connection conn, RefBaseObject refObject) {
		RefPackage result = refObject.refOutermostPackage();
		RefPackage candidate = result;
		while (candidate != null) {
		    // ascend the clustered imports in the metamodel
		    MofPackage p = candidate.refMetaObject();
		    candidate = null;
		    Aliases a = conn.getAssociation(Aliases.ASSOCIATION_DESCRIPTOR);
		    for (Import i : a.getImporter(p)) {
			if (i.isClustered()) {
			    MofPackage importer = (MofPackage) i.getContainer();
			    candidate = conn.getJmiHelper().getRefPackageForMofPackage(
				    importer);
			    result = candidate;
			    break;
			}
		    }
		}
		return result;
	    }

	    public static RefPackage getOutermostPackageThroughClusteredImportsFromMofClass(
		    Connection conn, MofClass mofClass) {
		RefPackage result = conn.getJmiHelper().getRefClassForMofClass(mofClass).refOutermostPackage();
		RefPackage candidate = result;
		while (candidate != null) {
		    // ascend the clustered imports in the metamodel
		    MofPackage p = candidate.refMetaObject();
		    candidate = null;
		    Aliases a = conn.getAssociation(Aliases.ASSOCIATION_DESCRIPTOR);
		    for (Import i : a.getImporter(p)) {
			if (i.isClustered()) {
			    MofPackage importer = (MofPackage) i.getContainer();
			    candidate = conn.getJmiHelper().getRefPackageForMofPackage(
				    importer);
			    result = candidate;
			    break;
			}
		    }
		}
		return result;
	    }
}
