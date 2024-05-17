CREATE DATABASE PROG_POKEMON;



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
    NOM_MOVIMIENTO VARCHAR(20) NOT NULL,
    POTENCIA INT,
    TIPO VARCHAR(20) NOT NULL,
    ESTADO VARCHAR(20),
    QUITA INT,
    PP INT NOT NULL,
    MEJORA VARCHAR(20),
    CANT_MEJORA INT,
    NIVEL_APRENDIZAJE INT NOT NULL,
    CATEGORIA VARCHAR(20)
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


-- Inserts de los 151 Pokémon de la generación 1 en la tabla POKEMON
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO) VALUES
(1, 6, NULL, 0, 49, 65, 49, 65, 45, 5, 70, 'M', 'Saludable', 0, 100, NULL),
(1, 7, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL),
(1, 8, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL),
(1, 9, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL),
(1, 10, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL);
(1, 11, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 80, NULL);

(2, 12, NULL, 0, 49, 65, 49, 65, 45, 5, 70, 'M', 'Saludable', 0, 100, NULL),
(2, 13, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL),
(2, 14, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL),
(2, 15, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL),
(2, 16, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL);
(2, 17, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 80, NULL);





--INSERT POKEDEX
INSERT INTO POKEDEX (NUM_POKEDEX, NOM_POKEMON, TIPO1, TIPO2, IMAGEN, NIVEL_EVOLUCION) VALUES
(1, 'Bulbasaur', 'Planta', 'Veneno', 'ani_bw_001.gif', 16),
(2, 'Ivysaur', 'Planta', 'Veneno', 'ani_bw_002.gif', 32),
(3, 'Venusaur', 'Planta', 'Veneno', 'ani_bw_003.gif', NULL),
(4, 'Charmander', 'Fuego', 'Fuego', 'ani_bw_004.gif', 16),
(5, 'Charmeleon', 'Fuego', 'Fuego', 'ani_bw_005.gif', 36),
(6, 'Charizard', 'Fuego', 'Volador', 'ani_bw_006.gif', NULL),
(7, 'Squirtle', 'Agua', 'Agua', 'ani_bw_007.gif', 16),
(8, 'Wartortle', 'Agua', 'Agua', 'ani_bw_008.gif', 36),
(9, 'Blastoise', 'Agua', 'Agua', 'ani_bw_009.gif', NULL),
(10, 'Caterpie', 'Bicho', 'Agua', 'ani_bw_010.gif', 7),
(11, 'Metapod', 'Bicho', 'Agua', 'ani_bw_011.gif', 10),
(12, 'Butterfree', 'Bicho', 'Volador', 'ani_bw_012.gif', NULL),
(13, 'Weedle', 'Bicho', 'Veneno', 'ani_bw_013.gif', 7),
(14, 'Kakuna', 'Bicho', 'Veneno', 'ani_bw_014.gif', 10),
(15, 'Beedrill', 'Bicho', 'Veneno', 'ani_bw_015.gif', NULL),
(16, 'Pidgey', 'Normal', 'Volador', 'ani_bw_016.gif', 18),
(17, 'Pidgeotto', 'Normal', 'Volador', 'ani_bw_017.gif', 36),
(18, 'Pidgeot', 'Normal', 'Volador', 'ani_bw_018.gif', NULL),
(19, 'Rattata', 'Normal', 'Normal', 'ani_bw_019.gif', 20),
(20, 'Raticate', 'Normal', 'Normal', 'ani_bw_020.gif', NULL),
(21, 'Spearow', 'Normal', 'Volador', 'ani_bw_021.gif', 20),
(22, 'Fearow', 'Normal', 'Volador', 'ani_bw_022.gif', NULL),
(23, 'Ekans', 'Veneno', 'Veneno', 'ani_bw_023.gif', 22),
(24, 'Arbok', 'Veneno', 'Veneno', 'ani_bw_024.gif', NULL),
(25, 'Pikachu', 'Eléctrico', 'Eléctrico', 'ani_bw_025.gif', NULL),
(26, 'Raichu', 'Eléctrico', 'Eléctrico', 'ani_bw_026.gif', NULL),
(27, 'Sandshrew', 'Tierra', 'Tierra', 'ani_bw_027.gif', 22),
(28, 'Sandslash', 'Tierra', 'Tierra', 'ani_bw_028.gif', NULL),
(29, 'Nidoran♀', 'Veneno', 'Veneno', 'ani_bw_029.gif', 16),
(30, 'Nidorina', 'Veneno', 'Veneno', 'ani_bw_030.gif', 22),


-- Movimientos de Ataque (Inflije daño al Pokémon rival)
INSERT INTO MOVIMIENTOS (ID_MOVIMIENTO, NOM_MOVIMIENTO, POTENCIA, TIPO, ESTADO, QUITA, PP, MEJORA, CANT_MEJORA, NIVEL_APRENDIZAJE, CATEGORIA) VALUES
(1, 'Pound', 40, 'Normal', 'Físico', NULL, 35, NULL, NULL, 1, 'Ataque'),
(2, 'Karate Chop', 50, 'Lucha', 'Físico', NULL, 25, NULL, NULL, 1, 'Ataque'),
(4, 'Comet Punch', 18, 'Normal', 'Físico', NULL, 15, NULL, NULL, 1, 'Ataque'),
(5, 'Mega Punch', 80, 'Normal', 'Físico', NULL, 20, NULL, NULL, 1, 'Ataque'),
(6, 'Pay Day', 40, 'Normal', 'Físico', NULL, 20, NULL, NULL, 1, 'Ataque'),
(7, 'Fire Punch', 75, 'Fuego', 'Físico', NULL, 15, NULL, NULL, 1, 'Ataque'),
(8, 'Ice Punch', 75, 'Hielo', 'Físico', NULL, 15, NULL, NULL, 1, 'Ataque'),
(9, 'Thunder Punch', 75, 'Eléctrico', 'Físico', NULL, 15, NULL, NULL, 1, 'Ataque'),
(10, 'Scratch', 40, 'Normal', 'Físico', NULL, 35, NULL, NULL, 1, 'Ataque');

-- Movimientos de Estado (Alteran el estado del Pokémon enemigo)
INSERT INTO MOVIMIENTOS (ID_MOVIMIENTO, NOM_MOVIMIENTO, POTENCIA, TIPO, ESTADO, QUITA, PP, MEJORA, CANT_MEJORA, NIVEL_APRENDIZAJE, CATEGORIA) VALUES
(3, 'Growl', 35, 'Normal', 'Físico', NULL, 40, NULL, NULL, 1, 'Ataque'),
(12, 'Leer', 35, 'Normal', 'Físico', NULL, 30, NULL, NULL, 1, 'Ataque'),
(14, 'Whirlwind', 67, 'Normal', 'Físico', NULL, 20, NULL, NULL, 1, 'Ataque'),
(15, 'Supersonic', 34, 'Normal', 'Físico', NULL, 20, NULL, NULL, 1, 'Ataque'),
(18, 'Disable', 23, 'Normal', 'Físico', NULL, 20, NULL, NULL, 1, 'Ataque'),
(28, 'Growl', 44, 'Normal', 'Físico', NULL, 40, NULL, NULL, 1, 'Ataque'),
(32, 'Supersonic', 44, 'Normal', 'Físico', NULL, 20, NULL, NULL, 1, 'Ataque'),
(33, 'Confusion', 50, 'Psíquico', 'Físico', NULL, 25, NULL, NULL, 1, 'Ataque'),
(35, 'Water Gun', 40, 'Agua', 'Físico', NULL, 25, NULL, NULL, 1, 'Ataque');

-- Movimientos de Mejora (Alteran una estadística de nuestro Pokémon)
INSERT INTO MOVIMIENTOS (ID_MOVIMIENTO, NOM_MOVIMIENTO, POTENCIA, TIPO, ESTADO, QUITA, PP, MEJORA, CANT_MEJORA, NIVEL_APRENDIZAJE, CATEGORIA) VALUES
(74, 'Swords Dance', 45, 'Normal', 'Físico', NULL, 30, 'Atk', 2, 1, 'Ataque'),
(75, 'Agility', 34, 'Psíquico', 'Físico', NULL, 30, 'Speed', 2, 1, 'Ataque'),
(86, 'Minimize', 23, 'Normal', 'Físico', NULL, 20, 'Evasion', 2, 1, 'Ataque'),
(88, 'Withdraw', 22, 'Agua', 'Físico', NULL, 40, 'Defense', 1, 1, 'Ataque'),
(89, 'Defense Curl', 12, 'Normal', 'Físico', NULL, 40, 'Defense', 1, 1, 'Ataque'),
(90, 'Barrier', 33, 'Psíquico', 'Físico', NULL, 20, 'Defense', 2, 1, 'Ataque'),
(91, 'Light Screen', 55, 'Psíquico', 'Físico', NULL, 30, 'Special Defense', 2, 1, 'Ataque'),
(93, 'Reflect', 33, 'Psíquico', 'Físico', NULL, 20, 'Defense', 2, 1, 'Ataque');


INSERT INTO MOVIMIENTOS_POKEMON (ID_MOVIMIENTO, ID_POKEMON) VALUES
(35, 6),
(88, 6),
(5, 6),
(8, 6),
(35, 7),
(88, 7),
(3, 7),
(4, 7),
(1, 8),
(9, 8),
(10, 8),
(33, 8),
(6, 9),
(7, 9),
(12, 9),
(18, 9),
(88, 10),
(10, 10),
(35, 10),
(6, 10),
(28, 11),
(75, 11),
(90, 11),
(91, 11);



































