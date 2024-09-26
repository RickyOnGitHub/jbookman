# JBookMan - the Java Spring Boot Challenge

Howdy and Welcome!! This is my simple [**fullstack portfolio application**](https://aws.amazon.com/what-is/full-stack-development/) using [**Java Spring Boot**](https://spring.io/projects/spring-boot) for backend and [**Angular**](https://angular.dev/) for frontend. They talk to each other using [**REST**](https://en.wikipedia.org/wiki/REST). The application allows the management of **books** in a virtual library system. The data model is quite simple and includes properties such as title, author, ISBN, publication year and list price. The project is based on the famous [**JHipster Framework**](https://www.jhipster.tech/), using the version 8.3.0, you can find documentation and help at [https://www.jhipster.tech/documentation-archive/v8.3.0](https://www.jhipster.tech/documentation-archive/v8.3.0).

## Quickstart

- make a subdirectory for this project on a local drive, f.e. `c:\dev`
- navigate to this target directory `cd c:\dev`
- clone this repository (assuming you are using git) `git clone https://github.com/RickyOnGitHub/jbookman.git`
- navigate to root folder of the resulting project folder `cd c:\dev\jbookman`
- run `.\mvnw` to start the application with the development profile (caution: if running this command for the first time, it might take some time due to install of node_modules subfolder)
- if built is successful, open browser and navigate to http://localhost:8080 where you will be greeted by some Java Hipster

<img src="/static/jbookman-welcome-001.png" alt="JBookMan Welcome Screen">

- sign in with username `admin` and password `admin` by selecting the entry from the **Account Menu**.

<img src="/static/jbookman-signin-001.png" alt="JBookMan Sign in Screen">

- if successfully signed in, you can select the program entities from the **Entities Menu**.

<img src="/static/jbookman-entities-001.png" alt="JBookMan Available Entities">

- to enter a new book, it helps to understand the data model, which is represented in this application in [JDL](https://www.jhipster.tech/jdl/intro/).

<img src="/static/jbookman-jdl-001.png" alt="JBookMan JDL Data Model">

- you see, there a several relationships for a book entry: if you want to create a new book (1) author, (2) publisher, (3) genre and (4) iso currency for the books' list price must be available. Don't be afraid, sample data to start off is created with [FAKER](https://fakerjs.dev/). From the list of available books, you can **Create a new book**.

<img src="/static/jbookman-entities-books-001.png" alt="JBookMan List of currently available Books">

- You enter the details information for a new book entry and store it with the Save Button:

<img src="/static/jbookman-entity-book-new-001.png" alt="JBookMan Add a new book to the List">

- The **Administration** Section offers nice-looking UIs on top of some Spring Boot's many monitoring and configuration features:

<img src="/static/jbookman-administration-001.png" alt="JBookMan Administration Menu">

- With the **Sign out** Entry from the **Account Menu**, you can leave this Application.

<img src="/static/jbookman-account-001.png" alt="JBookMan Sign Out from the Account Menu">

## Which concepts are demonstrated?

1. Initial Setup

   - Create a Spring Boot project:
     - Use Spring Initializr or another tool to create a Spring Boot project.
     - Add the necessary dependencies:
       - Spring Web (for REST)
       - Spring Data JPA (for database integration)
       - H2 with file-based persistence for the development profile
       - PostreSQL for the production profile
       - Spring Boot Test (for unit tests)

2. Implement Data Model

   - Develop a simple Book class:
     - The Book class should contain at least the following attributes:
       - Long id (unique identifier) or possibly a UUID (as String)
       - String title (title of the book)
       - String author (author of the book)
       - String isbn (ISBN number of the book)
       - int year (publication year)
       - big-decimal price (price of the book)
     - Use JPA annotations to define the class as an entity.
     - add some field level validation rules

3. Create Repository Layer

   - Create a JPA repository for the Book entity to manage interactions with the database.

4. Implement Service Layer

   - Implement a service class that encapsulates the logic of the book management service.

5. Create REST Controller

   - Develop a REST controller that provides the API endpoints.
   - The API should support the following endpoints:
     - POST /books – to add a new book
     - GET /books/{id} – to retrieve a book by ID
     - GET /books – to retrieve all books
     - PUT /books/{id} – to update a book
     - DELETE /books/{id} – to delete a book
   - Use DTOs (Data Transfer Objects) to separate communication with the client.

6. Error Handling and Validation

   - Implement error handling for cases such as:
     - A book with the specified ID does not exist (404 Not Found).
     - Invalid inputs when creating or updating a book (400 Bad Request).
   - Use @ExceptionHandler and @Valid annotations for this purpose.

7. Write Unit Tests

   - Write unit tests for the service layer to test the main logic.
     - Use Mockito to mock the repository in the tests.
     - Test all CRUD operations (create, read, update, delete).
   - Implement integration tests for the REST controller with MockMvc to ensure the endpoints work as expected.

8. Create Web-User-Interface to the Book-Service in Angular.

## What is JHipster?

JHipster is one of those open-source projects you stumble upon and immediately think, "`Of course!`" It combines three very successful frameworks in web development: Bootstrap, Angular, and Spring Boot. Bootstrap was one of the first dominant web-component frameworks. Its most substantial appeal was that it only required a bit of HTML, and it worked! It leveled the playing field in HTML/CSS development, much like Apple's Human Interface Guidelines did for iOS apps.

[Julien Dubois](https://www.julien-dubois.com) started JHipster in October 2013 (Julien's first commit was on [October 21, 2013](https://github.com/jhipster/generator-jhipster/commit/c8630ab7af7b6a99db880b3b0e2403806b7d2436). The first public release (version 0.3.1) launched on December 7, 2013. Since then, the project has had 250 releases! It is an open-source, Apache 2.0-licensed project on GitHub. It has a core team of 30 developers and over 700 contributors. You can find its homepage at [www.jhipster.tech](https://www.jhipster.tech). If you look at [the project on GitHub](https://github.com/jhipster/generator-jhipster), you can see it's mostly written in TypeScript (57%), Java (18%), and JavaScript (13%). JHipster 8 is the same JHipster many developers know and love, with a couple of bright and shiny new features: namely Spring Boot 3.2, Angular 17, Vue 3, and Java 21 support.

## Project Structure

Node is required for generation and recommended for development. `package.json` is always generated for a better development experience with prettier, commit hooks, scripts and so on.

In the project root, JHipster generates configuration files for tools like git, prettier, eslint, husky, and others that are well known and you can find references in the web.

`/src/*` structure follows default Java structure.

- `.yo-rc.json` - Yeoman configuration file
  JHipster configuration is stored in this file at `generator-jhipster` key. You may find `generator-jhipster-*` for specific blueprints configuration.
- `.yo-resolve` (optional) - Yeoman conflict resolver
  Allows to use a specific action when conflicts are found skipping prompts for files that matches a pattern. Each line should match `[pattern] [action]` with pattern been a [Minimatch](https://github.com/isaacs/minimatch#minimatch) pattern and action been one of skip (default if omitted) or force. Lines starting with `#` are considered comments and are ignored.
- `.jhipster/*.json` - JHipster entity configuration files

- `npmw` - wrapper to use locally installed npm.
  JHipster installs Node and npm locally using the build tool by default. This wrapper makes sure npm is installed locally and uses it avoiding some differences different versions can cause. By using `./npmw` instead of the traditional `npm` you can configure a Node-less environment to develop or test your application.
- `/src/main/docker` - Docker configurations for the application and services that the application depends on

## Development

Before you can build this project, you must install and configure the following dependencies on your machine:

1. [Node.js](https://nodejs.org/): We use Node to run a development web server and build the project.
   Depending on your system, you can install Node either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

```
npm install
```

We use npm scripts and [Angular CLI][] with [Webpack][] as our build system.

Run the following commands in two separate terminals to create a blissful development experience where your browser
auto-refreshes when files change on your hard drive.

```
./mvnw
npm start
```

Npm is also used to manage CSS and JavaScript dependencies used in this application. You can upgrade dependencies by
specifying a newer version in [package.json](package.json). You can also run `npm update` and `npm install` to manage dependencies.
Add the `help` flag on any command to see how you can use it. For example, `npm help update`.

The `npm run` command will list all of the scripts available to run for this project.

### PWA Support

JHipster ships with PWA (Progressive Web App) support, and it's turned off by default. One of the main components of a PWA is a service worker.

The service worker initialization code is disabled by default. To enable it, uncomment the following code in `src/main/webapp/app/app.config.ts`:

```typescript
ServiceWorkerModule.register('ngsw-worker.js', { enabled: false }),
```

### Managing dependencies

For example, to add [Leaflet][] library as a runtime dependency of your application, you would run following command:

```
npm install --save --save-exact leaflet
```

To benefit from TypeScript type definitions from [DefinitelyTyped][] repository in development, you would run following command:

```
npm install --save-dev --save-exact @types/leaflet
```

Then you would import the JS and CSS files specified in library's installation instructions so that [Webpack][] knows about them:
Edit [src/main/webapp/app/app.config.ts](src/main/webapp/app/app.config.ts) file:

```
import 'leaflet/dist/leaflet.js';
```

Edit [src/main/webapp/content/scss/vendor.scss](src/main/webapp/content/scss/vendor.scss) file:

```
@import 'leaflet/dist/leaflet.css';
```

Note: There are still a few other things remaining to do for Leaflet that we won't detail here.

For further instructions on how to develop with JHipster, have a look at [Using JHipster in development][].

### Using Angular CLI

You can also use [Angular CLI][] to generate some custom client code.

For example, the following command:

```
ng generate component my-component
```

will generate few files:

```
create src/main/webapp/app/my-component/my-component.component.html
create src/main/webapp/app/my-component/my-component.component.ts
update src/main/webapp/app/app.config.ts
```

## Building for production

### Packaging as jar

To build the final jar and optimize the jbookman application for production, run:

```
./mvnw -Pprod clean verify
```

This will concatenate and minify the client CSS and JavaScript files. It will also modify `index.html` so it references these new files.
To ensure everything worked, run:

```
java -jar target/*.jar
```

Then navigate to [http://localhost:8080](http://localhost:8080) in your browser.

Refer to [Using JHipster in production][] for more details.

### Packaging as war

To package your application as a war in order to deploy it to an application server, run:

```
./mvnw -Pprod,war clean verify
```

### JHipster Control Center

JHipster Control Center can help you manage and control your application(s). You can start a local control center server (accessible on http://localhost:7419) with:

```
docker compose -f src/main/docker/jhipster-control-center.yml up
```

## Testing

### Client tests

Unit tests are run by [Jest][]. They're located in [src/test/javascript/](src/test/javascript/) and can be run with:

```
npm test
```

UI end-to-end tests are powered by [Cypress][]. They're located in [src/test/javascript/cypress](src/test/javascript/cypress)
and can be run by starting Spring Boot in one terminal (`./mvnw spring-boot:run`) and running the tests (`npm run e2e`) in a second one.

#### Lighthouse audits

You can execute automated [lighthouse audits][https://developers.google.com/web/tools/lighthouse/] with [cypress audits][https://github.com/mfrachet/cypress-audit] by running `npm run e2e:cypress:audits`.
You should only run the audits when your application is packaged with the production profile.
The lighthouse report is created in `target/cypress/lhreport.html`

### Spring Boot tests

To launch your application's tests, run:

```
./mvnw verify
```

### E2E Webapp Code Coverage

When using Cypress, you can generate code coverage report by running your dev server with instrumented code:

Build your Angular application with instrumented code:

    npm run webapp:instrumenter

Start your backend without compiling frontend:

    npm run backend:start

Start your Cypress end to end testing:

    npm run e2e:cypress:coverage

The coverage report is generated under `./coverage/lcov-report/`

## Others

### Code quality using Sonar

Sonar is used to analyse code quality. You can start a local Sonar server (accessible on http://localhost:9001) with:

```
docker compose -f src/main/docker/sonar.yml up -d
```

Note: we have turned off forced authentication redirect for UI in [src/main/docker/sonar.yml](src/main/docker/sonar.yml) for out of the box experience while trying out SonarQube, for real use cases turn it back on.

You can run a Sonar analysis with using the [sonar-scanner](https://docs.sonarqube.org/display/SCAN/Analyzing+with+SonarQube+Scanner) or by using the maven plugin.

Then, run a Sonar analysis:

```
./mvnw -Pprod clean verify sonar:sonar -Dsonar.login=admin -Dsonar.password=admin
```

If you need to re-run the Sonar phase, please be sure to specify at least the `initialize` phase since Sonar properties are loaded from the sonar-project.properties file.

```
./mvnw initialize sonar:sonar -Dsonar.login=admin -Dsonar.password=admin
```

Additionally, Instead of passing `sonar.password` and `sonar.login` as CLI arguments, these parameters can be configured from [sonar-project.properties](sonar-project.properties) as shown below:

```
sonar.login=admin
sonar.password=admin
```

For more information, refer to the [Code quality page][].

### Using Docker to simplify development (optional)

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a postgresql database in a docker container, run:

```
docker compose -f src/main/docker/postgresql.yml up -d
```

To stop it and remove the container, run:

```
docker compose -f src/main/docker/postgresql.yml down
```

You can also fully dockerize your application and all the services that it depends on.
To achieve this, first build a docker image of your app by running:

```
npm run java:docker
```

Or build a arm64 docker image when using an arm64 processor os like MacOS with M1 processor family running:

```
npm run java:docker:arm64
```

Then run:

```
docker compose -f src/main/docker/app.yml up -d
```

When running Docker Desktop on MacOS Big Sur or later, consider enabling experimental `Use the new Virtualization framework` for better processing performance ([disk access performance is worse](https://github.com/docker/roadmap/issues/7)). For more information refer to [Using Docker and Docker-Compose](https://www.jhipster.tech/documentation-archive/v8.3.0/docker-compose), this page also contains information on the docker-compose sub-generator (`jhipster docker-compose`), which is able to generate docker configurations for one or several JHipster applications.

## Continuous Integration (optional)

To configure CI for your project, run the ci-cd sub-generator (`jhipster ci-cd`), this will let you generate configuration files for a number of Continuous Integration systems. Consult the [Setting up Continuous Integration](https://www.jhipster.tech/documentation-archive/v8.3.0/setting-up-ci/) page for more information.

## Further References

[JHipster Homepage and latest documentation](https://www.jhipster.tech)

[JHipster 8.3.0 archive](https://www.jhipster.tech/documentation-archive/v8.3.0)

[Using JHipster in development](https://www.jhipster.tech/documentation-archive/v8.3.0/development/)

[Using JHipster in production](https://www.jhipster.tech/documentation-archive/v8.3.0/production/)

[Running tests page](https://www.jhipster.tech/documentation-archive/v8.3.0/running-tests/)

[Code quality page](https://www.jhipster.tech/documentation-archive/v8.3.0/code-quality/)

[Node.js](https://nodejs.org/)

[NPM](https://www.npmjs.com/)

[Webpack](https://webpack.js.org/)

[BrowserSync](https://www.browsersync.io/)

[Jest](https://facebook.github.io/jest/)

[Cypress](https://www.cypress.io/)

[Leaflet](https://leafletjs.com/)

[DefinitelyTyped](https://definitelytyped.org/)

[Angular CLI](https://angular.dev/cli)
