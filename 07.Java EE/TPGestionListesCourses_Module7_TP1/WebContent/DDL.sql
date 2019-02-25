CREATE TABLE LISTES
(
	id int identity(1,1) CONSTRAINT PK_LISTES PRIMARY KEY,
	nom varchar(50) NOT NULL
);

CREATE TABLE ARTICLES
(
	id int identity(1,1) CONSTRAINT PK_ARTICLES PRIMARY KEY,
	nom varchar(50) NOT NULL,
	id_liste int NOT NULL
);

ALTER TABLE ARTICLES ADD coche bit default 0;

ALTER TABLE ARTICLES
	ADD CONSTRAINT FK_ARTICLES_LISTES 
		FOREIGN KEY(id_liste) REFERENCES LISTES(id)
		ON DELETE CASCADE;

ALTER TABLE ARTICLES
	DROP CONSTRAINT FK_ARTICLES_LISTES;
