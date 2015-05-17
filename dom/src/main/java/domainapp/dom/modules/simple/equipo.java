package domainapp.dom.modules.simple;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.i18n.TranslatableString;

public class equipo {

	 //region > identificatiom
    public TranslatableString title() {
        return TranslatableString.tr("Object: {name}", "name", getName());
    }
    //endregion

    //region > name (property)

    private String name;

    @javax.jdo.annotations.Column(allowsNull="false", length = 40)
    @Title(sequence="1")
    @Property(
            editing = Editing.DISABLED
    )
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

    //endregion    	
}
