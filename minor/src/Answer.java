
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.lang.Math;

import  java.io.*;
import  java.io.FileReader;


public class Answer {
    boolean found;
    private String basicquestion;
    String question;

    HashMap<String,String> allAnswer=new HashMap<>();
    HashMap<List<String>,List<String>>  smartAnswer=new      HashMap<>();
    Answer()
      {
          createbot();
      }
      private void createbot() {

          try {
              BufferedReader br = new BufferedReader(new FileReader("D:\\java_coding_space\\minor\\file.txt"));
              String pair ;

              while ((pair = br.readLine()) != null) {
                  String[] keyval = pair.split("\t", 2);
                  allAnswer.put(keyval[0], keyval[1]);
              }

                }
                catch(IOException e)
                {
                    System.out.println(e);
                }
                try{
                    BufferedReader  smartbuffer = new BufferedReader(new FileReader("D:\\java_coding_space\\minor\\advance.txt"));
                     String line="";

                     while((line=smartbuffer.readLine())!=null)
                     {
                         String [] keyvalue=line.split("\t",2);

                        String[] key=keyvalue[0].split(",");
                        try {
                            String[] value = keyvalue[1].split(",");

                            smartAnswer.put(Arrays.asList(key), Arrays.asList(value));
                        }

                catch(ArrayIndexOutOfBoundsException e)
                         {
                             System.out.println(" smart  file not correct");
                         }

                     }

                }catch(IOException e)
          {
                 System.out.println("  error while fetching smart file  : " +e);
          }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(" smart  file not correct");
                }
      }




   public String getAnswer(String question)
   {
       found=false;
       this.question=question;
       basicquestion=basic(question);
       if(basicquestion=="help") {
           return help();
       }






       for(String key: allAnswer.keySet()) {
           String bkey = basic(key);

           if (bkey.equalsIgnoreCase(basicquestion)) {
               found = true;
               return allAnswer.get(key);
           }
       }

       if(!found)
       {
           for(List <String >keys :smartAnswer.keySet())
           {
               for(String eachkey :keys )
               {      String beachkey=basic(eachkey);
                    if(beachkey.equalsIgnoreCase(basicquestion))
                    {

                        found=true;
                        List<String>values=smartAnswer.get(keys);
                        int  length=values.size();

                        int rand=(int)Math.floor(Math.random()*length);

                       return  values.get(rand);
                    }
               }
           }

       }
       //to do (main reply getter from file)
       return "we don't have answer to this";
   }

    static public String basic(String val)
    {

        return  val.replaceAll("[^\\w]","");
    }

    public String  help()
    {
        String helpval="   ";
        return  helpval;
    }


}
