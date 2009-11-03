package com.sap.tc.moin.repository.core.generator.jmi;

import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import com.sap.tc.moin.repository.core.generator.jmi.javamodel.JavaConstants;
import com.sap.tc.moin.repository.core.generator.jmi.javamodel.Method;

public abstract class Mof2JavaConverter {
  public static Method convertOperation2Method(Operation anOperation) {
    List operationContent = Generator.getAllContent(anOperation);
    // Mof operation name
    String operationName = Generator.getJMIIdentifier(anOperation);
    Method method = new Method(operationName);
    // Mof operation visibility
    if(VisibilityKindEnum.PUBLIC_VIS.equals(anOperation.getVisibility())) {
      method.addModifierName(JavaConstants.MODIFIER_PUBLIC);
    }
    else if(VisibilityKindEnum.PRIVATE_VIS.equals(anOperation.getVisibility())) {
      method.addModifierName(JavaConstants.MODIFIER_PRIVATE);
    }
    else if(VisibilityKindEnum.PROTECTED_VIS.equals(anOperation.getVisibility())) {
      method.addModifierName(JavaConstants.MODIFIER_PROTECTED);
    }
    // Mof operation scope
    if(ScopeKindEnum.CLASSIFIER_LEVEL.equals(anOperation.getScope())) {
      method.addModifierName(JavaConstants.MODIFIER_STATIC);
    }
    // Mof operation exceptions
    List operationExceptions = anOperation.getExceptions();
    if((operationExceptions != null)) {
      for(Iterator iter = operationExceptions.iterator(); iter.hasNext();) {
        method.addExceptionName(((MofException)iter.next()).getName());
      }
    }
    // Mof operation parameters
    if((operationContent != null)) {
      for(Iterator iter = operationContent.iterator(); iter.hasNext();) {
        Object o = iter.next();
        if(o instanceof Parameter) {
          Parameter operationParameter = (Parameter)o;
          String operationParameterName = operationParameter.getName();
          String operationParameterTypeName = operationParameter.getType().getName();
          if(operationParameter.getDirection().equals(DirectionKindEnum.RETURN_DIR)) {
  	        method.setReturnTypeName(operationParameterTypeName);
          }
          else {
            method.addParameterName(operationParameterName);
            method.addParameterTypeName(operationParameterTypeName);
          }
        }
      }
    }
    // return method
    return method;
  }
}
