-- MySQL dump 10.13  Distrib 5.6.40, for linux-glibc2.12 (x86_64)
--
-- Host: localhost    Database: EmployeeData
-- ------------------------------------------------------
-- Server version	5.6.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BOOKING`
--

DROP TABLE IF EXISTS `BOOKING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BOOKING` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sourceLocation` varchar(30) DEFAULT NULL,
  `dateTimeOfJourney` timestamp NULL DEFAULT NULL,
  `employeeId` int(11) DEFAULT NULL,
  `bookingStatusOfJourney` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `employeeId` (`employeeId`),
  CONSTRAINT `BOOKING_ibfk_1` FOREIGN KEY (`employeeId`) REFERENCES `EMPLOYEE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BOOKING`
--

LOCK TABLES `BOOKING` WRITE;
/*!40000 ALTER TABLE `BOOKING` DISABLE KEYS */;
INSERT INTO `BOOKING` VALUES (19,'Bk Nagar','2019-07-21 19:44:07',3,1),(20,'Banashankari','2019-07-21 16:44:07',3,0),(21,'R T Nagar','2019-07-22 16:44:07',3,0),(22,'Frazer Town','2019-07-22 15:44:07',3,1),(23,'Banashankari','2019-07-22 17:44:07',3,1),(24,'Kadrenahalli','2019-07-22 15:44:07',4,1),(25,'Rajaji Nagar','2019-07-22 15:44:07',3,1),(26,'B T M layout','2019-07-22 15:44:07',3,1),(27,'K R Market','2019-07-22 17:44:07',3,1),(28,'S K Palya','2019-07-22 18:44:07',3,1);
/*!40000 ALTER TABLE `BOOKING` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CAB`
--

DROP TABLE IF EXISTS `CAB`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CAB` (
  `cabId` int(11) NOT NULL AUTO_INCREMENT,
  `registrationNumber` varchar(10) DEFAULT NULL,
  `driverId` int(11) NOT NULL,
  `cabStatus` tinyint(1) NOT NULL,
  `comments` varchar(100) DEFAULT NULL,
  `vacancy` int(11) DEFAULT NULL,
  PRIMARY KEY (`cabId`),
  KEY `driverId` (`driverId`),
  CONSTRAINT `CAB_ibfk_1` FOREIGN KEY (`driverId`) REFERENCES `EMPLOYEE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CAB`
--

LOCK TABLES `CAB` WRITE;
/*!40000 ALTER TABLE `CAB` DISABLE KEYS */;
INSERT INTO `CAB` VALUES (2,'KQ36J3425',3,1,'Fdfh',1),(4,'KR24H5749',3,0,'eragzdh',2),(5,'NH76H8694',3,0,'ags',4),(6,'NF12M7465',3,1,'wehs',3);
/*!40000 ALTER TABLE `CAB` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLOYEE`
--

DROP TABLE IF EXISTS `EMPLOYEE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EMPLOYEE` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employeeName` varchar(100) DEFAULT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `joiningDate` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLOYEE`
--

LOCK TABLES `EMPLOYEE` WRITE;
/*!40000 ALTER TABLE `EMPLOYEE` DISABLE KEYS */;
INSERT INTO `EMPLOYEE` VALUES (3,'Rajesh Kumar','java developer','05-07-2019','rajesh@gmail.com','9872487536','Banglore'),(4,'Kiran','Teste','05-07-2019','kiran@gmail.com','9876542583','Bangalore');
/*!40000 ALTER TABLE `EMPLOYEE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-22 12:54:20
