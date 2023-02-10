package model;

public class Encaminhamento {
	
	private String descricao;
	private String tipoDeExame;
	private String ProfissionalResponsavel;
	private String nomePaciente;
	private String EmailPaciente;
	private String motivo;
	private int idencaminhamento;
	
	
	public Encaminhamento(String descricao, String tipoDeExame, String profissionalResponsavel, String nomePaciente,
			String emailPaciente, String motivo, int idencaminhamento) {
		super();
		this.descricao = descricao;
		this.tipoDeExame = tipoDeExame;
		ProfissionalResponsavel = profissionalResponsavel;
		this.nomePaciente = nomePaciente;
		EmailPaciente = emailPaciente;
		this.motivo = motivo;
		this.idencaminhamento = idencaminhamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipoDeExame() {
		return tipoDeExame;
	}
	public void setTipoDeExame(String tipoDeExame) {
		this.tipoDeExame = tipoDeExame;
	}
	public String getProfissionalResponsavel() {
		return ProfissionalResponsavel;
	}
	public void setProfissionalResponsavel(String profissionalResponsavel) {
		ProfissionalResponsavel = profissionalResponsavel;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getEmailPaciente() {
		return EmailPaciente;
	}
	public void setEmailPaciente(String emailPaciente) {
		EmailPaciente = emailPaciente;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public int getIdencaminhamento() {
		return idencaminhamento;
	}
	public void setIdencaminhamento(int idencaminhamento) {
		this.idencaminhamento = idencaminhamento;
	}
	
	
	
	
}
