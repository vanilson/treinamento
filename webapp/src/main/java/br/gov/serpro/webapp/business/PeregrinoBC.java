package br.gov.serpro.webapp.business;

import java.util.Calendar;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.gov.serpro.webapp.domain.Peregrino;
import br.gov.serpro.webapp.exception.PeregrinoException;
import br.gov.serpro.webapp.message.InfoMessages;
import br.gov.serpro.webapp.persistence.PeregrinoDAO;

@BusinessController
public class PeregrinoBC extends DelegateCrud<Peregrino, Long, PeregrinoDAO> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MessageContext messageContext;
	
	@Inject
	private ResourceBundle bundle;
	
	private void validate(Peregrino peregrino) {
		if (peregrino.getNome().equals("Wilson")) {
			throw new PeregrinoException(bundle.getString("erro.validar.nome.peregrino"));
		}
	}

	@Override
	public void insert(Peregrino peregrino) {
		this.validate(peregrino);
		peregrino.setDataInscricao(Calendar.getInstance().getTime().toString());
		super.insert(peregrino);
	    messageContext.add(InfoMessages.PEREGRINO_INSERT_OK, peregrino.getNome());
	}

	@Override
	public void update(Peregrino peregrino) {
		this.validate(peregrino);
	    super.update(peregrino);
	    messageContext.add(InfoMessages.PEREGRINO_UPDATE_OK, peregrino.getNome());
	}
	
	@Override
	public void delete(Long id) {
	    super.delete(id);
	    messageContext.add(InfoMessages.PEREGRINO_DELETE_OK, id);
	}	
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Peregrino("Zezinho", "(71) 9922-2790", "zezinho@gmail.com"));
			insert(new Peregrino("Huguinho", "(71) 2325-5252", "huguinho@gmail.com"));
			insert(new Peregrino("Luizinho", "(71) 3454-2345", "luizinho@gmail.com"));
			insert(new Peregrino("Mickey", "(71) 9990-0909", "mickey@gmail.com"));
			insert(new Peregrino("Pato Donald", "(81) 8876-4567", "donald@gmail.com"));
			insert(new Peregrino("Pateta", "(71) 7890-1234", "pateta@gmail.com"));
			insert(new Peregrino("Tio Patinhas", "(71) 4567-8989", "rico@gmail.com"));

		}
	}

}
