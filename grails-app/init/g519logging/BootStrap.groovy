package g519logging

import grails.gorm.transactions.Transactional
import groovy.sql.Sql

import javax.sql.DataSource

class BootStrap {

    static final dropTables =
            """DROP TABLE logging_event_exception IF EXISTS;
            DROP TABLE logging_event_property IF EXISTS;
            DROP TABLE logging_event IF EXISTS;"""

    static final createLoggingEvent =
            """CREATE TABLE logging_event (
  timestmp BIGINT NOT NULL,
  formatted_message LONGVARCHAR NOT NULL,
  logger_name VARCHAR(256) NOT NULL,
  level_string VARCHAR(256) NOT NULL,
  thread_name VARCHAR(256),
  reference_flag SMALLINT,
  arg0 VARCHAR(256),
  arg1 VARCHAR(256),
  arg2 VARCHAR(256),
  arg3 VARCHAR(256),
  caller_filename VARCHAR(256), 
  caller_class VARCHAR(256), 
  caller_method VARCHAR(256), 
  caller_line CHAR(4),
  event_id IDENTITY NOT NULL)"""

    static final createLoggingEventProperty =
            """CREATE TABLE logging_event_property (
  event_id BIGINT NOT NULL,
  mapped_key  VARCHAR(254) NOT NULL,
  mapped_value LONGVARCHAR,
  PRIMARY KEY(event_id, mapped_key),
  FOREIGN KEY (event_id) REFERENCES logging_event(event_id))"""

    static final createLoggingEventException =
            """CREATE TABLE logging_event_exception (
  event_id BIGINT NOT NULL,
  i SMALLINT NOT NULL,
  trace_line VARCHAR(256) NOT NULL,
  PRIMARY KEY(event_id, i),
  FOREIGN KEY (event_id) REFERENCES logging_event(event_id))"""

    DataSource dataSource_loggingDs

    def init = { servletContext ->
        createLoggingTables()
    }

    @Transactional
    def createLoggingTables() {
        def sql = new Sql(dataSource_loggingDs)
        sql.withTransaction {
            it.prepareStatement(dropTables).executeUpdate()
            it.prepareStatement(createLoggingEvent).executeUpdate()
            it.prepareStatement(createLoggingEventProperty).executeUpdate()
            it.prepareStatement(createLoggingEventException).executeUpdate()
        }
    }

    def destroy = {
    }
}
