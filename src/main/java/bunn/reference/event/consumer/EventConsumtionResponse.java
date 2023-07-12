package bunn.reference.event.consumer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventConsumtionResponse {

    @NotBlank
    private String eventId;

    @Size(min = 0, max = 1024)
    @Pattern(regexp = "[A-Za-z0-9\\.-_ ]*")
    private String message;

}
