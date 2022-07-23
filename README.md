Various methods of configuring logback

Change the value of the property logging.config in application.yml to control which config file is used

Go to http://localhost:8080/chatty/index to generate some log statements

To keep things self-contained, file based logs are written to /logs directory in app base and database
logs are written to a datasource configured specifically for logging which is torn down and created in
bootstrap.