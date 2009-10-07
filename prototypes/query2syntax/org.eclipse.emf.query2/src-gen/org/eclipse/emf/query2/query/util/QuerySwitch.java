/**
 * <copyright>
 * </copyright>
 *

 */
package org.eclipse.emf.query2.query.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.query.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.query2.query.QueryPackage
 * @generated
 */
public class QuerySwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static QueryPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuerySwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = QueryPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case QueryPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.NAMED_QUERY:
      {
        NamedQuery namedQuery = (NamedQuery)theEObject;
        T result = caseNamedQuery(namedQuery);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.MQ_LQUERY:
      {
        MQLquery mqLquery = (MQLquery)theEObject;
        T result = caseMQLquery(mqLquery);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.SELECT_ENTRY:
      {
        SelectEntry selectEntry = (SelectEntry)theEObject;
        T result = caseSelectEntry(selectEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.FROM_ENTRY:
      {
        FromEntry fromEntry = (FromEntry)theEObject;
        T result = caseFromEntry(fromEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.SCOPE_CLAUSE:
      {
        ScopeClause scopeClause = (ScopeClause)theEObject;
        T result = caseScopeClause(scopeClause);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.RESOURCE_SCOPE:
      {
        ResourceScope resourceScope = (ResourceScope)theEObject;
        T result = caseResourceScope(resourceScope);
        if (result == null) result = caseScopeClause(resourceScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.ELEMENT_SCOPE:
      {
        ElementScope elementScope = (ElementScope)theEObject;
        T result = caseElementScope(elementScope);
        if (result == null) result = caseScopeClause(elementScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.WHERE_ENTRY:
      {
        WhereEntry whereEntry = (WhereEntry)theEObject;
        T result = caseWhereEntry(whereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.ATTRIBUTE_WHERE_ENTRY:
      {
        AttributeWhereEntry attributeWhereEntry = (AttributeWhereEntry)theEObject;
        T result = caseAttributeWhereEntry(attributeWhereEntry);
        if (result == null) result = caseWhereEntry(attributeWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.NUMERIC_ATTRIBUTE_WHERE_ENTRY:
      {
        NumericAttributeWhereEntry numericAttributeWhereEntry = (NumericAttributeWhereEntry)theEObject;
        T result = caseNumericAttributeWhereEntry(numericAttributeWhereEntry);
        if (result == null) result = caseAttributeWhereEntry(numericAttributeWhereEntry);
        if (result == null) result = caseWhereEntry(numericAttributeWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.DOUBLE_WHERE_ENTRY:
      {
        DoubleWhereEntry doubleWhereEntry = (DoubleWhereEntry)theEObject;
        T result = caseDoubleWhereEntry(doubleWhereEntry);
        if (result == null) result = caseNumericAttributeWhereEntry(doubleWhereEntry);
        if (result == null) result = caseAttributeWhereEntry(doubleWhereEntry);
        if (result == null) result = caseWhereEntry(doubleWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.LONG_WHERE_ENTRY:
      {
        LongWhereEntry longWhereEntry = (LongWhereEntry)theEObject;
        T result = caseLongWhereEntry(longWhereEntry);
        if (result == null) result = caseNumericAttributeWhereEntry(longWhereEntry);
        if (result == null) result = caseAttributeWhereEntry(longWhereEntry);
        if (result == null) result = caseWhereEntry(longWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.VARIABLE_WHERE_ENTRY:
      {
        VariableWhereEntry variableWhereEntry = (VariableWhereEntry)theEObject;
        T result = caseVariableWhereEntry(variableWhereEntry);
        if (result == null) result = caseAttributeWhereEntry(variableWhereEntry);
        if (result == null) result = caseWhereEntry(variableWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.STRING_ATTRIBUTE_WHERE_ENTRY:
      {
        StringAttributeWhereEntry stringAttributeWhereEntry = (StringAttributeWhereEntry)theEObject;
        T result = caseStringAttributeWhereEntry(stringAttributeWhereEntry);
        if (result == null) result = caseAttributeWhereEntry(stringAttributeWhereEntry);
        if (result == null) result = caseWhereEntry(stringAttributeWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.BOOLEAN_ATTRIBUTE_WHERE_ENTRY:
      {
        BooleanAttributeWhereEntry booleanAttributeWhereEntry = (BooleanAttributeWhereEntry)theEObject;
        T result = caseBooleanAttributeWhereEntry(booleanAttributeWhereEntry);
        if (result == null) result = caseAttributeWhereEntry(booleanAttributeWhereEntry);
        if (result == null) result = caseWhereEntry(booleanAttributeWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.REFERENCE_WHERE_ENTRY:
      {
        ReferenceWhereEntry referenceWhereEntry = (ReferenceWhereEntry)theEObject;
        T result = caseReferenceWhereEntry(referenceWhereEntry);
        if (result == null) result = caseWhereEntry(referenceWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.NULL_WHERE_ENTRY:
      {
        NullWhereEntry nullWhereEntry = (NullWhereEntry)theEObject;
        T result = caseNullWhereEntry(nullWhereEntry);
        if (result == null) result = caseWhereEntry(nullWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.REFERENCE_ALIAS_WHERE_ENTRY:
      {
        ReferenceAliasWhereEntry referenceAliasWhereEntry = (ReferenceAliasWhereEntry)theEObject;
        T result = caseReferenceAliasWhereEntry(referenceAliasWhereEntry);
        if (result == null) result = caseReferenceWhereEntry(referenceAliasWhereEntry);
        if (result == null) result = caseWhereEntry(referenceAliasWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.SUBSELECT_WHERE_ENTRY:
      {
        SubselectWhereEntry subselectWhereEntry = (SubselectWhereEntry)theEObject;
        T result = caseSubselectWhereEntry(subselectWhereEntry);
        if (result == null) result = caseReferenceWhereEntry(subselectWhereEntry);
        if (result == null) result = caseWhereEntry(subselectWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.ALIAS_WHERE_ENTRY:
      {
        AliasWhereEntry aliasWhereEntry = (AliasWhereEntry)theEObject;
        T result = caseAliasWhereEntry(aliasWhereEntry);
        if (result == null) result = caseWhereEntry(aliasWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.OR_WHERE_ENTRY:
      {
        OrWhereEntry orWhereEntry = (OrWhereEntry)theEObject;
        T result = caseOrWhereEntry(orWhereEntry);
        if (result == null) result = caseWhereEntry(orWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case QueryPackage.AND_WHERE_ENTRY:
      {
        AndWhereEntry andWhereEntry = (AndWhereEntry)theEObject;
        T result = caseAndWhereEntry(andWhereEntry);
        if (result == null) result = caseWhereEntry(andWhereEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Query</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Query</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedQuery(NamedQuery object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>MQ Lquery</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>MQ Lquery</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMQLquery(MQLquery object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Select Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Select Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelectEntry(SelectEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>From Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>From Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFromEntry(FromEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scope Clause</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scope Clause</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScopeClause(ScopeClause object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Resource Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Resource Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResourceScope(ResourceScope object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementScope(ElementScope object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhereEntry(WhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeWhereEntry(AttributeWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numeric Attribute Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numeric Attribute Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericAttributeWhereEntry(NumericAttributeWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Double Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Double Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDoubleWhereEntry(DoubleWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Long Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Long Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLongWhereEntry(LongWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableWhereEntry(VariableWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Attribute Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Attribute Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringAttributeWhereEntry(StringAttributeWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Attribute Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Attribute Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanAttributeWhereEntry(BooleanAttributeWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceWhereEntry(ReferenceWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNullWhereEntry(NullWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Reference Alias Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Reference Alias Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferenceAliasWhereEntry(ReferenceAliasWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subselect Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subselect Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubselectWhereEntry(SubselectWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alias Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alias Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAliasWhereEntry(AliasWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrWhereEntry(OrWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And Where Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And Where Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAndWhereEntry(AndWhereEntry object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //QuerySwitch
