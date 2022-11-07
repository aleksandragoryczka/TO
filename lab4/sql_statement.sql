CREATE TABLE `notes` (
  `idnotes` int NOT NULL AUTO_INCREMENT,
  `note_title` varchar(45) NOT NULL,
  `note_content` varchar(1000) NOT NULL,
  `iduser` int NOT NULL,
  PRIMARY KEY (`idnotes`),
  KEY `iduser_idx` (`iduser`),
  CONSTRAINT `iduser` FOREIGN KEY (`iduser`) REFERENCES `users` (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `users` (
  `idusers` int NOT NULL AUTO_INCREMENT,
  `name_user` varchar(45) NOT NULL,
  `surname_user` varchar(45) NOT NULL,
  `login_user` varchar(45) NOT NULL,
  `password_user` varchar(60) NOT NULL,
  PRIMARY KEY (`idusers`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;