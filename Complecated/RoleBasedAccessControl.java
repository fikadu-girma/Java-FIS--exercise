package Complecated;

import java.util.*;

public class RoleBasedAccessControl {

    static Map<String, Set<String>> permissions = new HashMap<>();

    static {
        permissions.put("ADMIN", Set.of("READ", "WRITE", "DELETE"));
        permissions.put("USER", Set.of("READ"));
    }

    public static boolean hasPermission(String role, String action) {
        return permissions.getOrDefault(role, Set.of()).contains(action);
    }

    public static void main(String[] args) {
        System.out.println(hasPermission("ADMIN", "DELETE"));
        System.out.println(hasPermission("USER", "DELETE"));
    }
}

