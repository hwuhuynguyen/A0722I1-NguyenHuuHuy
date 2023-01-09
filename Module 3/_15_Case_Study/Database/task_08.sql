use furama;

-- Task 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.

-- Option 1:--

select distinct kh.ho_ten 
from khach_hang kh;

-- Option 2:--

select kh.ho_ten 
from khach_hang kh 
group by ho_ten;

-- Option 3:--

select kh.ho_ten 
from khach_hang kh 
union
select kh.ho_ten 
from khach_hang kh 