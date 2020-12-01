package model.bean;

public class Pessoa {
    
    private int idPessoa;
    private int ativo;
    private PessoaFisica pf;
    private PessoaJuridica pj;

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public PessoaFisica getPf() {
        if (pf == null) {
            pf = new PessoaFisica();
        }
        return pf;
    }

    public void setPf(PessoaFisica pf) {
        this.pf = pf;
    }

    public PessoaJuridica getPj() {
        if (pj == null) {
            pj = new PessoaJuridica();
        }
        return pj;
    }

    public void setPj(PessoaJuridica pj) {
        this.pj = pj;
    }

    
}
