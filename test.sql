USE test;

DROP TABLE IF EXISTS `PARTS`;

CREATE TABLE `PARTS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(40) DEFAULT NULL,
  `QTY` int(11) NOT NULL,
  `REQUIRED` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO `PARTS` (`ID`, `NAME`, `QTY`, `REQUIRED`)
VALUES
	(6,'звуковая карта',2,0),
	(5,'материнская плата',0,1),
	(7,'процессор',2,0),
	(8,'подсветка корпуса',100,0),
	(9,'корпус',10,1),
	(10,'память',10,1),
	(11,'SSD диск',15,1),
	(12,'видеокарта',7,0),
	(13,'клавиатура',10,1),
	(14,'мышь',10,1),
	(15,'вентилятор для процессора',2,1);