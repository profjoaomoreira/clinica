create database projetoclinica;

use projetoclinica;

create table medicos(
cod_medico serial not null,
nome_medico character varying(50) not null,
especialidade_medico character varying(50) not null,
crm_medico integer not null,
constraint med_cod primary key (cod_medico) 
)

with (OIDS-FALSE);
alter table medicos OWNER TO postgress;
