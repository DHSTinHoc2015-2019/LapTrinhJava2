-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 14, 2018 at 10:14 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentdb`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DanhSachSinhVien` ()  BEGIN
   SELECT *  FROM student;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_create_student` (`Code` INT(11), `Name` TEXT charset utf8mb4, `Gender` INT(11))  BEGIN
	INSERT INTO student VALUES (Code, Name, Gender);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_delete_student` (`Code` INT(11))  BEGIN
	DELETE FROM student WHERE student.Code = Code;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_student` (IN `Name` TEXT CHARSET utf8mb4, IN `Gender` INT(11), IN `Code` INT(11))  BEGIN
	UPDATE student SET student.Name = Name, student.Gender = Gender WHERE student.Code = Code;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Code` int(11) NOT NULL,
  `Name` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Gender` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Code`, `Name`, `Gender`) VALUES
(1, 'Trần A', 1),
(2, 'Nguyễn Thị B', 1),
(3, 'Trần Văn C', 0),
(4, 'Nguyễn a', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`Code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `Code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
