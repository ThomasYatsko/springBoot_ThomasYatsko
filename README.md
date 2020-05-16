h2 as in memory RDBMS (Relational DB Management System)

defining (part of) RDBMS schema via schema.sql of SpringBoot (see src/main/resources/schema.sql)

updating RDBMS schema via JPA(hybernate) via "spring.jpa.hibernate.ddl-auto=update" value in application.properties

initializing RDBMS schema via data.sql of SpringBoot (see src/main/resources/data.sql)

using jdbcTemplate to hand code access to RDBMS (h2) via SQL in code

using ORM(Object Relational Mapping) to access RDBMS (h2) via JPA (via it's default implementation, hybernate). Hence we write very little code. SQL will be generated and executed via hybernate

using JPA's JPQL Query and "Native" SQL Query (see exp17c.jpa.repo.StaffRepository)

creating REST api end points (resources) via Spring Web

swagger to generate documents for REST api end points

jUnit5 to unit and integration test

using lombok to instrument(auto generate) setter/getter/constructor/.. of a POJO via lombok annotations

using spring-boot-devtools (see pom.xml), which watches changes in code and triggers auto deployments of app upon saved code changes, will ONLY be in effect during dev runs, will NOT be there in PROD jar build

RDBMS schema creation via schema.sql and initializing via data.sql
