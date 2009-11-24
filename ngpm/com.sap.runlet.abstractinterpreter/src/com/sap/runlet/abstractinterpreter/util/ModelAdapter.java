package com.sap.runlet.abstractinterpreter.util;


public interface ModelAdapter<LinkMetaObject, LinkEndMetaObject, MetaClass, TypeUsage, ClassUsage extends TypeUsage>
extends TypeService<TypeUsage>,
	ClassAndAssociationEndService<LinkEndMetaObject, MetaClass, ClassUsage>,
	AssociationService<LinkMetaObject, LinkEndMetaObject, MetaClass, ClassUsage> {
}
