-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2021 a las 04:43:37
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
  `id_autor` int(11) NOT NULL,
  `dni_autor` bigint(20) NOT NULL,
  `nombre_autor` varchar(30) NOT NULL,
  `apellido_autor` varchar(30) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `nacionalidad` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `autor`
--

INSERT INTO `autor` (`id_autor`, `dni_autor`, `nombre_autor`, `apellido_autor`, `fecha_nacimiento`, `nacionalidad`) VALUES
(171, 123, 'nom1', 'ape1', '1950-01-01', 'Argentino'),
(172, 345, 'nom2', 'ape2', '1951-01-01', 'Argentina'),
(173, 678, 'nom3', 'ape3', '1952-01-01', 'Arg'),
(174, 30000000, 'Echo', 'Terrell', '1964-12-12', 'Albania'),
(175, 30000002, 'Abigail', 'Sosa', '1982-02-16', 'Nauru'),
(176, 30000004, 'Vance', 'Jackson', '1960-08-20', 'Mali'),
(177, 30000006, 'Harper', 'Mccray', '1974-04-18', 'American Samoa'),
(178, 30000008, 'Emery', 'Wynn', '1993-02-28', 'Virgin Islands, United States'),
(179, 30000010, 'McKenzie', 'Wilkinson', '1995-04-25', 'Djibouti'),
(180, 30000012, 'Dara', 'Goodwin', '1987-11-30', 'Syria'),
(181, 30000014, 'Joshua', 'Small', '1973-07-21', 'Philippines'),
(182, 30000016, 'Thane', 'Freeman', '1964-03-04', 'Saint Lucia'),
(183, 30000018, 'Noel', 'Gilliam', '1995-04-24', 'Maldives'),
(184, 30000020, 'Olga', 'Randolph', '1956-04-12', 'Hungary'),
(185, 30000022, 'Grant', 'Mcdonald', '1966-03-10', 'French Polynesia'),
(186, 30000024, 'Tucker', 'Acosta', '1975-07-08', 'Cameroon'),
(187, 30000026, 'Aline', 'Porter', '1984-07-26', 'Dominican Republic'),
(188, 30000028, 'Bevis', 'Joseph', '1967-02-24', 'Virgin Islands, British'),
(189, 30000030, 'Urielle', 'Harper', '1984-07-27', 'South Sudan'),
(190, 30000032, 'Damian', 'Richmond', '1966-03-01', 'Bolivia'),
(191, 30000034, 'Samantha', 'Tyler', '1985-12-07', 'Trinidad and Tobago'),
(192, 30000036, 'Paul', 'Rodriguez', '1974-06-26', 'Uganda'),
(193, 30000038, 'Dylan', 'Woods', '1983-09-02', 'Svalbard and Jan Mayen Islands'),
(194, 30000040, 'Kennedy', 'Levy', '1972-05-18', 'Tanzania'),
(195, 30000042, 'Stuart', 'Emerson', '1970-05-07', 'Macedonia'),
(196, 30000044, 'Kermit', 'Barnes', '1959-11-30', 'Sudan'),
(197, 30000046, 'Callum', 'Vaughan', '1973-03-14', 'Yemen'),
(198, 30000048, 'Ralph', 'Mccoy', '1965-04-23', 'India'),
(199, 30000050, 'Hadassah', 'Gardner', '1999-03-02', 'Iran'),
(200, 30000052, 'Unity', 'Cole', '1953-12-28', 'Montenegro'),
(201, 30000054, 'Minerva', 'Peters', '1993-07-18', 'Monaco'),
(202, 30000056, 'Abdul', 'Tanner', '1977-09-25', 'Colombia'),
(203, 30000058, 'Sacha', 'Logan', '1983-02-14', 'Antarctica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `id_ejemplar` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`id_ejemplar`, `id_libro`, `estado`) VALUES
(3, 2, 3),
(4, 2, 0),
(5, 3, 0),
(6, 4, 1),
(7, 4, 1),
(8, 4, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector`
--

CREATE TABLE `lector` (
  `id_lector` int(11) NOT NULL,
  `nombre_lector` varchar(20) NOT NULL,
  `apellido_lector` varchar(20) NOT NULL,
  `dni_lector` bigint(20) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lector`
--

INSERT INTO `lector` (`id_lector`, `nombre_lector`, `apellido_lector`, `dni_lector`, `estado`) VALUES
(1, 'Kevin', 'Paredes', 32456789, 0),
(2, 'Lautaro', 'Saucedo', 34456789, 0),
(3, 'Bruno', 'Sturniolo', 44456789, 0),
(4, 'Leandro', 'Weber', 54456789, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id_libro` int(11) NOT NULL,
  `id_autor` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `editorial` varchar(25) NOT NULL,
  `año` int(11) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `isbn` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id_libro`, `id_autor`, `nombre`, `editorial`, `año`, `tipo`, `isbn`) VALUES
(2, 176, 'Las Maravillas', 'no tengo idea', 1960, 'fantasia', 1),
(3, 176, 'cara sucia', 'las gallinas', 2021, 'agricultura', 2),
(4, 175, 'patricio', 'las gallinas', 2021, 'agricultura', 3),
(5, 174, 'sqlParaGiles', 'Info para Dummies', 1980, 'educativa', 5),
(6, 174, 'enim. Nunc ut', 'lectus', 2019, 'non,', 6),
(7, 171, 'aliquam arcu. Aliqua', 'elit, pharetra', 1977, 'semper', 7),
(8, 185, 'ornare placerat, orc', 'quis turpis vitae', 1991, 'est,', 8),
(9, 171, 'sit amet', 'Vivamus', 1991, 'nec,', 9),
(10, 177, 'pede blandit congue.', 'Vivamus nibh', 1955, 'pede,', 10),
(11, 179, 'mattis', 'tincidunt tempus risus.', 1975, 'arcu.', 11),
(12, 188, 'ut mi.', 'ornare. In faucibus.', 1984, 'vehicula', 12),
(13, 171, 'et netus et', 'sit amet,', 1982, 'a,', 13),
(14, 184, 'felis purus ac tellu', 'nisi.', 1989, 'Quisque', 14),
(15, 178, 'sit amet massa.', 'nunc, ullamcorper', 1990, 'vel', 15),
(16, 190, 'Nullam velit dui, se', 'elit, dictum eu,', 2001, 'Integer', 16),
(17, 172, 'ipsum. Suspendisse s', 'ante.', 2006, 'sit', 17),
(18, 186, 'nulla. In tincidunt ', 'libero et tristique', 2000, 'gravida.', 18),
(19, 171, 'iaculis', 'semper, dui lectus', 2000, 'mauris,', 19),
(20, 185, 'at auctor ullamcorpe', 'libero est, congue', 1979, 'massa.', 20),
(21, 183, 'quam. Curabitur vel ', 'facilisis non, bibendum', 1977, 'nec', 21),
(22, 173, 'quis, pede. Suspendi', 'sed', 2010, 'massa.', 22),
(23, 182, 'Vivamus nibh', 'Sed nunc', 1957, 'lacinia', 23),
(24, 174, 'hendrerit. Donec por', 'lacinia at, iaculis', 1957, 'gravida', 24),
(25, 183, 'justo sit amet nulla', 'magna sed dui.', 1989, 'facilisis', 25);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multa`
--

CREATE TABLE `multa` (
  `id_multa` int(11) NOT NULL,
  `id_lector` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `multa`
--

INSERT INTO `multa` (`id_multa`, `id_lector`, `fecha_inicio`, `fecha_fin`) VALUES
(1, 4, '2021-05-21', '2051-05-21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id_prestamo` int(11) NOT NULL,
  `id_ejemplar` int(11) NOT NULL,
  `id_lector` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_devolucion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`id_prestamo`, `id_ejemplar`, `id_lector`, `fecha`, `estado`, `fecha_devolucion`) VALUES
(5, 4, 2, '2021-05-27', 1, NULL),
(6, 6, 3, '2021-05-10', 0, '2021-05-26'),
(7, 5, 3, '2021-04-08', 1, NULL),
(8, 6, 2, '2021-01-27', 1, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `autor`
--
ALTER TABLE `autor`
  ADD PRIMARY KEY (`id_autor`),
  ADD UNIQUE KEY `dni` (`dni_autor`);

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
  ADD PRIMARY KEY (`id_lector`),
  ADD UNIQUE KEY `dni_lector` (`dni_lector`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id_libro`),
  ADD UNIQUE KEY `isbn` (`isbn`),
  ADD UNIQUE KEY `isbn_2` (`isbn`),
  ADD KEY `publica` (`id_autor`);

--
-- Indices de la tabla `multa`
--
ALTER TABLE `multa`
  ADD PRIMARY KEY (`id_multa`),
  ADD KEY `deuda` (`id_lector`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`id_prestamo`),
  ADD KEY `id_lector` (`id_lector`),
  ADD KEY `id_ejemplar` (`id_ejemplar`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `autor`
--
ALTER TABLE `autor`
  MODIFY `id_autor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=204;

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `id_ejemplar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `lector`
--
ALTER TABLE `lector`
  MODIFY `id_lector` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id_libro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `multa`
--
ALTER TABLE `multa`
  MODIFY `id_multa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id_prestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `tiene` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`);

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `publica` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`);

--
-- Filtros para la tabla `multa`
--
ALTER TABLE `multa`
  ADD CONSTRAINT `deuda` FOREIGN KEY (`id_lector`) REFERENCES `lector` (`id_lector`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`id_lector`) REFERENCES `lector` (`id_lector`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplar` (`id_ejemplar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
