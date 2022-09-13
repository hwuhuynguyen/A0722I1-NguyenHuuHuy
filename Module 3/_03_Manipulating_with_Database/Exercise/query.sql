use `QuanLyBanHang`;

insert into Customer values (1, 'Minh Quan', 10),
							(2, 'Ngoc Oanh', 20),
                            (3, 'Hong Ha', 50);

insert into `Order` values (1, 1, '2006-03-21', null),
						   (2, 2, '2006-03-21', null),
                           (3, 1, '2006-03-16', null);

insert into Product (pName, pPrice)
values ('May giat', 3),
	   ('Tu lanh', 5),
       ('Dieu hoa', 7),
       ('Quat', 1),
       ('Bep dien', 2);
       
insert into OrderDetail values (1, 1, 3),
							   (1, 3, 7),
                               (1, 4, 2),
                               (2, 1, 1),
                               (3, 1, 8),
                               (2, 5, 4),
                               (2, 3, 3);
                               
select O.oID, O.cID, oDate, (P.pPrice*OD.odQTY) as oPrice
from `Order` O
join OrderDetail OD on O.oID = OD.oID 
join Product P on OD.pID = P.pID;

select distinct C.cID, C.cName, C.cAge 
from Customer C
join `Order` O on C.cID = O.cID;

select distinct P.pID, P.pName, P.pPrice
from Product P
join OrderDetail OD on P.pID = OD.pID;

select  C.cID, C.cName, C.cAge 
from Customer C 
where C.cID not in (select distinct c1.cID from Customer c1 join `Order` o1 on c1.cID = o1.cID);

select O.oID, O.cID, O.oDate, sum(OD.odQTY * P.pPrice) as TotalPrice from `Order` O
join OrderDetail OD on O.oID = OD.oID
join Product P on OD.pID = P.pID
group by O.oID;
