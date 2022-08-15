package serasa.com.br.desafio.infra.dataprovider.database.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "PESSOA")
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PESSOA", nullable = false)
    private Long id;

	@Column(name = "DATAINCLUSAO")
	private LocalDateTime dataInclusao;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TELEFONE")
    private String telefone;

    @Column(name = "IDADE")
	private Integer idade;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "REGIAO")
    private String regiao;

    @Column(name = "SCORE")
    private Integer score;
}