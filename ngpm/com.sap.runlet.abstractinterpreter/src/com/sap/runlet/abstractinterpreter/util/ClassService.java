package com.sap.runlet.abstractinterpreter.util;

import java.util.Collection;

public interface ClassService<LinkEndMetaObject, ClassUsage, MetaClass> {
    MetaClass getClazz(ClassUsage classUsage);
    String getClassUsageName(ClassUsage classUsage);
    String getClassName(MetaClass clazz);
    boolean isValueType(MetaClass clazz);
    Collection<LinkEndMetaObject> getConformsToCompositeChildAssociationEnds(MetaClass clazz);
}
