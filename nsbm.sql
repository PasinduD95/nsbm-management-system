-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2018 at 02:28 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nsbm`
--

-- --------------------------------------------------------

--
-- Table structure for table `al_result`
--

CREATE TABLE `al_result` (
  `Student_id` int(11) NOT NULL,
  `Subject_1` varchar(50) NOT NULL,
  `Result_1` char(1) NOT NULL,
  `Subject_2` varchar(50) NOT NULL,
  `Result_2` char(1) NOT NULL,
  `Subject_3` varchar(50) NOT NULL,
  `Result_3` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `al_result`
--

INSERT INTO `al_result` (`Student_id`, `Subject_1`, `Result_1`, `Subject_2`, `Result_2`, `Subject_3`, `Result_3`) VALUES
(3, 'asdf', 's', 'sdf', 's', 'sdf', 'f');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `Course_id` varchar(10) NOT NULL,
  `Course_name` varchar(50) NOT NULL,
  `Duration` double NOT NULL,
  `Credit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`Course_id`, `Course_name`, `Duration`, `Credit`) VALUES
('10', 'gdddd', 5, 2),
('20', 'hjvh', 14, 2),
('25', 'nijbiu', 18, 5),
('cs2100', 'java', 10, 10),
('scs2105', 'computer network', 22, 3);

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `Faculty_Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `Ins_id` int(11) NOT NULL,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `Room` varchar(3) NOT NULL,
  `Teach_sub` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`Ins_id`, `Fname`, `Lname`, `Address`, `Contact`, `Room`, `Teach_sub`) VALUES
(1, 'uyou', 'ghu', 'hugyhl', '5648', '56', 'gfk'),
(2, 'ygu', 'hv', 'vvvvvvvvvv', '468', '5', 'gchccjyck');

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

CREATE TABLE `lecturer` (
  `Lec_id` int(3) NOT NULL,
  `Fname` varchar(50) NOT NULL,
  `Lname` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `Room` varchar(3) NOT NULL,
  `Teach_sub` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturer`
--

INSERT INTO `lecturer` (`Lec_id`, `Fname`, `Lname`, `Address`, `Contact`, `Room`, `Teach_sub`) VALUES
(1, 'vuyu', 'hvuyou', 'yvu', '64866', '67', 'gfiu'),
(2, 'gyuo', 'yug', 'hbiy', '5665658', '54', 'vhgvkh');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Payment_id` varchar(5) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `postgraduate_student`
--

CREATE TABLE `postgraduate_student` (
  `Student_id` int(4) NOT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(150) NOT NULL,
  `City` varchar(50) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Date_of_birth` date NOT NULL,
  `Qualification_Type` varchar(100) NOT NULL,
  `Institute` varchar(100) NOT NULL,
  `Year_of_completion` varchar(4) NOT NULL,
  `Faculty` varchar(50) NOT NULL,
  `Course` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `postgraduate_student`
--

INSERT INTO `postgraduate_student` (`Student_id`, `First_Name`, `Last_Name`, `Gender`, `Address`, `City`, `NIC`, `Contact`, `Email`, `Date_of_birth`, `Qualification_Type`, `Institute`, `Year_of_completion`, `Faculty`, `Course`) VALUES
(1, 'pasindu', 'dilshan', 'Male', 'sujani, walgama north', 'matara', '951592633v', '0776557560', 'jkpasindudilshan@gmail.com', '1995-06-07', 'diploma', 'open university', '2015', 'School of Computing', 'Computer Science'),
(2, 'kamala', 'perera', 'Female', 'kekanadura', 'matara', '0715465852', '926536452v', 'kamalperera@gmail.com', '1992-08-12', 'diploma', 'open university', '2010', 'School of Business', 'Business Economics'),
(3, 'amali', 'rathnayake', 'Female', 'sssssssssssssssssss', 'matara', '936534252v', '0715464201', 'amalirathnayake@gmail.com', '1993-10-05', 'diploma', 'open university', '2012', 'School of Computing', 'Information System');

-- --------------------------------------------------------

--
-- Table structure for table `practical_assessment`
--

CREATE TABLE `practical_assessment` (
  `Lab_Ass_Mark` varchar(2) NOT NULL,
  `Demonstration_Mark` varchar(2) NOT NULL,
  `Project_Mark` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `semester`
--

CREATE TABLE `semester` (
  `Semester_id` int(11) NOT NULL,
  `Amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `Subject_Code` varchar(10) NOT NULL,
  `Subject_Name` varchar(50) NOT NULL,
  `Grade` varchar(3) DEFAULT NULL,
  `Credit` int(11) NOT NULL,
  `Fee` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`Subject_Code`, `Subject_Name`, `Grade`, `Credit`, `Fee`) VALUES
('scs2101', 'Software Engineering', 'A', 2, 12500),
('scs2102', 'Computer Science', 'A', 2, 13200),
('scs2103', 'Database', 'B+', 3, 14000),
('scs2104', 'Programming', 'A+', 3, 15300),
('scs2105', 'Data Structure & Algorithms', 'A-', 3, 15000);

-- --------------------------------------------------------

--
-- Table structure for table `theoretical_assessment`
--

CREATE TABLE `theoretical_assessment` (
  `Assignment_Mark` varchar(2) NOT NULL,
  `Report_Mark` varchar(2) NOT NULL,
  `In-Class_Mark` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `undergraduate_student`
--

CREATE TABLE `undergraduate_student` (
  `Student_id` int(11) NOT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(150) NOT NULL,
  `City` varchar(50) NOT NULL,
  `NIC` varchar(10) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Date_of_birth` date NOT NULL,
  `AL_Stream` varchar(50) NOT NULL,
  `Index_No` varchar(10) NOT NULL,
  `Rank` int(11) NOT NULL,
  `ZScore` double NOT NULL,
  `Faculty` varchar(50) NOT NULL,
  `Course` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `undergraduate_student`
--

INSERT INTO `undergraduate_student` (`Student_id`, `First_Name`, `Last_Name`, `Gender`, `Address`, `City`, `NIC`, `Contact`, `Email`, `Date_of_birth`, `AL_Stream`, `Index_No`, `Rank`, `ZScore`, `Faculty`, `Course`) VALUES
(1, '', '', '', '', '', '', '', '', '0000-00-00', '3', '1.3658', 200, 0, '', ''),
(3, 'aaaaaaaaaaaaaa', 'bbbbbbbbbbbbbb', 'F', 'cccccccccccccc', 'dddddddddddddd', '34eeeeeeee', '3423534543', 'ffffffffffffff', '2017-09-11', 'gggggggggg', '234235', 200, 1.324, '', ''),
(4548, 'vyu', 'yvuu', 'Male', 'uyviuu', 'bjhbk', '578', '65786', 'jgkf', '2016-06-04', 'Maths', '75989', 165, 1.5265, 'School of Business', 'Computer Science'),
(1, 'hbu', 'dfg', 'Male', 'fgfz', 'fdgdfg', '3434', '4565465', 'gsgg', '2016-06-04', 'Maths', '5655', 453, 1.56, 'School of Business', 'Computer Science'),
(4550, 'pasindu', 'dilshan', 'Male', 'sujani, walgama north', 'matara', '951592633V', '0776557560', 'jkpasindudilshan@gmail.com', '1995-06-07', 'Maths', '9247801', 206, 1.5406, 'School of Computing', 'Computer Science'),
(4551, 'ann', 'sd', 'Female', 'qcdcq', 'dcq', '4345', '35145', 'vfd', '2015-06-06', 'Maths', '34132', 32, 3.234, 'School of Business', 'Computer Science'),
(4552, 'ppppppppppppppppdcqd', 'dqq', 'Female', 'qwf', 'cqef', '324', '4321', 'dfvewfv', '2014-06-07', 'Maths', '4323232', 32, 2.334, 'School of Business', 'Computer Science'),
(4553, 'e', 'd', 'Male', 'fw', 'rfwre', '45f', '45435', 'reg', '2016-06-04', 'Maths', '41345', 454, 4.413, 'School of Business', 'Computer Science'),
(4554, 'a', 'a', 'Male', 'a', 'a', 'e2wd', '2324', 's', '2015-07-04', 'Maths', '213', 43, 3.54, 'School of Business', 'Computer Science'),
(4555, 'a', 'a', 'Male', 'a', 'a', '34', '345435', 'a', '2015-07-04', 'Bio', '343', 32, 3.5, 'School of Business', 'Computer Science'),
(4556, 'fgf', 'ffv', 'Female', 'fvadfv', 'vdfz', '45q34', '335435', 'dfad', '2016-06-04', 'Maths', '4543', 53, 1.56, 'School of Business', 'Computer Science'),
(4557, 'fgf', 'ffv', 'Female', 'fvadfv', 'vdfz', '45q34', '335435', 'dfad', '2016-06-04', 'Maths', '4543', 53, 1.56, 'School of Business', 'Computer Science');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Student_id` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Student_id`, `Username`, `Password`) VALUES
(1, 'pasindu', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `al_result`
--
ALTER TABLE `al_result`
  ADD PRIMARY KEY (`Student_id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`Course_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`Faculty_Name`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`Ins_id`);

--
-- Indexes for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`Lec_id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_id`);

--
-- Indexes for table `postgraduate_student`
--
ALTER TABLE `postgraduate_student`
  ADD PRIMARY KEY (`Student_id`);

--
-- Indexes for table `semester`
--
ALTER TABLE `semester`
  ADD PRIMARY KEY (`Semester_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`Subject_Code`);

--
-- Indexes for table `undergraduate_student`
--
ALTER TABLE `undergraduate_student`
  ADD KEY `Student_id` (`Student_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Student_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `al_result`
--
ALTER TABLE `al_result`
  MODIFY `Student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `instructor`
--
ALTER TABLE `instructor`
  MODIFY `Ins_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `lecturer`
--
ALTER TABLE `lecturer`
  MODIFY `Lec_id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `postgraduate_student`
--
ALTER TABLE `postgraduate_student`
  MODIFY `Student_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `undergraduate_student`
--
ALTER TABLE `undergraduate_student`
  MODIFY `Student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4558;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `Student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `al_result`
--
ALTER TABLE `al_result`
  ADD CONSTRAINT `al_result_ibfk_1` FOREIGN KEY (`Student_id`) REFERENCES `undergraduate_student` (`Student_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
