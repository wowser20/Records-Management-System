-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 22, 2020 at 06:22 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentinfo`
--

-- --------------------------------------------------------

--
-- Table structure for table `age`
--

CREATE TABLE `age` (
  `Age` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `age`
--

INSERT INTO `age` (`Age`) VALUES
('15'),
('16'),
('17'),
('18'),
('19'),
('20'),
('21'),
('22'),
('23'),
('24'),
('25'),
('26'),
('27'),
('28'),
('29'),
('30'),
('31'),
('32'),
('33'),
('34'),
('35'),
('36'),
('37'),
('38'),
('39'),
('40'),
('41'),
('42'),
('43'),
('44'),
('45'),
('46'),
('47'),
('48'),
('49'),
('50'),
('51'),
('52'),
('53'),
('54'),
('55'),
('56'),
('57'),
('58'),
('59'),
('60'),
('61'),
('62'),
('63'),
('64'),
('65'),
('66'),
('67'),
('68'),
('69'),
('70'),
('71'),
('72'),
('73'),
('74'),
('75'),
('76'),
('77'),
('78'),
('79'),
('80');

-- --------------------------------------------------------

--
-- Table structure for table `cmb_department`
--

CREATE TABLE `cmb_department` (
  `Department` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cmb_department`
--

INSERT INTO `cmb_department` (`Department`) VALUES
('CCE'),
('CTE'),
('CASE'),
('CEE'),
('CAE'),
('CHSE'),
('CAFAE'),
('CCJE'),
('CHE');

-- --------------------------------------------------------

--
-- Table structure for table `sex`
--

CREATE TABLE `sex` (
  `Sex` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sex`
--

INSERT INTO `sex` (`Sex`) VALUES
('F'),
('M');

-- --------------------------------------------------------

--
-- Table structure for table `student_list`
--

CREATE TABLE `student_list` (
  `Lastname` text NOT NULL,
  `Firstname` text NOT NULL,
  `Middlename` text NOT NULL,
  `Sex` text NOT NULL,
  `Age` text NOT NULL,
  `Contactinfo` text NOT NULL,
  `Gradelevel` text NOT NULL,
  `Address` text NOT NULL,
  `ID` text NOT NULL,
  `Course` text NOT NULL,
  `Email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_list`
--

INSERT INTO `student_list` (`Lastname`, `Firstname`, `Middlename`, `Sex`, `Age`, `Contactinfo`, `Gradelevel`, `Address`, `ID`, `Course`, `Email`) VALUES
('Remoreras', 'Andrea', 'Robilla', 'F', '20', '09070841101', '1ST YEAR', 'Cabantian, Davao City', '512875', 'BSCS', 'andrea@gmail.com'),
('Imperial', 'Rica', 'Juan', 'F', '19', '0912658452', '2ND YEAR', 'Cabantian, Davao City', '512875', 'BSA', 'rica@gmail.com'),
('Sotomayor', 'Abegail', 'Remoreras', 'F', '20', '0956232485', '2ND YEAR', 'Cabantian, Davao City', '512878', 'BSMA', 'abegail@gmail.com'),
('Vallejo', 'Remi', 'Tanan', 'M', '20', '094845456', '2ND YEAR', 'Bislig, Surigao Del Sur', '512986', 'BSCS', 'remi@gmail.com'),
('Hernando', 'Jaynard John', 'Jara', 'M', '20', '0965658454', '2ND YEAR', 'Piapi Boulevard, Davao City', '512111', 'BSCS', 'jaynard@gmail.com'),
('Budiongan', 'Hannah ', 'H', 'F', '20', '0956532663', '2ND YEAR', 'Tibungco, Davao City', '512178', 'BSCS', 'hannah@gmail.com'),
('Atilano', 'Joyce', 'Belec', 'F', '21', '093653245', '2ND YEAR', 'Deca Cabantian, Davao City', '512741', 'BSHM', 'joyce@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `teacher_list`
--

CREATE TABLE `teacher_list` (
  `Lastname` text NOT NULL,
  `Firstname` text NOT NULL,
  `Middlename` text NOT NULL,
  `Sex` text NOT NULL,
  `Age` text NOT NULL,
  `Department` text NOT NULL,
  `Contact` text NOT NULL,
  `Address` text NOT NULL,
  `Email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teacher_list`
--

INSERT INTO `teacher_list` (`Lastname`, `Firstname`, `Middlename`, `Sex`, `Age`, `Department`, `Contact`, `Address`, `Email`) VALUES
('Remoreras', 'Andrea Ella', 'Robilla', 'F', '20', 'CCE', '09070841101', 'Cabantian, Davao City', 'andrea@gmail.com'),
('Sotomayor', 'Abegail', 'Remoreras', 'F', '20', 'CASE', '0912032654', 'Cabantian, Davao City', 'abegail@gmail.com'),
('Remoreras', 'Krystal Joyce', 'Robilla', 'F', '24', 'CAE', '09365324485', 'Cabantian, Davao City', 'krystal@gmail.com'),
('Imperial', 'Rica', 'Juan', 'F', '20', 'CAE', '0912587558', 'Soraya, Davao City', 'rica@gmail.com'),
('Atilano', 'Joyce', 'Belec', 'F', '22', 'CHE', '096532658', 'Deca Cabantian, Davao City', 'joyce@gmail.com'),
('Vallejo', 'Remi', 'Tano', 'F', '20', 'CCE', '095652329', 'Bislig, Surigao Del Sur', 'remi@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--

CREATE TABLE `userdata` (
  `username` text NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`username`, `password`) VALUES
('admin', '09078865120'),
('admin', '09078865120'),
('andrea', '09078865120');

-- --------------------------------------------------------

--
-- Table structure for table `year_level`
--

CREATE TABLE `year_level` (
  `Year` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `year_level`
--

INSERT INTO `year_level` (`Year`) VALUES
('1ST YEAR'),
('2ND YEAR'),
('3RD YEAR'),
('4TH YEAR'),
('5TH YEAR');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
