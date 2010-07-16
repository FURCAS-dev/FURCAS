require(outliers)
require(lattice)
results = read.table("/tmp/result.data", header=TRUE)

length(results$executionTime)

summary(results)

for(i in 1:5){
results$cleanExecutionTime = ifelse(results$executionTime == outlier(results$executionTime), NA, results$executionTime)
results = subset(results, !is.na(results$cleanExecutionTime))
results$cleanExecutionTime = NULL;
}
summary(results)
aggregatedResults = aggregate(results, by=list(results$modelSize), FUN=mean)
attach(aggregatedResults)
plot(x=modelSize, y=executionTime)
pdf("result.pdf")
xyplot(executionTime~modelSize, type=c("p","r"))
dev.off()
detach(aggregatedResults)