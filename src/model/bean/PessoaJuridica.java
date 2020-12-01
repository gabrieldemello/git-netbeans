package model.bean;
/**
 *
 * @author Gabriel Carneiro
 */
public class PessoaJuridica extends Pessoa {
    
    private Integer idPessoaJuridica;
    private String RazaoSocial;
    private String CNPJ;
    private Integer Pessoa_idPessoa;

    public Integer getIdPessoaJuridica() {
        return idPessoaJuridica;
    }

    public void setIdPessoaJuridica(Integer idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public Integer getPessoa_idPessoa() {
        return Pessoa_idPessoa;
    }

    public void setPessoa_idPessoa(Integer Pessoa_idPessoa) {
        this.Pessoa_idPessoa = Pessoa_idPessoa;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "idPessoaJuridica=" + idPessoaJuridica + ", RazaoSocial=" + RazaoSocial + ", CNPJ=" + CNPJ + ", Pessoa_idPessoa=" + Pessoa_idPessoa + '}';
    }
    
    
    
}
