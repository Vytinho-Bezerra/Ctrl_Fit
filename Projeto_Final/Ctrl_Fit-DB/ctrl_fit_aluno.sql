CREATE DATABASE  IF NOT EXISTS `ctrl_fit` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ctrl_fit`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: ctrl_fit
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aluno` (
  `Matricula_Aluno` int NOT NULL AUTO_INCREMENT,
  `Cpf_Aluno` varchar(14) COLLATE utf8mb4_general_ci NOT NULL,
  `Nome_Aluno` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `DtNascimento_Aluno` date NOT NULL,
  `Sexo_Aluno` char(1) COLLATE utf8mb4_general_ci NOT NULL,
  `Endereco_Aluno` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `Bairro_Aluno` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `Cep_Aluno` varchar(14) COLLATE utf8mb4_general_ci NOT NULL,
  `Telefone_Aluno` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Celular_Aluno` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `Email_Aluno` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`Matricula_Aluno`),
  UNIQUE KEY `Cpf_Aluno_UNIQUE` (`Cpf_Aluno`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1001,'123.456.789-99','Rafaela Costa','2000-11-09','F','Av. Exemplo','Bairro Exemplo','12345-000','(11)1234-5678','(11)98765-4321','rafaela.costa@email.com'),(1002,'123.456.789-01','Jéssica de Oliveira','1997-11-09','F','Rua Exemplo','Bairro Exemplo','12345-000','(11)1234-5678','(11)98765-4321','jessica.oliveira@email.com'),(1003,'123.456.789-10','Marcelo Ramos','1999-03-26','M','Av. Exemplo','Bairro Exemplo','12345-000','(11)1234-5678','(11)98765-4321','marcelo.ramos@email.com');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-12 12:25:17
