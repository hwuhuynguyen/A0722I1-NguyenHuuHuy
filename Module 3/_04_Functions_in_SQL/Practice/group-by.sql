use `QuanLySinhVien`;

select Address, count(StudentID) as 'So luong hoc sinh' from Student
group by Address;

select S.StudentID, S.StudentName, avg(Mark) as 'Diem trung binh' from Student S
inner join Mark M on S.StudentID = M.StudentID
group by S.StudentID;

select S.StudentID, S.StudentName, avg(Mark) as 'Diem trung binh' from Student S
inner join Mark M on S.StudentID = M.StudentID
group by S.StudentID
having avg(Mark) > 15;

select S.StudentID, S.StudentName, avg(Mark) as 'Diem trung binh' from Student S
inner join Mark M on S.StudentID = M.StudentID
group by S.StudentID
having avg(Mark) >= all (select avg(Mark) from Mark group by StudentID);