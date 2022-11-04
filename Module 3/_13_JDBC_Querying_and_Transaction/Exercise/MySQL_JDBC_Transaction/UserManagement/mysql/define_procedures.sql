use `demo`;
delimiter ##
create procedure view_all_users()
	begin
		select * from users;
	end ## 
delimiter ;

call view_all_users();


delimiter ##
create procedure update_user_store_procedure(
	IN user_id int,
    IN user_name varchar(50),
	IN user_email varchar(50),
	IN user_country varchar(50)
)
	begin
		update users
		set name = user_name, email = user_email, country = user_country
		where id = user_id;
	end ##
delimiter ;

delimiter ##
create procedure delete_user_store_procedure(
	IN user_id int
)
	begin
		delete from users 
        where id = user_id;
	end ##
delimiter ;