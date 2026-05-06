package com.df.lonis.lonisbackendapplication.chiffreaffaires;

/**
 * Projection JPQL pour agréger les chiffres d'affaires par terminal.
 */
public record TerminalAggregate(
		Long terminalId,
		Long chiffreAffaires,
		Long soldeTotal
) {}
