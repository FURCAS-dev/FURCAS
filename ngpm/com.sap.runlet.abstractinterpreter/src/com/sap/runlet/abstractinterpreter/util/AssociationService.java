package com.sap.runlet.abstractinterpreter.util;

import java.util.List;


/**
 * Offers a few services on an association, such as fetching its name or
 * fetching its ends.
 * 
 * @author Axel Uhl D043530
 */
public interface AssociationService<LinkMetaObject, LinkEndMetaObject, MetaClass, ClassUsage>
extends AssociationEndService<LinkEndMetaObject, MetaClass, ClassUsage>{
    String getAssociationName(LinkMetaObject association);
    List<LinkEndMetaObject> getEnds(LinkMetaObject association);
    LinkMetaObject getAssociation(LinkEndMetaObject end);
}
