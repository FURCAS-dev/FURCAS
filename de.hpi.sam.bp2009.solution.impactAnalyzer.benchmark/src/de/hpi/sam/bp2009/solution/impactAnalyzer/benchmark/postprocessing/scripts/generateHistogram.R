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

aggrAllInstanceUnfiltered = aggr
aggrAllInstanceUnfiltered$measureTime = aggrAllInstanceUnfiltered$aiExecAndEvalTime
aggrAllInstanceUnfiltered$measurement = 1 

aggrAllInstanceFiltered = aggrFiltered
aggrAllInstanceFiltered$measureTime = aggrAllInstanceFiltered$aiExecAndEvalTime
aggrAllInstanceFiltered$measurement = 2
mergeAll = merge(aggrAllInstanceUnfiltered, aggrAllInstanceFiltered, all = TRUE)

for (i in 0:(dim(options)[1]-1)) {
    aggrIaFiltered = aggrFiltered[aggrFiltered$Group.4 == i, ]
    aggrIaFiltered$measureTime = aggrIaFiltered$iaExecAndEvalTime
    aggrIaFiltered$measurement = i+3
    mergeAll = merge(mergeAll, aggrIaFiltered, all = TRUE)
}
mergeAll$modelSize = -mergeAll$Group.1

pdf("ciHistogram1.pdf", width = 8, height = 6)
aggregate.plot(mergeAll$measureTime, by=list(mergeAll$measurement, mergeAll$modelSize), FUN = "mean", error = "ci", alpha = 0.1, legend = FALSE, main = NULL)
legend(x = "topleft", legend =  c("All instances with event filter", as.character(options$description)), fill=grey.colors(5))
title("Total re-evaluation time meaned with a 90% CI", ylab="Total re-evaluation time in nanoseconds", xlab="Scaled models from small to large")
dev.off()

mergeAll = merge(mergeAll, aggrAllInstanceUnfiltered, all = TRUE)

pdf("ciHistogram.pdf", width = 8, height = 6)
aggregate.plot(mergeAll$measureTime, by=list(mergeAll$measurement, mergeAll$modelSize), FUN = "mean", error = "ci", alpha = 0.1, legend = FALSE, main = NULL)
legend(x = "topleft", legend = c("All instances w/o event filter", "All instances with event filter", as.character(options$description)), fill=grey.colors(5))
title("Total re-evaluation time meaned with a 90% CI", ylab="Total re-evaluation time in nanoseconds", xlab="Scaled models from small to large")
dev.off()
