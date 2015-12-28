use `stockdb`;
alter table `consumable` drop column `consumable`.`quantity_available`;
drop table `cabinet_contains`;

create index `printer_publicid` on `printer`(`publicid`);
create index `consumable_publicid` on `consumable`(`publicid`);
create index `cabinet_publicid` on `cabinet`(`publicid`);

create table `quantity` (
	`id` bigint(20) not null auto_increment,
    `publicid` varchar(255) default null,
    `amount` int,
    `consumable_id` bigint(20) not null,
    primary key (`id`),
    constraint `FK_quantity_consumable` foreign key (`consumable_id`) references `consumable`(`id`)
) engine=InnoDB auto_increment = 3 charset=utf8;
create index `quantity_publicid` on `quantity`(`publicid`);

create table `cabinet_quantities` (
	`cabinet_id` bigint(20) not null,
    `quantities_id` bigint(20) not null,
    constraint `FK_cabinet_quantities_cabinet_id` foreign key (`cabinet_id`) references `cabinet`(`id`),
    constraint `FK_cabinet_quantities_quantities_id` foreign key (`quantities_id`) references `quantity`(`id`)
)engine=InnoDB default charset=utf8;
create index `FK_cabinet_quantities_cabinet_id` on `cabinet_quantities`(`cabinet_id`);
create index `FK_cabinet_quantities_quantities_id` on `cabinet_quantities`(`quantities_id`);

