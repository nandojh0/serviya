/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 *
 * @author daihan
 */
@Component
public class DocumentManager {

    @Autowired
    private Environment env;

    @Autowired
    private FileFunctions fileFunctions;

    public String getCurrentDate() {
        final Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public String getCurrentTime() {
        final Time currentTime = new Time(new Date().getTime());
        return currentTime.toString();
    }

    private String getDocumentName(int id) {
        String path;
        String name;

        if (env.getRequiredProperty("ENVIRONMENT").equals("LINUX")) {
            path = System.getProperty("catalina.base") + File.separator + "webapps"
                    + File.separator + "log_WebLinde" + File.separator;
        } else {
            path = System.getProperty("user.dir") + File.separator + "webapps"
                    + File.separator + "log_WebLinde" + File.separator;
        }

        File file = new File(path);

        if (!file.exists()) {
            file.mkdirs();
        }

        switch (id) {
            case 0:
                name = path + getCurrentDate() + "_Transactions.txt";
                break;
            case 1:
                name = path + getCurrentDate() + "_Exceptions.txt";
                break;
            default:
                name = path + getCurrentDate() + "_Transactions.txt";
                break;
        }

        return name;
    }

    public void write(final int id, final String message) {
        synchronized (this) {
            String fileName = getDocumentName(id);

            try ( FileWriter fileWriter = new FileWriter(fileName, true);  BufferedWriter bufferWriter = new BufferedWriter(fileWriter)) {
                bufferWriter.write(message);
                bufferWriter.newLine();
                fileFunctions.setPermissions(fileName);

            } catch (IOException ex) {
                Logger.getLogger(DocumentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
