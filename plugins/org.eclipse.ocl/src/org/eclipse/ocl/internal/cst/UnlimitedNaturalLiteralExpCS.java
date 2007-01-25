/**
 * <copyright>
 * </copyright>
 *
 * $Id: UnlimitedNaturalLiteralExpCS.java,v 1.1 2007/01/25 18:24:34 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unlimited Natural Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.UnlimitedNaturalLiteralExpCS#getIntegerSymbol <em>Integer Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getUnlimitedNaturalLiteralExpCS()
 * @model
 * @generated
 */
public interface UnlimitedNaturalLiteralExpCS extends PrimitiveLiteralExpCS {
    /**
     * Returns the value of the '<em><b>Integer Symbol</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Integer Symbol</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Integer Symbol</em>' attribute.
     * @see #setIntegerSymbol(Integer)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getUnlimitedNaturalLiteralExpCS_IntegerSymbol()
     * @model
     * @generated
     */
    Integer getIntegerSymbol();

    /**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.UnlimitedNaturalLiteralExpCS#getIntegerSymbol <em>Integer Symbol</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Integer Symbol</em>' attribute.
     * @see #getIntegerSymbol()
     * @generated
     */
    void setIntegerSymbol(Integer value);

} // UnlimitedNaturalLiteralExpCS
