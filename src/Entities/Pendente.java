
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
    
    public void showListPend(List<Voo>voos){
        for(Voo v:voos){
            if(id==v.getNum_voo()){
              System.out.println("Numero: "+v.getNum_voo()
              +"Origem: "+v.getOrigin()
              +"Destino: "+v.getDestino()
              +"Horario de pardida: "+v.f1.format(v.getHora_partida())+" Horario de chegada: "+v.f1.format(v.getHora_chegada()));
            }
        }
    }
    
}
