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


-- Inserts de los 151 Pokémon de la generación 1 en la tabla POKEMON
INSERT INTO POKEMON (ID_USER, NUM_POKEDEX, MOTE, CAJA, ATAQUE, AT_ESPECIAL, DEFENSA, DEF_ESPECIAL, VELOCIDAD, NIVEL, FERTILIDAD, SEXO, ESTADO, EXPERIENCIA, VITALIDAD, ID_OBJETO) VALUES
(1, 1, NULL, 0, 49, 65, 49, 65, 45, 5, 70, 'M', 'Saludable', 0, 100, NULL),
(1, 2, NULL, 1, 62, 80, 63, 80, 60, 16, 70, 'M', 'Saludable', 0, 100, NULL);



--INSERT POKEDEX
INSERT INTO POKEDEX (NUM_POKEDEX, NOM_POKEMON, TIPO1, TIPO2, IMAGEN, NIVEL_EVOLUCION) VALUES
(1, 'Bulbasaur', 'Planta', 'Veneno', 'ani_bw_1.gif', 16),
(2, 'Ivysaur', 'Planta', 'Veneno', 'ani_bw_2.gif', 32),
(3, 'Venusaur', 'Planta', 'Veneno', 'ani_bw_3.gif', NULL),
(4, 'Charmander', 'Fuego', NULL, 'ani_bw_4.gif', 16),
(5, 'Charmeleon', 'Fuego', NULL, 'ani_bw_5.gif', 36),
(6, 'Charizard', 'Fuego', 'Volador', 'ani_bw_6.gif', NULL),
(7, 'Squirtle', 'Agua', NULL, 'ani_bw_7.gif', 16),
(8, 'Wartortle', 'Agua', NULL, 'ani_bw_8.gif', 36),
(9, 'Blastoise', 'Agua', NULL, 'ani_bw_9.gif', NULL),
(10, 'Caterpie', 'Bicho', NULL, 'ani_bw_10.gif', 7),
(11, 'Metapod', 'Bicho', NULL, 'ani_bw_11.gif', 10),
(12, 'Butterfree', 'Bicho', 'Volador', 'ani_bw_12.gif', NULL),
(13, 'Weedle', 'Bicho', 'Veneno', 'ani_bw_13.gif', 7),
(14, 'Kakuna', 'Bicho', 'Veneno', 'ani_bw_14.gif', 10),
(15, 'Beedrill', 'Bicho', 'Veneno', 'ani_bw_15.gif', NULL),
(16, 'Pidgey', 'Normal', 'Volador', 'ani_bw_16.gif', 18),
(17, 'Pidgeotto', 'Normal', 'Volador', 'ani_bw_17.gif', 36),
(18, 'Pidgeot', 'Normal', 'Volador', 'ani_bw_18.gif', NULL),
(19, 'Rattata', 'Normal', NULL, 'ani_bw_19.gif', 20),
(20, 'Raticate', 'Normal', NULL, 'ani_bw_20.gif', NULL),
(21, 'Spearow', 'Normal', 'Volador', 'ani_bw_21.gif', 20),
(22, 'Fearow', 'Normal', 'Volador', 'ani_bw_22.gif', NULL),
(23, 'Ekans', 'Veneno', NULL, 'ani_bw_23.gif', 22),
(24, 'Arbok', 'Veneno', NULL, 'ani_bw_24.gif', NULL),
(25, 'Pikachu', 'Eléctrico', NULL, 'ani_bw_25.gif', 22),
(26, 'Raichu', 'Eléctrico', NULL, 'ani_bw_26.gif', NULL),
(27, 'Sandshrew', 'Tierra', NULL, 'ani_bw_27.gif', 22),
(28, 'Sandslash', 'Tierra', NULL, 'ani_bw_28.gif', NULL),
(29, 'Nidoran♀', 'Veneno', NULL, 'ani_bw_29.gif', 16),
(30, 'Nidorina', 'Veneno', NULL, 'ani_bw_30.gif', 36),
(31, 'Nidoqueen', 'Veneno', 'Tierra', 'ani_bw_31.gif', NULL),
(32, 'Nidoran♂', 'Veneno', NULL, 'ani_bw_32.gif', 16),
(33, 'Nidorino', 'Veneno', NULL, 'ani_bw_33.gif', 36),
(34, 'Nidoking', 'Veneno', 'Tierra', 'ani_bw_34.gif', NULL),
(35, 'Clefairy', 'Hada', NULL, 'ani_bw_35.gif', 36),
(36, 'Clefable', 'Hada', NULL, 'ani_bw_36.gif', NULL),
(37, 'Vulpix', 'Fuego', NULL, 'ani_bw_37.gif', 24),
(38, 'Ninetales', 'Fuego', NULL, 'ani_bw_38.gif', NULL),
(39, 'Jigglypuff', 'Normal', 'Hada', 'ani_bw_39.gif', 36),
(40, 'Wigglytuff', 'Normal', 'Hada', 'ani_bw_40.gif', NULL),
(41, 'Zubat', 'Veneno', 'Volador', 'ani_bw_41.gif', 22),
(42, 'Golbat', 'Veneno', 'Volador', 'ani_bw_42.gif', NULL),
(43, 'Oddish', 'Planta', 'Veneno', 'ani_bw_43.gif', 21),
(44, 'Gloom', 'Planta', 'Veneno', 'ani_bw_44.gif', 21),
(45, 'Vileplume', 'Planta', 'Veneno', 'ani_bw_45.gif', NULL),
(46, 'Paras', 'Bicho', 'Planta', 'ani_bw_46.gif', 24),
(47, 'Parasect', 'Bicho', 'Planta', 'ani_bw_47.gif', NULL),
(48, 'Venonat', 'Bicho', 'Veneno', 'ani_bw_48.gif', 31),
(49, 'Venomoth', 'Bicho', 'Veneno', 'ani_bw_49.gif', NULL),
(50, 'Diglett', 'Tierra', NULL, 'ani_bw_50.gif', 26),
(51, 'Dugtrio', 'Tierra', NULL, 'ani_bw_51.gif', NULL),
(52, 'Meowth', 'Normal', NULL, 'ani_bw_52.gif', 28),
(53, 'Persian', 'Normal', NULL, 'ani_bw_53.gif', NULL),
(54, 'Psyduck', 'Agua', NULL, 'ani_bw_54.gif', 33),
(55, 'Golduck', 'Agua', NULL, 'ani_bw_55.gif', NULL),
(56, 'Mankey', 'Lucha', NULL, 'ani_bw_56.gif', 28),
(57, 'Primeape', 'Lucha', NULL, 'ani_bw_57.gif', NULL),
(58, 'Growlithe', 'Fuego', NULL, 'ani_bw_58.gif', 36),
(59, 'Arcanine', 'Fuego', NULL, 'ani_bw_59.gif', NULL),
(60, 'Poliwag', 'Agua', NULL, 'ani_bw_60.gif', 25),
(61, 'Poliwhirl', 'Agua', NULL, 'ani_bw_61.gif', 36),
(62, 'Poliwrath', 'Agua', 'Lucha', 'ani_bw_62.gif', NULL),
(63, 'Abra', 'Psíquico', NULL, 'ani_bw_63.gif', 16),
(64, 'Kadabra', 'Psíquico', NULL, 'ani_bw_64.gif', 36),
(65, 'Alakazam', 'Psíquico', NULL, 'ani_bw_65.gif', NULL),
(66, 'Machop', 'Lucha', NULL, 'ani_bw_66.gif', 28),
(67, 'Machoke', 'Lucha', NULL, 'ani_bw_67.gif', 36),
(68, 'Machamp', 'Lucha', NULL, 'ani_bw_68.gif', NULL),
(69, 'Bellsprout', 'Planta', 'Veneno', 'ani_bw_69.gif', 21),
(70, 'Weepinbell', 'Planta', 'Veneno', 'ani_bw_70.gif', 21),
(71, 'Victreebel', 'Planta', 'Veneno', 'ani_bw_71.gif', NULL),
(72, 'Tentacool', 'Agua', 'Veneno', 'ani_bw_72.gif', 30),
(73, 'Tentacruel', 'Agua', 'Veneno', 'ani_bw_73.gif', NULL),
(74, 'Geodude', 'Roca', 'Tierra', 'ani_bw_74.gif', 25),
(75, 'Graveler', 'Roca', 'Tierra', 'ani_bw_75.gif', 36),
(76, 'Golem', 'Roca', 'Tierra', 'ani_bw_76.gif', NULL),
(77, 'Ponyta', 'Fuego', NULL, 'ani_bw_77.gif', 40),
(78, 'Rapidash', 'Fuego', NULL, 'ani_bw_78.gif', NULL),
(79, 'Slowpoke', 'Agua', 'Psíquico', 'ani_bw_79.gif', 37),
(80, 'Slowbro', 'Agua', 'Psíquico', 'ani_bw_80.gif', NULL),
(81, 'Magnemite', 'Eléctrico', 'Acero', 'ani_bw_81.gif', 30),
(82, 'Magneton', 'Eléctrico', 'Acero', 'ani_bw_82.gif', NULL),
(83, 'Farfetch\'d', 'Normal', 'Volador', 'ani_bw_83.gif', NULL),
(84, 'Doduo', 'Normal', 'Volador', 'ani_bw_84.gif', 31),
(85, 'Dodrio', 'Normal', 'Volador', 'ani_bw_85.gif', NULL),
(86, 'Seel', 'Agua', NULL, 'ani_bw_86.gif', 34),
(87, 'Dewgong', 'Agua', 'Hielo', 'ani_bw_87.gif', NULL),
(88, 'Grimer', 'Veneno', NULL, 'ani_bw_88.gif', 38),
(89, 'Muk', 'Veneno', NULL, 'ani_bw_89.gif', NULL),
(90, 'Shellder', 'Agua', NULL, 'ani_bw_90.gif', 35),
(91, 'Cloyster', 'Agua', 'Hielo', 'ani_bw_91.gif', NULL),
(92, 'Gastly', 'Fantasma', 'Veneno', 'ani_bw_92.gif', 25),
(93, 'Haunter', 'Fantasma', 'Veneno', 'ani_bw_93.gif', 36),
(94, 'Gengar', 'Fantasma', 'Veneno', 'ani_bw_94.gif', NULL),
(95, 'Onix', 'Roca', 'Tierra', 'ani_bw_95.gif', NULL),
(96, 'Drowzee', 'Psíquico', NULL, 'ani_bw_96.gif', 26),
(97, 'Hypno', 'Psíquico', NULL, 'ani_bw_97.gif', NULL),
(98, 'Krabby', 'Agua', NULL, 'ani_bw_98.gif', 28),
(99, 'Kingler', 'Agua', NULL, 'ani_bw_99.gif', NULL),
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
(120, 'Staryu', 'Agua', NULL, 'ani_bw_120.gif', 36),
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
(133, 'Eevee', 'Normal', NULL, 'ani_bw_133.gif', 36),
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







































