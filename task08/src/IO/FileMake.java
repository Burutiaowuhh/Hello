package IO;

import java.io.*;
import java.util.List;

public class FileMake {

<<<<<<< HEAD
    public void Iohandle(List list) throws IOException {
        File file = new File("account.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        if (!file.exists()) {
=======
    public void Iohandle(List list) throws IOException{
        File file=new File("account.txt");
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        if(!file.exists()){
>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
            file.createNewFile();
        }
//        Account account2= new CreditAccount("43456", "shi", "321201", "poi", 30, true) ;
        bw.write(String.valueOf(list));
        bw.flush();
        bw.close();
    }

    public void Ioreadhandle() throws IOException {
<<<<<<< HEAD
        File file = new File("D:\\IntelliJ IDEA 2017.2.6\\IntelliJ workspace\\task08\\account.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        String s = null;
        while ((s = br.readLine()) != null) {
=======
        File file=new File("D:\\IntelliJ IDEA 2017.2.6\\IntelliJ workspace\\task08\\account.txt");
        FileReader fileReader=new FileReader(file);
        BufferedReader br=new BufferedReader(fileReader);
        String s=null;
        while ((s=br.readLine())!=null){
>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
            System.out.println(s);

        }
        br.close();
    }


}
