package org.eclipse.ocl.examples.impactanalyzer.benchmark;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Reads a full dump of analysis results and pre-aggregates them for easier handling with R. Special assumption: all
 * columns have values that fit in <code>long</code> variables, except for the <code>filtered</code> column which is a
 * boolean, encoded by the literals <code>TRUE</code> or <code>FALSE</code>.
 * <p>
 * 
 * Note that the <code>sloppiness</code> column is scaled by a factor {@link #SLOPPINESS_SCALE}.
 * 
 * @author Axel Uhl (d043530)
 */
public class Analyzer {
    private static final int MAX_MODEL_ID = 100;
    private static final int MAX_OPTION_ID = 10;
    private static final int AVG_LINE_LENGTH = 100;
    private static final long SLOPPINESS_SCALE = 1000000;

    /**
     * Keys the optionIds to measurement numbers such that they appear roughly with increasing measureTime values
     */
    private static final int[] optionIdToMeasurement = { 10, 11, 3, 9, 5, 4, 12, 6, 7, 8 };

    private final String[] additionalColumnNames = { "iaEvalAndExecTime", "aiExecAndEvalTime",
            "allInstancesEvalAndExecTime", "sloppiness" };

    private final BufferedReader reader;
    private final BufferedWriter writer;
    private final List<String> columnList;

    private final int estimatedNumberOfLines;
    private int linesRead;

    /**
     * Will be set after the header has been read. See {@link #readHeader()}. Identified the index in
     * {@link #columnList} where the <code>filtered</code> Boolean column is located.
     */
    private int filteredColumnIndex;

    private int allInstanceExecTimeColumnIndex = -1;
    private int allInstanceEvalTimeColumnIndex = -1;
    private int allInstancesEvalAndExecTimeColumnIndex = -1;
    private int executionTimeColumnIndex = -1;
    private int iaEvalAndExecTimeColumnIndex = -1;
    private int evaluationTimeAfterColumnIndex = -1;
    private int optionIdColumnIndex = -1;
    private int modelIdColumnIndex = -1;
    private int modelSizeColumnIndex = -1;
    private int noEqualResultsBeforeAndAfterColumnIndex = -1;
    private int noContextObjectsColumnIndex = -1;
    private int noAllInstancesColumnIndex = -1;
    private int allInstanceNoInvalidEvalsColumnIndex = -1;
    private int sloppinessColumnIndex = -1;
    private int noIaAllInstanceCallsColumnIndex = -1;
    private int noAllInstanceEvalAllInstanceCallsColumnIndex = -1;
    private int noTracebackStepsExecutedColumnIndex = -1;

    /**
     * Stores the sum of the model sizes, indexed by the modelId column value
     */
    private final Aggregator[] modelSize;

    /**
     * Results, aggregated by <code>optionId</code>
     */
    private final Result[] results;
    
    /**
     * If provided, this tells the number of measurement runs that were executed which
     * therefore is the quotient by which all numbers to be summed up will be divided
     * during output.
     */
    private int quotient;

    /**
     * One row of the file. The <code>filtered</code> flag is separate; all other <code>long</code> columns match up
     * with the indexes in {@link Analyzer#columnList} which means that the column for <code>filtered</code> remains
     * empty in the <code>long</code> array.
     * 
     * @author Axel Uhl (d043530)
     */
    private class Record {
        private final long[] values;
        private final boolean filtered;

        public Record(boolean filtered, long[] values) {
            super();
            assert values.length == columnList.size();
            this.filtered = filtered;
            this.values = values;
        }

        public boolean isFiltered() {
            return filtered;
        }

        public long getValue(int i) {
            return values[i];
        }
    }

    /**
     * Used to compute the sum and average aggregates of a set of numerical values. Uses {@link BigInteger} internally
     * to avoid overflows. The maximum number of elements that can be aggregated is {@link Long#MAX_VALUE}.
     * 
     * @author Axel Uhl (d043530)
     */
    private static class Aggregator {
        private long count;
        private BigInteger sum = BigInteger.ZERO;

        public void aggregate(long value) {
            sum = sum.add(BigInteger.valueOf(value));
            count++;
        }

        public BigInteger getSum() {
            return sum;
        }

        public double getAverage() {
            return sum.doubleValue() / count;
        }

        public String toString() {
            return "" + getSum() + "/" + count + "=" + getAverage();
        }
    }

    /**
     * Captures aggregation results for a single algorithm variant for all model IDs
     * 
     * @author Axel Uhl (d043530)
     */
    private class Result {
        private final int optionId;

        private final Aggregator[] aggrAllInstanceUnfiltered = new Aggregator[MAX_MODEL_ID];
        private final Aggregator[] aggrAllInstanceFiltered = new Aggregator[MAX_MODEL_ID];
        private final Aggregator[] aggrIaFiltered = new Aggregator[MAX_MODEL_ID];
        private final Aggregator[] aggrIaFilteredWithoutAllInstancesDuringTraceback = new Aggregator[MAX_MODEL_ID];
        private final Aggregator[] aggrIaFilteredWithoutAllInstancesAtAnyTime = new Aggregator[MAX_MODEL_ID];
        private final Aggregator[] sloppinessFiltered = new Aggregator[MAX_MODEL_ID];
        private final Aggregator[] aggrNumberOfTracebackStepsExecuted = new Aggregator[MAX_MODEL_ID];

        public Result(int optionId) {
            this.optionId = optionId;
        }

        /**
         * If <code>filtered</code> is <code>true</code>, the event of the record has passed the event filter. Its
         * <code>aiExecAndEvalTime</code> is added to the {@link #aggrAllInstanceFiltered} and {@link #aggrIaFiltered}
         * aggregators. In all cases it's added to the {@link #aggrAllInstanceUnfiltered} aggregator.
         * @param noTracebackStepsExecuted 
         */
        public void recordMeasurement(long aiExecAndEvalTime, long iaExecAndEvalTime, long sloppiness,
                boolean filtered, long numberOfAllInstanceCallsDuringTraceback,
                long numberOfAllInstanceEvalsDuringEvalOnAllInstances, long noTracebackStepsExecuted, int modelId) {
            if (aggrAllInstanceUnfiltered[modelId] == null) {
                aggrAllInstanceUnfiltered[modelId] = new Aggregator();
            }
            aggrAllInstanceUnfiltered[modelId].aggregate(aiExecAndEvalTime);
            if (aggrNumberOfTracebackStepsExecuted[modelId] == null) {
                aggrNumberOfTracebackStepsExecuted[modelId] = new Aggregator();
            }
            aggrNumberOfTracebackStepsExecuted[modelId].aggregate(noTracebackStepsExecuted);
            if (filtered) {
                if (aggrAllInstanceFiltered[modelId] == null) {
                    aggrAllInstanceFiltered[modelId] = new Aggregator();
                }
                aggrAllInstanceFiltered[modelId].aggregate(aiExecAndEvalTime);
                if (aggrIaFiltered[modelId] == null) {
                    aggrIaFiltered[modelId] = new Aggregator();
                }
                aggrIaFiltered[modelId].aggregate(iaExecAndEvalTime);
                if (numberOfAllInstanceCallsDuringTraceback == 0) {
                    if (aggrIaFilteredWithoutAllInstancesDuringTraceback[modelId] == null) {
                        aggrIaFilteredWithoutAllInstancesDuringTraceback[modelId] = new Aggregator();
                    }
                    aggrIaFilteredWithoutAllInstancesDuringTraceback[modelId].aggregate(iaExecAndEvalTime);
                    if (numberOfAllInstanceEvalsDuringEvalOnAllInstances == 0) {
                        if (aggrIaFilteredWithoutAllInstancesAtAnyTime[modelId] == null) {
                            aggrIaFilteredWithoutAllInstancesAtAnyTime[modelId] = new Aggregator();
                        }
                        aggrIaFilteredWithoutAllInstancesAtAnyTime[modelId].aggregate(iaExecAndEvalTime);
                    }
                }
                if (sloppinessFiltered[modelId] == null) {
                    sloppinessFiltered[modelId] = new Aggregator();
                }
                sloppinessFiltered[modelId].aggregate(sloppiness);
            }
        }

        public int getOptionId() {
            return optionId;
        }

        /**
         * Returns the {@link Aggregator#getSum() sums} of the {@link #aggrAllInstanceUnfiltered} aggregator,
         * keyed by the {@link Analyzer#getAverageModelSize(int) model sizes}.
         */
        public Map<Double, BigInteger> getAggrAllInstanceUnfilteredAverage() {
            return getSumByModelSize(aggrAllInstanceUnfiltered);
        }

        /**
         * Returns the {@link Aggregator#getSum() sums} of the {@link #aggrAllInstanceFiltered} aggregator,
         * keyed by the {@link Analyzer#getAverageModelSize(int) model sizes}.
         */
        public Map<Double, BigInteger> getAggrAllInstanceFilteredSum() {
            return getSumByModelSize(aggrAllInstanceFiltered);
        }

        /**
         * Returns the {@link Aggregator#getSum() sums} of the
         * {@link #aggrIaFilteredWithoutAllInstancesDuringTraceback} aggregator, keyed by the
         * {@link Analyzer#getAverageModelSize(int) model sizes}.
         */
        public Map<Double, BigInteger> getAggrIaFilteredWithoutAllInstancesDuringTracebackSum() {
            return getSumByModelSize(aggrIaFilteredWithoutAllInstancesDuringTraceback);
        }

        /**
         * Returns the {@link Aggregator#getSum() sums} of the
         * {@link #aggrIaFilteredWithoutAllInstancesAtAnyTime} aggregator, keyed by the
         * {@link Analyzer#getAverageModelSize(int) model sizes}.
         */
        public Map<Double, BigInteger> getAggrIaFilteredWithoutAllInstancesAtAnyTimeSum() {
            return getSumByModelSize(aggrIaFilteredWithoutAllInstancesAtAnyTime);
        }

        /**
         * Returns the {@link Aggregator#getSum() sums} of the
         * {@link #aggrIaFilteredWithoutAllInstancesAtAnyTime} aggregator, keyed by the
         * {@link Analyzer#getAverageModelSize(int) model sizes}.
         */
        public Map<Double, Double> getAggrNumberOfTracebackStepsExecutedAverage() {
            return getAverageByModelSize(aggrNumberOfTracebackStepsExecuted);
        }

        /**
         * Returns the {@link Aggregator#getSum() sums} of the {@link #aggrIaFiltered} aggregator, keyed by the
         * {@link Analyzer#getAverageModelSize(int) model sizes}.
         */
        public Map<Double, BigInteger> getAggrIaFilteredSum() {
            return getSumByModelSize(aggrIaFiltered);
        }

        /**
         * Considers {@link Analyzer#quotient} and divides the sums by this quotient before putting them to the
         * values of the map returned.
         * 
         * @param aggregatorArray
         *            an array of {@link Aggregator}s where the array index is the model ID. Based on the model ID, the
         *            model size is computed using {@link Analyzer#getAverageModelSize(int)} and then used as the key
         *            for the resulting map.
         * @return a map whose key set is ordered for ascending model size
         */
        private Map<Double, BigInteger> getSumByModelSize(Aggregator[] aggregatorArray) {
            BigInteger quotientAsBigInt = BigInteger.valueOf(quotient);
            Map<Double, BigInteger> result = new TreeMap<Double, BigInteger>();
            for (int i = 0; i < MAX_MODEL_ID; i++) {
                if (aggregatorArray[i] != null) {
                    result.put(getAverageModelSize(i), aggregatorArray[i].getSum().divide(quotientAsBigInt));
                }
            }
            return result;
        }

        /**
         * @param aggregatorArray
         *            an array of {@link Aggregator}s where the array index is the model ID. Based on the model ID, the
         *            model size is computed using {@link Analyzer#getAverageModelSize(int)} and then used as the key
         *            for the resulting map.
         * @return a map whose key set is ordered for ascending model size
         */
        private Map<Double, Double> getAverageByModelSize(Aggregator[] aggregatorArray) {
            Map<Double, Double> result = new TreeMap<Double, Double>();
            for (int i = 0; i < MAX_MODEL_ID; i++) {
                if (aggregatorArray[i] != null) {
                    result.put(getAverageModelSize(i), aggregatorArray[i].getAverage());
                }
            }
            return result;
        }
    }

    public Analyzer(String inFileName, String outFileName, int quotient) throws IOException {
        File inFile = new File(inFileName);
        long inFileSize = inFile.length();
        reader = new BufferedReader(new FileReader(inFile));
        writer = new BufferedWriter(outFileName == null ? new OutputStreamWriter(System.out) : new FileWriter(
                outFileName));
        columnList = new ArrayList<String>();
        modelSize = new Aggregator[MAX_MODEL_ID];
        linesRead = 0;
        estimatedNumberOfLines = (int) (inFileSize / AVG_LINE_LENGTH);
        results = new Result[MAX_OPTION_ID];
        this.quotient = quotient;
    }

    /**
     * @param args
     *            <code>args[0]</code> is expected to specify the file from which to load data, <code>args[1]</code> is
     *            expected to specify the output file.
     */
    public static void main(String[] args) {
        try {
            Analyzer analyzer = new Analyzer(args[0], args.length < 2 ? null : args[1],
                    /* quotient */ args.length > 2 ? Integer.valueOf(args[2]).intValue() : 1);
            analyzer.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException {
        readHeader();
        Record record = readRecord();
        while (record != null) {
            if (linesRead % 1000000 == 0) {
                System.err.println((100. * linesRead / estimatedNumberOfLines) + "% (" + linesRead + "/"
                        + estimatedNumberOfLines + ")");
            }
            updateAggregates(record);
            record = readRecord();
        }
        System.out.println();
        dumpResults();
    }

    /**
     * Dumps results to {@link #writer}.
     */
    private void dumpResults() throws IOException {
        System.err.println("Dumping results...");
        writeHeader();
        for (int optionId = 0; optionId < MAX_OPTION_ID; optionId++) {
            if (results[optionId] != null) {
                int i = 0;
                if (optionId == 0) {
                    // write re-evaluation times over all instances filtered/unfiltered
                    // as the first two measurements
                    for (Map.Entry<Double, BigInteger> unfilteredEntry : results[optionId]
                            .getAggrAllInstanceUnfilteredAverage().entrySet()) {
                        writer.write("" + results[optionId].getOptionId() + "\t" + (i++) + "\t"
                                + unfilteredEntry.getKey() + "\t1\t" + unfilteredEntry.getValue() + "\t"
                                + results[optionId].getAggrAllInstanceFilteredSum().get(unfilteredEntry.getKey()) + "\t"
                                + results[optionId].getAggrIaFilteredWithoutAllInstancesDuringTracebackSum().get(unfilteredEntry.getKey()) + "\t"
                                + results[optionId].getAggrIaFilteredWithoutAllInstancesAtAnyTimeSum().get(unfilteredEntry.getKey()) + "\t"
                                + results[optionId].getAggrNumberOfTracebackStepsExecutedAverage().get(unfilteredEntry.getKey())
                                + "\n");
                    }
                    i = 0;
                    for (Map.Entry<Double, BigInteger> filteredEntry : results[optionId]
                            .getAggrAllInstanceFilteredSum().entrySet()) {
                        writer.write("" + results[optionId].getOptionId() + "\t" + (i++) + "\t"
                                + filteredEntry.getKey() + "\t2\t" + filteredEntry.getValue() + "\t"
                                + results[optionId].getAggrAllInstanceFilteredSum().get(filteredEntry.getKey()) + "\t"
                                + results[optionId].getAggrIaFilteredWithoutAllInstancesDuringTracebackSum().get(filteredEntry.getKey()) + "\t"
                                + results[optionId].getAggrIaFilteredWithoutAllInstancesAtAnyTimeSum().get(filteredEntry.getKey()) + "\t"
                                + results[optionId].getAggrNumberOfTracebackStepsExecutedAverage().get(filteredEntry.getKey())
                                + "\n");
                    }
                    i = 0;
                }
                for (Map.Entry<Double, BigInteger> ia : results[optionId].getAggrIaFilteredSum().entrySet()) {
                    writer.write("" + results[optionId].getOptionId() + "\t" + (i++) + "\t" + ia.getKey() + "\t"
                            + optionIdToMeasurement[optionId] + "\t" + ia.getValue() + "\t"
                            + results[optionId].getAggrAllInstanceFilteredSum().get(ia.getKey()) + "\t"
                            + results[optionId].getAggrIaFilteredWithoutAllInstancesDuringTracebackSum().get(ia.getKey()) + "\t"
                            + results[optionId].getAggrIaFilteredWithoutAllInstancesAtAnyTimeSum().get(ia.getKey()) + "\t"
                            + results[optionId].getAggrNumberOfTracebackStepsExecutedAverage().get(ia.getKey())
                            + "\n");
                }
            }
        }
        writer.close();
        System.err.println("Finished.");
    }

    private void writeHeader() throws IOException {
        writer.write("optionId\tmodelId\tmodelSize\tmeasurement\tmeasureTime\tallInstancesFilterdEvalAndExecTime\tmeasureTimeWithoutAllInstancesDuringTraceback\tmeasureTimeWithoutAllInstancesAtAnyTime\tnumberOfTracebackStepsExecuted\n");
    }

    /**
     * If the record's {@link #noAllInstancesColumnIndex noAllInstances} value differs from the
     * {@link Aggregator#allinstanceNoInvalidEvals number of invalid evaluation results} for the expression, meaning
     * that at least one valid evaluation result was obtained for the expression on any model for any of its extent's
     * elements, this method updates the aggregates of this analyzer, particularly the model size for the record's
     * {@link #modelIdColumnIndex modelId} s well as the allInstances and impact analysis times. See
     * {@link Result#recordMeasurement(long, long, long, boolean, int, long, int)}.
     */
    private void updateAggregates(Record record) {
        if (record.getValue(noAllInstancesColumnIndex) != record.getValue(allInstanceNoInvalidEvalsColumnIndex)) {
            int modelId = (int) record.getValue(modelIdColumnIndex);
            getModelSizeAggregator(modelId).aggregate(record.getValue(modelSizeColumnIndex));
            int optionId = (int) record.getValue(optionIdColumnIndex);
            getResult(optionId).recordMeasurement(record.getValue(allInstancesEvalAndExecTimeColumnIndex),
                    record.getValue(iaEvalAndExecTimeColumnIndex), record.getValue(sloppinessColumnIndex),
                    record.isFiltered(), record.getValue(noIaAllInstanceCallsColumnIndex),
                    record.getValue(noAllInstanceEvalAllInstanceCallsColumnIndex),
                    record.getValue(noTracebackStepsExecutedColumnIndex), modelId);
        }
    }

    /**
     * Option the {@link Result} object for the option ID <code>optionId</code>. Create if not yet there.
     */
    private Result getResult(int optionId) {
        Result result = results[optionId];
        if (result == null) {
            result = new Result(optionId);
            results[optionId] = result;
        }
        return result;
    }

    private Aggregator getModelSizeAggregator(int modelId) {
        Aggregator result = modelSize[modelId];
        if (result == null) {
            result = new Aggregator();
            modelSize[modelId] = result;
        }
        return result;
    }

    private double getAverageModelSize(int modelId) {
        return getModelSizeAggregator(modelId).getAverage();
    }

    private void readHeader() throws IOException {
        String header = reader.readLine();
        StringTokenizer tok = new StringTokenizer(header, " \t");
        while (tok.hasMoreTokens()) {
            String next = tok.nextToken();
            columnList.add(next);
        }
        for (String additionalColumnName : additionalColumnNames) {
            columnList.add(additionalColumnName);
        }
        for (int i = 0; i < columnList.size(); i++) {
            String next = columnList.get(i);
            if (next.equals("filtered")) {
                filteredColumnIndex = i;
            } else if (next.equals("allInstanceExecTime")) {
                allInstanceExecTimeColumnIndex = i;
            } else if (next.equals("allInstanceEvalTime")) {
                allInstanceEvalTimeColumnIndex = i;
            } else if (next.equals("allInstancesEvalAndExecTime")) {
                allInstancesEvalAndExecTimeColumnIndex = i;
            } else if (next.equals("executionTime")) {
                executionTimeColumnIndex = i;
            } else if (next.equals("iaEvalAndExecTime")) {
                iaEvalAndExecTimeColumnIndex = i;
            } else if (next.equals("evaluationTimeAfter")) {
                evaluationTimeAfterColumnIndex = i;
            } else if (next.equals("modelId")) {
                modelIdColumnIndex = i;
            } else if (next.equals("modelSize")) {
                modelSizeColumnIndex = i;
            } else if (next.equals("noEqualResultsBeforeAndAfter")) {
                noEqualResultsBeforeAndAfterColumnIndex = i;
            } else if (next.equals("noContextObjects")) {
                noContextObjectsColumnIndex = i;
            } else if (next.equals("noAllInstances")) {
                noAllInstancesColumnIndex = i;
            } else if (next.equals("allInstanceNoInvalidEvals")) {
                allInstanceNoInvalidEvalsColumnIndex = i;
            } else if (next.equals("sloppiness")) {
                sloppinessColumnIndex = i;
            } else if (next.equals("optionId")) {
                optionIdColumnIndex = i;
            } else if (next.equals("noIaAllInstanceCalls")) {
                noIaAllInstanceCallsColumnIndex = i;
            } else if (next.equals("noAllInstanceEvalAllInstanceCalls")) {
                noAllInstanceEvalAllInstanceCallsColumnIndex = i;
            } else if (next.equals("noTracebackStepsExecuted")) {
                noTracebackStepsExecutedColumnIndex = i;
            }
        }
    }

    /**
     * @return <code>null</code> if the end of the file has been reached
     */
    private Record readRecord() throws IOException {
        Record result = null;
        String row = reader.readLine();
        if (row != null) {
            linesRead++;
            long[] values = new long[columnList.size()];
            boolean filtered = false;
            StringTokenizer tok = new StringTokenizer(row, " \t");
            tok.nextToken(); // skip row ID
            int i = 0;
            while (tok.hasMoreTokens()) {
                String next = tok.nextToken();
                if (i == filteredColumnIndex) {
                    filtered = Boolean.valueOf(next);
                } else {
                    values[i] = Long.valueOf(next);
                }
                i++;
            }
            values[iaEvalAndExecTimeColumnIndex] = values[executionTimeColumnIndex]
                    + values[evaluationTimeAfterColumnIndex];
            values[allInstancesEvalAndExecTimeColumnIndex] = values[allInstanceEvalTimeColumnIndex]
                    + values[allInstanceExecTimeColumnIndex];
            values[sloppinessColumnIndex] = SLOPPINESS_SCALE * (values[noEqualResultsBeforeAndAfterColumnIndex] + 1)
                    / (values[noContextObjectsColumnIndex] + 1);
            result = new Record(filtered, values);
        }
        return result;
    }

}
