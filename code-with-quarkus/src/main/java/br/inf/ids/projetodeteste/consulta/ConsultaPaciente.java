package br.inf.ids.projetodeteste.consulta;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="consulpaci")
public class ConsultaPaciente {

   @ApiModelProperty("Consulta")
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Id
   @Column(name = "codigoconsul")
   private Long id;

   @ApiModelProperty("Exames")
   @NotNull
   @Column(name = "exames")
   @Size(max = 250)
   private String exames;

   @ApiModelProperty("Diagnosticos")
   @NotNull
   @Column(name = "diagnostico")
   @Size(max = 150)
   private String diaginostico;

   @ApiModelProperty("Medicamentos")
   @Column(name = "medicamentos")
   @Size(max = 80)
   private String medicamentos;
}
