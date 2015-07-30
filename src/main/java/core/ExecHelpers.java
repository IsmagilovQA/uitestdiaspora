package core;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ExecHelpers {

    public static String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }

    public static String executeSource(String... commands)  {
        StringBuffer output = new StringBuffer();

        Process p;
        try {
            //ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", ". env.sh; " + command);
            ProcessBuilder pb = new ProcessBuilder(commands);
            p = pb.start();
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }


}
