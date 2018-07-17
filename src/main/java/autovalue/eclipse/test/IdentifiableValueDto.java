package autovalue.eclipse.test;

import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.auto.value.AutoValue;

import io.swagger.annotations.ApiModelProperty;

@AutoValue
@JsonDeserialize(builder = AutoValue_IdentifiableValueDto.Builder.class)
public abstract class IdentifiableValueDto implements IdentifiableValue {

	@ApiModelProperty(value = "value id")
	@Nullable
	public abstract String getId();

	@AutoValue.CopyAnnotations(exclude = NotBlank.class)
	@ApiModelProperty(value = "value", required = true)
	@Nullable
	@NotBlank
	public abstract String getValue();

	public static Builder builder() {
		return new AutoValue_IdentifiableValueDto.Builder();
	}

	@AutoValue.Builder
	@JsonPOJOBuilder(withPrefix = "set")
	public abstract static class Builder {
		public abstract Builder setId(String value);

		public abstract Builder setValue(String value);

		public abstract IdentifiableValueDto build();
	}

}
