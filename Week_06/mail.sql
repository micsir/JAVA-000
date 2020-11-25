create table t_good
(
    good_id     int                                      not null
        primary key,
    good_code   varchar(45)                              not null comment '商品代码',
    good_name   varchar(45)                              not null comment '商品名称',
    good_desc   varchar(256) default ''                  null comment '商品描述',
    top         tinyint(1)   default 0                   null comment '是否置顶',
    sort        int          default 0                   null comment '商品排序',
    good_type   int          default 1                   null comment '商品类型（1.实体商品，2虚拟商品）',
    enable      tinyint(1)   default 1                   null comment '是否启用',
    create_time datetime     default current_timestamp() null comment '创建时间',
    update_time datetime                                 null comment '更新时间',
    good_price  decimal(10, 2)                           null comment '商品单价',
    good_unit   varchar(25)                              null comment '商品数量单位',
    constraint t_good_good_code_uindex
        unique (good_code)
)
    comment '商品';

create index t_good_good_name_index
    on t_good (good_name);

create table t_good_car
(
    id          int                                  not null
        primary key,
    user_id     int                                  not null comment '用户id',
    user_name   varchar(45)                          null comment '用户名',
    good_id     int                                  null comment '商品id',
    create_time datetime default current_timestamp() null comment '创建时间',
    update_time datetime                             null comment '更新时间'
)
    comment '下单用户购物车';

create table t_good_stock
(
    good_id     int               not null comment '商品代码'
        primary key,
    stock_num   bigint default -1 null comment '商品库存(-1表示无限库存)',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '更新时间'
)
    comment '商品库存';

create table t_order
(
    order_id      int auto_increment
        primary key,
    order_code    varchar(45)                          null comment '订单号',
    create_time   datetime default current_timestamp() null comment '下单时间',
    update_time   datetime default current_timestamp() null comment '更新时间',
    order_status  tinyint                              null comment '订单状态（1待支付，2支付完成，3支付失败，4发货中，5已完成）',
    pay_user_id   int                                  not null comment '下单用户',
    pay_user_name varchar(45)                          null comment '下单用户名',
    constraint t_order_order_code_uindex
        unique (order_code)
);

create index t_order_order_status_index
    on t_order (order_status);

create index t_order_pay_user_id_index
    on t_order (pay_user_id);

create table t_order_good
(
    id           int                                      not null
        primary key,
    good_id      int                                      null comment '商品id',
    order_id     int                                      null comment '订单号',
    good_code    varchar(45)                              not null comment '商品代码',
    good_name    varchar(45)                              not null comment '商品名称',
    good_desc    varchar(256) default ''                  null comment '商品描述',
    good_type    int          default 1                   null comment '商品类型（1.实体商品，2虚拟商品）',
    create_time  datetime     default current_timestamp() null comment '创建时间',
    update_time  datetime     default current_timestamp() null comment '更新时间',
    purchase_num int                                      not null comment '购买数量'
)
    comment '订单商品条目';

create index t_order_good_good_code_index
    on t_order_good (good_code);

create index t_order_good_order_id_index
    on t_order_good (order_id);

create table t_user
(
    user_id         int                                  not null
        primary key,
    user_name       varchar(45)                          null comment '用户名',
    nick_name       varchar(45)                          null comment '昵称',
    pwd             varchar(45)                          null comment '密码',
    last_login_time datetime                             null comment '上次登录时间',
    create_time     datetime default current_timestamp() null comment '创建时间',
    update_time     datetime                             null comment '更新时间',
    enable          tinyint  default 1                   null comment '是否启用',
    constraint t_user_pk
        unique (user_name)
)
    comment '下单用户';

