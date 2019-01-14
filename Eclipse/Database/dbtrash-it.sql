-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 14, 2019 alle 19:18
-- Versione del server: 10.1.37-MariaDB
-- Versione PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtrash-it`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `area`
--

CREATE TABLE `area` (
  `IDArea` varchar(2) NOT NULL,
  `Nome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `area`
--

INSERT INTO `area` (`IDArea`, `Nome`) VALUES
('AP', 'Ascoli Piceno'),
('MC', 'Macerata');

-- --------------------------------------------------------

--
-- Struttura della tabella `componente`
--

CREATE TABLE `componente` (
  `IDcomponente` varchar(2) NOT NULL,
  `prodottoID` varchar(13) NOT NULL,
  `descrizione` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `componente`
--

INSERT INTO `componente` (`IDcomponente`, `prodottoID`, `descrizione`) VALUES
('CA', '123456', 'corpo'),
('PL', '123456', 'tappo'),
('TP', '80007920', 'corpo');

-- --------------------------------------------------------

--
-- Struttura della tabella `policy`
--

CREATE TABLE `policy` (
  `componenteID` varchar(2) NOT NULL,
  `areaID` varchar(2) NOT NULL,
  `descrizione` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `policy`
--

INSERT INTO `policy` (`componenteID`, `areaID`, `descrizione`) VALUES
('CA', 'AP', 'carta'),
('CA', 'MC', 'carta'),
('PL', 'AP', 'plastica'),
('PL', 'MC', 'plastica'),
('TP', 'AP', 'carta'),
('TP', 'MC', 'indifferenziato');

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `IDProdotto` varchar(13) NOT NULL,
  `Nome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `prodotto`
--

INSERT INTO `prodotto` (`IDProdotto`, `Nome`) VALUES
('123456', 'Bottiglia Latte'),
('80007920', 'San Benedetto 2L');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`IDArea`);

--
-- Indici per le tabelle `componente`
--
ALTER TABLE `componente`
  ADD PRIMARY KEY (`IDcomponente`,`prodottoID`),
  ADD KEY `prodottoID` (`prodottoID`);

--
-- Indici per le tabelle `policy`
--
ALTER TABLE `policy`
  ADD PRIMARY KEY (`componenteID`,`areaID`),
  ADD KEY `areaID` (`areaID`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`IDProdotto`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `componente`
--
ALTER TABLE `componente`
  ADD CONSTRAINT `componente_ibfk_1` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`IDProdotto`);

--
-- Limiti per la tabella `policy`
--
ALTER TABLE `policy`
  ADD CONSTRAINT `policy_ibfk_1` FOREIGN KEY (`componenteID`) REFERENCES `componente` (`IDcomponente`),
  ADD CONSTRAINT `policy_ibfk_2` FOREIGN KEY (`areaID`) REFERENCES `area` (`IDArea`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
