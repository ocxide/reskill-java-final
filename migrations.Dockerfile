FROM postgres

ARG PASSWORD
ARG USERS_SERVICE_DB
ARG USER

COPY usersservice/init.sql /migrations/usersservice.sql
COPY booksservice/init.sql /migrations/bookservice.sql
COPY borrowingsservice/init.sql /migrations/borrowingsservice.sql
COPY notificationsservice/init.sql /migrations/notificationservice.sql

COPY createdb.sh /migrations/createdb.sh
RUN chmod +x /migrations/createdb.sh

CMD /bin/sh -c "\
	PGPASSWORD=${PASSWORD} /migrations/createdb.sh ${USERS_SERVICE_DB}; \
	PGPASSWORD=${PASSWORD} /migrations/createdb.sh ${BOOKS_SERVICE_DB}; \
	PGPASSWORD=${PASSWORD} /migrations/createdb.sh ${BORROWINGS_SERVICE_DB}; \
	PGPASSWORD=${PASSWORD} /migrations/createdb.sh ${NOTIFICATIONS_SERVICE_DB}; \
  echo Running migrations...; \
	PGPASSWORD=${PASSWORD} psql -h db -U ${USER} -d ${USERS_SERVICE_DB} -f /migrations/usersservice.sql; \
	PGPASSWORD=${PASSWORD} psql -h db -U ${USER} -d ${BOOKS_SERVICE_DB} -f /migrations/bookservice.sql; \
	PGPASSWORD=${PASSWORD} psql -h db -U ${USER} -d ${BORROWINGS_SERVICE_DB} -f /migrations/borrowingsservice.sql; \
	PGPASSWORD=${PASSWORD} psql -h db -U ${USER} -d ${NOTIFICATIONS_SERVICE_DB} -f /migrations/notificationservice.sql; \
  echo Migrations completed. \
"
