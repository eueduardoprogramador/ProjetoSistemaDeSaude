package br.inf.ids.projetodeteste.recepcao;

import br.inf.ids.projetodeteste.RegistroPaciente;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ApiModel(value = "RecepcaoPaciente", description = "Recepcao Paciente")
@Table(name="Receppaci")
public class RecepcaoPaciente implements Serializable {

    @ApiModelProperty("Recepção Código")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "registrorecepcao")
    private Long id;

    @JoinColumn(name = "registrogeral")
    @ManyToOne(fetch = FetchType.LAZY)
    private RegistroPaciente paciente;

    @ApiModelProperty("Sintomas")
    @NotNull
    @Column(name = "sintomas")
    @Size(max = 200)
    private String sintomas;

    @ApiModelProperty("Alergias")
    @Column(name = "alergias")
    @Size(max = 80)
    private String alergia;

    @ApiModelProperty("Tempo de Sintomas")
    @Column(name = "temposintoma")
    @Size(max = 25)
    private String temposintoma;
}
