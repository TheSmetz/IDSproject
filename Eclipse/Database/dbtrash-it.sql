-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 17, 2019 alle 19:12
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

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `componente`
--
ALTER TABLE `componente`
  ADD PRIMARY KEY (`IDcomponente`,`prodottoID`),
  ADD KEY `componente_ibfk_1` (`prodottoID`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `componente`
--
ALTER TABLE `componente`
  ADD CONSTRAINT `componente_ibfk_1` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`IDprodotto`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
