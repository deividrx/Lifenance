--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2 (Debian 14.2-1.pgdg110+1)
-- Dumped by pg_dump version 14.2 (Debian 14.2-1.pgdg110+1)

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

--
-- Name: lifenance_db; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE lifenance_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE lifenance_db OWNER TO postgres;

\connect lifenance_db

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

--
-- Name: account_types; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.account_types AS ENUM (
    'SAVING',
    'CHECKING'
);


ALTER TYPE public.account_types OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bank_accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bank_accounts (
    bank_account_id bigint NOT NULL,
    bank_name character varying(100) NOT NULL,
    agencia integer NOT NULL,
    account_number integer NOT NULL,
    type_account public.account_types NOT NULL,
    limite double precision NOT NULL,
    user_cpf character varying(11) NOT NULL
);


ALTER TABLE public.bank_accounts OWNER TO postgres;

--
-- Name: bank_accounts_bank_account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bank_accounts_bank_account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.bank_accounts_bank_account_id_seq OWNER TO postgres;

--
-- Name: bank_accounts_bank_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bank_accounts_bank_account_id_seq OWNED BY public.bank_accounts.bank_account_id;


--
-- Name: card_flags; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.card_flags (
    flag_id bigint NOT NULL,
    flag_name character varying(50) NOT NULL
);


ALTER TABLE public.card_flags OWNER TO postgres;

--
-- Name: card_flags_flag_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.card_flags_flag_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.card_flags_flag_id_seq OWNER TO postgres;

--
-- Name: card_flags_flag_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.card_flags_flag_id_seq OWNED BY public.card_flags.flag_id;


--
-- Name: cards; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cards (
    card_id bigint NOT NULL,
    card_name character varying(100) NOT NULL,
    card_number integer NOT NULL,
    validity date NOT NULL,
    limite double precision NOT NULL,
    multa integer,
    vencimento_fatura date NOT NULL,
    card_flag_id bigint NOT NULL,
    user_cpf character varying(11) NOT NULL
);


ALTER TABLE public.cards OWNER TO postgres;

--
-- Name: cards_card_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cards_card_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cards_card_id_seq OWNER TO postgres;

--
-- Name: cards_card_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cards_card_id_seq OWNED BY public.cards.card_id;


--
-- Name: transactions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transactions (
    transaction_id bigint NOT NULL,
    transaction_value double precision NOT NULL,
    transaction_name character varying(120) NOT NULL,
    transaction_initial_date date NOT NULL,
    transaction_final_date date,
    transaction_description text,
    user_cpf character varying(11) NOT NULL
);


ALTER TABLE public.transactions OWNER TO postgres;

--
-- Name: transactions_bank_accounts; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transactions_bank_accounts (
    transaction_bank_account_id bigint NOT NULL,
    bank_account_id bigint NOT NULL,
    transaction_id bigint NOT NULL
);


ALTER TABLE public.transactions_bank_accounts OWNER TO postgres;

--
-- Name: transactions_bank_accounts_transaction_bank_account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transactions_bank_accounts_transaction_bank_account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.transactions_bank_accounts_transaction_bank_account_id_seq OWNER TO postgres;

--
-- Name: transactions_bank_accounts_transaction_bank_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transactions_bank_accounts_transaction_bank_account_id_seq OWNED BY public.transactions_bank_accounts.transaction_bank_account_id;


--
-- Name: transactions_cards; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transactions_cards (
    transaction_card_id bigint NOT NULL,
    card_id bigint NOT NULL,
    transaction_id bigint NOT NULL
);


ALTER TABLE public.transactions_cards OWNER TO postgres;

--
-- Name: transactions_cards_transaction_card_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transactions_cards_transaction_card_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.transactions_cards_transaction_card_id_seq OWNER TO postgres;

--
-- Name: transactions_cards_transaction_card_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transactions_cards_transaction_card_id_seq OWNED BY public.transactions_cards.transaction_card_id;


--
-- Name: transactions_transaction_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transactions_transaction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.transactions_transaction_id_seq OWNER TO postgres;

--
-- Name: transactions_transaction_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transactions_transaction_id_seq OWNED BY public.transactions.transaction_id;


--
-- Name: user_sessions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_sessions (
    id_session character varying(12) NOT NULL,
    validator character varying(64) NOT NULL,
    user_cpf character varying(11) NOT NULL
);


ALTER TABLE public.user_sessions OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    user_cpf character varying(11) NOT NULL,
    first_name character varying(30) NOT NULL,
    last_name character varying(30) NOT NULL,
    user_email character varying(100) NOT NULL,
    user_password character varying(64) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: bank_accounts bank_account_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bank_accounts ALTER COLUMN bank_account_id SET DEFAULT nextval('public.bank_accounts_bank_account_id_seq'::regclass);


--
-- Name: card_flags flag_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.card_flags ALTER COLUMN flag_id SET DEFAULT nextval('public.card_flags_flag_id_seq'::regclass);


--
-- Name: cards card_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cards ALTER COLUMN card_id SET DEFAULT nextval('public.cards_card_id_seq'::regclass);


--
-- Name: transactions transaction_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions ALTER COLUMN transaction_id SET DEFAULT nextval('public.transactions_transaction_id_seq'::regclass);


--
-- Name: transactions_bank_accounts transaction_bank_account_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_bank_accounts ALTER COLUMN transaction_bank_account_id SET DEFAULT nextval('public.transactions_bank_accounts_transaction_bank_account_id_seq'::regclass);


--
-- Name: transactions_cards transaction_card_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_cards ALTER COLUMN transaction_card_id SET DEFAULT nextval('public.transactions_cards_transaction_card_id_seq'::regclass);


--
-- Data for Name: bank_accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bank_accounts (bank_account_id, bank_name, agencia, account_number, type_account, limite, user_cpf) FROM stdin;
\.


--
-- Data for Name: card_flags; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.card_flags (flag_id, flag_name) FROM stdin;
1	Mastercard
2	Visa
3	American Express
4	Hipercard
5	Elo
\.


--
-- Data for Name: cards; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cards (card_id, card_name, card_number, validity, limite, multa, vencimento_fatura, card_flag_id, user_cpf) FROM stdin;
\.


--
-- Data for Name: transactions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transactions (transaction_id, transaction_value, transaction_name, transaction_initial_date, transaction_final_date, transaction_description, user_cpf) FROM stdin;
\.


--
-- Data for Name: transactions_bank_accounts; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transactions_bank_accounts (transaction_bank_account_id, bank_account_id, transaction_id) FROM stdin;
\.


--
-- Data for Name: transactions_cards; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.transactions_cards (transaction_card_id, card_id, transaction_id) FROM stdin;
\.


--
-- Data for Name: user_sessions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_sessions (id_session, validator, user_cpf) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (user_cpf, first_name, last_name, user_email, user_password) FROM stdin;
61221922017	Giga	Chad	gigachad@gmail.com	gigachad
63790861022	Levi	Ackerman	leviackerman@gmail.com	leviackerman
32129586007	Bruce	Wayne	brucewayne@gmail.com	brucewayne
47440202082	Monkey	Luffy	monkeyluffy@gmail.com	monkeyluffy
84326698063	Satoru	Gojo	satorugojo@gmail.com	bacate
06308065005     Inugami Korone  koroneinugami@hotmail.com       bacate
\.


--
-- Name: bank_accounts_bank_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bank_accounts_bank_account_id_seq', 1, false);


--
-- Name: card_flags_flag_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.card_flags_flag_id_seq', 5, true);


--
-- Name: cards_card_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cards_card_id_seq', 1, false);


--
-- Name: transactions_bank_accounts_transaction_bank_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transactions_bank_accounts_transaction_bank_account_id_seq', 1, false);


--
-- Name: transactions_cards_transaction_card_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transactions_cards_transaction_card_id_seq', 1, false);


--
-- Name: transactions_transaction_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transactions_transaction_id_seq', 1, false);


--
-- Name: bank_accounts bank_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bank_accounts
    ADD CONSTRAINT bank_accounts_pkey PRIMARY KEY (bank_account_id);


--
-- Name: card_flags card_flags_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.card_flags
    ADD CONSTRAINT card_flags_pkey PRIMARY KEY (flag_id);


--
-- Name: cards cards_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cards
    ADD CONSTRAINT cards_pkey PRIMARY KEY (card_id);


--
-- Name: transactions_bank_accounts transactions_bank_accounts_bank_account_id_transaction_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_bank_accounts
    ADD CONSTRAINT transactions_bank_accounts_bank_account_id_transaction_id_key UNIQUE (bank_account_id, transaction_id);


--
-- Name: transactions_bank_accounts transactions_bank_accounts_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_bank_accounts
    ADD CONSTRAINT transactions_bank_accounts_pkey PRIMARY KEY (transaction_bank_account_id);


--
-- Name: transactions_cards transactions_cards_card_id_transaction_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_cards
    ADD CONSTRAINT transactions_cards_card_id_transaction_id_key UNIQUE (card_id, transaction_id);


--
-- Name: transactions_cards transactions_cards_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_cards
    ADD CONSTRAINT transactions_cards_pkey PRIMARY KEY (transaction_card_id);


--
-- Name: transactions transactions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT transactions_pkey PRIMARY KEY (transaction_id);


--
-- Name: user_sessions user_sessions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_sessions
    ADD CONSTRAINT user_sessions_pkey PRIMARY KEY (id_session);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_cpf);


--
-- Name: transactions_bank_accounts fk_bank_account; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_bank_accounts
    ADD CONSTRAINT fk_bank_account FOREIGN KEY (bank_account_id) REFERENCES public.bank_accounts(bank_account_id);


--
-- Name: transactions_cards fk_card; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_cards
    ADD CONSTRAINT fk_card FOREIGN KEY (card_id) REFERENCES public.cards(card_id);


--
-- Name: cards fk_card_flag; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cards
    ADD CONSTRAINT fk_card_flag FOREIGN KEY (card_flag_id) REFERENCES public.card_flags(flag_id);


--
-- Name: transactions_bank_accounts fk_transaction; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_bank_accounts
    ADD CONSTRAINT fk_transaction FOREIGN KEY (transaction_id) REFERENCES public.transactions(transaction_id);


--
-- Name: transactions_cards fk_transaction; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions_cards
    ADD CONSTRAINT fk_transaction FOREIGN KEY (transaction_id) REFERENCES public.transactions(transaction_id);


--
-- Name: user_sessions fk_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_sessions
    ADD CONSTRAINT fk_user FOREIGN KEY (user_cpf) REFERENCES public.users(user_cpf);


--
-- Name: bank_accounts fk_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bank_accounts
    ADD CONSTRAINT fk_user FOREIGN KEY (user_cpf) REFERENCES public.users(user_cpf);


--
-- Name: cards fk_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cards
    ADD CONSTRAINT fk_user FOREIGN KEY (user_cpf) REFERENCES public.users(user_cpf);


--
-- Name: transactions fk_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transactions
    ADD CONSTRAINT fk_user FOREIGN KEY (user_cpf) REFERENCES public.users(user_cpf);


--
-- PostgreSQL database dump complete
--

