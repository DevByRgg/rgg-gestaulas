-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-01-2021 a las 17:55:04
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.5

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
CREATE DATABASE IF NOT EXISTS `bbdd_gestoraulas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci;
USE `bbdd_gestoraulas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE `aulas` (
  `id` int(8) NOT NULL,
  `nombre` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `tipo` int(8) NOT NULL,
  `sede` int(8) NOT NULL,
  `capacidad` int(8) NOT NULL,
  `equipo_profesor` int(8) NOT NULL,
  `equipo_alumno` int(8) NOT NULL,
  `equipamiento` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipamientos`
--

CREATE TABLE `equipamientos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(128) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `descripcion` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `festivos`
--

CREATE TABLE `festivos` (
  `id` int(8) NOT NULL,
  `nombre` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenadores`
--

CREATE TABLE `ordenadores` (
  `id` int(8) NOT NULL,
  `nombre` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `sistema_operativo` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `pantalla` int(8) NOT NULL,
  `cpu` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `ram` int(4) NOT NULL,
  `tarjeta_grafica` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `nombre_curso` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `id_aula` int(8) NOT NULL,
  `fecha_reserva` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sedes`
--

CREATE TABLE `sedes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `direccion` varchar(128) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `cp` varchar(16) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `tlf` varchar(16) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_aulas`
--

CREATE TABLE `tipo_aulas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `equipo_profe` (`equipo_profesor`),
  ADD KEY `equipo_alumno` (`equipo_alumno`),
  ADD KEY `tipo` (`tipo`),
  ADD KEY `sede` (`sede`),
  ADD KEY `equipamiento` (`equipamiento`);

--
-- Indices de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `festivos`
--
ALTER TABLE `festivos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `fecha` (`fecha`);

--
-- Indices de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unicos` (`id_aula`,`fecha_reserva`) USING BTREE,
  ADD KEY `id_aula` (`id_aula`);

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
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `festivos`
--
ALTER TABLE `festivos`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sedes`
--
ALTER TABLE `sedes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_aulas`
--
ALTER TABLE `tipo_aulas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD CONSTRAINT `aulas_ibfk_1` FOREIGN KEY (`sede`) REFERENCES `sedes` (`id`),
  ADD CONSTRAINT `aulas_ibfk_3` FOREIGN KEY (`equipo_alumno`) REFERENCES `ordenadores` (`id`),
  ADD CONSTRAINT `aulas_ibfk_4` FOREIGN KEY (`tipo`) REFERENCES `tipo_aulas` (`id`),
  ADD CONSTRAINT `aulas_ibfk_5` FOREIGN KEY (`equipamiento`) REFERENCES `equipamientos` (`id`),
  ADD CONSTRAINT `aulas_ibfk_6` FOREIGN KEY (`equipo_profesor`) REFERENCES `ordenadores` (`id`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_aula`) REFERENCES `aulas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
