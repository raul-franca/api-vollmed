Horizontal scaling an application on Heroku is equivalent to changing 
the number of running dynos.

Scale the number of web dynos to zero:
heroku ps:scale web=0

Access the app again by refreshing your browser or running heroku open. 
You get an error message because your app no longer has any web dynos available to serve requests.

Scale it up again:
heroku ps:scale web=1
