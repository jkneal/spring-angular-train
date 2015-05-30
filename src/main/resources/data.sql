INSERT INTO STORE_T (NAME, OWNER, OPEN, WEBSITE, CREATE_DT) VALUES ('Joe''s Sports Store', 'Joe', 'OPEN', 'joesports.com', parsedatetime('01-09-2012 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS'));

INSERT INTO ORDER_T (ID, TOTAL, CREATE_DT, VERSION) VALUES(ORDER_SEQ.nextval, 19.99, parsedatetime('17-09-2012 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), 1);

INSERT INTO PRODUCT_T (NAME, QTY, BACKORDER_AVAILABLE, CREATE_DT) VALUES('Basketball', 5, 'Y', current_timestamp());

INSERT INTO CUSTOMER_T (USERNAME, FIRST_NAME, LAST_NAME, CREATE_DT) VALUES ('johndoe', 'John', 'Doe', current_timestamp());
INSERT INTO CUSTOMER_T (USERNAME, FIRST_NAME, LAST_NAME, CREATE_DT) VALUES ('janedoe', 'Jane', 'Doe', current_timestamp());
