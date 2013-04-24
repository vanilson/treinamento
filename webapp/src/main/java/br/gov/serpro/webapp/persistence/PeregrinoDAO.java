package br.gov.serpro.webapp.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.gov.serpro.webapp.domain.Peregrino;

@PersistenceController
public class PeregrinoDAO extends JPACrud<Peregrino, Long> {
	
	private static final long serialVersionUID = 1L;
	
}
