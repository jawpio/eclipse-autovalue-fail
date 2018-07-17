package autovalue.eclipse.test;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.auto.value.AutoValue;

import io.swagger.annotations.ApiModelProperty;

@AutoValue
@JsonDeserialize(builder = AutoValue_ColumnRestrictionDto.Builder.class)
public abstract class ColumnRestrictionDto {

	@AutoValue.CopyAnnotations(exclude = Valid.class)
	@ApiModelProperty(value = "some description")
	@Nullable
	@Valid
	@NotNull
	public abstract ColumnRestrictionsDto getColumn();

	public static Builder builder() {
		return new AutoValue_ColumnRestrictionDto.Builder();
	}

	@AutoValue.Builder
	@JsonPOJOBuilder(withPrefix = "set")
	public abstract static class Builder {

		public abstract Builder setColumn(ColumnRestrictionsDto value);

		public abstract ColumnRestrictionDto build();
	}
}
