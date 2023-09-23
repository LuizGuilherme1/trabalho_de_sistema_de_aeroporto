import Entities.Check_in;
import Entities.Pendente;
import Entities.Usuario;
import Entities.Voo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
         //file
         /* need to fix
         String path ="C:\\voos.txt";
         try (BufferedReader br = new BufferedReader(new FileReader(path))) {
	     String line = br.readLine();
	     while (line != null) {
	     	 String[] fields = line.split("|");
                 int id = Integer.parseInt(fields[0]);
	     	 String origen = fields[1];
                 String destino = fields[2];
                 LocalDateTime partida = LocalDateTime.parse(fields[3],f1);
                 LocalDateTime chegada = LocalDateTime.parse(fields[4], f1);
	     	 int maxpa = Integer.parseInt(fields[5]);
                 voos.add(new Voo(id, origen, destino, partida, chegada, maxpa));
	     }
	 } catch (IOException e) {
	 	System.out.println("Error: " + e.getMessage());
	 }
         */
         //file end
         int num=1000;
         String origen ="Brazil";
         String destino ="Usa";
         LocalDateTime partida = LocalDateTime.parse("20/12/2023 12:00", f1);
         LocalDateTime chegada = LocalDateTime.parse("02/01/2024 02:12", f1);
         int max=12;
         voos.add(new Voo(num, origen, destino, partida, chegada, max));
         num=2001;
         origen="Usa";
         destino="Japão";
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
                 System.out.println("deseja fazer uma reserva(y/n)");
                 char choice=s.next().charAt(0);
                 if(choice=='y'){
                 do{
                     System.out.print("escreva o numero do voo: ");
                     int id=s.nextInt();
                     for(Voo v:voos){
                         if(id==v.getNum_voo()&&!v.testCheio(checkin)){
                             System.out.print("escreva o seu nome: ");
                             s.nextLine();
                             String nome=s.nextLine();
                             System.out.print("escreva o sua idade: ");
                             int idade=s.nextInt();
                             System.out.print("escreva o seu cpf: ");
                             String cpf=s.next();
                             System.out.print("escreva o seu e-mail: ");
                             String email=s.nextLine();
                             Pendente pend =new Pendente(new Usuario(nome, cpf, email, idade), id);
                             pen.add(pend);
                             System.out.println("gostaria de fazer outra reserva(y/n)");
                             choice=s.next().charAt(0);
                          }else if(id==v.getNum_voo()&&!v.testCheio(checkin)){
                             System.out.println("este voo esta cheio");
                             System.out.println("gostaria de fazer outra reserva(y/n)");
                             choice=s.next().charAt(0);
                         }else{
                             System.out.println("este voo nâo existe.");
                             System.out.println("gostaria de fazer outra reserva(y/n)");
                             choice=s.next().charAt(0);
                             }
                     }
                      }while(choice!='n');
              }else if(choice=='n'){
                     System.out.println("escreva 1 para fazer uma reserva.");
                     System.out.println("escreva 2 para fazer um check-in de uma reserva.");
                     System.out.println("escreva 3 para ver os voos disponiveis,pendentes e cheios");
                     System.out.println("ecreva 4 para sair");
                     i=s.nextInt();
              }else{
                     System.out.println("não e uma opção(y/n)");
                     choice = s.next().charAt(0);
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
                 List<Pendente>a=new ArrayList<>();
                 for(Pendente p:pen){
                     if(p.getId()==id&&p.estaCheio(checkin, voos)==true){
                           p.showListPend(voos);
                           System.out.println("-----------------------");
                           a.add(p);
                       }else{
                         System.out.println("perdão este voo esta cheio ou não existe");
                         System.out.println("escreva 1 para fazer uma reserva.");
                         System.out.println("escreva 2 para fazer um check-in de uma reserva.");
                         System.out.println("escreva 3 para ver os voos disponiveis,pendentes e cheios");
                         System.out.println("ecreva 4 para sair");
                         i=s.nextInt();
                     }
                 }
                 System.out.println("escolha o cpf");
                 String cpf=s.next();
                 for(Pendente p:a){
                     if(p.getCpf()==cpf){
                         checkin.add(new Check_in(id, cpf));
                         pen.remove(p);
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
                       }else{
                           System.out.print("");
                       }
                   }
                   System.out.println("lista de voos reservados: ");
                   for(Pendente p:pen){
                       if(p!=null){
                           p.showListPend(voos);
                           System.out.println("-----------------------");
                       }else{
                           System.out.print("");
                       }
                   }
                   System.out.println("lista de voos cheios: ");
                   for(Voo v:voos){
                       if(v.testCheio(checkin)){
                           v.showListCheio(checkin);
                           System.out.println("-----------------------");
                       }
                   }
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