#!/bin/bash -e
DEFAULT_BROWSER=chrome
BROWSER_TYPE=$1

if [ -z "$BROWSER_TYPE" ]; then
    echo "BROWSER_TYPE value not set, defaulting to $DEFAULT_BROWSER..."
    echo ""
fi

# Scalafmt checks have been separated from the test command to avoid OutOfMemoryError in Jenkins
#sbt scalafmtCheckAll scalafmtSbtCheck

./startup_auth.sh

./run_browser_with_docker.sh $DEFAULT_BROWSER

sbt clean -Dbrowser="${BROWSER_TYPE:=$DEFAULT_BROWSER}" -Denvironment=local "testOnly uk.gov.hmrc.alcoholDuty.cucumber.runner.Runner" testReport
