use login_schema;

desc users;

select * from users;

insert into users(username,password) VALUES(
	"luka",
    "paroli"
);

delete from users where username = "luka";

ALTER TABLE users

ADD COLUMN userBio varchar(720) DEFAULT 'empty';
