CREATE TABLE IF NOT EXISTS public.departments
(
    department_id text COLLATE pg_catalog."default" NOT NULL,
    department_name text COLLATE pg_catalog."default" NOT NULL,
    department_location text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT departments_pkey PRIMARY KEY (department_id)

)

    TABLESPACE pg_default;

ALTER TABLE public.departments
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.users
(
    user_id text COLLATE pg_catalog."default" NOT NULL,
    name text COLLATE pg_catalog."default",
    department_id text COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT users_department_id_fkey FOREIGN KEY (department_id)
        REFERENCES public.departments (department_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;



