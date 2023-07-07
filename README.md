# Token based auth - Instructions for setting up and running the application
<hr>
<h2>Clone the repo</h2>

step 1: use below cammand to clone the repo

<pre>
git clone https://github.com/shashanknaik0/spring-token-auth.git
</pre>


step 2: get into the directory
<pre>
cd spring-token-auth
</pre>

<hr>
<h2>Install dependency</h2>
install java 17 from official java website.<br>
install gradle for java extension and use UI to install dependency.

<hr>
<h2>Run the project</h2>
use UI to run gradle project or use below cammand
<pre>
./gradlew bootRun
</pre>

step 4: development server will run at http://127.0.0.1:8080. Read <a href="API%20documentation.pdf">API documentation</a> for more information.<br>
use postman to send the http requests.
<pre>
/signup - (POST) Add a new user to the platform. The user details will include fields like username, email, and password. 
/login - (POST) Login to the page to genatrate auth token.
/secret - (GET) only user with valid authentication token can access.
</pre>
