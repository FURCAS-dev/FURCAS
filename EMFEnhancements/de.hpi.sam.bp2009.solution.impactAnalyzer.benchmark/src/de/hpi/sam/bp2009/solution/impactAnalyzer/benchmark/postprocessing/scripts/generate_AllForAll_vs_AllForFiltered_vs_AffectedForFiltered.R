require(epicalc)
# read different optimization options from data file:
options=read.table("c:/tmp/optionDescription.data", sep="\t", header=TRUE)

# Use strippedResults because we don't care about expressions that always only result in invalid
strippedResult$iaExecAndEvalTime = as.numeric(strippedResult$executionTime + strippedResult$evaluationTimeAfter)
strippedResult$aiExecAndEvalTime = as.numeric(strippedResult$allInstanceEvalTime + strippedResult$allInstanceExecTime)

ms=aggregate(strippedResult[,c("modelId", "modelSize")], by=list(strippedResult$modelId), FUN="mean")

avgAggr = aggregate(strippedResult[, c("aiExecAndEvalTime", "iaExecAndEvalTime")], by=list(strippedResult$modelId, strippedResult$oclId, strippedResult$notificationId), FUN = "mean")
aggr = aggregate(avgAggr[, c("aiExecAndEvalTime", "iaExecAndEvalTime")], by=list(avgAggr$Group.1), FUN = "sum") 
aggr$modelSize=ms[ms$modelId==aggr$Group.1, ]$modelSize

filtered = strippedResult[strippedResult$filtered == TRUE, ]
avgAggrFiltered = aggregate(filtered[, c("aiExecAndEvalTime", "iaExecAndEvalTime")], by=list(filtered$modelId, filtered$oclId, filtered$notificationId), FUN = "mean")
aggrFilteredAvgOverRuns = aggregate(avgAggrFiltered[, c("aiExecAndEvalTime", "iaExecAndEvalTime")], by=list(avgAggrFiltered$Group.1), FUN = "sum") 
aggrFilteredAvgOverRuns$modelSize=ms[ms$modelId==aggrFilteredAvgOverRuns$Group.1, ]$modelSize

avgAggrFilteredByOptionId = aggregate(filtered[, c("aiExecAndEvalTime", "iaExecAndEvalTime")], by=list(filtered$modelId, filtered$oclId, filtered$notificationId, filtered$optionId), FUN = "mean")
aggrFilteredAvgByOptionIdOverRuns = aggregate(avgAggrFilteredByOptionId[, c("aiExecAndEvalTime", "iaExecAndEvalTime")], by=list(avgAggrFilteredByOptionId$Group.1, avgAggrFilteredByOptionId$Group.4), FUN = "sum") 
aggrFilteredAvgByOptionIdOverRuns$modelSize=ms[ms$modelId==aggrFilteredAvgByOptionIdOverRuns$Group.1, ]$modelSize

# Selecting the options (row numbers starting with 1 from optionDescription.data) to show:
optionToShow=1
optionsToShow=c(optionToShow)

aggrAllInstanceUnfiltered = aggr
aggrAllInstanceUnfiltered$measureTime = aggrAllInstanceUnfiltered$aiExecAndEvalTime
aggrAllInstanceUnfiltered$measurement = 1 

aggrAllInstanceFiltered = aggrFilteredAvgOverRuns
aggrAllInstanceFiltered$measureTime = aggrAllInstanceFiltered$aiExecAndEvalTime
aggrAllInstanceFiltered$measurement = 2
mergeAll = merge(aggrAllInstanceUnfiltered, aggrAllInstanceFiltered, all = TRUE)

for (i in optionsToShow) {
    aggrIaFiltered = aggrFilteredAvgByOptionIdOverRuns[aggrFilteredAvgByOptionIdOverRuns$Group.2 == i-1, ]
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

allForAllStripped=allForAll[, c("Group.1", "aiExecAndEvalTime")]
c2=merge(c, allForAllStripped, by=c("Group.1"))
allForInstanceFilteredStripped=aggrAllInstanceFiltered[, c("Group.1", "aiExecAndEvalTime")]
c3=merge(c2, allForInstanceFilteredStripped, by=c("Group.1"))
affectedForFilteredStripped=affectedForFiltered[, c("Group.1", "iaExecAndEvalTime")]
c4=merge(c3, affectedForFilteredStripped, by=c("Group.1"))
c4$q1=c4$aiExecAndEvalTime.x/c4$iaExecAndEvalTime
c4$q2=c4$aiExecAndEvalTime.y/c4$iaExecAndEvalTime
cat("Average ratio allForAll / affectedForFiltered:", mean(c4$q1), "\n")
cat("Average ratio allForAll / affectedForFiltered:", mean(c4$q2), "\n")