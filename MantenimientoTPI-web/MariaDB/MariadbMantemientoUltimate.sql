CREATE DATABASE  IF NOT EXISTS `mantenimientoPC` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mantenimientoPC`;
-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: mantenimientoPC
-- ------------------------------------------------------
-- Server version	10.3.5-MariaDB-10.3.5+maria~jessie

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
-- Table structure for table `Calendario`
--

DROP TABLE IF EXISTS `Calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Calendario` (
  `idCalendario` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_mantenimiento` date NOT NULL,
  `excepcion` tinyint(1) NOT NULL,
  PRIMARY KEY (`idCalendario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Calendario`
--

LOCK TABLES `Calendario` WRITE;
/*!40000 ALTER TABLE `Calendario` DISABLE KEYS */;
/*!40000 ALTER TABLE `Calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Diagnostico`
--

DROP TABLE IF EXISTS `Diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Diagnostico` (
  `pK_idDiagnostico` int(2) NOT NULL,
  `OrdenTrabajo_pk_idOrdenTrabajo` int(6) NOT NULL,
  PRIMARY KEY (`pK_idDiagnostico`,`OrdenTrabajo_pk_idOrdenTrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Diagnostico`
--

LOCK TABLES `Diagnostico` WRITE;
/*!40000 ALTER TABLE `Diagnostico` DISABLE KEYS */;
/*!40000 ALTER TABLE `Diagnostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Dianostico_parte`
--

DROP TABLE IF EXISTS `Dianostico_parte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Dianostico_parte` (
  `pk_idDianostico_parte` int(3) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `Diagnostico_pK_idDiagnostico` int(2) NOT NULL,
  `Diagnostico_OrdenTrabajo_pk_idOrdenTrabajo` int(6) NOT NULL,
  `Equipo_detalle_pk_EDnoSerie` varchar(15) NOT NULL,
  PRIMARY KEY (`pk_idDianostico_parte`),
  KEY `fk_Dianostico_parte_Diagnostico1_idx` (`Diagnostico_pK_idDiagnostico`,`Diagnostico_OrdenTrabajo_pk_idOrdenTrabajo`),
  KEY `fk_Dianostico_parte_Equipo_detalle1_idx` (`Equipo_detalle_pk_EDnoSerie`),
  CONSTRAINT `fk_Dianostico_parte_Diagnostico1` FOREIGN KEY (`Diagnostico_pK_idDiagnostico`, `Diagnostico_OrdenTrabajo_pk_idOrdenTrabajo`) REFERENCES `Diagnostico` (`pK_idDiagnostico`, `OrdenTrabajo_pk_idOrdenTrabajo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dianostico_parte_Equipo_detalle1` FOREIGN KEY (`Equipo_detalle_pk_EDnoSerie`) REFERENCES `Equipo_detalle` (`pk_EDnoSerie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Dianostico_parte`
--

LOCK TABLES `Dianostico_parte` WRITE;
/*!40000 ALTER TABLE `Dianostico_parte` DISABLE KEYS */;
/*!40000 ALTER TABLE `Dianostico_parte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipo_detalle`
--

DROP TABLE IF EXISTS `Equipo_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Equipo_detalle` (
  `pk_EDnoSerie` varchar(15) NOT NULL,
  `noInventario` varchar(30) DEFAULT NULL,
  `partNumber` varchar(20) DEFAULT NULL,
  `modelo` varchar(45) DEFAULT NULL,
  `hardware_sofware` tinyint(1) NOT NULL,
  `sofware` varchar(45) DEFAULT NULL,
  `version` varchar(20) DEFAULT NULL,
  `arquitectura3264` tinyint(1) DEFAULT NULL,
  `licencia` tinyint(1) DEFAULT NULL,
  `observaciones` text DEFAULT NULL,
  `fabricantes_idFabricante` int(11) NOT NULL,
  `Equipo_detalle_pk_EDnoSerie` varchar(15) NOT NULL,
  PRIMARY KEY (`pk_EDnoSerie`),
  KEY `fk_Equipo_detalle_fabricantes1_idx` (`fabricantes_idFabricante`),
  KEY `fk_Equipo_detalle_Equipo_detalle1_idx` (`Equipo_detalle_pk_EDnoSerie`),
  CONSTRAINT `fk_Equipo_detalle_Equipo_detalle1` FOREIGN KEY (`Equipo_detalle_pk_EDnoSerie`) REFERENCES `Equipo_detalle` (`pk_EDnoSerie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Equipo_detalle_fabricantes1` FOREIGN KEY (`fabricantes_idFabricante`) REFERENCES `fabricantes` (`idFabricante`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipo_detalle`
--

LOCK TABLES `Equipo_detalle` WRITE;
/*!40000 ALTER TABLE `Equipo_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `Equipo_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estado`
--

DROP TABLE IF EXISTS `Estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estado` (
  `pk_idEstado` int(2) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento` int(3) NOT NULL,
  `Procedimientos_Pasos_pk_idPaso` int(3) NOT NULL,
  `Procedimientos_Dianostico_parte_pk_idDianostico_parte` int(3) NOT NULL,
  PRIMARY KEY (`pk_idEstado`,`Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`,`Procedimientos_Pasos_pk_idPaso`,`Procedimientos_Dianostico_parte_pk_idDianostico_parte`),
  KEY `fk_Estado_Procedimientos1_idx` (`Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`,`Procedimientos_Pasos_pk_idPaso`,`Procedimientos_Dianostico_parte_pk_idDianostico_parte`),
  CONSTRAINT `fk_Estado_Procedimientos1` FOREIGN KEY (`Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`, `Procedimientos_Pasos_pk_idPaso`, `Procedimientos_Dianostico_parte_pk_idDianostico_parte`) REFERENCES `Procedimientos` (`Tipo_procedimiento_pk_idTipo_procedimiento`, `Pasos_pk_idPaso`, `Dianostico_parte_pk_idDianostico_parte`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estado`
--

LOCK TABLES `Estado` WRITE;
/*!40000 ALTER TABLE `Estado` DISABLE KEYS */;
/*!40000 ALTER TABLE `Estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estado_detalle`
--

DROP TABLE IF EXISTS `Estado_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Estado_detalle` (
  `Personal_pk_idPersonal` int(3) NOT NULL,
  `Estado_pk_idEstado` int(2) NOT NULL,
  `Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento` int(3) NOT NULL,
  `Estado_Procedimientos_Pasos_pk_idPaso` int(3) NOT NULL,
  `Estado_Procedimientos_Dianostico_parte_pk_idDianostico_parte` int(3) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Personal_pk_idPersonal`,`Estado_pk_idEstado`,`Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`,`Estado_Procedimientos_Pasos_pk_idPaso`,`Estado_Procedimientos_Dianostico_parte_pk_idDianostico_parte`),
  KEY `fk_Estado_detalle_Estado1_idx` (`Estado_pk_idEstado`,`Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`,`Estado_Procedimientos_Pasos_pk_idPaso`,`Estado_Procedimientos_Dianostico_parte_pk_idDianostico_parte`),
  CONSTRAINT `fk_Estado_detalle_Estado1` FOREIGN KEY (`Estado_pk_idEstado`, `Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`, `Estado_Procedimientos_Pasos_pk_idPaso`, `Estado_Procedimientos_Dianostico_parte_pk_idDianostico_parte`) REFERENCES `Estado` (`pk_idEstado`, `Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`, `Procedimientos_Pasos_pk_idPaso`, `Procedimientos_Dianostico_parte_pk_idDianostico_parte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Estado_detalle_Personal1` FOREIGN KEY (`Personal_pk_idPersonal`) REFERENCES `Personal` (`pk_idPersonal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estado_detalle`
--

LOCK TABLES `Estado_detalle` WRITE;
/*!40000 ALTER TABLE `Estado_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `Estado_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HistorialTrabajo`
--

DROP TABLE IF EXISTS `HistorialTrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HistorialTrabajo` (
  `pk_idHistorialTrabajo` int(6) NOT NULL AUTO_INCREMENT,
  `fechaInicio` date NOT NULL,
  `fechaFin` date DEFAULT NULL,
  `Rol_pk_idRol` int(3) NOT NULL,
  `Personal_pk_idPersonal` int(3) NOT NULL,
  PRIMARY KEY (`pk_idHistorialTrabajo`),
  KEY `fk_HistorialTrabajo_Rol_idx` (`Rol_pk_idRol`),
  KEY `fk_HistorialTrabajo_Personal1_idx` (`Personal_pk_idPersonal`),
  CONSTRAINT `fk_HistorialTrabajo_Personal1` FOREIGN KEY (`Personal_pk_idPersonal`) REFERENCES `Personal` (`pk_idPersonal`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_HistorialTrabajo_Rol` FOREIGN KEY (`Rol_pk_idRol`) REFERENCES `Rol` (`pk_idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HistorialTrabajo`
--

LOCK TABLES `HistorialTrabajo` WRITE;
/*!40000 ALTER TABLE `HistorialTrabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `HistorialTrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Mantenimiento_detalle`
--

DROP TABLE IF EXISTS `Mantenimiento_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Mantenimiento_detalle` (
  `pk_idMantenimiento_detallecol` int(4) NOT NULL,
  `fecha` date NOT NULL,
  `observaciones` text DEFAULT NULL,
  `Equipo_detalle_pk_EDnoSerie` varchar(15) NOT NULL,
  `Estado_pk_idEstado` int(2) NOT NULL,
  `Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento` int(3) NOT NULL,
  `Estado_Procedimientos_Pasos_pk_idPaso` int(3) NOT NULL,
  `Estado_Procedimientos_Dianostico_parte_pk_idDianostico_parte` int(3) NOT NULL,
  `OrdenTrabajo_pk_idOrdenTrabajo` int(6) NOT NULL,
  PRIMARY KEY (`pk_idMantenimiento_detallecol`,`OrdenTrabajo_pk_idOrdenTrabajo`),
  KEY `fk_Mantenimiento_detalle_Equipo_detalle1_idx` (`Equipo_detalle_pk_EDnoSerie`),
  KEY `fk_Mantenimiento_detalle_Estado1_idx` (`Estado_pk_idEstado`,`Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`,`Estado_Procedimientos_Pasos_pk_idPaso`,`Estado_Procedimientos_Dianostico_parte_pk_idDianostico_parte`),
  KEY `fk_Mantenimiento_detalle_OrdenTrabajo1_idx` (`OrdenTrabajo_pk_idOrdenTrabajo`),
  CONSTRAINT `fk_Mantenimiento_detalle_Equipo_detalle1` FOREIGN KEY (`Equipo_detalle_pk_EDnoSerie`) REFERENCES `Equipo_detalle` (`pk_EDnoSerie`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mantenimiento_detalle_Estado1` FOREIGN KEY (`Estado_pk_idEstado`, `Estado_Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`, `Estado_Procedimientos_Pasos_pk_idPaso`, `Estado_Procedimientos_Dianostico_parte_pk_idDianostico_parte`) REFERENCES `Estado` (`pk_idEstado`, `Procedimientos_Tipo_procedimiento_pk_idTipo_procedimiento`, `Procedimientos_Pasos_pk_idPaso`, `Procedimientos_Dianostico_parte_pk_idDianostico_parte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mantenimiento_detalle_OrdenTrabajo1` FOREIGN KEY (`OrdenTrabajo_pk_idOrdenTrabajo`) REFERENCES `OrdenTrabajo` (`pk_idOrdenTrabajo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mantenimiento_detalle`
--

LOCK TABLES `Mantenimiento_detalle` WRITE;
/*!40000 ALTER TABLE `Mantenimiento_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `Mantenimiento_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OrdenTrabajo`
--

DROP TABLE IF EXISTS `OrdenTrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `OrdenTrabajo` (
  `pk_idOrdenTrabajo` int(6) NOT NULL AUTO_INCREMENT,
  `solicitudDescripcion` text DEFAULT NULL,
  `solicitudFecha` date DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `clienteEmail` varchar(45) DEFAULT NULL,
  `clienteTelefono` varchar(15) DEFAULT NULL,
  `clienteDomicilio` varchar(45) DEFAULT NULL,
  `Estado` tinyint(1) NOT NULL,
  `ordenTrabajoAprobadaFecha` date DEFAULT NULL,
  `tecnicoDiagnostico` text DEFAULT NULL,
  `posibleFechaEntrega` date DEFAULT NULL,
  `TipoMantenimiento_pk_idTipoMantenimiento` int(2) NOT NULL,
  `Solicitud_pk_idSolicitud` int(3) NOT NULL,
  `Unidad_pk_idUnidad` int(2) NOT NULL,
  `Prioridad_pk_idPrioridad` int(2) NOT NULL,
  PRIMARY KEY (`pk_idOrdenTrabajo`),
  KEY `fk_OrdenTrabajo_TipoMantenimiento1_idx` (`TipoMantenimiento_pk_idTipoMantenimiento`),
  KEY `fk_OrdenTrabajo_Solicitud1_idx` (`Solicitud_pk_idSolicitud`),
  KEY `fk_OrdenTrabajo_Unidad1_idx` (`Unidad_pk_idUnidad`),
  KEY `fk_OrdenTrabajo_Prioridad1_idx` (`Prioridad_pk_idPrioridad`),
  CONSTRAINT `fk_OrdenTrabajo_Prioridad1` FOREIGN KEY (`Prioridad_pk_idPrioridad`) REFERENCES `Prioridad` (`pk_idPrioridad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdenTrabajo_Solicitud1` FOREIGN KEY (`Solicitud_pk_idSolicitud`) REFERENCES `Solicitud` (`pk_idSolicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdenTrabajo_TipoMantenimiento1` FOREIGN KEY (`TipoMantenimiento_pk_idTipoMantenimiento`) REFERENCES `TipoMantenimiento` (`pk_idTipoMantenimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_OrdenTrabajo_Unidad1` FOREIGN KEY (`Unidad_pk_idUnidad`) REFERENCES `Unidad` (`pk_idUnidad`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrdenTrabajo`
--

LOCK TABLES `OrdenTrabajo` WRITE;
/*!40000 ALTER TABLE `OrdenTrabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `OrdenTrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pasos`
--

DROP TABLE IF EXISTS `Pasos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Pasos` (
  `pk_idPaso` int(3) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `observacion` text DEFAULT NULL,
  `duracion_Paso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk_idPaso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pasos`
--

LOCK TABLES `Pasos` WRITE;
/*!40000 ALTER TABLE `Pasos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Pasos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Personal`
--

DROP TABLE IF EXISTS `Personal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Personal` (
  `pk_idPersonal` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dui` varchar(45) NOT NULL,
  `nit` varchar(45) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `empleadoEstudiante` tinyint(1) NOT NULL,
  `due` varchar(45) DEFAULT NULL,
  `domicilio` varchar(45) NOT NULL,
  PRIMARY KEY (`pk_idPersonal`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Personal`
--

LOCK TABLES `Personal` WRITE;
/*!40000 ALTER TABLE `Personal` DISABLE KEYS */;
INSERT INTO `Personal` VALUES (1,'Juanito','Alcachofa','881851551','84484',1,0,'','SANTA ANA');
/*!40000 ALTER TABLE `Personal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prioridad`
--

DROP TABLE IF EXISTS `Prioridad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Prioridad` (
  `pk_idPrioridad` int(2) NOT NULL AUTO_INCREMENT,
  `PrioridadNivel` varchar(45) NOT NULL,
  PRIMARY KEY (`pk_idPrioridad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prioridad`
--

LOCK TABLES `Prioridad` WRITE;
/*!40000 ALTER TABLE `Prioridad` DISABLE KEYS */;
/*!40000 ALTER TABLE `Prioridad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Procedimientos`
--

DROP TABLE IF EXISTS `Procedimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Procedimientos` (
  `nombre_Procedimiento` varchar(60) DEFAULT NULL,
  `Tipo_procedimiento_pk_idTipo_procedimiento` int(3) NOT NULL,
  `Pasos_pk_idPaso` int(3) NOT NULL,
  `Dianostico_parte_pk_idDianostico_parte` int(3) NOT NULL,
  PRIMARY KEY (`Tipo_procedimiento_pk_idTipo_procedimiento`,`Pasos_pk_idPaso`,`Dianostico_parte_pk_idDianostico_parte`),
  KEY `fk_Procedimientos_Pasos1_idx` (`Pasos_pk_idPaso`),
  KEY `fk_Procedimientos_Dianostico_parte1_idx` (`Dianostico_parte_pk_idDianostico_parte`),
  CONSTRAINT `fk_Procedimientos_Dianostico_parte1` FOREIGN KEY (`Dianostico_parte_pk_idDianostico_parte`) REFERENCES `Dianostico_parte` (`pk_idDianostico_parte`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Procedimientos_Pasos1` FOREIGN KEY (`Pasos_pk_idPaso`) REFERENCES `Pasos` (`pk_idPaso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Procedimientos_Tipo_procedimiento1` FOREIGN KEY (`Tipo_procedimiento_pk_idTipo_procedimiento`) REFERENCES `Tipo_procedimiento` (`pk_idTipo_procedimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Procedimientos`
--

LOCK TABLES `Procedimientos` WRITE;
/*!40000 ALTER TABLE `Procedimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Procedimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Rol`
--

DROP TABLE IF EXISTS `Rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Rol` (
  `pk_idRol` int(3) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`pk_idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Rol`
--

LOCK TABLES `Rol` WRITE;
/*!40000 ALTER TABLE `Rol` DISABLE KEYS */;
INSERT INTO `Rol` VALUES (1,'Limpiador'),(2,'Desamblador'),(3,'Soldador'),(4,'Admnistrativo');
/*!40000 ALTER TABLE `Rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Solicitud`
--

DROP TABLE IF EXISTS `Solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Solicitud` (
  `pk_idSolicitud` int(3) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `correo` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`pk_idSolicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Solicitud`
--

LOCK TABLES `Solicitud` WRITE;
/*!40000 ALTER TABLE `Solicitud` DISABLE KEYS */;
INSERT INTO `Solicitud` VALUES (1,'pedrito','asdas','asdas'),(2,'johanna','asdasd','adas');
/*!40000 ALTER TABLE `Solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sub_TipoMantenimiento`
--

DROP TABLE IF EXISTS `Sub_TipoMantenimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sub_TipoMantenimiento` (
  `pk_idSub_TipoMantenimiento` int(2) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(70) NOT NULL,
  PRIMARY KEY (`pk_idSub_TipoMantenimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sub_TipoMantenimiento`
--

LOCK TABLES `Sub_TipoMantenimiento` WRITE;
/*!40000 ALTER TABLE `Sub_TipoMantenimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `Sub_TipoMantenimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Telefono`
--

DROP TABLE IF EXISTS `Telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Telefono` (
  `pk_idTelefono` int(5) NOT NULL AUTO_INCREMENT,
  `Telefono` varchar(45) NOT NULL,
  `Personal_pk_idPersonal` int(3) NOT NULL,
  PRIMARY KEY (`pk_idTelefono`),
  KEY `fk_Telefono_Personal1_idx` (`Personal_pk_idPersonal`),
  CONSTRAINT `fk_Telefono_Personal1` FOREIGN KEY (`Personal_pk_idPersonal`) REFERENCES `Personal` (`pk_idPersonal`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Telefono`
--

LOCK TABLES `Telefono` WRITE;
/*!40000 ALTER TABLE `Telefono` DISABLE KEYS */;
INSERT INTO `Telefono` VALUES (1,'748515815',1);
/*!40000 ALTER TABLE `Telefono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoMantenimiento`
--

DROP TABLE IF EXISTS `TipoMantenimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TipoMantenimiento` (
  `pk_idTipoMantenimiento` int(2) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(70) NOT NULL,
  `Sub_TipoMantenimiento_pk_idSub_TipoMantenimiento` int(2) NOT NULL,
  PRIMARY KEY (`pk_idTipoMantenimiento`),
  KEY `fk_TipoMantenimiento_Sub_TipoMantenimiento1_idx` (`Sub_TipoMantenimiento_pk_idSub_TipoMantenimiento`),
  CONSTRAINT `fk_TipoMantenimiento_Sub_TipoMantenimiento1` FOREIGN KEY (`Sub_TipoMantenimiento_pk_idSub_TipoMantenimiento`) REFERENCES `Sub_TipoMantenimiento` (`pk_idSub_TipoMantenimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoMantenimiento`
--

LOCK TABLES `TipoMantenimiento` WRITE;
/*!40000 ALTER TABLE `TipoMantenimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `TipoMantenimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tipo_procedimiento`
--

DROP TABLE IF EXISTS `Tipo_procedimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tipo_procedimiento` (
  `pk_idTipo_procedimiento` int(3) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) NOT NULL,
  `observacion` text DEFAULT NULL,
  PRIMARY KEY (`pk_idTipo_procedimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tipo_procedimiento`
--

LOCK TABLES `Tipo_procedimiento` WRITE;
/*!40000 ALTER TABLE `Tipo_procedimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tipo_procedimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Unidad`
--

DROP TABLE IF EXISTS `Unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Unidad` (
  `pk_idUnidad` int(2) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pk_idUnidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Unidad`
--

LOCK TABLES `Unidad` WRITE;
/*!40000 ALTER TABLE `Unidad` DISABLE KEYS */;
INSERT INTO `Unidad` VALUES (1,'Departamento de Economia','');
/*!40000 ALTER TABLE `Unidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabricantes`
--

DROP TABLE IF EXISTS `fabricantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fabricantes` (
  `idFabricante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `descripcion_Fabricante` text DEFAULT NULL,
  `correo_Fabricante` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` text DEFAULT NULL,
  PRIMARY KEY (`idFabricante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricantes`
--

LOCK TABLES `fabricantes` WRITE;
/*!40000 ALTER TABLE `fabricantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `fabricantes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-10  0:59:36
