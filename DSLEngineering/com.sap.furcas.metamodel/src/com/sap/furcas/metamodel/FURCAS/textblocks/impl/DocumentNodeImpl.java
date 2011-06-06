/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Document Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#isChildrenChanged <em>Children Changed</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#isRelexingNeeded <em>Relexing Needed</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#getSequenceElement <em>Sequence Element</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#getOffset <em>Offset</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#getLength <em>Length</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#getOtherVersions <em>Other Versions</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#isOffsetRelative <em>Offset Relative</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.textblocks.impl.DocumentNodeImpl#getAbsoluteOffset <em>Absolute Offset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DocumentNodeImpl extends EObjectImpl implements DocumentNode {
        /**
     * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
        protected static final Version VERSION_EDEFAULT = Version.REFERENCE;

        /**
     * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getVersion()
     * @generated
     * @ordered
     */
        protected Version version = VERSION_EDEFAULT;

        /**
     * The default value of the '{@link #isChildrenChanged() <em>Children Changed</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isChildrenChanged()
     * @generated
     * @ordered
     */
        protected static final boolean CHILDREN_CHANGED_EDEFAULT = false;

        /**
     * The cached value of the '{@link #isChildrenChanged() <em>Children Changed</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isChildrenChanged()
     * @generated
     * @ordered
     */
        protected boolean childrenChanged = CHILDREN_CHANGED_EDEFAULT;

        /**
     * The default value of the '{@link #isRelexingNeeded() <em>Relexing Needed</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isRelexingNeeded()
     * @generated
     * @ordered
     */
        protected static final boolean RELEXING_NEEDED_EDEFAULT = false;

        /**
     * The cached value of the '{@link #isRelexingNeeded() <em>Relexing Needed</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isRelexingNeeded()
     * @generated
     * @ordered
     */
        protected boolean relexingNeeded = RELEXING_NEEDED_EDEFAULT;

        /**
     * The cached value of the '{@link #getSequenceElement() <em>Sequence Element</em>}' reference.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getSequenceElement()
     * @generated
     * @ordered
     */
        protected SequenceElement sequenceElement;

        /**
     * The default value of the '{@link #getOffset() <em>Offset</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getOffset()
     * @generated
     * @ordered
     */
        protected static final int OFFSET_EDEFAULT = 0;

        /**
     * The cached value of the '{@link #getOffset() <em>Offset</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getOffset()
     * @generated
     * @ordered
     */
        protected int offset = OFFSET_EDEFAULT;

        /**
     * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
        protected static final int LENGTH_EDEFAULT = 0;

        /**
     * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getLength()
     * @generated
     * @ordered
     */
        protected int length = LENGTH_EDEFAULT;

        /**
     * The cached value of the '{@link #getOtherVersions() <em>Other Versions</em>}' reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getOtherVersions()
     * @generated
     * @ordered
     */
        protected EList<DocumentNode> otherVersions;

        /**
     * The default value of the '{@link #isOffsetRelative() <em>Offset Relative</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isOffsetRelative()
     * @generated
     * @ordered
     */
        protected static final boolean OFFSET_RELATIVE_EDEFAULT = false;

        /**
     * The cached value of the '{@link #isOffsetRelative() <em>Offset Relative</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #isOffsetRelative()
     * @generated
     * @ordered
     */
        protected boolean offsetRelative = OFFSET_RELATIVE_EDEFAULT;

        /**
     * The default value of the '{@link #getAbsoluteOffset() <em>Absolute Offset</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getAbsoluteOffset()
     * @generated
     * @ordered
     */
        protected static final int ABSOLUTE_OFFSET_EDEFAULT = 0;

        /**
     * The cached value of the '{@link #getAbsoluteOffset() <em>Absolute Offset</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getAbsoluteOffset()
     * @generated
     * @ordered
     */
        protected int absoluteOffset = ABSOLUTE_OFFSET_EDEFAULT;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected DocumentNodeImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TextblocksPackage.Literals.DOCUMENT_NODE;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public Version getVersion() {
        return version;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setVersion(Version newVersion) {
        Version oldVersion = version;
        version = newVersion == null ? VERSION_EDEFAULT : newVersion;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.DOCUMENT_NODE__VERSION, oldVersion, version));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isChildrenChanged() {
        return childrenChanged;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setChildrenChanged(boolean newChildrenChanged) {
        boolean oldChildrenChanged = childrenChanged;
        childrenChanged = newChildrenChanged;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.DOCUMENT_NODE__CHILDREN_CHANGED, oldChildrenChanged, childrenChanged));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isRelexingNeeded() {
        return relexingNeeded;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setRelexingNeeded(boolean newRelexingNeeded) {
        boolean oldRelexingNeeded = relexingNeeded;
        relexingNeeded = newRelexingNeeded;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.DOCUMENT_NODE__RELEXING_NEEDED, oldRelexingNeeded, relexingNeeded));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public TextBlock getParent() {
        if (eContainerFeatureID() != TextblocksPackage.DOCUMENT_NODE__PARENT) return null;
        return (TextBlock)eContainer();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public NotificationChain basicSetParent(TextBlock newParent, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newParent, TextblocksPackage.DOCUMENT_NODE__PARENT, msgs);
        return msgs;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setParent(TextBlock newParent) {
        if (newParent != eInternalContainer() || (eContainerFeatureID() != TextblocksPackage.DOCUMENT_NODE__PARENT && newParent != null)) {
            if (EcoreUtil.isAncestor(this, newParent))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParent != null)
                msgs = ((InternalEObject)newParent).eInverseAdd(this, TextblocksPackage.TEXT_BLOCK__SUB_NODES, TextBlock.class, msgs);
            msgs = basicSetParent(newParent, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.DOCUMENT_NODE__PARENT, newParent, newParent));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public SequenceElement getSequenceElement() {
        if (sequenceElement != null && sequenceElement.eIsProxy()) {
            InternalEObject oldSequenceElement = (InternalEObject)sequenceElement;
            sequenceElement = (SequenceElement)eResolveProxy(oldSequenceElement);
            if (sequenceElement != oldSequenceElement) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TextblocksPackage.DOCUMENT_NODE__SEQUENCE_ELEMENT, oldSequenceElement, sequenceElement));
            }
        }
        return sequenceElement;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public SequenceElement basicGetSequenceElement() {
        return sequenceElement;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setSequenceElement(SequenceElement newSequenceElement) {
        SequenceElement oldSequenceElement = sequenceElement;
        sequenceElement = newSequenceElement;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.DOCUMENT_NODE__SEQUENCE_ELEMENT, oldSequenceElement, sequenceElement));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public int getOffset() {
        return offset;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setOffset(int newOffset) {
        int oldOffset = offset;
        offset = newOffset;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.DOCUMENT_NODE__OFFSET, oldOffset, offset));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public int getLength() {
        return length;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setLength(int newLength) {
        int oldLength = length;
        length = newLength;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.DOCUMENT_NODE__LENGTH, oldLength, length));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<DocumentNode> getOtherVersions() {
        if (otherVersions == null) {
            otherVersions = new EObjectResolvingEList<DocumentNode>(DocumentNode.class, this, TextblocksPackage.DOCUMENT_NODE__OTHER_VERSIONS);
        }
        return otherVersions;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isOffsetRelative() {
        return offsetRelative;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setOffsetRelative(boolean newOffsetRelative) {
        boolean oldOffsetRelative = offsetRelative;
        offsetRelative = newOffsetRelative;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.DOCUMENT_NODE__OFFSET_RELATIVE, oldOffsetRelative, offsetRelative));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public int getAbsoluteOffset() {
        return absoluteOffset;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setAbsoluteOffset(int newAbsoluteOffset) {
        int oldAbsoluteOffset = absoluteOffset;
        absoluteOffset = newAbsoluteOffset;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TextblocksPackage.DOCUMENT_NODE__ABSOLUTE_OFFSET, oldAbsoluteOffset, absoluteOffset));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TextblocksPackage.DOCUMENT_NODE__PARENT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetParent((TextBlock)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TextblocksPackage.DOCUMENT_NODE__PARENT:
                return basicSetParent(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case TextblocksPackage.DOCUMENT_NODE__PARENT:
                return eInternalContainer().eInverseRemove(this, TextblocksPackage.TEXT_BLOCK__SUB_NODES, TextBlock.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TextblocksPackage.DOCUMENT_NODE__VERSION:
                return getVersion();
            case TextblocksPackage.DOCUMENT_NODE__CHILDREN_CHANGED:
                return isChildrenChanged();
            case TextblocksPackage.DOCUMENT_NODE__RELEXING_NEEDED:
                return isRelexingNeeded();
            case TextblocksPackage.DOCUMENT_NODE__PARENT:
                return getParent();
            case TextblocksPackage.DOCUMENT_NODE__SEQUENCE_ELEMENT:
                if (resolve) return getSequenceElement();
                return basicGetSequenceElement();
            case TextblocksPackage.DOCUMENT_NODE__OFFSET:
                return getOffset();
            case TextblocksPackage.DOCUMENT_NODE__LENGTH:
                return getLength();
            case TextblocksPackage.DOCUMENT_NODE__OTHER_VERSIONS:
                return getOtherVersions();
            case TextblocksPackage.DOCUMENT_NODE__OFFSET_RELATIVE:
                return isOffsetRelative();
            case TextblocksPackage.DOCUMENT_NODE__ABSOLUTE_OFFSET:
                return getAbsoluteOffset();
        }
        return super.eGet(featureID, resolve, coreType);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @SuppressWarnings("unchecked")
        @Override
        public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case TextblocksPackage.DOCUMENT_NODE__VERSION:
                setVersion((Version)newValue);
                return;
            case TextblocksPackage.DOCUMENT_NODE__CHILDREN_CHANGED:
                setChildrenChanged((Boolean)newValue);
                return;
            case TextblocksPackage.DOCUMENT_NODE__RELEXING_NEEDED:
                setRelexingNeeded((Boolean)newValue);
                return;
            case TextblocksPackage.DOCUMENT_NODE__PARENT:
                setParent((TextBlock)newValue);
                return;
            case TextblocksPackage.DOCUMENT_NODE__SEQUENCE_ELEMENT:
                setSequenceElement((SequenceElement)newValue);
                return;
            case TextblocksPackage.DOCUMENT_NODE__OFFSET:
                setOffset((Integer)newValue);
                return;
            case TextblocksPackage.DOCUMENT_NODE__LENGTH:
                setLength((Integer)newValue);
                return;
            case TextblocksPackage.DOCUMENT_NODE__OTHER_VERSIONS:
                getOtherVersions().clear();
                getOtherVersions().addAll((Collection<? extends DocumentNode>)newValue);
                return;
            case TextblocksPackage.DOCUMENT_NODE__OFFSET_RELATIVE:
                setOffsetRelative((Boolean)newValue);
                return;
            case TextblocksPackage.DOCUMENT_NODE__ABSOLUTE_OFFSET:
                setAbsoluteOffset((Integer)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public void eUnset(int featureID) {
        switch (featureID) {
            case TextblocksPackage.DOCUMENT_NODE__VERSION:
                setVersion(VERSION_EDEFAULT);
                return;
            case TextblocksPackage.DOCUMENT_NODE__CHILDREN_CHANGED:
                setChildrenChanged(CHILDREN_CHANGED_EDEFAULT);
                return;
            case TextblocksPackage.DOCUMENT_NODE__RELEXING_NEEDED:
                setRelexingNeeded(RELEXING_NEEDED_EDEFAULT);
                return;
            case TextblocksPackage.DOCUMENT_NODE__PARENT:
                setParent((TextBlock)null);
                return;
            case TextblocksPackage.DOCUMENT_NODE__SEQUENCE_ELEMENT:
                setSequenceElement((SequenceElement)null);
                return;
            case TextblocksPackage.DOCUMENT_NODE__OFFSET:
                setOffset(OFFSET_EDEFAULT);
                return;
            case TextblocksPackage.DOCUMENT_NODE__LENGTH:
                setLength(LENGTH_EDEFAULT);
                return;
            case TextblocksPackage.DOCUMENT_NODE__OTHER_VERSIONS:
                getOtherVersions().clear();
                return;
            case TextblocksPackage.DOCUMENT_NODE__OFFSET_RELATIVE:
                setOffsetRelative(OFFSET_RELATIVE_EDEFAULT);
                return;
            case TextblocksPackage.DOCUMENT_NODE__ABSOLUTE_OFFSET:
                setAbsoluteOffset(ABSOLUTE_OFFSET_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public boolean eIsSet(int featureID) {
        switch (featureID) {
            case TextblocksPackage.DOCUMENT_NODE__VERSION:
                return version != VERSION_EDEFAULT;
            case TextblocksPackage.DOCUMENT_NODE__CHILDREN_CHANGED:
                return childrenChanged != CHILDREN_CHANGED_EDEFAULT;
            case TextblocksPackage.DOCUMENT_NODE__RELEXING_NEEDED:
                return relexingNeeded != RELEXING_NEEDED_EDEFAULT;
            case TextblocksPackage.DOCUMENT_NODE__PARENT:
                return getParent() != null;
            case TextblocksPackage.DOCUMENT_NODE__SEQUENCE_ELEMENT:
                return sequenceElement != null;
            case TextblocksPackage.DOCUMENT_NODE__OFFSET:
                return offset != OFFSET_EDEFAULT;
            case TextblocksPackage.DOCUMENT_NODE__LENGTH:
                return length != LENGTH_EDEFAULT;
            case TextblocksPackage.DOCUMENT_NODE__OTHER_VERSIONS:
                return otherVersions != null && !otherVersions.isEmpty();
            case TextblocksPackage.DOCUMENT_NODE__OFFSET_RELATIVE:
                return offsetRelative != OFFSET_RELATIVE_EDEFAULT;
            case TextblocksPackage.DOCUMENT_NODE__ABSOLUTE_OFFSET:
                return absoluteOffset != ABSOLUTE_OFFSET_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (version: ");
        result.append(version);
        result.append(", childrenChanged: ");
        result.append(childrenChanged);
        result.append(", relexingNeeded: ");
        result.append(relexingNeeded);
        result.append(", offset: ");
        result.append(offset);
        result.append(", length: ");
        result.append(length);
        result.append(", offsetRelative: ");
        result.append(offsetRelative);
        result.append(", absoluteOffset: ");
        result.append(absoluteOffset);
        result.append(')');
        return result.toString();
    }

} //DocumentNodeImpl
