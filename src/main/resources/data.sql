INSERT INTO STORE_T (NAME, OWNER, OPEN, WEBSITE) VALUES ('Joe''s Sports Store', 'Joe', 'OPEN', 'joesports.com');

INSERT INTO ORDER_T (ID, TOTAL, CREATE_DT, VERSION) VALUES(ORDER_SEQ.nextval, 19.99, parsedatetime('17-09-2012 18:47:52.690', 'dd-MM-yyyy hh:mm:ss.SS'), 1);

INSERT INTO PRODUCT_T (NAME, QTY) VALUES('Basketball', 5, 'Y');
