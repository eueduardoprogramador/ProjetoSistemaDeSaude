package br.inf.ids.projetodeteste.fichaatendimento;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ApiModel(value = "FichaAtendimento", description = "Ficha de Atendimento")
@Table(name="fichapaci")
public class FichaAtendimentoPaciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ApiModelProperty("Horario de Entrada")
    @Column(name="horarioentrada")
    private LocalDate horaentrada;

    @ApiModelProperty("Numero de Atendimento")
    @Column(name="numatendi")
    private Long numeratendi;
}
