package domainapp.dom.modules.simple;

import javax.jdo.annotations.IdentityType;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.i18n.TranslatableString;

@javax.jdo.annotations.PersistenceCapable(identityType=IdentityType.DATASTORE)
@DomainObjectLayout(
        bookmarking = BookmarkPolicy.AS_ROOT
)

public class Equipo implements Comparable<Equipo>{

	 //region > identificatiom
    public TranslatableString title() {
        return TranslatableString.tr("Object: {name}", "name", getName(),
        							"Object: {imei}", "imei", getImei(),
        							"Object: {telefono}", "telefono", getTelefono());
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

    //region > imei (property)

    private String imei;

    @javax.jdo.annotations.Column(allowsNull="false", length = 40)
    @Title(sequence="2")
    @Property(
            editing = Editing.ENABLED
    )
    public String getImei() {
        return imei;
    }

    public void setImei(final String imei) {
        this.imei = imei;
    }
    
    //region > Telefono (property)

    private String telefono;

    @javax.jdo.annotations.Column(allowsNull="false", length = 40)
    @Title(sequence="3")
    @Property(
            editing = Editing.ENABLED
    )
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(final String telefono) {
        this.telefono = imei;
    }
    
    
    //region > injected services

    @javax.inject.Inject
    @SuppressWarnings("unused")
    private DomainObjectContainer container;

	@Override
	public int compareTo(Equipo o) {
		// TODO Auto-generated method stub
		return 0;
	}

    //endregion    	
}
