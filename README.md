sales-taxes

#### Pre-requirements

* JDK 1.8
* Maven 3.x (optional)

#### How to start the application

Download or clone this repo and start a terminal at the root directory (where `pom.xml` file is located).

If [Apache Maven](http://maven.apache.org/) it's properly installed and set-up in your environment, you can type on terminal:

`mvn spring-boot:run`

But if you <b>don't</b> have Maven, you can use [Maven Wrapper](https://github.com/takari/maven-wrapper), which is provided within the package.

On Linux:

`./mvnw spring-boot:run`

On Windows:

`mvnw.bat spring-boot:run`

At the first time, it maybe can take few minutes until all dependencies are downloaded.
In a couple seconds the application will start.
When the following log appears on your terminal, it's everything ok:

`INFO 29840 --- [           main] c.d.salestaxes.SalesTaxesApplication     : Started SalesTaxesApplication in 7.374 seconds`

Then, you can access http://localhost:9009/docs and start using the application.
