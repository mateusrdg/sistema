-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `caixa`
--

DROP TABLE IF EXISTS `caixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `caixa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `caixa_movimentacao`
--

DROP TABLE IF EXISTS `caixa_movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `caixa_movimentacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` int(11) NOT NULL,
  `data_abertura` datetime NOT NULL,
  `hora_abertura` datetime NOT NULL,
  `data_fechamento` datetime DEFAULT NULL,
  `hora_fechamento` datetime DEFAULT NULL,
  `caixa_id` int(11) NOT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_caixa_movimentacao_caixa_idx` (`caixa_id`),
  KEY `fk_caixa_movimentacao_funcionario_id_idx` (`funcionario_id`),
  CONSTRAINT `fk_caixa_movimentacao_caixa` FOREIGN KEY (`caixa_id`) REFERENCES `caixa` (`id`),
  CONSTRAINT `fk_caixa_movimentacao_funcionario_id` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigoIBGE` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `estado_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cidade_estado_idx` (`estado_id`),
  CONSTRAINT `fk_cidade_estado` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `cpf_cnpj` varchar(14) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `data_cadastro` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `estado` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `conta_pagar`
--

DROP TABLE IF EXISTS `conta_pagar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `conta_pagar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `hora` datetime DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `data_pagamento` datetime DEFAULT NULL,
  `data_vencimento` datetime DEFAULT NULL,
  `forma_pagamento_compra_id` int(11) DEFAULT NULL,
  `parcela_compra_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_conta_pagar_forma_pagamento_pedido_idx` (`forma_pagamento_compra_id`),
  KEY `fk_conta_pagar_parcela_compra_id_idx` (`parcela_compra_id`),
  CONSTRAINT `fk_conta_pagar_forma_pagamento_compra` FOREIGN KEY (`forma_pagamento_compra_id`) REFERENCES `forma_pagamento_compra` (`id`),
  CONSTRAINT `fk_conta_pagar_parcela_compra_id` FOREIGN KEY (`parcela_compra_id`) REFERENCES `parcela_compra` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `conta_receber`
--

DROP TABLE IF EXISTS `conta_receber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `conta_receber` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `hora` datetime DEFAULT NULL,
  `valor` decimal(19,2) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `data_pagamento` datetime DEFAULT NULL,
  `data_vencimento` datetime DEFAULT NULL,
  `forma_pagamento_venda_id` int(11) DEFAULT NULL,
  `parcela_venda_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_conta_receber_forma_pagamento_pedido_idx` (`forma_pagamento_venda_id`),
  KEY `fk_conta_receber_parcela_id_idx` (`parcela_venda_id`),
  CONSTRAINT `fk_conta_receber_forma_pagamento_pedido` FOREIGN KEY (`forma_pagamento_venda_id`) REFERENCES `forma_pagamento_venda` (`id`),
  CONSTRAINT `fk_conta_receber_parcela_id` FOREIGN KEY (`parcela_venda_id`) REFERENCES `parcela_venda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rua` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `bairro` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cep` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `complemento` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `cidade_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_endereco_cidade_idx` (`cidade_id`),
  CONSTRAINT `fk_endereco_cidade` FOREIGN KEY (`cidade_id`) REFERENCES `cidade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `entrada_estoque`
--

DROP TABLE IF EXISTS `entrada_estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `entrada_estoque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` decimal(19,2) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `pedido_compra_item_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_entrada_estoque_produto_idx` (`produto_id`),
  KEY `fk_entrada_estoque_pedido_compra_item_id_idx` (`pedido_compra_item_id`),
  CONSTRAINT `fk_entrada_estoque_pedido_compra_item_id` FOREIGN KEY (`pedido_compra_item_id`) REFERENCES `pedido_compra_item` (`id`),
  CONSTRAINT `fk_entrada_estoque_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sigla` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `codigoIBGE` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `pais_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pais_id_idx` (`pais_id`),
  CONSTRAINT `fk_estado_pais` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `estoque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `forma_pagamento`
--

DROP TABLE IF EXISTS `forma_pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `forma_pagamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `forma_pagamento_compra`
--

DROP TABLE IF EXISTS `forma_pagamento_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `forma_pagamento_compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(19,4) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `forma_pagamento_id` int(11) NOT NULL,
  `pedido_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_forma_pagamento_compra_forma_pedido_compra_id_idx` (`pedido_id`),
  KEY `fk_forma_pagamento_compra_forma_pagamento_id_idx` (`forma_pagamento_id`),
  CONSTRAINT `fk_forma_pagamento_compra_forma_pagamento_id` FOREIGN KEY (`forma_pagamento_id`) REFERENCES `forma_pagamento` (`id`),
  CONSTRAINT `fk_forma_pagamento_compra_forma_pedido_compra_id` FOREIGN KEY (`pedido_id`) REFERENCES `pedido_compra` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `forma_pagamento_venda`
--

DROP TABLE IF EXISTS `forma_pagamento_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `forma_pagamento_venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(19,2) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `estado` int(11) NOT NULL,
  `forma_pagamento_id` int(11) NOT NULL,
  `pedido_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_forma_pagamento_pedido_forma_pagamento_idx` (`forma_pagamento_id`),
  KEY `fk_forma_pagamento_venda_pedido_venda_id_idx` (`pedido_id`),
  CONSTRAINT `fk_forma_pagamento_pedido_forma_pagamento` FOREIGN KEY (`forma_pagamento_id`) REFERENCES `forma_pagamento` (`id`),
  CONSTRAINT `fk_forma_pagamento_venda_pedido_venda_id` FOREIGN KEY (`pedido_id`) REFERENCES `pedido_venda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fornecedor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `nome_fantasia` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `cpf_cnpj` varchar(14) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  `estado` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `cpf_cnpj` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  `estado` int(10) DEFAULT NULL,
  `tipo` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grupo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `movimentacao`
--

DROP TABLE IF EXISTS `movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `movimentacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `hora` datetime NOT NULL,
  `valor` decimal(19,2) NOT NULL,
  `tipo` int(11) NOT NULL,
  `caixa_movimentacao_id` int(11) NOT NULL,
  `conta_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_movimentacao_caixa_movimentacao_idx` (`caixa_movimentacao_id`),
  CONSTRAINT `fk_movimentacao_caixa_movimentacao` FOREIGN KEY (`caixa_movimentacao_id`) REFERENCES `caixa_movimentacao` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orcamento`
--

DROP TABLE IF EXISTS `orcamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orcamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `hora` datetime DEFAULT NULL,
  `faturado` int(11) NOT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  `cliente_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orcamento_funcionario_idx` (`funcionario_id`),
  KEY `fk_orcamento_cliente_id_idx` (`cliente_id`),
  CONSTRAINT `fk_orcamento_cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_orcamento_funcionario` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orcamento_item`
--

DROP TABLE IF EXISTS `orcamento_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orcamento_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` decimal(19,4) NOT NULL,
  `preco` decimal(19,4) NOT NULL,
  `desconto` decimal(19,4) DEFAULT NULL,
  `produto_id` int(11) NOT NULL,
  `orcamento_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_orcamento_id_produto_idx` (`produto_id`),
  KEY `fk_orcamento_item_orcamento_idx` (`orcamento_id`),
  CONSTRAINT `fk_orcamento_item_orcamento` FOREIGN KEY (`orcamento_id`) REFERENCES `orcamento` (`id`),
  CONSTRAINT `fk_orcamento_item_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `sigla` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `codigo` varchar(2) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `parcela_compra`
--

DROP TABLE IF EXISTS `parcela_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parcela_compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forma_pagamento_compra_id` int(11) NOT NULL,
  `valor` decimal(19,4) NOT NULL,
  `estado` int(11) NOT NULL,
  `data_vencimento` datetime NOT NULL,
  `data_pagamento` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_parcela_compra_forma_pagamento_compra_id_idx` (`forma_pagamento_compra_id`),
  CONSTRAINT `fk_parcela_compra_forma_pagamento_compra_id` FOREIGN KEY (`forma_pagamento_compra_id`) REFERENCES `forma_pagamento_compra` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `parcela_venda`
--

DROP TABLE IF EXISTS `parcela_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parcela_venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forma_pagamento_venda_id` int(11) NOT NULL,
  `valor` decimal(19,2) NOT NULL,
  `estado` int(11) NOT NULL,
  `data_vencimento` datetime NOT NULL,
  `data_pagamento` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_parcela_forma_pagamento_pedido_idx` (`forma_pagamento_venda_id`),
  CONSTRAINT `fk_parcela_venda_forma_pagamento_venda_id` FOREIGN KEY (`forma_pagamento_venda_id`) REFERENCES `forma_pagamento_venda` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pedido_compra`
--

DROP TABLE IF EXISTS `pedido_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedido_compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime DEFAULT NULL,
  `hora` datetime DEFAULT NULL,
  `fornecedor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_compra_fornecedor_idx` (`fornecedor_id`),
  CONSTRAINT `fk_pedido_compra_fornecedor` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pedido_compra_item`
--

DROP TABLE IF EXISTS `pedido_compra_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedido_compra_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` decimal(19,4) NOT NULL,
  `preco` decimal(19,4) NOT NULL,
  `desconto` decimal(19,4) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `pedido_compra_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_compra_item_produto_idx` (`produto_id`),
  KEY `fk_pedido_compra_item_pedido_compra_idx` (`pedido_compra_id`),
  CONSTRAINT `fk_pedido_compra_item_pedido_compra` FOREIGN KEY (`pedido_compra_id`) REFERENCES `pedido_compra` (`id`),
  CONSTRAINT `fk_pedido_compra_item_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pedido_venda`
--

DROP TABLE IF EXISTS `pedido_venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedido_venda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `hora` datetime DEFAULT NULL,
  `cliente_id` int(11) NOT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_venda_cliente_idx` (`cliente_id`),
  KEY `fk_pedido_venda_funcionario_idx` (`funcionario_id`),
  CONSTRAINT `fk_pedido_venda_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_pedido_venda_funcionario` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pedido_venda_item`
--

DROP TABLE IF EXISTS `pedido_venda_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pedido_venda_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidade` decimal(19,2) NOT NULL,
  `preco` decimal(19,2) NOT NULL,
  `desconto` decimal(19,2) NOT NULL,
  `produto_id` int(11) NOT NULL,
  `pedido_venda_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_venda_item_pedido_venda_idx` (`pedido_venda_id`),
  KEY `fk_pedido_venda_item_produto_idx` (`produto_id`),
  CONSTRAINT `fk_pedido_venda_item_pedido_venda` FOREIGN KEY (`pedido_venda_id`) REFERENCES `pedido_venda` (`id`),
  CONSTRAINT `fk_pedido_venda_item_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `pessoa_endereco`
--

DROP TABLE IF EXISTS `pessoa_endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pessoa_endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pessoa_id` int(11) NOT NULL,
  `endereco_id` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `preco`
--

DROP TABLE IF EXISTS `preco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `preco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_id` int(11) NOT NULL,
  `tipo` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `valor` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_preco_produto_idx` (`produto_id`),
  CONSTRAINT `fk_preco_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `data_cadastro` datetime DEFAULT NULL,
  `preco_compra` decimal(19,2) DEFAULT NULL,
  `ativo` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produto_estoque`
--

DROP TABLE IF EXISTS `produto_estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `produto_estoque` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_id` int(11) NOT NULL,
  `estoque_id` int(11) NOT NULL,
  `quantidade` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produto_estoque_produto_idx` (`produto_id`),
  KEY `fk_produto_estoque_estoque_idx` (`estoque_id`),
  CONSTRAINT `fk_produto_estoque_estoque` FOREIGN KEY (`estoque_id`) REFERENCES `estoque` (`id`),
  CONSTRAINT `fk_produto_estoque_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `produto_subgrupo`
--

DROP TABLE IF EXISTS `produto_subgrupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `produto_subgrupo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produto_id` int(11) NOT NULL,
  `subgrupo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produto_subgrupo_produto_idx` (`produto_id`),
  KEY `produto_subgrupo_subgrupo_idx` (`subgrupo_id`),
  CONSTRAINT `fk_produto_subgrupo_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`),
  CONSTRAINT `produto_subgrupo_subgrupo` FOREIGN KEY (`subgrupo_id`) REFERENCES `subgrupo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `subgrupo`
--

DROP TABLE IF EXISTS `subgrupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subgrupo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `grupo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_subgrupo_grupo_idx` (`grupo_id`),
  CONSTRAINT `fk_subgrupo_grupo` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `telefone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cliente_id` int(11) DEFAULT NULL,
  `fornecedor_id` int(11) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  `numero` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_telefone_cliente_idx` (`cliente_id`),
  KEY `fk_telefone_fornecedor_idx` (`fornecedor_id`),
  KEY `fk_telefone_funcionario_idx` (`funcionario_id`),
  CONSTRAINT `fk_telefone_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_telefone_fornecedor` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id`),
  CONSTRAINT `fk_telefone_funcionario` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-12 23:55:40
