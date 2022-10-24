-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 24-Out-2022 às 22:57
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bd_locadora`
--
CREATE DATABASE IF NOT EXISTS `bd_locadora` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bd_locadora`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `usuario` varchar(10) NOT NULL,
  `nome` varchar(32) NOT NULL,
  `senha` bigint(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `admin`
--

INSERT INTO `admin` (`id`, `usuario`, `nome`, `senha`) VALUES
(1, '@vek', 'Victor', 321),
(2, '@mari', 'Mariane', 123);

-- --------------------------------------------------------

--
-- Estrutura da tabela `filmes`
--

CREATE TABLE `filmes` (
  `id` int(11) NOT NULL,
  `titulo` varchar(32) NOT NULL,
  `lancamento` int(4) NOT NULL,
  `classificacao` enum('Livre','10','12','14','16','18') NOT NULL,
  `genero` enum('Romance','Acao','Terror','') NOT NULL,
  `duracao` varchar(8) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `filmes`
--

INSERT INTO `filmes` (`id`, `titulo`, `lancamento`, `classificacao`, `genero`, `duracao`, `valor`) VALUES
(1, 'Orgulho e Preconceito', 2006, 'Livre', 'Romance', '2h 7m', 30),
(2, 'Motoqueiro Fantasma', 2007, '14', 'Acao', '2h 3m', 45),
(3, 'Coraline e o Mundo Secreto', 2009, '10', 'Terror', '1h 55m', 25),
(4, 'Titanic', 1997, '12', 'Romance', '3h 14m', 35),
(5, 'Clube da Luta', 1999, '18', 'Acao', '2h 19m', 50),
(6, 'O Melhor Amigo da Noiva', 2008, '10', 'Romance', '1h 41m', 5),
(7, 'A Casa Monstro', 2006, 'Livre', 'Terror', '1h 31m', 10),
(8, 'The Batman', 2022, '14', 'Acao', '2h 56m', 40),
(9, 'Sociedade Literaria', 2018, '12', 'Romance', '2h 4m', 15),
(10, 'Invocacao do Mal', 2013, '14', 'Terror', '1h 52m', 20),
(11, 'Em Ritmo de Fuga', 2017, '14', 'Acao', '1h 55m', 25),
(12, 'A Noiva-Cadaver', 2005, 'Livre', 'Terror', '1h 14m', 30);

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacao`
--

CREATE TABLE `locacao` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_filme` int(11) NOT NULL,
  `usuario` varchar(14) NOT NULL,
  `filme` varchar(32) NOT NULL,
  `data_locacao` date NOT NULL,
  `data_devolucao` date NOT NULL,
  `form_pagamento` enum('Credito','Debito','Pix','Dinheiro','Boleto') NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `locacao`
--

INSERT INTO `locacao` (`id`, `id_usuario`, `id_filme`, `usuario`, `filme`, `data_locacao`, `data_devolucao`, `form_pagamento`, `total`) VALUES
(2, 4, 1, 'aroma', 'Orgulho e Preconceito', '2022-10-03', '2022-11-24', 'Boleto', 55),
(9, 6, 2, 'victor', 'Motoqueiro Fantasma', '2022-10-10', '2022-10-24', 'Dinheiro', 45),
(10, 15, 3, 'igor', 'Coraline E O Mundo Secreto', '2022-10-10', '2022-10-24', 'Credito', 25),
(11, 6, 8, 'victor', 'The Batman', '2022-10-10', '2022-10-24', 'Pix', 40),
(13, 6, 1, 'victor', 'Orgulho e Preconceito', '2022-10-10', '2022-10-24', 'Debito', 30),
(15, 6, 9, 'victor', 'Sociedade Literaria', '2022-10-10', '2022-10-24', 'Boleto', 15),
(16, 20, 11, 'mari', 'Em Ritmo de Fuga', '2022-10-10', '2022-10-24', 'Debito', 25),
(17, 20, 3, 'mari', 'Coraline e o Mundo Secreto', '2022-10-10', '2022-10-24', 'Dinheiro', 25),
(18, 20, 4, 'mari', 'Titanic', '2022-10-10', '2022-10-24', 'Boleto', 35),
(19, 20, 5, 'mari', 'Clube da Luta', '2022-10-10', '2022-10-24', 'Pix', 50),
(20, 20, 7, 'mari', 'A Casa Monstro', '2022-10-10', '2022-10-24', 'Boleto', 10),
(21, 20, 6, 'mari', 'O Melhor Amigo da Noiva', '2022-10-10', '2022-10-25', 'Debito', 5),
(22, 20, 12, 'mari', 'A Noiva-Cadaver', '2022-10-10', '2022-10-24', 'Pix', 30),
(23, 20, 10, 'mari', 'Invocacao do Mal', '2022-10-10', '2022-10-24', 'Dinheiro', 20),
(24, 6, 12, 'victor', 'A Noiva-Cadaver', '2022-10-24', '2022-11-10', 'Debito', 30),
(25, 6, 11, 'victor', 'Em Ritmo de Fuga', '2022-10-24', '2022-11-08', 'Pix', 25),
(26, 21, 6, 'julius', 'O Melhor Amigo da Noiva', '2022-10-24', '2022-11-08', 'Credito', 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nome` varchar(32) NOT NULL,
  `data_nasc` date NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `telefone` varchar(14) NOT NULL,
  `usuario` varchar(14) NOT NULL,
  `senha` bigint(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `data_nasc`, `endereco`, `telefone`, `usuario`, `senha`) VALUES
(4, 'Aroma', '2006-03-27', 'Rua Mari, 78', '(11)99999-1111', 'aroma', 1234),
(6, 'Victor', '2005-12-19', 'rua 567, 890', '(11)12345-6789', 'victor', 1234),
(15, 'Igor', '2005-10-30', 'rua 69, 800', '(11)95995-5896', 'igor', 1234),
(20, 'Mariane', '2005-04-03', 'rua dom miguel de bulhões, 65', '(11)95634-6432', 'mari', 1234),
(21, 'Julio', '2006-01-19', 'rua oi, 78', '(11)11111-1111', 'julius', 1234);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `filmes`
--
ALTER TABLE `filmes`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `locacao`
--
ALTER TABLE `locacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_filme` (`id_filme`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Índices para tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `filmes`
--
ALTER TABLE `filmes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `locacao`
--
ALTER TABLE `locacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `locacao`
--
ALTER TABLE `locacao`
  ADD CONSTRAINT `locacao_ibfk_1` FOREIGN KEY (`id_filme`) REFERENCES `filmes` (`id`),
  ADD CONSTRAINT `locacao_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
