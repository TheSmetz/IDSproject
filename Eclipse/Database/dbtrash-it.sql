-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 14, 2019 alle 13:12
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
  `IDComponente` varchar(10) NOT NULL,
  `Nome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `componente`
--

INSERT INTO `componente` (`IDComponente`, `Nome`) VALUES
('CA', 'Carta'),
('IN', 'Indifferenziato'),
('PL', 'Plastica'),
('TB', 'Tappo Bottiglietta'),
('TP', 'Tetrapack'),
('VE', 'Vetro');

-- --------------------------------------------------------

--
-- Struttura della tabella `policy`
--

CREATE TABLE `policy` (
  `IDArea` varchar(2) NOT NULL,
  `IDComponente` varchar(10) NOT NULL,
  `Descrizione` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `policy`
--

INSERT INTO `policy` (`IDArea`, `IDComponente`, `Descrizione`) VALUES
('MC', 'TP', 'Plastica'),
('MC', 'TP', 'Plastica'),
('AP', 'TP', 'Carta'),
('AP', 'TP', 'Carta');

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `IDProdotto` varchar(13) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `PrimoComponente` varchar(20) NOT NULL,
  `SecondoComponente` varchar(20) DEFAULT NULL,
  `TerzoComponente` varchar(20) DEFAULT NULL,
  `QuartoComponente` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `prodotto`
--

INSERT INTO `prodotto` (`IDProdotto`, `Nome`, `PrimoComponente`, `SecondoComponente`, `TerzoComponente`, `QuartoComponente`) VALUES
('123456', 'Bottiglia Latte', 'TP', NULL, NULL, NULL),
('80007920', 'San Benedetto 2L', 'PL', 'TB', NULL, NULL);

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
  ADD PRIMARY KEY (`IDComponente`);

--
-- Indici per le tabelle `policy`
--
ALTER TABLE `policy`
  ADD KEY `AreaID` (`IDArea`),
  ADD KEY `ComponenteID` (`IDComponente`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`IDProdotto`),
  ADD KEY `PComponente` (`PrimoComponente`),
  ADD KEY `SComponente` (`SecondoComponente`),
  ADD KEY `TComponente` (`TerzoComponente`),
  ADD KEY `QComponente` (`QuartoComponente`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `policy`
--
ALTER TABLE `policy`
  ADD CONSTRAINT `AreaID` FOREIGN KEY (`IDArea`) REFERENCES `area` (`IDArea`),
  ADD CONSTRAINT `ComponenteID` FOREIGN KEY (`IDComponente`) REFERENCES `componente` (`IDComponente`);

--
-- Limiti per la tabella `prodotto`
--
ALTER TABLE `prodotto`
  ADD CONSTRAINT `PComponente` FOREIGN KEY (`PrimoComponente`) REFERENCES `componente` (`IDComponente`),
  ADD CONSTRAINT `QComponente` FOREIGN KEY (`QuartoComponente`) REFERENCES `componente` (`IDComponente`),
  ADD CONSTRAINT `SComponente` FOREIGN KEY (`SecondoComponente`) REFERENCES `componente` (`IDComponente`),
  ADD CONSTRAINT `TComponente` FOREIGN KEY (`TerzoComponente`) REFERENCES `componente` (`IDComponente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
