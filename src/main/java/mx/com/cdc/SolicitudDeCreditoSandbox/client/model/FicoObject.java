package mx.com.cdc.SolicitudDeCreditoSandbox.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class FicoObject {
  @SerializedName("score")
  private Long score = null;
  @SerializedName("razones")
  private List<FicoRazonObject> razones = new ArrayList<FicoRazonObject>();

  public FicoObject score(Long score) {
    this.score = score;
    return this;
  }

  @ApiModelProperty(example = "740", required = true, value = "Valor de la calificación (SCORE) reportado. Los valores para FICO pueden ser 0 o dentro del intervalo 300 a 850.")
  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

  public FicoObject razones(List<FicoRazonObject> razones) {
    this.razones = razones;
    return this;
  }

  public FicoObject addRazonesItem(FicoRazonObject razonesItem) {
    this.razones.add(razonesItem);
    return this;
  }

  @ApiModelProperty(required = true, value = "Código de la razón por la que se genera el valor del score. Ver tabla Razones Score")
  public List<FicoRazonObject> getRazones() {
    return razones;
  }

  public void setRazones(List<FicoRazonObject> razones) {
    this.razones = razones;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FicoObject ficoObject = (FicoObject) o;
    return Objects.equals(this.score, ficoObject.score) &&
        Objects.equals(this.razones, ficoObject.razones);
  }

  @Override
  public int hashCode() {
    return Objects.hash(score, razones);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FicoObject {\n");

    sb.append("    score: ").append(toIndentedString(score)).append("\n");
    sb.append("    razones: ").append(toIndentedString(razones)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
