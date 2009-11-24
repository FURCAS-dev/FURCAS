package com.sap.runlet.abstractinterpreter.util;

import java.util.Collection;

import com.sap.runlet.abstractinterpreter.Side;

public interface AssociationEndService<LinkEndMetaObject, MetaClass, ClassUsage> {
    String getEndName(LinkEndMetaObject end);
    MetaClass getEndType(LinkEndMetaObject end);
    ClassUsage getClassUsage(LinkEndMetaObject end);
    boolean isUnique(LinkEndMetaObject end);
    boolean isOrdered(LinkEndMetaObject end);
    Side getSideOfEnd(LinkEndMetaObject end);
    LinkEndMetaObject otherEnd(LinkEndMetaObject end);
    Collection<LinkEndMetaObject> getConformsToAssociationEnds(MetaClass clazz);
    Collection<LinkEndMetaObject> getEqualityRelevantAssociationEnds(MetaClass clazz);
    boolean isContributesToEquality(LinkEndMetaObject end);
    boolean isComposite(LinkEndMetaObject end);
    boolean isMany(LinkEndMetaObject end);
}
