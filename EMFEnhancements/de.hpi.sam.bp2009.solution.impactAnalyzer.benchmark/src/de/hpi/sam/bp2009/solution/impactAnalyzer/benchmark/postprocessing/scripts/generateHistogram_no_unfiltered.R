require(epicalc)
# read different optimization options from data file:
options=read.table("optionDescription.data", sep="\t", header=TRUE)

# Pick only every second model size
result = result[result$modelId %% 2 == 0, ]

result$iaExecAndEvalTime = result$executionTime + result$evaluationTimeAfter
result$aiExecAndEvalTime = result$allInstanceEvalTime + result$allInstanceExecTime

aggr = aggregate(result[, c("aiExecAndEvalTime", "iaExecAndEvalTime")], by=list(result$modelId, result$oclId, result$executionIndex, result$optionId), FUN = "sum") 

filtered = result[result$filtered == TRUE, ]
aggrFiltered = aggregate(filtered[, c("aiExecAndEvalTime", "iaExecAndEvalTime")], by=list(filtered$modelId, filtered$oclId, filtered$executionIndex, filtered$optionId), FUN = "sum")

# Selecting the options (row numbers starting with 1 from optionDescription.data) to show:
optionsToShow=c(1,3,4,6,9)

aggrAllInstanceUnfiltered = aggr
aggrAllInstanceUnfiltered$measureTime = aggrAllInstanceUnfiltered$aiExecAndEvalTime
aggrAllInstanceUnfiltered$measurement = 1 

aggrAllInstanceFiltered = aggrFiltered
aggrAllInstanceFiltered$measureTime = aggrAllInstanceFiltered$aiExecAndEvalTime
aggrAllInstanceFiltered$measurement = 2
mergeAll = merge(aggrAllInstanceUnfiltered, aggrAllInstanceFiltered, all = TRUE)

for (i in optionsToShow) {
    aggrIaFiltered = aggrFiltered[aggrFiltered$Group.4 == i-1, ]
    aggrIaFiltered$measureTime = aggrIaFiltered$iaExecAndEvalTime
    aggrIaFiltered$measurement = i+2
    mergeAll = merge(mergeAll, aggrIaFiltered, all = TRUE)
}
mergeAll$modelSize = -mergeAll$Group.1

# Remove unfiltered allInstances stuff
#mergeAll = mergeAll[mergeAll$measurement != 1 & mergeAll$measurement != 2,]
mergeAll = mergeAll[mergeAll$measurement != 1,]

pdf("ciHistogram_no_unfiltered.pdf", width = 8, height = 6)
aggregate.plot(mergeAll$measureTime, by=list(mergeAll$measurement, mergeAll$modelSize), FUN = "mean", error = "ci", alpha = 0.1, legend = FALSE, main = NULL)
legend(x = "topleft", legend =  c("Evaluation on allInstances() for expressions whose filter is matched by event", as.character(options$description)[optionsToShow]), fill=grey.colors(length(optionsToShow)+1))
title("Total re-evaluation time meaned with a 90% CI", ylab="Total re-evaluation time in nanoseconds", xlab="Scaled models from small to large")
dev.off()
