package com.sap.tc.moin.repository.core.generator.jmi.javamodel;

import java.util.ArrayList;
import java.util.List;

public class Method {
  private MethodSignature signature = null;
  private String returnTypeName = JavaConstants.VOID;
  private List modifierNames = new ArrayList(); // e.g. public, static, final
  private List parameterNames = new ArrayList();
  private List exceptionNames = new ArrayList();
  public Method(String aName) {
    signature = new MethodSignature(aName);
  }
  public Method(String aName, String aReturnTypeName) {
    signature = new MethodSignature(aName);
    returnTypeName = aReturnTypeName;
  }
  public void setReturnTypeName(String aReturnTypeName) {
    returnTypeName = aReturnTypeName;
  }
  public void setModifierNames(List theModifierNames) {
    modifierNames = theModifierNames;
  }
  public void setParameterTypeNames(List theParameterTypeNames) {
    signature.setParameterTypeNames(theParameterTypeNames);
  }
  public void setParameterNames(List theParameterNames) {
    parameterNames = theParameterNames;
  }
  public void setExceptionNames(List theExceptionNames) {
    exceptionNames = theExceptionNames;
  }
  public void addModifierName(String aModifierName) {
    modifierNames.add(aModifierName);
  }
  public void addParameterTypeName(String aParameterTypeName) {
    signature.addParameterTypeName(aParameterTypeName);
  }
  public void addParameterName(String aParameterName) {
    parameterNames.add(aParameterName);
  }
  public void addExceptionName(String anExceptionName) {
    exceptionNames.add(anExceptionName);
  }
  public String getName() {
    return signature.getMethodName();
  }
  public String getReturnTypeName() {
    return returnTypeName;
  }
  public List getModifierNames() {
    return modifierNames;
  }
  public List getParameterTypeNames() {
    return signature.getParameterTypeNames();
  }
  public List getParameterNames() {
    return parameterNames;
  }
  public List getExceptionNames() {
    return exceptionNames;
  }
  public MethodSignature getSignature() {
    return signature;
  }
}