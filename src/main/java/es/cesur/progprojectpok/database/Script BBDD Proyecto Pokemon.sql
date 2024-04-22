CREATE TABLE ENTRENADOR (
    ID_USER INT  AUTO_INCREMENT PRIMARY KEY,
    NOMBRE_USER VARCHAR(30) NOT NULL,
    PASS_USER VARCHAR(30) NOT NULL,
    POKEDOLLAR INT
);

CREATE TABLE POKEMON (
    ID_POKEMON INT AUTO_INCREMENT PRIMARY KEY,
    ID_USER INT,
    NUM_POKEDEX INT,
    MOTE VARCHAR(30),
    CAJA INT NOT NULL,
    ATAQUE INT NOT NULL,
    AT_ESPECIAL INT NOT NULL,
    DEFENSA INT NOT NULL,
    DEF_ESPECIAL INT NOT NULL,
    VELOCIDAD INT NOT NULL,
    NIVEL INT NOT NULL,
    FERTILIDAD INT NOT NULL,
    SEXO CHAR(1) NOT NULL,
    ESTADO VARCHAR(20) NOT NULL,
    EXPERIENCIA INT NOT NULL,
    VITALIDAD INT NOT NULL,
    ID_OBJETO INT
    
  
);

CREATE TABLE MOVIMIENTOS (
    ID_MOVIMIENTO INT NOT NULL PRIMARY KEY,
    POTENCIA INT,
    TIPO VARCHAR(20) NOT NULL,
    ESTADO VARCHAR(20),
    QUITA INT,
    TURNOS INT,
    MEJORA VARCHAR(20),
    CANT_MEJORA INT,
    NIVEL_APRENDIZAJE INT NOT NULL
);

CREATE TABLE MOVIMIENTOS_POKEMON (
    ID_MOVIMIENTO INT,
    ID_POKEMON INT
    

);

CREATE TABLE OBJETO (
    ID_OBJETO INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE VARCHAR(20) NOT NULL,
    ATAQUE INT,
    AT_ESPECIAL INT,
    DEFENSA INT,
    DEF_ESPECIAL INT,
    VELOCIDAD INT,
    PRECIO INT NOT NULL
);

CREATE TABLE MOCHILA(
    ID_USER INT,
    ID_OBJETO INT,
    NUM_OBJETO INT NOT NULL

   
);

CREATE TABLE POKEDEX(
    NUM_POKEDEX INT PRIMARY KEY,
    NOM_POKEMON VARCHAR(30) NOT NULL,
    TIPO1 VARCHAR(20) NOT NULL,
    TIPO2 VARCHAR(20),
    IMAGEN VARCHAR(100) NOT NULL,
    SONIDO VARCHAR(100) NOT NULL, 
    NIVEL_EVOLUCION INT,
    NUM_POKEDEX_EVO INT
    
   
);


-- POKEMON

ALTER TABLE POKEMON 

  	ADD CONSTRAINT FK_POK_USER FOREIGN KEY(ID_USER) REFERENCES ENTRENADOR(ID_USER),

   	ADD CONSTRAINT FK_POK_NUMPOKE FOREIGN KEY(NUM_POKEDEX) REFERENCES POKEDEX(NUM_POKEDEX),
  	ADD CONSTRAINT FK_POK_IDOBJ FOREIGN KEY(ID_OBJETO) REFERENCES OBJETO(ID_OBJETO);



-- POKEDEX

ALTER TABLE POKEDEX ADD

 CONSTRAINT FK_PKDEX_NUMEVO FOREIGN KEY(NUM_POKEDEX_EVO) REFERENCES POKEMON(NUM_POKEDEX);


-- MOCHILA

ALTER TABLE MOCHILA 


    ADD CONSTRAINT FK_MOCHILA_IDUSR FOREIGN KEY(ID_USER) REFERENCES ENTRENADOR(ID_USER),
    ADD CONSTRAINT FK_MOCHILA_IDOBJ FOREIGN KEY(ID_OBJETO) REFERENCES OBJETO(ID_OBJETO);


-- MOVIMIENTOS_POKEMON

ALTER TABLE MOVIMIENTOS_POKEMON

   ADD CONSTRAINT PK_MOVPOK_POK PRIMARY KEY(ID_MOVIMIENTO, ID_POKEMON),
    
   ADD CONSTRAINT FK_MOVPOK_MOV FOREIGN KEY(ID_MOVIMIENTO) REFERENCES MOVIMIENTOS(ID_MOVIMIENTO),
   ADD CONSTRAINT FK_MOVPOK_POK FOREIGN KEY(ID_POKEMON) REFERENCES POKEMON(ID_POKEMON);






INSERT INTO ENTRENADOR (NOMBRE_USER, PASS_USER, POKEDOLLAR) VALUES
('Felipe', '12345', 500),
('Daniel', '123456', 300);





-- Bulbasaur
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (1, 1, 'Bulbasaur', 1, 49, 65, 49, 65, 45, 5, 70, 'M', 'Saludable', 0, 100, NULL);

-- Ivysaur
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (1, 2, 'Ivysaur', 1, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL);

-- Venusaur
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (1, 3, 'Venussaur', 1, 82, 100, 83, 100, 80, 32, 70, 'M', 'Saludable', 0, 100, NULL);

-- Charmander
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (2, 4, 'Charmander', 1, 52, 60, 43, 50, 65, 5, 70, 'M', 'Saludable', 0, 100, NULL);

-- Charmeleon
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (2, 5, 'Charmeleon', 1, 64, 80, 58, 65, 80, 16, 70, 'M', 'Saludable', 0, 100, NULL);

-- Charizard
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (2, 6, 'Charizard', 1, 84, 109, 78, 85, 100, 36, 70, 'M', 'Saludable', 0, 100, NULL);

-- Squirtle
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (3, 7, 'Squirtle', 1, 48, 50, 65, 64, 43, 5, 70, 'M', 'Saludable', 0, 100, NULL);

-- Wartortle
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (3, 8, 'Wartortle', 1, 63, 65, 80, 80, 58, 16, 70, 'M', 'Saludable', 0, 100, NULL);

-- Blastoise
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (3, 9, 'Blasttoise', 1, 83, 85, 100, 105, 78, 36, 70, 'M', 'Saludable', 0, 100, NULL);

-- Caterpie
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (4, 10, 'Caterpie', 1, 30, 20, 35, 20, 45, 3, 70, 'M', 'Saludable', 0, 100, NULL);

-- Metapod
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (4, 11, 'Metapod', 1, 20, 25, 55, 25, 30, 7, 70, 'M', 'Saludable', 0, 100, NULL);

-- Butterfree
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (4, 12, 'Butterfree', 1, 45, 80, 50, 80, 70, 10, 70, 'M', 'Saludable', 0, 100, NULL);

-- Weedle
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (5, 13, 'Weedle', 1, 35, 20, 30, 20, 50, 3, 70, 'M', 'Saludable', 0, 100, NULL);

-- Kakuna
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (5, 14, 'Kakuna', 1, 25, 25, 50, 25, 35, 7, 70, 'M', 'Saludable', 0, 100, NULL);

-- Beedrill
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (5, 15, 'Beedrill', 1, 90, 45, 40, 80, 75, 10, 70, 'M', 'Saludable', 0, 100, NULL);

-- Pidgey
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (6, 16, 'Pidgey', 1, 45, 35, 40, 35, 56, 5, 70, 'M', 'Saludable', 0, 100, NULL);

-- Pidgeotto
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (6, 17, 'Pidgeotto', 1, 60, 50, 55, 50, 71, 18, 70, 'M', 'Saludable', 0, 100, NULL);

-- Pidgeot
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (6, 18, 'Pidgeot', 1, 80, 70, 75, 70, 91, 36, 70, 'M', 'Saludable', 0, 100, NULL);

-- Rattata
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO)
VALUES (7, 19, 'Rattta', 1, 56, 25, 35, 35, 72, 4, 70, 'M', 'Saludable', 0, 100, NULL);




