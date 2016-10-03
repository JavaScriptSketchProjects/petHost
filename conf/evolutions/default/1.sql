# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table calificacionentity (
  id                            bigint not null,
  name                          varchar(255),
  numero                        integer,
  host_id                       bigint,
  constraint pk_calificacionentity primary key (id)
);
create sequence Calificacion;

create table comentarioentity (
  id                            bigint not null,
  calificacion_id               bigint,
  comentario                    varchar(255),
  constraint pk_comentarioentity primary key (id)
);
create sequence Comentario;

create table espacioentity (
  id                            bigint not null,
  name                          varchar(255),
  host_id                       bigint,
  capacidad                     integer,
  precio                        float,
  calendario                    timestamp,
  constraint pk_espacioentity primary key (id)
);
create sequence Espacio;

create table hostentity (
  id                            bigint not null,
  name                          varchar(255),
  pethost_id                    bigint,
  lugar_id                      bigint,
  email                         varchar(255),
  nick_name                     varchar(255),
  password                      varchar(255),
  num_contacto                  bigint,
  constraint uq_hostentity_lugar_id unique (lugar_id),
  constraint pk_hostentity primary key (id)
);
create sequence Host;

create table lugarentity (
  id                            bigint not null,
  name                          varchar(255),
  host_id                       bigint,
  user_id                       bigint,
  latitud                       float,
  longitud                      float,
  constraint uq_lugarentity_host_id unique (host_id),
  constraint uq_lugarentity_user_id unique (user_id),
  constraint pk_lugarentity primary key (id)
);
create sequence Lugar;

create table pethostentity (
  id                            bigint not null,
  name                          varchar(255),
  admin_user                    varchar(255),
  password                      varchar(255),
  constraint pk_pethostentity primary key (id)
);
create sequence PetHost;

create table reservaentity (
  id                            bigint not null,
  name                          varchar(255),
  usuario_id                    bigint,
  espacio_id                    bigint,
  precio                        float,
  num_mascotas                  integer,
  fecha1                        timestamp,
  fecha2                        timestamp,
  estado                        varchar(255),
  constraint pk_reservaentity primary key (id)
);
create sequence Reserva;

create table usuarioentity (
  id                            bigint not null,
  name                          varchar(255),
  lugar_id                      bigint,
  pethost_id                    bigint,
  email                         varchar(255),
  nick_name                     varchar(255),
  password                      varchar(255),
  num_contacto                  bigint,
  constraint uq_usuarioentity_lugar_id unique (lugar_id),
  constraint pk_usuarioentity primary key (id)
);
create sequence Usuario;

alter table calificacionentity add constraint fk_calificacionentity_host_id foreign key (host_id) references hostentity (id) on delete restrict on update restrict;
create index ix_calificacionentity_host_id on calificacionentity (host_id);

alter table comentarioentity add constraint fk_comentarioentity_calificacion_id foreign key (calificacion_id) references calificacionentity (id) on delete restrict on update restrict;
create index ix_comentarioentity_calificacion_id on comentarioentity (calificacion_id);

alter table espacioentity add constraint fk_espacioentity_host_id foreign key (host_id) references hostentity (id) on delete restrict on update restrict;
create index ix_espacioentity_host_id on espacioentity (host_id);

alter table hostentity add constraint fk_hostentity_pethost_id foreign key (pethost_id) references pethostentity (id) on delete restrict on update restrict;
create index ix_hostentity_pethost_id on hostentity (pethost_id);

alter table hostentity add constraint fk_hostentity_lugar_id foreign key (lugar_id) references lugarentity (id) on delete restrict on update restrict;

alter table lugarentity add constraint fk_lugarentity_host_id foreign key (host_id) references hostentity (id) on delete restrict on update restrict;

alter table lugarentity add constraint fk_lugarentity_user_id foreign key (user_id) references usuarioentity (id) on delete restrict on update restrict;

alter table reservaentity add constraint fk_reservaentity_usuario_id foreign key (usuario_id) references usuarioentity (id) on delete restrict on update restrict;
create index ix_reservaentity_usuario_id on reservaentity (usuario_id);

alter table reservaentity add constraint fk_reservaentity_espacio_id foreign key (espacio_id) references espacioentity (id) on delete restrict on update restrict;
create index ix_reservaentity_espacio_id on reservaentity (espacio_id);

alter table usuarioentity add constraint fk_usuarioentity_lugar_id foreign key (lugar_id) references lugarentity (id) on delete restrict on update restrict;

alter table usuarioentity add constraint fk_usuarioentity_pethost_id foreign key (pethost_id) references pethostentity (id) on delete restrict on update restrict;
create index ix_usuarioentity_pethost_id on usuarioentity (pethost_id);


# --- !Downs

alter table if exists calificacionentity drop constraint if exists fk_calificacionentity_host_id;
drop index if exists ix_calificacionentity_host_id;

alter table if exists comentarioentity drop constraint if exists fk_comentarioentity_calificacion_id;
drop index if exists ix_comentarioentity_calificacion_id;

alter table if exists espacioentity drop constraint if exists fk_espacioentity_host_id;
drop index if exists ix_espacioentity_host_id;

alter table if exists hostentity drop constraint if exists fk_hostentity_pethost_id;
drop index if exists ix_hostentity_pethost_id;

alter table if exists hostentity drop constraint if exists fk_hostentity_lugar_id;

alter table if exists lugarentity drop constraint if exists fk_lugarentity_host_id;

alter table if exists lugarentity drop constraint if exists fk_lugarentity_user_id;

alter table if exists reservaentity drop constraint if exists fk_reservaentity_usuario_id;
drop index if exists ix_reservaentity_usuario_id;

alter table if exists reservaentity drop constraint if exists fk_reservaentity_espacio_id;
drop index if exists ix_reservaentity_espacio_id;

alter table if exists usuarioentity drop constraint if exists fk_usuarioentity_lugar_id;

alter table if exists usuarioentity drop constraint if exists fk_usuarioentity_pethost_id;
drop index if exists ix_usuarioentity_pethost_id;

drop table if exists calificacionentity cascade;
drop sequence if exists Calificacion;

drop table if exists comentarioentity cascade;
drop sequence if exists Comentario;

drop table if exists espacioentity cascade;
drop sequence if exists Espacio;

drop table if exists hostentity cascade;
drop sequence if exists Host;

drop table if exists lugarentity cascade;
drop sequence if exists Lugar;

drop table if exists pethostentity cascade;
drop sequence if exists PetHost;

drop table if exists reservaentity cascade;
drop sequence if exists Reserva;

drop table if exists usuarioentity cascade;
drop sequence if exists Usuario;

