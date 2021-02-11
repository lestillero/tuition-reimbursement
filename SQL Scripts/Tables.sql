--------------------------------------------------------------------------------------------------------------------------------
-- CREATE TABLES

DROP TABLE staff;
DROP TABLE request_status;
DROP TABLE request_info;
DROP TABLE fund_info;
DROP TABLE dept;

CREATE TABLE staff (
    staff_id NUMBER(10) PRIMARY KEY,
    first_name VARCHAR2(20),
    last_name VARCHAR2(20),
    supervisor_id NUMBER(10),
    dept_id NUMBER(10),
    avail_fund NUMBER(10,2)
);

CREATE TABLE request_info (
    request_id NUMBER(20) PRIMARY KEY,
    staff_id NUMBER(10),
    date_start DATE,
    date_end DATE,
    location VARCHAR2(20),
    event_type VARCHAR2(25),
    description VARCHAR2(280),
    grading_format VARCHAR2(20),
    supporting_docs VARCHAR2(140),
    passing_grade_verif VARCHAR2(140)
);

CREATE TABLE request_status (
    request_id NUMBER(20) PRIMARY KEY,
    status VARCHAR2(20),
    date_requestor DATE,
    addtlinfo_requestor VARCHAR2(280),
    date_supervisor DATE,
    addtlinfo_supervisor VARCHAR2(280),
    date_dept DATE,
    addtlinfo_dept VARCHAR2(280),
    date_benco DATE,
    addtlinfo_benco VARCHAR2(280)
);

CREATE TABLE fund_info (
    request_id NUMBER(20) PRIMARY KEY,
    amt_requested NUMBER(10,2),
    amt_awarded NUMBER(10,2)
);

ALTER TABLE fund_info ADD amt_reimbursed NUMBER(10,2);

CREATE TABLE dept (
    dept_id NUMBER(10) PRIMARY KEY,
    dept_name VARCHAR2(20),
    dept_head_id NUMBER(10)
);

--------------------------------------------------------------------------------------------------------------------------------
-- ADD FOREIGN KEYS

ALTER TABLE request_info DROP CONSTRAINT fk_request_info_staff;
ALTER TABLE request_status DROP CONSTRAINT fk_request_status_info;
ALTER TABLE fund_info DROP CONSTRAINT fk_fund_request_info;
ALTER TABLE staff DROP CONSTRAINT fk_staff_dept;


ALTER TABLE request_info ADD CONSTRAINT fk_request_info_staff FOREIGN KEY
(staff_id) REFERENCES staff(staff_id);

ALTER TABLE request_status ADD CONSTRAINT fk_request_status_info FOREIGN KEY
(request_id) REFERENCES request_info(request_id) ON DELETE CASCADE;

ALTER TABLE fund_info ADD CONSTRAINT fk_fund_request_info FOREIGN KEY
(request_id) REFERENCES request_info(request_id) ON DELETE CASCADE;

ALTER TABLE staff ADD CONSTRAINT fk_staff_dept FOREIGN KEY
(dept_id) REFERENCES dept(dept_id);

--------------------------------------------------------------------------------------------------------------------------------
-- ADD CONSTRAINT

ALTER TABLE users MODIFY (username NOT NULL);

ALTER TABLE users MODIFY (password NOT NULL);

--------------------------------------------------------------------------------------------------------------------------------
-- CREATE SEQUENCES

DROP SEQUENCE staff_seq;
DROP SEQUENCE request_seq;
DROP SEQUENCE dept_seq;

CREATE SEQUENCE staff_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE SEQUENCE request_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE SEQUENCE dept_seq
    START WITH 1
    INCREMENT BY 1;
