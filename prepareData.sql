BEGIN;
DROP TABLE IF EXISTS public.student CASCADE;
CREATE TABLE public.student
(
    id uuid,
    name character varying(128) NOT NULL,
    mark integer,
    PRIMARY KEY (id)
)
    WITH (OIDS = FALSE)
    TABLESPACE pg_default;
ALTER TABLE public.student
    OWNER to postgres;
COMMENT ON TABLE public.student
    IS 'Список студентов';
COMMIT;