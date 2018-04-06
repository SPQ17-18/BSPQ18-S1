/* DELETE 'nucleus' database*/
DROP SCHEMA IF EXISTS cineplusDB;
/* DELETE USER 'spq' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'%';

/* CREATE 'nucleus' DATABASE */
CREATE SCHEMA cineplusDB;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER IF NOT EXISTS 'spq'@'%' IDENTIFIED BY 'spq';

GRANT ALL ON cineplusDB.* TO 'spq'@'%';