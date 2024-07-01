$ sudo -u postgres psql

postgres=# CREATE USER shrikant WITH PASSWORD 'kale';
CREATE ROLE

postgres=# CREATE DATABASE ultimate_db OWNER shrikant;
CREATE DATABASE

postgres=# \l
                                    List of databases
    Name     |   Owner   | Encoding |   Collate   |    Ctype    |    Access privileges
-------------+-----------+----------+-------------+-------------+-------------------------
 ultimate_db | shrikant  | UTF8     | en_US.UTF-8 | en_US.UTF-8 |
(1 rows)

postgres=# GRANT ALL PRIVILEGES ON DATABASE ultimate_db TO shrikant;T
GRANT


postgres=# \c ultimate_db;
You are now connected to database "ultimate_db" as user "postgres".


ultimate_db=# \dt;
          List of relations
 Schema |  Name   | Type  |  Owner
--------+---------+-------+----------
 public | student | table | shrikant
(1 row)


ultimate_db=# \d student
                        Table "public.student"
   Column   |          Type          | Collation | Nullable | Default
------------+------------------------+-----------+----------+---------
 age        | integer                |           | not null |
 id         | integer                |           | not null |
 email      | character varying(255) |           |          |
 first_name | character varying(255) |           |          |
 last_name  | character varying(255) |           |          |
Indexes:
    "student_pkey" PRIMARY KEY, btree (id)


ultimate_db=# select * from student;
 age | id | email | first_name | last_name
-----+----+-------+------------+-----------
(0 rows)

ultimate_db=#
