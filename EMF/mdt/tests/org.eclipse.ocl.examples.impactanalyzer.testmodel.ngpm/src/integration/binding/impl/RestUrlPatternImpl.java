/**
 * <copyright>
 * </copyright>
 *
 * $Id: RestUrlPatternImpl.java,v 1.1 2011/02/07 17:21:37 auhl Exp $
 */
package integration.binding.impl;

import integration.binding.BindingPackage;
import integration.binding.RestUrlPattern;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rest Url Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RestUrlPatternImpl extends UrlPatternImpl implements RestUrlPattern {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected RestUrlPatternImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return BindingPackage.Literals.REST_URL_PATTERN;
    }

} //RestUrlPatternImpl
