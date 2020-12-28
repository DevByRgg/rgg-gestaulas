-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-12-2020 a las 15:47:53
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
  `id` int(11) NOT NULL,
  `id_sede` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `ocupada` tinyint(4) NOT NULL,
  `equipo_profe` int(11) NOT NULL,
  `equipo_alumno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `aulas`
--

INSERT INTO `aulas` (`id`, `id_sede`, `capacidad`, `ocupada`, `equipo_profe`, `equipo_alumno`) VALUES
(1, 1, 15, 0, 1, 1),
(2, 1, 12, 0, 2, 2),
(3, 1, 17, 0, 2, 2);

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
(1, 'Impresora 3D Creality CR-10S PRO V2', 'La impresora 3D Creality CR-10S PRO V2 ofrece un volumen de impresión 3D de gran formato 30 x 30 x 40 cm'),
(2, 'Impresora laser hp monocromo', 'Impresora en red para impresión de documentos'),
(3, 'Proyector', 'Proyector para diapositivas ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenadores`
--

CREATE TABLE `ordenadores` (
  `tipo` int(11) NOT NULL,
  `nombre` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `sistema_operativo` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `dimension_pantalla` int(11) NOT NULL,
  `cpu` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `ram` int(11) NOT NULL,
  `hdd` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `tarjeta_grafica` varchar(64) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `observaciones` varchar(300) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `ordenadores`
--

INSERT INTO `ordenadores` (`tipo`, `nombre`, `sistema_operativo`, `dimension_pantalla`, `cpu`, `ram`, `hdd`, `tarjeta_grafica`, `observaciones`) VALUES
(1, 'Diseño Grafico', 'Mac OS X', 27, 'Intel I7 11632 - 8 cores - 16 threads', 64, 'ssd 1Tb nvme', 'nvidia Quadro Fx5500', 'Esto es una prueba y pongo lo que quiero'),
(2, 'Programacion Windows', 'Windows 10 pro', 24, 'Intel Core I7', 16, '2 Terabytes', 'Nvidia GTX 1600 3GB', 'Aplicaciones instaladas: IDES de programación: Eclipse, NetBeans');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `relacion_aula_equipamientos`
--

CREATE TABLE `relacion_aula_equipamientos` (
  `id_sede` int(11) NOT NULL,
  `id_aula` int(11) NOT NULL,
  `id_equipamiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `relacion_aula_equipamientos`
--

INSERT INTO `relacion_aula_equipamientos` (`id_sede`, `id_aula`, `id_equipamiento`) VALUES
(1, 1, 1),
(1, 1, 3),
(1, 3, 3);

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
(1, 'Maldonado', 'Calle de Maldonado, 48', '28006 Madrid', '914 01 07 02');

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
  ADD KEY `id_sede` (`id_sede`),
  ADD KEY `equipo_profe` (`equipo_profe`),
  ADD KEY `equipo_alumno` (`equipo_alumno`);

--
-- Indices de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  ADD PRIMARY KEY (`tipo`);

--
-- Indices de la tabla `relacion_aula_equipamientos`
--
ALTER TABLE `relacion_aula_equipamientos`
  ADD PRIMARY KEY (`id_sede`,`id_aula`,`id_equipamiento`) USING BTREE,
  ADD KEY `id_sede` (`id_sede`),
  ADD KEY `id_aula` (`id_aula`),
  ADD KEY `id_equipamiento` (`id_equipamiento`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  MODIFY `tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sedes`
--
ALTER TABLE `sedes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  ADD CONSTRAINT `aulas_ibfk_1` FOREIGN KEY (`id_sede`) REFERENCES `sedes` (`id`),
  ADD CONSTRAINT `aulas_ibfk_2` FOREIGN KEY (`equipo_profe`) REFERENCES `ordenadores` (`tipo`),
  ADD CONSTRAINT `aulas_ibfk_3` FOREIGN KEY (`equipo_alumno`) REFERENCES `ordenadores` (`tipo`);

--
-- Filtros para la tabla `relacion_aula_equipamientos`
--
ALTER TABLE `relacion_aula_equipamientos`
  ADD CONSTRAINT `relacion_aula_equipamientos_ibfk_1` FOREIGN KEY (`id_sede`) REFERENCES `sedes` (`id`),
  ADD CONSTRAINT `relacion_aula_equipamientos_ibfk_2` FOREIGN KEY (`id_aula`) REFERENCES `aulas` (`id`),
  ADD CONSTRAINT `relacion_aula_equipamientos_ibfk_3` FOREIGN KEY (`id_equipamiento`) REFERENCES `equipamientos` (`id`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_admin`) REFERENCES `administradores` (`id`),
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`id_aula`) REFERENCES `aulas` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id`) REFERENCES `administradores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
