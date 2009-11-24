package com.sap.runlet.abstractinterpreter.util;

public interface TypeService<TypeUsage> {
    boolean aConformsToB(TypeUsage a, TypeUsage b);
}
