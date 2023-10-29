package scripts;

import tables.AdministradorDB;

public class InsereAdministrador {
    public InsereAdministrador(){
        AdministradorDB administradorInsert = new AdministradorDB();
        administradorInsert.InsereAdministrador("Carlos","6784651905","1005698779","Domingues Sacada","carlos@gmail.com");
    }
}
