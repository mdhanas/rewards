CREATE TABLE CUSTOMER (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          firstName VARCHAR(250) NOT NULL,
                          lastName VARCHAR(250) NOT NULL,
);

CREATE TABLE CUSTOMER_SALES (customerId INT NOT NULL,
                             salesAmount DOUBLE NOT NULL,
                             salesDate DATE NOT NULL );