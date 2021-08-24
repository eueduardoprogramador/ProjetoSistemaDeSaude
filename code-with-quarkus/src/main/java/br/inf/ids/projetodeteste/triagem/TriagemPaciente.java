package br.inf.ids.projetodeteste.triagem;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "triapacie")
public class TriagemPaciente {

    @ApiModelProperty("idtriagem")
    @Id
    @OneToMany(fetch = FetchType.LAZY)
    @Column(name="id")
    private Long id;

    @ApiModelProperty("Peso")
    @Column(name = "peso")
    private Double peso;

    @ApiModelProperty("Altura")
    @Column(name = "altura")
    private Double altura;

    @ApiModelProperty("Pressão")
    @Column(name = "pressão")
    private Double pressao;

    @ApiModelProperty("Glicose")
    @Column(name = "glicose")
    private Long glicose;
}
