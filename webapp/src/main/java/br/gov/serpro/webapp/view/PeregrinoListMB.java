package br.gov.serpro.webapp.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.gov.serpro.webapp.business.PeregrinoBC;
import br.gov.serpro.webapp.domain.Peregrino;

@ViewController
@NextView("./peregrino_edit.xhtml")
@PreviousView("./peregrino_list.xhtml")
public class PeregrinoListMB extends AbstractListPageBean<Peregrino, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PeregrinoBC bc;

	@Override
	protected List<Peregrino> handleResultList() {
		return this.bc.findAll();
	}

	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);

			if (delete) {
				bc.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}
