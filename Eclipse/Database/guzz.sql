-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Gen 14, 2019 alle 12:13
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
-- Database: `guzz`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `area`
--

CREATE TABLE `area` (
  `IDarea` int(11) NOT NULL,
  `nome` char(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `area`
--

INSERT INTO `area` (`IDarea`, `nome`) VALUES
(1, 'macerata'),
(2, 'san severino');

-- --------------------------------------------------------

--
-- Struttura della tabella `componente`
--

CREATE TABLE `componente` (
  `IDcomponente` int(11) NOT NULL,
  `prodottoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `componente`
--

INSERT INTO `componente` (`IDcomponente`, `prodottoID`) VALUES
(1, 1),
(3, 1),
(2, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `policy`
--

CREATE TABLE `policy` (
  `areaID` int(11) DEFAULT NULL,
  `componenteID` int(11) DEFAULT NULL,
  `descrizione` char(50) DEFAULT NULL,
  `punti` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `policy`
--

INSERT INTO `policy` (`areaID`, `componenteID`, `descrizione`, `punti`) VALUES
(1, 1, 'plastica', 3),
(2, 1, 'indifferenziato', 0),
(1, 3, 'indifferenziato', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotto`
--

CREATE TABLE `prodotto` (
  `IDprodotto` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `prodotto`
--

INSERT INTO `prodotto` (`IDprodotto`, `nome`) VALUES
(1, 'penna'),
(2, 'borraccia');

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
  ADD PRIMARY KEY (`IDcomponente`),
  ADD KEY `prodottoID` (`prodottoID`);

--
-- Indici per le tabelle `policy`
--
ALTER TABLE `policy`
  ADD KEY `areaID` (`areaID`),
  ADD KEY `componenteID` (`componenteID`);

--
-- Indici per le tabelle `prodotto`
--
ALTER TABLE `prodotto`
  ADD PRIMARY KEY (`IDprodotto`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `area`
--
ALTER TABLE `area`
  MODIFY `IDarea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `componente`
--
ALTER TABLE `componente`
  MODIFY `IDcomponente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `componente`
--
ALTER TABLE `componente`
  ADD CONSTRAINT `componente_ibfk_1` FOREIGN KEY (`prodottoID`) REFERENCES `prodotto` (`IDprodotto`);

--
-- Limiti per la tabella `policy`
--
ALTER TABLE `policy`
  ADD CONSTRAINT `policy_ibfk_1` FOREIGN KEY (`areaID`) REFERENCES `area` (`IDarea`),
  ADD CONSTRAINT `policy_ibfk_2` FOREIGN KEY (`componenteID`) REFERENCES `componente` (`IDcomponente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
