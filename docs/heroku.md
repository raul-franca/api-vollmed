git push heroku main
heroku open
heroku config:set DATABASE_URL=your_database_url
heroku config:set DATABASE_PASSWORD=your_password
heroku config:set DATABASE_USER=your_user
heroku config:set DATABASE_NAME=your_database_name
heroku config:set DATABASE_HOST=your_database_host
heroku config:set DATABASE_PORT=your_database_port
heroku config:set DATABASE_SSLMODE=REQUIRED



DATABASE_URL=mysql://doadmin:AVNS_JNlNiHtI3ouE9pFFNsG@db-vollmed-do-user-17817977-0.k.db.ondigitalocean.com:25060/defaultdb?sslMode=REQUIRED
heroku config:set DATABASE_HOST=db-vollmed-do-user-17817977-0.k.db.ondigitalocean.com
heroku config:set DATABASE_PORT=25060
heroku config:set DATABASE_NAME=defaultdb
heroku config:set DATABASE_USER=doadmin
heroku config:set DATABASE_PASSWORD=AVNS_JNlNiHtI3ouE9pFFNsG
heroku config:set DATABASE_SSLMODE=REQUIRED