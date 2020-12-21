-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-12-2020 a las 18:10:53
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.9

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
(0, 'Impresora 3D Creality CR-10S PRO V2', 'La impresora 3D Creality CR-10S PRO V2 ofrece un volumen de impresión 3D de gran formato 30 x 30 x 40 cm');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipamientos`
--
ALTER TABLE `equipamientos`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
