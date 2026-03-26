public class ChamadoRede extends Chamado {
    private String ipAfetado;
    private String diagnostico;

    // Construtor sem o ID
    public ChamadoRede(String descricao, String ipAfetado) {
        super(descricao); // Repassa apenas a descrição para a classe pai
        this.ipAfetado = ipAfetado;
        this.diagnostico = "Aguardando análise técnica...";
    }

    public String getIpAfetado() { return ipAfetado; }
    public String getDiagnostico() { return diagnostico; }

    public String resolver(String diagnostico) {
        super.resolver();
        this.diagnostico = diagnostico;
        return "Chamado de Rede #" + getId() + " resolvido com sucesso!";
    }

    @Override
    public String obterDetalhes() {
        return super.obterDetalhes() + "\n" +
                "   IP Afetado: " + this.ipAfetado + "\n" +
                "   Diagnóstico: " + this.diagnostico;
    }
}