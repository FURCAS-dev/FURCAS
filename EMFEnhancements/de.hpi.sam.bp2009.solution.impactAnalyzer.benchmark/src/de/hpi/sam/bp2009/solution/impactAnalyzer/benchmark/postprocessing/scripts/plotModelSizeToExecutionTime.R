require(outliers)
require(lattice)
#result = read.table("result.data", header=TRUE)

length(result$executionTime)

summary(result)

for(i in 1:5){
result$cleanExecutionTime = ifelse(result$executionTime == outlier(result$executionTime), NA, result$executionTime)
result = subset(result, !is.na(result$cleanExecutionTime))
result$cleanExecutionTime = NULL;
}
summary(result)
aggregatedresult = aggregate(result, by=list(result$modelSize), FUN=mean)
attach(aggregatedresult)
plot(x=modelSize, y=executionTime)
xyplot(executionTime~modelSize, type=c("p","r"))
detach(aggregatedresult)