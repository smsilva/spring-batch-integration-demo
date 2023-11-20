#!/bin/bash
FILE_NAME="$1"

if [ -z "${FILE_NAME?}" ]; then
  echo "Usage: $0 <FILE_NAME>"
  exit 1
fi

if [ ! -f "${FILE_NAME?}" ]; then
  echo "File not found: ${FILE_NAME?}"
  exit 1
fi

export PGPASSWORD="postgres"

psql \
  --host localhost \
  --port 5432 \
  --dbname postgres \
  --username postgres \
  --file "${FILE_NAME?}"
