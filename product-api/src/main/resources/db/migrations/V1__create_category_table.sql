CREATE IF NOT EXISTS SCHEMA SC_PRODUCTS;

CREATE TABLE SC_PRODUCTS.TB_CATEGORY(
    ID BIGSERIAL NOT NULL PRIMARY KEY,
    NAME VARCHAR(100) NOT NULL
);