INSERT INTO STORE_T (NAME, OWNER, OPEN, WEBSITE, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('Joe''s Sports Store', 'Joe', 'OPEN', 'joesports.com', '5100 51st', 'Chicago', 'IL', '60290', parsedatetime('01-09-2012 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS'));
INSERT INTO STORE_T (NAME, OWNER, OPEN, WEBSITE, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('Other Sports Store', 'Joe', 'OPEN', 'othersports.com', '5200 51st', 'Chicago', 'IL', '60290', parsedatetime('01-09-2013 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS'));
INSERT INTO STORE_T (NAME, OWNER, OPEN, WEBSITE, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('New Sports Store', 'Joe', 'OPEN', 'newsports.com', '5300 51st', 'Chicago', 'IL', '60290', parsedatetime('01-09-2014 00:00:00.000', 'dd-MM-yyyy hh:mm:ss.SS'));

INSERT INTO ORDER_T (ID, PRODUCT_ID, TOTAL, CREATE_DT, VERSION, CUSTOMER_FK) VALUES(ORDER_SEQ.nextval, 1, 19.99, parsedatetime('17-09-2012 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), 1, 1);

INSERT INTO PRODUCT_T (ID, NAME, DESCR, CATEGORY, PRICE, QTY, BACKORDER_AVAILABLE, CREATE_DT) VALUES(1, 'Basketball', 'Alfred Sports Basketball, standard size', 'Playing Balls', 18.80, 5, 'Y', current_timestamp());
INSERT INTO PRODUCT_T (NAME, DESCR, CATEGORY, PRICE, QTY, BACKORDER_AVAILABLE, CREATE_DT) VALUES('Football', 'Alfred Sports Football, not inflated', 'Playing Balls', 24.20, 3, 'N', current_timestamp());
INSERT INTO PRODUCT_T (NAME, DESCR, CATEGORY, PRICE, QTY, BACKORDER_AVAILABLE, CREATE_DT) VALUES('Baseball', 'Great American Baseball', 'Playing Balls', 8.00, 9, 'N', current_timestamp());
INSERT INTO PRODUCT_T (NAME, DESCR, CATEGORY, PRICE, QTY, BACKORDER_AVAILABLE, CREATE_DT) VALUES('Softball', 'Womans Softball College Rule', 'Playing Balls', 9.00, 9, 'Y', current_timestamp());
INSERT INTO PRODUCT_T (NAME, DESCR, CATEGORY, PRICE, QTY, BACKORDER_AVAILABLE, CREATE_DT) VALUES('Tennisball', 'Serena Williams Signature Ball', 'Playing Balls', 5.00, 4, 'N', current_timestamp());

INSERT INTO CATEGORY_T (ID, CODE) VALUES(1, 'Playing Balls');
INSERT INTO CATEGORY_T (ID, CODE) VALUES(2, 'Equipment');
INSERT INTO CATEGORY_T (ID, CODE) VALUES(3, 'Clothes');
INSERT INTO CATEGORY_T (ID, CODE) VALUES(4, 'Safety');
INSERT INTO CATEGORY_T (ID, CODE) VALUES(5, 'Fitness');

INSERT INTO CUSTOMER_T (USERNAME, CARD_NBR, FIRST_NAME, LAST_NAME, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('johndoe', '111111111', 'John', 'Doe', '1234 Sesame St', 'Chicago', 'IL', '60290', current_timestamp());
INSERT INTO CUSTOMER_T (USERNAME, CARD_NBR, FIRST_NAME, LAST_NAME, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD, CREATE_DT) VALUES ('janedoe', '222222222', 'Jane', 'Doe', '5678 Sesame St', 'Chicago', 'IL', '60290', current_timestamp());

INSERT INTO ORDER_ITEM_T (ORDER_ID, PRODUCT_ID, QTY, CREATE_DT) VALUES (1, 1, 2, current_timestamp());