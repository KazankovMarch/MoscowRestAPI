-- Table: public.area

-- DROP TABLE public.area;

CREATE TABLE public.area
(
    name text COLLATE pg_catalog."default",
    id integer NOT NULL DEFAULT nextval('area_id_seq'::regclass),
    CONSTRAINT area_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.area
    OWNER to postgres;

-- Table: public.house

-- DROP TABLE public.house;

CREATE TABLE public.house
(
    address text COLLATE pg_catalog."default" NOT NULL,
    street_prefix text COLLATE pg_catalog."default",
    street_name text COLLATE pg_catalog."default",
    building text COLLATE pg_catalog."default",
    year integer,
    id integer NOT NULL DEFAULT nextval('house_id_seq'::regclass),
    area_id bigint,
    CONSTRAINT house_pkey PRIMARY KEY (address),
    CONSTRAINT house_area_id_fkey FOREIGN KEY (area_id)
        REFERENCES public.area (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.house
    OWNER to postgres;

-- Table: public.water

-- DROP TABLE public.water;

CREATE TABLE public.water
(
    type_name text COLLATE pg_catalog."default" NOT NULL,
    res_val text COLLATE pg_catalog."default",
    id integer NOT NULL DEFAULT nextval('water_id_seq'::regclass),
    area_id bigint,
    CONSTRAINT water_area_id_fkey FOREIGN KEY (area_id)
        REFERENCES public.area (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.water
    OWNER to postgres;

-- Table: public.noise

-- DROP TABLE public.noise;

CREATE TABLE public.noise
(
    source text COLLATE pg_catalog."default",
    results text COLLATE pg_catalog."default",
    address text COLLATE pg_catalog."default",
    checkdate text COLLATE pg_catalog."default",
    numrequests integer,
    changes text COLLATE pg_catalog."default",
    id integer NOT NULL DEFAULT nextval('noise_id_seq'::regclass),
    area_id bigint,
    CONSTRAINT noise_pkey PRIMARY KEY (id),
    CONSTRAINT noise_area_id_fkey FOREIGN KEY (area_id)
        REFERENCES public.area (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.noise
    OWNER to postgres;

-- Table: public.area

-- DROP TABLE public.area;

CREATE TABLE public.area
(
  name text COLLATE pg_catalog."default",
  id integer NOT NULL DEFAULT nextval('area_id_seq'::regclass),
  CONSTRAINT area_pkey PRIMARY KEY (id)
)
  WITH (
    OIDS = FALSE
  )
  TABLESPACE pg_default;

ALTER TABLE public.area
  OWNER to postgres;

-- Table: public.comment

-- DROP TABLE public.comment;

CREATE TABLE public.comment
(
  id integer NOT NULL DEFAULT nextval('comment_id_seq'::regclass),
  client_id bigint,
  house_id bigint,
  body text COLLATE pg_catalog."default",
  grade_id integer,
  CONSTRAINT comment_pkey PRIMARY KEY (id),
  CONSTRAINT comment_client_id_fkey FOREIGN KEY (client_id)
    REFERENCES public.client (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  CONSTRAINT comment_grade_id_fkey FOREIGN KEY (grade_id)
    REFERENCES public.grade (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
  CONSTRAINT comment_house_id_fkey FOREIGN KEY (house_id)
    REFERENCES public.house (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
)
  WITH (
    OIDS = FALSE
  )
  TABLESPACE pg_default;

ALTER TABLE public.comment
  OWNER to postgres;