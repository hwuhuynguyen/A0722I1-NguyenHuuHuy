use `demoproduct`;

create unique index idx_productCode
on data (productCode);

create index idx_NameAndPrice
on data (productName, `productPrice`);

explain select * from data where productCode = 'S18_2795';
explain select * from data where productName = '2002 Suzuki XREO';

drop index idx_productCode on data;
alter table data drop index idx_NameAndPrice;

create view Product_View as
select productCode, productName, productPrice from data;

select * from Product_View;

create or replace view Product_View as
select productCode, productName, productPrice, productAmount from data
where productPrice > 50;

select * from Product_View;

drop view Product_View;

delimiter //
create procedure getAllProducts()
begin
	select * from data;
end //
delimiter ;

call getAllProducts();

drop procedure if exists getAllProducts;

delimiter //
create procedure addNewProduct(
	IN productCode varchar(50),
    IN productName varchar(50),
    IN productPrice double,
    IN productAmount int,
    IN productDescription text
)
begin
	insert into data (productCode, productName, productPrice, productAmount, productDescription) 
    values (productCode, productName, productPrice, productAmount, productDescription);
end //
delimiter ;

call addNewProduct('S800_8125', 'Toyota C100', 1000, 10, 'A brand new car');

drop procedure if exists addNewProduct;

delimiter //
create procedure updateProduct(
	IN idProduct int,
    IN productCode varchar(50),
    IN productName varchar(50),
    IN productPrice double,
    IN productAmount int,
    IN productDescription text
)
begin
	update data
    set productCode = productCode, productName = productName, productPrice = productPrice, 
    productAmount = productAmount, productDescription = productDescription
    where id = idProduct; 
end //
delimiter ;

call updateProduct(107, 'S800_8125', 'Toyota A100', 1000, 0, 'Sold out');

drop procedure if exists updateProduct;

delimiter //
create procedure deleteProduct(
	IN idProduct int
)
begin
	delete from data
    where id = idProduct; 
end //
delimiter ;

call deleteProduct(107);

drop procedure if exists deleteProduct;