-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-12-2020 a las 17:47:31
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
(1, 'M-001', 4, 1, 14, 1, 1, 5);

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
(1, 'Apple Mac Pro', 'Mac OS X', 27, 'Intel Xeon E5-1650 v2', 32, 'AMD FirePro D500');

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
  ADD UNIQUE KEY `tipo` (`tipo`),
  ADD UNIQUE KEY `sede` (`sede`) USING BTREE,
  ADD UNIQUE KEY `profesor` (`equipo_profesor`),
  ADD UNIQUE KEY `alumno` (`equipo_alumno`),
  ADD UNIQUE KEY `equipamiento` (`equipamiento`);

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
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  ADD CONSTRAINT `aulas_ibfk_1` FOREIGN KEY (`tipo`) REFERENCES `tipo_aulas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aulas_ibfk_2` FOREIGN KEY (`sede`) REFERENCES `sedes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aulas_ibfk_3` FOREIGN KEY (`equipo_profesor`) REFERENCES `ordenadores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aulas_ibfk_4` FOREIGN KEY (`equipo_alumno`) REFERENCES `ordenadores` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aulas_ibfk_5` FOREIGN KEY (`equipamiento`) REFERENCES `equipamientos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
