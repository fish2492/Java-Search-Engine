
import java.util.ArrayList;
import java.io.File;
public class Test
{
    public static void main(String args[]) throws Exception
    {
           ArrayList s1R =FileSearch.search("DJ","m4a"); 
           for(int i =0;i<s1R.size();i++)
            System.out.println(s1R.get(i)); 
    }


}

public class FileSearch
{
    
    private static String mainDirectory = "/home/yohans/";
   
    
    public static ArrayList search(String key,String FileType) throws Exception 
    {
             
           ArrayList searchResultFiles = new ArrayList();
           LoadedFile userFiles = new LoadedFile(mainDirectory);


           ArrayList zfiles = userFiles.getAllFiles();
           ArrayList zfileNames = userFiles.getAllFileNames();

           ArrayList resultIndex = getIndexSearch(zfileNames, key,FileType);
           
           for(int i =0;i<resultIndex.size();i++)
           searchResultFiles.add(zfiles.get((int)resultIndex.get(i)));

    
        return searchResultFiles;
                
    }

        

    private static ArrayList getIndexSearch( ArrayList list,String key,String Filetype )
    {
         ArrayList resultIndexs = new ArrayList();
        
         for(int i =0 ;i<list.size(); i++)
            {
                String str = (String)list.get(i);
                if (str.indexOf(Filetype) !=-1)
                { 
                     if ( str.indexOf(key)  != -1 )
                    {
                         
                        resultIndexs.add(i);
    
                    }
             
               }
    
            }
        
        return resultIndexs;

    }    


}









public class LoadedFile 
{

    String uperPath;

    ArrayList allFileNames=new ArrayList();
    ArrayList allFiles = new ArrayList();


    public LoadedFile(String Path) throws Exception
    {
        uperPath = Path;
        
            
            ArrayList[] d = getAllFiles(uperPath );
            allFiles = d[0];
            allFileNames = d[1];
        
       
     }
   
    public ArrayList getAllFiles()
    {
        return allFiles;
    }

    public ArrayList getAllFileNames()
    {
        return allFileNames;
        
    }
    

 

    // this method loads every file in a given path
    // directories
    // it users recursion 
    private ArrayList[] getAllFiles(String path ) throws Exception
    {
        
         ArrayList allFiles = new ArrayList();
         ArrayList allFileNames = new ArrayList();
         rec(path,allFiles,allFileNames);
 
         ArrayList[]  d = new ArrayList[2];   
         d[0] = allFiles;
         d[1] = allFileNames;
         return d;
    }
    
    private void rec(String path,ArrayList allFiles,ArrayList allFileNames ) throws Exception
    {   
            File d = new File(path);
            
            File[]  fileList = d.listFiles();
            String[] fileNameList =  d.list();
            //add all the files to the all Files
             

            for(int i=0;i<fileList.length;i++)
                         allFiles.add(fileList[i]);
            
            // add all the files just names;
        
             for(int i=0;i<fileList.length;i++)
                         allFileNames.add(fileNameList[i]);
              
            for ( int i=0;i<fileList.length;i++)
            {  
             
                    
                   if(fileList[i].isDirectory())
                    {
                        try{
                            rec(fileList[i].getAbsolutePath(),allFiles,allFileNames);
                        }catch(NullPointerException e)
                            {    }
                    }
                
                
            }

     } 
    

}

