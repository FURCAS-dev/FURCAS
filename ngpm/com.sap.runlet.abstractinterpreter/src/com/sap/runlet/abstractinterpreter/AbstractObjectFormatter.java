package com.sap.runlet.abstractinterpreter;

import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;

public interface AbstractObjectFormatter<LinkEndMetaObject, TypeUsage, ClassUsage extends TypeUsage,
SignatureImplementationType> {

    String formatType(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> value);

    String formatSignatureOfImpl(SignatureImplementationType signatureImpl);

    String formatOwnerOfSignatureOfImpl(SignatureImplementationType signatureImpl);

    String formatCurrentlyEvaluatingEObject(EObject currentlyEvaluating);
}
