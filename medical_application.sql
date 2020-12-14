-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  lun. 14 déc. 2020 à 15:26
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `medical_application`
--

-- --------------------------------------------------------

--
-- Structure de la table `appointement`
--

DROP TABLE IF EXISTS `appointement`;
CREATE TABLE IF NOT EXISTS `appointement` (
  `Number` smallint(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `IDPatient` smallint(6) NOT NULL,
  `IDDoctor` smallint(6) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `Note` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`Number`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `appointement`
--

INSERT INTO `appointement` (`Number`, `IDPatient`, `IDDoctor`, `Date`, `Time`, `Note`) VALUES
(000008, 9, 15, '2020-12-06', '14:00:00', 'Foot pain'),
(000014, 9, 15, '2020-12-07', '12:00:00', 'Nothing'),
(000032, 9, 17, '2020-12-11', '10:00:00', 'Kine');

-- --------------------------------------------------------

--
-- Structure de la table `connexion`
--

DROP TABLE IF EXISTS `connexion`;
CREATE TABLE IF NOT EXISTS `connexion` (
  `Id` smallint(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `Function` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Id` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Données utilisateur médecin et patient';

--
-- Déchargement des données de la table `connexion`
--

INSERT INTO `connexion` (`Id`, `Function`, `Username`, `Password`) VALUES
(00009, 'Patient', 'thePatient', 'okok'),
(00010, 'Doctor', 'theDoctor', 'okok'),
(00011, 'Doctor', 'jonassso', 'okok'),
(00012, 'Doctor', 'lukasGO', 'koko'),
(00013, 'Doctor', 'cloverat', 'okko'),
(00014, 'Doctor', 'francois67', 'koko'),
(00015, 'Doctor', 'joeb', 'okok'),
(00016, 'Doctor', 'donaldt', 'okok'),
(00017, 'Doctor', 'nixonR', 'nono'),
(00018, 'Patient', 'thePatient2', 'other'),
(00019, 'Patient', 'test', 'no123'),
(00020, 'Doctor', 'jileFro', 'okok');

-- --------------------------------------------------------

--
-- Structure de la table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `Number` smallint(5) UNSIGNED ZEROFILL NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  `Specification` varchar(20) NOT NULL,
  PRIMARY KEY (`Number`),
  KEY `Number` (`Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `doctor`
--

INSERT INTO `doctor` (`Number`, `Name`, `Surname`, `Specification`) VALUES
(00010, 'James', 'WHO', 'Cardiologist'),
(00011, 'Jonas', 'GATE', 'General Medicine'),
(00012, 'Lukas', 'FROOM', 'General Medicine'),
(00013, 'Arthur', 'KOPO', 'Cardiologist'),
(00014, 'Francois', 'LEFRANCAIS', 'General Medicine'),
(00015, 'Joe', 'Biden', 'Orthopedist'),
(00016, 'Donald', 'TRUMP', 'Orthopedist'),
(00017, 'Richard', 'Nixon', 'Physiotherapist'),
(00020, 'Joris', 'Muscat', 'Orthopedist');

-- --------------------------------------------------------

--
-- Structure de la table `doctorschedule`
--

DROP TABLE IF EXISTS `doctorschedule`;
CREATE TABLE IF NOT EXISTS `doctorschedule` (
  `IDDoctor` smallint(5) UNSIGNED ZEROFILL NOT NULL,
  `Monday` int(11) DEFAULT NULL,
  `Tuesday` int(11) DEFAULT NULL,
  `Wednesday` int(11) DEFAULT NULL,
  `Thursday` int(11) DEFAULT NULL,
  `Friday` int(11) DEFAULT NULL,
  `Saturday` int(11) DEFAULT NULL,
  `Sunday` int(11) DEFAULT NULL,
  `BeginTime` time NOT NULL,
  `EndTime` time NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `doctorschedule`
--

INSERT INTO `doctorschedule` (`IDDoctor`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`, `Saturday`, `Sunday`, `BeginTime`, `EndTime`) VALUES
(00010, 1, 1, 1, 1, 0, 0, 0, '08:00:00', '19:00:00'),
(00014, 1, 1, 0, 1, 0, 0, 0, '08:00:00', '17:00:00'),
(00015, 1, 1, 0, 0, 1, 0, 1, '10:00:00', '15:00:00'),
(00011, 1, 0, 1, 0, 1, 1, 0, '09:00:00', '15:00:00'),
(00012, 1, 0, 0, 1, 1, 0, 0, '11:00:00', '17:00:00'),
(00013, 1, 1, 1, 1, 0, 1, 0, '10:00:00', '19:00:00'),
(00016, 1, 1, 0, 1, 1, 0, 1, '12:00:00', '15:00:00'),
(00017, 1, 1, 1, 1, 1, 0, 0, '09:00:00', '16:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `Number` smallint(5) UNSIGNED ZEROFILL NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  `Pathology` varchar(20) NOT NULL,
  PRIMARY KEY (`Number`),
  KEY `Number` (`Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`Number`, `Name`, `Surname`, `Pathology`) VALUES
(00009, 'John', 'CAFE', 'Nothing');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `fk_doctor_number` FOREIGN KEY (`Number`) REFERENCES `connexion` (`Id`);

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `fk_patient_number` FOREIGN KEY (`Number`) REFERENCES `connexion` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
