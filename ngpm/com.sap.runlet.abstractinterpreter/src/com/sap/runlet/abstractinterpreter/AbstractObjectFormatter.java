package com.sap.runlet.abstractinterpreter;

import com.sap.runlet.abstractinterpreter.objects.RunletObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public interface AbstractObjectFormatter<LinkEndMetaObject, TypeUsage, ClassUsage extends TypeUsage,
SignatureImplementationType> {

    String formatType(RunletObject<LinkEndMetaObject, TypeUsage, ClassUsage> value);

    String formatSignatureOfImpl(SignatureImplementationType signatureImpl);

    String formatOwnerOfSignatureOfImpl(SignatureImplementationType signatureImpl);

    String formatCurrentlyEvaluatingRefObject(RefObject currentlyEvaluating);
}
