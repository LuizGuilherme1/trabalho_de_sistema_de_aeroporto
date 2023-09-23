package Entities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class Voo {
    private int num_voo;
    private String origin;
    private String destino;
    private LocalDateTime hora_partida;
    private LocalDateTime hora_chegada;
    private int quantidade_passageiros;
    
    DateTimeFormatter f1=DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

    public Voo() {
    }

    public Voo(int num_voo, String origin, String destino, LocalDateTime hora_partida, LocalDateTime hora_chegada, int quantidade_passageiros) {
        this.num_voo = num_voo;
        this.origin = origin;
        this.destino = destino;
        this.hora_partida = hora_partida;
        this.hora_chegada = hora_chegada;
        this.quantidade_passageiros = quantidade_passageiros;
    }

    public int getNum_voo() {
        return num_voo;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDateTime getHora_partida() {
        return hora_partida;
    }

    public LocalDateTime getHora_chegada() {
        return hora_chegada;
    }

    public int getQuantidade_passageiros() {
        return quantidade_passageiros;
    }
    
    public void showListDisp(Stack<Check_in>checkin){
        int pessoas_abordo=0;
            for(Check_in p:checkin){
                if(p.getId()==num_voo){
                pessoas_abordo++;
                }
            }
            System.out.println("Numero: "+num_voo
                +"\n Origem: "+origin
                +"\n Destino: "+destino
                +"\n Horario de pardida: "+f1.format(hora_partida)+" Horario de chegada: "+f1.format(hora_chegada)
                +"\n Quantidade de passageiros: "+(quantidade_passageiros-pessoas_abordo));
    }
    
    public void showListCheio(Stack<Check_in>checkin){
        int pessoas_abordo=0;
          for(Check_in p:checkin){
              if(p.getId()==num_voo){
              pessoas_abordo++;
              }
          }
          if((quantidade_passageiros-pessoas_abordo)<=0){
          System.out.println("Numero: "+num_voo
              +"\n Origem: "+origin
              +"\n Destino: "+destino
              +"\n Horario de pardida: "+f1.format(hora_partida)+" Horario de chegada: "+f1.format(hora_chegada)
              +"\n Quantidade de passageiros: Cheio");
          }
    }
    public boolean testCheio(Stack<Check_in>checkin){
        int cheio;
        int pessoas_abordo=0;
        for(Check_in p:checkin){
            if(p.getId()==num_voo){
            pessoas_abordo++;
            }
        }
        cheio = quantidade_passageiros-pessoas_abordo;
            if(cheio==0){
                return true;
            }else{
                return false;
            }
    }

    @Override
    public String toString() {
        return "Numero: "+num_voo
                +"\n Origem: "+origin
                +"\n Destino: "+destino
                +"\n Horario de pardida: "+f1.format(hora_partida)+" Horario de chegada: "+f1.format(hora_chegada)
                +"\n Quantidade de passageiros: "+quantidade_passageiros;
    }
    
}