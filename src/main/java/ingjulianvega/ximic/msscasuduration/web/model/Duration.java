package ingjulianvega.ximic.msscasuduration.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Duration implements Serializable {

    static final long serialVersionUID = 4563249978283821775L;

    private String name;

}
