/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Syntax</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl#getK <em>K</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl#getTemplates <em>Templates</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl#getSymbols <em>Symbols</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl#getOperatorLists <em>Operator Lists</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl#getTokens <em>Tokens</em>}</li>
 *   <li>{@link com.sap.furcas.metamodel.FURCAS.TCS.impl.ConcreteSyntaxImpl#getLexer <em>Lexer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConcreteSyntaxImpl extends NamedElementImpl implements ConcreteSyntax {
        /**
     * The default value of the '{@link #getK() <em>K</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getK()
     * @generated
     * @ordered
     */
        protected static final Integer K_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getK() <em>K</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getK()
     * @generated
     * @ordered
     */
        protected Integer k = K_EDEFAULT;

        /**
     * This is true if the K attribute has been set.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
        protected boolean kESet;

        /**
     * The cached value of the '{@link #getTemplates() <em>Templates</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getTemplates()
     * @generated
     * @ordered
     */
        protected EList<Template> templates;

        /**
     * The cached value of the '{@link #getKeywords() <em>Keywords</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getKeywords()
     * @generated
     * @ordered
     */
        protected EList<Keyword> keywords;

        /**
     * The cached value of the '{@link #getSymbols() <em>Symbols</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getSymbols()
     * @generated
     * @ordered
     */
        protected EList<Symbol> symbols;

        /**
     * The cached value of the '{@link #getOperatorLists() <em>Operator Lists</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getOperatorLists()
     * @generated
     * @ordered
     */
        protected EList<OperatorList> operatorLists;

        /**
     * The cached value of the '{@link #getTokens() <em>Tokens</em>}' containment reference list.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getTokens()
     * @generated
     * @ordered
     */
        protected EList<Token> tokens;

        /**
     * The default value of the '{@link #getLexer() <em>Lexer</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getLexer()
     * @generated
     * @ordered
     */
        protected static final String LEXER_EDEFAULT = null;

        /**
     * The cached value of the '{@link #getLexer() <em>Lexer</em>}' attribute.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #getLexer()
     * @generated
     * @ordered
     */
        protected String lexer = LEXER_EDEFAULT;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        protected ConcreteSyntaxImpl() {
        super();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        protected EClass eStaticClass() {
        return TCSPackage.Literals.CONCRETE_SYNTAX;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public Integer getK() {
        return k;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setK(Integer newK) {
        Integer oldK = k;
        k = newK;
        boolean oldKESet = kESet;
        kESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONCRETE_SYNTAX__K, oldK, k, !oldKESet));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void unsetK() {
        Integer oldK = k;
        boolean oldKESet = kESet;
        k = K_EDEFAULT;
        kESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, TCSPackage.CONCRETE_SYNTAX__K, oldK, K_EDEFAULT, oldKESet));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public boolean isSetK() {
        return kESet;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<Template> getTemplates() {
        if (templates == null) {
            templates = new EObjectContainmentWithInverseEList<Template>(Template.class, this, TCSPackage.CONCRETE_SYNTAX__TEMPLATES, TCSPackage.TEMPLATE__CONCRETE_SYNTAX);
        }
        return templates;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<Keyword> getKeywords() {
        if (keywords == null) {
            keywords = new EObjectContainmentEList<Keyword>(Keyword.class, this, TCSPackage.CONCRETE_SYNTAX__KEYWORDS);
        }
        return keywords;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<Symbol> getSymbols() {
        if (symbols == null) {
            symbols = new EObjectContainmentEList<Symbol>(Symbol.class, this, TCSPackage.CONCRETE_SYNTAX__SYMBOLS);
        }
        return symbols;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<OperatorList> getOperatorLists() {
        if (operatorLists == null) {
            operatorLists = new EObjectContainmentEList<OperatorList>(OperatorList.class, this, TCSPackage.CONCRETE_SYNTAX__OPERATOR_LISTS);
        }
        return operatorLists;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EList<Token> getTokens() {
        if (tokens == null) {
            tokens = new EObjectContainmentEList<Token>(Token.class, this, TCSPackage.CONCRETE_SYNTAX__TOKENS);
        }
        return tokens;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public String getLexer() {
        return lexer;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void setLexer(String newLexer) {
        String oldLexer = lexer;
        lexer = newLexer;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TCSPackage.CONCRETE_SYNTAX__LEXER, oldLexer, lexer));
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @SuppressWarnings("unchecked")
        @Override
        public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case TCSPackage.CONCRETE_SYNTAX__TEMPLATES:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplates()).basicAdd(otherEnd, msgs);
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
            case TCSPackage.CONCRETE_SYNTAX__TEMPLATES:
                return ((InternalEList<?>)getTemplates()).basicRemove(otherEnd, msgs);
            case TCSPackage.CONCRETE_SYNTAX__KEYWORDS:
                return ((InternalEList<?>)getKeywords()).basicRemove(otherEnd, msgs);
            case TCSPackage.CONCRETE_SYNTAX__SYMBOLS:
                return ((InternalEList<?>)getSymbols()).basicRemove(otherEnd, msgs);
            case TCSPackage.CONCRETE_SYNTAX__OPERATOR_LISTS:
                return ((InternalEList<?>)getOperatorLists()).basicRemove(otherEnd, msgs);
            case TCSPackage.CONCRETE_SYNTAX__TOKENS:
                return ((InternalEList<?>)getTokens()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TCSPackage.CONCRETE_SYNTAX__K:
                return getK();
            case TCSPackage.CONCRETE_SYNTAX__TEMPLATES:
                return getTemplates();
            case TCSPackage.CONCRETE_SYNTAX__KEYWORDS:
                return getKeywords();
            case TCSPackage.CONCRETE_SYNTAX__SYMBOLS:
                return getSymbols();
            case TCSPackage.CONCRETE_SYNTAX__OPERATOR_LISTS:
                return getOperatorLists();
            case TCSPackage.CONCRETE_SYNTAX__TOKENS:
                return getTokens();
            case TCSPackage.CONCRETE_SYNTAX__LEXER:
                return getLexer();
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
            case TCSPackage.CONCRETE_SYNTAX__K:
                setK((Integer)newValue);
                return;
            case TCSPackage.CONCRETE_SYNTAX__TEMPLATES:
                getTemplates().clear();
                getTemplates().addAll((Collection<? extends Template>)newValue);
                return;
            case TCSPackage.CONCRETE_SYNTAX__KEYWORDS:
                getKeywords().clear();
                getKeywords().addAll((Collection<? extends Keyword>)newValue);
                return;
            case TCSPackage.CONCRETE_SYNTAX__SYMBOLS:
                getSymbols().clear();
                getSymbols().addAll((Collection<? extends Symbol>)newValue);
                return;
            case TCSPackage.CONCRETE_SYNTAX__OPERATOR_LISTS:
                getOperatorLists().clear();
                getOperatorLists().addAll((Collection<? extends OperatorList>)newValue);
                return;
            case TCSPackage.CONCRETE_SYNTAX__TOKENS:
                getTokens().clear();
                getTokens().addAll((Collection<? extends Token>)newValue);
                return;
            case TCSPackage.CONCRETE_SYNTAX__LEXER:
                setLexer((String)newValue);
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
            case TCSPackage.CONCRETE_SYNTAX__K:
                unsetK();
                return;
            case TCSPackage.CONCRETE_SYNTAX__TEMPLATES:
                getTemplates().clear();
                return;
            case TCSPackage.CONCRETE_SYNTAX__KEYWORDS:
                getKeywords().clear();
                return;
            case TCSPackage.CONCRETE_SYNTAX__SYMBOLS:
                getSymbols().clear();
                return;
            case TCSPackage.CONCRETE_SYNTAX__OPERATOR_LISTS:
                getOperatorLists().clear();
                return;
            case TCSPackage.CONCRETE_SYNTAX__TOKENS:
                getTokens().clear();
                return;
            case TCSPackage.CONCRETE_SYNTAX__LEXER:
                setLexer(LEXER_EDEFAULT);
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
            case TCSPackage.CONCRETE_SYNTAX__K:
                return isSetK();
            case TCSPackage.CONCRETE_SYNTAX__TEMPLATES:
                return templates != null && !templates.isEmpty();
            case TCSPackage.CONCRETE_SYNTAX__KEYWORDS:
                return keywords != null && !keywords.isEmpty();
            case TCSPackage.CONCRETE_SYNTAX__SYMBOLS:
                return symbols != null && !symbols.isEmpty();
            case TCSPackage.CONCRETE_SYNTAX__OPERATOR_LISTS:
                return operatorLists != null && !operatorLists.isEmpty();
            case TCSPackage.CONCRETE_SYNTAX__TOKENS:
                return tokens != null && !tokens.isEmpty();
            case TCSPackage.CONCRETE_SYNTAX__LEXER:
                return LEXER_EDEFAULT == null ? lexer != null : !LEXER_EDEFAULT.equals(lexer);
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
        result.append(" (k: ");
        if (kESet) result.append(k); else result.append("<unset>");
        result.append(", lexer: ");
        result.append(lexer);
        result.append(')');
        return result.toString();
    }

} //ConcreteSyntaxImpl
