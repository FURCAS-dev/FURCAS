package com.sap.runlet.interpreter.repository.simpleimpl;

import com.sap.runlet.abstractinterpreter.repository.simpleimpl.InMemoryRepository;
import com.sap.runlet.abstractinterpreter.util.ModelAdapter;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

public class RunletInMemoryRepository extends InMemoryRepository<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> {

    public RunletInMemoryRepository(ModelAdapter<Association, AssociationEnd, SapClass, TypeDefinition, ClassTypeDefinition> modelAdapter) {
	super(modelAdapter);
    }
}
