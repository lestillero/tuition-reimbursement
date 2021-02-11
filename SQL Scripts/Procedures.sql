-- PL/SQL

commit;
rollback;

--------------------------------------------------------------------------------------------------------------------------------
-- create_dept

CREATE OR REPLACE PROCEDURE create_dept(dept_name VARCHAR2) IS
BEGIN

INSERT INTO dept VALUES (dept_seq.nextval, dept_name, null);

END;
/


--department names
CALL create_dept('Executive');
CALL create_dept('Alum Affairs');
CALL create_dept('Student Services');
CALL create_dept('Academics');
CALL create_dept('Athletics');
CALL create_dept('Building Mgmt');
CALL create_dept('Human Resources');

--really these are subdepartments
CALL create_dept('Guidance');
CALL create_dept('Custodian');
CALL create_dept('Cafeteria');
CALL create_dept('English');
CALL create_dept('Math');
CALL create_dept('Science');
CALL create_dept('Social Studies');
CALL create_dept('Related Arts');
CALL create_dept('Vocation');
CALL create_dept('Foreign Language');
CALL create_dept('Physical Education');
CALL create_dept('Sports');
CALL create_dept('Honors Program');
CALL create_dept('Student Council');

SELECT * FROM dept;

UPDATE dept SET dept_name = 'Human Resources' WHERE dept_id = 7;
UPDATE dept SET dept_name = 'Student Services' WHERE dept_id = 3;

--------------------------------------------------------------------------------------------------------------------------------
-- addto_staff

CREATE OR REPLACE PROCEDURE addto_staff(first_name VARCHAR2, last_name VARCHAR2, supervisor_id NUMBER, dept_id NUMBER) IS
BEGIN

INSERT INTO staff VALUES (staff_seq.nextval, first_name, last_name, supervisor_id, dept_id, 1000);

END;
/


--initial heads of departments
CALL addto_staff('Sue', 'Shi', 1, 1);
CALL addto_staff('Pete', 'Suh', 1, 2);
CALL addto_staff('Cal', 'Zone', 1, 3);
CALL addto_staff('Barbie', 'Kyu', 1, 4);
CALL addto_staff('Tom', 'Mato', 1, 5);
CALL addto_staff('Suila', 'Tay', 1, 6);
CALL addto_staff('Chi', 'Kenudelsoop', 1, 7);

SELECT * FROM staff WHERE dept_id = 3;
SELECT last_name FROM staff;
SELECT * FROM staff;

--more employees
CALL addto_staff('Saw', 'Sedge', 3, 3);
CALL addto_staff('Jayleede', 'O''knut', 4, 4);
CALL addto_staff('Peach', 'Cobbler', 4, 4);
CALL addto_staff('Gordon', 'Zola', 4, 4);
CALL addto_staff('Russell', 'Sprout', 4, 4);
CALL addto_staff('Chris', 'Peabayekon', 4, 4);
CALL addto_staff('Phyllida', 'Cod', 4, 4);
CALL addto_staff('Frenchie', 'Fry', 5, 5);
CALL addto_staff('Sal', 'Ted-Carmel', 5, 5);
CALL addto_staff('Dan', 'Caruse', 6, 6);
CALL addto_staff('Cal', 'Amari', 6, 6);
CALL addto_staff('Blue', 'Berriscone', 7,7);

--even more employees
CALL addto_staff('Bea', 'Fa', 8, 3);
CALL addto_staff('May', 'Pillsirup', 8, 3);
CALL addto_staff('Sal', 'Odd', 8, 3);

CALL addto_staff('Amber', 'Ohzha', 17, 6);
CALL addto_staff('Ginger', 'Aille', 23, 6);

UPDATE staff SET supervisor_id = 3 WHERE staff_id = 22;

CALL addto_staff('Basil', 'Pestho', 9, 4);
CALL addto_staff('Cho', 'Colette', 9, 4);
CALL addto_staff('Jasmine', 'Ti', 9, 4);

CALL addto_staff('Madeleine', 'Kuki', 10, 4);
CALL addto_staff('Brian', 'Flaiks', 10, 4);

CALL addto_staff('Fig', 'Newton', 11, 4);
CALL addto_staff('Candy', 'Kane', 11, 4);
CALL addto_staff('Darla', 'Puvdazy', 12, 4);
CALL addto_staff('Star', 'Anise', 12, 4);
CALL addto_staff('Dil', 'Pickles', 13, 4);
CALL addto_staff('Cinna', 'Mohn', 13, 4);
CALL addto_staff('Pepper', 'Oni', 14, 4);
CALL addto_staff('Reese', 'Ezkops', 14, 4);
CALL addto_staff('Hazel', 'Notkawvi', 16, 5);
CALL addto_staff('Reuben', 'Zanditch', 16, 5);
CALL addto_staff('Lotus', 'Moonkaek', 16, 5);

--------------------------------------------------------------------------------------------------------------------------------
-- create_request

CREATE OR REPLACE PROCEDURE create_request(staff_id NUMBER, date_requestor DATE, date_start DATE, date_end DATE,
    location VARCHAR2, event_type VARCHAR2, description VARCHAR2, grading_format VARCHAR2, amt_requested NUMBER) IS
BEGIN

INSERT INTO request_info VALUES (request_seq.nextval, staff_id, date_start, date_end, location, event_type, description, grading_format,
    null, null);

INSERT INTO request_status VALUES (request_seq.currval, 'Pending supervisor', date_requestor, null, null, null, null,
    null, null, null);

INSERT INTO fund_info VALUES (request_seq.currval, amt_requested, 0, 0);

END;
/


-- test calls

CALL create_request(4, '29JAN2021', '08MAR2021', '08MAR2021', 'Online', 'Seminar', 'PowerSchool workshop', 'Cert of completion', 60.00);
CALL create_request(4, '01FEB2021', '18FEB2021', '22APR2021', 'Online', 'Other', 'Addressing Students'' Different Abilities series', 'Presentation', 100.00);
CALL create_request(27, '03FEB2021', '27FEB2021', '27FEB2021', 'Online', 'Certification prep class', 'MTEL English prep class', 'Cert of completion', 65.00);
CALL create_request(11, '03FEB2021', '17FEB2021', '17FEB2021', 'Online', 'Technical training', 'Teaching Virtual Lab and Fieldwork Online', 'Presentation', 140.00);
CALL create_request(37, '03FEB2021', '10MAY2021', '26AUG2021', 'Online', 'University course', 'Curriculum in Music Education: Vision and Design', 'Letter grade', 1000.00);
CALL create_request(24, '03FEB2021', '03MAR2021', '04MAR2021', 'Online', 'Technical training', 'Food Service Equipment Safety Training', 'Cert of completion', 45.00);

SELECT * FROM request_info;
SELECT * FROM request_status;
SELECT * FROM fund_info;

DELETE FROM request_status WHERE request_id = 2;

--------------------------------------------------------------------------------------------------------------------------------
-- play!

