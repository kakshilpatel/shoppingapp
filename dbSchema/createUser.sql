CREATE USER 'guest'@'localhost' IDENTIFIED BY 'guestpswd';
GRANT ALL PRIVILEGES ON cs532_finalpj.* TO 'guest'@'localhost' WITH GRANT OPTION;
SHOW GRANTS FOR 'guest'@'localhost';