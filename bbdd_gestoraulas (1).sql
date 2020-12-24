-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-12-2020 a las 01:31:42
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bbdd_gestoraulas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE `aulas` (
  `id` int(8) NOT NULL,
  `nombre` varchar(16) COLLATE utf8mb4_spanish_ci NOT NULL,
  `tipo` int(8) NOT NULL,
  `sede` int(8) NOT NULL,
  `capacidad` int(4) NOT NULL,
  `equipo_profesor` int(8) NOT NULL,
  `equipo_alumno` int(8) NOT NULL,
  `equipamiento` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`id`, `nombre`, `tipo`, `sede`, `capacidad`, `equipo_profesor`, `equipo_alumno`, `equipamiento`) VALUES
(1, 'M-001', 4, 1, 14, 1, 1, 5),
(2, 'M-002', 1, 1, 14, 5, 5, 5),
(3, 'M-003', 2, 1, 20, 2, 2, 5),
(4, 'M-004', 3, 1, 10, 4, 4, 4),
(5, 'M-005', 5, 1, 20, 1, 1, 2),
(6, 'M-006', 7, 1, 16, 3, 3, 1),
(11, 'P-001', 1, 2, 10, 5, 5, 5),
(12, 'P-002', 2, 2, 24, 2, 2, 5),
(19, 'P-003', 3, 2, 16, 4, 4, 4),
(20, 'P-004', 4, 2, 16, 1, 1, 1),
(21, 'P-005', 5, 2, 20, 1, 1, 2),
(22, 'P-006', 7, 2, 30, 3, 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipamientos`
--

CREATE TABLE `equipamientos` (
  `id` int(8) NOT NULL,
  `nombre` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL,
  `descripcion` varchar(256) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `equipamientos`
--

INSERT INTO `equipamientos` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Impresora 3D', 'Impresora 3D Creality CR-10S PRO V2'),
(2, 'Plotter', 'HP DesignJet Z9+dr'),
(3, 'Proyector', 'Epson EF-100W'),
(4, 'Servidor BBDD', 'Oracle Exadata Database Machine SL6'),
(5, 'Pantalla 65\"', 'Xiaomi MI TV 4S 4K-UHD Smart TV');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenadores`
--

CREATE TABLE `ordenadores` (
  `id` int(8) NOT NULL,
  `nombre` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL,
  `sistema_operativo` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL,
  `pantalla` int(4) NOT NULL,
  `cpu` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL,
  `ram` int(4) NOT NULL,
  `tarjeta_grafica` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `ordenadores`
--

INSERT INTO `ordenadores` (`id`, `nombre`, `sistema_operativo`, `pantalla`, `cpu`, `ram`, `tarjeta_grafica`) VALUES
(1, 'Apple Mac Pro', 'Mac OS X', 27, 'Intel Xeon E5-1650 v2', 32, 'AMD FirePro D500'),
(2, 'PC HP ProDesk 600 G5', 'Windows 10 Pro 64', 24, ' Intel Core i5-9500', 16, ' Intel UHD 630'),
(3, 'PC OMEN 30L GT13-0017ns', 'Windows 10 Home 64', 24, 'Intel Core i7-10700K', 32, 'NVIDIA GeForce RTX 2080'),
(4, 'HP Z2 Mini G5', 'Windows 10 Pro 64', 27, 'Intel Core i9-9900', 32, 'NVIDIA Quadro T2000'),
(5, 'PC HP ProDesk 400 G6', 'Windows 10 Pro 64', 24, 'Intel Core i7-9700', 16, 'Intel UHD 630');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sedes`
--

CREATE TABLE `sedes` (
  `id` int(8) NOT NULL,
  `nombre` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL,
  `direccion` varchar(256) COLLATE utf8mb4_spanish_ci NOT NULL,
  `codigo_postal` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL,
  `telefono` varchar(32) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `sedes`
--

INSERT INTO `sedes` (`id`, `nombre`, `direccion`, `codigo_postal`, `telefono`) VALUES
(1, 'Maldonado', 'Calle de Maldonado, 48', '28006 Madrid', '+ 34 914 01 07 02'),
(2, 'Povedilla', 'Calle de la Povedilla, 4', '28009 Madrid', '+34 914 35 58 43');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_aulas`
--

CREATE TABLE `tipo_aulas` (
  `id` int(8) NOT NULL,
  `nombre` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tipo_aulas`
--

INSERT INTO `tipo_aulas` (`id`, `nombre`) VALUES
(1, 'Arquitectura'),
(2, 'Programacion'),
(3, 'Big Data'),
(4, 'Animacion'),
(5, 'Diseño'),
(7, 'Produccion');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sede` (`sede`),
  ADD KEY `tipo` (`tipo`),
  ADD KEY `profesor` (`equipo_profesor`),
  ADD KEY `alumno` (`equipo_alumno`),
  ADD KEY `equipamiento` (`equipamiento`);

--
-- Indices de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sedes`
--
ALTER TABLE `sedes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_aulas`
--
ALTER TABLE `tipo_aulas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aulas`
--
ALTER TABLE `aulas`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `sedes`
--
ALTER TABLE `sedes`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_aulas`
--
ALTER TABLE `tipo_aulas`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD CONSTRAINT `aulas_ibfk_1` FOREIGN KEY (`sede`) REFERENCES `sedes` (`id`),
  ADD CONSTRAINT `aulas_ibfk_2` FOREIGN KEY (`tipo`) REFERENCES `tipo_aulas` (`id`),
  ADD CONSTRAINT `aulas_ibfk_3` FOREIGN KEY (`equipamiento`) REFERENCES `equipamientos` (`id`),
  ADD CONSTRAINT `aulas_ibfk_4` FOREIGN KEY (`equipo_profesor`) REFERENCES `ordenadores` (`id`),
  ADD CONSTRAINT `aulas_ibfk_5` FOREIGN KEY (`equipo_alumno`) REFERENCES `ordenadores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
