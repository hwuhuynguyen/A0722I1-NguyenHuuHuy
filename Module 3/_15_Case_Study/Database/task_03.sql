use furama;

-- Task 3 : Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và
-- có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select *
from khach_hang
where (year(CURRENT_TIMESTAMP) - YEAR(ngay_sinh) BETWEEN 18 AND 50) and (dia_chi like '%Đà Nẵng' or dia_chi like '%Quảng Trị');