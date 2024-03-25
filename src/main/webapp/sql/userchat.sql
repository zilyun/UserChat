DROP TABLE CHAT_USER;

CREATE TABLE CHAT_USER(
    userID varchar2(20) primary key,
    userPassword varchar2(20),
    userName varchar2(20),
    userAge number(3),
    userGender varchar2(20),
    userEmail varchar(50),
    userProfile varchar(50)
);

CREATE TABLE CHAT (
	chatID	number(8) primary key,
	fromID  varchar2(20),
	toID	varchar2(20),
	chatContent varchar2(100),
	chatTime date
);


