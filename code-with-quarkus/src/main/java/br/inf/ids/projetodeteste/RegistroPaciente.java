package br.inf.ids.projetodeteste;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder  // Produz APIs de construtor complexas para suas classes.
@Entity  //Objeto Relacional
@ApiModel(value = "Registro", description = "Registro Geral Paciente")
@Table(name="repacien")
public class RegistroPaciente implements Serializable {

    @ApiModelProperty("Registro Geral Paciente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "registrogeral")
    private Long id;

    @ApiModelProperty("Nome")
    @NotNull
    @Column(name = "nomepaciente")
    @Size(max = 70)
    private String nomepaciente;

    @ApiModelProperty("Data de Nascimento")
    @NotNull
    @Column(name = "datanascimento")
    private LocalDate datanascimento;

    @ApiModelProperty("CPF")
    @NotNull
    @Column(name = "cpf")
    private Long cpf;

    @ApiModelProperty("CEP")
    @Column(name = "cep")
    private Long cep;
}
