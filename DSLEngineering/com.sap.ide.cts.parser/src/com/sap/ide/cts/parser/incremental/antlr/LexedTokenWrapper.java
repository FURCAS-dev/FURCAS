/**
 * 
 */
package com.sap.ide.cts.parser.incremental.antlr;

import java.util.Collection;
import java.util.List;

import org.antlr.runtime.CharStream;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xml.type.internal.DataValue.URI;

import com.sap.furcas.metamodel.TCS.FunctionCall;
import com.sap.furcas.metamodel.TCS.SequenceElement;
import com.sap.furcas.metamodel.textblocks.DocumentNode;
import com.sap.furcas.metamodel.textblocks.LexedToken;
import com.sap.furcas.metamodel.textblocks.TextBlock;
import com.sap.furcas.metamodel.textblocks.Version;
import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken;


/**
 * 
 */
public class LexedTokenWrapper implements ANTLR3LocationToken, LexedToken {

	private LexedToken wrappedToken;
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
	 * @see textblocks.LexedToken#getParentFunctionCall()
	 */
	@Override
	public FunctionCall getParentFunctionCall() throws JmiException {

		return wrappedToken.getParentFunctionCall();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.LexedToken#getSequenceElement()
	 */
	@Override
	public SequenceElement getSequenceElement() throws JmiException {

		return wrappedToken.getSequenceElement();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.LexedToken#setParentFunctionCall(tcs.FunctionCall)
	 */
	@Override
	public void setParentFunctionCall(FunctionCall newValue)
			throws JmiException {
		wrappedToken.setParentFunctionCall(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.LexedToken#setSequenceElement(tcs.SequenceElement)
	 */
	@Override
	public void setSequenceElement(SequenceElement newValue)
			throws JmiException {
		wrappedToken.setSequenceElement(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getLookahead()
	 */
	@Override
	public int getLookahead() throws JmiException {

		return wrappedToken.getLookahead();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getLookback()
	 */
	@Override
	public int getLookback() throws JmiException {

		return wrappedToken.getLookback();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getParentBlock()
	 */
	@Override
	public TextBlock getParentBlock() throws JmiException {

		return wrappedToken.getParent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getState()
	 */
	@Override
	public int getState() throws JmiException {

		return wrappedToken.getState();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#getValue()
	 */
	@Override
	public String getValue() throws JmiException {
		return wrappedToken.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setLookahead(int)
	 */
	@Override
	public void setLookahead(int newValue) throws JmiException {
		wrappedToken.setLookahead(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setLookback(int)
	 */
	@Override
	public void setLookback(int newValue) throws JmiException {
		wrappedToken.setLookback(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setParentBlock(textblocks.TextBlock)
	 */
	@Override
	public void setParentBlock(TextBlock newValue) throws JmiException {
		wrappedToken.setParent(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setState(int)
	 */
	@Override
	public void setState(int newValue) throws JmiException {
		wrappedToken.setState(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.AbstractToken#setValue(java.lang.String)
	 */
	@Override
	public void setValue(String newValue) throws JmiException {
		wrappedToken.setValue(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getAbsoluteOffset()
	 */
	@Override
	public int getAbsoluteOffset() throws JmiException {

		return wrappedToken.getAbsoluteOffset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getCorrespondingModelElements()
	 */
	@Override
	public List<EObject> getCorrespondingModelElements() throws JmiException {

		return wrappedToken.getCorrespondingModelElements();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getEndRow()
	 */
	@Override
	public int getEndRow() throws JmiException {

		return wrappedToken.getEndRow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getLength()
	 */
	@Override
	public int getLength() throws JmiException {

		return wrappedToken.getLength();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getOffset()
	 */
	@Override
	public int getOffset() throws JmiException {

		return wrappedToken.getOffset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getOtherVersions()
	 */
	@Override
	public List<DocumentNode> getOtherVersions() throws JmiException {

		return wrappedToken.getOtherVersions();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getStartColumn()
	 */
	@Override
	public int getStartColumn() throws JmiException {

		return wrappedToken.getStartColumn();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getStartRow()
	 */
	@Override
	public int getStartRow() throws JmiException {

		return wrappedToken.getStartRow();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#getVersion()
	 */
	@Override
	public Version getVersion() throws JmiException {

		return wrappedToken.getVersion();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#isChildrenChanged()
	 */
	@Override
	public boolean isChildrenChanged() throws JmiException {

		return wrappedToken.isChildrenChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#isOffsetRelative()
	 */
	@Override
	public boolean isOffsetRelative() throws JmiException {

		return wrappedToken.isOffsetRelative();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#isRelexingNeeded()
	 */
	@Override
	public boolean isRelexingNeeded() throws JmiException {

		return wrappedToken.isRelexingNeeded();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setChildrenChanged(boolean)
	 */
	@Override
	public void setChildrenChanged(boolean newValue) throws JmiException {
		wrappedToken.setChildrenChanged(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setEndRow(int)
	 */
	@Override
	public void setEndRow(int newValue) throws JmiException {
		wrappedToken.setEndRow(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setLength(int)
	 */
	@Override
	public void setLength(int newValue) throws JmiException {
		wrappedToken.setLength(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setOffset(int)
	 */
	@Override
	public void setOffset(int newValue) throws JmiException {
		wrappedToken.setOffset(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setOffsetRelative(boolean)
	 */
	@Override
	public void setOffsetRelative(boolean newValue) throws JmiException {
		wrappedToken.setOffsetRelative(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setRelexingNeeded(boolean)
	 */
	@Override
	public void setRelexingNeeded(boolean newValue) throws JmiException {
		wrappedToken.setRelexingNeeded(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setStartColumn(int)
	 */
	@Override
	public void setStartColumn(int newValue) throws JmiException {
		wrappedToken.setStartColumn(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setStartRow(int)
	 */
	@Override
	public void setStartRow(int newValue) throws JmiException {
		wrappedToken.setStartRow(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see textblocks.DocumentNode#setVersion(textblocks.Version)
	 */
	@Override
	public void setVersion(Version newValue) throws JmiException {
		wrappedToken.setVersion(newValue);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.EObject#refClass()
	 */
	@Override
	public EClass refClass() {

		return wrappedToken.refClass();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.EObject#refDelete()
	 */
	@Override
	public void refDelete() {
		wrappedToken.refDelete();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.EObject#refImmediateComposite()
	 */
	@Override
	public RefFeatured refImmediateComposite() {

		return wrappedToken.refImmediateComposite();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.EObject#refIsInstanceOf(com.sap.tc.moin.repository.mmi.reflect.EObject,
	 *      boolean)
	 */
	@Override
	public boolean refIsInstanceOf(EObject objType, boolean considerSubtypes) {

		return wrappedToken.refIsInstanceOf(objType, considerSubtypes);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.EObject#refOutermostComposite()
	 */
	@Override
	public RefFeatured refOutermostComposite() {

		return wrappedToken.refOutermostComposite();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(com.sap.tc.moin.repository.mmi.reflect.EObject)
	 */
	@Override
	public Object refGetValue(EObject feature) {

		return wrappedToken.refGetValue(feature);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refGetValue(java.lang.String)
	 */
	@Override
	public Object refGetValue(String featureName) {

		return wrappedToken.refGetValue(featureName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refInvokeOperation(com.sap.tc.moin.repository.mmi.reflect.EObject,
	 *      java.util.List)
	 */
	@Override
	public Object refInvokeOperation(EObject requestedOperation,
			List<? extends Object> args) throws RefException {
		return wrappedToken.refInvokeOperation(requestedOperation, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refInvokeOperation(java.lang.String,
	 *      java.util.List)
	 */
	@Override
	public Object refInvokeOperation(String requestedOperation,
			List<? extends Object> args) throws RefException {
		return wrappedToken.refInvokeOperation(requestedOperation, args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(com.sap.tc.moin.repository.mmi.reflect.EObject,
	 *      java.lang.Object)
	 */
	@Override
	public void refSetValue(EObject feature, Object value) {
		wrappedToken.refSetValue(feature, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefFeatured#refSetValue(java.lang.String,
	 *      java.lang.Object)
	 */
	@Override
	public void refSetValue(String featureName, Object value) {
		wrappedToken.refSetValue(featureName, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refImmediatePackage()
	 */
	@Override
	public RefPackage refImmediatePackage() {
		return wrappedToken.refImmediatePackage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refMetaObject()
	 */
	@Override
	public EObject refMetaObject() {
		return wrappedToken.refMetaObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refMofId()
	 */
	@Override
	public String refMofId() {
		return wrappedToken.refMofId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refOutermostPackage()
	 */
	@Override
	public RefPackage refOutermostPackage() {
		return wrappedToken.refOutermostPackage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.tc.moin.repository.mmi.reflect.RefBaseObject#refVerifyConstraints(boolean)
	 */
	@Override
	public Collection<JmiException> refVerifyConstraints(boolean deepVerify) {
		return wrappedToken.refVerifyConstraints(deepVerify);
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

	@Override
	public void assign___Partition(Resource mp) {
		// TODO Auto-generated method stub
		throw new RuntimeException("not implemented");
	}

	@Override
	public void assign___PartitionIncludingChildren(Resource mp) {
		// TODO Auto-generated method stub
		throw new RuntimeException("not implemented");
	}

	@Override
	public ResourceSet get___Connection() {
		// TODO Auto-generated method stub
		throw new RuntimeException("not implemented");
	}

	@Override
	public <T extends RefBaseObject> Class<T> get___JmiInterface() {
		// TODO Auto-generated method stub
		throw new RuntimeException("not implemented");
	}

	@Override
	public URI get___Mri() {
		return wrappedToken.get___Mri();
	}

	@Override
	public Resource get___Partition() {
		// TODO Auto-generated method stub
		throw new RuntimeException("not implemented");
	}

	@Override
	public boolean is___Alive() {
		// TODO Auto-generated method stub
		throw new RuntimeException("not implemented");
	}

	@Override
	public Collection<EObject> getReferencedElements()
		throws JmiException {
	    return wrappedToken.getReferencedElements();
	}

    @Override
    public boolean isOperator() throws JmiException {
        return wrappedToken.isOperator();
    }

    @Override
    public void setOperator(boolean newValue) throws JmiException {
        wrappedToken.setOperator(newValue);
    }

}
