import Entities.Check_in;
import Entities.Pendente;
import Entities.Usuario;
import Entities.Voo;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Program {
    public static void main(String[] args) throws ParseException{
         List<Voo>voos=new ArrayList<>();
         Queue<Pendente>pen=new LinkedList<>();
         Stack<Check_in>checkin=new Stack();
         DateTimeFormatter f1=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
         
         int num=1001;
         String origen ="Brazil";
         String destino ="Usa";
         LocalDateTime partida = LocalDateTime.parse("20/12/2023 12:00", f1);
         LocalDateTime chegada = LocalDateTime.parse("02/01/2024 02:12", f1);
         int max=12;
         voos.add(new Voo(num, origen, destino, partida, chegada, max));
         num=2001;
         origen="Usa";
         destino="Japao";
         partida=LocalDateTime.parse("20/12/2023 10:23", f1);
         chegada=LocalDateTime.parse("30/12/2023 11:11", f1);
         max=1;
         voos.add(new Voo(num, origen, destino, partida, chegada, max));
         
         Locale.setDefault(Locale.US);
         Scanner s=new Scanner(System.in);
         for(Voo e:voos){
             System.out.println(e.toString());
             System.out.println("-----------------------");
         }
         //inicio
         System.out.println("escreva 1 para fazer uma reserva.");
         System.out.println("escreva 2 para fazer um check-in de uma reserva.");
         System.out.println("escreva 3 para ver os voos disponiveis,pendentes e cheios");
         System.out.println("ecreva 4 para sair");
         int i=s.nextInt();
         do{
             if(i==1){
                 for(Voo v:voos){
                       if(!v.testCheio(checkin)){
                           v.showListDisp(checkin);
                           System.out.println("-----------------------");
                       }
                   }
                     System.out.print("escreva o numero do voo: ");
                     int id=s.nextInt();
                     boolean test = false;
                     for(Voo v:voos){
                         if(id==v.getNum_voo()&&!v.testCheio(checkin)){
                             System.out.print("escreva o seu nome: ");
                             s.nextLine();
                             String nome=s.nextLine();
                             System.out.print("escreva o sua idade: ");
                             int idade=s.nextInt();
                             System.out.print("escreva o seu cpf: ");
                             s.nextLine();
                             String cpf=s.nextLine();
                             System.out.print("escreva o seu e-mail: ");
                             String email=s.nextLine();
                             Pendente pend =new Pendente(new Usuario(nome, cpf, email, idade), id);
                             pen.add(pend);
                             System.out.println("-----------------------");
                             System.out.println("escreva 1 para fazer uma reserva.");
                             System.out.println("escreva 2 para fazer um check-in de uma reserva.");
                             System.out.println("escreva 3 para ver os voos disponiveis,pendentes e cheios");
                             System.out.println("ecreva 4 para sair");
                             i=s.nextInt();
                             test=true;
                          }
                     }if(test==false){
                     System.out.println("-----------------------");
                     System.out.println("este voo nâo exist ou ele esta cheio.");
                     System.out.println("escreva 1 para fazer uma reserva.");
                     System.out.println("escreva 2 para fazer um check-in de uma reserva.");
                     System.out.println("escreva 3 para ver os voos disponiveis,pendentes e cheios");
                     System.out.println("ecreva 4 para sair");
                     i=s.nextInt();
                     }else{
                         System.out.println("");
                     }
          }else if(i==2){
                 for(Pendente p:pen){
                     if(p!=null){
                           p.showListPend(voos);
                           System.out.println("-----------------------");
                       }
                 }
                 System.out.println("escolha o numero do voo");
                 int id=s.nextInt();
                 for(Pendente p:pen){
                     if(p.getId()==id&&!p.estaCheio(checkin, voos)){
                         p.showListPend(voos);
                         System.out.println("-----------------------");
                         System.out.println("quer fazer check-in (y/n)");
                         char choice = s.next().charAt(0);
                         if(choice=='y'){
                             checkin.add(new Check_in(id, p.getCpf()));
                             pen.remove(p);
                         }
                       }
                 }
                 System.out.println("escreva 1 para fazer uma reserva.");
                 System.out.println("escreva 2 para fazer um check-in de uma reserva.");
                 System.out.println("escreva 3 para ver os voos disponiveis,pendentes e cheios");
                 System.out.println("ecreva 4 para sair");
                 i=s.nextInt();
          }else if(i==3){
                 System.out.println("lista de voos disponiveis: ");
                 for(Voo v:voos){
                     if(!v.testCheio(checkin)){
                         v.showListDisp(checkin);
                         System.out.println("-----------------------");
                     }
                 }
                 System.out.println("lista de voos reservados: ");
                 for(Pendente p:pen){
                     if(p!=null){
                         p.showListPend(voos);
                         System.out.println("-----------------------");
                     }
                     }
                 System.out.println("lista de voos cheios: ");
                 for(Voo v:voos){
                     if(v.testCheio(checkin)){
                         v.showListCheio(checkin);
                         System.out.println("-----------------------");
                     }
                 }
                 System.out.println("escreva 1 para fazer uma reserva.");
                 System.out.println("escreva 2 para fazer um check-in de uma reserva.");
                 System.out.println("escreva 3 para ver os voos disponiveis,pendentes e cheios");
                 System.out.println("ecreva 4 para sair");
                 i=s.nextInt();
          }else if(i==4){
                 System.out.println("obrigado por testar");
          }else{
                 System.out.println("não e uma opição valida");
                 System.out.println("---------------------------");
                 System.out.println("escreva 1 para fazer uma reserva.");
                 System.out.println("escreva 2 para fazer um check-in de uma reserva.");
                 System.out.println("escreva 3 para ver os voos disponiveis,pendentes e cheios");
                 System.out.println("ecreva 4 para sair");
                 i=s.nextInt();
             }
    }while(i!=4);
   }
}