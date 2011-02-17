/**
 * <copyright>
 *
 * Copyright (c) 2003-2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EMOFHelperImpl.java,v 1.22 2009/02/17 19:36:15 emerks Exp $
 */
package org.eclipse.emf.ecore.xmi.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.ECrossReferenceEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;


public class EMOFHelperImpl extends XMLHelperImpl implements EMOFHandler.Helper
{
  protected EClass propertyClass = null;
  protected List<EObject> propertyFeatureList = null;
  protected Set<EObject> objectsWithGenericTypeList = new HashSet<EObject>();

  public EMOFHelperImpl(XMLResource resource)
  {
    super(resource);
    packages.put(EcorePackage.eINSTANCE, EMOFExtendedMetaData.EMOF_PACKAGE_NS_PREFIX);
  }

  @Override
  public Object getValue(EObject object, EStructuralFeature feature)
  {
    if (feature == EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE)
    {
      return ((EStructuralFeature)object).isChangeable() ? Boolean.FALSE : Boolean.TRUE; // EMOF.isReadOnly = !Ecore.changeable
    }
    else
    {
      return super.getValue(object, feature);
    }
  }

  @Override
  public void setValue(EObject object, EStructuralFeature feature, Object value, int position)
  {
    if (feature == EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE)
    {
      ((EStructuralFeature)object).setChangeable(Boolean.FALSE.toString().equals(value)); // Ecore.changeable = !EMOF.isReadOnly
    }
    else if (feature == EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND && "*".equals(value))
    {
      ((ETypedElement)object).setUpperBound(-1);
    }
    // Don't set the type if it's already set.
    //
    else if (feature == EcorePackage.Literals.ETYPED_ELEMENT__ETYPE)
    {
      if (((ETypedElement)object).getEType() == null)
      {
        super.setValue(object, feature, value, position);
      }
    }
    else if (feature == EcorePackage.Literals.ECLASS__ESUPER_TYPES || feature == EcorePackage.Literals.EOPERATION__EEXCEPTIONS)
    {
      // Ignore it if we've already set generic versions of these
      //
      if (!objectsWithGenericTypeList.contains(object))
      {
        super.setValue(object, feature, value, position);
      }
    }
    else if (feature == EcorePackage.Literals.ECLASS__EGENERIC_SUPER_TYPES || feature == EcorePackage.Literals.EOPERATION__EGENERIC_EXCEPTIONS)
    {
      // Ignore whatever was set before.
      //
      if (objectsWithGenericTypeList.add(object))
      {
        ((InternalEList<?>)object.eGet(feature)).clear();
      }
      super.setValue(object, feature, value, position);
    }
    else
    {
      super.setValue(object, feature, value, position);
    }
  }

  @Override
  public String getHREF(EObject obj)
  {
    String href = super.getHREF(obj);
    if (href != null && href.startsWith(EMOFExtendedMetaData.ECORE_EDATATYPE_HREF_PREFIX))
    {
      String dataType = href.substring(EMOFExtendedMetaData.ECORE_EDATATYPE_HREF_PREFIX.length());
      for (int i = 0; i < EMOFExtendedMetaData.MAPPED_ECORE_EDATATYPES.length; i++)
      {
        if (dataType.equals(EMOFExtendedMetaData.MAPPED_ECORE_EDATATYPES[i]))
        {
          return EMOFExtendedMetaData.MAPPED_EMOF_EDATATYPE_HREF_PREFIX_2_0 + EMOFExtendedMetaData.MAPPED_EMOF_EDATATYPES[i];
        }
      }
      return EMOFExtendedMetaData.UNMAPPED_EMOF_EDATATYPE_HREF_PREFIX + dataType;
    }

    return href;
  }

  @Override
  public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name, boolean isElement)
  {
    if (eClass == EcorePackage.Literals.EANNOTATION && EMOFExtendedMetaData.EMOF_TAG_ELEMENT.equals(name))
    {
      return EcorePackage.Literals.EANNOTATION__REFERENCES;
    }
    else if (EcorePackage.Literals.EMODEL_ELEMENT.isSuperTypeOf(eClass) && EMOFExtendedMetaData.EMOF_OWNED_COMMENT.equals(name))
    {
      return EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS;
    }

    for (int i = 0, size = eClass.getFeatureCount(); i < size; ++i)
    {
      EStructuralFeature eStructuralFeature = eClass.getEStructuralFeature(i);
      if (name.equals(extendedMetaData.getName(eStructuralFeature)) &&
            (namespaceURI == null ? 
             extendedMetaData.getNamespace(eStructuralFeature) == null : 
             namespaceURI.equals(extendedMetaData.getNamespace(eStructuralFeature))))
      {
        computeFeatureKind(eStructuralFeature);
        return eStructuralFeature;
      }
    }

    return null;
  }

  @Override
  public EClassifier getType(EFactory eFactory, String typeName)
  {
    EPackage ePackage = eFactory.getEPackage();
    if (ePackage == EcorePackage.eINSTANCE)
    {
      if (EcorePackage.Literals.ESTRUCTURAL_FEATURE.getName().equals(typeName) || "Property".equals(typeName))
      {
        if (propertyClass == null)
        {
          propertyClass = EcoreFactory.eINSTANCE.createEClass();
          propertyClass.getESuperTypes().add(EcorePackage.Literals.EREFERENCE);
          propertyClass.getESuperTypes().add(EcorePackage.Literals.EATTRIBUTE);
          propertyClass.setName("EMOFProperty");

          EPackage propertyPackage = EcoreFactory.eINSTANCE.createEPackage();
          propertyPackage.getEClassifiers().add(propertyClass);

          propertyFeatureList = new ArrayList<EObject>();
        }
        return propertyClass;
      }
      else if (EMOFExtendedMetaData.TAG.equals(typeName))
      {
        return EcorePackage.Literals.EANNOTATION;
      }
    }
    return super.getType(eFactory, typeName);
  }
  
  private static final Integer ONE = 1;

  @Override
  public EObject createObject(EFactory eFactory, EClassifier type)
  {
    if (type == propertyClass && propertyClass != null)
    {
      EObject property = propertyClass.getEPackage().getEFactoryInstance().create(propertyClass);
      property.eSet(EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND, ONE);
      property.eSet(EcorePackage.Literals.ETYPED_ELEMENT__ORDERED, Boolean.FALSE);
      propertyFeatureList.add(property);
      return property;
    }
    else if (EcorePackage.Literals.EANNOTATION == type)
    {
      EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
      annotation.setSource(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
      return annotation;
    }
    else if (EcorePackage.Literals.EOPERATION == type)
    {
      EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
      eOperation.setLowerBound(1);
      eOperation.setOrdered(false);
      return eOperation;
    }
    else if (EcorePackage.Literals.EPARAMETER == type)
    {
      EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
      eParameter.setLowerBound(1);
      eParameter.setOrdered(false);
      return eParameter;
    }
    return super.createObject(eFactory, type);
  }

  public void convertPropertyFeatures()
  {
    if (propertyFeatureList != null)
    {
      EcoreUtil.Copier copier = 
        new EcoreUtil.Copier(false)
        {
          private static final long serialVersionUID = 1L;

          @Override
          protected EObject createCopy(EObject eObject)
          {
            EClass eClass = 
              ((EStructuralFeature)eObject).getEType() instanceof EDataType ?
                  EcorePackage.Literals.EATTRIBUTE :
                  EcorePackage.Literals.EREFERENCE;
            return EcoreUtil.create(eClass);
          }
          @Override
          protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject)
          {
            // The eAnnotations and eGenericType are possible containment references. 
            // We'll move them instead of copying
            //
            if (eReference == EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE)
            {
              ((ETypedElement)copyEObject).setEGenericType(((ETypedElement)eObject).getEGenericType());
            }
            else
            {
              ((EStructuralFeature)copyEObject).getEAnnotations().addAll(((EStructuralFeature)eObject).getEAnnotations());
            }
          }
          @Override
          protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject)
          {
            if (copyEObject.eClass().getEAllStructuralFeatures().contains(eAttribute))
            {
              super.copyAttribute(eAttribute, eObject, copyEObject);
            }
          }
        };
      copier.copyAll(propertyFeatureList);
      copier.copyReferences();

      for (Map.Entry<EObject, EObject> entry : copier.entrySet())
      {
        EStructuralFeature emofFeature = (EStructuralFeature)entry.getKey();
        EStructuralFeature ecoreFeature = (EStructuralFeature)entry.getValue();
        resource.setID(ecoreFeature, resource.getID(emofFeature));
        EObject eObject = emofFeature.eContainer();
        @SuppressWarnings("unchecked")
        List<EObject> list = (List<EObject>)eObject.eGet(emofFeature.eContainmentFeature());
        list.set(list.indexOf(emofFeature), ecoreFeature);
      }

      for (TreeIterator<Notifier> contents = EcoreUtil.getAllContents(resource.getContents(), false); contents.hasNext(); )
      {
        EObject eObject = (EObject)contents.next();
        for (EContentsEList.FeatureIterator<EObject> featureIterator = 
               new ECrossReferenceEList.FeatureIteratorImpl<EObject>(eObject) 
               {
                 @Override
                protected boolean isIncluded(EStructuralFeature eStructuralFeature)
                {
                  return !eStructuralFeature.isDerived() && super.isIncluded(eStructuralFeature);
                }
               };
             featureIterator.hasNext(); )
        {
          EObject targetEObject = featureIterator.next();
          EObject copyEObject = copier.get(targetEObject);
          if (copyEObject != null)
          {
            EReference eReference = (EReference)featureIterator.feature();
            if (eReference.isMany())
            {
              @SuppressWarnings("unchecked") List<EObject> list = (List<EObject>)eObject.eGet(eReference);
              list.set(list.indexOf(targetEObject), copyEObject);
            }
            else
            {
              eObject.eSet(eReference, copyEObject);
            }
          }
        }
      }
    }
  }
}
