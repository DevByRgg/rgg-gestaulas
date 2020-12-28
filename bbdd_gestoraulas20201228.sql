-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-12-2020 a las 10:09:23
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
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `id` int(11) NOT NULL,
  `user` varchar(30) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(30) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

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

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`id`, `nombre`, `tipo`, `sede`, `capacidad`, `equipo_profesor`, `equipo_alumno`, `equipamiento`) VALUES
(4, 'M-001', 1, 1, 14, 5, 5, 5),
(5, 'M-002', 2, 1, 10, 4, 4, 3),
(6, 'M-003', 3, 1, 16, 7, 7, 5),
(7, 'M-004', 4, 1, 16, 3, 3, 4),
(8, 'M-005', 5, 1, 16, 3, 3, 5),
(9, 'M-006', 6, 1, 24, 8, 8, 5),
(10, 'P-001', 1, 2, 16, 5, 5, 5),
(11, 'P-002', 2, 2, 16, 4, 4, 3),
(12, 'P-003', 3, 2, 16, 7, 7, 5),
(13, 'P-004', 4, 2, 16, 3, 3, 4),
(14, 'P-005', 5, 2, 16, 6, 6, 5),
(15, 'P-006', 6, 2, 16, 8, 8, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipamientos`
--

CREATE TABLE `equipamientos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(128) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `descripcion` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `equipamientos`
--

INSERT INTO `equipamientos` (`id`, `nombre`, `descripcion`) VALUES
(2, 'Impresora laser hp monocromo', 'Impresora en red para impresión de documentos'),
(3, 'Proyector', 'Proyector para diapositivas '),
(4, 'Impresora 3D', '3D Creality CR-10S PRO V2'),
(5, 'Pantalla 65\"', 'Xiaomi MI TV 4S 4K-UHD Smart TV');

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

--
-- Volcado de datos para la tabla `ordenadores`
--

INSERT INTO `ordenadores` (`id`, `nombre`, `sistema_operativo`, `pantalla`, `cpu`, `ram`, `tarjeta_grafica`) VALUES
(3, 'Apple Mac Pro', 'Mac OS X', 27, ' Intel Core i5-9500', 32, 'AMD FirePro D500'),
(4, 'HP Z2 Mini G5', 'Windows 10 Pro 64', 24, 'Intel Core i7-9700', 16, ' Intel UHD 630'),
(5, 'PC HP ProDesk 400 G6', 'Windows 10 Pro 64', 24, ' Intel Core i5-9500', 16, ' Intel UHD 630'),
(6, 'PC HP ProDesk 600 G5', 'Windows 10 Pro 64', 24, 'Intel Core i7-10700K', 32, 'AMD FirePro D500'),
(7, 'PC HP Z4 G4', 'Windows 10 Pro 64', 27, 'Intel Core i9-9900', 64, 'nvidia Quadro Fx5500'),
(8, 'PC OMEN 30L GT13-0017ns', 'Windows 10 Pro 64', 24, 'Intel Xeon E5-1650 v2', 64, 'NVIDIA GeForce RTX 2080');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `id_aula` int(11) NOT NULL,
  `id_admin` int(11) NOT NULL,
  `dia_inicio` date NOT NULL,
  `dia_fin` date NOT NULL,
  `hora_inicio` date NOT NULL,
  `hora_fin` date NOT NULL
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

--
-- Volcado de datos para la tabla `sedes`
--

INSERT INTO `sedes` (`id`, `nombre`, `direccion`, `cp`, `tlf`) VALUES
(1, 'Maldonado', 'Calle de Maldonado, 48', '28006 Madrid', '914 01 07 02'),
(2, 'Povedilla', 'Calle de la Povedilla, 4', '28009 Madrid', '+34 914 35 58 43');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_aulas`
--

CREATE TABLE `tipo_aulas` (
  `id` int(11) NOT NULL,
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
(6, 'Produccion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(70) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`id`);

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
-- Indices de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_admin` (`id_admin`),
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
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `aulas`
--
ALTER TABLE `aulas`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sedes`
--
ALTER TABLE `sedes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_aulas`
--
ALTER TABLE `tipo_aulas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
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
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `administradores` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id`) REFERENCES `administradores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
