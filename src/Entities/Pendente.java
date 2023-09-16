
package Entities;

import java.util.ArrayList;
import java.util.List;

public class Pendente {
    private Usuario user;
    private int id;

    public Pendente(Usuario user,int id) {
        this.user = user;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
