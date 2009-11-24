package com.sap.runlet.abstractinterpreter.util;

/**
 * Set of model services that get along with the three type arguments used here.
 * 
 * @author Axel Uhl D043530
 */
public interface ClassAndAssociationEndService<LinkEndMetaObject, MetaClass, ClassUsage>
extends AssociationEndService<LinkEndMetaObject, MetaClass, ClassUsage>,
	ClassService<LinkEndMetaObject, ClassUsage, MetaClass> {

}
