delimiter //
create procedure getCustomerByID(
	IN id int
)
begin
	select * from customers where customerNumber = id;
end //
delimiter ;

call getCustomerByID(175);

delimiter //
create procedure getCustomersCountByCity(
	IN input_city varchar(50),
	OUT count int
)
begin
	select count(customerNumber) into count from customers where city = input_city;
end //
delimiter ;

call getCustomersCountByCity("Bridgewater", @total);
select @total;

delimiter //
create procedure setCounter(
	INOUT counter int,
    IN inc int
)
begin
	set counter = counter + inc;
end //
delimiter ;

set @counter = 0;
call setCounter(@counter, 2);
call setCounter(@counter, 3);
select @counter;