use `QuanLySinhVien`;

select * from Student 
where StudentName like 'h%';

select * from Class 
where month(StartDate) = 12;

select * from Subject 
where credit between 3 and 5;

update Student
set ClassID = 2
where StudentName = 'Hung';

select S.StudentID, S.StudentName, sj.SubName, M.Mark
from Student S
join Mark M on S.StudentID = M.StudentID
join Subject sj on M.SubID = sj.SubID
order by M.Mark desc, S.StudentName;