package com.sap.tc.moin.textual.moinadapter.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.common.util.ContextAndForeachHelper;

public class MoinHelper {
	private static final String OCL_SELF = "self";
	private static final String QUERY_PARAM_NAME = "\\?";

    /**
     * Finds all {@link EPackage}s that are imported by the given root.
     * 
     * @param root
     * @return
     */
	public static Collection<? extends EPackage> getImportedRefPackages(
			EPackage root) {
		Collection<EPackage> packages = new ArrayList<EPackage>();
		List<EModelElement> contents = (root.refMetaObject()).getContents();
		// if (contents != null) { // possible with mock objects
		for (EModelElement element : contents) {
			if (element instanceof Import) {
				if (((Import) element).isClustered()) {
					packages.add(root.refPackage(((Import) element)
							.getImportedNamespace()));
				} else {
					packages.add(root.get___Connection().getJmiHelper()
							.getRefPackageForMofPackage(
									(EPackage) ((Import) element)
											.getImportedNamespace()));
				}
			}
		}
		// }
		return packages;
	}
	
	public static Collection<EPackage> getImportedMofPackages(
                EPackage root) {
            Collection<EPackage> packages = new ArrayList<EPackage>();
            List<EModelElement> contents = root.getContents();
            // if (contents != null) { // possible with mock objects
            for (EModelElement element : contents) {
                    if (element instanceof Import) {
                            if (((Import) element).isClustered()) {
                                    packages.add((EPackage) ((Import) element)
                                                    .getImportedNamespace());
                            } else {
                                    packages.add((EPackage) ((Import) element).getImportedNamespace());
                            }
                    }
            }
            // }
            return packages;
	}

	public static String prepareOclQuery(String queryToExecute, Object keyValue)
			throws ModelAdapterException {
		String result = queryToExecute;
		if (queryToExecute != null) {
			if (result.startsWith("OCL:")) {
				result = result.replaceFirst("OCL:", "");
			}
			if (ContextAndForeachHelper.usesContext(result)) {
				if (result.indexOf(OCL_SELF) > -1) {
					throw new ModelAdapterException(
							"OCL Query cannot contain #context and self at the same time.");
				} else if (ContextAndForeachHelper.usesForeach(result)) {
				    throw new ModelAdapterException("OCL query cannot contain #foreach and #context at the same time");
				} else {
					result = result.replaceAll(ContextAndForeachHelper.contextPattern
							.pattern(), OCL_SELF);
				}
			} else if(ContextAndForeachHelper.usesForeach(result)) {
			    if (result.indexOf(OCL_SELF) > -1) {
                                throw new ModelAdapterException(
                                                "OCL Query cannot contain #foreach and self at the same time.");
			    } else if (ContextAndForeachHelper.usesContext(result)) {
				throw new ModelAdapterException("OCL query cannot contain #foreach and #context at the same time");
                            } else {
                                result = result.replaceAll(ContextAndForeachHelper.foreachPattern
                                                .pattern(), OCL_SELF);
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
	 * Retrieves the {@link EClass} for Reflect::Element using the given
	 * connection.
	 * 
	 * @param connection
	 * @return {@link EClass} for Reflect::Element
	 */
	public static EClass getReflectElement(ResourceSet connection) {
		ResultSet resultSet = connection
				.getMQLProcessor()
				.execute(
						"select instance from \""
								+ "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Reflect.moinmm"
								+ "#45ED2E29000DEAF733A545E62844AF3FC5E44767\" as instance");
		return (EClass) resultSet.getRefObjects("instance")[0];
	}

	    public static EPackage getOutermostPackageThroughClusteredImports(
		    ResourceSet conn, EObject refObject) {
		EPackage result = refObject.refOutermostPackage();
		EPackage candidate = result;
		while (candidate != null) {
		    // ascend the clustered imports in the metamodel
		    EPackage p = candidate.refMetaObject();
		    candidate = null;
		    Aliases a = conn.getAssociation(Aliases.ASSOCIATION_DESCRIPTOR);
		    for (Import i : a.getImporter(p)) {
			if (i.isClustered()) {
			    EPackage importer = (EPackage) i.getContainer();
			    candidate = conn.getJmiHelper().getRefPackageForMofPackage(
				    importer);
			    result = candidate;
			    break;
			}
		    }
		}
		return result;
	    }

	    public static EPackage getOutermostPackageThroughClusteredImportsFromMofClass(
		    ResourceSet conn, EClass mofClass) {
		EPackage result = conn.getJmiHelper().getRefClassForMofClass(mofClass).refOutermostPackage();
		EPackage candidate = result;
		while (candidate != null) {
		    // ascend the clustered imports in the metamodel
		    EPackage p = candidate.refMetaObject();
		    candidate = null;
		    Aliases a = conn.getAssociation(Aliases.ASSOCIATION_DESCRIPTOR);
		    for (Import i : a.getImporter(p)) {
			if (i.isClustered()) {
			    EPackage importer = (EPackage) i.getContainer();
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
