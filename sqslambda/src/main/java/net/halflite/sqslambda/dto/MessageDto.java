package net.halflite.sqslambda.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageDto {
  private final Long id;
  private final String statusType;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public MessageDto(
      @JsonProperty("id")Long id, 
      @JsonProperty("status_type")String statusType) {
    this.id = id;
    this.statusType = statusType;
  }

  public Long getId() {
    return id;
  }

  public String getStatusType() {
    return statusType;
  }

  @Override
  public String toString() {
    return String.format("%s[id=%d, statusType=%s]", this.getClass().getSimpleName(), this.id, this.statusType);
  }
}
