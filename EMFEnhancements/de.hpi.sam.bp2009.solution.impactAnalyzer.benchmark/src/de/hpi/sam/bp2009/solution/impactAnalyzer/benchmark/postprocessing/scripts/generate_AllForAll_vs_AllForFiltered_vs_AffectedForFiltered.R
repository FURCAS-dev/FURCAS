require(epicalc)
# read different optimization options from data file:
options=read.table("c:/tmp/optionDescription.data", sep="\t", header=TRUE)

strippedResult$iaExecAndEvalTime = as.numeric(strippedResult$executionTime + strippedResult$evaluationTimeAfter)
strippedResult$aiExecAndEvalTime = as.numeric(strippedResult$allInstanceEvalTime + strippedResult$allInstanceExecTime)

aggr = aggregate(strippedResult[, c("aiExecAndEvalTime", "iaExecAndEvalTime", "modelSize", "optionId")], by=list(strippedResult$modelId, strippedResult$executionIndex, strippedResult$optionId), FUN = "sum") 
aggrAvgOverRuns = aggregate(aggr, by=list(aggr$Group.1, aggr$optionId), FUN="mean")

filtered = strippedResult[strippedResult$filtered == TRUE, ]
aggrFiltered = aggregate(filtered[, c("aiExecAndEvalTime", "iaExecAndEvalTime", "modelSize", "optionId")], by=list(filtered$modelId, filtered$executionIndex, filtered$optionId), FUN = "sum")
aggrFilteredAvgOverRuns = aggregate(aggrFiltered, by=list(aggrFiltered$Group.1, aggrFiltered$optionId), FUN="mean")

# Selecting the options (row numbers starting with 1 from optionDescription.data) to show:
optionToShow=1
optionsToShow=c(optionToShow)

aggrAllInstanceUnfiltered = aggrAvgOverRuns
aggrAllInstanceUnfiltered$measureTime = aggrAllInstanceUnfiltered$aiExecAndEvalTime
aggrAllInstanceUnfiltered$measurement = 1 

aggrAllInstanceFiltered = aggrFilteredAvgOverRuns
aggrAllInstanceFiltered$measureTime = aggrAllInstanceFiltered$aiExecAndEvalTime
aggrAllInstanceFiltered$measurement = 2
mergeAll = merge(aggrAllInstanceUnfiltered, aggrAllInstanceFiltered, all = TRUE)

for (i in optionsToShow) {
    aggrIaFiltered = aggrFilteredAvgOverRuns[aggrFilteredAvgOverRuns$Group.3 == i-1, ]
    aggrIaFiltered$measureTime = aggrIaFiltered$iaExecAndEvalTime
    aggrIaFiltered$measurement = i+2
    mergeAll = merge(mergeAll, aggrIaFiltered, all = TRUE)
}
allForAll=mergeAll[mergeAll$measurement==1,]
allForFiltered=mergeAll[mergeAll$measurement==2,]
affectedForFiltered=mergeAll[mergeAll$measurement==2+optionToShow,]

pdf("allForAll_vs_AllForFiltered_vs_AffectedForFiltered.pdf", width = 8, height = 6)
plot(allForAll$modelSize, allForAll$measureTime, type="b",
     xlab="#model packages", ylab="total re-evaluation time in ns",
     ylim=range(allForAll$measureTime, allForFiltered$measureTime, affectedForFiltered$measureTime),
     # log="y",
     col="red", lty="dashed",
     main="Total re-evaluation times: all contexts for all expressions (dashed, red); all contexts for filtered expressions (dotted, black); affected contexts for filtered expressions (solid, blue)")
points(allForFiltered$modelSize, allForFiltered$measureTime, type="b", col="black", lty="dotted")
points(affectedForFiltered$modelSize, affectedForFiltered$measureTime, type="b", col="blue", lty="solid")
dev.off()
