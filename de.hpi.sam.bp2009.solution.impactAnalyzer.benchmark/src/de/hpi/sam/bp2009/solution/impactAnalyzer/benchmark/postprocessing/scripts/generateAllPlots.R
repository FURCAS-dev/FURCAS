require(lattice)
require(outliers)

result = read.table("~/Dropbox/fullResult8.data", header = TRUE)

result$iaEvalAndExecTime = result$executionTime + result$evaluationTimeAfter
result$allInstancesEvalAndExecTime = result$allInstanceEvalTime + result$allInstanceExecTime

attach(result)
strippedResult = result[noAllInstances != allInstanceNoInvalidEvals, ]
detach(result)

ylabEvalTime = "Evaluation time (total) in nanoseconds"

attach(strippedResult)
png("/tmp/plotScatterModelSize.png", width=1200, height=800)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ modelSize | optionId, type=c("p", "r"),
xlab = "Number of model elements (model size)",
ylab = ylabEvalTime)
dev.off()

png("/tmp/plotScatterOclId.png", width=1200, height=800)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ oclId | optionId, type=c("p", "r"),
xlab = "Different OCL Expressions",
ylab = ylabEvalTime)
dev.off()

png("/tmp/plotScatterNotificationId.png", width=1200, height=800)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ notificationId | optionId, type=c("p", "r"),
xlab = "Different model change notifications",
ylab = ylabEvalTime)
dev.off()

png("/tmp/plotScatterNoAllInstances.png", width=1200, height=800)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ noAllInstances | optionId, type=c("p", "r"),
xlab = "Number of all instances of context of OCL Expression"
ylab = ylabEvalTime)
dev.off()

aggregatedResult = aggregate(strippedResult, by=list(modelSize, optionId), FUN=mean)
detach(strippedResult)
attach(aggregatedResult)

png("/tmp/plotScatterModelSizeMean.png", width=1200, height=800)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ modelSize | optionId, type=c("p", "r"),
xlab = "Number of model elements (model size)",
ylab = "Meaned evaluation time (total) in nanoseconds"
)
dev.off()

detach(aggregatedResult)
attach(strippedResult)
aggregatedResult = aggregate(strippedResult, by=list(oclId, optionId), FUN = mean)
detach(strippedResult)
attach(aggregatedResult)

png("/tmp/plotScatterOclMean.png", width=1200, height=800)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ oclId | optionId, type=c("p", "r"),
xlab = "Different OCL Expressions"
ylab = "Meaned evaluation time (total) in nanoseconds"
dev.off()

detach(aggregatedResult)
attach(strippedResult)
aggregatedResult = aggregate(strippedResult, by=list(notificationId, optionId), FUN=mean)
detach(strippedResult)
attach(aggregatedResult)

png("/tmp/plotScatterNotificationMean.png", width=1200, height=800)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ notificationId | optionId, type=c("p", "r"),
xlab = "Different model change notifications",
ylab = "Meaned evaluation time (total) in nanoseconds")
dev.off()

detach(aggregatedResult)
attach(strippedResult)
png("/tmp/plot3dScatterOclNotification.png", width=1200, height=1200)
cloud(allInstacesEvalAndExecTime + iaEvalAndExecTime ~ modelSize * oclId | optionId, data = strippedResult)
dev.off()

