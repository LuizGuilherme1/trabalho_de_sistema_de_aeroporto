import Entities.Pendente;
import Entities.Usuario;
import Entities.Voo;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Program {
    public static void main(String[] args) {
         List<Voo>voos=new ArrayList<>();
         Queue<Pendente>pen=new LinkedList<>();
         
         Locale.setDefault(Locale.US);
         Scanner s=new Scanner(System.in);
         for(Voo e:voos){
             System.out.println(e.toString());
             System.out.println("-----------------------");
         }
         System.out.println("deseja fazer uma reserva(y/n)");
         char choice=s.next().charAt(0);
         if(choice=='y'){
         do{
             System.out.print("escreva o numero do voo: ");
             int id=s.nextInt();
             for(Voo v:voos){
                 if(id==v.getNum_voo()&&!v.testCheio(pen)){
                     System.out.print("escreva o seu nome: ");
                     s.nextLine();
                     String nome=s.nextLine();
                     System.out.print("escreva o sua idade: ");
                     int idade=s.nextInt();
                     System.out.print("escreva o seu cpf: ");
                     String cpf=s.nextLine();
                     System.out.print("escreva o seu e-mail: ");
                     String email=s.nextLine();
                     Pendente pend =new Pendente(new Usuario(nome, cpf, email, idade), id);
                     pen.add(pend);
                     System.out.println("gostaria de fazer outra reserva(y/n)");
                     choice=s.next().charAt(0);
                  }else if(id==v.getNum_voo()&&!v.testCheio(pen)){
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
         }else{
             System.out.println("lista de voos disponiveis: ");
             for(Voo v:voos){
                 if(!v.testCheio(pen)){
                     v.showListDisp(pen);
                     System.out.println("-----------------------");
                 }
             }
             System.out.println("lista de voos reservados: ");
             for(Pendente p:pen){
                 p.showListPend(voos);
                 System.out.println("-----------------------");
             }
             System.out.println("lista de voos cheios: ");
             for(Voo v:voos){
                 if(v.testCheio(pen)){
                     v.showListCheio(pen);
                     System.out.println("-----------------------");
                 }
             }
         }
    }
}