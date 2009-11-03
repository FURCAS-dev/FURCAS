package org.oslo.ocl20.standard.lib;

public interface OclVisitor {
	public Object visit(OclBoolean host, Object data);
    public Object visit(OclInteger host, Object data);
    public Object visit(OclReal host, Object data);
    public Object visit(OclString host, Object data);
	public Object visit(OclCollection host, Object data);
	public Object visit(OclSequence host, Object data);
    public Object visit(OclSet host, Object data);
	public Object visit(OclOrderedSet host, Object data);
    public Object visit(OclBag host, Object data);
    public Object visit(OclTuple host, Object data);
	public Object visit(OclUndefined host, Object data);
}
