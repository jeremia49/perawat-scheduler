-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 14, 2023 at 01:31 AM
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
  `id_row` int NOT NULL,
  `id_perawat` text NOT NULL,
  `nama_perawat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `perawat`
--

INSERT INTO `perawat` (`id_row`, `id_perawat`, `nama_perawat`) VALUES
(1, 'RP', 'Ramadani Pohan'),
(2, 'JN', 'Juniarti Nasution'),
(3, 'WSS', 'Wulan Susanti Sitompul'),
(4, 'ON', 'Oktavia Nela'),
(5, 'TS', 'Tika Siahaan'),
(6, 'SA', 'Siska Aritonang'),
(7, 'DT', 'Darmiani Tambunan'),
(8, 'CS', 'Cristina Simatupang'),
(9, 'TLT', 'Tartonadi L. Tobing'),
(10, 'NS', 'Nelli Simanjuntak'),
(11, 'DS', 'Dinda Saputri'),
(12, 'VP', 'Vengky Pasaribu');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `perawat`
--
ALTER TABLE `perawat`
  ADD PRIMARY KEY (`id_row`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `perawat`
--
ALTER TABLE `perawat`
  MODIFY `id_row` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
