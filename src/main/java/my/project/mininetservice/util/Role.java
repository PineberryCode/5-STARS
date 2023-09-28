package my.project.mininetservice.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public enum Role {
    ADMIN(Arrays.asList(Permission.READ_OVERVIEW));

    @Getter
    @Setter
    private List<Permission> permissions;
}
