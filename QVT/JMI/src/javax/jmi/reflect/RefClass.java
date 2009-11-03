package javax.jmi.reflect;

import java.util.*;

public interface RefClass extends RefFeatured {
    public RefObject refCreateInstance(List args);
    public Collection refAllOfType();
    public Collection refAllOfClass();
    public RefStruct refCreateStruct(RefObject struct, List params);
    public RefStruct refCreateStruct(String structName, List params);
    public RefEnum refGetEnum(RefObject enumeration, String name);
    public RefEnum refGetEnum(String enumName, String name);
}