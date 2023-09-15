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
         Queue<Usuario>usuario=new LinkedList<>();
         Locale.setDefault(Locale.US);
         Scanner s=new Scanner(System.in);
         for(Voo e:voos){
             System.out.println(e.toString());
             System.out.println();
         }
         System.out.println("deseja fazer uma reserva(y/n)");
         char choice=s.next().charAt(0);
         if(choice=='y'){
         do{
             System.out.print("escreva o seu nome: ");
             String nome=s.nextLine();
             System.out.print("escreva o sua idade: ");
             int idade=s.nextInt();
             System.out.print("escreva o seu cpf: ");
             s.nextLine();
             String cpf=s.nextLine();
             System.out.print("escreva o seu e-mail: ");
             String email=s.nextLine();
             Usuario user=new Usuario(nome, cpf, email, idade);
             usuario.add(user);
         }while(choice!='n');
         }
    }
}
