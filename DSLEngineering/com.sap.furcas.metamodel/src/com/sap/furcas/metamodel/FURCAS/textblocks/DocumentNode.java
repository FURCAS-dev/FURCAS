/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks;

import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getVersion <em>Version</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#isChildrenChanged <em>Children Changed</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#isRelexingNeeded <em>Relexing Needed</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getParent <em>Parent</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getCorrespondingModelElements <em>Corresponding Model Elements</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getReferencedElements <em>Referenced Elements</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getSequenceElement <em>Sequence Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getOffset <em>Offset</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getLength <em>Length</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getOtherVersions <em>Other Versions</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#isOffsetRelative <em>Offset Relative</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getStartRow <em>Start Row</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getStartColumn <em>Start Column</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getEndRow <em>End Row</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getEndColumn <em>End Column</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getAbsoluteOffset <em>Absolute Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode()
 * @model abstract="true"
 * @generated
 */
public interface DocumentNode extends EObject {
        /**
     * Returns the value of the '<em><b>Version</b></em>' attribute.
     * The literals are from the enumeration {@link com.sap.furcas.metamodel.FURCAS.textblocks.Version}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Version</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Version</em>' attribute.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.Version
     * @see #setVersion(Version)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_Version()
     * @model
     * @generated
     */
        Version getVersion();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getVersion <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Version</em>' attribute.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.Version
     * @see #getVersion()
     * @generated
     */
        void setVersion(Version value);

        /**
     * Returns the value of the '<em><b>Children Changed</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Children Changed</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Children Changed</em>' attribute.
     * @see #setChildrenChanged(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_ChildrenChanged()
     * @model
     * @generated
     */
        boolean isChildrenChanged();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#isChildrenChanged <em>Children Changed</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Children Changed</em>' attribute.
     * @see #isChildrenChanged()
     * @generated
     */
        void setChildrenChanged(boolean value);

        /**
     * Returns the value of the '<em><b>Relexing Needed</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Relexing Needed</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Relexing Needed</em>' attribute.
     * @see #setRelexingNeeded(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_RelexingNeeded()
     * @model
     * @generated
     */
        boolean isRelexingNeeded();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#isRelexingNeeded <em>Relexing Needed</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Relexing Needed</em>' attribute.
     * @see #isRelexingNeeded()
     * @generated
     */
        void setRelexingNeeded(boolean value);

        /**
     * Returns the value of the '<em><b>Parent</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getSubNodes <em>Sub Nodes</em>}'.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Parent</em>' container reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Parent</em>' container reference.
     * @see #setParent(TextBlock)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_Parent()
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock#getSubNodes
     * @model opposite="subNodes" transient="false"
     * @generated
     */
        TextBlock getParent();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getParent <em>Parent</em>}' container reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parent</em>' container reference.
     * @see #getParent()
     * @generated
     */
        void setParent(TextBlock value);

        /**
     * Returns the value of the '<em><b>Corresponding Model Elements</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Corresponding Model Elements</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Corresponding Model Elements</em>' reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_CorrespondingModelElements()
     * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='correspondingDocumentNode'"
     * @generated
     */
        EList<EObject> getCorrespondingModelElements();

        /**
     * Returns the value of the '<em><b>Referenced Elements</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Referenced Elements</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Referenced Elements</em>' reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_ReferencedElements()
     * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName='referencingDocumentNode'"
     * @generated
     */
        EList<EObject> getReferencedElements();

        /**
     * Returns the value of the '<em><b>Sequence Element</b></em>' reference.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Sequence Element</em>' reference isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Sequence Element</em>' reference.
     * @see #setSequenceElement(SequenceElement)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_SequenceElement()
     * @model
     * @generated
     */
        SequenceElement getSequenceElement();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getSequenceElement <em>Sequence Element</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sequence Element</em>' reference.
     * @see #getSequenceElement()
     * @generated
     */
        void setSequenceElement(SequenceElement value);

        /**
     * Returns the value of the '<em><b>Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Offset</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Offset</em>' attribute.
     * @see #setOffset(int)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_Offset()
     * @model
     * @generated
     */
        int getOffset();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getOffset <em>Offset</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Offset</em>' attribute.
     * @see #getOffset()
     * @generated
     */
        void setOffset(int value);

        /**
     * Returns the value of the '<em><b>Length</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Length</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Length</em>' attribute.
     * @see #setLength(int)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_Length()
     * @model
     * @generated
     */
        int getLength();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getLength <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Length</em>' attribute.
     * @see #getLength()
     * @generated
     */
        void setLength(int value);

        /**
     * Returns the value of the '<em><b>Other Versions</b></em>' reference list.
     * The list contents are of type {@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode}.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Other Versions</em>' reference list isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Other Versions</em>' reference list.
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_OtherVersions()
     * @model upper="2"
     * @generated
     */
        EList<DocumentNode> getOtherVersions();

        /**
     * Returns the value of the '<em><b>Offset Relative</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Offset Relative</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Offset Relative</em>' attribute.
     * @see #setOffsetRelative(boolean)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_OffsetRelative()
     * @model
     * @generated
     */
        boolean isOffsetRelative();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#isOffsetRelative <em>Offset Relative</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Offset Relative</em>' attribute.
     * @see #isOffsetRelative()
     * @generated
     */
        void setOffsetRelative(boolean value);

        /**
     * Returns the value of the '<em><b>Start Row</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Start Row</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Start Row</em>' attribute.
     * @see #setStartRow(int)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_StartRow()
     * @model
     * @generated
     */
        int getStartRow();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getStartRow <em>Start Row</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Row</em>' attribute.
     * @see #getStartRow()
     * @generated
     */
        void setStartRow(int value);

        /**
     * Returns the value of the '<em><b>Start Column</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Start Column</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Start Column</em>' attribute.
     * @see #setStartColumn(int)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_StartColumn()
     * @model
     * @generated
     */
        int getStartColumn();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getStartColumn <em>Start Column</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Start Column</em>' attribute.
     * @see #getStartColumn()
     * @generated
     */
        void setStartColumn(int value);

        /**
     * Returns the value of the '<em><b>End Row</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>End Row</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>End Row</em>' attribute.
     * @see #setEndRow(int)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_EndRow()
     * @model
     * @generated
     */
        int getEndRow();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getEndRow <em>End Row</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>End Row</em>' attribute.
     * @see #getEndRow()
     * @generated
     */
        void setEndRow(int value);

        /**
     * Returns the value of the '<em><b>End Column</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>End Column</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>End Column</em>' attribute.
     * @see #setEndColumn(int)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_EndColumn()
     * @model
     * @generated
     */
        int getEndColumn();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getEndColumn <em>End Column</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>End Column</em>' attribute.
     * @see #getEndColumn()
     * @generated
     */
        void setEndColumn(int value);

        /**
     * Returns the value of the '<em><b>Absolute Offset</b></em>' attribute.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of the '<em>Absolute Offset</em>' attribute isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @return the value of the '<em>Absolute Offset</em>' attribute.
     * @see #setAbsoluteOffset(int)
     * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getDocumentNode_AbsoluteOffset()
     * @model
     * @generated
     */
        int getAbsoluteOffset();

        /**
     * Sets the value of the '{@link com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode#getAbsoluteOffset <em>Absolute Offset</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @param value the new value of the '<em>Absolute Offset</em>' attribute.
     * @see #getAbsoluteOffset()
     * @generated
     */
        void setAbsoluteOffset(int value);

} // DocumentNode
