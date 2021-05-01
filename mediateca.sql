-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-05-2021 a las 07:57:08
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mediateca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas`
--

CREATE TABLE `artistas` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `artistas`
--

INSERT INTO `artistas` (`codigo`, `nombre`) VALUES
(1, 'Billie Eilish'),
(2, 'Post Malone'),
(3, 'David Bowie');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cds`
--

CREATE TABLE `cds` (
  `codigo` varchar(8) NOT NULL,
  `titulo` varchar(120) NOT NULL,
  `duracion` int(11) NOT NULL,
  `numero_canciones` int(11) NOT NULL,
  `unidades_disponibles` int(11) NOT NULL,
  `codigo_artista` int(11) NOT NULL,
  `codigo_genero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cds`
--

INSERT INTO `cds` (`codigo`, `titulo`, `duracion`, `numero_canciones`, `unidades_disponibles`, `codigo_artista`, `codigo_genero`) VALUES
('CDA00001', 'Live at Third Man Records', 35, 10, 100, 1, 3),
('CDA00003', 'Space Oddity', 45, 9, 10, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `directores`
--

CREATE TABLE `directores` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `directores`
--

INSERT INTO `directores` (`codigo`, `nombre`) VALUES
(1, 'Hermanos Russo'),
(2, 'J. J. Abrams');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dvds`
--

CREATE TABLE `dvds` (
  `codigo` varchar(8) NOT NULL,
  `titulo` varchar(120) NOT NULL,
  `duracion` int(11) NOT NULL,
  `codigo_director` int(11) NOT NULL,
  `codigo_genero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editoriales`
--

CREATE TABLE `editoriales` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(120) NOT NULL,
  `direccion` varchar(260) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `correo_electronico` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `editoriales`
--

INSERT INTO `editoriales` (`codigo`, `nombre`, `direccion`, `telefono`, `correo_electronico`) VALUES
(1, 'Editorial 1', NULL, NULL, NULL),
(2, 'Editorial 2', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

CREATE TABLE `generos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(120) NOT NULL,
  `descripcion` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `generos`
--

INSERT INTO `generos` (`codigo`, `nombre`, `descripcion`) VALUES
(1, 'Rock', NULL),
(2, 'Rap', NULL),
(3, 'Pop', NULL),
(4, 'Accion', NULL),
(5, 'Ficcion', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `codigo` varchar(8) NOT NULL,
  `titulo` varchar(120) NOT NULL,
  `autor` varchar(120) NOT NULL,
  `numero_paginas` int(11) NOT NULL,
  `ISBN` varchar(60) NOT NULL,
  `anio_publicacion` year(4) NOT NULL,
  `unidades_disponibles` int(11) NOT NULL,
  `codigo_editorial` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`codigo`, `titulo`, `autor`, `numero_paginas`, `ISBN`, `anio_publicacion`, `unidades_disponibles`, `codigo_editorial`) VALUES
('LIB00001', 'Libro 1', 'Autor 1', 400, 'ISBN0001', 2001, 123, 1),
('LIB00002', 'Libro 2 Cool', 'Autor 2', 400, 'ISBN0002', 2009, 50, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revistas`
--

CREATE TABLE `revistas` (
  `codigo` varchar(8) NOT NULL,
  `titulo` varchar(120) NOT NULL,
  `periodicidad` varchar(120) NOT NULL,
  `fecha_publicacion` date NOT NULL,
  `unidades_disponibles` int(11) NOT NULL,
  `codigo_editorial` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `cds`
--
ALTER TABLE `cds`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `cds_ibfk_1` (`codigo_artista`),
  ADD KEY `cds_ibfk_2` (`codigo_genero`);

--
-- Indices de la tabla `directores`
--
ALTER TABLE `directores`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `dvds`
--
ALTER TABLE `dvds`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `dvds_ibfk_1` (`codigo_director`),
  ADD KEY `dvds_ibfk_2` (`codigo_genero`);

--
-- Indices de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `generos`
--
ALTER TABLE `generos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `libros_ibfk_1` (`codigo_editorial`);

--
-- Indices de la tabla `revistas`
--
ALTER TABLE `revistas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `revistas_ibfk_1` (`codigo_editorial`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `artistas`
--
ALTER TABLE `artistas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `directores`
--
ALTER TABLE `directores`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `generos`
--
ALTER TABLE `generos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cds`
--
ALTER TABLE `cds`
  ADD CONSTRAINT `cds_ibfk_1` FOREIGN KEY (`codigo_artista`) REFERENCES `artistas` (`codigo`),
  ADD CONSTRAINT `cds_ibfk_2` FOREIGN KEY (`codigo_genero`) REFERENCES `generos` (`codigo`);

--
-- Filtros para la tabla `dvds`
--
ALTER TABLE `dvds`
  ADD CONSTRAINT `dvds_ibfk_1` FOREIGN KEY (`codigo_director`) REFERENCES `directores` (`codigo`),
  ADD CONSTRAINT `dvds_ibfk_2` FOREIGN KEY (`codigo_genero`) REFERENCES `generos` (`codigo`);

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`codigo_editorial`) REFERENCES `editoriales` (`codigo`);

--
-- Filtros para la tabla `revistas`
--
ALTER TABLE `revistas`
  ADD CONSTRAINT `revistas_ibfk_1` FOREIGN KEY (`codigo_editorial`) REFERENCES `editoriales` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
