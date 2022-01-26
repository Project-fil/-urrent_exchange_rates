drop table if exists actual_course cascade;
create table TESTDB.PUBLIC.actual_course
(
    id                 varchar(255)   not null primary key,
    api_key            varchar(100)   null,
    last_update_course varchar(50)    null,
    base_code          varchar(10)    null,
    code_currency      int            null,
    usd                decimal(10, 6) null,
    eur                decimal(10, 6) null,
    last_modified_date datetime       null,
    created_date       datetime       null
);