/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimitiveType.java,v 1.1 2007/01/25 18:24:36 cdamus Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.ocl.utilities.PredefinedType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.ocl.types.TypesPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType<O> extends PredefinedType<O> {
    String BOOLEAN_NAME = "Boolean"; //$NON-NLS-1$
    String STRING_NAME = "String"; //$NON-NLS-1$
    String INTEGER_NAME = "Integer"; //$NON-NLS-1$
    String UNLIMITED_NATURAL_NAME = "UnlimitedNatural"; //$NON-NLS-1$
    String REAL_NAME = "Real"; //$NON-NLS-1$
} // PrimitiveType
