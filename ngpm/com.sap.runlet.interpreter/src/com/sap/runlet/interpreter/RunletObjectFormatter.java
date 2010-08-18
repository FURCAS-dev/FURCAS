package com.sap.runlet.interpreter;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.sap.runlet.abstractinterpreter.AbstractObjectFormatter;
import com.sap.runlet.abstractinterpreter.objects.RunletObject;

import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.Signature;
import data.classes.SignatureImplementation;
import data.classes.TypeDefinition;

public class RunletObjectFormatter implements
	AbstractObjectFormatter<AssociationEnd, TypeDefinition, ClassTypeDefinition, SignatureImplementation> {

    @Override
    public String formatSignatureOfImpl(SignatureImplementation currentlyExecutingImplementation) {
	return StringFormatter.toString(currentlyExecutingImplementation.getImplementedSignature());
    }

    @Override
    public String formatType(RunletObject<AssociationEnd, TypeDefinition, ClassTypeDefinition> value) {
	return StringFormatter.toString(value.getType());
    }

    @Override
    public String formatOwnerOfSignatureOfImpl(SignatureImplementation signatureImpl) {
	return signatureImpl.getImplements_().getOwner().getName();
    }

    @Override
    public String formatCurrentlyEvaluatingRefObject(EObject currentlyEvaluating) {
	StringBuilder result = new StringBuilder();
	if (currentlyEvaluating instanceof Signature) {
	    result.append(StringFormatter.toString((Signature) currentlyEvaluating));
	} else {
	    Method getName;
	    try {
		getName = currentlyEvaluating.getClass().getMethod("getName");
		if (getName != null) {
		    result.append(getName.invoke(currentlyEvaluating));
		}
	    } catch (Exception e) {
		// just don't add result of getName() then...
	    }
	    result.append(':');
	    result.append(((EClass) currentlyEvaluating.refMetaObject()).getName());
	}
	return result.toString();
    }

}
