--Task – Select the employeeId, last name, and email for records in the Employee table where last name is King.
select "EmployeeId", "LastName", "Email" from "Employee" where "LastName" = 'King';

--Task – Select the city and state for the records in the Employee table where first name is Andrew and REPORTSTO is NULL.
select "City", "State" from "Employee" where "FirstName" = 'Andrew' and "ReportsTo" is null;

--Task – Select all records from the Album table where the composer is AC/DC.
select * from "Album" where "ArtistId" = (select "ArtistId" from "Artist" where "Name" = 'AC/DC');

--Task – Select all albums in Album table and sort result set in descending order by title.
select * from "Album" order by "Title" desc;

--Task – Select first name from Customer and sort result set in ascending order by city
select "FirstName"  from "Customer" order by "City" asc;

--Task – Select all invoices with a billing address like “T%”
select "BillingAddress" from "Invoice" where "BillingAddress" like 'T%';

--Task – Select all invoices that have a total between 15 and 50.
select * from "Invoice" where "Total" between '15' and '50';

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004.
select * from "Employee" where "HireDate" between '2003-06-01' and '2004-03-01';

--Task – Insert two complete new records into Genre table.
insert into "Genre" values (26, 'Kpop'), (27, 'Bachata');

--Task – Insert two complete new records into Employee table.
insert into "Employee" values (16, 'Santana', 'Javier','CEO', null, null, null, null, null, null, null, null, null, null, null), (17, 'Mario', 'Mario','Mail Clerk', null, null, null, null, null, null, null, null, null, null, null);

--Task – Insert two complete new records into Customer table.
insert into "Customer" values (60, 'Luigi', 'Luigi', null, null, null, null, null, null, null, null, 'luigi@mail.com', null), (61, 'Link', 'Link', null, null, null, null, null, null, null, null, 'link@mail.com', null);

--Task – Update Aaron Mitchell in Customer table to Robert Walter.
update "Customer" set "FirstName" = 'Robert', "LastName" = 'Walter' where "FirstName" = 'Aaron' and "LastName" = 'Mitchell'; 

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	.
update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';

--Task – Delete a record in Customer table where the name is Robert Walter.
alter table "InvoiceLine" drop constraint if exists "FK_InvoiceLineInvoiceId";
alter table "Invoice" drop constraint if exists "FK_InvoiceCustomerId";
delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';
alter table "InvoiceLine" add constraint "FK_InvoiceLineInvoiceId" foreign key ("InvoiceId") references "Invoice" ("InvoiceId") on delete cascade;
alter table "Invoice" add constraint "FK_InvoiceCustomerId" foreign key ("CustomerId") references "Customer" ("CustomerId") on delete cascade;

--Task – Create a query that returns the current time.
select now();

--Task – Create a query that returns the length of name in MEDIATYPE table
select "Name", length("Name") from "MediaType";

--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION average ()
    RETURNS NUMERIC AS $average_total$
        DECLARE average_total NUMERIC;
    BEGIN
    SELECT AVG("Total") Total INTO average_total FROM "Invoice";
    RETURN average_total;
END;
$average_total$ LANGUAGE plpgsql;

select average();

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION expensive ()
    RETURNS numeric AS $most_expensive$
        DECLARE most_expensive numeric;
    BEGIN
    SELECT Max("UnitPrice") UnitPrice INTO most_expensive FROM "Track";
    RETURN most_expensive;
END;
$most_expensive$ LANGUAGE plpgsql;

select expensive();

--Task – Create a function that returns the average price of invoiceline items in the invoiceline table.
CREATE OR REPLACE FUNCTION averagePrice ()
    RETURNS numeric AS $average_price$
        DECLARE average_Price numeric;
    BEGIN
    SELECT AVG("UnitPrice") UnitPrice INTO average_Price FROM "InvoiceLine";
    RETURN average_Price;
END;
$average_price$ LANGUAGE plpgsql;

select averagePrice();

--Task – Create a function that returns all employees who are born after 1968.
create or replace function old_people() returns table(f1 int4, f2 varchar, 
f3 varchar, f4 varchar, f5 int4, f6 timestamp, f7 timestamp, f8 varchar, 
f9 varchar, f10 varchar, f11 varchar, f12 varchar, f13 varchar, f14 varchar, f15 varchar)
    as $$ select * from "Employee" where "BirthDate" > '1968-12-31'; $$
    language sql;

select old_people();
   
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table to set the phone number to 867-5309.
CREATE OR REPLACE FUNCTION trigger_function() RETURNS trigger as $trigger_function$
   BEGIN
    update "Employee" 
    set "Phone" = '867-5309'
    where "EmployeeId" = new."EmployeeId";
    RETURN NEW;
  END;
$trigger_function$
LANGUAGE plpgsql;

create trigger employee_trigger
	after insert 
	on "Employee"
	for each row 
	execute procedure trigger_function();

--Task – Create a before trigger on the customer table that fires before a row is inserted from the table to set the company to Revature.
CREATE OR REPLACE FUNCTION before_trigger_function() RETURNS trigger as $before_trigger_function$
   BEGIN
    update "Customer" 
    set "Company" = 'Revature'
    where "CustomerId" = new."CustomerId";
    RETURN NEW;
  END;
$before_trigger_function$
LANGUAGE plpgsql;

create trigger employee_trigger
	before insert 
	on "Customer"
	for each row 
	execute procedure before_trigger_function();	
	
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select "Customer"."FirstName" || "Customer"."LastName" as "Name", "Invoice"."InvoiceId"
from "Customer" inner join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId"; 

--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select "Customer"."CustomerId", "Customer"."FirstName", "Customer"."LastName", "Invoice"."InvoiceId", "Invoice"."Total"
from "Customer" left outer join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId"; 

--Task – Create a right join that joins album and artist specifying artist name and title.
select "Artist"."Name", "Album"."Title" from "Artist" right outer join "Album" on "Album"."ArtistId" = "Artist"."ArtistId";

--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
select * from "Album" cross join "Artist" order by "Artist"."Name" asc;

--Task – Perform a self-join on the employee table, joining on the reportsto column.
select "I"."EmployeeId", "I"."LastName" || "I"."FirstName" AS "Name", "J"."ReportsTo"
from "Employee" "I", "Employee" "J"
where "I"."EmployeeId" = "J"."EmployeeId";

--Task - Create a UNION query for finding the unique records of last name, first name, and phone number for all customers and employees.
select "LastName", "FirstName", "Phone" from "Customer" union distinct select "LastName", "FirstName", "Phone" from "Employee";

--Task - Create an EXCEPT ALL query for finding the all records of the city, state, and postal codes for all customers and all records of employees that have a different  city, state, and postal codes of any customer.
(select distinct "City", "State", "PostalCode" from "Customer" except all select distinct "City", "State", "PostalCode" from "Employee");    