package br.gov.serpro.webapp.message;

import br.gov.frameworkdemoiselle.message.DefaultMessage;
import br.gov.frameworkdemoiselle.message.Message;



public interface InfoMessages {

    final Message PEREGRINO_DELETE_OK = new DefaultMessage("{peregrino-delete-ok}");

    final Message PEREGRINO_INSERT_OK = new DefaultMessage("{peregrino-insert-ok}");

    final Message PEREGRINO_UPDATE_OK = new DefaultMessage("{peregrino-update-ok}");

}
