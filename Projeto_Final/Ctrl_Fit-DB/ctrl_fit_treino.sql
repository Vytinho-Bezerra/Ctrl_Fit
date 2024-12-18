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
-- Table structure for table `treino`
--

DROP TABLE IF EXISTS `treino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treino` (
  `Codigo_Treino` int NOT NULL AUTO_INCREMENT,
  `Nome_Treino` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Divisao_Treino` char(1) COLLATE utf8mb4_general_ci NOT NULL,
  `QuantSeries_Treino` int NOT NULL,
  `QuantRepeticoes_Treino` int NOT NULL,
  `Observacoes_Treino` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Aluno_Matricula_Aluno` int NOT NULL,
  PRIMARY KEY (`Codigo_Treino`),
  KEY `Aluno_Matricula_Aluno` (`Aluno_Matricula_Aluno`),
  CONSTRAINT `treino_ibfk_2` FOREIGN KEY (`Aluno_Matricula_Aluno`) REFERENCES `aluno` (`Matricula_Aluno`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treino`
--

LOCK TABLES `treino` WRITE;
/*!40000 ALTER TABLE `treino` DISABLE KEYS */;
INSERT INTO `treino` VALUES (1,'Supino Reto com Barra','A',3,12,'Peso moderado, foco na técnica',1001),(2,'Desenvolvimento com Halteres','A',3,10,'Evitar excesso de carga',1001),(3,'Tríceps Pulley','A',3,15,'Aumentar progressivamente',1001),(4,'Puxada Aberta na Polia','B',3,12,'',1001),(5,'Remada Curvada','B',3,10,'',1001),(6,'Rosca Direta com Barra','B',3,12,'Evitar balançar o corpo',1001),(7,'Agachamento Livre','C',3,10,'',1001),(8,'Leg Press','C',3,12,'',1001),(9,'Elevação de Quadril','C',3,15,'',1001);
/*!40000 ALTER TABLE `treino` ENABLE KEYS */;
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
