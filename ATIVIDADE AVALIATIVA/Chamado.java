public class Chamado {
    private int id;
    private String descricao;
    private boolean resolvido;

    public Chamado(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.resolvido = false;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public boolean isResolvido() { return resolvido; }

    // Retorna uma String em vez de usar System.out.println
    public String resolver() {
        this.resolvido = true;
        return "Chamado #" + this.id + " foi marcado como resolvido!";
    }

    // Retorna os detalhes formatados para a interface
    public String obterDetalhes() {
        String status = this.resolvido ? "Resolvido" : "Pendente";
        return "ID: " + this.id + " | Descrição: " + this.descricao + " | Status: " + status;
    }
}