create table cliente(
  cod_cliente int primary KEY comment "Id do cliente",
  nome varchar(30) not null default 'ni' comment "nome",
  empresa varchar(30) not null default 'ni' comment "empresa",
  telefone varchar(255) not null default 'ni' comment "telefone"
);

create table tecnico(
  cod_tecnico int primary KEY comment "Id do tecnico",
  nome varchar(30) not null default 'ni' comment "nome"
);


create table ordemdeservico(
  cod_ordem int primary KEY comment "Id da ordem",
  data datetime,
  defeito varchar(255)  default 'ni' comment "defeito",
  equipamento varchar(255) not null default 'ni' comment "equipamento",
  cod_cliente int not null default 0 comment "Id do cliente",
  cod_tecnico int not null default 0 comment "Id do tecnico",
  cod_final int not null default 0 comment "Id codigo final"
);

create table finalizacao(
  cod_final int primary KEY comment "Codigo",
  valor_total numeric(10,2) not null default 0 comment "valor total",
  data datetime ,
  data_entrega datetime 
);

create table servico(
  cod_servico int primary KEY comment "Codigo do serviço",
  atividade varchar(255) not null default 'ni' comment "atividade"
);

create table relacao_3(
  cod_servico int not null default 0 comment "Id codigo servico",
  cod_ordem int not null default 0 comment "Id codigo ordem"
);

alter table relacao_3  
  add constraint fk_servico foreign key(cod_servico)
  references servico(cod_servico)
  on delete cascade 
  on update cascade
  

alter table relacao_3  
  add constraint fk_ordem foreign key(cod_ordem)
  references ordemdeservico(cod_ordem)
  on delete cascade 
  on update cascade
  

alter table ordemdeservico  
  add constraint fk_cod_cliente foreign key(cod_cliente)
  references cliente(cod_cliente)
  on delete cascade 
  on update cascade
  
  
alter table ordemdeservico  
  add constraint fk_cod_tecnico foreign key(cod_tecnico)
  references tecnico(cod_tecnico)
  on delete cascade 
  on update cascade
  
alter table ordemdeservico  
  add constraint fk_cod_final foreign key(cod_final)
  references finalizacao(cod_final)
  on delete cascade 
  on update cascade




  insert into cliente(cod_cliente, nome, empresa, telefone)
  values(2, 'alegria', 'kayron', '3289423'),
    (3, 'tristeza', 'kayron', '31111'),
    (4, 'happy', 'kayron', '2222222');

insert into tecnico(cod_tecnico, nome)
  values(2, 'teste'),
    (3, 'aass'),
    (4, 'frango');

insert into ordemdeservico (cod_ordem,data,defeito,equipamento,cod_cliente,cod_tecnico,cod_final)
  values(2, '2000/10/12', 'frangoassado', 'pcgamer', 2, 2, 2),
    (3,  '2000/10/12', 'frangoassadoaaaaaa', 'pcgameasdar', 2, 2, 2),
    (4,  '2000/10/12', 'frangoassado', 'pcgasdaamer', 2, 2, 2);

insert into servico (cod_servico, atividade)
  values(2, 'l2@l2.com'),
    (3, 'dasda'),
    (4, 'l4@lasdasdas4.com');

insert into finalizacao(cod_final, valor_total, data,data_entrega )
  values(2, 3, '1033/10/30','1330/10/30'),
    (3, 3333, '1033/10/30','1330/10/30'),
    (4, 44, '1033/10/30','1033/10/30');

select nome,telefone  from cliente;

update finalizacao f set data_entrega = '1899-12-31';

select * from finalizacao f ;
