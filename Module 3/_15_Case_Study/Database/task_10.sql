use furama;

-- Task 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
-- (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).

select 
	hd.ma_hop_dong, 
    hd.ngay_lam_hop_dong, 
    hd.ngay_ket_thuc, 
    hd.tien_dat_coc,
    ifnull(sum(hdct.so_luong), 0) as so_luong_dich_vu_di_kem
from hop_dong hd
	left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
group by hd.ma_hop_dong
order by hd.ma_hop_dong;