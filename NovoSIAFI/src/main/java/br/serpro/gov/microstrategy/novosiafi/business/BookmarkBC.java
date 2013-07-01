package br.serpro.gov.microstrategy.novosiafi.business;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;

import br.serpro.gov.microstrategy.novosiafi.domain.Bookmark;
import br.serpro.gov.microstrategy.novosiafi.persistence.BookmarkDAO;

@BusinessController
public class BookmarkBC extends DelegateCrud<Bookmark, Long, BookmarkDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Startup
	@Transactional
	public void load() {
		if (findAll().isEmpty()) {
			insert(new Bookmark("Relatorio 1", "http://localhost:8080/MicroStrategy/servlet/mstrWeb?Server=DOADO&Project=MicroStrategy+Tutorial&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&currentViewMedia=1&documentID=A1810A714790E8E902445D8D68655778"));
			insert(new Bookmark("Relatorio 2", "http://localhost:8080/MicroStrategy/servlet/mstrWeb?Server=DOADO&Project=MicroStrategy+Tutorial&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&currentViewMedia=1&documentID=66CA9BE44DD3725FE26449B795C5EDE6"));
			insert(new Bookmark("Relatorio 3", "http://localhost:8080/MicroStrategy/servlet/mstrWeb?Server=DOADO&Project=MicroStrategy+Tutorial&Port=0&evt=4001&src=mstrWeb.4001&reportID=125F9FB34CEB75E36192E7A7C784EE52&visMode=0&reportViewMode=1"));
			insert(new Bookmark("Relatorio 4", "http://localhost:8080/MicroStrategy/servlet/mstrWeb?Server=DOADO&Project=MicroStrategy+Tutorial&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&currentViewMedia=2&documentID=18D8D2824E43A33D039C698AB4975706"));
			insert(new Bookmark("Relatorio 5", "http://localhost:8080/MicroStrategy/servlet/mstrWeb?Server=DOADO&Project=MicroStrategy+Tutorial&Port=0&evt=2048001&src=mstrWeb.2048001&visMode=0&currentViewMedia=1&documentID=BAE6E1434B91F7C5465AB2BB1D4D78F5"));
		}
	}
	
}
