package br.gov.serpro.webapp.view;

import java.util.Calendar;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.serpro.webapp.business.PeregrinoBC;
import br.gov.serpro.webapp.domain.Peregrino;

@ViewController
@PreviousView("./peregrino_list.xhtml")
public class PeregrinoEditMB extends AbstractEditPageBean<Peregrino, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PeregrinoBC peregrinoBC;

	@Override
	@Transactional
	public String delete() {
		this.peregrinoBC.delete(getId());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String insert() {
		this.peregrinoBC.insert(getBean());
		return getPreviousView();
	}

	@Override
	@Transactional
	public String update() {
		this.peregrinoBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected void handleLoad() {
		setBean(this.peregrinoBC.load(getId()));
	}

}
