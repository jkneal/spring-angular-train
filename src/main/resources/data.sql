INSERT INTO STORE_T (NAME, OWNER, OPEN, WEBSITE, ADDR_LINE1, ADDR_CITY, ADDR_ST, ADDR_POST_CD) VALUES ('Joe''s Sports Store', 'Joe', 'OPEN', 'joesports.com', '5100 51st', 'Chicago', 'IL', '60290');

INSERT INTO ORDER_T (ID, TOTAL, CUSTOMER_FK, CREATE_DT, VERSION) VALUES(ORDER_SEQ.nextval, 19.99, 1, parsedatetime('17-09-2012 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), 1);

INSERT INTO PRODUCT_T (NAME, DESCR, CATEGORY, PRICE, QTY) VALUES('Basketball', 'Alfred Sports Basketball, standard size', 'Playing Balls', 18.80, 5);
INSERT INTO PRODUCT_T (NAME, DESCR, CATEGORY, PRICE, QTY) VALUES('Football', 'Alfred Sports Football, not inflated', 'Playing Balls', 24.20, 3);
INSERT INTO PRODUCT_T (NAME, DESCR, CATEGORY, PRICE, QTY) VALUES('Baseball', 'Great American Baseball', 'Playing Balls', 8.00, 9);
INSERT INTO PRODUCT_T (NAME, DESCR, CATEGORY, PRICE, QTY) VALUES('Softball', 'Womans Softball College Rule', 'Playing Balls', 9.00, 9);
INSERT INTO PRODUCT_T (NAME, DESCR, CATEGORY, PRICE, QTY) VALUES('Tennisball', 'Serena Williams Signature Ball', 'Playing Balls', 5.00, 4);

INSERT INTO CUSTOMER_T (ID, NAME, CARD_NBR) VALUES(1, 'Joe Track', '111111111');
INSERT INTO CUSTOMER_T (ID, NAME, CARD_NBR) VALUES(2, 'Jay Bob', '222222222');

INSERT INTO CATEGORY_T (ID, CODE) VALUES(1, 'Playing Balls');
INSERT INTO CATEGORY_T (ID, CODE) VALUES(2, 'Equipment');
INSERT INTO CATEGORY_T (ID, CODE) VALUES(3, 'Clothes');
INSERT INTO CATEGORY_T (ID, CODE) VALUES(4, 'Safety');
INSERT INTO CATEGORY_T (ID, CODE) VALUES(5, 'Fitness');
