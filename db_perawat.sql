-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 08, 2023 at 10:49 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perawat`
--

-- --------------------------------------------------------

--
-- Table structure for table `perawat`
--

CREATE TABLE `perawat` (
  `id_perawat` text NOT NULL,
  `nama_perawat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `perawat`
--

INSERT INTO `perawat` (`id_perawat`, `nama_perawat`) VALUES
('1', 'Ramadani Pohan'),
('2', 'Juniarti Nasution'),
('3', 'Wulan Susanti Sitompul'),
('4', 'Oktavia Nela'),
('5', 'Tika Siahaan'),
('6', 'Siska Aritonang'),
('7', 'Darmiani Tambunan'),
('8', 'Cristina Simatupang'),
('9', 'Tartonadi L. Tobing'),
('10', 'Nelli Simanjuntak'),
('11', 'Dinda Saputri'),
('12', 'Vengky Pasaribu');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
