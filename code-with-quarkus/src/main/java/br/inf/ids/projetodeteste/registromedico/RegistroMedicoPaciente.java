package br.inf.ids.projetodeteste.registromedico;

import br.inf.ids.projetodeteste.RegistroPaciente;
import br.inf.ids.projetodeteste.consulta.ConsultaPaciente;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@ApiModel(value = "RegistroMedico", description = "Registro Medico")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "regismedpacie")
@SequenceGenerator(name = "seq_registro", sequenceName = "seq_registro", allocationSize = 1)
public class RegistroMedicoPaciente{

    @ApiModelProperty("ID do Registro")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_registro")
    @Column(name = "idregistro")
    private Long idregistro;

    //Chave Composta
    @ApiModelProperty("Numero da Consulta")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registros", referencedColumnName = "codigoconsul")
    private List<ConsultaPaciente> numeroconsulta;

    //Chave Composta
    @ApiModelProperty("Registro do Paciente")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "registroid", referencedColumnName = "registrogeral")
    private List<RegistroPaciente> registrogeralpaciente;
}
