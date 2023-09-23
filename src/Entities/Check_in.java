package Entities;


public class Check_in {
    private int id;
    private int cpf;

    public Check_in() {
    }

    public Check_in(int id, int cpf) {
        this.id = id;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public int getCpf() {
        return cpf;
    }
    
    
}
