SELECT * FROM dept;
SELECT * FROM staff;
SELECT * FROM request_info;
SELECT * FROM request_status;
SELECT * FROM fund_info;

SELECT request_info.staff_id, request_info.request_id, request_status.status
    FROM request_info
    INNER JOIN request_status
    ON request_info.request_id = request_status.request_id;
    
SELECT * FROM request_status WHERE status LIKE 'P%' AND request_id = 2;

SELECT staff_id, request_info.request_id, status
    FROM request_info
    INNER JOIN request_status
    ON request_info.request_id = request_status.request_id
    WHERE status LIKE 'P%' AND staff_id = 4;
    
SELECT staff_id, request_info.request_id, status, date_requestor, addtlinfo_requestor,
    date_supervisor, addtlinfo_supervisor, date_dept, addtlinfo_dept, date_benco, addtlinfo_benco
    FROM request_info
    INNER JOIN request_status
    ON request_info.request_id = request_status.request_id
    WHERE staff_id = 4;

SELECT request_id, staff.staff_id, supervisor_id, dept_id
    FROM request_info
    INNER JOIN staff
    ON request_info.staff_id = staff.staff_id 
    WHERE supervisor_id = 6 or dept_id = 6;
    
SELECT request_id, staff.staff_id, supervisor_id, dept_id
    FROM request_info
    INNER JOIN staff
    ON request_info.staff_id = staff.staff_id;



