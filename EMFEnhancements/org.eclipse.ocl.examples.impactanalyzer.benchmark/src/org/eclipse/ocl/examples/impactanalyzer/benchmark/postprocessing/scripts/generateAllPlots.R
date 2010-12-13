require(lattice)
require(outliers)

ylabEvalTime = "Evaluation time (total) in nanoseconds"

attach(strippedResult)
png("plotScatterModelSize.png", width=1200, height=800, res = 110)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ modelSize | optionId, type=c("p", "r"),
xlab = "Number of model elements (model size)",
ylab = ylabEvalTime,
auto.key=TRUE)
dev.off()

png("plotScatterOclId.png", width=1200, height=800, res = 110)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ oclId | optionId, type=c("p"),
xlab = "Different OCL Expressions",
ylab = ylabEvalTime,
auto.key=TRUE)
dev.off()

png("plotScatterNotificationId.png", width=1200, height=800, res = 110)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ notificationId | optionId, type=c("p"),
xlab = "Different model change notifications",
ylab = ylabEvalTime,
auto.key=TRUE)
dev.off()

png("plotScatterNoAllInstances.png", width=1200, height=800, res = 110)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ noAllInstances | optionId, type=c("p", "r"),
xlab = "Number of all instances of context of OCL Expression",
ylab = ylabEvalTime,
auto.key=TRUE)
dev.off()

aggregatedResult = aggregate(strippedResult, by=list(modelSize, optionId), FUN=mean)
detach(strippedResult)
attach(aggregatedResult)

png("plotScatterModelSizeMean.png", width=1200, height=800, res = 110)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ modelSize | optionId, type=c("p", "r"),
xlab = "Number of model elements (model size)",
ylab = "Meaned evaluation time (total) in nanoseconds,
auto.key=TRUE"
)
dev.off()

detach(aggregatedResult)
attach(strippedResult)
aggregatedResult = aggregate(strippedResult, by=list(oclId, optionId), FUN = mean)
detach(strippedResult)
attach(aggregatedResult)

png("plotScatterOclMean.png", width=1200, height=800, res = 110)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ oclId | optionId, type=c("p"),
xlab = "Different OCL Expressions",
ylab = "Meaned evaluation time (total) in nanoseconds",
auto.key=TRUE)
dev.off()

detach(aggregatedResult)
attach(strippedResult)
aggregatedResult = aggregate(strippedResult, by=list(notificationId, optionId), FUN=mean)
detach(strippedResult)
attach(aggregatedResult)

png("plotScatterNotificationMean.png", width=1200, height=800, res = 110)
xyplot(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ notificationId | optionId, type=c("p"),
xlab = "Different model change notifications",
ylab = "Meaned evaluation time (total) in nanoseconds",
auto.key=TRUE)
dev.off()

detach(aggregatedResult)
attach(strippedResult)
png("plot3dScatterOclNotification.png", width=2400, height=2400)
cloud(allInstancesEvalAndExecTime + iaEvalAndExecTime ~ modelSize * oclId | optionId, data = strippedResult, auto.key=TRUE)
dev.off()
detach(strippedResult)
