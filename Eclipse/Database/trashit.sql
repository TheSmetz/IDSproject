-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Nov 26, 2018 alle 15:54
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
-- Database: `trashit`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `persone`
--

CREATE TABLE `persone` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `persone`
--

INSERT INTO `persone` (`id`, `nome`, `cognome`) VALUES
(1, 'Diego', 'Miccio'),
(2, 'Andrea', 'Falaschini'),
(3, 'Matteo', 'Iommi'),
(4, 'Matteo', 'Guerrini'),
(5, 'Cristiano', 'Zampa');

-- --------------------------------------------------------

--
-- Struttura della tabella `prodotti`
--

CREATE TABLE `prodotti` (
  `codiceABarre` int(11) NOT NULL,
  `descrizione` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `prodotti`
--

INSERT INTO `prodotti` (`codiceABarre`, `descrizione`) VALUES
(101, 'Bottiglia vetro, tappo indifferenziato'),
(202, 'Giornale carta'),
(303, 'Bottiglia plastica, Tappo indifferenziato'),
(404, 'Lattina indifferenziato'),
(505, 'Portatile, indifferenziato');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `persone`
--
ALTER TABLE `persone`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `prodotti`
--
ALTER TABLE `prodotti`
  ADD PRIMARY KEY (`codiceABarre`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `persone`
--
ALTER TABLE `persone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `prodotti`
--
ALTER TABLE `prodotti`
  MODIFY `codiceABarre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=506;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
