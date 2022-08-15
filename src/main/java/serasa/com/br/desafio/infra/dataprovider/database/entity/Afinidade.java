package serasa.com.br.desafio.infra.dataprovider.database.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "AFINIDADE")
@AllArgsConstructor
@NoArgsConstructor
public class Afinidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_AFINIDADE", nullable = false)
    private Long id;

	@Column(name = "REGIAO")
	private String regiao;

	@ElementCollection
	@CollectionTable(name="AFINIDADE_ESTADO", joinColumns=@JoinColumn(name="AFINIDADE_ID"))
	@Column(name="ESTADO")
	private List<String> estados;

}

