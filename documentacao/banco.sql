CREATE DATABASE sistemagerenciadordeavaliacoes;

USE sistemagerenciadordeavaliacoes;


DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `idEvento` bigint(20) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_area_evento1_idx` (`idEvento`),
  CONSTRAINT `fk_area_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacao`
--

DROP TABLE IF EXISTS `avaliacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacao`
--

LOCK TABLES `avaliacao` WRITE;
/*!40000 ALTER TABLE `avaliacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacaoCriterio`
--

DROP TABLE IF EXISTS `avaliacaoCriterio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacaoCriterio`
--

LOCK TABLES `avaliacaoCriterio` WRITE;
/*!40000 ALTER TABLE `avaliacaoCriterio` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliacaoCriterio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliador`
--

DROP TABLE IF EXISTS `avaliador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliador` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliador`
--

LOCK TABLES `avaliador` WRITE;
/*!40000 ALTER TABLE `avaliador` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliadorArea`
--

DROP TABLE IF EXISTS `avaliadorArea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avaliadorArea` (
  `avaliador_id` bigint(20) NOT NULL,
  `area_id` bigint(20) NOT NULL,
  PRIMARY KEY (`avaliador_id`,`area_id`),
  KEY `fk_avaliador_has_area_area1_idx` (`area_id`),
  KEY `fk_avaliador_has_area_avaliador1_idx` (`avaliador_id`),
  CONSTRAINT `fk_avaliador_has_area_area1` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliador_has_area_avaliador1` FOREIGN KEY (`avaliador_id`) REFERENCES `avaliador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliadorArea`
--

LOCK TABLES `avaliadorArea` WRITE;
/*!40000 ALTER TABLE `avaliadorArea` DISABLE KEYS */;
/*!40000 ALTER TABLE `avaliadorArea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `criterio`
--

DROP TABLE IF EXISTS `criterio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `criterio`
--

LOCK TABLES `criterio` WRITE;
/*!40000 ALTER TABLE `criterio` DISABLE KEYS */;
/*!40000 ALTER TABLE `criterio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `informacoes` varchar(255) NOT NULL,
  `liberado` tinyint(1) NOT NULL,
  `logotipo` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eventoAvaliador`
--

DROP TABLE IF EXISTS `eventoAvaliador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eventoAvaliador`
--

LOCK TABLES `eventoAvaliador` WRITE;
/*!40000 ALTER TABLE `eventoAvaliador` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventoAvaliador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizador`
--

DROP TABLE IF EXISTS `organizador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizador`
--

LOCK TABLES `organizador` WRITE;
/*!40000 ALTER TABLE `organizador` DISABLE KEYS */;
/*!40000 ALTER TABLE `organizador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizadorEvento`
--

DROP TABLE IF EXISTS `organizadorEvento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organizadorEvento` (
  `idOrganizador` bigint(20) NOT NULL,
  `idEvento` bigint(20) NOT NULL,
  PRIMARY KEY (`idOrganizador`,`idEvento`),
  KEY `fk_organizador_has_evento_evento1_idx` (`idEvento`),
  KEY `fk_organizador_has_evento_organizador1_idx` (`idOrganizador`),
  CONSTRAINT `fk_organizador_has_evento_evento1` FOREIGN KEY (`idEvento`) REFERENCES `evento` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_organizador_has_evento_organizador1` FOREIGN KEY (`idOrganizador`) REFERENCES `organizador` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizadorEvento`
--

LOCK TABLES `organizadorEvento` WRITE;
/*!40000 ALTER TABLE `organizadorEvento` DISABLE KEYS */;
/*!40000 ALTER TABLE `organizadorEvento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projeto`
--

DROP TABLE IF EXISTS `projeto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projeto`
--

LOCK TABLES `projeto` WRITE;
/*!40000 ALTER TABLE `projeto` DISABLE KEYS */;
/*!40000 ALTER TABLE `projeto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-01 20:54:53
