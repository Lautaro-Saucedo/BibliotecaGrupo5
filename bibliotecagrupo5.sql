-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-06-2021 a las 06:53:09
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
(123, 'nom1', 'ape1', '1950-01-01', 'Argentino'),
(345, 'nom2', 'ape2', '1951-01-01', 'Argentina'),
(678, 'nom3', 'ape3', '1952-01-01', 'Arg'),
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multa`
--

CREATE TABLE `multa` (
  `id_multa` int(10) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `id_prestamo` int(10) NOT NULL,
  `id_lector` int(10) NOT NULL,
  `id_multa` int(10) NOT NULL DEFAULT -1,
  `id_ejemplar` int(10) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  MODIFY `id_ejemplar` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `multa`
--
ALTER TABLE `multa`
  MODIFY `id_multa` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `id_prestamo` int(10) NOT NULL AUTO_INCREMENT;

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
