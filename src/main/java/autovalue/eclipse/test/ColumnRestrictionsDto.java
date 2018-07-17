package autovalue.eclipse.test;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.google.auto.value.AutoValue;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

@AutoValue
@JsonDeserialize(builder = AutoValue_ColumnRestrictionsDto.Builder.class)
public abstract class ColumnRestrictionsDto {

	@AutoValue.CopyAnnotations(exclude = Valid.class)
    @ApiParam(allowMultiple = true)
    @ApiModelProperty(value = "row values")
    @Nullable
    @Valid
    @NotNull
    @Size(min = 1)
    public abstract List<IdentifiableValueDto> getColumns();

    public static Builder builder() {
        return new AutoValue_ColumnRestrictionsDto.Builder();
    }

    @AutoValue.Builder
    @JsonPOJOBuilder(withPrefix = "set")
    public abstract static class Builder {
        public abstract Builder setColumns(List<IdentifiableValueDto> values);
        public abstract ColumnRestrictionsDto build();
    }

    @ApiModelProperty(hidden=true)
    @JsonIgnore
    public boolean isAnyRestrictionDefined() {
        return !Optional.ofNullable(getColumns())
                .map(List::isEmpty)
                .orElse(false);
    }
    
}
