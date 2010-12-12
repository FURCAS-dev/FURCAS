#!/bin/sh
if [ "$1" = "" ]; then
  echo Usage: progress \<result.data filename\>
  echo    outputs the number of the job currently being executed \(counted
  echo    starting with 0\)
else
  tail "$1" | awk '{ print $2; }' | sort -u | grep [0-9][0-9]* | tail -1
fi
