/**
 * 
 */
package com.sap.furcas.runtime.parser.textblocks;

import java.lang.reflect.InvocationTargetException;

import org.antlr.runtime.CharStream;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.LexedToken;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.metamodel.FURCAS.textblocks.Version;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;


/**
 * 
 */
public class LexedTokenWrapper implements ANTLR3LocationToken, LexedToken {

	private final LexedToken wrappedToken;
	private int channel = DEFAULT_CHANNEL;
	private int positionInLine = -1;
	private int tokenIndex = -1;

	public LexedTokenWrapper(LexedToken wrappedToken) {
		this.wrappedToken = wrappedToken;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken#getEndColumn()
	 */
	@Override
	public int getEndColumn() {
		return wrappedToken.getEndColumn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken#getEndLine()
	 */
	@Override
	public int getEndLine() {
		return wrappedToken.getEndRow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken#getStartIndex()
	 */
	@Override
	public int getStartIndex() {
		return wrappedToken.getOffset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken#getStopIndex()
	 */
	@Override
	public int getStopIndex() {
		return wrappedToken.getOffset() + wrappedToken.getLength();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken#setEndColumn(int)
	 */
	@Override
	public void setEndColumn(int endColumn) {
		wrappedToken.setEndColumn(endColumn);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken#setEndLine(int)
	 */
	@Override
	public void setEndLine(int endLine) {
		wrappedToken.setEndRow(endLine);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken#setStartIndex(int)
	 */
	@Override
	public void setStartIndex(int arg0) {
		wrappedToken.setOffset(arg0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken#setStopIndex(int)
	 */
	@Override
	public void setStopIndex(int arg0) {
		// TODO change ANTLR3LocationToken Interface if required at all
		// (Probably should never happen)
		throw new RuntimeException(
				"Wrapper does not support setting of stopIndex");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#getChannel()
	 */
	@Override
	public int getChannel() {

		return channel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#getCharPositionInLine()
	 */
	@Override
	public int getCharPositionInLine() {
		return positionInLine;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#getLine()
	 */
	@Override
	public int getLine() {
		return wrappedToken.getStartRow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#getText()
	 */
	@Override
	public String getText() {

		return getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#getTokenIndex()
	 */
	@Override
	public int getTokenIndex() {
		return tokenIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#getType()
	 */
	@Override
	public int getType() {
		return wrappedToken.getType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#setChannel(int)
	 */
	@Override
	public void setChannel(int channel) {
		this.channel = channel;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#setCharPositionInLine(int)
	 */
	@Override
	public void setCharPositionInLine(int pos) {
		this.positionInLine = pos;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#setLine(int)
	 */
	@Override
	public void setLine(int line) {
		wrappedToken.setStartRow(line);
		wrappedToken.setEndRow(line);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#setText(java.lang.String)
	 */
	@Override
	public void setText(String text) {
		wrappedToken.setValue(text);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#setTokenIndex(int)
	 */
	@Override
	public void setTokenIndex(int index) {
		this.tokenIndex = index;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.antlr.runtime.Token#setType(int)
	 */
	@Override
	public void setType(int ttype) {
		wrappedToken.setType(ttype);

	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.LexedToken#getSequenceElement()
	 */
	@Override
	public SequenceElement getSequenceElement() {

		return wrappedToken.getSequenceElement();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.LexedToken#setSequenceElement(tcs.SequenceElement)
	 */
	@Override
	public void setSequenceElement(SequenceElement newValue) {
		wrappedToken.setSequenceElement(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getLookahead()
	 */
	@Override
	public int getLookahead() {

		return wrappedToken.getLookahead();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getLookback()
	 */
	@Override
	public int getLookback() {

		return wrappedToken.getLookback();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getParentBlock()
	 */
	@Override
	public TextBlock getParent() {

		return wrappedToken.getParent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getState()
	 */
	@Override
	public int getState() {

		return wrappedToken.getState();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getValue()
	 */
	@Override
	public String getValue() {
		return wrappedToken.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setLookahead(int)
	 */
	@Override
	public void setLookahead(int newValue) {
		wrappedToken.setLookahead(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setLookback(int)
	 */
	@Override
	public void setLookback(int newValue) {
		wrappedToken.setLookback(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setParentBlock(textblocks.TextBlock)
	 */
	@Override
	public void setParent(TextBlock newValue) {
		wrappedToken.setParent(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setState(int)
	 */
	@Override
	public void setState(int newValue) {
		wrappedToken.setState(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setValue(java.lang.String)
	 */
	@Override
	public void setValue(String newValue) {
		wrappedToken.setValue(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getAbsoluteOffset()
	 */
	@Override
	public int getAbsoluteOffset() {

		return wrappedToken.getOffset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getCorrespondingModelElements()
	 */
	@Override
	public EList<EObject> getCorrespondingModelElements() {

		return wrappedToken.getCorrespondingModelElements();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getEndRow()
	 */
	@Override
	public int getEndRow() {

		return wrappedToken.getEndRow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getLength()
	 */
	@Override
	public int getLength() {

		return wrappedToken.getLength();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getOffset()
	 */
	@Override
	public int getOffset() {

		return wrappedToken.getOffset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getOtherVersions()
	 */
	@Override
	public EList<DocumentNode> getOtherVersions() {

		return wrappedToken.getOtherVersions();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getStartColumn()
	 */
	@Override
	public int getStartColumn() {

		return wrappedToken.getStartColumn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getStartRow()
	 */
	@Override
	public int getStartRow() {

		return wrappedToken.getStartRow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getVersion()
	 */
	@Override
	public Version getVersion() {

		return wrappedToken.getVersion();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#isChildrenChanged()
	 */
	@Override
	public boolean isChildrenChanged() {

		return wrappedToken.isChildrenChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#isOffsetRelative()
	 */
	@Override
	public boolean isOffsetRelative() {

		return wrappedToken.isOffsetRelative();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#isRelexingNeeded()
	 */
	@Override
	public boolean isRelexingNeeded() {

		return wrappedToken.isRelexingNeeded();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setChildrenChanged(boolean)
	 */
	@Override
	public void setChildrenChanged(boolean newValue) {
		wrappedToken.setChildrenChanged(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setEndRow(int)
	 */
	@Override
	public void setEndRow(int newValue) {
		wrappedToken.setEndRow(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setLength(int)
	 */
	@Override
	public void setLength(int newValue) {
		wrappedToken.setLength(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setOffset(int)
	 */
	@Override
	public void setOffset(int newValue) {
		wrappedToken.setOffset(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setOffsetRelative(boolean)
	 */
	@Override
	public void setOffsetRelative(boolean newValue) {
		wrappedToken.setOffsetRelative(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setRelexingNeeded(boolean)
	 */
	@Override
	public void setRelexingNeeded(boolean newValue) {
		wrappedToken.setRelexingNeeded(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setStartColumn(int)
	 */
	@Override
	public void setStartColumn(int newValue) {
		wrappedToken.setStartColumn(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setStartRow(int)
	 */
	@Override
	public void setStartRow(int newValue) {
		wrappedToken.setStartRow(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setVersion(textblocks.Version)
	 */
	@Override
	public void setVersion(Version newValue) {
		wrappedToken.setVersion(newValue);

	}


	@Override
	public CharStream getInputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInputStream(CharStream input) {
		// TODO Auto-generated method stub

	}

	
	public LexedToken getWrappedToken() {
	    return wrappedToken;
	}

	@Override
	public EList<EObject> getReferencedElements() {
	    return wrappedToken.getReferencedElements();
	}

    @Override
    public boolean isOperator() {
        return wrappedToken.isOperator();
    }

    @Override
    public void setOperator(boolean newValue) {
        wrappedToken.setOperator(newValue);
    }

	@Override
	public EClass eClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource eResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EObject eContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eIsProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments)
			throws InvocationTargetException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EList<Adapter> eAdapters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eDeliver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eNotify(Notification notification) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAbsoluteOffset(int value) {
		// TODO Auto-generated method stub
		
	}

}
