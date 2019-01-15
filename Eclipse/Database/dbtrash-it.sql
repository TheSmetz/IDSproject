-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 15, 2019 alle 10:38
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
  `IDarea` varchar(2) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `raccoltaPunti` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `area`
--

INSERT INTO `area` (`IDarea`, `nome`, `raccoltaPunti`) VALUES
('AP', 'Ascoli Piceno', 1),
('MC', 'Macerata', 0);

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
('CA', '8410668111116', 'corpo'),
('IN', '4006381492355', 'evidenziatore'),
('PL', '8410668111116', 'tappo'),
('TP', '80007920', 'corpo'),
('VE', '821935111124', 'intera bottiglia');

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
('IN', 'AP', 'Indifferenziato'),
('IN', 'MC', 'Indifferenziato'),
('PL', 'AP', 'plastica'),
('PL', 'MC', 'plastica'),
('TP', 'AP', 'carta'),
('TP', 'MC', 'indifferenziato'),
('VE', 'AP', 'Vetro'),
('VE', 'MC', 'Vetro');

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `IDprodotto` varchar(13) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `punti` int(3) NOT NULL,
  `immagine` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `prodotto`
--

INSERT INTO `prodotto` (`IDprodotto`, `nome`, `punti`, `immagine`) VALUES
('4006381492355', 'Stabilo rosa', 3, ''),
('80007920', 'San Benedetto 2L', 3, ''),
('8022880201027', 'Acqua naturale nocer', 3, ''),
('821935111124', 'Bottiglia Heineken', 5, ''),
('8410668111116', 'Bottiglia Latte Feiraco', 5, '');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`IDarea`);

--
-- Indici per le tabelle `componente`
--
ALTER TABLE `componente`
  ADD PRIMARY KEY (`IDcomponente`,`prodottoID`),
  ADD KEY `componente_ibfk_1` (`prodottoID`);

--
-- Indici per le tabelle `policy`
--
ALTER TABLE `policy`
  ADD PRIMARY KEY (`componenteID`,`areaID`),
  ADD KEY `policy_ibfk_2` (`areaID`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`IDprodotto`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `componente`
--
ALTER TABLE `componente`
  ADD CONSTRAINT `componente_ibfk_1` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`IDProdotto`) ON DELETE CASCADE ON UPDATE CASCADE;

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
