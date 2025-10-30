-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: daweb2
-- ------------------------------------------------------
-- Server version	9.4.0

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
-- Table structure for table `orders`
--
create database daweb2;
use daweb2;

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `OrderId` int NOT NULL AUTO_INCREMENT,
  `OrderCount` bigint NOT NULL,
  `OrderPrice` bigint NOT NULL,
  `OrderStatus` int NOT NULL,
  `ProductId` int DEFAULT NULL,
  `UserId` int DEFAULT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `FKquwao9vgtk7t92ciy34cg7wkc` (`ProductId`),
  KEY `FKlj9lgmu9u65vgmm6a9tmnjry7` (`UserId`),
  CONSTRAINT `FKlj9lgmu9u65vgmm6a9tmnjry7` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`),
  CONSTRAINT `FKquwao9vgtk7t92ciy34cg7wkc` FOREIGN KEY (`ProductId`) REFERENCES `product` (`ProductId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,120000,3,1,1),(2,1,85000,3,9,1),(3,1,260000,3,8,3),(4,1,120000,3,1,1),(5,1,120000,3,1,1),(6,1,135000,3,2,1),(7,1,135000,3,2,1),(8,1,480000,3,4,1),(9,1,85000,3,9,1),(10,1,85000,3,9,1),(11,1,120000,3,1,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ProductId` int NOT NULL AUTO_INCREMENT,
  `ProductAmount` bigint DEFAULT NULL,
  `ProductImage` varchar(200) DEFAULT NULL,
  `ProductName` varchar(200) NOT NULL,
  `ProductPrice` bigint DEFAULT NULL,
  `ProductCategoryId` int DEFAULT NULL,
  PRIMARY KEY (`ProductId`),
  KEY `FKihu2sxtypatumfr2hnbknolfk` (`ProductCategoryId`),
  CONSTRAINT `FKihu2sxtypatumfr2hnbknolfk` FOREIGN KEY (`ProductCategoryId`) REFERENCES `productcategory` (`ProductCategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,7,'barbatos_m.jpeg','Gundam Barbatos MG 1/100',1200000,1),(2,8,'exia_m.jpeg','Gundam Exia MG 1/100',1350000,1),(3,5,'unicorn_p.jpeg','Unicorn Gundam PG 1/60',5200000,2),(4,3,'wingzero_p.jpeg','Wing Zero Custom PG 1/60',4800000,2),(5,2,'strikefreedom_meta.jpeg','Gundam Metal Build Strike Freedom',7500000,3),(6,1,'rx78_chogoki.jpeg','Chogokin RX-78-2 Gundam 40th Anniversary',8200000,3),(7,7,'ligerzero_zoid.jpeg','Liger Zero ZOIDS',2100000,4),(8,3,'vf25_macros.jpeg','Macross VF-25 Messiah Valkyrie',2600000,4),(9,13,'godhand_nippe.jpeg','Kìm cắt mô hình GodHand SPN-120',850000,5),(10,50,'tamiya_blac.jpeg','Sơn Tamiya Acrylic XF-1 (Black)',65000,5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcategory`
--

DROP TABLE IF EXISTS `productcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productcategory` (
  `ProductCategoryId` int NOT NULL AUTO_INCREMENT,
  `ProductCategoryName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductCategoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcategory`
--

LOCK TABLES `productcategory` WRITE;
/*!40000 ALTER TABLE `productcategory` DISABLE KEYS */;
INSERT INTO `productcategory` VALUES (1,'MG 1/100'),(2,'PG 1/60'),(3,'Metabuild / Chogokin'),(4,'Zoids / Macross / Other'),(5,'Tools & Phụ kiện'),(6,'MG 1/100'),(7,'PG 1/60'),(8,'Metabuild / Chogokin'),(9,'Zoids / Macross / Other'),(10,'Tools & Phụ kiện');
/*!40000 ALTER TABLE `productcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `RatingId` int NOT NULL AUTO_INCREMENT,
  `ProductId` int DEFAULT NULL,
  `RatingComment` varchar(500) DEFAULT NULL,
  `RatingDate` date DEFAULT NULL,
  `RatingValue` int DEFAULT NULL,
  `UserId` int DEFAULT NULL,
  PRIMARY KEY (`RatingId`),
  KEY `FKshofjukkstpbaij8a3k8x4lgq` (`UserId`),
  CONSTRAINT `FKshofjukkstpbaij8a3k8x4lgq` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,1,'đẹp','2025-10-30',5,1);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `TransId` int NOT NULL AUTO_INCREMENT,
  `TransAddress` varchar(200) NOT NULL,
  `TransStatus` int DEFAULT NULL,
  `TransTotalValue` bigint DEFAULT NULL,
  `TransDay` date NOT NULL,
  `UserId` int DEFAULT NULL,
  PRIMARY KEY (`TransId`),
  KEY `FKmbjwbnh8iao66rrrpj1pt28a7` (`UserId`),
  CONSTRAINT `FKmbjwbnh8iao66rrrpj1pt28a7` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,'24 Hàn Thuyên Bình Thọ quận Thủ Đức Hồ Chí Minh',1,1200000,'2025-10-29',1),(2,'24 Hàn Thuyên Bình Thọ quận Thủ Đức Hồ Chí Minh',1,850000,'2025-10-30',1),(3,'56 le van viet',1,2600000,'2025-10-30',3);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `UserId` int NOT NULL AUTO_INCREMENT,
  `UserEmail` varchar(200) NOT NULL,
  `UserImage` varchar(100) DEFAULT NULL,
  `UserIsAdmin` bit(1) DEFAULT NULL,
  `UserName` varchar(100) NOT NULL,
  `UserPassword` varchar(400) NOT NULL,
  `UserPhone` varchar(13) NOT NULL,
  `userRegisDay` date NOT NULL,
  `UserAddress` varchar(200) NOT NULL,
  `UserFullName` varchar(200) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'tetsunguyen1@gmail.com','TKFm9IF18IjjfdBAwPTu.jpeg',_binary '\0','Truong','2c81f3d6fcab1827c76414ac293cd587cb208828e6b77f699067a2f10926cf301293db335e2ae7b17808a6106ec9c0fe38ebd301c35ee40e066cdcdc57ecbcad','0846003179','2025-10-29','24 Hàn Thuyên Bình Thọ quận Thủ Đức Hồ Chí Minh','Quang Truong'),(2,'admin@gmail.com','1qjHg1onDW0keZiPPb64.jpeg',_binary '','admin','2c81f3d6fcab1827c76414ac293cd587cb208828e6b77f699067a2f10926cf301293db335e2ae7b17808a6106ec9c0fe38ebd301c35ee40e066cdcdc57ecbcad','0945678977','2025-10-29','43 han thuyen','admin'),(3,'hungnguyen@gmail.com','uHM0dsBHXBGUSck3lhWb.jpeg',_binary '\0','hung','2c81f3d6fcab1827c76414ac293cd587cb208828e6b77f699067a2f10926cf301293db335e2ae7b17808a6106ec9c0fe38ebd301c35ee40e066cdcdc57ecbcad','0847003478','2025-10-29','56 le van viet','hungnguyen');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-30 17:02:55
