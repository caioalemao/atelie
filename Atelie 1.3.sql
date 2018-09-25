-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.1.19-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.4.0.5142
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para atelie
CREATE DATABASE IF NOT EXISTS `atelie` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `atelie`;

-- Copiando estrutura para tabela atelie.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `CPF` varchar(11) NOT NULL,
  `dtNasc` date NOT NULL,
  `rua` varchar(60) DEFAULT NULL,
  `bairro` varchar(30) DEFAULT NULL,
  `numero` varchar(5) DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  `telefone` varchar(11) DEFAULT NULL,
  `rg` varchar(9) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `dtcadastro` date NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela atelie.ordem
CREATE TABLE IF NOT EXISTS `ordem` (
  `idOrdem` int(11) NOT NULL AUTO_INCREMENT,
  `cePeca` int(11) NOT NULL,
  `ceServico` int(11) NOT NULL,
  PRIMARY KEY (`idOrdem`),
  KEY `FK_ordem_peca` (`cePeca`),
  KEY `FK_ordem_servico` (`ceServico`),
  CONSTRAINT `FK_ordem_peca` FOREIGN KEY (`cePeca`) REFERENCES `peca` (`idPeca`),
  CONSTRAINT `FK_ordem_servico` FOREIGN KEY (`ceServico`) REFERENCES `servico` (`idServico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela atelie.ordemdeservico
CREATE TABLE IF NOT EXISTS `ordemdeservico` (
  `idOrdemDeServico` int(11) NOT NULL AUTO_INCREMENT,
  `ceCliente` int(11) NOT NULL,
  `dtEntrega` date DEFAULT NULL,
  `dtEntrada` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `situacao` varchar(15) NOT NULL,
  `ceOrdem` int(11) NOT NULL,
  PRIMARY KEY (`idOrdemDeServico`),
  KEY `FK_ordemdeservico_cliente` (`ceCliente`),
  KEY `FK_ordemdeservico_ordem` (`ceOrdem`),
  CONSTRAINT `FK_ordemdeservico_cliente` FOREIGN KEY (`ceCliente`) REFERENCES `cliente` (`idCliente`),
  CONSTRAINT `FK_ordemdeservico_ordem` FOREIGN KEY (`ceOrdem`) REFERENCES `ordem` (`idOrdem`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela atelie.pagamento
CREATE TABLE IF NOT EXISTS `pagamento` (
  `idPagamento` int(11) NOT NULL AUTO_INCREMENT,
  `valorTotal` float NOT NULL,
  `statusPag` varchar(8) NOT NULL,
  `formaPag` varchar(7) NOT NULL,
  `ceOrdemServico` int(11) NOT NULL,
  `dataSistema` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idPagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela atelie.peca
CREATE TABLE IF NOT EXISTS `peca` (
  `idPeca` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPeca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela atelie.servico
CREATE TABLE IF NOT EXISTS `servico` (
  `idServico` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `valor` float NOT NULL,
  `tempo` time DEFAULT NULL,
  PRIMARY KEY (`idServico`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
