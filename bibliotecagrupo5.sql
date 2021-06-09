-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2021 a las 09:53:21
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bibliotecagrupo5`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE `autor` (
  `dni_autor` int(10) NOT NULL,
  `nombre_autor` varchar(50) NOT NULL,
  `apellido_autor` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `nacionalidad` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`dni_autor`, `nombre_autor`, `apellido_autor`, `fecha_nacimiento`, `nacionalidad`) VALUES
(123, 'nom1', 'ape1', '1950-01-01', 'Argentina'),
(345, 'nom2', 'ape2', '1951-01-01', 'Argentina'),
(678, 'nom3', 'ape3', '1952-01-01', 'Argentina'),
(30000000, 'Echo', 'Terrell', '1964-12-12', 'Albania'),
(30000002, 'Abigail', 'Sosa', '1982-02-16', 'Nauru'),
(30000004, 'Vance', 'Jackson', '1960-08-20', 'Mali'),
(30000006, 'Harper', 'Mccray', '1974-04-18', 'American Samoa'),
(30000008, 'Emery', 'Wynn', '1993-02-28', 'Virgin Islands, United States'),
(30000010, 'McKenzie', 'Wilkinson', '1995-04-25', 'Djibouti'),
(30000012, 'Dara', 'Goodwin', '1987-11-30', 'Syria'),
(30000014, 'Joshua', 'Small', '1973-07-21', 'Philippines'),
(30000016, 'Thane', 'Freeman', '1964-03-04', 'Saint Lucia'),
(30000018, 'Noel', 'Gilliam', '1995-04-24', 'Maldives'),
(30000020, 'Olga', 'Randolph', '1956-04-12', 'Hungary'),
(30000022, 'Grant', 'Mcdonald', '1966-03-10', 'French Polynesia'),
(30000024, 'Tucker', 'Acosta', '1975-07-08', 'Cameroon'),
(30000026, 'Aline', 'Porter', '1984-07-26', 'Dominican Republic'),
(30000028, 'Bevis', 'Joseph', '1967-02-24', 'Virgin Islands, British'),
(30000030, 'Urielle', 'Harper', '1984-07-27', 'South Sudan'),
(30000032, 'Damian', 'Richmond', '1966-03-01', 'Bolivia'),
(30000034, 'Samantha', 'Tyler', '1985-12-07', 'Trinidad and Tobago'),
(30000036, 'Paul', 'Rodriguez', '1974-06-26', 'Uganda'),
(30000038, 'Dylan', 'Woods', '1983-09-02', 'Svalbard and Jan Mayen Islands'),
(30000040, 'Kennedy', 'Levy', '1972-05-18', 'Tanzania'),
(30000042, 'Stuart', 'Emerson', '1970-05-07', 'Macedonia'),
(30000044, 'Kermit', 'Barnes', '1959-11-30', 'Sudan'),
(30000046, 'Callum', 'Vaughan', '1973-03-14', 'Yemen'),
(30000048, 'Ralph', 'Mccoy', '1965-04-23', 'India'),
(30000050, 'Hadassah', 'Gardner', '1999-03-02', 'Iran'),
(30000052, 'Unity', 'Cole', '1953-12-28', 'Montenegro'),
(30000054, 'Minerva', 'Peters', '1993-07-18', 'Monaco'),
(30000056, 'Abdul', 'Tanner', '1977-09-25', 'Colombia'),
(30000058, 'Sacha', 'Logan', '1983-02-14', 'Antarctica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `id_ejemplar` int(10) NOT NULL,
  `id_libro` int(10) NOT NULL,
  `estado` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`id_ejemplar`, `id_libro`, `estado`) VALUES
(9, 25, 2),
(10, 26, 2),
(11, 19, 2),
(12, 9, 0),
(13, 13, 1),
(14, 25, 1),
(15, 4, 1),
(16, 11, 3),
(17, 9, 1),
(18, 17, 2),
(19, 27, 1),
(20, 24, 1),
(21, 8, 1),
(22, 18, 1),
(23, 29, 1),
(24, 8, 1),
(25, 10, 1),
(26, 16, 3),
(27, 1, 3),
(28, 2, 1),
(29, 4, 1),
(30, 26, 1),
(31, 18, 3),
(32, 28, 2),
(33, 11, 1),
(34, 21, 2),
(35, 4, 1),
(36, 4, 3),
(37, 4, 3),
(38, 7, 2),
(39, 25, 1),
(40, 11, 3),
(41, 16, 1),
(42, 28, 1),
(43, 9, 1),
(44, 25, 1),
(45, 24, 1),
(46, 28, 1),
(47, 14, 3),
(48, 26, 3),
(49, 26, 3),
(50, 18, 1),
(51, 6, 3),
(52, 14, 2),
(53, 18, 1),
(54, 9, 1),
(55, 9, 1),
(56, 12, 3),
(57, 10, 3),
(58, 2, 3),
(59, 14, 1),
(60, 26, 0),
(61, 13, 0),
(62, 17, 0),
(63, 1, 3),
(64, 21, 0),
(65, 14, 0),
(66, 26, 0),
(67, 15, 0),
(68, 15, 0),
(69, 4, 0),
(70, 17, 0),
(71, 14, 0),
(72, 22, 0),
(73, 30, 0),
(74, 21, 0),
(75, 15, 0),
(76, 17, 0),
(77, 21, 0),
(78, 1, 0),
(79, 24, 0),
(80, 9, 0),
(81, 6, 0),
(82, 24, 0),
(83, 12, 0),
(84, 2, 0),
(85, 14, 0),
(86, 3, 0),
(87, 30, 0),
(88, 21, 0),
(89, 15, 0),
(90, 9, 0),
(91, 30, 0),
(92, 19, 0),
(93, 14, 0),
(94, 16, 0),
(95, 20, 0),
(96, 4, 0),
(97, 9, 0),
(98, 29, 0),
(99, 21, 0),
(100, 22, 0),
(101, 18, 0),
(102, 30, 0),
(103, 26, 0),
(104, 17, 0),
(105, 16, 0),
(106, 10, 0),
(107, 4, 0),
(108, 15, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector`
--

CREATE TABLE `lector` (
  `dni_lector` int(10) NOT NULL,
  `nombre_lector` varchar(50) NOT NULL,
  `apellido_lector` varchar(50) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lector`
--

INSERT INTO `lector` (`dni_lector`, `nombre_lector`, `apellido_lector`, `estado`) VALUES
(2000, 'Azalia', 'Webster', 1),
(2001, 'Jack', 'Shepherd', 1),
(2002, 'Driscoll', 'Christian', 1),
(2003, 'Nicole', 'Flores', 1),
(2004, 'Basia', 'Dixon', 1),
(2005, 'Hall', 'Alvarado', 1),
(2006, 'Leah', 'Hardy', 1),
(2007, 'Florence', 'Collier', 1),
(2008, 'Brock', 'Day', 1),
(2009, 'Winifred', 'Thompson', 1),
(2010, 'Lester', 'Cohen', 1),
(2011, 'Holmes', 'Luna', 1),
(2012, 'Nora', 'Padilla', 1),
(2013, 'Cole', 'Langley', 1),
(2014, 'Basil', 'Pennington', 1),
(2015, 'Margaret', 'Huffman', 1),
(2016, 'Emery', 'Pruitt', 1),
(2017, 'Nadine', 'Hammond', 1),
(2018, 'Otto', 'Cochran', 1),
(2019, 'Cleo', 'Reynolds', 1),
(2020, 'Brendan', 'Maynard', 1),
(2021, 'Gillian', 'Calderon', 1),
(2022, 'Shaine', 'Peters', 1),
(2023, 'April', 'Moon', 1),
(2024, 'Christen', 'Bailey', 1),
(2025, 'Daquan', 'Moon', 1),
(2026, 'Leo', 'Pena', 1),
(2027, 'Jaquelyn', 'Richard', 1),
(2028, 'Mark', 'Robbins', 1),
(2029, 'Veronica', 'Nash', 1),
(2030, 'Zelenia', 'Kramer', 1),
(2031, 'Cora', 'Rivas', 1),
(2032, 'Orlando', 'Everett', 1),
(2033, 'Caesar', 'Ross', 1),
(2034, 'Randall', 'Cooley', 1),
(2035, 'Lionel', 'Mooney', 1),
(2036, 'Daquan', 'Mendoza', 1),
(2037, 'Cherokee', 'Flynn', 1),
(2038, 'Calvin', 'Fowler', 1),
(2039, 'Brian', 'Gaines', 1),
(2040, 'Dane', 'Hahn', 1),
(2041, 'Inga', 'Francis', 1),
(2042, 'Justina', 'Alexander', 1),
(2043, 'Nita', 'Ball', 1),
(2044, 'Alec', 'Hebert', 1),
(2045, 'Allegra', 'Holman', 1),
(2046, 'Norman', 'Stevenson', 1),
(2047, 'Garrett', 'Hudson', 1),
(2048, 'Anika', 'Zimmerman', 1),
(2049, 'Serina', 'Burton', 1),
(2050, 'Isaiah', 'Allen', 1),
(2051, 'Harriet', 'Armstrong', 1),
(2052, 'Abraham', 'Dodson', 1),
(2053, 'Haviva', 'Phillips', 1),
(2054, 'Desiree', 'Woodard', 1),
(2055, 'Farrah', 'Saunders', 1),
(2056, 'Demetrius', 'Thompson', 1),
(2057, 'Dominique', 'Mcdaniel', 1),
(2058, 'Harlan', 'Morton', 1),
(2059, 'Belle', 'Dyer', 1),
(2060, 'Yoshi', 'Caldwell', 1),
(2061, 'Erica', 'Bullock', 1),
(2062, 'Maite', 'Shaw', 1),
(2063, 'Trevor', 'Becker', 1),
(2064, 'Fallon', 'Sears', 1),
(2065, 'Melanie', 'Lane', 1),
(2066, 'Zachery', 'Rose', 1),
(2067, 'Adele', 'Sosa', 1),
(2068, 'Martina', 'Skinner', 1),
(2069, 'Coby', 'Velasquez', 1),
(2070, 'Jonas', 'Hoover', 1),
(2071, 'Cadman', 'Frazier', 1),
(2072, 'Griffin', 'Head', 1),
(2073, 'Xenos', 'Douglas', 1),
(2074, 'Kaitlin', 'Jennings', 1),
(2075, 'Xenos', 'Rodriguez', 1),
(2076, 'Jaden', 'Mcdonald', 1),
(2077, 'Ezekiel', 'Howe', 1),
(2078, 'Quin', 'Hobbs', 1),
(2079, 'Constance', 'Wade', 1),
(2080, 'Hasad', 'Norman', 1),
(2081, 'Diana', 'Santiago', 1),
(2082, 'Venus', 'Frazier', 1),
(2083, 'Veda', 'Franco', 1),
(2084, 'Austin', 'Guerra', 1),
(2085, 'Phelan', 'Williams', 1),
(2086, 'Cheryl', 'Walker', 1),
(2087, 'Josephine', 'Richmond', 1),
(2088, 'Taylor', 'Case', 1),
(2089, 'Christian', 'Merrill', 1),
(2090, 'Althea', 'Lee', 1),
(2091, 'Tallulah', 'Bell', 1),
(2092, 'Yvonne', 'Weiss', 1),
(2093, 'Blair', 'Powell', 1),
(2094, 'Brian', 'Ryan', 1),
(2095, 'Nash', 'Hernandez', 1),
(2096, 'Katell', 'Pate', 1),
(2097, 'Odessa', 'Mckay', 1),
(2098, 'Charity', 'Bright', 1),
(2099, 'Odysseus', 'Nguyen', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `isbn` int(10) NOT NULL,
  `id_autor` int(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `editorial` varchar(50) NOT NULL,
  `año` int(10) NOT NULL,
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`isbn`, `id_autor`, `nombre`, `editorial`, `año`, `tipo`) VALUES
(1, 30000000, 'Donec vitae', 'Jenkins', 1956, 'informatica'),
(2, 30000002, 'nec ante blandit viverra. Donec tempus,', 'Atkins', 1963, 'informatica'),
(3, 30000004, 'Donec fringilla.', 'Johnson', 1962, 'historia'),
(4, 30000006, 'eu metus.', 'Hancock', 1958, 'ingenieria'),
(5, 30000008, 'diam', 'Farrell', 1974, 'literatura'),
(6, 30000010, 'fringilla cursus purus.', 'Garner', 1966, 'literatura'),
(7, 30000012, 'Mauris nulla. Integer urna. Vivamus molestie', 'Carter', 1977, 'matematica'),
(8, 30000014, 'molestie tellus. Aenean egestas hendrerit', 'Hopper', 1999, 'informatica'),
(9, 30000016, 'nunc nulla vulputate dui,', 'Vincent', 1969, 'medicina'),
(10, 30000018, 'cubilia Curae; Donec tincidunt. Donec vitae', 'Howell', 1984, 'medicina'),
(11, 30000020, 'purus', 'Malone', 1979, 'matematica'),
(12, 30000022, 'eu dolor egestas rhoncus. Proin nisl', 'Mooney', 1986, 'informatica'),
(13, 30000024, 'semper', 'Dixon', 1978, 'matematica'),
(14, 30000026, 'eleifend nec, malesuada', 'Mayer', 1955, 'ingenieria'),
(15, 30000028, 'ultricies ligula. Nullam enim. Sed', 'Spears', 1958, 'informatica'),
(16, 30000030, 'odio tristique pharetra. Quisque ac libero', 'Alvarez', 1963, 'informatica'),
(17, 30000032, 'Aliquam nec enim. Nunc ut', 'Hodge', 1956, 'historia'),
(18, 30000034, 'at fringilla purus mauris a', 'Bailey', 1962, 'informatica'),
(19, 30000036, 'pulvinar arcu et pede.', 'Huff', 1953, 'informatica'),
(20, 30000038, 'sed consequat auctor, nunc', 'Weeks', 1993, 'informatica'),
(21, 30000040, 'ut mi. Duis', 'Jarvis', 1966, 'literatura'),
(22, 30000042, 'volutpat ornare, facilisis eget,', 'Rosales', 1993, 'informatica'),
(23, 30000044, 'tristique pharetra.', 'Duffy', 1967, 'matematica'),
(24, 30000046, 'facilisis eget, ipsum.', 'Jackson', 1991, 'informatica'),
(25, 30000048, 'in sodales elit erat vitae', 'Terrell', 1964, 'ingenieria'),
(26, 30000050, 'ultrices', 'Gallagher', 1952, 'historia'),
(27, 30000052, 'vitae, sodales at, velit. Pellentesque', 'Pickett', 1959, 'informatica'),
(28, 30000054, 'risus. Donec egestas. Duis', 'Morton', 1993, 'historia'),
(29, 30000056, 'eleifend non, dapibus', 'Chase', 1967, 'matematica'),
(30, 30000058, 'Nunc mauris elit, dictum', 'Booker', 1999, 'historia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multa`
--

CREATE TABLE `multa` (
  `id_multa` int(10) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id_prestamo` int(10) NOT NULL,
  `id_lector` int(10) NOT NULL,
  `id_multa` int(10) DEFAULT NULL,
  `id_ejemplar` int(10) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id_prestamo`, `id_lector`, `id_multa`, `id_ejemplar`, `fecha_inicio`, `fecha_fin`) VALUES
(2, 2000, NULL, 10, '2021-06-01', '2021-06-02'),
(3, 2000, NULL, 11, '2021-05-31', '2021-06-03'),
(4, 2059, NULL, 12, '2021-06-03', NULL),
(5, 2090, NULL, 13, '2021-05-11', '2021-05-19'),
(6, 2026, NULL, 14, '2021-05-03', '2021-06-01'),
(7, 2075, NULL, 15, '2021-05-07', '2021-06-01'),
(11, 2058, NULL, 19, '2021-05-10', '2021-06-07'),
(12, 2076, NULL, 20, '2021-05-08', '2021-06-07'),
(13, 2048, NULL, 21, '2021-05-09', '2021-06-02'),
(15, 2032, NULL, 23, '2021-05-05', '2021-06-04'),
(16, 2028, NULL, 24, '2021-05-04', '2021-06-02'),
(17, 2011, NULL, 25, '2021-05-10', '2021-06-08'),
(20, 2076, NULL, 28, '2021-05-08', '2021-06-03'),
(21, 2087, NULL, 29, '2021-05-09', '2021-06-08'),
(22, 2041, NULL, 30, '2021-05-10', '2021-06-04'),
(25, 2086, NULL, 33, '2021-05-04', '2021-06-03'),
(27, 2098, NULL, 35, '2021-05-08', '2021-06-04'),
(30, 2098, NULL, 38, '2021-05-07', '2021-06-06'),
(35, 2097, NULL, 43, '2021-05-09', '2021-06-06'),
(36, 2075, NULL, 44, '2021-05-07', '2021-06-01'),
(39, 2047, NULL, 47, '2021-05-09', '2021-06-01'),
(40, 2067, NULL, 48, '2021-05-06', '2021-06-03'),
(41, 2093, NULL, 49, '2021-05-08', '2021-06-07'),
(43, 2004, NULL, 51, '2021-05-05', '2021-06-04'),
(44, 2025, NULL, 52, '2021-05-04', '2021-06-01'),
(45, 2037, NULL, 53, '2021-05-04', '2021-06-01'),
(46, 2059, NULL, 54, '2021-05-08', '2021-06-03'),
(49, 2049, NULL, 57, '2021-05-08', '2021-06-03'),
(103, 2009, NULL, 60, '2021-05-08', NULL),
(104, 2013, NULL, 61, '2021-05-10', NULL),
(105, 2040, NULL, 62, '2021-05-09', NULL),
(106, 2008, NULL, 63, '2021-05-04', '2021-05-20'),
(107, 2073, NULL, 64, '2021-05-10', NULL),
(108, 2000, NULL, 65, '2021-05-07', NULL),
(109, 2099, NULL, 66, '2021-05-08', NULL),
(110, 2038, NULL, 67, '2021-05-09', NULL),
(111, 2022, NULL, 68, '2021-05-06', NULL),
(112, 2099, NULL, 69, '2021-05-04', NULL),
(113, 2062, NULL, 70, '2021-05-02', NULL),
(114, 2010, NULL, 71, '2021-05-10', NULL),
(115, 2058, NULL, 72, '2021-05-04', NULL),
(116, 2082, NULL, 73, '2021-05-04', NULL),
(117, 2022, NULL, 74, '2021-05-08', NULL),
(118, 2048, NULL, 75, '2021-05-01', NULL),
(119, 2087, NULL, 76, '2021-05-01', NULL),
(120, 2058, NULL, 77, '2021-05-06', NULL),
(121, 2052, NULL, 78, '2021-05-09', NULL),
(122, 2059, NULL, 79, '2021-05-05', NULL),
(123, 2044, NULL, 80, '2021-05-04', NULL),
(124, 2028, NULL, 81, '2021-05-08', NULL),
(125, 2060, NULL, 82, '2021-05-01', NULL),
(126, 2094, NULL, 83, '2021-05-02', NULL),
(127, 2007, NULL, 84, '2021-05-10', NULL),
(128, 2080, NULL, 85, '2021-05-05', NULL),
(129, 2023, NULL, 86, '2021-05-05', NULL),
(130, 2059, NULL, 87, '2021-05-08', NULL),
(131, 2034, NULL, 88, '2021-05-10', NULL),
(132, 2073, NULL, 89, '2021-05-02', NULL),
(133, 2034, NULL, 90, '2021-05-10', NULL),
(134, 2061, NULL, 91, '2021-05-08', NULL),
(135, 2058, NULL, 92, '2021-05-07', NULL),
(136, 2075, NULL, 93, '2021-05-01', NULL),
(137, 2034, NULL, 94, '2021-05-03', NULL),
(138, 2081, NULL, 95, '2021-05-05', NULL),
(139, 2016, NULL, 96, '2021-05-05', NULL),
(140, 2077, NULL, 97, '2021-05-10', NULL),
(141, 2083, NULL, 98, '2021-05-08', NULL),
(142, 2018, NULL, 99, '2021-05-03', NULL),
(143, 2069, NULL, 100, '2021-05-09', NULL),
(144, 2074, NULL, 101, '2021-05-01', NULL),
(145, 2053, NULL, 102, '2021-05-05', NULL),
(146, 2073, NULL, 103, '2021-05-07', NULL),
(147, 2016, NULL, 104, '2021-05-06', NULL),
(148, 2013, NULL, 105, '2021-05-07', NULL),
(149, 2012, NULL, 106, '2021-05-05', NULL),
(150, 2067, NULL, 107, '2021-05-01', NULL),
(151, 2020, NULL, 108, '2021-05-09', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`dni_autor`);

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`id_ejemplar`),
  ADD KEY `tiene` (`id_libro`);

--
-- Indices de la tabla `lector`
--
ALTER TABLE `lector`
  ADD PRIMARY KEY (`dni_lector`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `id_autor` (`id_autor`);

--
-- Indices de la tabla `multa`
--
ALTER TABLE `multa`
  ADD PRIMARY KEY (`id_multa`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id_prestamo`),
  ADD KEY `id_multa` (`id_multa`),
  ADD KEY `id_ejemplar` (`id_ejemplar`),
  ADD KEY `id_lector` (`id_lector`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `id_ejemplar` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;

--
-- AUTO_INCREMENT de la tabla `multa`
--
ALTER TABLE `multa`
  MODIFY `id_multa` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id_prestamo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=152;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`isbn`);

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`dni_autor`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`id_multa`) REFERENCES `multa` (`id_multa`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplar` (`id_ejemplar`),
  ADD CONSTRAINT `prestamo_ibfk_3` FOREIGN KEY (`id_lector`) REFERENCES `lector` (`dni_lector`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
