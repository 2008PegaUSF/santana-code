--CREATE TABLES
--****************************************************
create table "User" (
"UserId" int primary KEY,
"Username" varchar unique not NULL,
"Password" varchar not NULL
"UserType" varchar,
"JointId" int
);

create table "Employee" (
"EmployeeId" int primary key,
"UserId" int not null, 
"EmployeeType" varchar,

foreign key ("UserId") references "User" ("UserId")
);

create table "Customer" (
"CustomerId" int primary key,
"UserId" int not null,
"LastName" varchar,
"FirstName" varchar,
"Address" varchar(150),
"Balance" numeric,
"CustomerType" varchar,
"City" varchar,
"State" varchar,
"ZipCode" varchar,
"Phone" varchar,
"AccountId" int,
"JointId" int,

foreign key ("UserId") references "User" ("UserId")
);

create table "Accounts" (
"AccountId" int primary key,
"balance" int not null,
"TransactionType" varchar,

foreign key ("UserId") references "User" ("UserId")
);

create table "Transactions" (
"TransactionId" int primary key,
"UserId" int not null,
"TransactionType" varchar,
"EntryDate" date,

foreign key ("UserId") references "User" ("UserId")
);

--****************************************************
--INSERT DATA
--****************************************************
insert into "User" values (1, 'admin', 'password');
insert into "User" values (2, 'emp', 'password');
insert into "User" values (3, 'mario', 'its-a-me');
insert into "User" values (4, 'luigi', 'imma-gonna-win');
insert into "User" values (5, 'link', 'hyaa');
insert into "User" values (6, 'kc123', '12345678');
insert into "User" values (7, 'javy', 'password');
insert into "User" values (8, 'peach', 'help');

insert into "Employee" values(1,1,'Admin');
insert into "Employee" values(2,2,'Employee');

insert into "Customer" values(1,3,'Mario', 'Mario', '123 Main St', 5000.00, 'Single');
insert into "Customer" values(2,4,'Luigi', 'Luigi', '123 Main St', 3000.00, 'Single');
insert into "Customer" values(3,5,'Link', 'Link', '456 Main St', 15000.00, 'Single');

insert into "Customer" values(1,6, null, 'Kasey', '145 Main St', 45000000.00, 'Joint');
insert into "Customer" values(1,7, null, 'Javy', '123 Main St', 500.00, 'Joint');
--****************************************************
--CREATE SEQUENCES, FUNCTIONS, AND TRIGGERS
--****************************************************

create sequence user_seq
start 20;

CREATE OR REPLACE FUNCTION public.user_insert()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
begin
	if(TG_OP = 'INSERT') then
	new."UserId" = (select nextval('user_seq'));
	end if;
	return new;
end;
$function$
;


create trigger user_insert before
insert
    on
    public."User" for each row execute function user_insert();

CREATE SEQUENCE customer_seq
START 10;
   
CREATE OR REPLACE FUNCTION public.customer_insert()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
begin
	if(TG_OP = 'INSERT') then
	new."CustomerId" = (select nextval('customer_seq'));
	end if;
	return new;
end;
$function$
;
   
create trigger customer_insert before
insert
    on
    public."Customer" for each row execute function customer_insert();
   
create sequence transaction_sequence
start 1;

create or replace function transaction_insert()
returns trigger as $$
begin
	if(TG_OP = 'INSERT') then
	new."TransactionId" = (select nextval('transaction_sequence'));
	end if;
	return new;
end;
$$ language plpgsql;
--Before trigger
create trigger transaction_insert
before insert on "Transactions"
for each row
execute function transaction_insert();

--****************************************************