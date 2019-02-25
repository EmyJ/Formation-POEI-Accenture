--INDIQUE LA BASE SUR LAQUELLE S'EXECUTE LE SCRIPT
USE GESTION_EMPLOYES;
GO

--EXEMPLES du cours

CREATE TABLE Employes( 
	CodeEmp INT				not null IDENTITY(1,1),
	Nom VARCHAR(20)			not null,
	Prenom CHAR(20)			null,
	DateNaissance DATE		null,
	DateEmbauche DATE		not null CONSTRAINT DF_Employes_DateEmbauche DEFAULT getdate(),
	DateModif TIMESTAMP		null,
	Salaire DECIMAL(8,2)	not null CONSTRAINT DF_Employes_Salaire DEFAULT 0
									 CONSTRAINT CK_Employes_Salaire CHECK (salaire >= 0),
	CodeService CHAR(5)		not null,
	CodeChef INT			null,
	CONSTRAINT PK_Employes PRIMARY KEY(CodeEmp),
	CONSTRAINT CK_Employes_VerifDate CHECK (DateNaissance is null or DateEmbauche >= DateNaissance)
);

CREATE TABLE Services(
	CodeService CHAR(5)		not null,
	Libelle VARCHAR(30)		not null,
	CONSTRAINT PK_Services PRIMARY KEY(CodeService),
	CONSTRAINT UN_Services_Libelle UNIQUE(Libelle)
);

/*********************************************************************************/

--A VOUS DE JOUER

CREATE TABLE Conges(
	CodeEmp INT				not null,					
	Annee NUMERIC(4)		not null,
	NbJoursAcquis NUMERIC(2) null CONSTRAINT DF_Conges_NbJoursAcquis DEFAULT 30,
	CONSTRAINT PK_Conges PRIMARY KEY (CodeEmp,Annee)
);

CREATE TABLE Conges_Mens(
	CodeEmp INT  			not null,
	Annee NUMERIC(4)		not null,
	Mois NUMERIC(2)			not null CONSTRAINT CK_Conges_Mens_Mois CHECK (mois between 1 and 12),
	NbJoursPris NUMERIC(2)	null CONSTRAINT DF_Conges_Mens_NbJoursPris DEFAULT 0,
	CONSTRAINT PK_Conges_Mens PRIMARY KEY (CodeEmp, Annee, Mois)	
);