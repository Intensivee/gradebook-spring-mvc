CREATE DATABASE  IF NOT EXISTS `gradebook` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gradebook`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: gradebook
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `attendance_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `presence` tinyint NOT NULL DEFAULT '0',
  `attendance_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`attendance_id`),
  KEY `fk_a_s_idx` (`subject_id`),
  KEY `fk_a_u_idx` (`user_id`),
  CONSTRAINT `fk_a_s` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_a_u` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (25,40,31,1,'2020-06-25 14:23:20'),(26,41,31,1,'2020-06-25 14:23:20'),(27,42,31,1,'2020-06-25 14:23:20'),(28,43,31,1,'2020-06-25 14:23:20'),(29,40,31,0,'2020-06-25 14:23:27'),(30,41,31,1,'2020-06-25 14:23:27'),(31,42,31,1,'2020-06-25 14:23:27'),(32,43,31,1,'2020-06-25 14:23:27'),(33,40,31,1,'2020-06-25 14:23:39'),(34,41,31,1,'2020-06-25 14:23:39'),(35,42,31,1,'2020-06-25 14:23:39'),(36,43,31,0,'2020-06-25 14:23:39'),(37,44,34,1,'2020-06-25 14:25:43'),(38,45,34,1,'2020-06-25 14:25:43'),(39,46,34,1,'2020-06-25 14:25:43'),(40,47,34,1,'2020-06-25 14:25:43'),(41,40,32,1,'2020-06-25 14:29:32'),(42,41,32,1,'2020-06-25 14:29:32'),(43,42,32,1,'2020-06-25 14:29:32'),(44,43,32,1,'2020-06-25 14:29:32'),(45,44,35,1,'2020-06-25 14:35:01'),(46,45,35,0,'2020-06-25 14:35:01'),(47,46,35,1,'2020-06-25 14:35:01'),(48,47,35,1,'2020-06-25 14:35:01'),(49,44,35,1,'2020-06-25 14:35:05'),(50,45,35,0,'2020-06-25 14:35:05'),(51,46,35,1,'2020-06-25 14:35:05'),(52,47,35,1,'2020-06-25 14:35:05'),(53,44,35,1,'2020-06-25 14:35:09'),(54,45,35,1,'2020-06-25 14:35:09'),(55,46,35,1,'2020-06-25 14:35:09'),(56,47,35,1,'2020-06-25 14:35:09'),(57,48,38,1,'2020-06-25 14:36:34'),(58,49,38,1,'2020-06-25 14:36:34'),(59,50,38,1,'2020-06-25 14:36:34'),(60,51,38,1,'2020-06-25 14:36:34'),(61,52,38,1,'2020-06-25 14:36:34'),(62,48,38,1,'2020-06-25 14:36:39'),(63,49,38,1,'2020-06-25 14:36:39'),(64,50,38,1,'2020-06-25 14:36:39'),(65,51,38,1,'2020-06-25 14:36:39'),(66,52,38,1,'2020-06-25 14:36:39'),(67,40,33,1,'2020-06-25 14:37:43'),(68,41,33,1,'2020-06-25 14:37:43'),(69,42,33,1,'2020-06-25 14:37:43'),(70,43,33,1,'2020-06-25 14:37:43'),(71,40,33,1,'2020-06-25 14:37:49'),(72,41,33,1,'2020-06-25 14:37:49'),(73,42,33,1,'2020-06-25 14:37:49'),(74,43,33,1,'2020-06-25 14:37:49'),(75,40,33,1,'2020-06-25 14:37:53'),(76,41,33,1,'2020-06-25 14:37:53'),(77,42,33,1,'2020-06-25 14:37:53'),(78,43,33,1,'2020-06-25 14:37:53'),(79,40,33,0,'2020-06-25 14:38:04'),(80,41,33,0,'2020-06-25 14:38:04'),(81,42,33,0,'2020-06-25 14:38:04'),(82,43,33,0,'2020-06-25 14:38:04'),(83,48,39,1,'2020-06-25 14:51:10'),(84,49,39,1,'2020-06-25 14:51:10'),(85,50,39,1,'2020-06-25 14:51:10'),(86,51,39,1,'2020-06-25 14:51:10'),(87,52,39,1,'2020-06-25 14:51:10'),(88,48,39,1,'2020-06-25 14:51:15'),(89,49,39,1,'2020-06-25 14:51:15'),(90,50,39,1,'2020-06-25 14:51:15'),(91,51,39,1,'2020-06-25 14:51:15'),(92,52,39,1,'2020-06-25 14:51:15'),(93,48,39,1,'2020-06-25 14:51:20'),(94,49,39,1,'2020-06-25 14:51:20'),(95,50,39,1,'2020-06-25 14:51:20'),(96,51,39,0,'2020-06-25 14:51:20'),(97,52,39,0,'2020-06-25 14:51:20'),(98,48,39,1,'2020-06-25 14:51:32'),(99,49,39,1,'2020-06-25 14:51:32'),(100,50,39,1,'2020-06-25 14:51:32'),(101,51,39,0,'2020-06-25 14:51:32'),(102,52,39,0,'2020-06-25 14:51:32'),(103,48,37,1,'2020-06-25 14:54:55'),(104,49,37,1,'2020-06-25 14:54:55'),(105,50,37,1,'2020-06-25 14:54:55'),(106,51,37,1,'2020-06-25 14:54:55'),(107,52,37,1,'2020-06-25 14:54:55'),(108,48,37,1,'2020-06-25 14:55:02'),(109,49,37,1,'2020-06-25 14:55:02'),(110,50,37,1,'2020-06-25 14:55:02'),(111,51,37,1,'2020-06-25 14:55:02'),(112,52,37,1,'2020-06-25 14:55:02');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `event_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL,
  `event_note` varchar(250) NOT NULL,
  PRIMARY KEY (`event_id`),
  KEY `fk_e_s_idx` (`subject_id`),
  CONSTRAINT `fk_e_s` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (29,31,'27.06.2020 - Test funkcja kwadratowa'),(30,31,'29.06.2020 - Poprawa testu funkcja kwadratowa'),(32,34,'25.06.2020 - INTERPOLACJA WIELOMIANOWA NEWTONA - TEST'),(33,37,'27.06.2020 - DEKOMPOZYCJA MACIERZY - ROZKŁAD LU - KARTKÓWKA'),(35,32,'26.06.2020 - Omawianie lektury Fiodora Dostojewskiego - \"Zbronia i kara\", test + rozprawka'),(36,35,'ODOPOWIEDZ USTNA: 15 minut interpretacji przy tablicy, dowolny wiersz Różewicza'),(37,38,'PRZYGOTOWANIA DO MATURY - 27.06.2020'),(38,33,'KARTKÓWKA ZE SŁÓWEK, ROZDZIAŁ 5: MIKROBIOLOGIA W ŻYCIU CODZIENNYM - 28.06.2020'),(39,36,'ROŚLINY, KARTKÓWKA KARNA - 28.06.2020');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mark`
--

DROP TABLE IF EXISTS `mark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mark` (
  `mark_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `subject_id` int NOT NULL,
  `grade` float NOT NULL DEFAULT '-1',
  PRIMARY KEY (`mark_id`),
  KEY `user_id_idx` (`user_id`),
  KEY `fk_m_s_idx` (`subject_id`),
  CONSTRAINT `fk_m_s` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_m_u` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mark`
--

LOCK TABLES `mark` WRITE;
/*!40000 ALTER TABLE `mark` DISABLE KEYS */;
INSERT INTO `mark` VALUES (51,40,31,4),(52,40,31,5),(53,40,31,3),(54,41,31,2),(55,41,31,3),(56,41,31,4),(57,42,31,2),(58,42,31,4),(59,43,31,5),(60,43,31,5),(61,43,31,5),(62,44,34,2),(63,45,34,2),(64,46,34,5),(65,47,34,3.5),(66,51,37,5),(67,51,37,5),(68,51,37,5),(69,52,37,5),(70,52,37,5),(71,52,37,5),(72,50,37,4),(73,50,37,3.5),(74,50,37,5),(75,49,37,5),(76,49,37,4.5),(77,49,37,4.5),(78,48,37,2),(79,48,37,3),(80,48,37,3.5),(81,40,32,5),(82,41,32,4.5),(83,42,32,3),(84,43,32,2),(85,44,35,5),(86,44,35,5),(87,45,35,4),(88,46,35,5),(89,47,35,5),(90,48,38,4),(91,49,38,5),(92,50,38,4.5),(93,51,38,5),(95,51,38,5),(96,52,38,5),(97,52,38,5),(98,40,33,2),(99,41,33,3),(100,42,33,2),(101,43,33,5),(102,43,33,5),(103,42,33,3.5),(104,44,36,4),(105,45,36,4),(106,46,36,2),(107,47,36,5),(109,47,36,4),(110,48,39,5),(111,49,39,4.5),(113,50,39,5),(114,51,39,5),(115,52,39,5),(116,51,39,5),(117,52,39,5);
/*!40000 ALTER TABLE `mark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(100) NOT NULL,
  `class_name` varchar(50) NOT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (31,'Matematyka','1'),(32,'Polski','1'),(33,'Angielski','1'),(34,'Matematyka','2'),(35,'Polski','2'),(36,'Angielski','2'),(37,'Matematyka','3'),(38,'Polski','3'),(39,'Angielski','3');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(250) NOT NULL,
  `lname` varchar(250) NOT NULL,
  `login` varchar(45) NOT NULL,
  `password` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `pesel` varchar(11) NOT NULL,
  `birth_date` date NOT NULL,
  `perm` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `pesel_UNIQUE` (`pesel`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (39,'Admin','Admin','22','2','admin@gmail.com','000000000','00000000000','1945-01-01',2),(40,'Andrzej','Mleko','amleko','mleczko123','amleko@gmail.com','999999999','99010142123','1999-01-01',0),(41,'Marcin','Komar','mkomar','komarekxxs','komar@gmail.com','999999998','99010300000','1999-01-03',0),(42,'Katarzyna','Jasiek','kjasiek','kasia33','kasia@gmail.com','999999997','99010400000','1999-01-04',0),(43,'Monika','Mafin','mmafin','czekoladaaa','mafinka@gmail.com','999999996','99010500000','1999-01-05',0),(44,'Aleksandra','Stach','astach','aleolaholaci','olaea@gmail.com','999999995','98010600000','1998-01-06',0),(45,'Mariola','Fredzel','mfredzel','abecadlo','mfre@gmail.com','999999994','98010700000','1998-01-07',0),(46,'Zuzanna','Labrador','zlablador','lubiepsy','zuzax@gmail.com','999999993','98010800000','1998-01-08',0),(47,'Kamila','Tacka','ktacka','domieszania','ktacka@gmail.com','999999992','98010900000','1998-01-09',0),(48,'Mariusz','Zelmer','mzelmer','czajnik33jedz','zelmer@gmail.com','999999990','97010010000','1997-01-09',0),(49,'Marcelina','Litera','mlitera','literator','literka@gmail.com','999999901','97010920000','1997-01-09',0),(50,'Natalia','Kwiat','nkwiat','stokrotka','natka@gmail.com','999999911','97010930000','1997-01-09',0),(51,'Aleksander','Kowalczyk','akowalczyk','robimyjave','alutek@gmail.com','999999921','97010940000','1997-01-09',0),(52,'Sebastian','Obora','sobora','nowiemprzeciez','sebus@gmail.com','999999932','97010950000','1997-01-04',0),(54,'Krzysztof','Palka','kpalka','matematyka','mocny@gmail.com','999992232','60040240000','1960-04-02',1),(55,'Dorota','Prusak','dprusak','polski','doris@gmail.com','123123123','94010120004','1994-01-01',1),(56,'Katarzyna','Samborska','ksamborska','angielski','kuflikk@gmail.com','429429112','90040200401','1990-04-02',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_subject`
--

DROP TABLE IF EXISTS `user_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_subject` (
  `user_id` int NOT NULL,
  `subject_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`subject_id`),
  KEY `fk_us_u_idx` (`user_id`),
  KEY `fk_us_s_idx` (`subject_id`),
  CONSTRAINT `fk_us_s` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_us_u` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_subject`
--

LOCK TABLES `user_subject` WRITE;
/*!40000 ALTER TABLE `user_subject` DISABLE KEYS */;
INSERT INTO `user_subject` VALUES (40,31),(40,32),(40,33),(41,31),(41,32),(41,33),(42,31),(42,32),(42,33),(43,31),(43,32),(43,33),(44,34),(44,35),(44,36),(45,34),(45,35),(45,36),(46,34),(46,35),(46,36),(47,34),(47,35),(47,36),(48,37),(48,38),(48,39),(49,37),(49,38),(49,39),(50,37),(50,38),(50,39),(51,37),(51,38),(51,39),(52,37),(52,38),(52,39),(54,31),(54,34),(54,37),(55,32),(55,35),(55,38),(56,33),(56,36),(56,39);
/*!40000 ALTER TABLE `user_subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-25 17:01:32
