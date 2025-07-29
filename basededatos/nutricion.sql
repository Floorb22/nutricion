-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 29-07-2025 a las 21:29:29
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nutricion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `codComida` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipoComida` varchar(100) NOT NULL,
  `caloriasPor100g` int(11) NOT NULL,
  `detalle` varchar(100) NOT NULL,
  `baja` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`codComida`, `nombre`, `tipoComida`, `caloriasPor100g`, `detalle`, `baja`) VALUES
(2, 'Yogur con cereales', 'Desayuno', 140, 'Yogur y cereal', 1),
(3, 'Tostadas con palta y huevo', 'Desayuno', 300, 'Tostadas, palta y huevo', 1),
(4, 'Cafe con galletas de limón', 'Desayuno', 100, 'Cafe y galletas', 1),
(5, 'Licuado de frutas', 'Desayuno', 130, 'Frutas', 1),
(6, 'Barrita de cereal', 'Snack', 350, 'Cereal', 1),
(7, 'Manzana', 'Snack', 52, 'Manzana', 1),
(8, 'Yogur griego', 'Snack', 100, 'Yogur', 1),
(9, 'Frutos secos', 'Snack', 160, 'Frutos secos', 1),
(10, 'Tostadas con mermelada', 'Merienda', 250, 'Tostadas', 1),
(11, 'Cafe y medialunas', 'Merienda', 280, 'Cafe y facturas', 1),
(12, 'Te y budin', 'Merienda', 180, 'Te y budin', 1),
(13, 'Ensalada de frutas', 'Merienda', 100, 'Frutas', 1),
(14, 'Arroz con pollo', 'Almuerzo', 363, 'Cuenta con arroz, pollo, cebolla y pimiento', 1),
(15, 'Milanesa con púre', 'Almuerzo', 550, 'La milanesa puede ser de carne o pollo con púre de verdura', 1),
(16, 'Tarta de verduras', 'Almuerzo', 350, 'Puede ser de zapallo o acelga', 1),
(17, 'Pollo al horno con ensalada', 'Almuerzo', 400, 'Pollo y ensaladas verdes', 1),
(18, 'Huevo revuelto con verduras salteadas', 'Cena', 250, 'Huevo y verduras', 1),
(19, 'Sopa de verduras', 'Cena', 150, 'Verduras con caldo', 1),
(20, 'Filet de merluza con ensalada', 'Cena', 300, 'Pescado y ensaladas', 1),
(21, 'Hamburguesa con púre', 'Cena', 500, 'La hamburguesa puede ser de carne o pollo con puré de verduras', 1),
(26, 'Ñoquis', 'Almuerzo', 500, 'Ñoquis con salsa roja o salsa blanca', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `codDieta` int(11) NOT NULL,
  `nombreDieta` varchar(100) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `pesoFinal` float NOT NULL,
  `totalCalorias` int(11) NOT NULL,
  `nroPaciente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`codDieta`, `nombreDieta`, `fechaInicio`, `fechaFin`, `pesoFinal`, `totalCalorias`, `nroPaciente`) VALUES
(2, 'Baja en calorías', '2025-02-15', '2025-05-30', 70, 1900, 2),
(4, 'Descenso moderado', '2025-07-07', '2025-09-15', 68, 1800, 8),
(5, 'Tonificación', '2025-06-02', '2025-10-06', 78, 2200, 9),
(6, 'Peso saludable', '2025-05-05', '2025-07-07', 63, 2000, 12),
(7, 'Reducción intensiva', '2025-07-07', '2025-08-20', 85, 1700, 11),
(8, 'Bienestar', '2025-05-12', '2025-07-14', 75, 2100, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudiario`
--

CREATE TABLE `menudiario` (
  `codMenu` int(11) NOT NULL,
  `diaNro` int(11) NOT NULL,
  `estado` tinyint(4) NOT NULL,
  `codDieta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menudiario`
--

INSERT INTO `menudiario` (`codMenu`, `diaNro`, `estado`, `codDieta`) VALUES
(1, 1, 1, 2),
(2, 2, 1, 2),
(3, 3, 1, 2),
(4, 4, 1, 2),
(5, 1, 1, 8),
(6, 2, 1, 8),
(7, 3, 1, 8),
(8, 1, 1, 6),
(9, 2, 1, 6),
(10, 3, 1, 6),
(11, 4, 1, 6),
(12, 5, 1, 6),
(13, 6, 1, 6),
(14, 1, 1, 4),
(15, 2, 1, 4),
(16, 3, 1, 4),
(17, 1, 1, 4),
(18, 2, 1, 4),
(19, 3, 1, 4),
(20, 4, 1, 4),
(21, 5, 1, 4),
(22, 6, 1, 4),
(23, 1, 1, 4),
(24, 2, 1, 4),
(25, 3, 1, 4),
(26, 4, 1, 4),
(27, 5, 1, 4),
(28, 6, 1, 4),
(29, 7, 1, 4),
(30, 1, 1, 5),
(31, 2, 1, 5),
(32, 3, 1, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `nroPaciente` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `edad` int(11) NOT NULL,
  `altura` float NOT NULL,
  `pesoActual` float NOT NULL,
  `pesoBuscado` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`nroPaciente`, `nombre`, `edad`, `altura`, `pesoActual`, `pesoBuscado`) VALUES
(2, 'Antonella', 19, 1.68, 69, 70),
(5, 'Flavia', 45, 1.68, 72.2, 65),
(7, 'Laura', 45, 1.6, 74, 64),
(8, 'Valentina', 29, 1.68, 83, 68.5),
(9, 'Martin', 42, 1.74, 92, 78),
(10, 'Camila', 23, 1.6, 58, 53),
(11, 'Julian', 35, 1.81, 102.5, 85),
(12, 'Lucia', 31, 1.7, 63, 63),
(13, 'Tomas', 27, 1.76, 75, 72),
(14, 'Romina', 38, 1.64, 80, 66),
(15, 'Ezequiel', 46, 1.79, 95, 82);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `renglondemenu`
--

CREATE TABLE `renglondemenu` (
  `nroRenglon` int(11) NOT NULL,
  `codComida` int(11) NOT NULL,
  `codMenu` int(11) NOT NULL,
  `cantidadGrs` double NOT NULL,
  `subtotalCalorias` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `renglondemenu`
--

INSERT INTO `renglondemenu` (`nroRenglon`, `codComida`, `codMenu`, `cantidadGrs`, `subtotalCalorias`) VALUES
(46, 2, 1, 100, 140),
(47, 15, 1, 100, 550),
(48, 9, 1, 100, 160),
(49, 11, 1, 100, 280),
(50, 19, 1, 100, 150),
(51, 4, 2, 100, 100),
(52, 17, 2, 100, 400),
(53, 7, 2, 100, 52),
(54, 10, 2, 100, 250),
(55, 19, 2, 100, 150),
(56, 3, 3, 100, 300),
(57, 17, 3, 100, 400),
(58, 6, 3, 100, 350),
(59, 12, 3, 100, 180),
(60, 19, 3, 100, 150),
(61, 2, 4, 100, 140),
(62, 16, 4, 100, 350),
(63, 6, 4, 100, 350),
(64, 11, 4, 100, 280),
(65, 20, 4, 100, 300),
(66, 4, 5, 100, 100),
(67, 26, 5, 100, 500),
(68, 6, 5, 100, 350),
(69, 12, 5, 100, 180),
(70, 21, 5, 100, 500),
(71, 3, 6, 100, 300),
(72, 26, 6, 100, 500),
(73, 8, 6, 100, 100),
(74, 13, 6, 100, 100),
(75, 18, 6, 100, 250),
(76, 2, 7, 100, 140),
(77, 17, 7, 100, 400),
(78, 7, 7, 100, 52),
(79, 10, 7, 100, 250),
(80, 20, 7, 100, 300),
(81, 5, 8, 100, 130),
(82, 16, 8, 100, 350),
(83, 7, 8, 100, 52),
(84, 13, 8, 100, 100),
(85, 20, 8, 100, 300),
(86, 3, 9, 100, 300),
(87, 26, 9, 100, 500),
(88, 8, 9, 100, 100),
(89, 12, 9, 100, 180),
(90, 18, 9, 100, 250),
(91, 5, 10, 100, 130),
(92, 17, 10, 100, 400),
(93, 9, 10, 100, 160),
(94, 12, 10, 100, 180),
(95, 19, 10, 100, 150),
(96, 2, 11, 100, 140),
(97, 16, 11, 100, 350),
(98, 9, 11, 100, 160),
(99, 13, 11, 100, 100),
(100, 20, 11, 100, 300),
(101, 4, 12, 100, 100),
(102, 15, 12, 100, 550),
(103, 9, 12, 100, 160),
(104, 11, 12, 100, 280),
(105, 21, 12, 100, 500),
(106, 14, 14, 100, 363),
(107, 21, 14, 100, 500),
(108, 17, 14, 100, 400),
(109, 15, 14, 100, 550),
(110, 15, 14, 100, 550),
(111, 21, 15, 100, 500),
(112, 21, 15, 100, 500),
(113, 21, 15, 100, 500),
(114, 21, 15, 100, 500),
(115, 14, 15, 100, 363),
(116, 17, 16, 100, 400),
(117, 14, 16, 100, 363),
(118, 14, 16, 100, 363),
(119, 14, 16, 100, 363),
(120, 14, 16, 100, 363),
(121, 21, 17, 100, 500),
(122, 17, 17, 100, 400),
(123, 15, 17, 100, 550),
(124, 17, 17, 100, 400),
(125, 17, 17, 100, 400),
(126, 17, 18, 100, 400),
(127, 15, 18, 100, 550),
(128, 15, 18, 100, 550),
(129, 20, 18, 100, 300),
(130, 15, 18, 100, 550),
(131, 14, 19, 100, 363),
(132, 15, 19, 100, 550),
(133, 17, 19, 100, 400),
(134, 17, 19, 100, 400),
(135, 14, 19, 100, 363),
(136, 21, 20, 100, 500),
(137, 15, 20, 100, 550),
(138, 20, 20, 100, 300),
(139, 17, 20, 100, 400),
(140, 15, 20, 100, 550),
(141, 21, 21, 100, 500),
(142, 17, 21, 100, 400),
(143, 17, 21, 100, 400),
(144, 17, 21, 100, 400),
(145, 20, 21, 100, 300),
(146, 20, 22, 100, 300),
(147, 15, 22, 100, 550),
(148, 17, 22, 100, 400),
(149, 21, 22, 100, 500),
(150, 21, 22, 100, 500),
(151, 15, 23, 100, 550),
(152, 17, 23, 100, 400),
(153, 8, 23, 100, 100),
(154, 2, 23, 100, 140),
(155, 14, 23, 100, 363),
(156, 20, 24, 100, 300),
(157, 20, 24, 100, 300),
(158, 8, 24, 100, 100),
(159, 2, 24, 100, 140),
(160, 14, 24, 100, 363),
(161, 15, 25, 100, 550),
(162, 8, 25, 100, 100),
(163, 21, 25, 100, 500),
(164, 8, 25, 100, 100),
(165, 20, 25, 100, 300),
(166, 8, 26, 100, 100),
(167, 8, 26, 100, 100),
(168, 14, 26, 100, 363),
(169, 17, 26, 100, 400),
(170, 21, 26, 100, 500),
(171, 20, 27, 100, 300),
(172, 14, 27, 100, 363),
(173, 17, 27, 100, 400),
(174, 17, 27, 100, 400),
(175, 17, 27, 100, 400),
(176, 2, 28, 100, 140),
(177, 15, 28, 100, 550),
(178, 20, 28, 100, 300),
(179, 17, 28, 100, 400),
(180, 14, 28, 100, 363),
(181, 2, 29, 100, 140),
(182, 21, 29, 100, 500),
(183, 2, 29, 100, 140),
(184, 17, 29, 100, 400),
(185, 8, 29, 100, 100),
(186, 18, 30, 100, 250),
(187, 3, 30, 100, 300),
(188, 18, 30, 100, 250),
(189, 20, 30, 100, 300),
(190, 17, 30, 100, 400),
(191, 17, 31, 100, 400),
(192, 17, 31, 100, 400),
(193, 17, 31, 100, 400),
(194, 18, 31, 100, 250),
(195, 17, 31, 100, 400),
(196, 18, 32, 100, 250),
(197, 18, 32, 100, 250),
(198, 20, 32, 100, 300),
(199, 3, 32, 100, 300),
(200, 20, 32, 100, 300);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`codComida`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`codDieta`),
  ADD KEY `nroPaciente` (`nroPaciente`);

--
-- Indices de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD PRIMARY KEY (`codMenu`),
  ADD KEY `codDieta` (`codDieta`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`nroPaciente`);

--
-- Indices de la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  ADD PRIMARY KEY (`nroRenglon`),
  ADD KEY `codComida` (`codComida`),
  ADD KEY `codMenu` (`codMenu`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `codComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `codDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `codMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `nroPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  MODIFY `nroRenglon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`nroPaciente`) REFERENCES `paciente` (`nroPaciente`);

--
-- Filtros para la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD CONSTRAINT `menudiario_ibfk_1` FOREIGN KEY (`codDieta`) REFERENCES `dieta` (`codDieta`);

--
-- Filtros para la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  ADD CONSTRAINT `renglondemenu_ibfk_1` FOREIGN KEY (`codComida`) REFERENCES `comida` (`codComida`),
  ADD CONSTRAINT `renglondemenu_ibfk_2` FOREIGN KEY (`codMenu`) REFERENCES `menudiario` (`codMenu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
