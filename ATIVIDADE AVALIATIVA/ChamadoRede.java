public class ChamadoRede extends Chamado {
    private String ipAfetado;

    public ChamadoRede(int id, String descricao, String ipAfetado) {
        super(id, descricao);
        this.ipAfetado = ipAfetado;
    }

    public String getIpAfetado() { return ipAfetado; }

    // Sobrecarga: Retorna a String do diagnóstico
    public String resolver(String diagnostico) {
        super.resolver(); // Muda o status na classe pai
        return "Chamado de Rede #" + getId() + " resolvido. Diagnóstico: " + diagnostico;
    }

    // Sobrescrita: Adiciona o IP ao texto da classe pai
    @Override
    public String obterDetalhes() {
        return super.obterDetalhes() + " | IP Afetado: " + this.ipAfetado;
    }
}