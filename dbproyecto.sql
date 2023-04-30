-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 30-04-2023 a las 17:52:51
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectofinaldb`
--
CREATE DATABASE IF NOT EXISTS `proyectofinaldb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `proyectofinaldb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registros`
--

CREATE TABLE `registros` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `edad` int(11) NOT NULL,
  `genero` varchar(45) NOT NULL,
  `documento` int(11) NOT NULL,
  `tipoDoc` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `registros`
--

INSERT INTO `registros` (`id`, `nombre`, `apellido`, `edad`, `genero`, `documento`, `tipoDoc`) VALUES
(1, 'Samuel', 'Tarazona', 19, 'Masculino', 12312312, 'cc'),
(2, 'Samuel', 'Tarazona', 15, 'masculino', 1478546521, 'T.I.'),
(3, 'Dani', 'Tarazona', 12, 'masculino', 155845654, 'T.I.'),
(5, 'koki', 'Tarazona', 60, 'masculino', 58484515, 'C.C.'),
(6, 'Sandra', 'Arciniegas', 49, 'femenino', 52081196, 'C.C.'),
(7, 'Sandra', 'Arciniegas', 19, 'femenino', 1478546521, 'C.C.'),
(8, 'Dani', 'Tarazona', 7, 'masculino', 48845584, 'T.I.'),
(9, 'Nico', 'Tarazona', 26, 'masculino', 4866248, 'C.C.'),
(10, 'Maria', 'Martinez', 12, 'femenino', 5886664, 'T.I.');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `registros`
--
ALTER TABLE `registros`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `registros`
--
ALTER TABLE `registros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
