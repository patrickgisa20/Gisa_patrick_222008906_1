-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 09:10 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gisa_patrick_r_s_m`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Email` varchar(200) NOT NULL,
  `password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Email`, `password`) VALUES
('admin', 1234),
('fred', 12345),
('gisa', 12345);

-- --------------------------------------------------------

--
-- Table structure for table `bus`
--

CREATE TABLE `bus` (
  `Bus_id` int(11) NOT NULL,
  `Names` varchar(50) NOT NULL,
  `Platenumber` varchar(50) NOT NULL,
  `Seatnumber` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bus`
--

INSERT INTO `bus` (`Bus_id`, `Names`, `Platenumber`, `Seatnumber`) VALUES
(1, 'gisa', 'rl23456', 30);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL,
  `Names` varchar(20) NOT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `mobile` varchar(200) NOT NULL,
  `address` varchar(20) DEFAULT NULL,
  `addressto` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `Names`, `Email`, `mobile`, `address`, `addressto`) VALUES
(1, 'kwizera', 'kwizera@gmail.com', '078456789', 'huye', ''),
(2, 'fred', 'sdfghj', 'dsfg', '1234567', ''),
(3, 'kwizera', 'kwizera@gmail.com', 'kigali', 'huye', '0987654'),
(4, 'sdfghj', 'sdfgh', 'kigali', 'huye', '123456'),
(5, 'sdtfghj', 'wertyu', 'kigali', 'nyagatare', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `Driver_id` int(11) NOT NULL,
  `Names` varchar(50) DEFAULT NULL,
  `Mobile` varchar(15) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `license` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`Driver_id`, `Names`, `Mobile`, `email`, `license`) VALUES
(1, 'gisa', '078888888', 'gisa@gmail.com', 'D'),
(2, 'GATETE', '12345678', 'GATETE@GMAIL.COM', 'G'),
(4, 'fred', '1234asdcf', 'sdfgd', 'asd');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `email` varchar(50) DEFAULT NULL,
  `password` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`email`, `password`) VALUES
('gisa', 12345),
('sdfghjk', 234567),
('JUNIOR', 12345),
('gisa', 12345);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL,
  `Bus_id` int(11) DEFAULT NULL,
  `customerid` int(11) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `start` varchar(20) DEFAULT NULL,
  `stop` varchar(20) DEFAULT NULL,
  `Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`ticket_id`, `Bus_id`, `customerid`, `driver_id`, `start`, `stop`, `Date`) VALUES
(1, 1, 2, 2, '2024/12/12', 'huye', '2024-12-12'),
(2, 1, 2, 2, 'nyagatare', 'nyanza', '2024-11-11'),
(3, 1, 4, 1, 'huye', 'huye', '2024-12-12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`Bus_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`Driver_id`),
  ADD UNIQUE KEY `license` (`license`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_id`),
  ADD KEY `Bus_id` (`Bus_id`),
  ADD KEY `customerid` (`customerid`),
  ADD KEY `driver_id` (`driver_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`Bus_id`) REFERENCES `bus` (`Bus_id`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`customerid`) REFERENCES `customer` (`customerid`),
  ADD CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`Driver_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
