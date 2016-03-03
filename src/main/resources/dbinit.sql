create table transaction(
	id int not null auto_increment,
	cid int not null,
	tdate datetime not null,
	primary key (id)		
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

create table item(
	id int not null auto_increment,
	name varchar(30) not null,
	primary key (id)		
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

create table trans_item(
	tid int not null,
	iid int not null,
	primary key (tid,iid),
	foreign key (tid) references transaction(id) on delete cascade on update cascade,
	foreign key (iid) references item(id) on delete cascade on update cascade
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;