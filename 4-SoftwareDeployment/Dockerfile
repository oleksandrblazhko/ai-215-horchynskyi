FROM postgres
LABEL descriptoin="Test Docker for PostgreSQL"
LABEL maintainer="Oleksii Horhcynskyi"
LABEL version="1.0"

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD 2004
ENV POSTGRES_DB horchynskyi-db

COPY ./db_script.sql /docker-entrypoint-initdb.d
