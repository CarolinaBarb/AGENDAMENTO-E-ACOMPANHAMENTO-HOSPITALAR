package model;

public class Contato {
    private String telefone;
    private String email;
    private String mensagens;

    public Contato(String telefone, String email, String mensagens) {
        this.telefone = telefone;
        this.email = email;
        this.mensagens = mensagens;
    }

    // getters and setters

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagens() {
        return mensagens;
    }

    public void setMensagens(String mensagens) {
        this.mensagens = mensagens;
    }

    //funcoes


}

