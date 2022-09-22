-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: sh-cynosdbmysql-grp-6xmg95sq.sql.tencentcdb.com    Database: eladmin
-- ------------------------------------------------------
-- Server version	5.7.18-cynos-log

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '2f8d023c-e288-11ec-9b3b-b4055d0c52ba:1-172';

--
-- Current Database: `eladmin`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `eladmin` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `eladmin`;

--
-- Table structure for table `code_column_config`
--

DROP TABLE IF EXISTS `code_column_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `code_column_config` (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `table_name` varchar(255) DEFAULT NULL,
  `column_name` varchar(255) DEFAULT NULL,
  `column_type` varchar(255) DEFAULT NULL,
  `dict_name` varchar(255) DEFAULT NULL,
  `extra` varchar(255) DEFAULT NULL,
  `form_show` bit(1) DEFAULT NULL,
  `form_type` varchar(255) DEFAULT NULL,
  `key_type` varchar(255) DEFAULT NULL,
  `list_show` bit(1) DEFAULT NULL,
  `not_null` bit(1) DEFAULT NULL,
  `query_type` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `date_annotation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`column_id`) USING BTREE,
  KEY `idx_table_name` (`table_name`)
) ENGINE=InnoDB AUTO_INCREMENT=197 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='代码生成字段信息存储';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_column_config`
--

LOCK TABLES `code_column_config` WRITE;
/*!40000 ALTER TABLE `code_column_config` DISABLE KEYS */;
INSERT INTO `code_column_config` VALUES (191,'table_name','id','int',NULL,'auto_increment',_binary '',NULL,'PRI',_binary '',_binary '\0',NULL,'',NULL),(192,'table_name','name','varchar',NULL,'',_binary '',NULL,'',_binary '',_binary '',NULL,'',NULL),(193,'temp_hum_data','id','int',NULL,'auto_increment',_binary '\0',NULL,'PRI',_binary '\0',_binary '\0','','',NULL),(194,'temp_hum_data','temperature','double',NULL,'',_binary '',NULL,'',_binary '',_binary '',NULL,'温度',NULL),(195,'temp_hum_data','humidity','double',NULL,'',_binary '',NULL,'',_binary '',_binary '',NULL,'湿度',NULL),(196,'temp_hum_data','timestamp','datetime',NULL,'',_binary '',NULL,'',_binary '',_binary '\0',NULL,'时间',NULL);
/*!40000 ALTER TABLE `code_column_config` ENABLE KEYS */;
UNLOCK TABLES;
