use `QuanLySinhVien`;

select SubID, SubName, Credit from Subject
where credit = (select max(credit) from Subject);

select S.SubID, S.SubName, S.Credit, M.Mark from Subject S
inner join Mark M on S.SubID = M.SubID
where M.Mark = (select max(Mark) from Mark);

select S.StudentID, S.StudentName, S.Address, S.Phone, S.Status, avg(Mark) as 'Average score' from Student S
inner join Mark M on S.StudentID = M.StudentID
group by S.StudentID
order by avg(Mark) desc;