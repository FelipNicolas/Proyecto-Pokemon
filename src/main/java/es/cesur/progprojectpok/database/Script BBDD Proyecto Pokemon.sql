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
(1, 1, NULL, 0, 49, 65, 49, 65, 45, 5, 70, 'M', 'Saludable', 0, 100, NULL),
(1, 2, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL),
(1, 7, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL),
(1, 10, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL),
(1, 5, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL);
(1, 9, NULL, 0, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 80, NULL);





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
(10, 'Caterpie', 'Bicho', 'Bicho', 'ani_bw_010.gif', 7),
(11, 'Metapod', 'Bicho', 'Bicho', 'ani_bw_011.gif', 10),
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
(25, 'Pikachu', 'Eléctrico','Eléctrico', 'ani_bw_025.gif', NULL),
(26, 'Raichu', 'Eléctrico', 'Eléctrico', 'ani_bw_026.gif', NULL),
(27, 'Sandshrew', 'Tierra', 'Tierra', 'ani_bw_027.gif', 22),
(28, 'Sandslash', 'Tierra', 'Tierra', 'ani_bw_028.gif', NULL),
(29, 'Nidoran♀', 'Veneno', 'Veneno', 'ani_bw_029.gif', 16),
(30, 'Nidorina', 'Veneno', 'Veneno', 'ani_bw_030.gif', 22),
(31, 'Nidoqueen', 'Veneno', 'Tierra', 'ani_bw_031.gif', NULL),
(32, 'Nidoran♂', 'Veneno', 'Veneno', 'ani_bw_032.gif', 16),
(33, 'Nidorino', 'Veneno', 'Veneno', 'ani_bw_033.gif', 22),
(34, 'Nidoking', 'Veneno', 'Tierra', 'ani_bw_034.gif', NULL),
(35, 'Clefairy', 'Hada', 'Hada', 'ani_bw_035.gif', NULL),
(36, 'Clefable', 'Hada', 'Hada', 'ani_bw_036.gif', NULL),
(37, 'Vulpix', 'Fuego', 'Fuego', 'ani_bw_037.gif', 16),
(38, 'Ninetales', 'Fuego', 'Fuego', 'ani_bw_038.gif', NULL),
(39, 'Jigglypuff', 'Normal', 'Hada', 'ani_bw_039.gif', NULL),
(40, 'Wigglytuff', 'Normal', 'Hada', 'ani_bw_040.gif', NULL),
(41, 'Zubat', 'Veneno', 'Volador', 'ani_bw_041.gif', 22),
(42, 'Golbat', 'Veneno', 'Volador', 'ani_bw_042.gif', NULL),
(43, 'Oddish', 'Planta', 'Veneno', 'ani_bw_043.gif', 21),
(44, 'Gloom', 'Planta', 'Veneno', 'ani_bw_044.gif', 21),
(45, 'Vileplume', 'Planta', 'Veneno', 'ani_bw_045.gif', NULL),
(46, 'Paras', 'Bicho', 'Planta', 'ani_bw_046.gif', 24),
(47, 'Parasect', 'Bicho', 'Planta', 'ani_bw_047.gif', NULL),
(48, 'Venonat', 'Bicho', 'Veneno', 'ani_bw_048.gif', 31),
(49, 'Venomoth', 'Bicho', 'Veneno', 'ani_bw_049.gif', NULL),

(50, 'Diglett', 'Tierra', NULL, 'ani_bw_050.gif', 26),
(51, 'Dugtrio', 'Tierra', NULL, 'ani_bw_051.gif', NULL),
(52, 'Meowth', 'Normal', NULL, 'ani_bw_052.gif', 28),
(53, 'Persian', 'Normal', NULL, 'ani_bw_053.gif', NULL),
(54, 'Psyduck', 'Agua', NULL, 'ani_bw_054.gif', 33),
(55, 'Golduck', 'Agua', NULL, 'ani_bw_055.gif', NULL),
(56, 'Mankey', 'Lucha', NULL, 'ani_bw_056.gif', 28),
(57, 'Primeape', 'Lucha', NULL, 'ani_bw_057.gif', NULL),
(58, 'Growlithe', 'Fuego', NULL, 'ani_bw_058.gif', 18),
(59, 'Arcanine', 'Fuego', NULL, 'ani_bw_059.gif', NULL),
(60, 'Poliwag', 'Agua', NULL, 'ani_bw_060.gif', 25),
(61, 'Poliwhirl', 'Agua', NULL, 'ani_bw_061.gif', 25),
(62, 'Poliwrath', 'Agua', 'Lucha', 'ani_bw_062.gif', NULL),
(63, 'Abra', 'Psíquico', NULL, 'ani_bw_063.gif', 16),
(64, 'Kadabra', 'Psíquico', NULL, 'ani_bw_064.gif', 16),
(65, 'Alakazam', 'Psíquico', NULL, 'ani_bw_065.gif', NULL),
(66, 'Machop', 'Lucha', NULL, 'ani_bw_066.gif', 28),
(67, 'Machoke', 'Lucha', NULL, 'ani_bw_067.gif', 28),
(68, 'Machamp', 'Lucha', NULL, 'ani_bw_068.gif', NULL),
(69, 'Bellsprout', 'Planta', 'Veneno', 'ani_bw_069.gif', 21),
(70, 'Weepinbell', 'Planta', 'Veneno', 'ani_bw_070.gif', 21),
(71, 'Victreebel', 'Planta', 'Veneno', 'ani_bw_071.gif', NULL),
(72, 'Tentacool', 'Agua', 'Veneno', 'ani_bw_072.gif', 30),
(73, 'Tentacruel', 'Agua', 'Veneno', 'ani_bw_073.gif', NULL),
(74, 'Geodude', 'Roca', 'Tierra', 'ani_bw_074.gif', 25),
(75, 'Graveler', 'Roca', 'Tierra', 'ani_bw_075.gif', 25),
(76, 'Golem', 'Roca', 'Tierra', 'ani_bw_076.gif', NULL),
(77, 'Ponyta', 'Fuego', NULL, 'ani_bw_077.gif', 40),
(78, 'Rapidash', 'Fuego', NULL, 'ani_bw_078.gif', NULL),
(79, 'Slowpoke', 'Agua', 'Psíquico', 'ani_bw_079.gif', 37),
(80, 'Slowbro', 'Agua', 'Psíquico', 'ani_bw_080.gif', NULL),
(81, 'Magnemite', 'Eléctrico', 'Acero', 'ani_bw_081.gif', 30),
(82, 'Magneton', 'Eléctrico', 'Acero', 'ani_bw_082.gif', NULL),
(83, 'Farfetch’d', 'Normal', 'Volador', 'ani_bw_083.gif', NULL),
(84, 'Doduo', 'Normal', 'Volador', 'ani_bw_084.gif', 31),
(85, 'Dodrio', 'Normal', 'Volador', 'ani_bw_085.gif', NULL),
(86, 'Seel', 'Agua', NULL, 'ani_bw_086.gif', 34),
(87, 'Dewgong', 'Agua', 'Hielo', 'ani_bw_087.gif', NULL),
(88, 'Grimer', 'Veneno', NULL, 'ani_bw_088.gif', 38),
(89, 'Muk', 'Veneno', NULL, 'ani_bw_089.gif', NULL),
(90, 'Shellder', 'Agua', NULL, 'ani_bw_090.gif', 36),
(91, 'Cloyster', 'Agua', 'Hielo', 'ani_bw_091.gif', NULL),
(92, 'Gastly', 'Fantasma', 'Veneno', 'ani_bw_092.gif', 25),
(93, 'Haunter', 'Fantasma', 'Veneno', 'ani_bw_093.gif', 25),
(94, 'Gengar', 'Fantasma', 'Veneno', 'ani_bw_094.gif', NULL),
(95, 'Onix', 'Roca', 'Tierra', 'ani_bw_095.gif', NULL),
(96, 'Drowzee', 'Psíquico', NULL, 'ani_bw_096.gif', 26),
(97, 'Hypno', 'Psíquico', NULL, 'ani_bw_097.gif', NULL),
(98, 'Krabby', 'Agua', NULL, 'ani_bw_098.gif', 28),
(99, 'Kingler', 'Agua', NULL, 'ani_bw_099.gif', NULL),
(100, 'Voltorb', 'Eléctrico', NULL, 'ani_bw_100.gif', 30),
(101, 'Electrode', 'Eléctrico', NULL, 'ani_bw_101.gif', NULL),
(102, 'Exeggcute', 'Planta', 'Psíquico', 'ani_bw_102.gif', 28),
(103, 'Exeggutor', 'Planta', 'Psíquico', 'ani_bw_103.gif', NULL),
(104, 'Cubone', 'Tierra', NULL, 'ani_bw_104.gif', 28),
(105, 'Marowak', 'Tierra', NULL, 'ani_bw_105.gif', NULL),
(106, 'Hitmonlee', 'Lucha', NULL, 'ani_bw_106.gif', NULL),
(107, 'Hitmonchan', 'Lucha', NULL, 'ani_bw_107.gif', NULL),
(108, 'Lickitung', 'Normal', NULL, 'ani_bw_108.gif', NULL),
(109, 'Koffing', 'Veneno', NULL, 'ani_bw_109.gif', 35),
(110, 'Weezing', 'Veneno', NULL, 'ani_bw_110.gif', NULL),
(111, 'Rhyhorn', 'Tierra', 'Roca', 'ani_bw_111.gif', 42),
(112, 'Rhydon', 'Tierra', 'Roca', 'ani_bw_112.gif', NULL),
(113, 'Chansey', 'Normal', NULL, 'ani_bw_113.gif', NULL),
(114, 'Tangela', 'Planta', NULL, 'ani_bw_114.gif', NULL),
(115, 'Kangaskhan', 'Normal', NULL, 'ani_bw_115.gif', NULL),
(116, 'Horsea', 'Agua', NULL, 'ani_bw_116.gif', 32),
(117, 'Seadra', 'Agua', NULL, 'ani_bw_117.gif', NULL),
(118, 'Goldeen', 'Agua', NULL, 'ani_bw_118.gif', 33),
(119, 'Seaking', 'Agua', NULL, 'ani_bw_119.gif', NULL),
(120, 'Staryu', 'Agua', NULL, 'ani_bw_120.gif', NULL),
(121, 'Starmie', 'Agua', 'Psíquico', 'ani_bw_121.gif', NULL),
(122, 'Mr. Mime', 'Psíquico', 'Hada', 'ani_bw_122.gif', NULL),
(123, 'Scyther', 'Bicho', 'Volador', 'ani_bw_123.gif', NULL),
(124, 'Jynx', 'Hielo', 'Psíquico', 'ani_bw_124.gif', NULL),
(125, 'Electabuzz', 'Eléctrico', NULL, 'ani_bw_125.gif', NULL),
(126, 'Magmar', 'Fuego', NULL, 'ani_bw_126.gif', NULL),
(127, 'Pinsir', 'Bicho', NULL, 'ani_bw_127.gif', NULL),
(128, 'Tauros', 'Normal', NULL, 'ani_bw_128.gif', NULL),
(129, 'Magikarp', 'Agua', NULL, 'ani_bw_129.gif', 20),
(130, 'Gyarados', 'Agua', 'Volador', 'ani_bw_130.gif', NULL),
(131, 'Lapras', 'Agua', 'Hielo', 'ani_bw_131.gif', NULL),
(132, 'Ditto', 'Normal', NULL, 'ani_bw_132.gif', NULL),
(133, 'Eevee', 'Normal', NULL, 'ani_bw_133.gif', NULL),
(134, 'Vaporeon', 'Agua', NULL, 'ani_bw_134.gif', NULL),
(135, 'Jolteon', 'Eléctrico', NULL, 'ani_bw_135.gif', NULL),
(136, 'Flareon', 'Fuego', NULL, 'ani_bw_136.gif', NULL),
(137, 'Porygon', 'Normal', NULL, 'ani_bw_137.gif', NULL),
(138, 'Omanyte', 'Roca', 'Agua', 'ani_bw_138.gif', 40),
(139, 'Omastar', 'Roca', 'Agua', 'ani_bw_139.gif', NULL),
(140, 'Kabuto', 'Roca', 'Agua', 'ani_bw_140.gif', 40),
(141, 'Kabutops', 'Roca', 'Agua', 'ani_bw_141.gif', NULL),
(142, 'Aerodactyl', 'Roca', 'Volador', 'ani_bw_142.gif', NULL),
(143, 'Snorlax', 'Normal', NULL, 'ani_bw_143.gif', NULL),
(144, 'Articuno', 'Hielo', 'Volador', 'ani_bw_144.gif', NULL),
(145, 'Zapdos', 'Eléctrico', 'Volador', 'ani_bw_145.gif', NULL),
(146, 'Moltres', 'Fuego', 'Volador', 'ani_bw_146.gif', NULL),
(147, 'Dratini', 'Dragón', NULL, 'ani_bw_147.gif', 30),
(148, 'Dragonair', 'Dragón', NULL, 'ani_bw_148.gif', 55),
(149, 'Dragonite', 'Dragón', 'Volador', 'ani_bw_149.gif', NULL),
(150, 'Mewtwo', 'Psíquico', NULL, 'ani_bw_150.gif', NULL),
(151, 'Mew', 'Psíquico', NULL, 'ani_bw_151.gif', NULL);


-- Movimientos de Ataque (Inflije daño al Pokémon rival)
INSERT INTO MOVIMIENTOS (ID_MOVIMIENTO, NOM_MOVIMIENTO, POTENCIA, TIPO, ESTADO, QUITA, PP, MEJORA, CANT_MEJORA, NIVEL_APRENDIZAJE, CATEGORIA) VALUES
(1, 'Pound', 40, 'Normal', 'Físico', NULL, 35, NULL, NULL, 1, 'Ataque'),
(2, 'Karate Chop', 50, 'LUCHA', 'Físico', NULL, 25, NULL, NULL, 1, 'Ataque'),
(4, 'Comet Punch', 18, 'Normal', 'Físico', NULL, 15, NULL, NULL, 1, 'Ataque'),
(5, 'Mega Punch', 80, 'Normal', 'Físico', NULL, 20, NULL, NULL, 1, 'Ataque'),
(6, 'Pay Day', 40, 'Normal', 'Físico', NULL, 20, NULL, NULL, 1, 'Ataque'),
(7, 'Fire Punch', 75, 'FUEGO', 'Físico', NULL, 15, NULL, NULL, 1, 'Ataque'),
(8, 'Ice Punch', 75, 'HIELO', 'Físico', NULL, 15, NULL, NULL, 1, 'Ataque'),
(9, 'Thunder Punch', 75, 'ELÉCTRICO', 'Físico', NULL, 15, NULL, NULL, 1, 'Ataque'),
(10, 'Scratch', 40, 'Normal', 'Físico', NULL, 35, NULL, NULL, 1, 'Ataque');

-- Movimientos de Estado (Alteran el estado del Pokémon enemigo)
INSERT INTO MOVIMIENTOS (ID_MOVIMIENTO, NOM_MOVIMIENTO, POTENCIA, TIPO, ESTADO, QUITA, PP, MEJORA, CANT_MEJORA, NIVEL_APRENDIZAJE, CATEGORIA) VALUES
(3, 'Growl', NULL, 'Normal', 'Estado', NULL, 40, NULL, NULL, 1, 'Estado'),
(12, 'Leer', NULL, 'Normal', 'Estado', NULL, 30, NULL, NULL, 1, 'Estado'),
(14, 'Whirlwind', NULL, 'Normal', 'Estado', NULL, 20, NULL, NULL, 1, 'Estado'),
(15, 'Supersonic', NULL, 'Normal', 'Estado', NULL, 20, NULL, NULL, 1, 'Estado'),
(18, 'Disable', NULL, 'Normal', 'Estado', NULL, 20, NULL, NULL, 1, 'Estado'),
(28, 'Growl', NULL, 'Normal', 'Estado', NULL, 40, NULL, NULL, 1, 'Estado'),
(32, 'Supersonic', NULL, 'Normal', 'Estado', NULL, 20, NULL, NULL, 1, 'Estado'),
(33, 'Confusion', 50, 'PSÍQUICO', 'Special', NULL, 25, NULL, NULL, 1, 'Estado'),
(35, 'Water Gun', 40, 'AGUA', 'Special', NULL, 25, NULL, NULL, 1, 'Estado');

-- Movimientos de Mejora (Alteran una estadística de nuestro Pokémon)
INSERT INTO MOVIMIENTOS (ID_MOVIMIENTO, NOM_MOVIMIENTO, POTENCIA, TIPO, ESTADO, QUITA, PP, MEJORA, CANT_MEJORA, NIVEL_APRENDIZAJE, CATEGORIA) VALUES
(74, 'Swords Dance', NULL, 'Normal', 'Estado', NULL, 30, 'Atk', 2, 1, 'Mejora'),
(75, 'Agility', NULL, 'PSÍQUICO', 'Estado', NULL, 30, 'Speed', 2, 1, 'Mejora'),
(86, 'Minimize', NULL, 'Normal', 'Estado', NULL, 20, 'Evasion', 2, 1, 'Mejora'),
(88, 'Withdraw', NULL, 'AGUA', 'Estado', NULL, 40, 'Defense', 1, 1, 'Mejora'),
(89, 'Defense Curl', NULL, 'Normal', 'Estado', NULL, 40, 'Defense', 1, 1, 'Mejora'),
(90, 'Barrier', NULL, 'PSÍQUICO', 'Estado', NULL, 20, 'Defense', 2, 1, 'Mejora'),
(91, 'Light Screen', NULL, 'PSÍQUICO', 'Estado', NULL, 30, 'Special Defense', 2, 1, 'Mejora'),
(93, 'Reflect', NULL, 'PSÍQUICO', 'Estado', NULL, 20, 'Defense', 2, 1, 'Mejora');


INSERT INTO MOVIMIENTOS_POKEMON (ID_MOVIMIENTO, ID_POKEMON) VALUES
(35, 1),
(88, 1),
(5, 1),
(8, 1),
(35, 2),
(88, 2),
(3, 2),
(4, 2),
(1, 3),
(9, 3),
(10, 3),
(33, 3),
(6, 4),
(7, 4),
(12, 4),
(18, 4),
(88, 5),
(10, 5),
(35, 5),
(6, 5),
(28, 7),
(75, 7),
(90, 7),
(91, 7);



































