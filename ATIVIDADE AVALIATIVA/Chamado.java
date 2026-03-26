public class Chamado {
    // O modificador 'static' faz com que essa variável seja compartilhada entre todos os chamados
    private static int contadorId = 1;

    private int id;
    private String descricao;
    private boolean resolvido;

    // Construtor não pede mais o ID
    public Chamado(String descricao) {
        this.id = contadorId++; // Atribui o valor atual e já soma +1 para o próximo
        this.descricao = descricao;
        this.resolvido = false;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public boolean isResolvido() { return resolvido; }

    public String resolver() {
        this.resolvido = true;
        return "Chamado #" + this.id + " foi marcado como resolvido!";
    }

    public String obterDetalhes() {
        String status = this.resolvido ? "[RESOLVIDO]" : "[PENDENTE]";
        return "🎫 CHAMADO #" + this.id + " " + status + "\n" +
                "   Descrição: " + this.descricao;
    }
}