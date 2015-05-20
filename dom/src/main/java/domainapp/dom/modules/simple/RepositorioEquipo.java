/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package domainapp.dom.modules.simple;


import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.ActionLayout;
import org.apache.isis.applib.annotation.BookmarkPolicy;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.DomainServiceLayout;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.SemanticsOf;

@DomainService(repositoryFor = Equipo.class)
@DomainServiceLayout(menuOrder = "10")
public class RepositorioEquipo {

    //region > create (action)
    @MemberOrder(sequence = "1")
    public Equipo create(
        final 	@ParameterLayout(named="Nombre") String name,
        		@ParameterLayout(named="Imei") String imei,
        		@ParameterLayout(named="Telefono") String telefono) {
        final Equipo equipo = container.newTransientInstance(Equipo.class);
        equipo.setName(name);
        equipo.setImei(imei);
        equipo.setTelefono(telefono);
        container.persistIfNotAlready(equipo);
        return equipo;
    }

    //endregion

  //region > listAll (action)
    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "2")
    public List<Equipo> listAll() {
        return container.allInstances(Equipo.class);
    }
    //endregion
    
    //region > injected services

    @javax.inject.Inject 
    DomainObjectContainer container;

    //endregion
}
