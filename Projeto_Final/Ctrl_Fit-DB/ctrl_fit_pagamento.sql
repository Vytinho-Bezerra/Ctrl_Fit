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
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento` (
  `Codigo_Pagamento` int NOT NULL AUTO_INCREMENT,
  `NomeAluno_Pagamento` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Plano_Pagamento` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Preco_Pagamento` decimal(10,2) DEFAULT NULL,
  `Forma_Pagamento` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Dt_Pagamento` date DEFAULT NULL,
  `DtInicio_Aluno` date DEFAULT NULL,
  `DtFim_Aluno` date DEFAULT NULL,
  `Situacao_Aluno` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Aluno_Matricula_Aluno` int NOT NULL,
  PRIMARY KEY (`Codigo_Pagamento`),
  KEY `Aluno_Matricula_Aluno` (`Aluno_Matricula_Aluno`),
  CONSTRAINT `pagamento_ibfk_2` FOREIGN KEY (`Aluno_Matricula_Aluno`) REFERENCES `aluno` (`Matricula_Aluno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (1,'Rafaela Costa','Mensal',80.00,'Cartão','2024-10-06','2024-10-06','2024-11-06','Ativa',1001),(2,'Jéssica de Oliveira','Trimestral',225.00,'Pix','2024-06-06','2024-06-06','2024-09-06','Pendente',1002),(3,'Marcelo Ramos','Mensal',80.00,'Dinheiro','2023-10-06','2023-10-06','2023-11-06','Encerrada',1003);
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-12 12:25:18
