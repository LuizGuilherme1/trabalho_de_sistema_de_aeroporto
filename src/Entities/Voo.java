package Entities;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Queue;
public class Voo {
    private int num_voo;
    private String origin;
    private String destino;
    private LocalDateTime hora_partida;
    private LocalDateTime hora_chegada;
    private int quantidade_passageiros;
    public int testCheio;
    
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
    
    public void showListDisp(Queue<Pendente>pen,List<Voo>voos){
        int pessoas_abordo=0;
        for(Voo v:voos){
            for(Pendente p:pen){
                if(p.getId()==num_voo){
                pessoas_abordo++;
                }
            }
            System.out.println("Numero: "+num_voo
                +"Origem: "+origin
                +"Destino: "+destino
                +"Horario de pardida: "+f1.format(hora_partida)+" Horario de chegada: "+f1.format(hora_chegada)
                +"Quantidade de passageiros: "+(testCheio=quantidade_passageiros-pessoas_abordo));
        }
    }
    
    public void showListCheio(Queue<Pendente>pen,List<Voo>voos){
        int pessoas_abordo=0;
        for(Voo v:voos){
            for(Pendente p:pen){
                if(p.getId()==num_voo){
                pessoas_abordo++;
                }
            }
            if((quantidade_passageiros-pessoas_abordo)<=0){
            System.out.println("Numero: "+num_voo
                +"Origem: "+origin
                +"Destino: "+destino
                +"Horario de pardida: "+f1.format(hora_partida)+" Horario de chegada: "+f1.format(hora_chegada)
                +"Quantidade de passageiros: Cheio");
            }
        }
    }

    @Override
    public String toString() {
        return "Numero: "+num_voo
                +"Origem: "+origin
                +"Destino: "+destino
                +"Horario de pardida: "+f1.format(hora_partida)+" Horario de chegada: "+f1.format(hora_chegada)
                +"Quantidade de passageiros: "+quantidade_passageiros;
    }
    
}