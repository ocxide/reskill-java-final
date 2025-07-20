FROM postgres

ARG PASSWORD
ARG USERS_SERVICE_DB
ARG USER

COPY ./usersservice/init.sql /migrations/usersservice.sql

CMD /bin/sh -c "\
  set -e; \
  echo Running migrations...; \
  PGPASSWORD=${PASSWORD} psql -h db -U ${USER} -c 'CREATE DATABASE ${USERS_SERVICE_DB}'; \
	PGPASSWORD=${PASSWORD} psql -h db -U ${USER} -d ${USERS_SERVICE_DB} -f /migrations/usersservice.sql; \
  echo Migrations completed. \
"
