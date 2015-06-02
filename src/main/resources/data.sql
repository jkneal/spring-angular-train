INSERT INTO STORE_T (NAME, OWNER, OPEN, WEBSITE, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('Joe''s Sports Store', 'Joe', 'OPEN', 'joesports.com', '5100 51st', 'Chicago', 'IL', '60290', parsedatetime('01-09-2012 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS'));
INSERT INTO STORE_T (NAME, OWNER, OPEN, WEBSITE, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('Other Sports Store', 'Joe', 'OPEN', 'othersports.com', '5200 51st', 'Chicago', 'IL', '60290', parsedatetime('01-09-2013 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS'));
INSERT INTO STORE_T (NAME, OWNER, OPEN, WEBSITE, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('New Sports Store', 'Joe', 'OPEN', 'newsports.com', '5300 51st', 'Chicago', 'IL', '60290', parsedatetime('01-09-2014 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS'));

INSERT INTO ORDER_T (ID, TOTAL, CREATE_DT, VERSION, CUSTOMER_ID) VALUES(ORDER_SEQ.nextval, 19.99, parsedatetime('17-09-2012 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 1);

INSERT INTO PRODUCT_T (NAME, QTY, BACKORDER_AVAILABLE, CREATE_DT) VALUES('Basketball', 5, 'Y', current_timestamp());

INSERT INTO CUSTOMER_T (USERNAME, FIRST_NAME, LAST_NAME, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('johndoe', 'John', 'Doe', '1234 Sesame St', 'Chicago', 'IL', '60290', current_timestamp());
INSERT INTO CUSTOMER_T (USERNAME, FIRST_NAME, LAST_NAME, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('janedoe', 'Jane', 'Doe', '5678 Sesame St', 'Chicago', 'IL', '60290', current_timestamp());

INSERT INTO ORDER_ITEM_T (ORDER_ID, PRODUCT_ID, QTY, CREATE_DT) VALUES (1, 1, 2, current_timestamp());