--
-- PostgreSQL database dump
--

-- Dumped from database version 12.8
-- Dumped by pg_dump version 12.8

--------------------------------------------------------------------------
-- Uncomment if the POSTGRES_DB is not set before creating the container--
--------------------------------------------------------------------------
--SET statement_timeout = 0;
--SET lock_timeout = 0;
--SET idle_in_transaction_session_timeout = 0;
--SET client_encoding = 'UTF8';
--SET standard_conforming_strings = on;
--SELECT pg_catalog.set_config('search_path', '', false);
--SET check_function_bodies = false;
--SET xmloption = content;
--SET client_min_messages = warning;
--SET row_security = off;
--
----
---- Name: cruise; Type: DATABASE; Schema: -; Owner: -
----
--
--CREATE DATABASE cruise WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.utf8' LC_CTYPE = 'en_US.utf8';
--
--
--\connect cruise

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.clients (
    client_id bigint NOT NULL,
    bio character varying(255),
    date_of_birth timestamp without time zone,
    email character varying(255) NOT NULL,
    first_name character varying(65) NOT NULL,
    gender integer,
    second_name character varying(65) NOT NULL,
    username character varying(65) NOT NULL
);


--
-- Name: clients_client_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.clients ALTER COLUMN client_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.clients_client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: posts; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.posts (
    post_id bigint NOT NULL,
    body character varying(255),
    likes bigint DEFAULT 0,
    client_id bigint NOT NULL
);


--
-- Name: posts_post_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.posts ALTER COLUMN post_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.posts_post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.clients OVERRIDING SYSTEM VALUE VALUES (1, 'Have a lovely day', '2021-09-22 19:36:36.026391', 'kmasenam@student.wethinkcode.co.za', 'kgotlelelo', 0, 'masenamela', 'code bender');
INSERT INTO public.clients OVERRIDING SYSTEM VALUE VALUES (2, 'another one', '2021-09-22 19:36:36.043624', 'kgotlelelomasenamela74@gmail.com', 'John', 0, 'Doe', 'Don');


--
-- Data for Name: posts; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.posts OVERRIDING SYSTEM VALUE VALUES (1, 'hello world', 0, 1);
INSERT INTO public.posts OVERRIDING SYSTEM VALUE VALUES (2, 'a post', 0, 2);


--
-- Name: clients_client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.clients_client_id_seq', 1, false);


--
-- Name: posts_post_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.posts_post_id_seq', 1, false);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (client_id);


--
-- Name: clients email_unq; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT email_unq UNIQUE (email);


--
-- Name: posts posts_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT posts_pkey PRIMARY KEY (post_id);


--
-- Name: posts clients_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.posts
    ADD CONSTRAINT clients_fkey FOREIGN KEY (client_id) REFERENCES public.clients(client_id);


--
-- PostgreSQL database dump complete
--

