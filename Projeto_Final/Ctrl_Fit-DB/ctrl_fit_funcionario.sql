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
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `Codigo_Func` int NOT NULL AUTO_INCREMENT,
  `Nome_Func` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `Cargo_Func` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `Cpf_Func` varchar(14) COLLATE utf8mb4_general_ci NOT NULL,
  `DtNascimento_Func` date NOT NULL,
  `Telefone_Func` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Celular_Func` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `Endereco_Func` varchar(150) COLLATE utf8mb4_general_ci NOT NULL,
  `Bairro_Func` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `Cep_Func` varchar(14) COLLATE utf8mb4_general_ci NOT NULL,
  `Sexo_Func` char(1) COLLATE utf8mb4_general_ci NOT NULL,
  `Salario_Func` decimal(10,2) NOT NULL,
  `DtAdmissao_Func` date NOT NULL,
  `Email_Func` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Senha_Func` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Usuario_Func` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Codigo_Usuario` int NOT NULL,
  PRIMARY KEY (`Codigo_Func`),
  UNIQUE KEY `Cpf_Func_UNIQUE` (`Cpf_Func`),
  KEY `fk_Codigo_Usuario` (`Codigo_Usuario`),
  CONSTRAINT `fk_Codigo_Usuario` FOREIGN KEY (`Codigo_Usuario`) REFERENCES `usuario_sistema` (`Codigo_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Carlos Nascimento','Gerente','123.456.789-10','1975-11-02','(11)1234-5678','(11)98765-4321','Av. Exemplo','Bairro Exemplo','12345-000','M',0.00,'2024-10-06','exemplo.teste@email.com','123456','carlos_nascimento_gerente',0),(2,'Eduarda Campos','Recepcionista','123.456.677-88','1992-03-01','(11)1234-5678','(11)98765-4321','Rua Exemplo','Bairro Exemplo','12345-000','F',2100.00,'2024-10-06','exemplo.teste@email.com','123456','eduarda_campos_recepcionista',0),(3,'Roberto Barros','Instrutor','123.456.789-46','1983-04-17','(11)1111-1123','(11)98765-4321','Av. Teste','Bairro Exemplo','12345-000','M',3500.00,'2024-10-06','exemplo.teste@email.com','123456','roberto_barros_instrutor',0);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_insert_funcionario` AFTER INSERT ON `funcionario` FOR EACH ROW BEGIN
    INSERT INTO Usuario_Sistema (Codigo_Usuario, Nome_Usuario, Senha_Usuario, Cargo_Usuario)
    VALUES (NEW.Codigo_Func, NEW.Usuario_Func, NEW.Senha_Func, NEW.Cargo_Func);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_update_funcionario` AFTER UPDATE ON `funcionario` FOR EACH ROW BEGIN
    UPDATE Usuario_Sistema
    SET Nome_Usuario = NEW.Usuario_Func,
        Senha_Usuario = NEW.Senha_Func,
        Cargo_Usuario = NEW.Cargo_Func
    WHERE Codigo_Usuario = OLD.Codigo_Func;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ZERO_IN_DATE,NO_ZERO_DATE,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_delete_funcionario` AFTER DELETE ON `funcionario` FOR EACH ROW BEGIN
    DELETE FROM Usuario_Sistema
    WHERE Codigo_Usuario = OLD.Codigo_Func;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-12 12:25:17
