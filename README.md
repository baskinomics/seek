# seek

## tldr;

I am building an API to be consumed by a web application because maintaining a spreadsheet sucks.

## Origins

Searching for a software engineer or software developer position is a non-trivial task. My process has conformed to the following steps:

1. Identify positions and companies.
2. Gather metadata about the positions and companies, i.e. Glassdoor salary estimates, company rating, position interview difficulty, etc.
3. Write a cover letter for each position.
4. Submit an application.

While one does strive to select opportunities which one is most qualified for or which the probability of success is high, this process is a "numbers game" for a littany of reasons and requires submitting applications in volume. As such, keeping this information organized and ascertaining a clear understanding of where one is in the process can be a burden of time and resources. 

My initial solution to this problem domain was to construct an elaborate Google Docs spreadsheet. As I progressed through the process I began to realize that while effective for its current purpose, the data entry and maintenance of the various sheets was tedious. In addition, all of the business logic and data relationships were contained only in my brain. 

After taking some time to evaluate the datasets and the aforementioned items, I decided to build an API to capture and improve upon what I had composed in my spreadsheet while adding functionality that would ease the burden imposed of maintaining the spreadsheets by hand. Furthermore, given the intended end-user (a software engineer) and the ubiquitous experience of having to find employment I figured I'd share this with the world. 

There is no shortage of tools to _find_ a job: LinkedIn, Indeed, Glassdoor, StackOverflow Jobs, etcetera. But to date, I have not come across any tools in this specific domain aimed at the job seeker _themselves_. Looking for a job, frankly, sucks. The goal of `seek` is to reduce the degrees of suck in that experience.

## Notes and Resources

This section is a temporary topic that serves as my personal notepad while I am developing the application.
### Micronaut
* [Micronaut Guides - Access a database with JPA and Hibernate](https://guides.micronaut.io/micronaut-data-access-jpa-hibernate/guide/index.html)
* [GitHub - Micronaut Guides - Access a database with JPA and Hibernate](https://github.com/micronaut-guides/micronaut-data-access-jpa-hibernate/tree/master/complete)
* [Server Events](https://docs.micronaut.io/latest/guide/index.html#serverEvents)
* [Configuring Hibernate](https://micronaut-projects.github.io/micronaut-sql/latest/guide/#hibernate)

### JPA and Hibernate
* [Criteria Queries Using JPA Metamodel](https://www.baeldung.com/hibernate-criteria-queries-metamodel)
* [Restricting Criteria Query Results](https://docs.oracle.com/cd/E19798-01/821-1841/gjivi/index.html)
* [Java Persistence - Identity Sequencing](https://en.wikibooks.org/wiki/Java_Persistence/Identity_and_Sequencing#Identity_sequencing)

### Lombok
* [`@Data`](https://projectlombok.org/features/Data)
* [Introduction to Project Lombok](https://www.baeldung.com/intro-to-project-lombok)
* [IntelliJ IDEA](https://projectlombok.org/setup/intellij)

### Docker
* [postgres | Docker Documentation](https://docs.docker.com/samples/library/postgres/)
* [Compose file version 3 reference](https://docs.docker.com/compose/compose-file/)

### PostgreSQL
* [PostgreSQL 11.4 Documentation](https://www.postgresql.org/docs/11/index.html)
* [The Basics of the PostgreSQL UUID Data Type](http://www.postgresqltutorial.com/postgresql-uuid/)

