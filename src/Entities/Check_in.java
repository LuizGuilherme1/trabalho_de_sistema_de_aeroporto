package Entities;


public class Check_in {
    private int id;
    private String cpf;

    public Check_in() {
    }

    public Check_in(int id, String cpf) {
        this.id = id;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }
    
    
}
