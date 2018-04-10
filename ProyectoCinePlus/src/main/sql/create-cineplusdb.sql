/* DELETE 'messagesDB' database*/
DROP SCHEMA IF EXISTS cinePlusDB;
/* DELETE USER 'spq' AT LOCAL SERVER*/
DROP USER  'spq'@'%';

/* CREATE 'messagesDB' DATABASE */
CREATE SCHEMA cinePlusDB;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER  'spq'@'%' IDENTIFIED BY 'spq';

GRANT ALL ON cinePlusDB.* TO 'spq'@'%';