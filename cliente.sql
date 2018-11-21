-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 21-11-2018 a las 10:04:03
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cliente`
--
CREATE DATABASE IF NOT EXISTS `cliente` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cliente`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `uid` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `pin` varchar(4) NOT NULL,
  `nomina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_cuenta`
--

DROP TABLE IF EXISTS `cliente_cuenta`;
CREATE TABLE `cliente_cuenta` (
  `cliente` int(11) NOT NULL,
  `cuenta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
CREATE TABLE `cuenta` (
  `cid` int(11) NOT NULL,
  `nombre` varchar(11) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina`
--

DROP TABLE IF EXISTS `nomina`;
CREATE TABLE `nomina` (
  `nid` int(11) NOT NULL,
  `nombre` varchar(11) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`uid`),
  ADD KEY `nomina` (`nomina`);

--
-- Indices de la tabla `cliente_cuenta`
--
ALTER TABLE `cliente_cuenta`
  ADD KEY `cliente` (`cliente`),
  ADD KEY `cuenta` (`cuenta`);

--
-- Indices de la tabla `cuenta`
--
ALTER TABLE `cuenta`
  ADD KEY `cid` (`cid`);

--
-- Indices de la tabla `nomina`
--
ALTER TABLE `nomina`
  ADD KEY `nid` (`nid`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `rel_cliente_nomina` FOREIGN KEY (`nomina`) REFERENCES `nomina` (`nid`);

--
-- Filtros para la tabla `cliente_cuenta`
--
ALTER TABLE `cliente_cuenta`
  ADD CONSTRAINT `rel_clcuenta_cliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`uid`),
  ADD CONSTRAINT `rel_clcuenta_cuenta` FOREIGN KEY (`cuenta`) REFERENCES `cuenta` (`cid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
