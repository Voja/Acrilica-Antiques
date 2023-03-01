/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.8-MariaDB : Database - umetnine
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`umetnine` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `umetnine`;

/*Table structure for table `klijent` */

DROP TABLE IF EXISTS `klijent`;

CREATE TABLE `klijent` (
  `KlijentID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `JMBG` varchar(20) NOT NULL,
  `ImeKlijenta` varchar(20) NOT NULL,
  `PrezimeKlijenta` varchar(30) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `BrojTelefona` varchar(20) NOT NULL,
  PRIMARY KEY (`KlijentID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `klijent` */

insert  into `klijent`(`KlijentID`,`JMBG`,`ImeKlijenta`,`PrezimeKlijenta`,`Status`,`BrojTelefona`) values 
(1,'2311998712356','Marko','Petrovic','GOLD','0631231234'),
(2,'2512996234781','Djordje','Grujic','SILVER','0654645434'),
(3,'0609997372637','Irena','Stanic','STANDARD','0641235153');

/*Table structure for table `materijal` */

DROP TABLE IF EXISTS `materijal`;

CREATE TABLE `materijal` (
  `UmetnickoDeloID` bigint(10) unsigned NOT NULL,
  `RbMaterijala` int(7) NOT NULL,
  `NazivMaterijala` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`UmetnickoDeloID`,`RbMaterijala`),
  CONSTRAINT `fk_umetnickoDelo_id` FOREIGN KEY (`UmetnickoDeloID`) REFERENCES `umetnickodelo` (`UmetnickoDeloID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `materijal` */

insert  into `materijal`(`UmetnickoDeloID`,`RbMaterijala`,`NazivMaterijala`) values 
(1,1,'Platno'),
(1,2,'Vodene boje'),
(2,1,'Porcelan'),
(2,2,'Akrilne boje'),
(3,1,'Bukovina'),
(3,2,'Jasen'),
(4,1,'Mahagoni'),
(4,2,'Orah'),
(4,3,'Intarzija sa pozlatom'),
(4,5,'Koza od kamile'),
(5,1,'Celik'),
(5,2,'Pozlata'),
(5,3,'Rubini'),
(6,1,'Celik'),
(6,2,'Pozlata'),
(7,1,'Uljane boje'),
(7,2,'Tempere'),
(7,3,'Akrilne boje'),
(7,4,'Zlatni ram'),
(7,5,'Platno'),
(8,1,'Porcelan'),
(8,2,'Safiri'),
(8,3,'Akrilne boje'),
(9,1,'Jasen'),
(9,2,'Mahagonij'),
(9,3,'Intarzija od bakra'),
(10,1,'Celik'),
(10,2,'Drska od japanskog javora'),
(10,3,'Pozlacena futrola'),
(11,1,'Celik'),
(11,2,'Srebro'),
(12,1,'Porcelan'),
(12,2,'Rubini'),
(12,3,'Dijamanti'),
(12,4,'Boje za porcelan'),
(13,1,'Gvozdje'),
(13,2,'Drska od bora');

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `RacunID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `DatumVreme` datetime NOT NULL,
  `CenaBezPopusta` decimal(10,2) unsigned NOT NULL,
  `Popust` decimal(10,2) unsigned NOT NULL,
  `CenaSaPopustom` decimal(10,2) unsigned NOT NULL,
  `KlijentID` bigint(10) unsigned NOT NULL,
  `ZaposleniID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`RacunID`),
  KEY `fk2_klijent_id` (`KlijentID`),
  KEY `fk2_zaposleni_id` (`ZaposleniID`),
  CONSTRAINT `fk2_klijent_id` FOREIGN KEY (`KlijentID`) REFERENCES `klijent` (`KlijentID`),
  CONSTRAINT `fk2_zaposleni_id` FOREIGN KEY (`ZaposleniID`) REFERENCES `zaposleni` (`ZaposleniID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `racun` */

insert  into `racun`(`RacunID`,`DatumVreme`,`CenaBezPopusta`,`Popust`,`CenaSaPopustom`,`KlijentID`,`ZaposleniID`) values 
(1,'2022-06-18 19:10:00',545000.00,5.00,490500.00,2,1),
(2,'2022-07-06 17:17:12',49100.00,10.00,44190.00,1,1),
(3,'2022-07-12 01:19:22',3057000.00,10.00,2751300.00,1,1);

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `RacunID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `RbStavke` int(11) NOT NULL,
  `Kolicina` int(7) NOT NULL,
  `CenaStavke` decimal(10,2) unsigned NOT NULL,
  `UmetnickoDeloID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`RacunID`,`RbStavke`),
  KEY `fk_umDelo_id` (`UmetnickoDeloID`),
  CONSTRAINT `fk_racun_id` FOREIGN KEY (`RacunID`) REFERENCES `racun` (`RacunID`) ON DELETE CASCADE,
  CONSTRAINT `fk_umDelo_id` FOREIGN KEY (`UmetnickoDeloID`) REFERENCES `umetnickodelo` (`UmetnickoDeloID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavkaracuna` */

insert  into `stavkaracuna`(`RacunID`,`RbStavke`,`Kolicina`,`CenaStavke`,`UmetnickoDeloID`) values 
(1,1,1,25000.00,2),
(1,2,1,520000.00,3),
(2,1,3,26700.00,9),
(2,2,2,19400.00,5),
(2,3,3,3000.00,6),
(3,1,1,2500000.00,7),
(3,2,1,520000.00,3),
(3,3,1,12000.00,4),
(3,4,1,25000.00,2);

/*Table structure for table `tipdela` */

DROP TABLE IF EXISTS `tipdela`;

CREATE TABLE `tipdela` (
  `TipDelaID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `NazivTipaDela` varchar(50) NOT NULL,
  PRIMARY KEY (`TipDelaID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tipdela` */

insert  into `tipdela`(`TipDelaID`,`NazivTipaDela`) values 
(1,'Slika'),
(2,'Vaza'),
(3,'Sto'),
(4,'Stolica'),
(5,'Mac'),
(6,'Escajg');

/*Table structure for table `umetnickodelo` */

DROP TABLE IF EXISTS `umetnickodelo`;

CREATE TABLE `umetnickodelo` (
  `UmetnickoDeloID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Cena` decimal(10,2) unsigned NOT NULL,
  `Opis` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Unikat` tinyint(1) NOT NULL,
  `TipDelaID` bigint(10) unsigned NOT NULL,
  PRIMARY KEY (`UmetnickoDeloID`),
  KEY `fk_tipDela_id` (`TipDelaID`),
  CONSTRAINT `fk_tipDela_id` FOREIGN KEY (`TipDelaID`) REFERENCES `tipdela` (`TipDelaID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `umetnickodelo` */

insert  into `umetnickodelo`(`UmetnickoDeloID`,`Naziv`,`Cena`,`Opis`,`Unikat`,`TipDelaID`) values 
(1,'Zvezdano nebo - Vincent van Gogh',1000000.00,'Prelepa slika.',1,1),
(2,'Quing Yuhuchunping',25000.00,'Odlicna vaza.',1,2),
(3,'Sto iz doba Lui XV',520000.00,'Super sto.',0,3),
(4,'Stolica Tannenberg',12000.00,'Stolica vrhunskog kvaliteta.',0,4),
(5,'Spanski rapier mac',9700.00,'Mac od legura celika, srebra i platine, iz 17. veka.',0,5),
(6,'Pozlaceni escajg (1 set)',1000.00,'Escajg od 3 kasike, 2 noza i 2 viljuske.',0,6),
(7,'Nocna straza - Rembrandt',2500000.00,'Neprocenjivo umetnicko delo sjajnog slikara Rembrandt Harmenszoon van Rijn-a.',1,1),
(8,'Uspavani zmaj - Ming',1250000.00,'Sjajna vaza iz perioda Ming dinastije.',1,2),
(9,'Italijanski tavolo',8900.00,'Stabilan i lep sto dekorisan u baroknom stilu.',0,3),
(10,'Dvostruki Geom - Silla',650000.00,'Prelep mac koriscen u periodu postojanja 3 kraljevstva Koreje, procenjeno da datira iz 250 g.n.e',0,5),
(11,'Srebrni escajg (1 set)',750.00,'Escajg od 3 kasike, 2 noza i 2 viljuske.',0,6),
(12,'Rotirajuce sunce - Ming',9000000.00,'Prelepa vaza iz perioda Ming dinastije, 2018. proglasena za najlepsu vazu iz ovog perioda.',1,2),
(13,'Persijski khanjar',25000.00,'Sjajan bodez iz perioda vladavine cara Ahamenida',0,5);

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `ZaposleniID` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `Ime` varchar(20) NOT NULL,
  `Prezime` varchar(30) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`ZaposleniID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`ZaposleniID`,`Ime`,`Prezime`,`Username`,`Password`) values 
(1,'Vojislav','Stefanovic','vojislav','vojislav123'),
(2,'Isidora','Jeremic','isidora','isidora123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
