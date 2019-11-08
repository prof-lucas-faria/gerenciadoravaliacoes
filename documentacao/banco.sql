CREATE DATABASE sistemagerenciadordeavaliacoes;

USE sistemagerenciadordeavaliacoes;

CREATE TABLE `evento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `informacoes` varchar(255) NOT NULL,
  `liberado` tinyint(1) NOT NULL,
  `logotipo` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `organizador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `idEvento` bigint(20) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_area_evento1_idx` (`idEvento`),
  CONSTRAINT `fk_area_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `categoria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `idEvento` bigint(20) NOT NULL,
  `qntMinAvalProjeto` int(11) DEFAULT NULL,
  `qntMaxAvalProjeto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_categoria_evento1_idx` (`idEvento`),
  CONSTRAINT `fk_categoria_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `projeto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `autores` varchar(255) NOT NULL,
  `idEvento` bigint(20) NOT NULL,
  `idCategoria` bigint(20) NOT NULL,
  `idArea` bigint(20) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_projeto_evento1_idx` (`idEvento`),
  KEY `fk_projeto_categoria1_idx` (`idCategoria`),
  KEY `fk_projeto_area1_idx` (`idArea`),
  CONSTRAINT `fk_projeto_area1` FOREIGN KEY (`idArea`) REFERENCES `area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_projeto_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `avaliador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `avaliadorArea` (
  `idAvaliador` bigint(20) NOT NULL,
  `idArea` bigint(20) NOT NULL,
  PRIMARY KEY (`idAvaliador`,`idArea`),
  KEY `fk_avaliador_has_area_area1_idx` (`idArea`),
  KEY `fk_avaliador_has_area_avaliador1_idx` (`idAvaliador`),
  CONSTRAINT `fk_avaliador_has_area_area1` FOREIGN KEY (`idArea`) REFERENCES `area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliador_has_area_avaliador1` FOREIGN KEY (`idAvaliador`) REFERENCES `avaliador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `avaliacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idAvaliador` bigint(20) NOT NULL,
  `idProjeto` bigint(20) NOT NULL,
  `nota` double NOT NULL,
  `avaliado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `avaliador_idx` (`idAvaliador`),
  KEY `projeto_idx` (`idProjeto`),
  CONSTRAINT `avaliador` FOREIGN KEY (`idAvaliador`) REFERENCES `avaliador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `projeto` FOREIGN KEY (`idProjeto`) REFERENCES `projeto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `criterio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `notaMinima` decimal(6,2) NOT NULL,
  `notaMaxima` decimal(6,2) NOT NULL,
  `idCategoria` bigint(20) NOT NULL,
  `nome` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_criterio_categoria1_idx` (`idCategoria`),
  CONSTRAINT `fk_criterio_categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `avaliacaoCriterio` (
  `idAvaliacao` bigint(20) NOT NULL,
  `idCriterio` bigint(20) NOT NULL,
  `nota` decimal(6,2) NOT NULL,
  PRIMARY KEY (`idAvaliacao`,`idCriterio`),
  KEY `fk_avaliacao_has_criterio_criterio1_idx` (`idCriterio`),
  KEY `fk_avaliacao_has_criterio_avaliacao1_idx` (`idAvaliacao`),
  CONSTRAINT `fk_avaliacao_has_criterio_avaliacao1` FOREIGN KEY (`idAvaliacao`) REFERENCES `avaliacao` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_has_criterio_criterio1` FOREIGN KEY (`idCriterio`) REFERENCES `criterio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `eventoAvaliador` (
  `idEvento` bigint(20) NOT NULL,
  `idAvaliador` bigint(20) NOT NULL,
  `logou` tinyint(1) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`idEvento`,`idAvaliador`),
  KEY `fk_evento_has_avaliador_avaliador1_idx` (`idAvaliador`),
  KEY `fk_evento_has_avaliador_evento1_idx` (`idEvento`),
  CONSTRAINT `fk_evento_has_avaliador_avaliador1` FOREIGN KEY (`idAvaliador`) REFERENCES `avaliador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento_has_avaliador_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `organizadorEvento` (
  `idOrganizador` bigint(20) NOT NULL,
  `idEvento` bigint(20) NOT NULL,
  PRIMARY KEY (`idOrganizador`,`idEvento`),
  KEY `fk_organizador_has_evento_evento1_idx` (`idEvento`),
  KEY `fk_organizador_has_evento_organizador1_idx` (`idOrganizador`),
  CONSTRAINT `fk_organizador_has_evento_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_organizador_has_evento_organizador1` FOREIGN KEY (`idOrganizador`) REFERENCES `organizador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

