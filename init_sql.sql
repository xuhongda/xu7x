use mybatis_springboot;

drop table xu7x_content;
drop table xu7x_index;

create table if not exists mybatis_springboot.xu7x_content
(
    id int not null
        primary key,
    index_id int not null,
    content varchar(1000) not null
)
    comment '文章详情';


create table if not exists mybatis_springboot.xu7x_index
(
    id int not null,
    name varchar(25) not null comment '文章名',
    create_time date not null comment '创建时间',
    last_update_time date not null comment '最后更新时间',
    author varchar(5) not null comment '作者',
    constraint xu7x_index_id_uindex
        unique (id)
)
    comment '文章导航';

alter table mybatis_springboot.xu7x_index
    add primary key (id);