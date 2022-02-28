package com.example.serviYa.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

@Repository
public class FileFunctions {

    @Autowired
    private Environment env;

    public void setPermissions(String filePath) throws IOException {
        if (env.getRequiredProperty("ENVIRONMENT").equals("LINUX")) {
            File file = new File(filePath);

            Set<PosixFilePermission> perms = new HashSet<>();
            perms.add(PosixFilePermission.OWNER_READ);
            perms.add(PosixFilePermission.OWNER_WRITE);
            perms.add(PosixFilePermission.OWNER_EXECUTE);
            perms.add(PosixFilePermission.GROUP_READ);
            perms.add(PosixFilePermission.GROUP_WRITE);
            perms.add(PosixFilePermission.GROUP_EXECUTE);

            Files.setPosixFilePermissions(file.toPath(), perms);
        }
    }
}
