CREATE DATABASE sistemagerenciadordeavaliacoes;

USE sistemagerenciadordeavaliacoes;

CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `idEvento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_area_evento1_idx` (`idEvento`),
  CONSTRAINT `fk_area_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `avaliacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAvaliador` int(11) NOT NULL,
  `idProjeto` int(11) NOT NULL,
  `nota` double NOT NULL,
  `avaliado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `avaliador_idx` (`idAvaliador`),
  KEY `projeto_idx` (`idProjeto`),
  CONSTRAINT `avaliador` FOREIGN KEY (`idAvaliador`) REFERENCES `avaliador` (`id`),
  CONSTRAINT `projeto` FOREIGN KEY (`idProjeto`) REFERENCES `projeto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `avaliacaocriterio` (
  `idAvaliacao` int(11) NOT NULL,
  `idCriterio` int(11) NOT NULL,
  `nota` decimal(6,2) NOT NULL,
  PRIMARY KEY (`idAvaliacao`,`idCriterio`),
  KEY `fk_avaliacao_has_criterio_criterio1_idx` (`idCriterio`),
  KEY `fk_avaliacao_has_criterio_avaliacao1_idx` (`idAvaliacao`),
  CONSTRAINT `fk_avaliacao_has_criterio_avaliacao1` FOREIGN KEY (`idAvaliacao`) REFERENCES `avaliacao` (`id`),
  CONSTRAINT `fk_avaliacao_has_criterio_criterio1` FOREIGN KEY (`idCriterio`) REFERENCES `criterio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `avaliador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `idArea` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_avaliador_area1_idx` (`idArea`),
  CONSTRAINT `fk_avaliador_area1` FOREIGN KEY (`idArea`) REFERENCES `area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `idEvento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categoria_evento1_idx` (`idEvento`),
  CONSTRAINT `fk_categoria_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `criterio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `notaMinima` decimal(6,2) NOT NULL,
  `notaMaxima` decimal(6,2) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_criterio_categoria1_idx` (`idCategoria`),
  CONSTRAINT `fk_criterio_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `evento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `informacoes` varchar(255) NOT NULL,
  `qntMinAvalProjeto` int(11) DEFAULT NULL,
  `qntMaxAvalProjeto` int(11) DEFAULT NULL,
  `liberado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `eventoavaliador` (
  `idEvento` int(11) NOT NULL,
  `idAvaliador` int(11) NOT NULL,
  `logou` tinyint(1) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`idEvento`,`idAvaliador`),
  KEY `fk_evento_has_avaliador_avaliador1_idx` (`idAvaliador`),
  KEY `fk_evento_has_avaliador_evento1_idx` (`idEvento`),
  CONSTRAINT `fk_evento_has_avaliador_avaliador1` FOREIGN KEY (`idAvaliador`) REFERENCES `avaliador` (`id`),
  CONSTRAINT `fk_evento_has_avaliador_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `organizador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `organizadorevento` (
  `idOrganizador` int(11) NOT NULL,
  `idEvento` int(11) NOT NULL,
  PRIMARY KEY (`idOrganizador`,`idEvento`),
  KEY `fk_organizador_has_evento_evento1_idx` (`idEvento`),
  KEY `fk_organizador_has_evento_organizador1_idx` (`idOrganizador`),
  CONSTRAINT `fk_organizador_has_evento_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`),
  CONSTRAINT `fk_organizador_has_evento_organizador1` FOREIGN KEY (`idOrganizador`) REFERENCES `organizador` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `projeto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `autores` varchar(255) NOT NULL,
  `idEvento` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `idArea` int(11) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_projeto_evento1_idx` (`idEvento`),
  KEY `fk_projeto_categoria1_idx` (`idCategoria`),
  KEY `fk_projeto_area1_idx` (`idArea`),
  CONSTRAINT `fk_projeto_area1` FOREIGN KEY (`idArea`) REFERENCES `area` (`id`),
  CONSTRAINT `fk_projeto_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `fk_projeto_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dump completed on 2019-11-01  2:18:07
