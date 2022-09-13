use `QuanLySinhVien`;

select * from Student;

select * from Student where Status = true;

select * from Subject where Credit < 10;

select s.StudentID, s.StudentName, s.Address, c.ClassName from Student s
join Class c on s.ClassID = c.ClassID
where ClassName = 'A1';

select S.StudentID, S.StudentName, S.Address, M.Mark, sj.SubName from Student S
join Mark M on S.StudentID = M.StudentID 
join Subject sj on M.SubID = sj.SubID
where sj.SubName = 'CF';