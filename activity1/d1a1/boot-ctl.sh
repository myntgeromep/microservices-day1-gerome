#!/usr/bin/env sh

SERVICE_NAME="account-management"
VERSION="0.0.1-SNAPSHOT"
PIDFILE="application.pid"
LOG_FILE="$SERVICE_NAME.log"

pid=""
get_pid() {
  pid=$(cat "$PIDFILE")
}

start() {
  echo "Starting $SERVICE_NAME ..."
  COMMAND="nohup java -jar $SERVICE_NAME-$VERSION.jar >> $LOG_FILE 2>&1 &"
  eval "$COMMAND"
  echo "Started $SERVICE_NAME"
}

stop() {
  echo "Stopping $SERVICE_NAME ..."
  get_pid
  kill -9 "$pid"
  rm $PIDFILE
  echo "Stopped $SERVICE_NAME"
}

case "$1" in

    'start')
        start
        ;;

    'stop')
        stop
        ;;

    'restart')
        stop
        start
        ;;

    *)
        echo "Usage: $0 { start | stop | restart }"
        exit 1
        #;;
esac

exit 0