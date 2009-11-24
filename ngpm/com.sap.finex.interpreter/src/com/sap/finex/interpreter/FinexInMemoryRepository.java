package com.sap.finex.interpreter;

import structure.Association;
import structure.Field;
import structure.FinexClass;
import structure.Type;

import com.sap.runlet.abstractinterpreter.repository.simpleimpl.InMemoryRepository;

public class FinexInMemoryRepository extends InMemoryRepository<Association, Field, FinexClass, Type, FinexClass> {

    public FinexInMemoryRepository(FinexModelAdapter modelAdapter) {
	super(modelAdapter);
    }
}
