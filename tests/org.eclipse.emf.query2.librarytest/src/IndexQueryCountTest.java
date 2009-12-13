import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query.index.query.QueryCommandWithResult;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.QueryResult;
import org.junit.Test;

public class IndexQueryCountTest extends QueryTestCase {

	@Test
	public void testEObjectCountQuery() throws Exception {
		QueryCommandWithResult<Integer> command = null;
		getDefaultIndexStore().executeQueryCommand(command = new QueryCommandWithResult<Integer>() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				EObjectOfTypeCountQuery query = new EObjectOfTypeCountQuery();
				query.eClassUri(URI.createURI("http://eclipse.org/modeling/emf/query/1.0.0#//Book"));

				QueryResult<Integer> result = queryExecutor.execute(query);

				this.setResult(result.iterator().next());
			}
		});

		long time = System.nanoTime();
		getDefaultIndexStore().executeQueryCommand(command = new QueryCommandWithResult<Integer>() {

			@Override
			public void execute(QueryExecutor queryExecutor) {
				EObjectOfTypeCountQuery query = new EObjectOfTypeCountQuery();
				query.eClassUri(URI.createURI("http://eclipse.org/modeling/emf/query/1.0.0#//Book"));

				QueryResult<Integer> result = queryExecutor.execute(query);

				this.setResult(result.iterator().next());
			}
		});
		time = System.nanoTime() - time;
		System.out.println("time: " + time + ", size: " + command.getResult());
	}
}
