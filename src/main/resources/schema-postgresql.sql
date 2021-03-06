DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Diretor_filmes;
DROP TABLE IF EXISTS Filmes;
DROP TABLE IF EXISTS Diretor;

/* TABLE USUARIO */

CREATE TABLE
IF NOT EXISTS Usuario
(
ID SERIAL PRIMARY KEY,
NOMEUSUARIO VARCHAR
(100),
EMAIL VARCHAR
(50),
SENHA VARCHAR
(10)
);

/* TABLE FILMES */

CREATE TABLE
IF NOT EXISTS Filmes
(
    IDFILME SERIAL PRIMARY KEY,
    TITULO VARCHAR
(100),
    GENEROFILME VARCHAR
(50),
    BIRTHYEAR VARCHAR
(4),
    DIRETOR VARCHAR
(50),
    SINOPSE VARCHAR
(500)
);

CREATE TABLE
IF NOT EXISTS Diretor
(
    IDDIRETOR SERIAL PRIMARY KEY,
    DIRETOR VARCHAR(50)
);

INSERT INTO Diretor(DIRETOR) VALUES('Agnès Varda');
INSERT INTO Diretor(DIRETOR) VALUES('Ingmar Bergman');

CREATE TABLE
IF NOT EXISTS Diretor_filmes
(
    IDDIRETOR INT,
    IDFILME INT,
    PRIMARY KEY
(IDFILME, IDDIRETOR),
CONSTRAINT FK_DIRETOR
    FOREIGN KEY(IDDIRETOR)
        REFERENCES Diretor(IDDIRETOR),
CONSTRAINT FK_IDFILME
    FOREIGN KEY(IDFILME)
        REFERENCES Filmes(IDFILME)
);

