-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        8.0.23 - MySQL Community Server - GPL
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 srm 的数据库结构
CREATE DATABASE IF NOT EXISTS `srm` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `srm`;

-- 导出  表 srm.t_admin 结构
CREATE TABLE IF NOT EXISTS `t_admin` (
  `adminId` int NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) DEFAULT NULL,
  `adminPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_admin 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT IGNORE INTO `t_admin` (`adminId`, `adminName`, `adminPassword`) VALUES
	(1, 'admin', 'admin');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;

-- 导出  表 srm.t_buzhi 结构
CREATE TABLE IF NOT EXISTS `t_buzhi` (
  `buzhiId` int NOT NULL AUTO_INCREMENT,
  `buzhiName` varchar(255) DEFAULT NULL,
  `buzhiMark` varchar(255) DEFAULT NULL,
  `buzhiMark1` varchar(255) DEFAULT NULL,
  `buzhiMark2` varchar(255) DEFAULT NULL,
  `buzhiType` int DEFAULT NULL,
  `buzhiType1` int DEFAULT NULL,
  `buzhiType2` int DEFAULT NULL,
  `buzhiDouble` double DEFAULT NULL,
  `buzhiDouble1` double DEFAULT NULL,
  `buzhiDouble2` double DEFAULT NULL,
  `buyuanId` int DEFAULT NULL,
  `buyuanName` varchar(255) DEFAULT NULL,
  `bumenId` int DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`buzhiId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_buzhi 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_buzhi` DISABLE KEYS */;
INSERT IGNORE INTO `t_buzhi` (`buzhiId`, `buzhiName`, `buzhiMark`, `buzhiMark1`, `buzhiMark2`, `buzhiType`, `buzhiType1`, `buzhiType2`, `buzhiDouble`, `buzhiDouble1`, `buzhiDouble2`, `buyuanId`, `buyuanName`, `bumenId`, `bumenName`) VALUES
	(1, '东城', '阿斯蒂芬', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '西城', '阿斯顿发大发', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

/*!40000 ALTER TABLE `t_buzhi` ENABLE KEYS */;

-- 导出  表 srm.t_jcbiaoti 结构
CREATE TABLE IF NOT EXISTS `t_jcbiaoti` (
  `jcbiaotiId` int NOT NULL AUTO_INCREMENT,
  `jcbiaotiName` varchar(255) DEFAULT NULL COMMENT '汉字',
  `jcbiaotiNeirong` varchar(255) DEFAULT NULL COMMENT 'url',
  `jcbiaotiMark` varchar(255) DEFAULT NULL,
  `jcbiaotiMark1` varchar(255) DEFAULT NULL,
  `jcbiaotiMark2` varchar(255) DEFAULT NULL,
  `jcbiaotiPaixu` int DEFAULT NULL,
  `jcbiaotiType` int DEFAULT NULL COMMENT '0网页导航1admin导航2user导航3yonghu导航4juese导航',
  `jcbiaotiType1` int DEFAULT NULL,
  `jcbiaotiType2` int DEFAULT NULL,
  PRIMARY KEY (`jcbiaotiId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_jcbiaoti 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `t_jcbiaoti` DISABLE KEYS */;
INSERT IGNORE INTO `t_jcbiaoti` (`jcbiaotiId`, `jcbiaotiName`, `jcbiaotiNeirong`, `jcbiaotiMark`, `jcbiaotiMark1`, `jcbiaotiMark2`, `jcbiaotiPaixu`, `jcbiaotiType`, `jcbiaotiType1`, `jcbiaotiType2`) VALUES
	(1, '用户信息', NULL, NULL, NULL, NULL, 1, 1, 0, NULL),
	(2, '业务员信息', NULL, NULL, NULL, NULL, 2, 1, 0, NULL),
	(3, '车辆信息', NULL, NULL, NULL, NULL, 3, 1, 0, NULL),
	(4, '报价信息', NULL, NULL, NULL, NULL, 4, 1, 0, NULL),
	(5, '交流下单', NULL, NULL, NULL, NULL, 5, 1, 0, NULL),
	(6, '车辆信息', NULL, NULL, NULL, NULL, 1, 2, 0, NULL),
	(7, '报价信息', NULL, NULL, NULL, NULL, 2, 2, 0, NULL),
	(8, '交流下单', NULL, NULL, NULL, NULL, 3, 2, 0, NULL),
	(9, '车辆信息', NULL, NULL, NULL, NULL, 1, 3, 0, NULL),
	(10, '报价信息', NULL, NULL, NULL, NULL, 2, 3, 0, NULL),
	(11, '交流下单', NULL, NULL, NULL, NULL, 3, 3, 0, NULL);
/*!40000 ALTER TABLE `t_jcbiaoti` ENABLE KEYS */;

-- 导出  表 srm.t_jcdaohang 结构
CREATE TABLE IF NOT EXISTS `t_jcdaohang` (
  `jcdaohangId` int NOT NULL AUTO_INCREMENT,
  `jcdaohangName` varchar(255) DEFAULT NULL COMMENT '汉字',
  `jcdaohangNeirong` varchar(255) DEFAULT NULL COMMENT 'url',
  `jcdaohangMark` varchar(255) DEFAULT NULL,
  `jcdaohangMark1` varchar(255) DEFAULT NULL,
  `jcdaohangMark2` varchar(255) DEFAULT NULL,
  `jcdaohangPaixu` int DEFAULT NULL,
  `jcdaohangType` int DEFAULT NULL COMMENT '0网页导航1admin导航2user导航3yonghu导航4juese导航',
  `jcdaohangType1` int DEFAULT NULL,
  `jcdaohangType2` int DEFAULT NULL,
  `jcbiaotiId` int DEFAULT NULL,
  `jcbiaotiName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jcdaohangId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_jcdaohang 的数据：~16 rows (大约)
/*!40000 ALTER TABLE `t_jcdaohang` DISABLE KEYS */;
INSERT IGNORE INTO `t_jcdaohang` (`jcdaohangId`, `jcdaohangName`, `jcdaohangNeirong`, `jcdaohangMark`, `jcdaohangMark1`, `jcdaohangMark2`, `jcdaohangPaixu`, `jcdaohangType`, `jcdaohangType1`, `jcdaohangType2`, `jcbiaotiId`, `jcbiaotiName`) VALUES
	(1, '区域信息', 'buzhi', NULL, NULL, NULL, 1, 1, 0, NULL, 1, NULL),
	(2, '用户信息', 'user', NULL, NULL, NULL, 2, 1, 0, NULL, 1, NULL),
	(3, '业务员信息', 'yonghu', NULL, NULL, NULL, 1, 1, 0, NULL, 2, NULL),
	(4, '车辆类型', 'sjleixing', NULL, NULL, NULL, 1, 1, 0, NULL, 3, NULL),
	(5, '车辆信息', 'shuju', NULL, NULL, NULL, 2, 1, 0, NULL, 3, NULL),
	(6, '报价信息', 'sjduochu', NULL, NULL, NULL, 1, 1, 0, NULL, 4, NULL),
	(7, '交流信息', 'sjjianchu', NULL, NULL, NULL, 1, 1, 0, NULL, 5, NULL),
	(8, '下单信息', 'sjshaochu', NULL, NULL, NULL, 2, 1, 0, NULL, 5, NULL),
	(9, '车辆信息', 'shuju', NULL, NULL, NULL, 1, 2, 0, NULL, 6, NULL),
	(10, '报价信息', 'sjduochu', NULL, NULL, NULL, 1, 2, 0, NULL, 7, NULL),
	(11, '交流信息', 'sjjianchu', NULL, NULL, NULL, 1, 2, 0, NULL, 8, NULL),
	(12, '下单信息', 'sjshaochu', NULL, NULL, NULL, 2, 2, 0, NULL, 8, NULL),
	(13, '车辆信息', 'shuju', NULL, NULL, NULL, 1, 3, 0, NULL, 9, NULL),
	(14, '报价信息', 'sjduochu', NULL, NULL, NULL, 1, 3, 0, NULL, 10, NULL),
	(15, '交流信息', 'sjjianchu', NULL, NULL, NULL, 1, 3, 0, NULL, 11, NULL),
	(16, '下单信息', 'sjshaochu', NULL, NULL, NULL, 2, 3, 0, NULL, 11, NULL);
/*!40000 ALTER TABLE `t_jcdaohang` ENABLE KEYS */;

-- 导出  表 srm.t_jcpeizhi 结构
CREATE TABLE IF NOT EXISTS `t_jcpeizhi` (
  `jcpeizhiId` int NOT NULL AUTO_INCREMENT,
  `jcpeizhiName` varchar(255) DEFAULT NULL,
  `jcpeizhiNeirong` varchar(255) DEFAULT NULL,
  `jcpeizhiMark` varchar(255) DEFAULT NULL,
  `bumenBieming` varchar(255) DEFAULT NULL,
  `buyuanBieming` varchar(255) DEFAULT NULL,
  `buzhiBieming` varchar(255) DEFAULT NULL,
  `userBieming` varchar(255) DEFAULT NULL COMMENT 'userBieming',
  `uxtypeBieming` varchar(255) DEFAULT NULL,
  `uxinxiBieming` varchar(255) DEFAULT NULL,
  `uyijianBieming` varchar(255) DEFAULT NULL,
  `roleBieming` varchar(255) DEFAULT NULL,
  `byumenBieming` varchar(255) DEFAULT NULL,
  `byuyuanBieming` varchar(255) DEFAULT NULL,
  `byuzhiBieming` varchar(255) DEFAULT NULL,
  `yonghuBieming` varchar(255) DEFAULT NULL COMMENT 'yonghuBieming',
  `yxtypeBieming` varchar(255) DEFAULT NULL,
  `yxinxiBieming` varchar(255) DEFAULT NULL,
  `yyijianBieming` varchar(255) DEFAULT NULL,
  `yhroleBieming` varchar(255) DEFAULT NULL,
  `ggtypeBieming` varchar(255) DEFAULT NULL,
  `gonggaoBieming` varchar(255) DEFAULT NULL,
  `ggpinglunBieming` varchar(255) DEFAULT NULL,
  `shujuBieming` varchar(255) DEFAULT NULL,
  `sjduochuBieming` varchar(255) DEFAULT NULL,
  `sjjianchuBieming` varchar(255) DEFAULT NULL,
  `sjlaiyuanBieming` varchar(255) DEFAULT NULL,
  `sjleixingBieming` varchar(255) DEFAULT NULL,
  `sjpinglunBieming` varchar(255) DEFAULT NULL,
  `sjqitaBieming` varchar(255) DEFAULT NULL,
  `sjshaochuBieming` varchar(255) DEFAULT NULL,
  `sjxingtaiBieming` varchar(255) DEFAULT NULL,
  `jcpeizhiType` int DEFAULT NULL,
  `jcpeizhiType1` int DEFAULT NULL,
  `jcpeizhiType2` int DEFAULT NULL,
  PRIMARY KEY (`jcpeizhiId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_jcpeizhi 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_jcpeizhi` DISABLE KEYS */;
INSERT IGNORE INTO `t_jcpeizhi` (`jcpeizhiId`, `jcpeizhiName`, `jcpeizhiNeirong`, `jcpeizhiMark`, `bumenBieming`, `buyuanBieming`, `buzhiBieming`, `userBieming`, `uxtypeBieming`, `uxinxiBieming`, `uyijianBieming`, `roleBieming`, `byumenBieming`, `byuyuanBieming`, `byuzhiBieming`, `yonghuBieming`, `yxtypeBieming`, `yxinxiBieming`, `yyijianBieming`, `yhroleBieming`, `ggtypeBieming`, `gonggaoBieming`, `ggpinglunBieming`, `shujuBieming`, `sjduochuBieming`, `sjjianchuBieming`, `sjlaiyuanBieming`, `sjleixingBieming`, `sjpinglunBieming`, `sjqitaBieming`, `sjshaochuBieming`, `sjxingtaiBieming`, `jcpeizhiType`, `jcpeizhiType1`, `jcpeizhiType2`) VALUES
	(1, '分布式车险下单', NULL, 'bdm104chexianxiadan', NULL, NULL, '区域', '用户', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '业务员', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '车辆', '报价', '交流', NULL, '类型', NULL, NULL, '下单', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_jcpeizhi` ENABLE KEYS */;

-- 导出  表 srm.t_rizhi 结构
CREATE TABLE IF NOT EXISTS `t_rizhi` (
  `rizhiId` int NOT NULL AUTO_INCREMENT,
  `rizhiName` varchar(255) NOT NULL,
  `dengluIp` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`rizhiId`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_rizhi 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `t_rizhi` DISABLE KEYS */;
INSERT IGNORE INTO `t_rizhi` (`rizhiId`, `rizhiName`, `dengluIp`, `date`) VALUES
	(1, 'admin', '127.0.0.1', '2021-04-14 22:28:13'),
	(2, 'admin', '127.0.0.1', '2021-04-14 22:28:52'),
	(3, 'yonghu1', '127.0.0.1', '2021-04-14 22:30:02'),
	(4, 'yewuyuan3', '127.0.0.1', '2021-04-14 22:30:46'),
	(5, 'yewuyuan1', '127.0.0.1', '2021-04-14 22:31:14'),
	(6, 'yewuyuan2', '127.0.0.1', '2021-04-14 22:31:45'),
	(7, 'yonghu1', '127.0.0.1', '2021-04-14 22:32:06'),
	(8, 'yewuyuan3', '127.0.0.1', '2021-04-14 22:32:28'),
	(9, 'yonghu1', '127.0.0.1', '2021-04-14 22:32:58'),
	(10, 'admin', '127.0.0.1', '2021-04-14 22:33:07'),
	(11, 'admin', '0:0:0:0:0:0:0:1', '2021-05-27 08:38:51'),
	(12, 'admin', '0:0:0:0:0:0:0:1', '2021-05-27 08:40:25'),
	(13, 'admin', '0:0:0:0:0:0:0:1', '2021-05-27 08:52:16'),
	(14, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 06:55:52'),
	(15, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 06:59:00'),
	(16, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 07:55:25'),
	(17, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:02:48'),
	(18, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:03:12'),
	(19, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:05:06'),
	(20, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:05:12'),
	(21, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:06:30'),
	(22, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:06:34'),
	(23, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:13:49'),
	(24, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:15:54'),
	(25, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:18:30'),
	(26, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:18:38'),
	(27, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:18:38'),
	(28, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:18:39'),
	(29, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:18:51'),
	(30, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:22:19'),
	(31, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 08:26:18'),
	(32, 'admin', '0:0:0:0:0:0:0:1', '2021-05-28 09:06:55');
/*!40000 ALTER TABLE `t_rizhi` ENABLE KEYS */;

-- 导出  表 srm.t_shuju 结构
CREATE TABLE IF NOT EXISTS `t_shuju` (
  `shujuId` int NOT NULL AUTO_INCREMENT,
  `shujuName` varchar(255) DEFAULT NULL,
  `shujuMark` varchar(2550) DEFAULT NULL,
  `shujuMark1` varchar(2550) DEFAULT NULL,
  `shujuMark2` varchar(2550) DEFAULT NULL,
  `shujuMark3` varchar(2550) DEFAULT NULL,
  `shujuDate` datetime DEFAULT NULL,
  `shujuDate1` datetime DEFAULT NULL,
  `shujuZong` int DEFAULT NULL,
  `shujuZong1` int DEFAULT NULL,
  `shujuZong2` int DEFAULT NULL,
  `shujuDouble` double DEFAULT NULL,
  `shujuDouble1` double DEFAULT NULL,
  `shujuDouble2` double DEFAULT NULL,
  `shujuDouble3` double DEFAULT NULL,
  `shujuDouble4` double DEFAULT NULL,
  `shujuType` int DEFAULT NULL,
  `shujuType1` int DEFAULT NULL,
  `shujuType2` int DEFAULT NULL,
  `shujuImg` varchar(255) DEFAULT NULL,
  `shujuImgName` varchar(255) DEFAULT NULL,
  `sjleixingId` int DEFAULT NULL,
  `sjleixingName` varchar(255) DEFAULT NULL,
  `sjxingtaiId` int DEFAULT NULL,
  `sjxingtaiName` varchar(255) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `buyuanId` int DEFAULT NULL,
  `buyuanName` varchar(255) DEFAULT NULL,
  `yonghuId` int DEFAULT NULL,
  `yonghuName` varchar(255) DEFAULT NULL,
  `byumenId` int DEFAULT NULL,
  `byumenName` varchar(255) DEFAULT NULL,
  `byuyuanId` int DEFAULT NULL,
  `byuyuanName` varchar(255) DEFAULT NULL,
  `buzhiId` int DEFAULT NULL,
  `buzhiName` varchar(255) DEFAULT NULL,
  `roleId` int DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `byuzhiId` int DEFAULT NULL,
  `byuzhiName` varchar(255) DEFAULT NULL,
  `yhroleId` int DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`shujuId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_shuju 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_shuju` DISABLE KEYS */;
INSERT IGNORE INTO `t_shuju` (`shujuId`, `shujuName`, `shujuMark`, `shujuMark1`, `shujuMark2`, `shujuMark3`, `shujuDate`, `shujuDate1`, `shujuZong`, `shujuZong1`, `shujuZong2`, `shujuDouble`, `shujuDouble1`, `shujuDouble2`, `shujuDouble3`, `shujuDouble4`, `shujuType`, `shujuType1`, `shujuType2`, `shujuImg`, `shujuImgName`, `sjleixingId`, `sjleixingName`, `sjxingtaiId`, `sjxingtaiName`, `userId`, `userName`, `bumenId`, `bumenName`, `buyuanId`, `buyuanName`, `yonghuId`, `yonghuName`, `byumenId`, `byumenName`, `byuyuanId`, `byuyuanName`, `buzhiId`, `buzhiName`, `roleId`, `roleName`, `byuzhiId`, `byuzhiName`, `yhroleId`, `yhroleName`) VALUES
	(1, '车辆信息1', '车辆信息', '车辆信息', '车辆信息', '车辆信息', '2021-04-14 22:30:17', NULL, 100, NULL, NULL, 5000, 0, 0, NULL, NULL, 0, NULL, NULL, '/file/00.jpg', '00.jpg', 1, '小车', NULL, NULL, 1, 'yonghu1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '东城', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_shuju` ENABLE KEYS */;

-- 导出  表 srm.t_sjduochu 结构
CREATE TABLE IF NOT EXISTS `t_sjduochu` (
  `sjduochuId` int NOT NULL AUTO_INCREMENT,
  `sjduochuName` varchar(255) DEFAULT NULL,
  `sjduochuMark` varchar(2550) DEFAULT NULL,
  `sjduochuMark1` varchar(2550) DEFAULT NULL,
  `sjduochuMark2` varchar(2550) DEFAULT NULL,
  `sjduochuMark3` varchar(2550) DEFAULT NULL,
  `sjduochuDate` datetime DEFAULT NULL,
  `sjduochuDate1` datetime DEFAULT NULL,
  `sjduochuZong` int DEFAULT NULL,
  `sjduochuZong1` int DEFAULT NULL,
  `sjduochuZong2` int DEFAULT NULL,
  `sjduochuDouble` double DEFAULT NULL,
  `sjduochuDouble1` double DEFAULT NULL,
  `sjduochuDouble2` double DEFAULT NULL,
  `sjduochuType` int DEFAULT NULL,
  `sjduochuType1` int DEFAULT NULL,
  `sjduochuType2` int DEFAULT NULL,
  `sjqitaId` int DEFAULT NULL,
  `sjqitaName` varchar(255) DEFAULT NULL,
  `sjlaiyuanId` int DEFAULT NULL,
  `sjlaiyuanName` varchar(255) DEFAULT NULL,
  `sjduochuImg` varchar(255) DEFAULT NULL,
  `sjduochuImgName` varchar(255) DEFAULT NULL,
  `shujuId` int DEFAULT NULL,
  `shujuName` varchar(255) DEFAULT NULL,
  `sjleixingId` int DEFAULT NULL,
  `sjleixingName` varchar(255) DEFAULT NULL,
  `sjxingtaiId` int DEFAULT NULL,
  `sjxingtaiName` varchar(255) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `buyuanId` int DEFAULT NULL,
  `buyuanName` varchar(255) DEFAULT NULL,
  `yonghuId` int DEFAULT NULL,
  `yonghuName` varchar(255) DEFAULT NULL,
  `byumenId` int DEFAULT NULL,
  `byumenName` varchar(255) DEFAULT NULL,
  `byuyuanId` int DEFAULT NULL,
  `byuyuanName` varchar(255) DEFAULT NULL,
  `buzhiId` int DEFAULT NULL,
  `buzhiName` varchar(255) DEFAULT NULL,
  `roleId` int DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `byuzhiId` int DEFAULT NULL,
  `byuzhiName` varchar(255) DEFAULT NULL,
  `yhroleId` int DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sjduochuId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_sjduochu 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_sjduochu` DISABLE KEYS */;
INSERT IGNORE INTO `t_sjduochu` (`sjduochuId`, `sjduochuName`, `sjduochuMark`, `sjduochuMark1`, `sjduochuMark2`, `sjduochuMark3`, `sjduochuDate`, `sjduochuDate1`, `sjduochuZong`, `sjduochuZong1`, `sjduochuZong2`, `sjduochuDouble`, `sjduochuDouble1`, `sjduochuDouble2`, `sjduochuType`, `sjduochuType1`, `sjduochuType2`, `sjqitaId`, `sjqitaName`, `sjlaiyuanId`, `sjlaiyuanName`, `sjduochuImg`, `sjduochuImgName`, `shujuId`, `shujuName`, `sjleixingId`, `sjleixingName`, `sjxingtaiId`, `sjxingtaiName`, `userId`, `userName`, `bumenId`, `bumenName`, `buyuanId`, `buyuanName`, `yonghuId`, `yonghuName`, `byumenId`, `byumenName`, `byuyuanId`, `byuyuanName`, `buzhiId`, `buzhiName`, `roleId`, `roleName`, `byuzhiId`, `byuzhiName`, `yhroleId`, `yhroleName`) VALUES
	(1, '阿打算复读三', '范德萨发答案的法萨芬的范德萨范德萨', NULL, NULL, NULL, '2021-04-14 22:30:56', NULL, NULL, NULL, NULL, 800, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, '/file/00.jpg', '00.jpg', 1, '车辆信息1', 1, '小车', NULL, NULL, 1, 'yonghu1', NULL, NULL, NULL, NULL, 3, 'yewuyuan3', NULL, NULL, NULL, NULL, 1, '东城', NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '阿斯顿发大水', '范德萨发的说法大沙发撒的发生大范德萨范德萨', NULL, NULL, NULL, '2021-04-14 22:31:28', NULL, NULL, NULL, NULL, 30, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, '/file/01.jpg', '01.jpg', 1, '车辆信息1', 1, '小车', NULL, NULL, 1, 'yonghu1', NULL, NULL, NULL, NULL, 1, 'yewuyuan1', NULL, NULL, NULL, NULL, 1, '东城', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_sjduochu` ENABLE KEYS */;

-- 导出  表 srm.t_sjjianchu 结构
CREATE TABLE IF NOT EXISTS `t_sjjianchu` (
  `sjjianchuId` int NOT NULL AUTO_INCREMENT,
  `sjjianchuName` varchar(255) DEFAULT NULL,
  `sjjianchuMark` varchar(2550) DEFAULT NULL,
  `sjjianchuMark1` varchar(2550) DEFAULT NULL,
  `sjjianchuMark2` varchar(2550) DEFAULT NULL,
  `sjjianchuMark3` varchar(2550) DEFAULT NULL,
  `sjjianchuDate` datetime DEFAULT NULL,
  `sjjianchuDate1` datetime DEFAULT NULL,
  `sjjianchuZong` int DEFAULT NULL,
  `sjjianchuZong1` int DEFAULT NULL,
  `sjjianchuZong2` int DEFAULT NULL,
  `sjjianchuDouble` double DEFAULT NULL,
  `sjjianchuDouble1` double DEFAULT NULL,
  `sjjianchuDouble2` double DEFAULT NULL,
  `sjjianchuType` int DEFAULT NULL,
  `sjjianchuType1` int DEFAULT NULL,
  `sjjianchuType2` int DEFAULT NULL,
  `sjqitaId` int DEFAULT NULL,
  `sjqitaName` varchar(255) DEFAULT NULL,
  `sjlaiyuanId` int DEFAULT NULL,
  `sjlaiyuanName` varchar(255) DEFAULT NULL,
  `sjjianchuImg` varchar(255) DEFAULT NULL,
  `sjjianchuImgName` varchar(255) DEFAULT NULL,
  `shujuId` int DEFAULT NULL,
  `shujuName` varchar(255) DEFAULT NULL,
  `sjleixingId` int DEFAULT NULL,
  `sjleixingName` varchar(255) DEFAULT NULL,
  `sjxingtaiId` int DEFAULT NULL,
  `sjxingtaiName` varchar(255) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `buyuanId` int DEFAULT NULL,
  `buyuanName` varchar(255) DEFAULT NULL,
  `yonghuId` int DEFAULT NULL,
  `yonghuName` varchar(255) DEFAULT NULL,
  `byumenId` int DEFAULT NULL,
  `byumenName` varchar(255) DEFAULT NULL,
  `byuyuanId` int DEFAULT NULL,
  `byuyuanName` varchar(255) DEFAULT NULL,
  `buzhiId` int DEFAULT NULL,
  `buzhiName` varchar(255) DEFAULT NULL,
  `roleId` int DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `byuzhiId` int DEFAULT NULL,
  `byuzhiName` varchar(255) DEFAULT NULL,
  `yhroleId` int DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sjjianchuId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_sjjianchu 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_sjjianchu` DISABLE KEYS */;
INSERT IGNORE INTO `t_sjjianchu` (`sjjianchuId`, `sjjianchuName`, `sjjianchuMark`, `sjjianchuMark1`, `sjjianchuMark2`, `sjjianchuMark3`, `sjjianchuDate`, `sjjianchuDate1`, `sjjianchuZong`, `sjjianchuZong1`, `sjjianchuZong2`, `sjjianchuDouble`, `sjjianchuDouble1`, `sjjianchuDouble2`, `sjjianchuType`, `sjjianchuType1`, `sjjianchuType2`, `sjqitaId`, `sjqitaName`, `sjlaiyuanId`, `sjlaiyuanName`, `sjjianchuImg`, `sjjianchuImgName`, `shujuId`, `shujuName`, `sjleixingId`, `sjleixingName`, `sjxingtaiId`, `sjxingtaiName`, `userId`, `userName`, `bumenId`, `bumenName`, `buyuanId`, `buyuanName`, `yonghuId`, `yonghuName`, `byumenId`, `byumenName`, `byuyuanId`, `byuyuanName`, `buzhiId`, `buzhiName`, `roleId`, `roleName`, `byuzhiId`, `byuzhiName`, `yhroleId`, `yhroleName`) VALUES
	(1, '阿斯蒂芬', '范德萨发的法大大士大夫撒爱的色放', '范德萨得分适当收费范德萨范德萨的方式撒旦法发', NULL, NULL, '2021-04-14 22:32:18', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '车辆信息1', 1, '小车', NULL, NULL, 1, 'yonghu1', NULL, NULL, NULL, NULL, 3, 'yewuyuan3', NULL, NULL, NULL, NULL, 1, '东城', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_sjjianchu` ENABLE KEYS */;

-- 导出  表 srm.t_sjleixing 结构
CREATE TABLE IF NOT EXISTS `t_sjleixing` (
  `sjleixingId` int NOT NULL AUTO_INCREMENT,
  `sjleixingName` varchar(255) DEFAULT NULL,
  `sjleixingMark` varchar(255) DEFAULT NULL,
  `sjleixingMark1` varchar(255) DEFAULT NULL,
  `sjleixingMark2` varchar(255) DEFAULT NULL,
  `sjleixingPhone` varchar(255) DEFAULT NULL,
  `sjleixingDizhi` varchar(255) DEFAULT NULL,
  `sjleixingDate` datetime DEFAULT NULL,
  `sjleixingDate1` datetime DEFAULT NULL,
  `sjleixingType` int DEFAULT NULL,
  `sjleixingType1` int DEFAULT NULL,
  `sjleixingDouble` double DEFAULT NULL,
  `sjleixingDouble1` double DEFAULT NULL,
  PRIMARY KEY (`sjleixingId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_sjleixing 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_sjleixing` DISABLE KEYS */;
INSERT IGNORE INTO `t_sjleixing` (`sjleixingId`, `sjleixingName`, `sjleixingMark`, `sjleixingMark1`, `sjleixingMark2`, `sjleixingPhone`, `sjleixingDizhi`, `sjleixingDate`, `sjleixingDate1`, `sjleixingType`, `sjleixingType1`, `sjleixingDouble`, `sjleixingDouble1`) VALUES
	(1, '小车', '小车', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_sjleixing` ENABLE KEYS */;

-- 导出  表 srm.t_sjpinglun 结构
CREATE TABLE IF NOT EXISTS `t_sjpinglun` (
  `sjpinglunId` int NOT NULL AUTO_INCREMENT,
  `sjpinglunName` varchar(2550) DEFAULT NULL,
  `sjpinglunMark` varchar(2550) DEFAULT NULL,
  `sjpinglunDate` datetime DEFAULT NULL,
  `sjpinglunDate1` datetime DEFAULT NULL,
  `sjpinglunType` int DEFAULT NULL,
  `sjpinglunType1` int DEFAULT NULL,
  `sjpinglunImg` varchar(255) DEFAULT NULL,
  `sjpinglunImgName` varchar(255) DEFAULT NULL,
  `shujuId` int DEFAULT NULL,
  `shujuName` varchar(255) DEFAULT NULL,
  `sjleixingId` int DEFAULT NULL,
  `sjleixingName` varchar(255) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `buyuanId` int DEFAULT NULL,
  `buyuanName` varchar(255) DEFAULT NULL,
  `yonghuId` int DEFAULT NULL,
  `yonghuName` varchar(255) DEFAULT NULL,
  `byumenId` int DEFAULT NULL,
  `byumenName` varchar(255) DEFAULT NULL,
  `byuyuanId` int DEFAULT NULL,
  `byuyuanName` varchar(255) DEFAULT NULL,
  `buzhiId` int DEFAULT NULL,
  `buzhiName` varchar(255) DEFAULT NULL,
  `roleId` int DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `byuzhiId` int DEFAULT NULL,
  `byuzhiName` varchar(255) DEFAULT NULL,
  `yhroleId` int DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sjpinglunId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_sjpinglun 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_sjpinglun` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sjpinglun` ENABLE KEYS */;

-- 导出  表 srm.t_sjshaochu 结构
CREATE TABLE IF NOT EXISTS `t_sjshaochu` (
  `sjshaochuId` int NOT NULL AUTO_INCREMENT,
  `sjshaochuName` varchar(255) DEFAULT NULL,
  `sjshaochuMark` varchar(2550) DEFAULT NULL,
  `sjshaochuMark1` varchar(2550) DEFAULT NULL,
  `sjshaochuMark2` varchar(2550) DEFAULT NULL,
  `sjshaochuMark3` varchar(2550) DEFAULT NULL,
  `sjshaochuDate` datetime DEFAULT NULL,
  `sjshaochuDate1` datetime DEFAULT NULL,
  `sjshaochuZong` int DEFAULT NULL,
  `sjshaochuZong1` int DEFAULT NULL,
  `sjshaochuZong2` int DEFAULT NULL,
  `sjshaochuDouble` double DEFAULT NULL,
  `sjshaochuDouble1` double DEFAULT NULL,
  `sjshaochuDouble2` double DEFAULT NULL,
  `sjshaochuType` int DEFAULT NULL,
  `sjshaochuType1` int DEFAULT NULL,
  `sjshaochuType2` int DEFAULT NULL,
  `sjqitaId` int DEFAULT NULL,
  `sjqitaName` varchar(255) DEFAULT NULL,
  `sjlaiyuanId` int DEFAULT NULL,
  `sjlaiyuanName` varchar(255) DEFAULT NULL,
  `sjshaochuImg` varchar(255) DEFAULT NULL,
  `sjshaochuImgName` varchar(255) DEFAULT NULL,
  `shujuId` int DEFAULT NULL,
  `shujuName` varchar(255) DEFAULT NULL,
  `sjleixingId` int DEFAULT NULL,
  `sjleixingName` varchar(255) DEFAULT NULL,
  `sjxingtaiId` int DEFAULT NULL,
  `sjxingtaiName` varchar(255) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `buyuanId` int DEFAULT NULL,
  `buyuanName` varchar(255) DEFAULT NULL,
  `yonghuId` int DEFAULT NULL,
  `yonghuName` varchar(255) DEFAULT NULL,
  `byumenId` int DEFAULT NULL,
  `byumenName` varchar(255) DEFAULT NULL,
  `byuyuanId` int DEFAULT NULL,
  `byuyuanName` varchar(255) DEFAULT NULL,
  `buzhiId` int DEFAULT NULL,
  `buzhiName` varchar(255) DEFAULT NULL,
  `roleId` int DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `byuzhiId` int DEFAULT NULL,
  `byuzhiName` varchar(255) DEFAULT NULL,
  `yhroleId` int DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sjshaochuId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_sjshaochu 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_sjshaochu` DISABLE KEYS */;
INSERT IGNORE INTO `t_sjshaochu` (`sjshaochuId`, `sjshaochuName`, `sjshaochuMark`, `sjshaochuMark1`, `sjshaochuMark2`, `sjshaochuMark3`, `sjshaochuDate`, `sjshaochuDate1`, `sjshaochuZong`, `sjshaochuZong1`, `sjshaochuZong2`, `sjshaochuDouble`, `sjshaochuDouble1`, `sjshaochuDouble2`, `sjshaochuType`, `sjshaochuType1`, `sjshaochuType2`, `sjqitaId`, `sjqitaName`, `sjlaiyuanId`, `sjlaiyuanName`, `sjshaochuImg`, `sjshaochuImgName`, `shujuId`, `shujuName`, `sjleixingId`, `sjleixingName`, `sjxingtaiId`, `sjxingtaiName`, `userId`, `userName`, `bumenId`, `bumenName`, `buyuanId`, `buyuanName`, `yonghuId`, `yonghuName`, `byumenId`, `byumenName`, `byuyuanId`, `byuyuanName`, `buzhiId`, `buzhiName`, `roleId`, `roleName`, `byuzhiId`, `byuzhiName`, `yhroleId`, `yhroleName`) VALUES
	(1, '车辆下单', '车辆下单', '车辆下单车辆下单车辆下单车辆下单车辆下单车辆下单', NULL, NULL, '2021-04-14 22:32:45', NULL, NULL, NULL, NULL, 33300, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, '/file/02.jpg', '02.jpg', 1, '车辆信息1', 1, '小车', NULL, NULL, 1, 'yonghu1', NULL, NULL, NULL, NULL, 3, 'yewuyuan3', NULL, NULL, NULL, NULL, 1, '东城', NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_sjshaochu` ENABLE KEYS */;

-- 导出  表 srm.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `userXingming` varchar(255) DEFAULT NULL,
  `userSex` int DEFAULT NULL,
  `userAge` int DEFAULT NULL,
  `userMinzu` varchar(255) DEFAULT NULL,
  `userPhone` varchar(255) DEFAULT NULL,
  `userMark` varchar(2550) DEFAULT NULL,
  `userMark1` varchar(255) DEFAULT NULL,
  `userMark2` varchar(255) DEFAULT NULL,
  `userMark3` varchar(255) DEFAULT NULL,
  `userMark4` varchar(255) DEFAULT NULL,
  `userDate` date DEFAULT NULL,
  `userDate1` date DEFAULT NULL,
  `userDate2` date DEFAULT NULL,
  `userType` int DEFAULT NULL,
  `userType1` int DEFAULT NULL,
  `userType2` int DEFAULT NULL,
  `userDouble` double DEFAULT NULL,
  `userDouble1` double DEFAULT NULL,
  `userDouble2` double DEFAULT NULL,
  `userZong` int DEFAULT NULL,
  `userZong1` int DEFAULT NULL,
  `userZong2` int DEFAULT NULL,
  `userImg` varchar(255) DEFAULT NULL,
  `userImgName` varchar(255) DEFAULT NULL,
  `roleId` int DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `bumenId` int DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `buyuanId` int DEFAULT NULL,
  `buyuanName` varchar(255) DEFAULT NULL,
  `buzhiId` int DEFAULT NULL,
  `buzhiName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT IGNORE INTO `t_user` (`userId`, `userName`, `userPassword`, `userXingming`, `userSex`, `userAge`, `userMinzu`, `userPhone`, `userMark`, `userMark1`, `userMark2`, `userMark3`, `userMark4`, `userDate`, `userDate1`, `userDate2`, `userType`, `userType1`, `userType2`, `userDouble`, `userDouble1`, `userDouble2`, `userZong`, `userZong1`, `userZong2`, `userImg`, `userImgName`, `roleId`, `roleName`, `bumenId`, `bumenName`, `buyuanId`, `buyuanName`, `buzhiId`, `buzhiName`) VALUES
	(1, 'yonghu1', 'yonghu1', 'yonghu1', 0, 22, NULL, '13012345678', NULL, '130123456782345678', NULL, NULL, NULL, '2020-04-14', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '东城'),
	(2, 'zhang', 'alskdja', 'zhangjunyi', 1, 24, 'han', '12345678912', NULL, '111111111111111111', NULL, NULL, NULL, '2021-05-20', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 'aaaa');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

-- 导出  表 srm.t_yonghu 结构
CREATE TABLE IF NOT EXISTS `t_yonghu` (
  `yonghuId` int NOT NULL AUTO_INCREMENT,
  `yonghuName` varchar(255) DEFAULT NULL,
  `yonghuPassword` varchar(255) DEFAULT NULL,
  `yonghuXingming` varchar(255) DEFAULT NULL,
  `yonghuSex` int DEFAULT NULL,
  `yonghuAge` int DEFAULT NULL,
  `yonghuPhone` varchar(255) DEFAULT NULL,
  `yonghuMinzu` varchar(255) DEFAULT NULL,
  `yonghuMark` varchar(255) DEFAULT NULL,
  `yonghuMark1` varchar(255) DEFAULT NULL,
  `yonghuMark2` varchar(255) DEFAULT NULL,
  `yonghuMark3` varchar(255) DEFAULT NULL,
  `yonghuMark4` varchar(255) DEFAULT NULL,
  `yonghuDate` datetime DEFAULT NULL,
  `yonghuDate1` datetime DEFAULT NULL,
  `yonghuDate2` datetime DEFAULT NULL,
  `yonghuType` int DEFAULT NULL,
  `yonghuType1` int DEFAULT NULL,
  `yonghuType2` int DEFAULT NULL,
  `yonghuDouble` double DEFAULT NULL,
  `yonghuDouble1` double DEFAULT NULL,
  `yonghuDouble2` double DEFAULT NULL,
  `yonghuZong` int DEFAULT NULL,
  `yonghuZong1` int DEFAULT NULL,
  `yonghuZong2` int DEFAULT NULL,
  `yonghuImg` varchar(255) DEFAULT NULL,
  `yonghuImgName` varchar(255) DEFAULT NULL,
  `yhroleId` int DEFAULT NULL,
  `yhroleName` varchar(255) DEFAULT NULL,
  `byuzhiId` int DEFAULT NULL,
  `byuzhiName` varchar(255) DEFAULT NULL,
  `byumenId` int DEFAULT NULL,
  `byumenName` varchar(255) DEFAULT NULL,
  `byuyuanId` int DEFAULT NULL,
  `byuyuanName` varchar(255) DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `bumenId` int DEFAULT NULL,
  `bumenName` varchar(255) DEFAULT NULL,
  `buyuanId` int DEFAULT NULL,
  `buyuanName` varchar(255) DEFAULT NULL,
  `buzhiId` int DEFAULT NULL,
  `buzhiName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`yonghuId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  srm.t_yonghu 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_yonghu` DISABLE KEYS */;
INSERT IGNORE INTO `t_yonghu` (`yonghuId`, `yonghuName`, `yonghuPassword`, `yonghuXingming`, `yonghuSex`, `yonghuAge`, `yonghuPhone`, `yonghuMinzu`, `yonghuMark`, `yonghuMark1`, `yonghuMark2`, `yonghuMark3`, `yonghuMark4`, `yonghuDate`, `yonghuDate1`, `yonghuDate2`, `yonghuType`, `yonghuType1`, `yonghuType2`, `yonghuDouble`, `yonghuDouble1`, `yonghuDouble2`, `yonghuZong`, `yonghuZong1`, `yonghuZong2`, `yonghuImg`, `yonghuImgName`, `yhroleId`, `yhroleName`, `byuzhiId`, `byuzhiName`, `byumenId`, `byumenName`, `byuyuanId`, `byuyuanName`, `userId`, `userName`, `bumenId`, `bumenName`, `buyuanId`, `buyuanName`, `buzhiId`, `buzhiName`) VALUES
	(1, 'yewuyuan1', 'yewuyuan1', 'yewuyuan1', 0, 33, '13012345678', NULL, NULL, 'yewuyuan1', NULL, NULL, NULL, '2021-04-14 22:29:40', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '东城'),
	(2, 'yewuyuan2', 'yewuyuan2', 'yewuyuan2', 0, 33, '13012345678', NULL, NULL, 'yewuyuan2', NULL, NULL, NULL, '2021-04-14 22:29:49', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, '西城'),
	(3, 'yewuyuan3', 'yewuyuan3', 'yewuyuan3', 0, 33, '13012345678', NULL, NULL, 'yewuyuan3', NULL, NULL, NULL, '2021-04-14 22:30:42', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, '东城');
/*!40000 ALTER TABLE `t_yonghu` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
