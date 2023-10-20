package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    
    public String getCpf(){
        return user.getCpf();
    }
    
    public boolean estaCheio(Stack<Check_in>checkin,List<Voo>voos){
        for(Check_in c:checkin){
            for(Voo v:voos){
                if(c.getId()==v.getNum_voo()&& v.testCheio(checkin)==true){
                 return true;
                 }
            }
        }
        return false;
    }
    
    public void showListPend(List<Voo>voos){
        for(Voo v:voos){
            if(id==v.getNum_voo()){
              System.out.println("Numero: "+v.getNum_voo()
              +"\n Origem: "+v.getOrigin()
              +"\n Destino: "+v.getDestino()
              +"\n Horario de pardida: "+v.f1.format(v.getHora_partida())
              +" Horario de chegada: "+v.f1.format(v.getHora_chegada())
              +"\n cpf:"+user.getCpf());
            }
        }
    }
    
}
