-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 23, 2014 at 03:37 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Students`
--
CREATE DATABASE IF NOT EXISTS `Students` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE Students;

-- --------------------------------------------------------

--
-- Table structure for table `col_of_business`
--

DROP TABLE IF EXISTS `col_of_business`;
CREATE TABLE IF NOT EXISTS "col_of_business" (
  "ID" int(10) NOT NULL,
  "Lastname" varchar(30) NOT NULL,
  "Firstname" varchar(30) NOT NULL,
  "Major" varchar(10) NOT NULL,
  "Phone number" bigint(20) NOT NULL,
  "Email Address" varchar(50) NOT NULL,
  PRIMARY KEY ("Lastname","Firstname","Major","Phone number","Email Address"),
  UNIQUE KEY "Phone number" ("Phone number"),
  FULLTEXT KEY "Lastname" ("Lastname","Firstname","Major","Email Address")
);

--
-- Dumping data for table `col_of_business`
--

INSERT INTO `col_of_business` (`ID`, `Lastname`, `Firstname`, `Major`, `Phone number`, `Email Address`) VALUES
(10010, 'Baker', 'Clay', 'ECON', 3209989088, 'clay.baker@ub.edu'),
(10022, 'Berry', 'Willie', 'MKTNG', 4698292133, 'willie.berry@ub.edu'),
(10016, 'Black', 'Gertrude', 'MGMT', 87899092322, 'gertrude.black@ub.edu'),
(10015, 'Buchanan', 'Deanne', 'MGMT', 9800897788, 'deanne.buchanan@ub.edu'),
(10013, 'Chavez', 'Renee', 'INSYS', 2149908897, 'renee.chavez@ub.edu'),
(10017, 'Cooper', 'Marcella', 'MGMT', 8783802309, 'marcella.cooper@ub.edu'),
(10003, 'Erickson', 'Laurence', 'ACCT', 9092132211, 'laurence.erickson@ub.edu'),
(10018, 'Gross', 'Blanche', 'MGMT', 9093389992, 'blanche.gross@ub.edu'),
(10005, 'Hernandez', 'Gloria', 'ECON', 3218893243, 'gloria.hernandez@ub.edu'),
(10008, 'Jones', 'Inez', 'ECON', 9729093255, 'inez.jones@ub.edu'),
(10011, 'Lynch', 'Jenny', 'INSYS', 8083997554, 'jenny.lynch@ub.edu'),
(10004, 'Matthews', 'Genevieve', 'ACCT', 8793224387, 'genevieve.matthews@ub.edu'),
(10021, 'McGuire', 'Kimberly', 'MKTNG', 8787346551, 'kimberly.mcguire@ub.edu'),
(10007, 'Payne', 'Krista', 'FIN', 9083290099, 'payne.krista@ub.edu'),
(10019, 'Price', 'Luis', 'MKTNG', 2143321123, 'luis.price@ub.edu'),
(10001, 'Reid', 'Rhonda', 'ACCT', 9083214433, 'rhonda.reid@ub.edu'),
(10012, 'Rowe', 'Rick', 'INSYS', 3904237789, 'rick.rowe@ub.edu'),
(10009, 'Thornton', 'Stella', 'FIN', 98033289703, 'stella.thornton@ub.edu'),
(10006, 'Walsh', 'Blake', 'ECON', 2193324908, 'blake.walsh@ub.edu'),
(10014, 'Webb', 'Joshua', 'INSYS', 8176784783, 'joshua.webb@ub.edu'),
(10020, 'Wheeler', 'Ismael', 'MKTNG', 2193905576, 'ismael.wheeler@ub.edu'),
(10002, 'Zimmerman', 'Juanita', 'ACCT', 2143324345, 'juanita.zimmerman@ub.edu');

-- --------------------------------------------------------

--
-- Table structure for table `col_of_ed_hp`
--

DROP TABLE IF EXISTS `col_of_ed_hp`;
CREATE TABLE IF NOT EXISTS "col_of_ed_hp" (
  "ID" int(10) NOT NULL,
  "Lastname" varchar(20) NOT NULL,
  "Firstname" varchar(20) NOT NULL,
  "Major" varchar(10) NOT NULL,
  "Phone number" bigint(20) NOT NULL,
  "Email address" varchar(50) NOT NULL,
  PRIMARY KEY ("Lastname","Firstname","Major","Phone number","Email address")
);

--
-- Dumping data for table `col_of_ed_hp`
--

INSERT INTO `col_of_ed_hp` (`ID`, `Lastname`, `Firstname`, `Major`, `Phone number`, `Email address`) VALUES
(10101, 'Farmer', 'Gladys', 'CURR', 9099875654, 'gladys.farmer@ub.edu'),
(10100, 'Mills', 'Regina', 'CURR', 8172113321, 'regina.mills@ub.edu'),
(10106, 'Powers', 'Carla', 'KINS', 2146756644, 'carla.powers@ub.edu'),
(10103, 'Rodgers', 'Matthew', 'ELEAD', 8177189800, 'matthew.rodgers@ub.edu'),
(10105, 'Santos', 'Roland', 'KINS', 9876567676, 'roland.santos@ub.edu'),
(10102, 'Smith', 'Betsy', 'ELEAD', 4689098899, 'betsy.smith@ub.edu');

-- --------------------------------------------------------

--
-- Table structure for table `col_of_engr`
--

DROP TABLE IF EXISTS `col_of_engr`;
CREATE TABLE IF NOT EXISTS "col_of_engr" (
  "ID" int(10) NOT NULL,
  "Lastname" varchar(20) NOT NULL,
  "Firstname" varchar(20) NOT NULL,
  "Major" varchar(10) NOT NULL,
  "Phone number" bigint(20) NOT NULL,
  "Email address" varchar(50) NOT NULL,
  PRIMARY KEY ("Lastname","Firstname","Major","Phone number","Email address")
);

--
-- Dumping data for table `col_of_engr`
--

INSERT INTO `col_of_engr` (`ID`, `Lastname`, `Firstname`, `Major`, `Phone number`, `Email address`) VALUES
(10203, 'Castro', 'Teresa', 'CE', 8163892200, 'teresa.castro@ub.edu'),
(10210, 'Coleman', 'Alexis', 'EE', 9093298865, 'alexis.coleman@ub.edu'),
(10213, 'Cruz', 'Jane', 'IE', 4628767711, 'jane.cruz@ub.edu'),
(10217, 'Doyle', 'Cornelius', 'MAE', 8907896454, 'cornelius.doyle@ub.edu'),
(10206, 'George', 'Brandy', 'CS', 9092839901, 'brandy.george@ub.edu'),
(10207, 'Goodman', 'Alice', 'CS', 8781233212, 'alice.goodman@ub.edu'),
(10216, 'Hines', 'Jane', 'MAE', 4652155465, 'jane.hines@ub.edu'),
(10214, 'Holland', 'Tom', 'MSE', 9820132211, 'tom.holland@ub.edu'),
(10205, 'Kelly', 'Debra', 'CE', 6872781111, 'kelly.debra@ub.edu'),
(10211, 'Malone', 'Toby', 'EE', 8182874654, 'toby.malone@ub.edu'),
(10200, 'Mclaughlin', 'Anne', 'BE', 2144447877, 'anne.mclaughlin@ub.edu'),
(10215, 'Mendez', 'Olive', 'MSE', 4656365587, 'olive.mendez@ub.edu'),
(10201, 'Morgan', 'Janie', 'BE', 9089907676, 'janie.morgan@ub.edu'),
(10212, 'Myers', 'Sean', 'IE', 9029886766, 'sean.myers@ub.edu'),
(10204, 'Park', 'Lowell', 'CE', 8789019009, 'lowell.park@ub.edu'),
(10208, 'Patton', 'Ron', 'CS', 4695646654, 'ron.patton@ub.edu'),
(10209, 'Porter', 'Roy', 'CS', 7687678877, 'roy.porter@ub.edu'),
(10202, 'Salazar', 'Margarette', 'BE', 8782878738, 'margarette.salazar@ub.edu');

-- --------------------------------------------------------

--
-- Table structure for table `col_of_lib_art`
--

DROP TABLE IF EXISTS `col_of_lib_art`;
CREATE TABLE IF NOT EXISTS "col_of_lib_art" (
  "ID" int(10) NOT NULL,
  "Lastname" varchar(30) NOT NULL,
  "Firstname" varchar(30) NOT NULL,
  "Major" varchar(10) NOT NULL,
  "Phone number" bigint(20) NOT NULL,
  "Email address" varchar(50) NOT NULL,
  PRIMARY KEY ("Lastname","Firstname","Major","Phone number","Email address")
);

--
-- Dumping data for table `col_of_lib_art`
--

INSERT INTO `col_of_lib_art` (`ID`, `Lastname`, `Firstname`, `Major`, `Phone number`, `Email address`) VALUES
(10318, 'Alexander', 'Adam', 'SOCI', 8739286554, 'adam.alexander@ub.edu'),
(10314, 'Campbell', 'Theresa', 'MUSI', 2183328578, 'theresa.campbell@ub.edu'),
(30320, 'Cook', 'Virginia', 'THEA', 8743787763, 'virginia.swan@ub.edu'),
(10300, 'Hopkins', 'Mandy', 'ART', 3215223576, 'mandy.hopkins@ub.edu'),
(10312, 'Jones', 'Joyce', 'MODL', 7183227945, 'joyce.jones@ub.edu'),
(10305, 'Lloyd', 'Jean', 'CRIM', 8985465533, 'jean.lloyd@ub.edu'),
(30317, 'Mitchell', 'Russell', 'POLS', 5467784345, 'russell.mitchell@ub.edu'),
(10307, 'Morris', 'Ashley', 'ENGL', 5234325120, 'ashley.morris@ub.edu'),
(10315, 'Parker', 'Shirley', 'MUSI', 9843327768, 'shirley.parker@ub.edu'),
(10313, 'Peterson', 'Earl', 'MODL', 7658493384, 'earl.peterson@ub.edu'),
(10306, 'Philips', 'Amy', 'ENGL', 2134212231, 'amy.philips@ub.edu'),
(10303, 'Ramirez', 'Marcella', 'COMM', 5654673374, 'marcella.ramirez@ub.edu'),
(10311, 'Roberts', 'Marie', 'LING', 2190294421, 'marie.roberts@ub.edu'),
(10304, 'Rose', 'Erica', 'CRIM', 4658340090, 'erica.rose@ub.edu'),
(10302, 'Simon', 'Margaret', 'COMM', 8892887898, 'margaret.simon@ub.edu'),
(10301, 'Summers', 'Manuel', 'ART', 7876785342, 'manuel.summers@ub.edu'),
(30321, 'Swan', 'Emma', 'THEA', 7483676678, 'emma.swan@ub.edu'),
(10309, 'Thomas', 'Tina', 'HIST', 9099824321, 'tina.thomas@ub.edu'),
(30316, 'Turner', 'Paula', 'PHIL', 6757987746, 'paula.turner@ub.edu'),
(10310, 'Watson', 'Betty', 'LING', 31243986775, 'betty.watson@ub.edu'),
(10319, 'White', 'Diane', 'SOCI', 8783435454, 'diane.white@ub.edu'),
(10308, 'Wright', 'Annie', 'HIST', 2123326459, 'annie.wright@ub.edu');

-- --------------------------------------------------------

--
-- Table structure for table `col_of_scie`
--

DROP TABLE IF EXISTS `col_of_scie`;
CREATE TABLE IF NOT EXISTS "col_of_scie" (
  "ID" int(10) NOT NULL,
  "Lastname" varchar(20) NOT NULL,
  "Firstname" varchar(20) NOT NULL,
  "Major" varchar(10) NOT NULL,
  "Phone number" bigint(20) NOT NULL,
  "Email address" varchar(50) NOT NULL,
  PRIMARY KEY ("Lastname","Firstname","Major","Phone number","Email address")
);

--
-- Dumping data for table `col_of_scie`
--

INSERT INTO `col_of_scie` (`ID`, `Lastname`, `Firstname`, `Major`, `Phone number`, `Email address`) VALUES
(10402, 'Allen', 'Jose', 'BIOL', 4657676655, 'jose.allen@ub.edu'),
(10400, 'Bailey', 'Christina', 'BIOL', 8786753442, 'christina.bailey@ub.edu'),
(40407, 'Baker', 'Katherine', 'EVSC', 2145097312, 'katherine.baker@ub.edu'),
(40408, 'Brooks', 'Johnny', 'MATH', 5763866783, 'johnny.brooks@ub.edu'),
(10405, 'Davis', 'Andrew', 'CHEM', 4657893374, 'andrew.davis@ub.edu'),
(40409, 'James', 'Denice', 'PHYS', 8778789321, 'denice.james@ub.edu'),
(10404, 'Kelly', 'Keith', 'CHEM', 8766785678, 'keith.kelly@ub.edu'),
(40410, 'Lee', 'Pauline', 'PSYCH', 8749898837, 'pauline.lee@ub.edu'),
(40411, 'Miller', 'Glenda', 'PSYCH', 8729338977, 'glenda.miller@ub.edu'),
(10403, 'Murphy', 'Judith', 'BIOL', 8746673356, 'judith.murphy@ub.edu'),
(10401, 'Roberts', 'Ruth', 'BIOL', 4688897867, 'ruth.roberts@ub.edu'),
(40406, 'Wood', 'Victor', 'EVSC', 3647725213, 'victor.wood@ub.edu');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
