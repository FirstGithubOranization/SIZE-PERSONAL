package z.time;

import org.junit.Test;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * TITLE:
 *
 * @author ZhongHe.Zh
 * @time 2017-08-09 21:00
 **/
public class Timmer {

    FileInputStream fis;

    FileOutputStream fos;

    BufferedOutputStream buff = null;

    FileWriter fw = null;

    BufferedReader reader = null;

    private String dafaultTime;

    public static void main(String[] args) {
        new Thread(() -> new Timmer().loops()).start();

    }

    public void loops() {
        while (true) {
            try {
                init();
                if (validTime())
                    fos.write("*".getBytes());
                Thread.sleep(60000);
                System.out.println("*");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 验证是否是有效的时间
     *
     * @return
     */
    private boolean validTime() {
        long timeMillis = System.currentTimeMillis();
        Date data = new Date(timeMillis);
        SimpleDateFormat minString = new SimpleDateFormat("mm");
        SimpleDateFormat hourString = new SimpleDateFormat("HH");
        int hour = Integer.parseInt(hourString + "");
        int min = Integer.parseInt(minString + "");
        if (hour == 12) {
            return false;
        }
        if (hour == 13 && (0 < min && min <= 30))
            return false;
        if (hour == 16 && (0 < min && min <= 30))
            return false;
        if (hour == 19 && (0 < min && min <= 30))
            return false;
        return true;
    }


    private void dealYestoday(int day){
        String yestodayString = getYestoday(day);
        float yestodayEfficientHour=count(yestodayString);

    }

    private void init() {
        try {
            File dir = new File(Timmer.class.getResource("").getFile() + "record");
            File readme = new File(Timmer.class.getResource("").getFile() + "README.txt");
            File today = new File(Timmer.class.getResource("").getFile() + "record/" + todayString());
            if (!dir.exists()) {
                System.out.println("init record dir...");
                dir.mkdir();
            }

            if (!today.exists()) {
                today.createNewFile();
                System.out.println("init today file...");
                /*结算昨天 算入README中*/

            }
            if (!readme.exists()) {

                readme.createNewFile();
                System.out.println("init readme file...");
            }
            if (fis == null) {
                fis = new FileInputStream(today);
                System.out.println("init inputStream...");
            }
            if (fos == null) {
                fos = new FileOutputStream(today);
                System.out.println("init outputStream...");

            }
            if (buff == null) {
                buff = new BufferedOutputStream(fos);
                System.out.println("init buffStream...");
            }

            if (fw == null) {
                fw = new FileWriter(today);
                System.out.println("init fileWrite...");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private BufferedReader getBufferedReader(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            return new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String todayString() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String d = df.format(date);
        return d;
    }

    private String getYestoday(int day) {
        long currentTime = System.currentTimeMillis() - day * 24 * 60 * 60 * 1000;
        Date date = new Date(currentTime);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String yestoday = df.format(date);
        return yestoday;
    }


    private float count(String dataString) {
        StringBuffer sb = new StringBuffer();
        try {

            String fileName = Timmer.class.getResource("").getFile() + "record/" + dataString;
            File file = new File(fileName);
            if(!file.exists()){
                dealYestoday(2);
            }
            String tempString = null;
            BufferedReader bfr = getBufferedReader(fileName);
            while ((tempString = bfr.readLine()) != null) {
                sb.append(tempString);
            }
            int minits = sb.length();
            return Float.parseFloat(String.valueOf(minits)) / Float.parseFloat(60 + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0f;
    }


    @Test
    public void test() {
        System.out.println(new Timmer().count("2017-08-09"));
//        System.out.println(new Timmer().validTime());
    }
}
