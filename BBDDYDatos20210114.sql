-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-01-2021 a las 17:58:59
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
DROP DATABASE IF EXISTS `bbdd_gestoraulas`;
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

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`id`, `nombre`, `tipo`, `sede`, `capacidad`, `equipo_profesor`, `equipo_alumno`, `equipamiento`) VALUES
(16, 'M001', 1, 1, 16, 3, 3, 5),
(17, 'M002', 2, 1, 20, 4, 4, 4),
(18, 'M003', 1, 1, 24, 3, 3, 5),
(19, 'M004', 2, 1, 12, 7, 7, 4),
(20, 'M005', 2, 1, 16, 8, 8, 3),
(21, 'P001', 1, 2, 24, 3, 3, 5),
(22, 'P002', 1, 2, 18, 3, 3, 4),
(23, 'P003', 2, 2, 20, 6, 6, 2),
(24, 'P004', 2, 2, 16, 7, 7, 2),
(25, 'P005', 2, 2, 16, 4, 4, 5),
(28, 'Pepperoni masa 2', 1, 1, 5, 3, 3, 5);

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
-- Estructura de tabla para la tabla `festivos`
--

CREATE TABLE `festivos` (
  `id` int(8) NOT NULL,
  `nombre` varchar(128) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `festivos`
--

INSERT INTO `festivos` (`id`, `nombre`, `fecha`) VALUES
(1, 'Año nuevo', '2021-01-01'),
(3, 'Dia de Reyes', '2021-01-06'),
(4, 'San Jose', '2021-03-19'),
(5, 'Jueves santo', '2021-04-01'),
(6, 'Fiesta del trabajo', '2021-05-01'),
(7, 'Dia de la comunidad de Madrid', '2021-05-03'),
(8, 'San Isidro', '2021-05-15'),
(9, 'Fiesta nacional Española', '2021-10-12'),
(10, 'Dia de todos los Santos', '2021-11-01'),
(11, 'Dia de la Almudena', '2021-11-09'),
(12, 'Dia de la Constitucion', '2021-12-06'),
(13, 'Inmaculada Concepcion', '2021-12-08'),
(14, 'Navidad', '2021-12-25'),
(15, 'Viernes Santo', '2021-04-02'),
(21, 'Atómica', '2021-01-13'),
(22, 'Atómica', '2021-01-14'),
(23, 'Atómica', '2021-01-15'),
(24, 'Atómica', '2021-01-16'),
(25, 'Atómica', '2021-01-17'),
(26, 'Atómica', '2021-01-18'),
(27, 'Atómica', '2021-01-19'),
(28, 'Atómica', '2021-01-20'),
(29, 'Atómica', '2021-01-21'),
(30, 'Atómica', '2021-01-22');

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
(3, 'Apple Mac Pro', 'Mac OS X', 27, ' Intel Core i5-10500', 32, 'AMD FirePro D500'),
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
  `nombre_curso` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `id_aula` int(8) NOT NULL,
  `fecha_reserva` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id`, `nombre_curso`, `id_aula`, `fecha_reserva`) VALUES
(569, 'Prueba', 16, '2021-02-01 08:00:00'),
(570, 'Prueba', 16, '2021-02-01 09:00:00'),
(571, 'Prueba', 16, '2021-02-01 10:00:00'),
(572, 'Prueba', 16, '2021-02-01 11:00:00'),
(575, 'patatin01', 17, '2021-01-04 08:00:00'),
(576, 'patatin01', 17, '2021-01-04 09:00:00'),
(577, 'patatin01', 17, '2021-01-05 08:00:00'),
(578, 'patatin01', 17, '2021-01-05 09:00:00'),
(579, 'patatin01', 17, '2021-01-11 08:00:00'),
(580, 'patatin01', 17, '2021-01-11 09:00:00'),
(581, 'patatin01', 17, '2021-01-12 08:00:00'),
(582, 'patatin01', 17, '2021-01-12 09:00:00'),
(583, 'patatin01', 17, '2021-01-25 08:00:00'),
(584, 'patatin01', 17, '2021-01-25 09:00:00'),
(585, 'patatin01', 17, '2021-01-26 08:00:00'),
(586, 'patatin01', 17, '2021-01-26 09:00:00'),
(587, 'patatin01', 17, '2021-02-01 08:00:00'),
(588, 'patatin01', 17, '2021-02-01 09:00:00'),
(589, 'patatin01', 17, '2021-02-02 08:00:00'),
(590, 'patatin01', 17, '2021-02-02 09:00:00'),
(591, 'patatin01', 17, '2021-02-08 08:00:00'),
(592, 'patatin01', 17, '2021-02-08 09:00:00'),
(593, 'patatin01', 17, '2021-02-09 08:00:00'),
(594, 'patatin01', 17, '2021-02-09 09:00:00'),
(595, 'patatin01', 17, '2021-02-15 08:00:00'),
(596, 'patatin01', 17, '2021-02-15 09:00:00'),
(597, 'patatin01', 17, '2021-02-16 08:00:00'),
(598, 'patatin01', 17, '2021-02-16 09:00:00'),
(599, 'patatin01', 17, '2021-02-22 08:00:00'),
(600, 'patatin01', 17, '2021-02-22 09:00:00'),
(601, 'patatin01', 17, '2021-02-23 08:00:00'),
(602, 'patatin01', 17, '2021-02-23 09:00:00'),
(603, 'patatin01', 17, '2021-03-01 08:00:00'),
(604, 'patatin01', 17, '2021-03-01 09:00:00'),
(605, 'patatin01', 17, '2021-03-02 08:00:00'),
(606, 'patatin01', 17, '2021-03-02 09:00:00'),
(607, 'patatin01', 17, '2021-03-08 08:00:00'),
(608, 'patatin01', 17, '2021-03-08 09:00:00'),
(609, 'patatin01', 17, '2021-03-09 08:00:00'),
(610, 'patatin01', 17, '2021-03-09 09:00:00'),
(611, 'patatin01', 17, '2021-03-15 08:00:00'),
(612, 'patatin01', 17, '2021-03-15 09:00:00'),
(613, 'patatin01', 17, '2021-03-16 08:00:00'),
(614, 'patatin01', 17, '2021-03-16 09:00:00');

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
(1, 'Maldonado', 'Calle de Maldonado, 48', '28006 Madrid', '+34 914 01 07 02'),
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
(1, 'Mac'),
(2, 'Windows');

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
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `festivos`
--
ALTER TABLE `festivos`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=615;

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
