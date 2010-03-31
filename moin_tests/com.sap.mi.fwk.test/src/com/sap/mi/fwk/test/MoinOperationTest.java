package com.sap.mi.fwk.test;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;

import com.sap.ide.metamodel.webdynpro.component.Component;
import com.sap.ide.metamodel.webdynpro.component.ComponentPackage;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.internal.MoinOperation;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.webdynpro.metamodel.test.WebDynproProjectTest;

/**
 * Tests integration of commands into the Eclipse undo stack
 * 
 * @author d024127
 */
public class MoinOperationTest extends WebDynproProjectTest {

    private static final String DC_NAME = "test/moinoperation";
    private static final IPath PARTITION_FOLDER = SOURCE_FOLDER_WEBDYNPRO.append("com/sap/test/moinop");

    private Connection connection;
    private Component component;

    public MoinOperationTest() {
        super(DC_NAME);
    }

    @Override
    protected String getDcName() {
        return DC_NAME;
    }

    public void testCommandExecution() {
        TestCommand tc = new TestCommand(connection, component);
        IUndoContext ctx = ConnectionManager.getInstance().addUndoContext(connection);
        connection.getCommandStack().execute(tc);

        assertTrue(OperationHistoryFactory.getOperationHistory().canUndo(ctx));
        assertFalse(OperationHistoryFactory.getOperationHistory().canRedo(ctx));

        IUndoableOperation stackOp = OperationHistoryFactory.getOperationHistory().getUndoOperation(ctx);
        assertTrue(stackOp.canUndo());
        assertFalse(stackOp.canRedo());

        assertEquals("new name", component.getName());
                
        IStatus status = null;
        try {
            status = OperationHistoryFactory.getOperationHistory().undoOperation(stackOp, null, null);
        } catch (ExecutionException e) {
            fail(e);
        }
         assertTrue(status.isOK());
         assertEquals("old name", component.getName());
         
         try {
             status = OperationHistoryFactory.getOperationHistory().redoOperation(stackOp, null, null);
         } catch (ExecutionException e) {
             fail(e);
         }
         assertTrue(status.isOK());
         assertEquals("new name", component.getName());
    }

    public void testMoinOperatiion() {
        MoinOperation op = new MoinOperation("test op", connection.getCommandStack());
        assertFalse(op.canExecute());
        try {
            op.execute(null, null);
            fail("UnsupportedOperationException not thrown");
        } catch (UnsupportedOperationException e) {
        }

        assertNotNull(op.toString());
        assertEquals(connection.getCommandStack(), op.getCmdStack());

        IStatus status;
        try {
            status = op.undo(null, null);
            assertTrue(status.getSeverity() == IStatus.ERROR);
        } catch (ExecutionException e) {
            fail(e);
        }

        try {
            status = op.redo(null, null);
            assertTrue(status.getSeverity() == IStatus.ERROR);
        } catch (ExecutionException e) {
            fail(e);
        }
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        connection = createConnection();
        PRI pri = getPri(getProject(), PARTITION_FOLDER.append("Partition"));
        ModelPartition partition = connection.getPartition(pri);
        if (partition != null) {
            partition.delete();
        }
        partition = connection.createPartition(pri);
        assertNotNull("Partition creation failed", partition);

        ComponentPackage compPackage = (ComponentPackage) connection.getPackage("sap.com/tc/moin/webdynpro/webdynpro",
            new String[] { "WebDynpro", "component" });
        component = (Component) compPackage.getComponent().refCreateInstance( );
        component.setName("old name");
        partition.assignElement((Partitionable) component);

        connection.save();
    }

    @Override
    protected void tearDown() throws Exception {

        connection.close();
        connection = null;
        component = null;

        super.tearDown();
    }

    private final class TestCommand extends Command {

        private Component comp;

        public TestCommand(Connection con, Component comp) {
            super(con);
            this.comp = comp;
        }

        @Override
        public boolean canExecute() {
            return true;
        }

        @Override
        public void doExecute() {
            comp.setName("new name");
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions() {
        	ModelPartition part = ((Partitionable)comp).get___Partition();
        	PartitionOperation partOp = new PartitionOperation(Operation.EDIT, part.getPri());
        	Collection<PartitionOperation> result = new HashSet<PartitionOperation>();
        	result.add(partOp);
            return result;
        }
    }
}