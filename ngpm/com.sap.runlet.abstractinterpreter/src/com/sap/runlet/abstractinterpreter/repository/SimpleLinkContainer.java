package com.sap.runlet.abstractinterpreter.repository;

import com.sap.runlet.abstractinterpreter.objects.Link;

public interface SimpleLinkContainer<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage extends TypeUsage> {

    public void addLink(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at);

    public void removeLink(Link<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage> link, Integer at);

}
